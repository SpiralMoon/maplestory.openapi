using MapleStory.OpenAPI.Dto;
using Newtonsoft.Json;
using System.Web;
using System.Text;

namespace MapleStory.OpenAPI
{
    /// <summary>
    /// MapleStory OpenAPI client.
    /// <para>This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a></para>
    /// </summary>
    public class MapleStoryAPI
    {
        private readonly string apiKey;

        private static readonly string BASE_URL = "https://open.api.nexon.com/";

        // in milliseconds
        private long timeOut { get; set; }

        public MapleStoryAPI (string apiKey)
        {
            this.apiKey = apiKey;
            this.timeOut = 5000;
        }


        /// <summary>
        /// 오늘 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        public Task<CubeHistoryResponseDTO> GetCubeResult(int count)
        {
            var utcNow = DateTimeOffset.UtcNow;
            var kstNow = utcNow.ToOffset(TimeSpan.FromHours(9));
            
            return GetCubeResult(count, kstNow.Year, kstNow.Month, kstNow.Day);
        }

        /// <summary>
        /// 지목한 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="year">조회 기준일 (KST) 연도</param>
        /// <param name="month">조회 기준일 (KST) 월</param>
        /// <param name="day">조회 기준일 (KST) 월의 날짜</param>
        public async Task<CubeHistoryResponseDTO> GetCubeResult(int count, int year, int month, int day)
        {
            if (year <= 2022 && month <= 11 && day < 25)
            {
                throw new ArgumentException("You can only retrieve data after 2022-11-25.");
            }

            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/history/cube";
                var uriBuilder = new UriBuilder($"{BASE_URL}{path}");

                var query = HttpUtility.ParseQueryString(uriBuilder.Query);
                query["count"] = count.ToString();
                query["date_kst"] = new DateTime(year, month, day).ToString("yyyyMMdd");

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
        /// 지목한 날짜의 큐브 사용 결과를 조회합니다.
        /// <para>큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="dateTimeOffset">조회 기준일 (KST)</param>
        public Task<CubeHistoryResponseDTO> GetCubeResult(int count, DateTimeOffset dateTimeOffset)
        {
            var kstDate = dateTimeOffset.ToOffset(TimeSpan.FromHours(9));

            return GetCubeResult(count, kstDate.Year, kstDate.Month, kstDate.Day);
        }

        /// <summary>
        /// 큐브 사용 결과를 조회합니다.
        /// <para>큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.</para>
        /// <para>큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.</para>
        /// <para>e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.</para>
        /// </summary>
        /// <param name="count">한번에 가져오려는 결과의 개수(최소 10, 최대 1000)</param>
        /// <param name="cursor">페이징 처리를 위한 cursor</param>
        public async Task<CubeHistoryResponseDTO> GetCubeResult(int count, string cursor)
        {
            using (var client = new HttpClient())
            {
                var path = "maplestory/v1/history/cube";
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
                    throw new MapleStoryAPIException(MapleStoryAPIErrorCode.OPENAPI00003, "Bad Request");
                }
            }
        }

        private void SetClient(HttpClient client)
        {
            client.Timeout = TimeSpan.FromMilliseconds(this.timeOut);
            client.DefaultRequestHeaders.Add("x-nxopen-api-key", this.apiKey);
        }

        private static MapleStoryAPIException ParseError(string body)
        {
            var error = JsonConvert.DeserializeObject<MapleStoryAPIErrorBody>(body);

            return new MapleStoryAPIException(error);
        }
    }
}