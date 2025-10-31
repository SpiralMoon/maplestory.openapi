using MapleStory.OpenAPI.Common.Enum;
using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 큐브 히스토리
    /// </summary>
    public class CubeHistoryDTO
    {
        /// <summary>
        /// 큐브 히스토리 식별자
        /// </summary>
        [JsonProperty("id")]
        public string Id { get; set; }

        /// <summary>
        /// 캐릭터 명
        /// </summary>
        [JsonProperty("character_name")]
        public string CharacterName { get; set; }

        /// <summary>
        /// 사용 일시
        /// </summary>
        [JsonProperty("date_create")]
        public DateTimeOffset DateCreate
        { 
            get
            {
                return _dateCreate.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateCreate = value;
            }
        }

        private DateTimeOffset _dateCreate;

        /// <summary>
        /// 사용 큐브
        /// </summary>
        [JsonProperty("cube_type")]
        public string CubeType { get; set; }

        /// <summary>
        /// 사용 결과
        /// </summary>
        [JsonProperty("item_upgrade_result")]
        public string ItemUpgradeResult { get; set; }

        /// <summary>
        /// 미라클 타임 적용 여부
        /// </summary>
        [JsonProperty("miracle_time_flag")]
        public string MiracleTimeFlag { get; set; }

        /// <summary>
        /// 장비 분류
        /// </summary>
        [JsonProperty("item_equipment_part")]
        public string itemEquipmentPart { get; set; }

        /// <summary>
        /// 장비 레벨
        /// </summary>
        [JsonProperty("item_level")]
        public int ItemLevel { get; set; }

        /// <summary>
        /// 큐브 사용한 장비
        /// </summary>
        [JsonProperty("target_item")]
        public string TargetItem { get; set; }

        /// <summary>
        /// 잠재능력 등급
        /// </summary>
        [JsonProperty("potential_option_grade")]
        public string PotentialOptionGrade { get; set; }

        /// <summary>
        /// 에디셔널 잠재능력 등급
        /// </summary>
        [JsonProperty("additional_potential_option_grade")]
        public string AdditionalPotentialOptionGrade { get; set; }

        /// <summary>
        /// 천장에 도달하여 확정 등급 상승한 여부
        /// </summary>
        [JsonProperty("upgradeGuarantee")]
        public bool UpgradeGuarantee { get; set; }

        /// <summary>
        /// 현재까지 쌓은 스택
        /// </summary>
        [JsonProperty("upgradeGuaranteeCount")]
        public int UpgradeGuaranteeCount { get; set; }

        /// <summary>
        /// 사용 전 잠재능력 옵션
        /// </summary>
        [JsonProperty("before_potential_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<CubeResultOptionDTO> BeforePotentialOption { get; set; } = new();

        /// <summary>
        /// 사용 전 에디셔널 잠재능력 옵션
        /// </summary>
        [JsonProperty("before_additional_potential_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<CubeResultOptionDTO> BeforeAdditionalPotentialOption { get; set; } = new();

        /// <summary>
        /// 사용 후 잠재능력 옵션
        /// </summary>
        [JsonProperty("after_potential_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<CubeResultOptionDTO> AfterPotentialOption { get; set; } = new();

        /// <summary>
        /// 사용 후 에디셔널 잠재능력 옵션
        /// </summary>
        [JsonProperty("after_additional_potential_option")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<CubeResultOptionDTO> AfterAdditionalPotentialOption { get; set; } = new();

        /// <summary>
        /// 아이템 업그레이드 여부
        /// </summary>
        public bool IsItemUpgrade
        {
            get
            {
                return ItemUpgradeResult == "성공";
            }
        }

        /// <summary>
        /// 미라클 타임 여부
        /// </summary>
        public bool IsMiracleTimeFlag
        {
            get
            {
                return MiracleTimeFlag == "이벤트 적용되지 않음";
            }
        }

        /// <summary>
        /// 잠재능력 등급을 열거형으로 반환
        /// </summary>
        public PotentialOptionGrade PotentialOptionGradeEnum
        {
            get
            {
                return Utils.PotentialOptionGradeFromString(PotentialOptionGrade);
            }
        }

        /// <summary>
        /// 추가 잠재능력 등급을 열거형으로 반환
        /// </summary>
        public PotentialOptionGrade AdditionalPotentialOptionGradeEnum
        {
            get
            {
                return Utils.PotentialOptionGradeFromString(AdditionalPotentialOptionGrade);
            }
        }
    }

    /// <summary>
    /// 큐브 결과 옵션 정보
    /// </summary>
    public class CubeResultOptionDTO
    {
        /// <summary>
        /// 옵션 명
        /// </summary>
        [JsonProperty("value")]
        public string Value { get; set; }

        /// <summary>
        /// 옵션 등급
        /// </summary>
        [JsonProperty("grade")]
        public string Grade { get; set; }

        public PotentialOptionGrade GradeEnum
        {
            get
            {
                return Utils.PotentialOptionGradeFromString(Grade);
            }
        }
    }

    /// <summary>
    /// 큐브 히스토리 응답 정보
    /// </summary>
    public class CubeHistoryResponseDTO
    {
        /// <summary>
        /// 결과 건 수
        /// </summary>
        [JsonProperty("count")]
        public int Count;

        /// <summary>
        /// 큐브 히스토리
        /// </summary>
        [JsonProperty("cube_history")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<CubeHistoryDTO> CubeHistory = new();

        /// <summary>
        /// 페이징 처리를 위한 cursor
        /// </summary>
        [JsonProperty("next_cursor")]
        public string? NextCursor;
    }
}