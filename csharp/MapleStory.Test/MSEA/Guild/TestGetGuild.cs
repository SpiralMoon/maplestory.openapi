using NUnit.Framework;
using MapleStory.OpenAPI.MSEA;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.MSEA.Guild
{
    [TestFixture]
    public class TestGetGuild
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_MSEA"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ogid = "0cfc7bab3040f40d3765b77d8050b7a8";

        [Test, Description("success: GetGuild")]
        public async Task GetGuild()
        {
            var guildName = "xEternity";
            var worldName = "Aquila";
            var response = await api.GetGuild(guildName, worldName);
            Assert.IsNotNull(response);
            Assert.That(response.OGuildId, Is.EqualTo(ogid));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetGuild with invalid guild name")]
        public async Task GetGuild_With_Invalid_Guild_Name()
        {
            var guildName = "_InvalidGuild";
            var worldName = "Aquila";
            var response = await api.GetGuild(guildName, worldName);
            Assert.IsNull(response);
        }

        [Test, Description("fail: GetGuild with invalid world name throws OPENAPI00004")]
        public void GetGuild_With_Invalid_World_Name_Throws_OPENAPI00004()
        {
            var guildName = "xEternity";
            var worldName = "_InvalidWorld";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetGuild(guildName, worldName));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
