using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Union raider information
    /// </summary>
    public class UnionRaiderDTO : Base.UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO>
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// Union raid member effects
        /// </summary>
        [JsonProperty("union_raider_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> UnionRaiderStat { get; set; } = new();

        /// <summary>
        /// Union raid capture effects
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> UnionOccupiedStat { get; set; } = new();

        /// <summary>
        /// Union raider deployment
        /// </summary>
        [JsonProperty("union_inner_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; } = new();

        /// <summary>
        /// Union Legion Block
        /// </summary>
        [JsonProperty("union_block")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderBlockDTO> UnionBlock { get; set; } = new();

        /// <summary>
        /// Number of the preset currently in use
        /// </summary>
        [JsonProperty("use_preset_no")]
        public override int UsePresetNo { get; set; }

        /// <summary>
        /// Information for Union Preset 1
        /// </summary>
        [JsonProperty("union_raider_preset_1")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset1 { get; set; }

        /// <summary>
        /// Information for Union Preset 2
        /// </summary>
        [JsonProperty("union_raider_preset_2")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset2 { get; set; }

        /// <summary>
        /// Information for Union Preset 3
        /// </summary>
        [JsonProperty("union_raider_preset_3")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset3 { get; set; }

        /// <summary>
        /// Information for Union Preset 4
        /// </summary>
        [JsonProperty("union_raider_preset_4")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset4 { get; set; }

        /// <summary>
        /// Information for Union Preset 5
        /// </summary>
        [JsonProperty("union_raider_preset_5")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset5 { get; set; }
    }

    /// <summary>
    /// Coordinates of the block's reference point
    /// </summary>
    public class UnionRaiderBlockControlPointDTO : Base.UnionRaiderBlockControlPointDTO
    {
        /// <summary>
        /// Block reference point X-coordinate
        /// </summary>
        [JsonProperty("x")]
        public override long X { get; set; }

        /// <summary>
        /// Block reference point Y-coordinate
        /// </summary>
        [JsonProperty("y")]
        public override long Y { get; set; }
    }

    /// <summary>
    /// Coordinates of the area occupied by the block
    /// </summary>
    public class UnionRaiderBlockPositionDTO : Base.UnionRaiderBlockPositionDTO
    {
        /// <summary>
        /// Block X-coordinate
        /// </summary>
        [JsonProperty("x")]
        public override long X { get; set; }

        /// <summary>
        /// Block Y-coordinate
        /// </summary>
        [JsonProperty("y")]
        public override long Y { get; set; }
    }

    /// <summary>
    /// Union Legion Block information
    /// </summary>
    public class UnionRaiderBlockDTO : Base.UnionRaiderBlockDTO<UnionRaiderBlockControlPointDTO, UnionRaiderBlockPositionDTO>
    {
        /// <summary>
        /// Block shapes (Warrior, Magician, Bowman, Thief, Pirate, Maple M, Hybrid)
        /// </summary>
        [JsonProperty("block_type")]
        public override string BlockType { get; set; }

        /// <summary>
        /// Character class corresponding to the block
        /// </summary>
        [JsonProperty("block_class")]
        public override string BlockClass { get; set; }

        /// <summary>
        /// Character level corresponding to the block
        /// </summary>
        [JsonProperty("block_level")]
        public override string BlockLevel { get; set; }

        /// <summary>
        /// Coordinates of the block's reference point
        /// </summary>
        [JsonProperty("block_control_point")]
        public override UnionRaiderBlockControlPointDTO BlockControlPoint { get; set; }

        /// <summary>
        /// Coordinates of the area occupied by the block (null if not placed)
        /// </summary>
        [JsonProperty("block_position")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderBlockPositionDTO> BlockPosition { get; set; } = new();
    }

    /// <summary>
    /// Union raider deployment information
    /// </summary>
    public class UnionRaiderInnerStatDTO : Base.UnionRaiderInnerStatDTO
    {
        /// <summary>
        /// Raider deployment position (0 to 7, clockwise from 11 o'clock)
        /// </summary>
        [JsonProperty("stat_field_id")]
        public override string StatFieldId { get; set; }

        /// <summary>
        /// Occupation effects over the area
        /// </summary>
        [JsonProperty("stat_field_effect")]
        public override string StatFieldEffect { get; set; }
    }

    /// <summary>
    /// Union preset information
    /// </summary>
    public class UnionRaiderPresetDTO : Base.UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO>
    {
        /// <summary>
        /// Union raid member effects
        /// </summary>
        [JsonProperty("union_raider_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> UnionRaiderStat { get; set; } = new();

        /// <summary>
        /// Union raid capture effects
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<string> UnionOccupiedStat { get; set; } = new();

        /// <summary>
        /// Union raider deployment
        /// </summary>
        [JsonProperty("union_inner_stat")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; } = new();

        /// <summary>
        /// Information about Legion Blocks
        /// </summary>
        [JsonProperty("union_block")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<UnionRaiderBlockDTO> UnionBlock { get; set; } = new();
    }
}
