using NUnit.Framework;
using MapleStory.OpenAPI.TMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.TMS.Union
{
    [TestFixture]
    public class TestGetUnionChampion
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_TMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "ab918948538b1b79046df133fff52092";

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
            var date = new DateTime(2025, 12, 19, 0, 0, 0);
            var response = await api.GetUnionChampion(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetUnionChampion with invalid date")]
        public void GetUnionChampion_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 12, 17, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetUnionChampion(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-12-18."));
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
