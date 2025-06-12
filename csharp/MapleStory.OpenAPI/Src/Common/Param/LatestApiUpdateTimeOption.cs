namespace MapleStory.OpenAPI.Common.Param
{
    /// <summary>
    /// API 서버의 데이터 갱신 시각과 조회 가능한 최근 날짜와 현재 날짜와의 차이
    /// </summary>
    public struct LatestApiUpdateTimeOption
    {
        public int Hour { get; set; }

        public int Minute { get; set; }

        public int? DateOffset { get; set; }
    }
}
