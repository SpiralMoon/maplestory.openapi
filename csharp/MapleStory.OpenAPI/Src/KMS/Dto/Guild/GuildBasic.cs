using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 길드 기본 정보
    /// </summary>
    public class GuildBasicDTO : Base.GuildBasicDTO<GuildSkillDTO>
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public override string WorldName { get; set; }

        /// <summary>
        /// 길드 명
        /// </summary>
        [JsonProperty("guild_name")]
        public override string GuildName { get; set; }

        /// <summary>
        /// 길드 레벨
        /// </summary>
        [JsonProperty("guild_level")]
        public override long GuildLevel { get; set; }

        /// <summary>
        /// 길드 명성치
        /// </summary>
        [JsonProperty("guild_fame")]
        public override long GuildFame { get; set; }

        /// <summary>
        /// 길드 포인트(GP)
        /// </summary>
        [JsonProperty("guild_point")]
        public override long GuildPoint { get; set; }

        /// <summary>
        /// 길드 마스터 캐릭터 명
        /// </summary>
        [JsonProperty("guild_master_name")]
        public override string GuildMasterName { get; set; }

        /// <summary>
        /// 길드원 수
        /// </summary>
        [JsonProperty("guild_member_count")]
        public override long GuildMemberCount { get; set; }

        /// <summary>
        /// 길드원 목록
        /// </summary>
        [JsonProperty("guild_member")]
        public override List<string> GuildMember { get; set; }

        /// <summary>
        /// 길드 스킬 목록
        /// </summary>
        [JsonProperty("guild_skill")]
        public override List<GuildSkillDTO> GuildSkill { get; set; }

        /// <summary>
        /// 노블레스 스킬 목록
        /// </summary>
        [JsonProperty("guild_noblesse_skill")]
        public override List<GuildSkillDTO> GuildNoblesseSkill { get; set; }
    }

    /// <summary>
    /// 길드 스킬 정보
    /// </summary>
    public class GuildSkillDTO : Base.GuildSkillDTO
    {
        /// <summary>
        /// 스킬 명
        /// </summary>
        [JsonProperty("skill_name")]
        public override string SkillName { get; set; }

        /// <summary>
        /// 스킬 설명
        /// </summary>
        [JsonProperty("skill_description")]
        public override string SkillDescription { get; set; }

        /// <summary>
        /// 스킬 레벨
        /// </summary>
        [JsonProperty("skill_level")]
        public override long SkillLevel { get; set; }

        /// <summary>
        /// 스킬 레벨 별 효과
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string SkillEffect { get; set; }

        /// <summary>
        /// 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_icon")]
        public override string SkillIcon { get; set; }
    }
}
