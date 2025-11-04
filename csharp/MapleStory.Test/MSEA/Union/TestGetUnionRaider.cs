using NUnit.Framework;
using MapleStory.OpenAPI.MSEA;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.MSEA.Union
{
    [TestFixture]
    public class TestGetUnionRaider
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_MSEA"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "caee7cf6ec6cb067c33b899f2779f3d1";

        [Test, Description("success: GetUnionRaider")]
        public async Task GetUnionRaider()
        {
            var response = await api.GetUnionRaider(ocid);
            // nothing to assert because some characters may not have union raider
            Console.WriteLine(response?.ToJson());
        }

        [Test, Description("success: GetUnionRaider with date")]
        public async Task GetUnionRaider_With_Date()
        {
            var date = new DateTime(2025, 4, 20, 0, 0, 0);
            var response = await api.GetUnionRaider(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetUnionRaider with invalid date")]
        public void GetUnionRaider_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 4, 19, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetUnionRaider(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-04-20."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetUnionRaider with invalid ocid throws OPENAPI00003")]
        public void GetUnionRaider_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetUnionRaider(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
