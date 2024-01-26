using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 안드로이드 프리셋 정보
    /// </summary>
    public class CharacterAndroidEquipmentPresetDTO
    {
        /// <summary>
        /// 안드로이드 명
        /// </summary>
        [JsonProperty("android_name")]
        public string AndroidName { get; set; }

        /// <summary>
        /// 안드로이드 닉네임
        /// </summary>
        [JsonProperty("android_nickname")]
        public string AndroidNickname { get; set; }

        /// <summary>
        /// 안드로이드 아이콘
        /// </summary>
        [JsonProperty("android_icon")]
        public string AndroidIcon { get; set; }

        /// <summary>
        /// 안드로이드 아이템 설명
        /// </summary>
        [JsonProperty("android_description")]
        public string AndroidDescription { get; set; }

        /// <summary>
        /// 안드로이드 성별
        /// </summary>
        [JsonProperty("android_gender")]
        public string? AndroidGender { get; set; }

        /// <summary>
        /// 안드로이드 등급
        /// </summary>
        [JsonProperty("android_grade")]
        public string AndroidGrade { get; set; }

        /// <summary>
        /// 안드로이드 피부 명
        /// </summary>
        [JsonProperty("android_skin_name")]
        public string AndroidSkinName { get; set; }

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
        /// 안드로이드 이어센서 클립 적용 여부
        /// </summary>
        [JsonProperty("android_ear_sensor_clip_flag")]
        public string AndroidEarSensorClipFlag { get; set; }

        /// <summary>
        /// 비인간형 안드로이드 여부
        /// </summary>
        [JsonProperty("android_non_humanoid_flag")]
        public string AndroidNonHumanoidFlag { get; set; }

        /// <summary>
        /// 잡화상점 기능 이용 가능 여부
        /// </summary>
        [JsonProperty("android_shop_usable_flag")]
        public string AndroidShopUsableFlag { get; set; }
    }
}
