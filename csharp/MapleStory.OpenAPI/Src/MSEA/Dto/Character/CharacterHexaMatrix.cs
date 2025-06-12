using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character HEXA Node information
    /// </summary>
    public class CharacterHexaMatrixDTO : Base.CharacterHexaMatrixDTO<CharacterHexaMatrixEquipmentDTO>
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
        /// HEXA Node information
        /// </summary>
        [JsonProperty("character_hexa_core_equipment")]
        public override List<CharacterHexaMatrixEquipmentDTO>? CharacterHexaCoreEquipment { get; set; }
    }

    /// <summary>
    /// Linked skill
    /// </summary>
    public class CharacterHexaMatrixEquipmentLinkedSkillDTO : Base.CharacterHexaMatrixEquipmentLinkedSkillDTO
    {
        /// <summary>
        /// HEXA Skill name
        /// </summary>
        [JsonProperty("hexa_skill_id")]
        public override string HexaSkillId { get; set; }
    }

    /// <summary>
    /// HEXA Node information
    /// </summary>
    public class CharacterHexaMatrixEquipmentDTO : Base.CharacterHexaMatrixEquipmentDTO<CharacterHexaMatrixEquipmentLinkedSkillDTO>
    {
        /// <summary>
        /// Node name
        /// </summary>
        [JsonProperty("hexa_core_name")]
        public override string HexaCoreName { get; set; }

        /// <summary>
        /// Node level
        /// </summary>
        [JsonProperty("hexa_core_level")]
        public override long HexaCoreLevel { get; set; }

        /// <summary>
        /// Node type
        /// </summary>
        [JsonProperty("hexa_core_type")]
        public override string HexaCoreType { get; set; }

        /// <summary>
        /// Linked skill
        /// </summary>
        [JsonProperty("linked_skill")]
        public override List<CharacterHexaMatrixEquipmentLinkedSkillDTO> LinkedSkill { get; set; }
    }
}
