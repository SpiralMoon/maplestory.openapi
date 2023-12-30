using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 연결된 HEXA 스킬 정보
    /// </summary>
    public class CharacterHexaMatrixEquipmentLinkedSkillDTO
    {
        /// <summary>
        /// HEXA 스킬 명
        /// </summary>
        [JsonProperty("hexa_skill_id")]
        public string HexaSkillId { get; set; }
    }
}
