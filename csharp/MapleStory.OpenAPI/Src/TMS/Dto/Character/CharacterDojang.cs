using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色在武陵道場的最高紀錄資訊
    /// </summary>
    public class CharacterDojangDTO : Base.CharacterDojangDTO
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
        /// 世界名稱
        /// </summary>
        [JsonProperty("world_name")]
        public override string? WorldName { get; set; }

        /// <summary>
        /// 武陵道場最高紀錄層數
        /// </summary>
        [JsonProperty("dojang_best_floor")]
        public override int? DojangBestFloor { get; set; }

        /// <summary>
        /// 達成武陵道場最高紀錄的日期 (TST，每日資料的小時與分鐘顯示為 0)
        /// </summary>
        [JsonProperty("date_dojang_record")]
        public override DateTimeOffset? DateDojangRecord
        {
            get
            {
                return _dateDojangRecord?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _dateDojangRecord = value;
            }
        }

        private DateTimeOffset? _dateDojangRecord;

        /// <summary>
        /// 通關武陵道場最高樓層所花費的時間 (秒)
        /// </summary>
        [JsonProperty("dojang_best_time")]
        public override int? DojangBestTime { get; set; }
    }
}
