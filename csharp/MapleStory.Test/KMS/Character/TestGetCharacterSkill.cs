using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Character
{
    [TestFixture]
    public class TestGetCharacterSkill
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

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
            var date = new DateTime(2023, 12, 22, 0, 0, 0);
            var response = await api.GetCharacterSkill(ocid, skillGrade, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterSkill with has no skill grade")]
        public async Task GetCharacterSkill_With_Has_No_Skill_Grade()
        {
            var ocid = "c0ee173596c89da990c6fae8106e62f0"; // This character is 2nd job
            var skillGrade = "hyperactive";
            var response = await api.GetCharacterSkill(ocid, skillGrade);
            Assert.IsNotNull(response);
            Assert.IsNull(response?.CharacterSkillGrade);
            Assert.That(response?.CharacterSkill, Is.Empty);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterSkill on date with no data")]
        public async Task GetCharacterSkill_On_Date_With_No_Data()
        {
            var noDataOcid = "b0187493ec48ddd7b1d304fe8982d0b0";
            var skillGrade = "6";
            var date = new DateTime(2025, 6, 18, 0, 0, 0);
            var response = await api.GetCharacterSkill(noDataOcid, skillGrade, date);
            Assert.IsNull(response);
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
            var invalidDate = new DateTime(2023, 12, 20, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterSkill(ocid, skillGrade, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-21."));
            Console.WriteLine(e.Message);
        }
    }
}
