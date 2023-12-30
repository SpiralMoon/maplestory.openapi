using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 펫 장비 정보
    /// </summary>
    public class CharacterPetEquipmentDTO
    {
        /// <summary>
        /// 조회 기준일 (KST)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset Date
        {
            get
            {
                return _date.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset _date;

        /// <summary>
        /// 펫1 명
        /// </summary>
        [JsonProperty("pet_1_name")]
        public string Pet1Name { get; set; }

        /// <summary>
        /// 펫1 닉네임
        /// </summary>
        [JsonProperty("pet_1_nickname")]
        public string Pet1Nickname { get; set; }

        /// <summary>
        /// 펫1 아이콘
        /// </summary>
        [JsonProperty("pet_1_icon")]
        public string Pet1Icon { get; set; }

        /// <summary>
        /// 펫1 설명
        /// </summary>
        [JsonProperty("pet_1_description")]
        public string Pet1Description { get; set; }

        /// <summary>
        /// 펫1 장착 정보
        /// </summary>
        [JsonProperty("pet_1_equipment")]
        public CharacterPetEquipmentItemDTO Pet1Equipment { get; set; }

        /// <summary>
        /// 펫1 펫 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_1_auto_skill")]
        public CharacterPetEquipmentAutoSkillDTO Pet1AutoSkill { get; set; }

        /// <summary>
        /// 펫1 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_1_pet_type")]
        public string? Pet1PetType { get; set; }

        /// <summary>
        /// 펫1 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_1_skill")]
        public List<string> Pet1Skill { get; set; }

        /// <summary>
        /// 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("pet_1_date_expire")]
        public DateTimeOffset Pet1DateExpire
        {
            get
            {
                return _pet1DateExpire.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _pet1DateExpire = value;
            }
        }

        private DateTimeOffset _pet1DateExpire;

        /// <summary>
        /// 펫2 명
        /// </summary>
        [JsonProperty("pet_2_name")]
        public string Pet2Name { get; set; }

        /// <summary>
        /// 펫2 닉네임
        /// </summary>
        [JsonProperty("pet_2_nickname")]
        public string Pet2Nickname { get; set; }

        /// <summary>
        /// 펫2 아이콘
        /// </summary>
        [JsonProperty("pet_2_icon")]
        public string Pet2Icon { get; set; }

        /// <summary>
        /// 펫2 설명
        /// </summary>
        [JsonProperty("pet_2_description")]
        public string Pet2Description { get; set; }

        /// <summary>
        /// 펫2 장착 정보
        /// </summary>
        [JsonProperty("pet_2_equipment")]
        public CharacterPetEquipmentItemDTO Pet2Equipment { get; set; }

        /// <summary>
        /// 펫2 펫 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_2_auto_skill")]
        public CharacterPetEquipmentAutoSkillDTO Pet2AutoSkill { get; set; }

        /// <summary>
        /// 펫2 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_2_pet_type")]
        public string? Pet2PetType { get; set; }

        /// <summary>
        /// 펫2 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_2_skill")]
        public List<string> Pet2Skill { get; set; }

        /// <summary>
        /// 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("pet_2_date_expire")]
        public DateTimeOffset Pet2DateExpire
        {
            get
            {
                return _pet2DateExpire.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _pet2DateExpire = value;
            }
        }

        private DateTimeOffset _pet2DateExpire;

        /// <summary>
        /// 펫3 명
        /// </summary>
        [JsonProperty("pet_3_name")]
        public string Pet3Name { get; set; }

        /// <summary>
        /// 펫3 닉네임
        /// </summary>
        [JsonProperty("pet_3_nickname")]
        public string Pet3Nickname { get; set; }

        /// <summary>
        /// 펫3 아이콘
        /// </summary>
        [JsonProperty("pet_3_icon")]
        public string Pet3Icon { get; set; }

        /// <summary>
        /// 펫3 설명
        /// </summary>
        [JsonProperty("pet_3_description")]
        public string Pet3Description { get; set; }

        /// <summary>
        /// 펫3 장착 정보
        /// </summary>
        [JsonProperty("pet_3_equipment")]
        public CharacterPetEquipmentItemDTO Pet3Equipment { get; set; }

        /// <summary>
        /// 펫3 펫 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_3_auto_skill")]
        public CharacterPetEquipmentAutoSkillDTO Pet3AutoSkill { get; set; }

        /// <summary>
        /// 펫3 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_3_pet_type")]
        public string? Pet3PetType { get; set; }

        /// <summary>
        /// 펫3 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_3_skill")]
        public List<string> Pet3Skill { get; set; }

        /// <summary>
        /// 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("pet_3_date_expire")]
        public DateTimeOffset Pet3DateExpire
        {
            get
            {
                return _pet3DateExpire.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _pet3DateExpire = value;
            }
        }

        private DateTimeOffset _pet3DateExpire;
    }
}
