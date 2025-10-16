using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 公會基本資訊
    /// </summary>
    public class GuildBasicDTO : Base.GuildBasicDTO<GuildSkillDTO>
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
        /// 世界名稱
        /// </summary>
        [JsonProperty("world_name")]
        public override string WorldName { get; set; }

        /// <summary>
        /// 公會名稱
        /// </summary>
        [JsonProperty("guild_name")]
        public override string GuildName { get; set; }

        /// <summary>
        /// 公會等級
        /// </summary>
        [JsonProperty("guild_level")]
        public override long GuildLevel { get; set; }

        /// <summary>
        /// 公會名聲值
        /// </summary>
        [JsonProperty("guild_fame")]
        public override long GuildFame { get; set; }

        /// <summary>
        /// 公會點數 (GP)
        /// </summary>
        [JsonProperty("guild_point")]
        public override long GuildPoint { get; set; }

        /// <summary>
        /// 公會會長角色名稱
        /// </summary>
        [JsonProperty("guild_master_name")]
        public override string GuildMasterName { get; set; }

        /// <summary>
        /// 公會成員人數
        /// </summary>
        [JsonProperty("guild_member_count")]
        public override long GuildMemberCount { get; set; }

        /// <summary>
        /// 公會成員清單
        /// </summary>
        [JsonProperty("guild_member")]
        public override List<string> GuildMember { get; set; }

        /// <summary>
        /// 公會技能清單
        /// </summary>
        [JsonProperty("guild_skill")]
        public override List<GuildSkillDTO> GuildSkill { get; set; }

        /// <summary>
        /// 貴族技能清單
        /// </summary>
        [JsonProperty("guild_noblesse_skill")]
        public override List<GuildSkillDTO> GuildNoblesseSkill { get; set; }
    }

    /// <summary>
    /// 公會技能
    /// </summary>
    public class GuildSkillDTO : Base.GuildSkillDTO
    {
        /// <summary>
        /// 技能名稱
        /// </summary>
        [JsonProperty("skill_name")]
        public override string SkillName { get; set; }

        /// <summary>
        /// 技能描述
        /// </summary>
        [JsonProperty("skill_description")]
        public override string SkillDescription { get; set; }

        /// <summary>
        /// 技能等級
        /// </summary>
        [JsonProperty("skill_level")]
        public override long SkillLevel { get; set; }

        /// <summary>
        /// 技能等級的效果
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string SkillEffect { get; set; }

        /// <summary>
        /// 技能圖示
        /// </summary>
        [JsonProperty("skill_icon")]
        public override string SkillIcon { get; set; }
    }
}
