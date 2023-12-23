using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 HEXA 스탯 코어 정보
    /// </summary>
    public class CharacterHexaMatrixStatDTO
    {
        /// <summary>
        /// 조회 기준일 (KST)
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string CharacterClass { get; set; }

        /// <summary>
        /// HEXA 스탯 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core")]
        public List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore { get; set; }

        /// <summary>
        /// 프리셋 HEXA 스탯 코어 정보
        /// </summary>
        [JsonProperty("preset_hexa_stat_core")]
        public List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore { get; set; }
    }
}
