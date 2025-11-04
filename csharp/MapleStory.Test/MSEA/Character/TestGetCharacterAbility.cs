using NUnit.Framework;
using MapleStory.OpenAPI.MSEA;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.MSEA.Character
{
    [TestFixture]
    public class TestGetCharacterAbility
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_MSEA"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "caee7cf6ec6cb067c33b899f2779f3d1";

        [Test, Description("success: GetCharacterAbility")]
        public async Task GetCharacterAbility()
        {
            var response = await api.GetCharacterAbility(ocid);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterAbility with date")]
        public async Task GetCharacterAbility_With_Date()
        {
            var date = new DateTime(2025, 4, 20, 0, 0, 0);
            var response = await api.GetCharacterAbility(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetCharacterAbility with invalid ocid throws OPENAPI00003")]
        public void GetCharacterAbility_With_Invalid_Ocid_Throw_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacterAbility(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCharacterAbility with invalid date")]
        public void GetCharacterAbility_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 4, 19, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterAbility(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-04-20."));
            Console.WriteLine(e.Message);
        }
    }
}
