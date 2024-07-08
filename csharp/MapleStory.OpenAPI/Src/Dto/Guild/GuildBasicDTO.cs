using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 길드 기본 정보
    /// </summary>
    public class GuildBasicDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset? Date
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
        public string WorldName { get; set; }

        /// <summary>
        /// 길드 명
        /// </summary>
        [JsonProperty("guild_name")]
        public string GuildName { get; set; }

        /// <summary>
        /// 길드 레벨
        /// </summary>
        [JsonProperty("guild_level")]
        public long GuildLevel { get; set; }

        /// <summary>
        /// 길드 명성치
        /// </summary>
        [JsonProperty("guild_fame")]
        public long GuildFame { get; set; }

        /// <summary>
        /// 길드 포인트(GP)
        /// </summary>
        [JsonProperty("guild_point")]
        public long GuildPoint { get; set; }

        /// <summary>
        /// 길드 마스터 캐릭터 명
        /// </summary>
        [JsonProperty("guild_master_name")]
        public string GuildMasterName { get; set; }

        /// <summary>
        /// 길드원 수
        /// </summary>
        [JsonProperty("guild_member_count")]
        public long GuildMemberCount { get; set; }

        /// <summary>
        /// 길드원 목록
        /// </summary>
        [JsonProperty("guild_member")]
        public List<string> GuildMember { get; set; }

        /// <summary>
        /// 길드 스킬 목록
        /// </summary>
        [JsonProperty("guild_skill")]
        public List<GuildSkillDTO> GuildSkill { get; set; }

        /// <summary>
        /// 노블레스 스킬 목록
        /// </summary>
        [JsonProperty("guild_noblesse_skill")]
        public List<GuildSkillDTO> GuildNoblesseSkill { get; set; }
    }
}
