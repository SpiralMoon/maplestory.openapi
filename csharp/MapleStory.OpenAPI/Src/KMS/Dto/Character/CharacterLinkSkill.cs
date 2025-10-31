using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 링크 스킬 정보
    /// </summary>
    public class CharacterLinkSkillDTO : Base.CharacterLinkSkillDTO<CharacterLinkSkillInfoDTO>
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
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 링크 스킬 정보
        /// </summary>
        [JsonProperty("character_link_skill")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkill { get; set; } = new();

        /// <summary>
        /// 링크 스킬 1번 프리셋 정보
        /// </summary>
        [JsonProperty("character_link_skill_preset_1")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset1 { get; set; } = new();

        /// <summary>
        /// 링크 스킬 2번 프리셋 정보
        /// </summary>
        [JsonProperty("character_link_skill_preset_2")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset2 { get; set; } = new();

        /// <summary>
        /// 링크 스킬 3번 프리셋 정보
        /// </summary>
        [JsonProperty("character_link_skill_preset_3")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterLinkSkillInfoDTO> CharacterLinkSkillPreset3 { get; set; } = new();

        /// <summary>
        /// 내 링크 스킬 정보
        /// </summary>
        [JsonProperty("character_owned_link_skill")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkill { get; set; }

        /// <summary>
        /// 내 링크 스킬 1번 프리셋 정보
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_1")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset1 { get; set; }

        /// <summary>
        /// 내 링크 스킬 2번 프리셋 정보
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_2")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset2 { get; set; }

        /// <summary>
        /// 내 링크 스킬 3번 프리셋 정보
        /// </summary>
        [JsonProperty("character_owned_link_skill_preset_3")]
        public override CharacterLinkSkillInfoDTO? CharacterOwnedLinkSkillPreset3 { get; set; }
    }

    /// <summary>
    /// 캐릭터 링크 스킬 정보
    /// </summary>
    public class CharacterLinkSkillInfoDTO : Base.CharacterLinkSkillInfoDTO
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
        /// 스킬 효과
        /// </summary>
        [JsonProperty("skill_effect")]
        public override string SkillEffect { get; set; }

        /// <summary>
        /// 다음 레벨의 스킬 효과
        /// </summary>
        [JsonProperty("skill_effect_next")]
        public override string? SkillEffectNext { get; set; }

        /// <summary>
        /// 스킬 아이콘
        /// </summary>
        [JsonProperty("skill_icon")]
        public override string SkillIcon { get; set; }
    }
}
