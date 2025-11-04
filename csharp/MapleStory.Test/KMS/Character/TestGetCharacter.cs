using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Character
{
    [TestFixture]
    public class TestGetCharacter
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetCharacter")]
        public async Task GetCharacter()
        {
            var nickname = "아델";
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
