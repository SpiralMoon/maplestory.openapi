using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 HEXA 코어 정보
    /// </summary>
    public class CharacterHexaMatrixDTO : Base.CharacterHexaMatrixDTO<CharacterHexaMatrixEquipmentDTO>
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
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
        public override List<CharacterHexaMatrixEquipmentDTO>? CharacterHexaCoreEquipment { get; set; }
    }

    /// <summary>
    /// 연결된 HEXA 스킬 정보
    /// </summary>
    public class CharacterHexaMatrixEquipmentLinkedSkillDTO : Base.CharacterHexaMatrixEquipmentLinkedSkillDTO
    {
        /// <summary>
        /// HEXA 스킬 명
        /// </summary>
        [JsonProperty("hexa_skill_id")]
        public override string HexaSkillId { get; set; }
    }

    /// <summary>
    /// 캐릭터 HEXA 코어 정보
    /// </summary>
    public class CharacterHexaMatrixEquipmentDTO : Base.CharacterHexaMatrixEquipmentDTO<CharacterHexaMatrixEquipmentLinkedSkillDTO>
    {
        /// <summary>
        /// 코어 명
        /// </summary>
        [JsonProperty("hexa_core_name")]
        public override string HexaCoreName { get; set; }

        /// <summary>
        /// 코어 레벨
        /// </summary>
        [JsonProperty("hexa_core_level")]
        public override long HexaCoreLevel { get; set; }

        /// <summary>
        /// 코어 타입
        /// </summary>
        [JsonProperty("hexa_core_type")]
        public override string HexaCoreType { get; set; }

        /// <summary>
        /// 연결된 스킬
        /// </summary>
        [JsonProperty("linked_skill")]
        public override List<CharacterHexaMatrixEquipmentLinkedSkillDTO> LinkedSkill { get; set; }
    }
}
