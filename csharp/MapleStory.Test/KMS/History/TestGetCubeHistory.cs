using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.History
{
    [TestFixture]
    public class TestGetCubeHistory
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetCubeHistory")]
        public async Task GetCubeHistory()
        {
            int count = 1000;
            var response = await api.GetCubeHistory(count);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCubeHistory with date")]
        public async Task GetCubeHistory_With_Date()
        {
            int count = 1000;
            var date = new DateTime(2025, 10, 23, 0, 0, 0);
            var response = await api.GetCubeHistory(count, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetCubeHistory [with cursor]")]
        public async Task GetCubeHistory_With_Cursor()
        {
            int count = 10;
            var date = new DateTime(2025, 10, 23, 0, 0, 0);
            var response = await api.GetCubeHistory(count, date);
            var nextCursor = response.NextCursor;
            Assert.That(nextCursor, Is.Not.Null);
            var nextResponse = await api.GetCubeHistory(count, nextCursor);
            Console.WriteLine(nextResponse.ToJson());
        }

        [Test, Description("fail: GetCubeHistory [throws OPENAPI00003 with invalid cursor]")]
        public void GetCubeHistory_With_Invalid_Cursor_Throws_OPENAPI00003()
        {
            int count = 1000;
            var invalidCursor = "invalid_cursor_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCubeHistory(count, invalidCursor));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("fail: GetCubeHistory [throws OPENAPI00004 with excessive count]")]
        public void GetCubeHistory_With_Excessive_Count_Throws_OPENAPI00004()
        {
            int count = 9999;
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetCubeHistory(count));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
