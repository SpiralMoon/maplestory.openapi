using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.History
{
    [TestFixture]
    public class TestGetPotentialHistory
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetPotentialHistory")]
        public async Task GetPotentialHistory()
        {
            int count = 1000;
            var response = await api.GetPotentialHistory(count);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetPotentialHistory with date")]
        public async Task GetPotentialHistory_With_Date()
        {
            int count = 1000;
            var date = new DateTime(2025, 7, 31, 0, 0, 0);
            var response = await api.GetPotentialHistory(count, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetPotentialHistory [with cursor]")]
        public async Task GetPotentialHistory_With_Cursor()
        {
            int count = 10;
            var date = new DateTime(2025, 7, 31, 0, 0, 0);
            var response = await api.GetPotentialHistory(count, date);
            var nextCursor = response.NextCursor;
            Assert.That(nextCursor, Is.Not.Null);
            var nextResponse = await api.GetPotentialHistory(count, nextCursor);
            Console.WriteLine(nextResponse.ToJson());
        }

        [Test, Description("fail: GetPotentialHistory with invalid date")]
        public void GetPotentialHistory_With_Invalid_Date()
        {
            int count = 1000;
            var invalidDate = new DateTime(2024, 1, 24, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetPotentialHistory(count, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2024-01-25."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetPotentialHistory [throws OPENAPI00003 with invalid cursor]")]
        public void GetPotentialHistory_With_Invalid_Cursor_Throws_OPENAPI00003()
        {
            int count = 1000;
            var invalidCursor = "invalid_cursor_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetPotentialHistory(count, invalidCursor));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetPotentialHistory [throws OPENAPI00004 with excessive count]")]
        public void GetPotentialHistory_With_Excessive_Count_Throws_OPENAPI00004()
        {
            int count = 9999;
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetPotentialHistory(count));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
