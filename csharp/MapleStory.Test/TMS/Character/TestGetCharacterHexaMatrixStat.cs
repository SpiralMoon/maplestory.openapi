using NUnit.Framework;
using MapleStory.OpenAPI.TMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.TMS.Character
{
    [TestFixture]
    public class TestGetCharacterHexaMatrixStat
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_TMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "ab918948538b1b79046df133fff52092";

        [Test, Description("success: GetCharacterHexaMatrixStat")]
        public async Task GetCharacterHexaMatrixStat()
        {
            var response = await api.GetCharacterHexaMatrixStat(ocid);
            // nothing to assert because some characters may not have Hexa Matrix Stat
            Console.WriteLine(response?.ToJson());
        }

        [Test, Description("success: GetCharacterHexaMatrixStat with date")]
        public async Task GetCharacterHexaMatrixStat_With_Date()
        {
            var date = new DateTime(2025, 10, 15, 0, 0, 0);
            var response = await api.GetCharacterHexaMatrixStat(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetCharacterHexaMatrixStat with invalid ocid throws OPENAPI00003")]
        public void GetCharacterHexaMatrixStat_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacterHexaMatrixStat(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCharacterHexaMatrixStat with invalid date")]
        public void GetCharacterHexaMatrixStat_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 10, 14, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterHexaMatrixStat(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-10-15."));
            Console.WriteLine(e.Message);
        }
    }
}
