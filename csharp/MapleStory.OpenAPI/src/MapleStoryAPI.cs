using MapleStory.OpenAPI.Dto;
using Newtonsoft.Json;
using System.Web;
using System.Text;

namespace MapleStory.OpenAPI
{
    /// <summary>
    /// MapleStory OpenAPI client.
    /// <para>This is an implementation of <a href="https://developers.nexon.com/Maplestory/apiList">MapleStory API</a></para>
    /// </summary>
    public class MapleStoryAPI
    {
        private readonly string apiKey;

        private static readonly string BASE_URL = "https://public.api.nexon.com/";

        // in milliseconds
        private long timeOut { get; set; }

        public MapleStoryAPI (string apiKey)
        {
            this.apiKey = apiKey;
            this.timeOut = 5000;
        }

        /// <summary>
        /// 오늘 날짜의 확률형 아이템 큐브의 사용 결과를 조회합니다.
        /// <para>데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.</para>
        /// <para>데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10</param>
        public Task<CubeHistoryResponseDTO> GetCubeResult(int count)
        {
            var kstId = "Korea Standard Time";
            var kstTimeZone = TimeZoneInfo.FindSystemTimeZoneById(kstId);

            var utcNow = DateTime.UtcNow;
            var kstNow = TimeZoneInfo.ConvertTimeFromUtc(utcNow, kstTimeZone);

            return GetCubeResult(count, kstNow.Year, kstNow.Month, kstNow.Day);
        }

        /// <summary>
        /// 지목한 날짜의 확률형 아이템 큐브의 사용 결과를 조회합니다.
        /// <para>데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.</para>
        /// <para>데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10</param>
        /// <param name="year">조회할 연도</param>
        /// <param name="month">조회할 월</param>
        /// <param name="day">조회할 월의 날짜</param>
        /// <exception cref="ArgumentException"></exception>
        public async Task<CubeHistoryResponseDTO> GetCubeResult(int count, int year, int month, int day)
        {
            if (year <= 2022 && month <= 11 && day < 25)
            {
                throw new ArgumentException("You can only retrieve data after 2022-11-25.");
            }

            using (var client = new HttpClient())
            {
                var path = "openapi/maplestory/v1/cube-use-results";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["count"] = count.ToString();
                query["date"] = new DateTime(year, month, day).ToString("yyyy-MM-dd");

                uriBuilder.Query = query.ToString();

                this.SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CubeHistoryResponseDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 확률형 아이템 큐브의 사용 결과를 조회합니다.
        /// <para>데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.</para>
        /// <para>데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10</param>
        public async Task<CubeHistoryResponseDTO> GetCubeResult(int count, string cursor)
        {
            using (var client = new HttpClient())
            {
                var path = "openapi/maplestory/v1/cube-use-results";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["count"] = count.ToString();
                query["cursor"] = cursor;

                uriBuilder.Query = query.ToString();

                this.SetClient(client);

                var response = await client.GetAsync(uriBuilder.Uri);
                var body = await response.Content.ReadAsStringAsync();

                if (response.IsSuccessStatusCode)
                {
                    var result = JsonConvert.DeserializeObject<CubeHistoryResponseDTO>(body);

                    return result;
                }
                else
                {
                    throw ParseError(body);
                }
            }
        }

        /// <summary>
        /// 서버 점검 정보를 조회합니다.
        /// </summary>
        public async Task<InspectionInfoDTO> GetInspectionInfo()
        {
            using (var client = new HttpClient())
            {
                var baseUrl = "https://api.maplestory.nexon.com/";
                var path = "soap/maplestory.asmx";
                var uriBuilder = new UriBuilder($"{baseUrl}{path}");

                client.DefaultRequestHeaders.Add("SOAPAction", "https://api.maplestory.nexon.com/soap/GetInspectionInfo");
                client.Timeout = TimeSpan.FromMilliseconds(this.timeOut);

                var soapEnvelop =
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <GetInspectionInfo xmlns=\"https://api.maplestory.nexon.com/soap/\" />\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
                var body = new StringContent(soapEnvelop, Encoding.UTF8, "text/xml");

                var response = await client.PostAsync(uriBuilder.Uri, body);

                if (response.IsSuccessStatusCode)
                {
                    var responseBody = await response.Content.ReadAsStringAsync();

                    return new InspectionInfoDTO(responseBody);
                }
                else
                {
                    throw new MapleStoryAPIException(400, "Bad Request");
                }
            }
        }

        private void SetClient(HttpClient client)
        {
            client.Timeout = TimeSpan.FromMilliseconds(this.timeOut);

            try
            {
                client.DefaultRequestHeaders.Add("authorization", this.apiKey);
            }
            catch (FormatException)
            {
                throw new MapleStoryAPIException(401, "Unauthorized");
            }
        }

        private static MapleStoryAPIException ParseError(string body)
        {
            var error = JsonConvert.DeserializeObject<MapleStoryAPIErrorBody>(body);

            return new MapleStoryAPIException(error);
        }
    }
}