using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 HEXA 코어 정보
    /// </summary>
    public class CharacterHexaMatrixEquipmentDTO
    {
        /// <summary>
        /// 코어 명
        /// </summary>
        [JsonProperty("hexa_core_name")]
        public string HexaCoreName { get; set; }

        /// <summary>
        /// 코어 레벨
        /// </summary>
        [JsonProperty("hexa_core_level")]
        public long HexaCoreLevel { get; set; }

        /// <summary>
        /// 코어 타입
        /// </summary>
        [JsonProperty("hexa_core_type")]
        public string HexaCoreType { get; set; }

        /// <summary>
        /// 연결된 스킬
        /// </summary>
        [JsonProperty("linked_skill")]
        public List<CharacterHexaMatrixEquipmentLinkedSkillDTO> LinkedSkill { get; set; }
    }
}
