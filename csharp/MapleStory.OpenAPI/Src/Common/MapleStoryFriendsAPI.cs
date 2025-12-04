using MapleStory.OpenAPI.Common.Param;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using RestSharp;

namespace MapleStory.OpenAPI.Common
{
    /// <summary>
    /// MapleStory Friends API client.
    /// </summary>
    public abstract class MapleStoryFriendsAPI
    {
        private readonly string accessToken;

        private readonly RestClient client;

        protected static readonly string BASE_URL = "https://open.api.nexon.com/";

        // in milliseconds
        protected int timeOut { get; set; }

        protected string subUrl;

        protected int timezoneOffset;

        public MapleStoryFriendsAPI(string accessToken, string subUrl, int timezoneOffset)
        {
            this.accessToken = accessToken;
            this.timeOut = 5000;
            this.client = new RestClient(options: new RestClientOptions(BASE_URL));
            this.subUrl = subUrl;
            this.timezoneOffset = timezoneOffset;
        }

        protected async Task<ResponseBody?> Get<ResponseBody>(string path, Dictionary<string, string?>? query = null, bool checkEmpty = false) where ResponseBody : class
        {
            var request = new RestRequest(path);

            request.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            request.AddHeader("Authorization", $"Bearer {this.accessToken}");

            if (query != null)
            {
                foreach (var element in query)
                {
                    if (element.Value != null)
                    {
                        request.AddQueryParameter(element.Key, element.Value);
                    }
                }
            }

            var response = await this.client.ExecuteGetAsync(request);

            if (response.IsSuccessStatusCode)
            {
                if (checkEmpty)
                {
                    var jObject = JObject.Parse(response.Content!);

                    if (IsEmptyResponse(jObject))
                    {
                        return null;
                    }
                }

                return JsonConvert.DeserializeObject<ResponseBody>(response.Content!);
            }
            else
            {
                throw ParseError(response.Content!);
            }
        }

        protected async Task<RestResponse> Get(string path, Dictionary<string, string?>? query = null)
        {
            var request = new RestRequest(path);

            request.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            request.AddHeader("Authorization", $"Bearer {this.accessToken}");

            if (query != null)
            {
                foreach (var element in query)
                {
                    if (element.Value != null)
                    {
                        request.AddQueryParameter(element.Key, element.Value);
                    }
                }
            }

            var response = await this.client.ExecuteGetAsync(request);

            if (response.IsSuccessStatusCode)
            {
                return response;
            }
            else
            {
                throw ParseError(response.Content!);
            }
        }

        private static bool IsEmptyResponse(JObject jObject)
        {
            foreach (var property in jObject.Properties())
            {
                if (property.Name.ToLower() == "date")
                {
                    continue;
                }

                if (property.Value.Type == JTokenType.Null)
                {
                    continue;
                }

                if (property.Value.Type == JTokenType.Array)
                {
                    var array = (JArray)property.Value;
                    if (array.Count == 0)
                    {
                        continue;
                    }
                }

                return false;
            }
            return true;
        }

        protected static MapleStoryAPIException ParseError(string content)
        {
            var errorBody = JsonConvert.DeserializeObject<MapleStoryAPIErrorBody>(content);
            return new MapleStoryAPIException(errorBody!);
        }

        protected static DateTimeOffset MinDate(int year, int month, int day)
        {
            return new DateTimeOffset(year, month, day, 0, 0, 0, TimeSpan.FromMinutes(540));
        }

        protected DateTimeOffset GetProperDefaultDateTimeOffset(LatestApiUpdateTimeOption option)
        {
            var nowInTimezone = DateTimeOffset.Now.ToOffset(TimeSpan.FromMinutes(this.timezoneOffset));
            var updateTime = DateTimeOffset.Now.ToOffset(TimeSpan.FromMinutes(this.timezoneOffset))
                .AddHours(-(nowInTimezone.Hour))
                .AddMinutes(-(nowInTimezone.Minute))
                .AddHours(option.Hour)
                .AddMinutes(option.Minute);

            DateTimeOffset adjustedDateTime;

            if (nowInTimezone > updateTime)
            {
                adjustedDateTime = nowInTimezone;
            }
            else
            {
                adjustedDateTime = nowInTimezone.AddDays(-1);
            }

            return adjustedDateTime.AddDays(option.DateOffset != null ? -(int)option.DateOffset : 0);
        }

        protected string ToDateString(DateTimeOffset date, DateTimeOffset? minDate = null)
        {
            if (minDate != null && date < minDate)
            {
                throw new ArgumentException($"You can only retrieve data after {minDate.Value:yyyy-MM-dd}.");
            }

            return date.ToString("yyyy-MM-dd");
        }
    }
}
