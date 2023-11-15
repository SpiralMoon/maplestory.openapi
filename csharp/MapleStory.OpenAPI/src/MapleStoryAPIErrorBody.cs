using Newtonsoft.Json;

namespace MapleStory.OpenAPI.src
{
    public class MapleStoryAPIErrorBody
    {
        [JsonProperty("message")]
        public string Message;

        [JsonProperty("status")]
        public int Status;
    }
}
