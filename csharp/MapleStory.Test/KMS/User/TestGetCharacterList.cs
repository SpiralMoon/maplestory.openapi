using NUnit.Framework;
using MapleStory.OpenAPI.KMS;

namespace MapleStory.Test.KMS.User
{
    [TestFixture]
    public class TestGetCharacterList
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetCharacterList")]
        public async Task GetCharacterList()
        {
            var response = await api.GetCharacterList();
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }
    }
}
