using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 어빌리티 정보
    /// </summary>
    public class CharacterAbilityDTO : Base.CharacterAbilityDTO<CharacterAbilityInfoDTO, CharacterAbilityPresetDTO>
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
        /// 어빌리티 등급
        /// </summary>
        [JsonProperty("ability_grade")]
        public override string? AbilityGrade { get; set; }

        /// <summary>
        /// 어빌리티 정보 리스트
        /// </summary>
        [JsonProperty("ability_info")]
        public override List<CharacterAbilityInfoDTO> AbilityInfo { get; set; }

        /// <summary>
        /// 보유 명성치
        /// </summary>
        [JsonProperty("remain_fame")]
        public override long? RemainFame { get; set; }

        /// <summary>
        /// 적용 중인 어빌리티 프리셋 번호
        /// </summary>
        [JsonProperty("preset_no")]
        public override int? PresetNo { get; set; }

        /// <summary>
        /// 어빌리티 1번 프리셋 전체 정보
        /// </summary>
        [JsonProperty("ability_preset_1")]
        public override CharacterAbilityPresetDTO? AbilityPreset1 { get; set; }

        /// <summary>
        /// 어빌리티 2번 프리셋 전체 정보
        /// </summary>
        [JsonProperty("ability_preset_2")]
        public override CharacterAbilityPresetDTO? AbilityPreset2 { get; set; }

        /// <summary>
        /// 어빌리티 3번 프리셋 전체 정보
        /// </summary>
        [JsonProperty("ability_preset_3")]
        public override CharacterAbilityPresetDTO? AbilityPreset3 { get; set; }
    }

    /// <summary>
    /// 캐릭터 어빌리티 상세 정보
    /// </summary>
    public class CharacterAbilityInfoDTO : Base.CharacterAbilityInfoDTO
    {
        /// <summary>
        /// 어빌리티 번호
        /// </summary>
        [JsonProperty("ability_no")]
        public override string AbilityNo { get; set; }

        /// <summary>
        /// 어빌리티 등급
        /// </summary>
        [JsonProperty("ability_grade")]
        public override string AbilityGrade { get; set; }

        /// <summary>
        /// 어빌리티 옵션 및 수치
        /// </summary>
        [JsonProperty("ability_value")]
        public override string AbilityValue { get; set; }
    }

    /// <summary>
    /// 캐릭터 어빌리티 프리셋 정보
    /// </summary>
    public class CharacterAbilityPresetDTO : Base.CharacterAbilityPresetDTO<CharacterAbilityInfoDTO>
    {
        /// <summary>
        /// 프리셋의 어빌리티 등급
        /// </summary>
        [JsonProperty("ability_preset_grade")]
        public override string AbilityPresetGrade { get; set; }

        /// <summary>
        /// 프리셋의 어빌리티 정보
        /// </summary>
        [JsonProperty("ability_info")]
        public override List<CharacterAbilityInfoDTO> AbilityInfo { get; set; }
    }
}
