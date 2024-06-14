using NUnit.Framework;
using MapleStory.OpenAPI;

namespace MapleStory.Test
{
    [TestFixture]
    public class RankingAPI
    {
        private static readonly string apiKey = Environment.GetEnvironmentVariable("API_KEY")!; // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test]
        public async Task GetOverallRanking()
        {
            var response = await api.GetOverallRanking(null, 0, null, null, null);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetUnionRanking()
        {
            var response = await api.GetUnionRanking(null, null, null);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetGuildRanking()
        {
            var response = await api.GetGuildRanking(null, 0, null, null);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetDojangRanking()
        {
            var response = await api.GetDojangRanking(null, 0, null, null, null);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetSeedRanking()
        {
            var response = await api.GetTheSeedRanking(null, null, null);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetAchievementRanking()
        {
            var response = await api.GetAchievementRanking(null, null);
            Console.WriteLine(response.ToJson());
        }
    }
}
