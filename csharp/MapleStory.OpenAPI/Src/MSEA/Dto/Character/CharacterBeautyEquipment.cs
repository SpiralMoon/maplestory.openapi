using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character equipped hair, face, and skin information
    /// </summary>
    public class CharacterBeautyEquipmentDTO : Base.CharacterBeautyEquipmentDTO<CharacterBeautyEquipmentHairDTO, CharacterBeautyEquipmentFaceDTO, CharacterBeautyEquipmentSkinDTO>
    {
        /// <summary>
        /// Reference date for query (SGT)
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
        /// Character gender
        /// </summary>
        [JsonProperty("character_gender")]
        public override string? CharacterGender { get; set; }

        /// <summary>
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// Character hair information
        /// (Alpha mode for Zero, Normal mode for Angelic Buster)
        /// </summary>
        [JsonProperty("character_hair")]
        public override CharacterBeautyEquipmentHairDTO? CharacterHair { get; set; }

        /// <summary>
        /// Character face information
        /// (Alpha mode for Zero, Normal mode for Angelic Buster)
        /// </summary>
        [JsonProperty("character_face")]
        public override CharacterBeautyEquipmentFaceDTO? CharacterFace { get; set; }

        /// <summary>
        /// Character skin information
        /// (Alpha mode for Zero, Normal mode for Angelic Buster)
        /// </summary>
        [JsonProperty("character_skin")]
        public override CharacterBeautyEquipmentSkinDTO? CharacterSkin { get; set; }

        /// <summary>
        /// Hair information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
        /// </summary>
        [JsonProperty("additional_character_hair")]
        public override CharacterBeautyEquipmentHairDTO? AdditionalCharacterHair { get; set; }

        /// <summary>
        /// Face information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
        /// </summary>
        [JsonProperty("additional_character_face")]
        public override CharacterBeautyEquipmentFaceDTO? AdditionalCharacterFace { get; set; }

        /// <summary>
        /// Skin information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
        /// </summary>
        [JsonProperty("additional_character_skin")]
        public override CharacterBeautyEquipmentSkinDTO? AdditionalCharacterSkin { get; set; }
    }

    /// <summary>
    /// Character hair information
    /// </summary>
    public class CharacterBeautyEquipmentHairDTO : Base.CharacterBeautyEquipmentHairDTO
    {
        /// <summary>
        /// Hair name
        /// </summary>
        [JsonProperty("hair_name")]
        public override string HairName { get; set; }

        /// <summary>
        /// Base hair color
        /// </summary>
        [JsonProperty("base_color")]
        public override string BaseColor { get; set; }

        /// <summary>
        /// Mixed hair color
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// Dye ratio for mixed hair color
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }
    }

    /// <summary>
    /// Character face information
    /// </summary>
    public class CharacterBeautyEquipmentFaceDTO : Base.CharacterBeautyEquipmentFaceDTO
    {
        /// <summary>
        /// Face name
        /// </summary>
        [JsonProperty("face_name")]
        public override string FaceName { get; set; }

        /// <summary>
        /// Base face color
        /// </summary>
        [JsonProperty("base_color")]
        public override string BaseColor { get; set; }

        /// <summary>
        /// Mixed face color
        /// </summary>
        [JsonProperty("mix_color")]
        public override string? MixColor { get; set; }

        /// <summary>
        /// Dye ratio for mixed face color
        /// </summary>
        [JsonProperty("mix_rate")]
        public override string MixRate { get; set; }
    }

    /// <summary>
    /// Character skin information
    /// </summary>
    public class CharacterBeautyEquipmentSkinDTO : Base.CharacterBeautyEquipmentSkinDTO
    {
        /// <summary>
        /// Skin name
        /// </summary>
        [JsonProperty("skin_name")]
        public override string SkinName { get; set; }

        /// <summary>
        /// Color style
        /// </summary>
        [JsonProperty("color_style")]
        public override string? ColorStyle { get; set; }

        /// <summary>
        /// Skin hue
        /// </summary>
        [JsonProperty("hue")]
        public override int? Hue { get; set; }

        /// <summary>
        /// Skin saturation
        /// </summary>
        [JsonProperty("saturation")]
        public override int? Saturation { get; set; }

        /// <summary>
        /// Skin brightness
        /// </summary>
        [JsonProperty("brightness")]
        public override int? Brightness { get; set; }
    }
}
