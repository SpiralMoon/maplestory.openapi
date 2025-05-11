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
        public DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string? CharacterClass { get; set; }

        /// <summary>
        /// HEXA 스탯 I 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core")]
        public List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore { get; set; }

        /// <summary>
        /// HEXA 스탯 II 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core_2")]
        public List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore2 { get; set; }

        /// <summary>
        /// HEXA 스탯 III 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core_3")]
        public List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore3 { get; set; }

        /// <summary>
        /// 프리셋 HEXA 스탯 I 코어 정보
        /// </summary>
        [JsonProperty("preset_hexa_stat_core")]
        public List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore { get; set; }

        /// <summary>
        /// 프리셋 HEXA 스탯 II 코어 정보
        /// </summary>
        [JsonProperty("preset_hexa_stat_core_2")]
        public List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore2 { get; set; }

        /// <summary>
        /// 프리셋 HEXA 스탯 III 코어 정보
        /// </summary>
        [JsonProperty("preset_hexa_stat_core_3")]
        public List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore3 { get; set; }
    }
}
