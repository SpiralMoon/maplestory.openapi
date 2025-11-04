using NUnit.Framework;
using MapleStory.OpenAPI.KMS;

namespace MapleStory.Test.KMS.User
{
    [TestFixture]
    public class TestGetAchievement
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetAchievement")]
        public async Task GetAchievement()
        {
            var response = await api.GetAchievement();
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }
    }
}
