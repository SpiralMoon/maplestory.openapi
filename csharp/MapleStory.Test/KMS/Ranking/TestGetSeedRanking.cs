using MapleStory.OpenAPI.Common;
using MapleStory.OpenAPI.KMS;
using NUnit.Framework;
using System.Security.Cryptography;

namespace MapleStory.Test.KMS.Ranking
{
    [TestFixture]
    public class TestGetSeedRanking
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetTheSeedRanking")]
        public async Task GetTheSeedRanking()
        {
            var response = await api.GetTheSeedRanking(worldName: null, ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetTheSeedRanking with paging")]
        public async Task GetTheSeedRanking_With_Paging()
        {
            var response = await api.GetTheSeedRanking(worldName: null, ocid: null, page: 2);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetTheSeedRanking with ocid")]
        public async Task GetTheSeedRanking_With_Ocid()
        {
            var response = await api.GetTheSeedRanking(worldName: null, ocid, page: null);
            Assert.That(response.Ranking.Count, Is.GreaterThanOrEqualTo(0));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetTheSeedRanking with world name")]
        public async Task GetTheSeedRanking_With_World_Name()
        {
            var response = await api.GetTheSeedRanking(worldName: "스카니아", ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetTheSeedRanking with date")]
        public async Task GetTheSeedRanking_With_Date()
        {
            var date = new DateTime(2023, 12, 23, 0, 0, 0);
            var response = await api.GetTheSeedRanking(worldName: null, ocid: null, page: null, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetTheSeedRanking with invalid date")]
        public void GetTheSeedRanking_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2023, 12, 21, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetTheSeedRanking(worldName: null, ocid: null, page: null, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-22."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetTheSeedRanking with invalid ocid throws OPENAPI00003")]
        public void GetTheSeedRanking_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetTheSeedRanking(worldName: null, invalidOcid, page: null));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
