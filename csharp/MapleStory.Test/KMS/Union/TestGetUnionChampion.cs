using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Union
{
    [TestFixture]
    public class TestGetUnionChampion
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetUnionChampion")]
        public async Task GetUnionChampion()
        {
            var response = await api.GetUnionChampion(ocid);
            // nothing to assert because some characters may not have union champion
            Console.WriteLine(response?.ToJson());
        }

        [Test, Description("success: GetUnionChampion with date")]
        public async Task GetUnionChampion_With_Date()
        {
            var date = new DateTime(2025, 2, 20, 0, 0, 0);
            var response = await api.GetUnionChampion(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetUnionChampion with invalid date")]
        public void GetUnionChampion_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 2, 19, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetUnionChampion(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-02-20."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetUnionChampion with invalid ocid throws OPENAPI00003")]
        public void GetUnionChampion_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetUnionChampion(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
