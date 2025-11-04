using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Union
{
    [TestFixture]
    public class TestGetUnionArtifact
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test, Description("success: GetUnionArtifact")]
        public async Task GetUnionArtifact()
        {
            var response = await api.GetUnionArtifact(ocid);
            // nothing to assert because some characters may not have union artifact
            Console.WriteLine(response?.ToJson());
        }

        [Test, Description("success: GetUnionArtifact with date")]
        public async Task GetUnionArtifact_With_Date()
        {
            var date = new DateTime(2024, 1, 18, 0, 0, 0);
            var response = await api.GetUnionArtifact(ocid, date);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetUnionArtifact with invalid date")]
        public void GetUnionArtifact_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2024, 1, 17, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetUnionArtifact(ocid, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2024-01-18."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetUnionArtifact with invalid ocid throws OPENAPI00003")]
        public void GetUnionArtifact_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetUnionArtifact(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
