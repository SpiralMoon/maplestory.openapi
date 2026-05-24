using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 연무장 측정 결과 정보
    /// </summary>
    public class BattlePracticeResultDTO
    {
        /// <summary>
        /// 리플레이 등록 일시 (KST)
        /// </summary>
        [JsonProperty("register_date")]
        public DateTimeOffset RegisterDate
        {
            get
            {
                return _registerDate.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _registerDate = value;
            }
        }

        private DateTimeOffset _registerDate;

        /// <summary>
        /// 총 연무 시간 (ms)
        /// </summary>
        [JsonProperty("total_play_time")]
        public long TotalPlayTime { get; set; }

        /// <summary>
        /// 총합 데미지
        /// </summary>
        [JsonProperty("total_damage")]
        public long TotalDamage { get; set; }

        /// <summary>
        /// 초당 평균 데미지
        /// </summary>
        [JsonProperty("total_dps")]
        public long TotalDps { get; set; }

        /// <summary>
        /// 종료 타입 (1:자동 종료, 2:수동 종료, 3:시간 초과, 9:기타 종료)
        /// </summary>
        [JsonProperty("end_type")]
        public string EndType { get; set; }

        /// <summary>
        /// 리플레이 추천 수
        /// </summary>
        [JsonProperty("like_count")]
        public long LikeCount { get; set; }

        /// <summary>
        /// 스킬 단위 전투 분석 정보
        /// </summary>
        [JsonProperty("skill_statistic")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<BattlePracticeSkillStatisticDTO> SkillStatistic { get; set; } = new();
    }

    /// <summary>
    /// 연무장 스킬 단위 전투 분석 정보
    /// </summary>
    public class BattlePracticeSkillStatisticDTO
    {
        /// <summary>
        /// 스킬 명
        /// </summary>
        [JsonProperty("skill_name")]
        public string SkillName { get; set; }

        /// <summary>
        /// 누적 데미지
        /// </summary>
        [JsonProperty("damage")]
        public long Damage { get; set; }

        /// <summary>
        /// 데미지 점유율
        /// </summary>
        [JsonProperty("damage_percent")]
        public string DamagePercent { get; set; }

        /// <summary>
        /// 초당 평균 데미지
        /// </summary>
        [JsonProperty("dps")]
        public long Dps { get; set; }

        /// <summary>
        /// 사용 횟수
        /// </summary>
        [JsonProperty("use_count")]
        public long UseCount { get; set; }

        /// <summary>
        /// 1회당 평균 데미지
        /// </summary>
        [JsonProperty("damage_per_use")]
        public long DamagePerUse { get; set; }

        /// <summary>
        /// 공격 횟수
        /// </summary>
        [JsonProperty("attack_count")]
        public long AttackCount { get; set; }

        /// <summary>
        /// 최대 데미지 (1타)
        /// </summary>
        [JsonProperty("max_damage")]
        public long MaxDamage { get; set; }

        /// <summary>
        /// 최소 데미지 (1타)
        /// </summary>
        [JsonProperty("min_damage")]
        public long MinDamage { get; set; }
    }
}
