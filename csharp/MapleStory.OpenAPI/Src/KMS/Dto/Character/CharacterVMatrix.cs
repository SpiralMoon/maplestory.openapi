using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 V매트릭스 정보
    /// </summary>
    public class CharacterVMatrixDTO : Base.CharacterVMatrixDTO<CharacterVMatrixCoreEquipmentDTO>
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
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// V코어 정보
        /// </summary>
        [JsonProperty("character_v_core_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterVMatrixCoreEquipmentDTO> CharacterVCoreEquipment { get; set; } = new();

        /// <summary>
        /// 캐릭터 잔여 매트릭스 강화 포인트
        /// </summary>
        [JsonProperty("character_v_matrix_remain_slot_upgrade_point")]
        public override int? CharacterVMatrixRemainSlotUpgradePoint { get; set; }
    }

    /// <summary>
    /// 캐릭터 V코어 정보
    /// </summary>
    public class CharacterVMatrixCoreEquipmentDTO : Base.CharacterVMatrixCoreEquipmentDTO
    {
        /// <summary>
        /// 슬롯 인덱스
        /// </summary>
        [JsonProperty("slot_id")]
        public override string SlotId { get; set; }

        /// <summary>
        /// 슬롯 레벨
        /// </summary>
        [JsonProperty("slot_level")]
        public override long SlotLevel { get; set; }

        /// <summary>
        /// 코어 명
        /// </summary>
        [JsonProperty("v_core_name")]
        public override string? VCoreName { get; set; }

        /// <summary>
        /// 코어 타입
        /// </summary>
        [JsonProperty("v_core_type")]
        public override string? VCoreType { get; set; }

        /// <summary>
        /// 코어 레벨
        /// </summary>
        [JsonProperty("v_core_level")]
        public override long VCoreLevel { get; set; }

        /// <summary>
        /// 코어에 해당하는 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_1")]
        public override string VCoreSkill1 { get; set; }

        /// <summary>
        /// 강화 코어인 경우 코어에 해당하는 두 번째 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_2")]
        public override string? VCoreSkill2 { get; set; }

        /// <summary>
        /// 강화 코어인 경우 코어에 해당하는 세 번째 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_3")]
        public override string? VCoreSkill3 { get; set; }
    }
}
