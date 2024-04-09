using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 유니온 공격대 정보
    /// </summary>
    public class UnionRaiderDTO
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
        /// 유니온 공격대원 효과
        /// </summary>
        [JsonProperty("union_raider_stat")]
        public List<string> UnionRaiderStat { get; set; }

        /// <summary>
        /// 유니온 공격대 점령 효과
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        public List<string> UnionOccupiedStat { get; set; }

        /// <summary>
        /// 유니온 공격대 배치
        /// </summary>
        [JsonProperty("union_inner_stat")]
        public List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; }

        /// <summary>
        /// 유니온 블록 정보
        /// </summary>
        [JsonProperty("union_block")]
        public List<UnionRaiderBlockDTO> UnionBlock { get; set; }

        /// <summary>
        /// 적용 중인 프리셋 번호
        /// </summary>
        [JsonProperty("use_preset_no")]
        public int UsePresetNo { get; set; }

        /// <summary>
        /// 유니온 프리셋 1번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_1")]
        public UnionRaiderPresetDTO? UnionRaiderPreset1 { get; set; }

        /// <summary>
        /// 유니온 프리셋 2번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_2")]
        public UnionRaiderPresetDTO? UnionRaiderPreset2 { get; set; }

        /// <summary>
        /// 유니온 프리셋 3번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_3")]
        public UnionRaiderPresetDTO? UnionRaiderPreset3 { get; set; }

        /// <summary>
        /// 유니온 프리셋 4번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_4")]
        public UnionRaiderPresetDTO? UnionRaiderPreset4 { get; set; }

        /// <summary>
        /// 유니온 프리셋 5번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_5")]
        public UnionRaiderPresetDTO? UnionRaiderPreset5 { get; set; }
    }
}
