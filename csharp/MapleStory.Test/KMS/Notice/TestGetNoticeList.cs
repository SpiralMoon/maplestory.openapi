using NUnit.Framework;
using MapleStory.OpenAPI.KMS;

namespace MapleStory.Test.KMS.Notice
{
    [TestFixture]
    public class TestGetNoticeList
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetNoticeList")]
        public async Task GetNoticeList()
        {
            var response = await api.GetNoticeList();
            Console.WriteLine(response.ToJson());
        }
    }
}
