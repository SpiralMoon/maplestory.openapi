using NUnit.Framework;
using MapleStory.OpenAPI;

namespace MapleStory.Test
{
    [TestFixture]
    public class NoticeAPI
    {
        private static readonly string apiKey = Environment.GetEnvironmentVariable("API_KEY")!; // Your API Key
        private static readonly MapleStoryAPI api = new MapleStoryAPI(apiKey);

        [Test]
        public async Task GetNoticeList()
        {
            var response = await api.GetNoticeList();
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetNoticeDetail()
        {
            var list = await api.GetNoticeList();

            if (list.Notice.Count == 0)
            {
                throw new Exception("Notice muse be not empty.");
            }

            var noticeId = list.Notice[0].NoticeId;
            var response = await api.GetNoticeDetail(noticeId);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetUpdateNoticeList()
        {
            var response = await api.GetUpdateNoticeList();
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetUpdateNoticeDetail()
        {
            var list = await api.GetUpdateNoticeList();

            if (list.UpdateNotice.Count == 0)
            {
                throw new Exception("Notice muse be not empty.");
            }

            var noticeId = list.UpdateNotice[0].NoticeId;
            var response = await api.GetUpdateNoticeDetail(noticeId);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetEventNoticeList()
        {
            var response = await api.GetEventNoticeList();
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetEventNoticeDetail()
        {
            var list = await api.GetEventNoticeList();

            if (list.EventNotice.Count == 0)
            {
                throw new Exception("Notice muse be not empty.");
            }

            var noticeId = list.EventNotice[0].NoticeId;
            var response = await api.GetEventNoticeDetail(noticeId);
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCashshopNoticeList()
        {
            var response = await api.GetCashshopNoticeList();
            Console.WriteLine(response.ToJson());
        }

        [Test]
        public async Task GetCashshopNoticeDetail()
        {
            var list = await api.GetCashshopNoticeList();

            if (list.CashshopNotice.Count == 0)
            {
                throw new Exception("Notice muse be not empty.");
            }

            var noticeId = list.CashshopNotice[0].NoticeId;
            var response = await api.GetCashshopNoticeDetail(noticeId);
            Console.WriteLine(response.ToJson());
        }
    }
}
