using Newtonsoft.Json;

namespace MapleStory.OpenAPI
{
    internal class MapleStoryAPIErrorBody
    {
        [JsonProperty("error")]
        public Error Error;
    }

    internal class Error
    {
        [JsonProperty("message")]
        public string Message;

        [JsonProperty("name")]
        public string Name;
    }
}
