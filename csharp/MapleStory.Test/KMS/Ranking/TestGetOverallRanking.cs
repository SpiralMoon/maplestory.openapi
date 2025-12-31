using MapleStory.OpenAPI.Common;
using MapleStory.OpenAPI.KMS;
using NUnit.Framework;
using System.Security.Cryptography;

namespace MapleStory.Test.KMS.Ranking
{
    [TestFixture]
    public class TestGetOverallRanking
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetOverallRanking")]
        public async Task GetOverallRanking()
        {
            var response = await api.GetOverallRanking(worldName: null, worldType: null, characterClass: null, ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetOverallRanking with paging")]
        public async Task GetOverallRanking_With_Paging()
        {
            var response = await api.GetOverallRanking(worldName: null, worldType: null, characterClass: null, ocid: null, page: 2);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetOverallRanking with ocid")]
        public async Task GetOverallRanking_With_Ocid()
        {
            var response = await api.GetOverallRanking(worldName: null, worldType: null, characterClass: null, ocid, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetOverallRanking with specific job")]
        public async Task GetOverallRanking_With_Specific_Job()
        {
            var response = await api.GetOverallRanking(worldName: null, worldType: null, characterClass: "전사-히어로", ocid, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetOverallRanking with job group")]
        public async Task GetOverallRanking_With_Job_Group()
        {
            var response = await api.GetOverallRanking(worldName: null, worldType: null, characterClass: "전사-전체 전직", ocid, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetOverallRanking with world name")]
        public async Task GetOverallRanking_With_World_Name()
        {
            var response = await api.GetOverallRanking(worldName: "스카니아", worldType: null, characterClass: null, ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetOverallRanking with world type")]
        public async Task GetOverallRanking_With_World_Type()
        {
            var response = await api.GetOverallRanking(worldName: null, worldType: 0, characterClass: null, ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetOverallRanking with world and job")]
        public async Task GetOverallRanking_With_World_And_Job()
        {
            var response = await api.GetOverallRanking(worldName: "스카니아", worldType: null, characterClass: "아델-전체 전직", ocid: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetOverallRanking with date")]
        public async Task GetOverallRanking_With_Date()
        {
            var date = new DateTime(2025, 1, 1, 0, 0, 0);
            var response = await api.GetOverallRanking(worldName: null, worldType: 0, characterClass: null, ocid: null, page: null, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetOverallRanking with invalid date")]
        public void GetOverallRanking_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2023, 12, 21, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetOverallRanking(worldName: null, worldType: 0, characterClass: null, ocid: null, page: null, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-22."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetOverallRanking with invalid ocid throws OPENAPI00003")]
        public void GetOverallRanking_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetOverallRanking(worldName: null, worldType: 0, characterClass: null, invalidOcid, page: null));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
