using NUnit.Framework;
using MapleStory.OpenAPI.TMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.TMS.Character
{
    [TestFixture]
    public class TestGetCharacterHyperStat
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_TMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "ab918948538b1b79046df133fff52092";

        [Test, Description("success: GetCharacterHyperStat")]
        public async Task GetCharacterHyperStat()
        {
            var response = await api.GetCharacterHyperStat(ocid);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterHyperStat with date")]
        public async Task GetCharacterHyperStat_With_Date()
        {
            var date = new DateTime(2025, 10, 15, 0, 0, 0);
            var response = await api.GetCharacterHyperStat(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetCharacterHyperStat with invalid ocid throws OPENAPI00003")]
        public void GetCharacterHyperStat_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacterHyperStat(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCharacterHyperStat with invalid date")]
        public void GetCharacterHyperStat_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 10, 14, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterHyperStat(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-10-15."));
            Console.WriteLine(e.Message);
        }
    }
}
