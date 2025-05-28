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

    /// <summary>
    /// 유니온 블록 기준점 좌표 정보
    /// </summary>
    public class UnionRaiderBlockControlPointDTO
    {
        /// <summary>
        /// 블록 기준점 X좌표
        /// </summary>
        [JsonProperty("x")]
        public long X { get; set; }

        /// <summary>
        /// 블록 기준점 Y좌표
        /// </summary>
        [JsonProperty("y")]
        public long Y { get; set; }
    }

    /// <summary>
    /// 유니온 블록이 차지하고 있는 영역 좌표들
    /// </summary>
    public class UnionRaiderBlockPositionDTO
    {
        /// <summary>
        /// 블록 X좌표
        /// </summary>
        [JsonProperty("x")]
        public long X { get; set; }

        /// <summary>
        /// 블록 Y좌표
        /// </summary>
        [JsonProperty("y")]
        public long Y { get; set; }
    }

    /// <summary>
    /// 유니온 블록 정보
    /// </summary>
    public class UnionRaiderBlockDTO
    {
        /// <summary>
        /// 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
        /// </summary>
        [JsonProperty("block_type")]
        public string BlockType { get; set; }

        /// <summary>
        /// 블록 해당 캐릭터 직업
        /// </summary>
        [JsonProperty("block_class")]
        public string BlockClass { get; set; }

        /// <summary>
        /// 블록 해당 캐릭터 레벨
        /// </summary>
        [JsonProperty("block_level")]
        public string BlockLevel { get; set; }

        /// <summary>
        /// 블록 기준점 좌표
        /// </summary>
        [JsonProperty("block_control_point")]
        public UnionRaiderBlockControlPointDTO BlockControlPoint { get; set; }

        /// <summary>
        /// 블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
        /// </summary>
        [JsonProperty("block_position")]
        public List<UnionRaiderBlockPositionDTO> BlockPosition { get; set; }
    }

    /// <summary>
    /// 유니온 공격대 배치 정보
    /// </summary>
    public class UnionRaiderInnerStatDTO
    {
        /// <summary>
        /// 공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
        /// </summary>
        [JsonProperty("stat_field_id")]
        public string StatFieldId { get; set; }

        /// <summary>
        /// 해당 지역 점령 효과
        /// </summary>
        [JsonProperty("stat_field_effect")]
        public string StatFieldEffect { get; set; }
    }

    /// <summary>
    /// 유니온 프리셋 정보
    /// </summary>
    public class UnionRaiderPresetDTO
    {
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
    }
}
