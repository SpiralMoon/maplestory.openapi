using NUnit.Framework;
using MapleStory.OpenAPI.TMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.TMS.Character
{
    [TestFixture]
    public class TestGetCharacter
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_TMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "ab918948538b1b79046df133fff52092";

        [Test, Description("success: GetCharacter")]
        public async Task GetCharacter()
        {
            var nickname = "吳獨秀x";
            var response = await api.GetCharacter(nickname);
            Assert.That(response.OCID, Is.EqualTo(ocid));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetCharacter with invalid name throws OPENAPI00004")]
        public void GetCharacter_With_Invalid_Name_Throws_OPENAPI00004()
        {
            var invalidNickname = "invalid_nickname_123_";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacter(invalidNickname));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
