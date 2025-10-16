using MapleStory.OpenAPI.Common.Enum;
using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色外型圖片資訊
    /// </summary>
    public class CharacterImageDTO : Base.CharacterImageDTO
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
        /// 角色外型圖片原始 (URL)
        /// </summary>
        public override string OriginUrl { get; set; }

        /// <summary>
        /// 角色外型圖片原始 (base64)
        /// </summary>
        public override string OriginImage { get; set; }

        /// <summary>
        /// 角色外型圖片 (base64)
        /// </summary>
        public override string Image { get; set; }

        /// <summary>
        /// 角色動作
        /// </summary>
        public override CharacterImageAction Action { get; set; }

        /// <summary>
        /// 角色表情
        /// </summary>
        public override CharacterImageEmotion Emotion { get; set; }

        /// <summary>
        /// 角色武器動作
        /// </summary>
        public override CharacterImageWeaponMotion Wmotion { get; set; }

        /// <summary>
        /// 角色動作影格
        /// </summary>
        public override int? ActionFrame { get; set; }

        /// <summary>
        /// 角色表情影格
        /// </summary>
        public override int? EmotionFrame { get; set; }

        /// <summary>
        /// 寬度 (對應背景大小，96 (預設) 至 1000)
        /// </summary>
        public override int Width { get; set; }

        /// <summary>
        /// 高度 (對應背景大小，96 (預設) 至 1000)
        /// </summary>
        public override int Height { get; set; }

        /// <summary>
        /// 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
        /// </summary>
        public override int? X { get; set; }

        /// <summary>
        /// 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
        /// </summary>
        public override int? Y { get; set; }
    }
}
