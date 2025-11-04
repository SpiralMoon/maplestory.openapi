using NUnit.Framework;
using MapleStory.OpenAPI.KMS;

namespace MapleStory.Test.KMS.Notice
{
    [TestFixture]
    public class TestGetEventNoticeList
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetEventNoticeList")]
        public async Task GetEventNoticeList()
        {
            var response = await api.GetEventNoticeList();
            Console.WriteLine(response.ToJson());
        }
    }
}
