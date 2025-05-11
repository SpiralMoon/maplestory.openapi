using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 장비 아이템 정보
    /// </summary>
    public class CharacterItemEquipmentDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
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
        /// 캐릭터 성별
        /// </summary>
        [JsonProperty("character_gender")]
        public string? CharacterGender { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string? CharacterClass { get; set; }

        /// <summary>
        /// 적용 중인 장비 프리셋 번호
        /// </summary>
        [JsonProperty("preset_no")]
        public int? PresetNo { get; set; }

        /// <summary>
        /// 장비 정보
        /// </summary>
        [JsonProperty("item_equipment")]
        public List<CharacterItemEquipmentInfoDTO> ItemEquipment { get; set; }

        /// <summary>
        /// 1번 프리셋 장비 정보
        /// </summary>
        [JsonProperty("item_equipment_preset_1")]
        public List<CharacterItemEquipmentInfoDTO>? ItemEquipmentPreset1 { get; set; }

        /// <summary>
        /// 2번 프리셋 장비 정보
        /// </summary>
        [JsonProperty("item_equipment_preset_2")]
        public List<CharacterItemEquipmentInfoDTO>? ItemEquipmentPreset2 { get; set; }

        /// <summary>
        /// 3번 프리셋 장비 정보
        /// </summary>
        [JsonProperty("item_equipment_preset_3")]
        public List<CharacterItemEquipmentInfoDTO>? ItemEquipmentPreset3 { get; set; }

        /// <summary>
        /// 칭호 정보
        /// </summary>
        [JsonProperty("title")]
        public CharacterItemEquipmentTitleDTO? Title { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장 외형 정보
        /// </summary>
        [JsonProperty("medal_shape")]
        public CharacterItemEquipmentMedalShapeDTO? MedalShape { get; set; }

        /// <summary>
        /// 에반 드래곤 장비 정보 (에반인 경우 응답)
        /// </summary>
        [JsonProperty("dragon_equipment")]
        public List<CharacterItemEquipmentDragonInfoDTO> DragonEquipment { get; set; }

        /// <summary>
        /// 메카닉 장비 정보 (메카닉인 경우 응답)
        /// </summary>
        [JsonProperty("mechanic_equipment")]
        public List<CharacterItemEquipmentMechanicInfoDTO> MechanicEquipment { get; set; }
    }
}
