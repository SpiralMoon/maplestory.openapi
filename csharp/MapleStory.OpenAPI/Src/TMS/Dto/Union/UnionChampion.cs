using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 聯盟冠軍資訊
    /// </summary>
    public class UnionChampionDTO : Base.UnionChampionDTO<UnionChampionInfoDTO, UnionChampionBadgeInfoDTO>
    {
        /// <summary>
        /// 查詢基準日（TST，以日為單位，時與分一律標示為 0）
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
        /// 聯盟冠軍資訊
        /// </summary>
        [JsonProperty("union_champion")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionChampionInfoDTO> UnionChampion { get; set; } = new();

        /// <summary>
        /// 冠軍徽章效果
        /// </summary>
        [JsonProperty("champion_badge_total_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionChampionBadgeInfoDTO> ChampionBadgeTotalInfo { get; set; } = new();
    }

    /// <summary>
    /// 聯盟冠軍徽章資訊
    /// </summary>
    public class UnionChampionBadgeInfoDTO : Base.UnionChampionBadgeInfoDTO
    {
        /// <summary>
        /// 聯盟冠軍徽章資訊
        /// </summary>
        [JsonProperty("stat")]
        public override string? Stat { get; set; }
    }

    /// <summary>
    /// 聯盟冠軍資訊
    /// </summary>
    public class UnionChampionInfoDTO : Base.UnionChampionInfoDTO<UnionChampionBadgeInfoDTO>
    {
        /// <summary>
        /// 聯盟冠軍角色名稱
        /// </summary>
        [JsonProperty("champion_name")]
        public override string ChampionName { get; set; }

        /// <summary>
        /// 聯盟冠軍欄位
        /// </summary>
        [JsonProperty("champion_slot")]
        public override int ChampionSlot { get; set; }

        /// <summary>
        /// 聯盟冠軍等級
        /// </summary>
        [JsonProperty("champion_grade")]
        public override string ChampionGrade { get; set; }

        /// <summary>
        /// 聯盟冠軍角色職業
        /// </summary>
        [JsonProperty("champion_class")]
        public override string ChampionClass { get; set; }

        /// <summary>
        /// 聯盟冠軍徽章資訊
        /// </summary>
        [JsonProperty("champion_badge_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionChampionBadgeInfoDTO> ChampionBadgeInfo { get; set; } = new();
    }
}
