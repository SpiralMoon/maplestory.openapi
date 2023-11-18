using Newtonsoft.Json;

namespace MapleStory.OpenAPI
{
    internal class MapleStoryAPIErrorBody
    {
        [JsonProperty("message")]
        public string Message;

        [JsonProperty("status")]
        public int Status;
    }
}
