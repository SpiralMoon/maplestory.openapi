using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.BattlePractice
{
    [TestFixture]
    public class TestGetBattlePracticeCharacterInfo
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);
        private static readonly string replayId = "8ac5ac350d67765e4c49db94cc61f83d";

        [Test, Description("success: GetBattlePracticeCharacterInfo")]
        public async Task GetBattlePracticeCharacterInfo()
        {
            var response = await api.GetBattlePracticeCharacterInfo(replayId);
            Assert.IsNotNull(response);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetBattlePracticeCharacterInfo with invalid replay_id")]
        public void GetBattlePracticeCharacterInfo_With_Invalid_Replay_Id()
        {
            var invalidReplayId = "invalid_replay_id_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetBattlePracticeCharacterInfo(invalidReplayId));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
