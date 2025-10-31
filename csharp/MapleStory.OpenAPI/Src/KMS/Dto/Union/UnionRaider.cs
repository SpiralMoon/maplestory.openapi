using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 유니온 공격대 정보
    /// </summary>
    public class UnionRaiderDTO : Base.UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO>
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
        /// 유니온 공격대원 효과
        /// </summary>
        [JsonProperty("union_raider_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> UnionRaiderStat { get; set; } = new();

        /// <summary>
        /// 유니온 공격대 점령 효과
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> UnionOccupiedStat { get; set; } = new();

        /// <summary>
        /// 유니온 공격대 배치
        /// </summary>
        [JsonProperty("union_inner_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; } = new();

        /// <summary>
        /// 유니온 블록 정보
        /// </summary>
        [JsonProperty("union_block")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderBlockDTO> UnionBlock { get; set; } = new();

        /// <summary>
        /// 적용 중인 프리셋 번호
        /// </summary>
        [JsonProperty("use_preset_no")]
        public override int UsePresetNo { get; set; }

        /// <summary>
        /// 유니온 프리셋 1번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_1")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset1 { get; set; }

        /// <summary>
        /// 유니온 프리셋 2번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_2")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset2 { get; set; }

        /// <summary>
        /// 유니온 프리셋 3번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_3")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset3 { get; set; }

        /// <summary>
        /// 유니온 프리셋 4번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_4")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset4 { get; set; }

        /// <summary>
        /// 유니온 프리셋 5번 정보
        /// </summary>
        [JsonProperty("union_raider_preset_5")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset5 { get; set; }
    }

    /// <summary>
    /// 유니온 블록 기준점 좌표 정보
    /// </summary>
    public class UnionRaiderBlockControlPointDTO : Base.UnionRaiderBlockControlPointDTO
    {
        /// <summary>
        /// 블록 기준점 X좌표
        /// </summary>
        [JsonProperty("x")]
        public override long X { get; set; }

        /// <summary>
        /// 블록 기준점 Y좌표
        /// </summary>
        [JsonProperty("y")]
        public override long Y { get; set; }
    }

    /// <summary>
    /// 유니온 블록이 차지하고 있는 영역 좌표들
    /// </summary>
    public class UnionRaiderBlockPositionDTO : Base.UnionRaiderBlockPositionDTO
    {
        /// <summary>
        /// 블록 X좌표
        /// </summary>
        [JsonProperty("x")]
        public override long X { get; set; }

        /// <summary>
        /// 블록 Y좌표
        /// </summary>
        [JsonProperty("y")]
        public override long Y { get; set; }
    }

    /// <summary>
    /// 유니온 블록 정보
    /// </summary>
    public class UnionRaiderBlockDTO : Base.UnionRaiderBlockDTO<UnionRaiderBlockControlPointDTO, UnionRaiderBlockPositionDTO>
    {
        /// <summary>
        /// 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
        /// </summary>
        [JsonProperty("block_type")]
        public override string BlockType { get; set; }

        /// <summary>
        /// 블록 해당 캐릭터 직업
        /// </summary>
        [JsonProperty("block_class")]
        public override string BlockClass { get; set; }

        /// <summary>
        /// 블록 해당 캐릭터 레벨
        /// </summary>
        [JsonProperty("block_level")]
        public override string BlockLevel { get; set; }

        /// <summary>
        /// 블록 기준점 좌표
        /// </summary>
        [JsonProperty("block_control_point")]
        public override UnionRaiderBlockControlPointDTO BlockControlPoint { get; set; }

        /// <summary>
        /// 블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
        /// </summary>
        [JsonProperty("block_position")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderBlockPositionDTO> BlockPosition { get; set; } = new();
    }

    /// <summary>
    /// 유니온 공격대 배치 정보
    /// </summary>
    public class UnionRaiderInnerStatDTO : Base.UnionRaiderInnerStatDTO
    {
        /// <summary>
        /// 공격대 배치 위치 (11시 방향부터 시계 방향 순서대로 0~7)
        /// </summary>
        [JsonProperty("stat_field_id")]
        public override string StatFieldId { get; set; }

        /// <summary>
        /// 해당 지역 점령 효과
        /// </summary>
        [JsonProperty("stat_field_effect")]
        public override string StatFieldEffect { get; set; }
    }

    /// <summary>
    /// 유니온 프리셋 정보
    /// </summary>
    public class UnionRaiderPresetDTO : Base.UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO>
    {
        /// <summary>
        /// 유니온 공격대원 효과
        /// </summary>
        [JsonProperty("union_raider_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> UnionRaiderStat { get; set; } = new();

        /// <summary>
        /// 유니온 공격대 점령 효과
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> UnionOccupiedStat { get; set; } = new();

        /// <summary>
        /// 유니온 공격대 배치
        /// </summary>
        [JsonProperty("union_inner_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; } = new();

        /// <summary>
        /// 유니온 블록 정보
        /// </summary>
        [JsonProperty("union_block")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderBlockDTO> UnionBlock { get; set; } = new();
    }
}