using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Guild
{
    [TestFixture]
    public class TestGetGuild
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ogid = "f5992063d46d6f8718e514fca5428960";

        [Test, Description("success: GetGuild")]
        public async Task GetGuild()
        {
            var guildName = "붕붕";
            var worldName = "크로아";
            var response = await api.GetGuild(guildName, worldName);
            Assert.IsNotNull(response);
            Assert.That(response.OGuildId, Is.EqualTo(ogid));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetGuild with invalid guild name")]
        public async Task GetGuild_With_Invalid_Guild_Name()
        {
            var guildName = "_InvalidGuild";
            var worldName = "크로아";
            var response = await api.GetGuild(guildName, worldName);
            Assert.IsNull(response);
        }

        [Test, Description("fail: GetGuild with invalid world name throws OPENAPI00004")]
        public void GetGuild_With_Invalid_World_Name_Throws_OPENAPI00004()
        {
            var guildName = "붕붕";
            var worldName = "_InvalidWorld";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetGuild(guildName, worldName));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
