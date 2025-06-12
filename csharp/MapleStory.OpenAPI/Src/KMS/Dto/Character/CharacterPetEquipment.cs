using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 펫 장비 정보
    /// </summary>
    public class CharacterPetEquipmentDTO : Base.CharacterPetEquipmentDTO<CharacterPetEquipmentItemDTO, CharacterPetEquipmentAutoSkillDTO>
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
        /// 펫1 명
        /// </summary>
        [JsonProperty("pet_1_name")]
        public override string? Pet1Name { get; set; }

        /// <summary>
        /// 펫1 닉네임
        /// </summary>
        [JsonProperty("pet_1_nickname")]
        public override string? Pet1Nickname { get; set; }

        /// <summary>
        /// 펫1 아이콘
        /// </summary>
        [JsonProperty("pet_1_icon")]
        public override string? Pet1Icon { get; set; }

        /// <summary>
        /// 펫1 설명
        /// </summary>
        [JsonProperty("pet_1_description")]
        public override string? Pet1Description { get; set; }

        /// <summary>
        /// 펫1 장착 정보
        /// </summary>
        [JsonProperty("pet_1_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet1Equipment { get; set; }

        /// <summary>
        /// 펫1 펫 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_1_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet1AutoSkill { get; set; }

        /// <summary>
        /// 펫1 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_1_pet_type")]
        public override string? Pet1PetType { get; set; }

        /// <summary>
        /// 펫1 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_1_skill")]
        public override List<string> Pet1Skill { get; set; }

        /// <summary>
        /// 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        public override DateTimeOffset? Pet1DateExpire
        {
            get
            {
                if (_pet1DateExpire != null && _pet1DateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_pet1DateExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("pet_1_date_expire")]
        private string? _pet1DateExpire;

        /// <summary>
        /// 펫1 마법의 시간 만료 여부
        /// </summary>
        public override bool? Pet1Expired
        {
            get
            {
                if (_pet1DateExpire == null)
                {
                    return null;
                }

                return _pet1DateExpire == "expired";
            }
        }

        /// <summary>
        /// 펫1 외형
        /// </summary>
        [JsonProperty("pet_1_appearance")]
        public override string? Pet1Appearance { get; set; }

        /// <summary>
        /// 펫1 외형 아이콘
        /// </summary>
        [JsonProperty("pet_1_appearance_icon")]
        public override string? Pet1AppearanceIcon { get; set; }

        /// <summary>
        /// 펫2 명
        /// </summary>
        [JsonProperty("pet_2_name")]
        public override string? Pet2Name { get; set; }

        /// <summary>
        /// 펫2 닉네임
        /// </summary>
        [JsonProperty("pet_2_nickname")]
        public override string? Pet2Nickname { get; set; }

        /// <summary>
        /// 펫2 아이콘
        /// </summary>
        [JsonProperty("pet_2_icon")]
        public override string? Pet2Icon { get; set; }

        /// <summary>
        /// 펫2 설명
        /// </summary>
        [JsonProperty("pet_2_description")]
        public override string? Pet2Description { get; set; }

        /// <summary>
        /// 펫2 장착 정보
        /// </summary>
        [JsonProperty("pet_2_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet2Equipment { get; set; }

        /// <summary>
        /// 펫2 펫 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_2_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet2AutoSkill { get; set; }

        /// <summary>
        /// 펫2 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_2_pet_type")]
        public override string? Pet2PetType { get; set; }

        /// <summary>
        /// 펫2 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_2_skill")]
        public override List<string> Pet2Skill { get; set; }

        /// <summary>
        /// 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        public override DateTimeOffset? Pet2DateExpire
        {
            get
            {
                if (_pet2DateExpire != null && _pet2DateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_pet2DateExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("pet_2_date_expire")]
        private string? _pet2DateExpire;

        /// <summary>
        /// 펫2 마법의 시간 만료 여부
        /// </summary>
        public override bool? Pet2Expired
        {
            get
            {
                if (_pet2DateExpire == null)
                {
                    return null;
                }

                return _pet2DateExpire == "expired";
            }
        }

        /// <summary>
        /// 펫2 외형
        /// </summary>
        [JsonProperty("pet_2_appearance")]
        public override string? Pet2Appearance { get; set; }

        /// <summary>
        /// 펫2 외형 아이콘
        /// </summary>
        [JsonProperty("pet_2_appearance_icon")]
        public override string? Pet2AppearanceIcon { get; set; }

        /// <summary>
        /// 펫3 명
        /// </summary>
        [JsonProperty("pet_3_name")]
        public override string? Pet3Name { get; set; }

        /// <summary>
        /// 펫3 닉네임
        /// </summary>
        [JsonProperty("pet_3_nickname")]
        public override string? Pet3Nickname { get; set; }

        /// <summary>
        /// 펫3 아이콘
        /// </summary>
        [JsonProperty("pet_3_icon")]
        public override string? Pet3Icon { get; set; }

        /// <summary>
        /// 펫3 설명
        /// </summary>
        [JsonProperty("pet_3_description")]
        public override string? Pet3Description { get; set; }

        /// <summary>
        /// 펫3 장착 정보
        /// </summary>
        [JsonProperty("pet_3_equipment")]
        public override CharacterPetEquipmentItemDTO? Pet3Equipment { get; set; }

        /// <summary>
        /// 펫3 펫 버프 자동스킬 정보
        /// </summary>
        [JsonProperty("pet_3_auto_skill")]
        public override CharacterPetEquipmentAutoSkillDTO? Pet3AutoSkill { get; set; }

        /// <summary>
        /// 펫3 원더 펫 종류
        /// </summary>
        [JsonProperty("pet_3_pet_type")]
        public override string? Pet3PetType { get; set; }

        /// <summary>
        /// 펫3 펫 보유 스킬
        /// </summary>
        [JsonProperty("pet_3_skill")]
        public override List<string> Pet3Skill { get; set; }

        /// <summary>
        /// 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
        /// </summary>
        public override DateTimeOffset? Pet3DateExpire
        {
            get
            {
                if (_pet3DateExpire != null && _pet3DateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_pet3DateExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("pet_3_date_expire")]
        private string? _pet3DateExpire;

        /// <summary>
        /// 펫3 마법의 시간 만료 여부
        /// </summary>
        public override bool? Pet3Expired
        {
            get
            {
                if (_pet3DateExpire == null)
                {
                    return null;
                }

                return _pet3DateExpire == "expired";
            }
        }

        /// <summary>
        /// 펫3 외형
        /// </summary>
        [JsonProperty("pet_3_appearance")]
        public override string? Pet3Appearance { get; set; }

        /// <summary>
        /// 펫3 외형 아이콘
        /// </summary>
        [JsonProperty("pet_3_appearance_icon")]
        public override string? Pet3AppearanceIcon { get; set; }
    }

    /// <summary>
    /// 캐릭터 펫 장비 자동 스킬 정보
    /// </summary>
    public class CharacterPetEquipmentAutoSkillDTO : Base.CharacterPetEquipmentAutoSkillDTO
    {
        /// <summary>
        /// 첫 번째 슬롯에 등록된 자동 스킬
        /// </summary>
        [JsonProperty("skill_1")]
        public override string? Skill1 { get; set; }

        /// <summary>
        /// 첫 번째 슬롯에 등록된 자동 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_1_icon")]
        public override string? Skill1Icon { get; set; }

        /// <summary>
        /// 두 번째 슬롯에 등록된 자동 스킬
        /// </summary>
        [JsonProperty("skill_2")]
        public override string? Skill2 { get; set; }

        /// <summary>
        /// 두 번째 슬롯에 등록된 자동 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_2_icon")]
        public override string? Skill2Icon { get; set; }
    }

    /// <summary>
    /// 캐릭터 펫 장비 아이템 옵션 정보
    /// </summary>
    public class CharacterPetEquipmentItemOptionDTO : Base.CharacterPetEquipmentItemOptionDTO
    {
        /// <summary>
        /// 옵션 타입
        /// </summary>
        [JsonProperty("option_type")]
        public override string OptionType { get; set; }

        /// <summary>
        /// 옵션 값
        /// </summary>
        [JsonProperty("option_value")]
        public override string OptionValue { get; set; }
    }

    /// <summary>
    /// 캐릭터 펫 장비 아이템 정보
    /// </summary>
    public class CharacterPetEquipmentItemDTO : Base.CharacterPetEquipmentItemDTO<CharacterPetEquipmentItemOptionDTO>
    {
        /// <summary>
        /// 아이템 명
        /// </summary>
        [JsonProperty("item_name")]
        public override string? ItemName { get; set; }

        /// <summary>
        /// 아이템 아이콘
        /// </summary>
        [JsonProperty("item_icon")]
        public override string? ItemIcon { get; set; }

        /// <summary>
        /// 아이템 설명
        /// </summary>
        [JsonProperty("item_description")]
        public override string? ItemDescription { get; set; }

        /// <summary>
        /// 아이템 표기상 옵션
        /// </summary>
        [JsonProperty("item_option")]
        public override List<CharacterPetEquipmentItemOptionDTO> ItemOption { get; set; }

        /// <summary>
        /// 업그레이드 횟수
        /// </summary>
        [JsonProperty("scroll_upgrade")]
        public override int ScrollUpgrade { get; set; }

        /// <summary>
        /// 업그레이드 가능 횟수
        /// </summary>
        [JsonProperty("scroll_upgradable")]
        public override int ScrollUpgradable { get; set; }

        /// <summary>
        /// 아이템 외형
        /// </summary>
        [JsonProperty("item_shape")]
        public override string? ItemShape {  get; set; }

        /// <summary>
        /// 아이템 외형 아이콘
        /// </summary>
        [JsonProperty("item_shape_icon")]
        public override string? ItemShapeIcon { get; set; }
    }
}
