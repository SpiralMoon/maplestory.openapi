using MapleStory.OpenAPI.Common;
using MapleStory.OpenAPI.KMS;
using NUnit.Framework;
using System.Security.Cryptography;

namespace MapleStory.Test.KMS.Ranking
{
    [TestFixture]
    public class TestGetGuildRanking
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetGuildRanking")]
        public async Task GetGuildRanking()
        {
            var response = await api.GetGuildRanking(worldName: null, rankingType: 0, guildName: null, page: null);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetGuildRanking with paging")]
        public async Task GetGuildRanking_With_Paging()
        {
            var response = await api.GetGuildRanking(worldName: null, rankingType: 0, guildName: null, page: 2);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetGuildRanking with guild name")]
        public async Task GetGuildRanking_With_Guild_Name()
        {
            var response = await api.GetGuildRanking(worldName: null, rankingType: 0, guildName: "붕붕", page: null);
            Assert.That(response.Ranking.Count, Is.GreaterThan(0));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetGuildRanking with world name")]
        public async Task GetGuildRanking_With_World_Name()
        {
            var response = await api.GetGuildRanking(worldName: "스카니아", rankingType: 0, guildName: null, page: null);
            Assert.That(response.Ranking.Count, Is.GreaterThan(0));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetGuildRanking with world and guild name")]
        public async Task GetGuildRanking_With_World_And_Guild_Name()
        {
            var response = await api.GetGuildRanking(worldName: "스카니아", rankingType: 0, guildName: "붕붕", page: null);
            Assert.That(response.Ranking.Count, Is.LessThanOrEqualTo(1));
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetGuildRanking with date")]
        public async Task GetGuildRanking_With_Date()
        {
            var date = new DateTime(2025, 1, 1, 0, 0, 0);
            var response = await api.GetGuildRanking(worldName: null, rankingType: 0, guildName: null, page: null, date);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetGuildRanking with invalid date")]
        public void GetGuildRanking_With_Invalid_Date()
        {
            var invalidDate = new DateTime(2023, 12, 21, 0, 0, 0);
            var e = Assert.ThrowsAsync<ArgumentException>(async () => await api.GetGuildRanking(worldName: null, rankingType: 0, guildName: null, page: null, invalidDate));
            Assert.That(e.Message, Does.Contain("You can only retrieve data after 2023-12-22."));
            Console.WriteLine(e.Message);
        }

        [Test, Description("success: GetGuildRanking with invalid guild name")]
        public async Task GetGuildRanking_With_Invalid_Guild_Name()
        {
            var invalidGuildName = "invalid_guild_name_123";
            var response = await api.GetGuildRanking(worldName: null, rankingType: 0, guildName: invalidGuildName, page: null);
            Assert.IsEmpty(response.Ranking);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetGuildRanking with ranking type throws OPENAPI00004")]
        public void GetGuildRanking_With_Invalid_Ranking_Type_Throws_OPENAPI00004()
        {
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetGuildRanking(worldName: null, rankingType: -1, guildName: null, page: null));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
