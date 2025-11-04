using NUnit.Framework;
using MapleStory.OpenAPI.MSEA;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.MSEA.Guild
{
    [TestFixture]
    public class TestGetGuildBasic
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_MSEA"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ogid = "0cfc7bab3040f40d3765b77d8050b7a8";

        [Test, Description("success: GetGuildBasic")]
        public async Task GetGuildBasic()
        {
            var response = await api.GetGuildBasic(ogid);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetGuildBasic with date")]
        public async Task GetGuildBasic_With_Date()
        {
            var date = new DateTime(2025, 4, 20, 0, 0, 0);
            var response = await api.GetGuildBasic(ogid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetGuildBasic with invalid ogid throws OPENAPI00003")]
        public void GetGuildBasic_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOgid = "invalid_ogid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetGuildBasic(invalidOgid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetGuildBasic with invalid date")]
        public void GetGuildBasic_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 4, 19, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetGuildBasic(ogid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-04-20."));
            Console.WriteLine(e.Message);
        }
    }
}
