using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色目前已裝備的髮型、臉型與膚色資訊
    /// </summary>
    public class CharacterBeautyEquipmentDTO : Base.CharacterBeautyEquipmentDTO<CharacterBeautyEquipmentHairDTO, CharacterBeautyEquipmentFaceDTO, CharacterBeautyEquipmentSkinDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 角色性別
        /// </summary>
        [JsonProperty("character_gender")]
        public override string? CharacterGender { get; set; }

        /// <summary>
        /// 角色職業
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 角色髮型資訊
        /// (神之子為 Alpha、天使破壞者為一般模式時)
        /// </summary>
        [JsonProperty("character_hair")]
        public override CharacterBeautyEquipmentHairDTO? CharacterHair { get; set; }

        /// <summary>
        /// 角色臉型資訊
        /// (神之子為 Alpha、天使破壞者為一般模式時)
        /// </summary>
        [JsonProperty("character_face")]
        public override CharacterBeautyEquipmentFaceDTO? CharacterFace { get; set; }

        /// <summary>
        /// 角色膚色資訊
        /// (神之子為 Alpha、天使破壞者為一般模式時)
        /// </summary>
        [JsonProperty("character_skin")]
        public override CharacterBeautyEquipmentSkinDTO? CharacterSkin { get; set; }

        /// <summary>
        /// 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備髮型資訊
        /// </summary>
        [JsonProperty("additional_character_hair")]
        public override CharacterBeautyEquipmentHairDTO? AdditionalCharacterHair { get; set; }

        /// <summary>
        /// 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備臉型資訊
        /// </summary>
        [JsonProperty("additional_character_face")]
        public override CharacterBeautyEquipmentFaceDTO? AdditionalCharacterFace { get; set; }

        /// <summary>
        /// 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備膚色資訊
        /// </summary>
        [JsonProperty("additional_character_skin")]
        public override CharacterBeautyEquipmentSkinDTO? AdditionalCharacterSkin { get; set; }
    }

    /// <summary>
    /// 角色髮型資訊
    /// </summary>
    public class CharacterBeautyEquipmentHairDTO : Base.CharacterBeautyEquipmentHairDTO
    {
        /// <summary>
        /// 髮型名稱
        /// </summary>
        [JsonProperty("hair_name")]
        public override string HairName { get; set; }

        /// <summary>
        /// 髮型基本顏色
        /// </summary>
        [JsonProperty("base_color")]
        public override string BaseColor { get; set; }

        /// <summary>
        /// 髮型混染顏色
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// 髮型混染顏色比例
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }
    }

    /// <summary>
    /// 角色臉型資訊
    /// </summary>
    public class CharacterBeautyEquipmentFaceDTO : Base.CharacterBeautyEquipmentFaceDTO
    {
        /// <summary>
        /// 臉型名稱
        /// </summary>
        [JsonProperty("face_name")]
        public override string FaceName { get; set; }

        /// <summary>
        /// 臉型基本顏色
        /// </summary>
        [JsonProperty("base_color")]
        public override string BaseColor { get; set; }

        /// <summary>
        /// 臉型混染顏色
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// 臉型混染顏色比例
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }
    }

    /// <summary>
    /// 角色膚色資訊
    /// </summary>
    public class CharacterBeautyEquipmentSkinDTO : Base.CharacterBeautyEquipmentSkinDTO
    {
        /// <summary>
        /// 膚色名稱
        /// </summary>
        [JsonProperty("skin_name")]
        public override string SkinName { get; set; }

        /// <summary>
        /// 色系
        /// </summary>
        [JsonProperty("color_style")]
        public override string? ColorStyle { get; set; }

        /// <summary>
        /// 膚色色調
        /// </summary>
        [JsonProperty("hue")]
        public override int? Hue { get; set; }

        /// <summary>
        /// 膚色彩度
        /// </summary>
        [JsonProperty("saturation")]
        public override int? Saturation { get; set; }

        /// <summary>
        /// 膚色明度
        /// </summary>
        [JsonProperty("brightness")]
        public override int? Brightness { get; set; }
    }
}
