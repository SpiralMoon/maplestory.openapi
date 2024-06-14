using NUnit.Framework;
using MapleStory.OpenAPI;

namespace MapleStory.Test
{
    [TestFixture]
    public class UnionAPI
    {
        private static readonly string apiKey = Environment.GetEnvironmentVariable("API_KEY")!; // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string ocid = "e0a4f439e53c369866b55297d2f5f4eb";

        [Test]
        public async Task GetUnion()
        {
            var response = await api.GetUnion(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetUnionRaider()
        {
            var response = await api.GetUnionRaider(ocid);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetUnionArtifact()
        {
            var response = await api.GetUnionArtifact(ocid);
            Console.WriteLine(response.ToJson());
        }
    }
}
