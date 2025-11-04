using NUnit.Framework;
using MapleStory.OpenAPI.KMS;

namespace MapleStory.Test.KMS.Notice
{
    [TestFixture]
    public class TestGetUpdateNoticeList
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetUpdateNoticeList")]
        public async Task GetUpdateNoticeList()
        {
            var response = await api.GetUpdateNoticeList();
            Console.WriteLine(response.ToJson());
        }
    }
}
