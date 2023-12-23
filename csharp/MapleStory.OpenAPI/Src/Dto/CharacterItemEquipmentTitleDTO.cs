using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 칭호 아이템 정보
    /// </summary>
    public class CharacterItemEquipmentTitleDTO
    {
        /// <summary>
        /// 칭호 장비 명
        /// </summary>
        [JsonProperty("title_name")]
        public string TitleName { get; set; }

        /// <summary>
        /// 칭호 아이콘
        /// </summary>
        [JsonProperty("title_icon")]
        public string TitleIcon { get; set; }

        /// <summary>
        /// 칭호 설명
        /// </summary>
        [JsonProperty("title_description")]
        public string TitleDescription { get; set; }

        /// <summary>
        /// 칭호 유효 기간 (KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public string DateExpire { get; set; }

        /// <summary>
        /// 칭호 옵션 유효 기간 (expired:만료, null:무제한) (KST)
        /// </summary>
        [JsonProperty("date_option_expire")]
        public string DateOptionExpire { get; set; }
    }
}
