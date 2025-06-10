using NUnit.Framework;
using MapleStory.OpenAPI.KMS;

namespace MapleStory.Test
{
    [TestFixture]
    public class HistoryAPI
    {
        private static readonly string apiKey = Environment.GetEnvironmentVariable("API_KEY")!; // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test]
        public async Task GetStarforceHistory()
        {
            int count = 1000;
            var response = await api.GetStarforceHistory(count);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetPotentialHistory()
        {
            int count = 1000;
            var response = await api.GetPotentialHistory(count);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCubeHistory()
        {
            int count = 1000;
            var response = await api.GetCubeHistory(count);
            Console.WriteLine(response.ToJson());
        }
    }
}
