using MapleStory.OpenAPI.Common;
using MapleStory.OpenAPI.KMS;
using NUnit.Framework;

namespace MapleStory.Test.KMS.Notice
{
    [TestFixture]
    public class TestGetNoticeDetail
    {
        private static readonly string apiKey = EnvConfig.Get("API_KEY_KMS"); // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test, Description("success: GetNoticeDetail")]
        public async Task GetNoticeDetail()
        {
            var list = await api.GetNoticeList();

            if (list.Notice.Count == 0)
            {
                throw new Exception("Notice must be not empty.");
            }

            var noticeId = list.Notice[0].NoticeId;
            var response = await api.GetNoticeDetail(noticeId);
            Console.WriteLine(response.ToJson());
        }

        [Test, Description("fail: GetNoticeDetail with invalid notice id throw OPENAPI00004")]
        public void GetNoticeDetail_With_Invalid_Notice_Id_thorws_OPENAPI00004()
        {
            var invalidNoticeId = -1;
            var e = Assert.ThrowsAsync<MapleStoryAPIException>(async () => await api.GetNoticeDetail(invalidNoticeId));
            Assert.That(e.ErrorCode, Is.EqualTo(MapleStoryAPIErrorCode.OPENAPI00004));
            Console.WriteLine($"{e.ErrorCode} {e.Message}");
        }
    }
}
