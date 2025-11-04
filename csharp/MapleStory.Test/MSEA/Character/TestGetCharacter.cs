using NUnit.Framework;
using MapleStory.OpenAPI.MSEA;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.MSEA.Character
{
    [TestFixture]
    public class TestGetCharacter
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_MSEA"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "caee7cf6ec6cb067c33b899f2779f3d1";

        [Test, Description("success: GetCharacter")]
        public async Task GetCharacter()
        {
            var nickname = "Arid";
            var response = await api.GetCharacter(nickname);
            Assert.That(response.OCID, Is.EqualTo(ocid));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetCharacter with invalid name throw OPENAPI00004")]
        public void GetCharacter_With_Invalid_Name_Throw_OPENAPI00004()
        {
            var invalidNickname = "invalid_nickname_123_";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacter(invalidNickname));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
