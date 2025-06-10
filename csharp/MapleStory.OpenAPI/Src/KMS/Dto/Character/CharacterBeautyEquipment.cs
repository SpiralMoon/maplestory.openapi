using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 헤어, 성형, 피부 정보
    /// </summary>
    public class CharacterBeautyEquipmentDTO : Base.CharacterBeautyEquipmentDTO<CharacterBeautyEquipmentHairDTO, CharacterBeautyEquipmentFaceDTO, CharacterBeautyEquipmentSkinDTO>
    {
        /// <summary>
        /// 조회 기준일 (KST)
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
        /// 캐릭터 성별
        /// </summary>
        [JsonProperty("character_gender")]
        public override string? CharacterGender { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 캐릭터 헤어 정보
        /// (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
        /// </summary>
        [JsonProperty("character_hair")]
        public override CharacterBeautyEquipmentHairDTO? CharacterHair { get; set; }

        /// <summary>
        /// 캐릭터 성형 정보
        /// (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
        /// </summary>
        [JsonProperty("character_face")]
        public override CharacterBeautyEquipmentFaceDTO? CharacterFace { get; set; }

        /// <summary>
        /// 캐릭터 피부 정보
        /// (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
        /// </summary>
        [JsonProperty("character_skin")]
        public override CharacterBeautyEquipmentSkinDTO? CharacterSkin { get; set; }

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 헤어 정보
        /// </summary>
        [JsonProperty("additional_character_hair")]
        public override CharacterBeautyEquipmentHairDTO? AdditionalCharacterHair { get; set; }

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 성형 정보
        /// </summary>
        [JsonProperty("additional_character_face")]
        public override CharacterBeautyEquipmentFaceDTO? AdditionalCharacterFace { get; set; }

        /// <summary>
        /// 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 피부 정보
        /// </summary>
        [JsonProperty("additional_character_skin")]
        public override CharacterBeautyEquipmentSkinDTO? AdditionalCharacterSkin { get; set; }
    }

    /// <summary>
    /// 캐릭터 헤어 정보
    /// </summary>
    public class CharacterBeautyEquipmentHairDTO : Base.CharacterBeautyEquipmentHairDTO
    {
        /// <summary>
        /// 헤어 명
        /// </summary>
        [JsonProperty("hair_name")]
        public override string HairName { get; set; }

        /// <summary>
        /// 헤어 베이스 컬러
        /// </summary>
        [JsonProperty("base_color")]
        public override string BaseColor { get; set; }

        /// <summary>
        /// 헤어 믹스 컬러
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// 헤어 믹스 컬러의 염색 비율
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }
    }

    /// <summary>
    /// 캐릭터 성형 정보
    /// </summary>
    public class CharacterBeautyEquipmentFaceDTO : Base.CharacterBeautyEquipmentFaceDTO
    {
        /// <summary>
        /// 성형 명
        /// </summary>
        [JsonProperty("face_name")]
        public override string FaceName { get; set; }

        /// <summary>
        /// 성형 베이스 컬러
        /// </summary>
        [JsonProperty("base_color")]
        public override string BaseColor { get; set; }

        /// <summary>
        /// 성형 믹스 컬러
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// 성형 믹스 컬러의 염색 비율
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }
    }

    /// <summary>
    /// 캐릭터 피부 정보
    /// </summary>
    public class CharacterBeautyEquipmentSkinDTO : Base.CharacterBeautyEquipmentSkinDTO
    {
        /// <summary>
        /// 피부 명
        /// </summary>
        [JsonProperty("skin_name")]
        public override string SkinName { get; set; }

        /// <summary>
        /// 색상 계열
        /// </summary>
        [JsonProperty("color_style")]
        public override string? ColorStyle { get; set; }

        /// <summary>
        /// 피부 색조
        /// </summary>
        [JsonProperty("hue")]
        public override int? Hue { get; set; }

        /// <summary>
        /// 피부 채도
        /// </summary>
        [JsonProperty("saturation")]
        public override int? Saturation { get; set; }

        /// <summary>
        /// 피부 명도
        /// </summary>
        [JsonProperty("brightness")]
        public override int? Brightness { get; set; }
    }
}
