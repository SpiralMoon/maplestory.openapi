using NUnit.Framework;
using MapleStory.OpenAPI.TMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.TMS.Character
{
    [TestFixture]
    public class TestGetCharacterSkill
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_TMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "ab918948538b1b79046df133fff52092";

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
            var date = new DateTime(2025, 10, 15, 0, 0, 0);
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
            var invalidDate = new DateTime(2025, 10, 14, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterSkill(ocid, skillGrade, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-10-15."));
            Console.WriteLine(e.Message);
        }
    }
}
