using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 헤어, 성형, 피부 정보
    /// </summary>
    public class CharacterBeautyEquipmentDTO
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
        /// 캐릭터 헤어 정보
        /// (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
        /// </summary>
        [JsonProperty("character_hair")]
        public CharacterBeautyEquipmentHairDTO CharacterHair { get; set; }

        /// <summary>
        /// 캐릭터 성형 정보
        /// (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
        /// </summary>
        [JsonProperty("character_face")]
        public CharacterBeautyEquipmentFaceDTO CharacterFace { get; set; }

        /// <summary>
        /// 드레스 업 모드에 적용 중인 헤어 정보
        /// (제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
        /// </summary>
        [JsonProperty("additional_character_hair")]
        public CharacterBeautyEquipmentHairDTO? AdditionalCharacterHair { get; set; }

        /// <summary>
        /// 드레스 업 모드에 적용 중인 성형 정보
        /// (제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
        /// </summary>
        [JsonProperty("additional_character_face")]
        public CharacterBeautyEquipmentFaceDTO? AdditionalCharacterFace { get; set; }

        /// <summary>
        /// 드레스 업 모드에 적용 중인 피부 명
        /// (제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
        /// </summary>
        [JsonProperty("additional_character_skin_name")]
        public string? AdditionalCharacterSkinName { get; set; }
    }
}
