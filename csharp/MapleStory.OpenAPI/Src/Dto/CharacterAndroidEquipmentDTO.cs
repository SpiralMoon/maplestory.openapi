using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 안드로이드 장비 정보
    /// </summary>
    public class CharacterAndroidEquipmentDTO
    {
        /// <summary>
        /// 조회 기준일 (KST)
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// 안드로이드 명
        /// </summary>
        [JsonProperty("android_name")]
        public string? AndroidName { get; set; }

        /// <summary>
        /// 안드로이드 닉네임
        /// </summary>
        [JsonProperty("android_nickname")]
        public string? AndroidNickname { get; set; }

        /// <summary>
        /// 안드로이드 아이콘
        /// </summary>
        [JsonProperty("android_icon")]
        public string? AndroidIcon { get; set; }

        /// <summary>
        /// 안드로이드 아이템 설명
        /// </summary>
        [JsonProperty("android_description")]
        public string? AndroidDescription { get; set; }

        /// <summary>
        /// 안드로이드 헤어 정보
        /// </summary>
        [JsonProperty("android_hair")]
        public CharacterAndroidEquipmentHairDTO AndroidHair { get; set; }

        /// <summary>
        /// 안드로이드 성형 정보
        /// </summary>
        [JsonProperty("android_face")]
        public CharacterAndroidEquipmentFaceDTO AndroidFace { get; set; }

        /// <summary>
        /// 안드로이드 피부 명
        /// </summary>
        [JsonProperty("android_skin_name")]
        public string? AndroidSkinName { get; set; }

        /// <summary>
        /// 안드로이드 캐시 아이템 장착 정보
        /// </summary>
        [JsonProperty("android_cash_item_equipment")]
        public List<CharacterAndroidCashItemEquipmentDTO> AndroidCashItemEquipment { get; set; }

        /// <summary>
        /// 안드로이드 이어센서 클립 적용 여부
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public string? AndroidEarSensorClipFlag { get; set; }
    }
}
