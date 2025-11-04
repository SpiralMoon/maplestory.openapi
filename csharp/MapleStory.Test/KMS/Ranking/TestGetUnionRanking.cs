using MapleStory.OpenAPI.Common;
using MapleStory.OpenAPI.KMS;
using NUnit.Framework;

namespace MapleStory.Test.KMS.Ranking
{
    [TestFixture]
    public class TestGetUnionRanking
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetUnionRanking")]
        public async Task GetUnionRanking()
        {
            var response = await api.GetUnionRanking(worldName: null, ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetUnionRanking with paging")]
        public async Task GetUnionRanking_With_Paging()
        {
            var response = await api.GetUnionRanking(worldName: null, ocid: null, page: 2);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetUnionRanking with ocid")]
        public async Task GetUnionRanking_With_Ocid()
        {
            var response = await api.GetUnionRanking(worldName: null, ocid, page: null);
            Assert.That(response.Ranking.Count, Is.EqualTo(1));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetUnionRanking with world name")]
        public async Task GetUnionRanking_With_World_Name()
        {
            var response = await api.GetUnionRanking(worldName: "스카니아", ocid, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetUnionRanking with date")]
        public async Task GetUnionRanking_With_Date()
        {
            var date = new DateTime(2023, 12, 23, 0, 0, 0);
            var response = await api.GetUnionRanking(worldName: null, ocid: null, page: null, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetUnionRanking with invalid date")]
        public void GetUnionRanking_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2023, 12, 21, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetUnionRanking(worldName: null, ocid: null, page: null, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-22."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetUnionRanking with invalid ocid throws OPENAPI00003")]
        public void GetUnionRanking_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetUnionRanking(worldName: null, invalidOcid, page: null));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
