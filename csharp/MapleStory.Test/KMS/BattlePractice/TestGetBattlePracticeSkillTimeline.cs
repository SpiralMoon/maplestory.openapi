using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.BattlePractice
{
    [TestFixture]
    public class TestGetBattlePracticeSkillTimeline
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string replayId = "8ac5ac350d67765e4c49db94cc61f83d";

        [Test, Description("success: GetBattlePracticeSkillTimeline (default page)")]
        public async Task GetBattlePracticeSkillTimeline()
        {
            var response = await api.GetBattlePracticeSkillTimeline(replayId);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("success: GetBattlePracticeSkillTimeline with pageNo")]
        public async Task GetBattlePracticeSkillTimeline_With_PageNo()
        {
            var response = await api.GetBattlePracticeSkillTimeline(replayId, 1);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetBattlePracticeSkillTimeline with invalid replay_id")]
        public void GetBattlePracticeSkillTimeline_With_Invalid_Replay_Id()
        {
            var invalidReplayId = "invalid_replay_id_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetBattlePracticeSkillTimeline(invalidReplayId));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
