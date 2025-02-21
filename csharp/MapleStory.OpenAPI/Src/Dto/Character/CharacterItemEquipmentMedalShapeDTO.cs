using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 외형 설정에 등록한 훈장 외형 정보
    /// </summary>
    public class CharacterItemEquipmentMedalShapeDTO
    {
        /// <summary>
        /// 외형 설정에 등록한 훈장 장비 명
        /// </summary>
        [JsonProperty("medal_shape_name")]
        public string MedalShapeName { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장 아이콘
        /// </summary>
        [JsonProperty("medal_shape_icon")]
        public string MedalShapeIcon { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장 설명
        /// </summary>
        [JsonProperty("medal_shape_description")]
        public string MedalShapeDescription { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장의 모루 적용 장비 명
        /// </summary>
        [JsonProperty("medal_shape_changed_name")]
        public string MedalShapeChangedName { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장의 모루 적용 아이콘
        /// </summary>
        [JsonProperty("medal_shape_changed_icon")]
        public string MedalShapeChangedIcon { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 훈장의 모루 적용 훈장 설명
        /// </summary>
        [JsonProperty("medal_shape_changed_description")]
        public string MedalShapeChangedDescription { get; set; }
    }
}
