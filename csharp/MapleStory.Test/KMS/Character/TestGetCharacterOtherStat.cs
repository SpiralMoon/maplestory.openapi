using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Character
{
    [TestFixture]
    public class TestGetCharacterOtherStat
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetCharacterOtherStat")]
        public async Task GetCharacterOtherStat()
        {
            var response = await api.GetCharacterOtherStat(ocid);
            // nothing to assert because some characters may not have other stats
            Console.WriteLine(response?.ToJson());
        }

        [Test, Description("success: GetCharacterOtherStat with date")]
        public async Task GetCharacterOtherStat_With_Date()
        {
            var ocid = "17886f88aca85174fe898b739b7fd0d9";
            var date = new DateTime(2025, 11, 20, 0, 0, 0);
            var response = await api.GetCharacterOtherStat(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCharacterOtherStat on date with no data")]
        public async Task GetCharacterOtherStat_On_Date_With_No_Data()
        {
            var ocid = "b0187493ec48ddd7b1d304fe8982d0b0";
            var date = new DateTime(2025, 8, 21, 0, 0, 0);
            var response = await api.GetCharacterOtherStat(ocid, date);
            Assert.IsNull(response);
        }

        [Test, Description("fail: GetCharacterOtherStat with invalid ocid throws OPENAPI00003")]
        public void GetCharacterOtherStat_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCharacterOtherStat(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCharacterOtherStat with invalid date")]
        public void GetCharacterOtherStat_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2025, 8, 20, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetCharacterOtherStat(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2025-08-21."));
            Console.WriteLine(e.Message);
        }
    }
}
