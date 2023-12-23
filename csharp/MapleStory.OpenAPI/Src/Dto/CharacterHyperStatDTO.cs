using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 하이퍼 스탯 정보
    /// </summary>
    public class CharacterHyperStatDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string CharacterClass { get; set; }

        /// <summary>
        /// 적용 중인 프리셋 번호
        /// </summary>
        [JsonProperty("use_preset_no")]
        public string UsePresetNo { get; set; }

        /// <summary>
        /// 사용 가능한 최대 하이퍼 스탯 포인트
        /// </summary>
        [JsonProperty("use_available_hyper_stat")]
        public long UseAvailableHyperStat { get; set; }

        /// <summary>
        /// 프리셋 1번 하이퍼 스탯 정보
        /// </summary>
        [JsonProperty("hyper_stat_preset_1")]
        public List<CharacterHyperStatPresetDTO> HyperStatPreset1 { get; set; }

        /// <summary>
        /// 프리셋 1번 하이퍼 스탯 잔여 포인트
        /// </summary>
        [JsonProperty("hyper_stat_preset_1_remain_point")]
        public long HyperStatPreset1RemainPoint { get; set; }

        /// <summary>
        /// 프리셋 2번 하이퍼 스탯 정보
        /// </summary>
        [JsonProperty("hyper_stat_preset_2")]
        public List<CharacterHyperStatPresetDTO> HyperStatPreset2 { get; set; }

        /// <summary>
        /// 프리셋 2번 하이퍼 스탯 잔여 포인트
        /// </summary>
        [JsonProperty("hyper_stat_preset_2_remain_point")]
        public long HyperStatPreset2RemainPoint { get; set; }

        /// <summary>
        /// 프리셋 3번 하이퍼 스탯 정보
        /// </summary>
        [JsonProperty("hyper_stat_preset_3")]
        public List<CharacterHyperStatPresetDTO> HyperStatPreset3 { get; set; }

        /// <summary>
        /// 프리셋 3번 하이퍼 스탯 잔여 포인트
        /// </summary>
        [JsonProperty("hyper_stat_preset_3_remain_point")]
        public long HyperStatPreset3RemainPoint { get; set; }
    }
}
