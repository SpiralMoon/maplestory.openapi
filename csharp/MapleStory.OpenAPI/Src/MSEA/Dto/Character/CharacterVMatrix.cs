using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character V Matrix information
    /// </summary>
    public class CharacterVMatrixDTO : Base.CharacterVMatrixDTO<CharacterVMatrixCoreEquipmentDTO>
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get => _date?.ToOffset(TimeSpan.FromHours(8));
            set => _date = value;
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// V Matrix Node information
        /// </summary>
        [JsonProperty("character_v_core_equipment")]
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public override List<CharacterVMatrixCoreEquipmentDTO> CharacterVCoreEquipment { get; set; } = new();

        /// <summary>
        /// Remaining Matrix enhancement points for the character
        /// </summary>
        [JsonProperty("character_v_matrix_remain_slot_upgrade_point")]
        public override int CharacterVMatrixRemainSlotUpgradePoint { get; set; }
    }

    /// <summary>
    /// V Matrix Node information
    /// </summary>
    public class CharacterVMatrixCoreEquipmentDTO : Base.CharacterVMatrixCoreEquipmentDTO
    {
        /// <summary>
        /// Slot index
        /// </summary>
        [JsonProperty("slot_id")]
        public override string SlotId { get; set; }

        /// <summary>
        /// Slot level
        /// </summary>
        [JsonProperty("slot_level")]
        public override long SlotLevel { get; set; }

        /// <summary>
        /// Node name
        /// </summary>
        [JsonProperty("v_core_name")]
        public override string? VCoreName { get; set; }

        /// <summary>
        /// Node type
        /// </summary>
        [JsonProperty("v_core_type")]
        public override string? VCoreType { get; set; }

        /// <summary>
        /// Node level
        /// </summary>
        [JsonProperty("v_core_level")]
        public override long VCoreLevel { get; set; }

        /// <summary>
        /// Name of the skill that corresponds to the node
        /// </summary>
        [JsonProperty("v_core_skill_1")]
        public override string VCoreSkill1 { get; set; }

        /// <summary>
        /// Name of the second skill that corresponds to the node (for Boost Nodes)
        /// </summary>
        [JsonProperty("v_core_skill_2")]
        public override string? VCoreSkill2 { get; set; }

        /// <summary>
        /// Name of the third skill that corresponds to the node (for Boost Nodes)
        /// </summary>
        [JsonProperty("v_core_skill_3")]
        public override string? VCoreSkill3 { get; set; }
    }
}
