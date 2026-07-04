using Newtonsoft.Json;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 萌獸 資訊
    /// </summary>
    public class CharacterFamiliarDTO
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset? Date
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
        /// 萌獸 鏈路插槽資訊
        /// </summary>
        [JsonProperty("familiar_link_slot")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<CharacterFamiliarLinkSlotDTO> FamiliarLinkSlot { get; set; } = new();

        /// <summary>
        /// 萌獸 細節
        /// </summary>
        [JsonProperty("familiar_info")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<CharacterFamiliarInfoDTO> FamiliarInfo { get; set; } = new();
    }

    /// <summary>
    /// 萌獸 鏈路插槽資訊
    /// </summary>
    public class CharacterFamiliarLinkSlotDTO
    {
        /// <summary>
        /// 插槽標識符 (1~3, vip)
        /// </summary>
        [JsonProperty("slot_id")]
        public string SlotId { get; set; }

        /// <summary>
        /// 連結的 萌獸 名稱 (如果插槽中沒有任何關聯，則為 null)
        /// </summary>
        [JsonProperty("familiar_name")]
        public string? FamiliarName { get; set; }

        /// <summary>
        /// 已啟用還是未啟用 (true, false)
        /// </summary>
        [JsonProperty("active_flag")]
        public string ActiveFlag { get; set; }

        /// <summary>
        /// 截止日期
        /// </summary>
        [JsonProperty("expire_date")]
        public DateTimeOffset? ExpireDate
        {
            get
            {
                return _expireDate?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _expireDate = value;
            }
        }

        private DateTimeOffset? _expireDate;
    }

    /// <summary>
    /// 萌獸 細節
    /// </summary>
    public class CharacterFamiliarInfoDTO
    {
        /// <summary>
        /// 萌獸 名稱
        /// </summary>
        [JsonProperty("familiar_name")]
        public string FamiliarName { get; set; }

        /// <summary>
        /// 萌獸 暱稱
        /// </summary>
        [JsonProperty("familiar_nickname")]
        public string FamiliarNickname { get; set; }

        /// <summary>
        /// 特別與否
        /// </summary>
        [JsonProperty("familiar_special_flag")]
        public string FamiliarSpecialFlag { get; set; }

        /// <summary>
        /// 萌獸 情況
        /// </summary>
        [JsonProperty("familiar_state")]
        public string FamiliarState { get; set; }

        /// <summary>
        /// 等級
        /// </summary>
        [JsonProperty("familiar_level")]
        public long FamiliarLevel { get; set; }

        /// <summary>
        /// 經驗
        /// </summary>
        [JsonProperty("familiar_exp")]
        public long FamiliarExp { get; set; }

        /// <summary>
        /// 具備的技能
        /// </summary>
        [JsonProperty("skill_name")]
        public string? SkillName { get; set; }

        /// <summary>
        /// 選項等級
        /// </summary>
        [JsonProperty("option_level")]
        public long OptionLevel { get; set; }

        /// <summary>
        /// 選項訊息
        /// </summary>
        [JsonProperty("option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<CharacterFamiliarInfoOptionDTO> Option { get; set; } = new();

        /// <summary>
        /// 等級
        /// </summary>
        [JsonProperty("familiar_grade")]
        public string FamiliarGrade { get; set; }

        /// <summary>
        /// 外觀名稱
        /// </summary>
        [JsonProperty("look_name")]
        public string? LookName { get; set; }

        /// <summary>
        /// 當前是否已被召喚
        /// </summary>
        [JsonProperty("summoned_flag")]
        public string SummonedFlag { get; set; }

        /// <summary>
        /// 連結槽索引 (1~3, vip, not link)
        /// </summary>
        [JsonProperty("slot_id")]
        public string SlotId { get; set; }
    }

    /// <summary>
    /// 選項訊息
    /// </summary>
    public class CharacterFamiliarInfoOptionDTO
    {
        /// <summary>
        /// 選項號
        /// </summary>
        [JsonProperty("option_no")]
        public long OptionNo { get; set; }

        /// <summary>
        /// 選項名稱
        /// </summary>
        [JsonProperty("option_name")]
        public string OptionName { get; set; }

        /// <summary>
        /// 選擇權價值
        /// </summary>
        [JsonProperty("option_value")]
        public string OptionValue { get; set; }
    }
}
