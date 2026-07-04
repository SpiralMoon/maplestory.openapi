using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 스케줄러 정보
    /// </summary>
    public class SchedulerCharacterStateDTO
    {
        /// <summary>
        /// 조회 기준일 (YYYY-MM-DD)
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
        /// 캐릭터 명
        /// </summary>
        [JsonProperty("character_name")]
        public string CharacterName { get; set; }

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public string WorldName { get; set; }

        /// <summary>
        /// 캐릭터 레벨
        /// </summary>
        [JsonProperty("character_level")]
        public long CharacterLevel { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string CharacterClass { get; set; }

        /// <summary>
        /// 일일 콘텐츠 정보
        /// </summary>
        [JsonProperty("daily_contents")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<SchedulerDailyContentDTO> DailyContents { get; set; } = new();

        /// <summary>
        /// 주간 콘텐츠 정보
        /// </summary>
        [JsonProperty("weekly_contents")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<SchedulerWeeklyContentDTO> WeeklyContents { get; set; } = new();

        /// <summary>
        /// 보스 콘텐츠 정보
        /// </summary>
        [JsonProperty("boss_contents")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<SchedulerBossContentDTO> BossContents { get; set; } = new();

        /// <summary>
        /// 주간 보스 처치 완료 횟수
        /// </summary>
        [JsonProperty("weekly_boss_clear_count")]
        public long WeeklyBossClearCount { get; set; }

        /// <summary>
        /// 주간 보스 처치 제한 횟수
        /// </summary>
        [JsonProperty("weekly_boss_clear_limit_count")]
        public long WeeklyBossClearLimitCount { get; set; }
    }

    /// <summary>
    /// 스케줄러 일일 콘텐츠 정보
    /// </summary>
    public class SchedulerDailyContentDTO
    {
        /// <summary>
        /// 콘텐츠/퀘스트 명
        /// </summary>
        [JsonProperty("content_name")]
        public string ContentName { get; set; }

        /// <summary>
        /// 타입 ('contents', 'quest')
        /// </summary>
        [JsonProperty("type")]
        public string Type { get; set; }

        /// <summary>
        /// 인게임 스케줄러 등록 여부 (true/false)
        /// </summary>
        [JsonProperty("registration_flag")]
        public bool RegistrationFlag { get; set; }

        /// <summary>
        /// 현재 완료 횟수/점수
        /// </summary>
        [JsonProperty("now_count")]
        public long NowCount { get; set; }

        /// <summary>
        /// 최대 완료 가능 횟수/점수
        /// </summary>
        [JsonProperty("max_count")]
        public long MaxCount { get; set; }

        /// <summary>
        /// 퀘스트인 경우 진행 상태 ("0":기타, "1":진행 중, "2":완료)
        /// </summary>
        [JsonProperty("quest_state")]
        public string? QuestState { get; set; }
    }

    /// <summary>
    /// 스케줄러 주간 콘텐츠 정보
    /// </summary>
    public class SchedulerWeeklyContentDTO
    {
        /// <summary>
        /// 콘텐츠 명
        /// </summary>
        [JsonProperty("content_name")]
        public string ContentName { get; set; }

        /// <summary>
        /// 콘텐츠 종류 ('contents', 'quest')
        /// </summary>
        [JsonProperty("type")]
        public string Type { get; set; }

        /// <summary>
        /// 인게임 스케줄러 등록 여부 (true/false)
        /// </summary>
        [JsonProperty("registration_flag")]
        public bool RegistrationFlag { get; set; }

        /// <summary>
        /// 현재 완료 횟수/점수
        /// </summary>
        [JsonProperty("now_count")]
        public long NowCount { get; set; }

        /// <summary>
        /// 최대 완료 가능 횟수/점수
        /// </summary>
        [JsonProperty("max_count")]
        public long MaxCount { get; set; }

        /// <summary>
        /// 퀘스트인 경우 진행 상태 ("0":기타, "1":진행 중, "2":완료)
        /// </summary>
        [JsonProperty("quest_state")]
        public string? QuestState { get; set; }
    }

    /// <summary>
    /// 스케줄러 보스 콘텐츠 정보
    /// </summary>
    public class SchedulerBossContentDTO
    {
        /// <summary>
        /// 보스 명
        /// </summary>
        [JsonProperty("content_name")]
        public string ContentName { get; set; }

        /// <summary>
        /// 보스 난이도
        /// </summary>
        [JsonProperty("difficulty")]
        public string Difficulty { get; set; }

        /// <summary>
        /// 보스 초기화 주기
        /// </summary>
        [JsonProperty("cycle")]
        public string Cycle { get; set; }

        /// <summary>
        /// 리스트 순서
        /// </summary>
        [JsonProperty("list_order_no")]
        public long ListOrderNo { get; set; }

        /// <summary>
        /// 인게임 스케줄러 등록 여부 (true/false)
        /// </summary>
        [JsonProperty("registration_flag")]
        public bool RegistrationFlag { get; set; }

        /// <summary>
        /// 완료 여부 (true/false)
        /// </summary>
        [JsonProperty("complete_flag")]
        public bool CompleteFlag { get; set; }
    }
}
