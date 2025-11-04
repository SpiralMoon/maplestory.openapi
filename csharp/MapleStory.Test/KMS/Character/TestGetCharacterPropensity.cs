using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Character
{
    [TestFixture]
    public class TestGetCharacterPropensity
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetCharacterPropensity")]
        public async Task GetCharacterPropensity()
        {
            var response = await api.GetCharacterPropensity(ocid);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterPropensity with date")]
        public async Task GetCharacterPropensity_With_Date()
        {
            var date = new DateTime(2023, 12, 22, 0, 0, 0);
            var response = await api.GetCharacterPropensity(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterPropensity on date with no data")]
        public async Task GetCharacterPropensity_On_Date_With_No_Data()
        {
            var ocid = "b0187493ec48ddd7b1d304fe8982d0b0";
            var date = new DateTime(2025, 6, 18, 0, 0, 0);
            var response = await api.GetCharacterPropensity(ocid, date);
            Assert.IsNull(response);
        }

        [Test, Description("fail: GetCharacterPropensity with invalid ocid throws OPENAPI00003")]
        public void GetCharacterPropensity_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacterPropensity(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCharacterPropensity with invalid date")]
        public void GetCharacterPropensity_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2023, 12, 20, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterPropensity(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-21."));
            Console.WriteLine(e.Message);
        }
    }
}
