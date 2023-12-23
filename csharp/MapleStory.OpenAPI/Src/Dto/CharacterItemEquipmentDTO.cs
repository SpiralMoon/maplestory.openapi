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
        public string Date { get; set; }

        /// <summary>
        /// 캐릭터 성별
        /// </summary>
        [JsonProperty("character_gender")]
        public string CharacterGender { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string CharacterClass { get; set; }

        /// <summary>
        /// 장비 정보 리스트
        /// </summary>
        [JsonProperty("item_equipment")]
        public List<CharacterItemEquipmentInfoDTO> ItemEquipment { get; set; }

        /// <summary>
        /// 칭호 정보
        /// </summary>
        [JsonProperty("title")]
        public CharacterItemEquipmentTitleDTO Title { get; set; }

        /// <summary>
        /// 에반 드래곤 장비 정보 (에반인 경우 응답)
        /// </summary>
        [JsonProperty("dragon_equipment")]
        public List<CharacterItemEquipmentInfoDTO> DragonEquipment { get; set; }

        /// <summary>
        /// 메카닉 장비 정보 (메카닉인 경우 응답)
        /// </summary>
        [JsonProperty("mechanic_equipment")]
        public List<CharacterItemEquipmentInfoDTO> MechanicEquipment { get; set; }
    }
}
