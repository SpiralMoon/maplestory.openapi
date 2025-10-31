using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色綜合能力值資訊
    /// </summary>
    public class CharacterStatDTO : Base.CharacterStatDTO<CharacterFinalStatDTO>
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
        /// 角色職業
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 當前能力值資訊
        /// </summary>
        [JsonProperty("final_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterFinalStatDTO> FinalStat { get; set; } = new();

        /// <summary>
        /// 剩餘 AP
        /// </summary>
        [JsonProperty("remain_ap")]
        public override int? RemainAp { get; set; }
    }

    /// <summary>
    /// 當前能力值資訊
    /// </summary>
    public class CharacterFinalStatDTO : Base.CharacterFinalStatDTO
    {
        /// <summary>
        /// 能力值名稱
        /// </summary>
        [JsonProperty("stat_name")]
        public override string StatName { get; set; }

        /// <summary>
        /// 能力值數值
        /// </summary>
        [JsonProperty("stat_value")]
        public override string StatValue { get; set; }
    }
}
