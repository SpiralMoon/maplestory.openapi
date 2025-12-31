using MapleStory.OpenAPI.Common;
using MapleStory.OpenAPI.KMS;
using NUnit.Framework;

namespace MapleStory.Test.KMS.Ranking
{
    [TestFixture]
    public class TestGetAchievementRanking
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetAchievementRanking")]
        public async Task GetAchievementRanking()
        {
            var response = await api.GetAchievementRanking(ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetAchievementRanking with paging")]
        public async Task GetAchievementRanking_With_Paging()
        {
            var response = await api.GetAchievementRanking(ocid: null, page: 2);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetAchievementRanking with ocid")]
        public async Task GetAchievementRanking_With_Ocid()
        {
            var response = await api.GetAchievementRanking(ocid, page: null);
            Assert.That(response.Ranking.Count, Is.GreaterThanOrEqualTo(0));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetAchievementRanking with date")]
        public async Task GetAchievementRanking_With_Date()
        {
            var date = new DateTime(2025, 1, 1, 0, 0, 0);
            var response = await api.GetAchievementRanking(ocid: null, page: null, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetAchievementRanking with invalid date")]
        public void GetAchievementRanking_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2023, 12, 21, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetAchievementRanking(ocid: null, page: null, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-22."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetAchievementRanking with invalid ocid throws OPENAPI00003")]
        public void GetAchievementRanking_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetAchievementRanking(invalidOcid, page: null));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
