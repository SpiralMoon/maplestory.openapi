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
        public DateTimeOffset? DateExpire
        {
            get
            {
                if (_dateExpire != null && _dateExpire != "expired")
                {
                    return DateTimeOffset.Parse(_dateExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("date_expire")]
        private string? _dateExpire { get; set; }

        /// <summary>
        /// 칭호 유효 기간 만료 여부
        /// </summary>
        public bool? IsExpired
        {
            get
            {
                if (_dateExpire == null)
                {
                    return null;
                }

                return _dateExpire == "expired";
            }
        }

        /// <summary>
        /// 칭호 옵션 유효 기간 (KST)
        /// </summary>
        public DateTimeOffset? DateOptionExpire
        {
            get
            {
                if (_dateOptionExpire != null && _dateOptionExpire != "expired")
                {
                    return DateTimeOffset.Parse(_dateOptionExpire).ToOffset(TimeSpan.FromHours(9));
                }

                return null;
            }
        }

        [JsonProperty("date_option_expire")]
        private string? _dateOptionExpire { get; set; }

        /// <summary>
        /// 칭호 옵션 유효 기간 만료 여부
        /// </summary>
        public bool? IsOptionExpired
        {
            get
            {
                if (_dateOptionExpire == null)
                {
                    return null;
                }

                return _dateOptionExpire == "expired";
            }
        }

        /// <summary>
        /// 외형 설정에 등록한 칭호 장비 명
        /// </summary>
        [JsonProperty("title_shape_name")]
        public string? TitleShapeName { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 칭호 아이콘
        /// </summary>
        [JsonProperty("title_shape_icon")]
        public string? TitleShapeIcon { get; set; }

        /// <summary>
        /// 외형 설정에 등록한 칭호 설명
        /// </summary>
        [JsonProperty("title_shape_description")]
        public string? TitleShapeDescription { get; set; }
    }
}
