using NUnit.Framework;
using MapleStory.OpenAPI.TMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.TMS.Character
{
    [TestFixture]
    public class TestGetCharacterBasic
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_TMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "ab918948538b1b79046df133fff52092";

        [Test, Description("success: GetCharacterBasic")]
        public async Task GetCharacterBasic()
        {
            var response = await api.GetCharacterBasic(ocid);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterBasic with date")]
        public async Task GetCharacterBasic_With_Date()
        {
            var date = new DateTime(2025, 10, 15, 0, 0, 0);
            var response = await api.GetCharacterBasic(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetCharacterBasic with invalid ocid throws OPENAPI00003")]
        public void GetCharacterBasic_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123_";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacterBasic(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCharacterBasic with invalid date")]
        public void GetCharacterBasic_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 10, 14, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterBasic(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-10-15."));
            Console.WriteLine(e.Message);
        }
    }
}
