using NUnit.Framework;
using MapleStory.OpenAPI;

namespace MapleStory.Test
{
    [TestFixture]
    public class GuildAPI
    {
        private static readonly string apiKey = Environment.GetEnvironmentVariable("API_KEY")!; // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ogid = "f5992063d46d6f8718e514fca5428960";

        [Test]
        public async Task GetGuild()
        {
            var guildName = "붕붕";
            var worldName = "크로아";
            var response = await api.GetGuild(guildName, worldName);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetGuildBasic()
        {
            var response = await api.GetGuildBasic(ogid);
            Console.WriteLine(response.ToJson());
        }
    }
}
