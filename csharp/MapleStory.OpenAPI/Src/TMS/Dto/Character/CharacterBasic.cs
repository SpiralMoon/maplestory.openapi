using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色基本資訊
    /// </summary>
    public class CharacterBasicDTO : Base.CharacterBasicDTO
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
        /// 角色名稱
        /// </summary>
        [JsonProperty("character_name")]
        public override string CharacterName { get; set; }

        /// <summary>
        /// 世界名稱
        /// </summary>
        [JsonProperty("world_name")]
        public override string WorldName { get; set; }

        /// <summary>
        /// 角色性別
        /// </summary>
        [JsonProperty("character_gender")]
        public override string CharacterGender { get; set; }

        /// <summary>
        /// 角色職業
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// 角色轉職次數
        /// </summary>
        [JsonProperty("character_class_level")]
        public override string CharacterClassLevel { get; set; }

        /// <summary>
        /// 角色等級
        /// </summary>
        [JsonProperty("character_level")]
        public override long CharacterLevel { get; set; }

        /// <summary>
        /// 當前等級的經驗值
        /// </summary>
        [JsonProperty("character_exp")]
        public override long CharacterExp { get; set; }

        /// <summary>
        /// 當前等級的經驗值百分比
        /// </summary>
        [JsonProperty("character_exp_rate")]
        public override string CharacterExpRate { get; set; }

        /// <summary>
        /// 角色所屬公會的名稱
        /// </summary>
        [JsonProperty("character_guild_name")]
        public override string? CharacterGuildName { get; set; }

        /// <summary>
        /// 角色外型圖片
        /// </summary>
        [JsonProperty("character_image")]
        public override string CharacterImage
        {
            get
            {
                return _characterImage;
            }
            set
            {
                _characterImage = Utils.RemoveQuery(value);
            }
        }

        private string _characterImage;

        /// <summary>
        /// 角色建立日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        /// </summary>
        [JsonProperty("character_date_create")]
        public override DateTimeOffset? CharacterDateCreate
        {
            get
            {
                return _characterDateCreate?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _characterDateCreate = value;
            }
        }

        private DateTimeOffset? _characterDateCreate;

        /// <summary>
        /// 過去 7 天的登入狀態 (true：已登入，false：未登入)
        /// </summary>
        public override bool AccessFlag
        {
            get
            {
                return _accessFlag == "true";
            }
        }

        [JsonProperty("access_flag")]
        private string _accessFlag { get; set; }

        /// <summary>
        /// 解放任務完成狀態 (0：未完成，1：創世武器已解放)
        /// </summary>
        [JsonProperty("liberation_quest_clear")]
        private string LiberationQuestClear { get; set; }
    }
}
