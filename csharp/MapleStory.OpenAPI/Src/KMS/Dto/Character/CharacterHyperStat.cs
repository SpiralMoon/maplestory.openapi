using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 하이퍼 스탯 정보
    /// </summary>
    public class CharacterHyperStatDTO : Base.CharacterHyperStatDTO<CharacterHyperStatPresetDTO>
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
        /// 적용 중인 프리셋 번호
        /// </summary>
        [JsonProperty("use_preset_no")]
        public override string? UsePresetNo { get; set; }

        /// <summary>
        /// 사용 가능한 최대 하이퍼 스탯 포인트
        /// </summary>
        [JsonProperty("use_available_hyper_stat")]
        public override int? UseAvailableHyperStat { get; set; }

        /// <summary>
        /// 프리셋 1번 하이퍼 스탯 정보
        /// </summary>
        [JsonProperty("hyper_stat_preset_1")]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset1 { get; set; }

        /// <summary>
        /// 프리셋 1번 하이퍼 스탯 잔여 포인트
        /// </summary>
        [JsonProperty("hyper_stat_preset_1_remain_point")]
        public override int? HyperStatPreset1RemainPoint { get; set; }

        /// <summary>
        /// 프리셋 2번 하이퍼 스탯 정보
        /// </summary>
        [JsonProperty("hyper_stat_preset_2")]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset2 { get; set; }

        /// <summary>
        /// 프리셋 2번 하이퍼 스탯 잔여 포인트
        /// </summary>
        [JsonProperty("hyper_stat_preset_2_remain_point")]
        public override int? HyperStatPreset2RemainPoint { get; set; }

        /// <summary>
        /// 프리셋 3번 하이퍼 스탯 정보
        /// </summary>
        [JsonProperty("hyper_stat_preset_3")]
        public override List<CharacterHyperStatPresetDTO> HyperStatPreset3 { get; set; }

        /// <summary>
        /// 프리셋 3번 하이퍼 스탯 잔여 포인트
        /// </summary>
        [JsonProperty("hyper_stat_preset_3_remain_point")]
        public override int? HyperStatPreset3RemainPoint { get; set; }
    }

    /// <summary>
    /// 하이퍼 스탯 프리셋 정보
    /// </summary>
    public class CharacterHyperStatPresetDTO : Base.CharacterHyperStatPresetDTO
    {
        /// <summary>
        /// 스탯 종류
        /// </summary>
        [JsonProperty("stat_type")]
        public override string StatType { get; set; }

        /// <summary>
        /// 스탯 투자 포인트
        /// </summary>
        [JsonProperty("stat_point")]
        public override long? StatPoint { get; set; }

        /// <summary>
        /// 스탯 레벨
        /// </summary>
        [JsonProperty("stat_level")]
        public override long StatLevel { get; set; }

        /// <summary>
        /// 스탯 상승량
        /// </summary>
        [JsonProperty("stat_increase")]
        public override string? StatIncrease { get; set; }
    }
}
