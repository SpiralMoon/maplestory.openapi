using NUnit.Framework;
using MapleStory.OpenAPI.TMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.TMS.Union
{
    [TestFixture]
    public class TestGetUnionRaider
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_TMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "ab918948538b1b79046df133fff52092";

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
            var date = new DateTime(2025, 10, 15, 0, 0, 0);
            var response = await api.GetUnionRaider(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetUnionRaider with invalid date")]
        public void GetUnionRaider_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 10, 14, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetUnionRaider(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-10-15."));
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
