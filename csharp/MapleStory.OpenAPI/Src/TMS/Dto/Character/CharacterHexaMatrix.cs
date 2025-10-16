using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色已裝備於 HEXA 矩陣的 HEXA 核心資訊
    /// </summary>
    public class CharacterHexaMatrixDTO : Base.CharacterHexaMatrixDTO<CharacterHexaMatrixEquipmentDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
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
        /// HEXA 核心資訊
        /// </summary>
        [JsonProperty("character_hexa_core_equipment")]
        public override List<CharacterHexaMatrixEquipmentDTO>? CharacterHexaCoreEquipment { get; set; }
    }

    /// <summary>
    /// 已連接的技能
    /// </summary>
    public class CharacterHexaMatrixEquipmentLinkedSkillDTO : Base.CharacterHexaMatrixEquipmentLinkedSkillDTO
    {
        /// <summary>
        /// HEXA 技能名稱
        /// </summary>
        [JsonProperty("hexa_skill_id")]
        public override string HexaSkillId { get; set; }
    }

    /// <summary>
    /// HEXA 核心資訊
    /// </summary>
    public class CharacterHexaMatrixEquipmentDTO : Base.CharacterHexaMatrixEquipmentDTO<CharacterHexaMatrixEquipmentLinkedSkillDTO>
    {
        /// <summary>
        /// 核心名稱
        /// </summary>
        [JsonProperty("hexa_core_name")]
        public override string HexaCoreName { get; set; }

        /// <summary>
        /// 核心等級
        /// </summary>
        [JsonProperty("hexa_core_level")]
        public override long HexaCoreLevel { get; set; }

        /// <summary>
        /// 核心類型
        /// </summary>
        [JsonProperty("hexa_core_type")]
        public override string HexaCoreType { get; set; }

        /// <summary>
        /// 已連接的技能
        /// </summary>
        [JsonProperty("linked_skill")]
        public override List<CharacterHexaMatrixEquipmentLinkedSkillDTO> LinkedSkill { get; set; }
    }
}
