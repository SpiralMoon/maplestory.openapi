using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 정보
    /// </summary>
    public class CharacterDTO : Base.CharacterDTO
    {
        /// <summary>
        /// 캐릭터 식별자
        /// </summary>
        [JsonProperty("ocid")]

        public override string OCID { get; set; }
    }
}
