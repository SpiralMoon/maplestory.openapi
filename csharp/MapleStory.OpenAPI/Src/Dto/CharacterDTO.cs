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
        [JsonProperty("character_name")]

        public string Ocid { get; set; }
    }
}
