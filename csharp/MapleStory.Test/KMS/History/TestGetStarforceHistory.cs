using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.History
{
    [TestFixture]
    public class TestGetStarforceHistory
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetStarforceHistory")]
        public async Task GetStarforceHistory()
        {
            int count = 1000;
            var response = await api.GetStarforceHistory(count);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetStarforceHistory with date")]
        public async Task GetStarforceHistory_With_Date()
        {
            int count = 1000;
            var date = new DateTime(2025, 9, 21, 0, 0, 0);
            var response = await api.GetStarforceHistory(count, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetStarforceHistory [with cursor]")]
        public async Task GetStarforceHistory_With_Cursor()
        {
            int count = 10;
            var date = new DateTime(2025, 9, 21, 0, 0, 0);
            var response = await api.GetStarforceHistory(count, date);
            var nextCursor = response.NextCursor;
            Assert.That(nextCursor, Is.Not.Null);
            var nextResponse = await api.GetStarforceHistory(count, nextCursor);
            Console.WriteLine(nextResponse.ToJson());
        }

        [Test, Description("fail: GetStarforceHistory with invalid date")]
        public void GetStarforceHistory_With_Invalid_Date()
        {
            int count = 1000;
            var invalidDate = new DateTime(2023, 12, 26, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetStarforceHistory(count, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-27."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("fail: GetStarforceHistory [throws OPENAPI00003 with invalid cursor]")]
        public void GetStarforceHistory_With_Invalid_Cursor_Throws_OPENAPI00003()
        {
            int count = 1000;
            var invalidCursor = "invalid_cursor_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetStarforceHistory(count, invalidCursor));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetStarforceHistory [throws OPENAPI00004 with excessive count]")]
        public void GetStarforceHistory_With_Excessive_Count_Throws_OPENAPI00004()
        {
            int count = 9999;
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetStarforceHistory(count));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
