using MapleStory.OpenAPI.Common;
using MapleStory.OpenAPI.KMS;
using NUnit.Framework;

namespace MapleStory.Test.KMS.Ranking
{
    [TestFixture]
    public class TestGetDojangRanking
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetDojangRanking")]
        public async Task GetDojangRanking()
        {
            var response = await api.GetDojangRanking(worldName: null, difficulty: 0, characterClass: null, ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetDojangRanking with paging")]
        public async Task GetDojangRanking_With_Paging()
        {
            var response = await api.GetDojangRanking(worldName: null, difficulty: 1, characterClass: null, ocid: null, page: 2);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetDojangRanking with ocid")]
        public async Task GetDojangRanking_With_Ocid()
        {
            var response = await api.GetDojangRanking(worldName: null, difficulty: 1, characterClass: null, ocid, page: null);
            Assert.That(response.Ranking.Count, Is.GreaterThanOrEqualTo(0));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetDojangRanking with world name")]
        public async Task GetDojangRanking_With_World_Name()
        {
            var response = await api.GetDojangRanking(worldName: "스카니아", difficulty: 1, characterClass: null, ocid: null, page: null);
            Assert.That(response.Ranking.Count, Is.GreaterThanOrEqualTo(0));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetDojangRanking with specific job")]
        public async Task GetDojangRanking_With_Specific_Job()
        {
            var response = await api.GetDojangRanking(worldName: null, difficulty: 1, characterClass: "전사-히어로", ocid: null, page: null);
            Assert.That(response.Ranking.Count, Is.GreaterThanOrEqualTo(0));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetDojangRanking with date")]
        public async Task GetDojangRanking_With_Date()
        {
            var date = new DateTime(2023, 12, 23, 0, 0, 0);
            var response = await api.GetDojangRanking(worldName: null, difficulty: 1, characterClass: null, ocid: null, page: null, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetDojangRanking with invalid date")]
        public void GetDojangRanking_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2023, 12, 21, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetDojangRanking(worldName: null, difficulty: 1, characterClass: null, ocid: null, page: null, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-22."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetDojangRanking with invalid ocid throws OPENAPI00003")]
        public void GetDojangRanking_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetDojangRanking(worldName: null, difficulty: 1, characterClass: null, invalidOcid, page: null));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
