using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 기본 정보
    /// </summary>
    public class CharacterBasicDTO : Base.CharacterBasicDTO
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
        /// 캐릭터 명
        /// </summary>
        [JsonProperty("character_name")]
        public override string CharacterName { get; set; }

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public override string WorldName { get; set; }

        /// <summary>
        /// 캐릭터 성별
        /// </summary>
        [JsonProperty("character_gender")]
        public override string CharacterGender { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// 캐릭터 전직 차수
        /// </summary>
        [JsonProperty("character_class_level")]
        public override string CharacterClassLevel { get; set; }

        /// <summary>
        /// 캐릭터 레벨
        /// </summary>
        [JsonProperty("character_level")]
        public override long CharacterLevel { get; set; }

        /// <summary>
        /// 현재 레벨에서 보유한 경험치
        /// </summary>
        [JsonProperty("character_exp")]
        public override long CharacterExp { get; set; }

        /// <summary>
        /// 현재 레벨에서 경험치 퍼센트
        /// </summary>
        [JsonProperty("character_exp_rate")]
        public override string CharacterExpRate { get; set; }

        /// <summary>
        /// 캐릭터 소속 길드 명
        /// </summary>
        [JsonProperty("character_guild_name")]
        public override string? CharacterGuildName { get; set; }

        /// <summary>
        /// 캐릭터 외형 이미지
        /// </summary>
        [JsonProperty("character_image")]
        public override string CharacterImage { get; set; }

        /// <summary>
        /// 캐릭터 생성일
        /// </summary>
        [JsonProperty("character_date_create")]
        public override DateTimeOffset CharacterDateCreate
        {
            get
            {
                return _characterDateCreate.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _characterDateCreate = value;
            }
        }

        private DateTimeOffset _characterDateCreate;

        /// <summary>
        /// 최근 7일간 접속 여부
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
        /// 해방 퀘스트 완료 여부 (0:미완료, 1:제네시스 무기 해방, 2:데스티니 무기 1차 해방)
        /// </summary>
        [JsonProperty("liberation_quest_clear")]
        public string  LiberationQuestClear {  get; set; }
    }
}
