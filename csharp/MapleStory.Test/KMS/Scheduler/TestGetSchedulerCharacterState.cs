using NUnit.Framework;
using MapleStory.OpenAPI.KMS;
using MapleStory.OpenAPI.Common;

namespace MapleStory.Test.KMS.Scheduler
{
    [TestFixture]
    public class TestGetSchedulerCharacterState
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetSchedulerCharacterState")]
        public async Task GetSchedulerCharacterState()
        {
            var characterList = await api.GetCharacterList();
            var ocid = characterList.AccountList[0].CharacterList[0].OCID;
            var response = await api.GetSchedulerCharacterState(ocid);
            if (response != null)
            {
                Console.WriteLine(response.ToJson());
            }
        }

        [Test, Description("fail: GetSchedulerCharacterState with invalid ocid throws OPENAPI00003")]
        public void GetSchedulerCharacterState_With_Invalid_Ocid_Throws_OPENAPI00003()
        {
            var invalidOcid = "invalid_ocid_123";
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetSchedulerCharacterState(invalidOcid));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00003));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }

        [Test, Description("success: GetSchedulerCharacterState within the 14-day window")]
        public async Task GetSchedulerCharacterState_Within_Window()
        {
            var characterList = await api.GetCharacterList();
            var ocid = characterList.AccountList[0].CharacterList[0].OCID;
            var date = DateTimeOffset.UtcNow.ToOffset(TimeSpan.FromHours(9)).AddDays(-13);
            var response = await api.GetSchedulerCharacterState(ocid, date);
            if (response != null)
            {
                Console.WriteLine(response.ToJson());
            }
        }

        [Test, Description("fail: GetSchedulerCharacterState outside the 14-day window throws OPENAPI00004")]
        public async Task GetSchedulerCharacterState_Outside_Window_Throws_OPENAPI00004()
        {
            var characterList = await api.GetCharacterList();
            var ocid = characterList.AccountList[0].CharacterList[0].OCID;
            var date = DateTimeOffset.UtcNow.ToOffset(TimeSpan.FromHours(9)).AddDays(-14);
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetSchedulerCharacterState(ocid, date));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
