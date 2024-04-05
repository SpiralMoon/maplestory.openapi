using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 V매트릭스 정보
    /// </summary>
    public class CharacterVMatrixDTO
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
        public string CharacterClass { get; set; }

        /// <summary>
        /// V 코어 정보를 나타내는 DTO 클래스입니다.
        /// </summary>
        [JsonProperty("character_v_core_equipment")]
        public List<CharacterVMatrixCoreEquipmentDTO> CharacterVCoreEquipment { get; set; }

        /// <summary>
        /// 캐릭터 잔여 매트릭스 강화 포인트
        /// </summary>
        [JsonProperty("character_v_matrix_remain_slot_upgrade_point")]
        public long CharacterVMatrixRemainSlotUpgradePoint { get; set; }
    }
}
