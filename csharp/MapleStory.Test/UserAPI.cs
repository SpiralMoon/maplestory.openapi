using NUnit.Framework;
using MapleStory.OpenAPI.KMS;

namespace MapleStory.Test
{
    [TestFixture]
    public class UserAPI
    {
        private static readonly string apiKey = Environment.GetEnvironmentVariable("API_KEY")!; // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test]
        public async Task GetCharacterList()
        {
            var response = await api.GetCharacterList();
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetAchievement()
        {
            var response = await api.GetAchievement();
            Console.WriteLine(response.ToJson());
        }
    }
}
