using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 정보
    /// </summary>
    public class CharacterDTO
    {
        /// <summary>
        /// 캐릭터 식별자
        /// </summary>
        [JsonProperty("ocid")]

        public string OCID { get; set; }
    }
}
