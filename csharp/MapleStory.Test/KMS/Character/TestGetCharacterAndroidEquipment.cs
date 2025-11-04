using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Character
{
    [TestFixture]
    public class TestGetCharacterAndroidEquipment
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetCharacterAndroidEquipment")]
        public async Task GetCharacterAndroidEquipment()
        {
            var response = await api.GetCharacterAndroidEquipment(ocid);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterAndroidEquipment with date")]
        public async Task GetCharacterAndroidEquipment_With_Date()
        {
            var date = new DateTime(2023, 12, 22, 0, 0, 0);
            var response = await api.GetCharacterAndroidEquipment(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterAndroidEquipment on date with no data")]
        public async Task GetCharacterAndroidEquipment_On_Date_With_No_Data()
        {
            var ocid = "b0187493ec48ddd7b1d304fe8982d0b0";
            var date = new DateTime(2025, 6, 18, 0, 0, 0);
            var response = await api.GetCharacterAndroidEquipment(ocid, date);
            Assert.IsNull(response);
        }

        [Test, Description("fail: GetCharacterAndroidEquipment with invalid ocid throws OPENAPI00003")]
        public void GetCharacterAndroidEquipment_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacterAndroidEquipment(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCharacterAndroidEquipment with invalid date")]
        public void GetCharacterAndroidEquipment_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2023, 12, 20, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterAndroidEquipment(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-21."));
            Console.WriteLine(e.Message);
        }
    }
}
