using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色目前套用的套裝效果資訊
    /// </summary>
    public class CharacterSetEffectDTO : Base.CharacterSetEffectDTO<CharacterSetEffectSetDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
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
        /// 套裝效果資訊
        /// </summary>
        [JsonProperty("set_effect")]
        public override List<CharacterSetEffectSetDTO> SetEffect { get; set; }
    }

    /// <summary>
    /// 目前已裝備的套裝效果資訊
    /// </summary>
    public class CharacterSetEffectInfoDTO : Base.CharacterSetEffectInfoDTO
    {
        /// <summary>
        /// 套裝效果等級 (裝備件數)
        /// </summary>
        [JsonProperty("set_count")]
        public override int SetCount { get; set; }

        /// <summary>
        /// 套裝效果
        /// </summary>
        [JsonProperty("set_option")]
        public override string SetOption { get; set; }
    }

    /// <summary>
    /// 全部套裝效果資訊
    /// </summary>
    public class CharacterSetEffectOptionFullDTO : Base.CharacterSetEffectOptionFullDTO
    {
        /// <summary>
        /// 套裝效果等級 (裝備件數)
        /// </summary>
        [JsonProperty("set_count")]
        public override int SetCount { get; set; }

        /// <summary>
        /// 套裝效果
        /// </summary>
        [JsonProperty("set_option")]
        public override string SetOption { get; set; }
    }

    /// <summary>
    /// 套裝效果資訊
    /// </summary>
    public class CharacterSetEffectSetDTO : Base.CharacterSetEffectSetDTO<CharacterSetEffectInfoDTO, CharacterSetEffectOptionFullDTO>
    {
        /// <summary>
        /// 套裝效果名稱
        /// </summary>
        [JsonProperty("set_name")]
        public override string SetName { get; set; }

        /// <summary>
        /// 套裝件數 (包含幸運道具)
        /// </summary>
        [JsonProperty("total_set_count")]
        public override long TotalSetCount { get; set; }

        /// <summary>
        /// 目前已裝備的套裝效果資訊
        /// </summary>
        [JsonProperty("set_effect_info")]
        public override List<CharacterSetEffectInfoDTO> SetEffectInfo { get; set; }

        /// <summary>
        /// 全部套裝效果資訊
        /// </summary>
        [JsonProperty("set_option_full")]
        public override List<CharacterSetEffectOptionFullDTO> SetOptionFull { get; set; }
    }
}
