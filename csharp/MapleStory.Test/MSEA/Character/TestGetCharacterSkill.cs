using NUnit.Framework;
using MapleStory.OpenAPI.MSEA;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.MSEA.Character
{
    [TestFixture]
    public class TestGetCharacterSkill
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_MSEA"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "caee7cf6ec6cb067c33b899f2779f3d1";

        [Test, Description("success: GetCharacterSkill")]
        public async Task GetCharacterSkill()
        {
            var skillGrade = "6";
            var response = await api.GetCharacterSkill(ocid, skillGrade);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterSkill with date")]
        public async Task GetCharacterSkill_With_Date()
        {
            var skillGrade = "6";
            var date = new DateTime(2025, 4, 20, 0, 0, 0);
            var response = await api.GetCharacterSkill(ocid, skillGrade, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetCharacterSkill with invalid ocid throws OPENAPI00003")]
        public void GetCharacterSkill_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var skillGrade = "6";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacterSkill(invalidOcid, skillGrade));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCharacterSkill with invalid date")]
        public void GetCharacterSkill_With_Invalid_Date()
        {
            var skillGrade = "6";
            var invalidDate = new DateTime(2025, 4, 19, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterSkill(ocid, skillGrade, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-04-20."));
            Console.WriteLine(e.Message);
        }
    }
}
