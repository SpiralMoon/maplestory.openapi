using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 큐브히스토리 정보
    /// </summary>
    public class CubeHistoryDTO
    {
        /// <summary>
        /// 큐브 사용 내역에 대한 고유 식별자
        /// </summary>
        [JsonProperty("id")]
        public string Id { get; set; }

        /// <summary>
        /// 캐릭터이름
        /// </summary>
        [JsonProperty("character_name")]
        public string CharacterName { get; set; }

        /// <summary>
        /// 월드 이름
        /// </summary>
        [JsonProperty("world_name")]
        public string WorldName { get; set; }

        /// <summary>
        /// 큐브 사용 날짜
        /// </summary>
        [JsonProperty("create_date")]
        public string CreateDate { get; set; }

        /// <summary>
        /// 사용한 큐브
        /// </summary>
        [JsonProperty("cube_type")]
        public string CubeType { get; set; }

        /// <summary>
        /// 큐브 사용 결과
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
        [JsonProperty("item_equip_part")]
        public string ItemEquipPart { get; set; }

        /// <summary>
        /// 장비 레벨
        /// </summary>
        [JsonProperty("item_level")]
        public int ItemLevel { get; set; }

        /// <summary>
        /// 큐브를 사용한 장비
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
        [JsonProperty("upgradeguarantee")]
        public bool UpgradeGuarantee { get; set; }

        /// <summary>
        /// 현재까지 쌓은 스택
        /// </summary>
        [JsonProperty("upgradeguaranteecount")]
        public int UpgradeGuaranteeCount { get; set; }

        /// <summary>
        /// 큐브 사용 전 잠재능력 옵션
        /// </summary>
        [JsonProperty("before_potential_options")]
        public List<CubeResultOptionDTO> BeforePotentialOptions { get; set; }

        /// <summary>
        /// 큐브 사용 전 에디셔널 잠재능력 옵션
        /// </summary>
        [JsonProperty("before_additional_potential_options")]
        public List<CubeResultOptionDTO> BeforeAdditionalPotentialOptions { get; set; }

        /// <summary>
        /// 큐브 사용 후 잠재능력 옵션
        /// </summary>
        [JsonProperty("after_potential_options")]
        public List<CubeResultOptionDTO> AfterPotentialOptions { get; set; }

        /// <summary>
        /// 큐브 사용 후 에디셔널 잠재능력 옵션
        /// </summary>
        [JsonProperty("after_additional_potential_options")]
        public List<CubeResultOptionDTO> AfterAdditionalPotentialOptions { get; set; }

        /// <summary>
        /// 아이템 업그레이드 여부
        /// </summary>
        public bool IsItemUpgrade
        {
            get
            {
                return this.ItemUpgradeResult == "성공";
            }
        }

        /// <summary>
        /// 미라클 타임 여부
        /// </summary>
        public bool IsMiracleTimeFlag
        {
            get
            {
                return (this.MiracleTimeFlag == "이벤트 적용되지 않음");
            }
        }

        /// <summary>
        /// 잠재능력 등급을 열거형으로 반환
        /// </summary>
        public PotentialOptionGrade PotentialOptionGradeEnum
        {
            get
            {
                return Utils.PotentialOptionGradeFromString(this.PotentialOptionGrade);
            }
        }

        /// <summary>
        /// 추가 잠재능력 등급을 열거형으로 반환
        /// </summary>
        public PotentialOptionGrade AdditionalPotentialOptionGradeEnum
        {
            get
            {
                return Utils.PotentialOptionGradeFromString(this.AdditionalPotentialOptionGrade);
            }
        }
    }
}