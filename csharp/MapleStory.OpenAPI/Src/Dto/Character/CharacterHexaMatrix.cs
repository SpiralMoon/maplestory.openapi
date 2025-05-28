using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 HEXA 코어 정보
    /// </summary>
    public class CharacterHexaMatrixDTO
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
        /// HEXA 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_core_equipment")]
        public List<CharacterHexaMatrixEquipmentDTO>? CharacterHexaCoreEquipment { get; set; }
    }

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
