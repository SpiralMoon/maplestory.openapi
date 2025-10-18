using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色 V 矩陣欄位資訊與已裝備 V 核心資訊
    /// </summary>
    public class CharacterVMatrixDTO : Base.CharacterVMatrixDTO<CharacterVMatrixCoreEquipmentDTO>
    {
        /// <summary>
        /// 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get => _date?.ToOffset(TimeSpan.FromHours(8));
            set => _date = value;
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 角色職業
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// V 核心資訊
        /// </summary>
        [JsonProperty("character_v_core_equipment")]
        public override List<CharacterVMatrixCoreEquipmentDTO> CharacterVCoreEquipment { get; set; }

        /// <summary>
        /// 角色剩餘的矩陣強化點數
        /// </summary>
        [JsonProperty("character_v_matrix_remain_slot_upgrade_point")]
        public override int? CharacterVMatrixRemainSlotUpgradePoint { get; set; }
    }

    /// <summary>
    /// V 核心資訊
    /// </summary>
    public class CharacterVMatrixCoreEquipmentDTO : Base.CharacterVMatrixCoreEquipmentDTO
    {
        /// <summary>
        /// 欄位索引
        /// </summary>
        [JsonProperty("slot_id")]
        public override string SlotId { get; set; }

        /// <summary>
        /// 欄位等級
        /// </summary>
        [JsonProperty("slot_level")]
        public override long SlotLevel { get; set; }

        /// <summary>
        /// 核心名稱
        /// </summary>
        [JsonProperty("v_core_name")]
        public override string? VCoreName { get; set; }

        /// <summary>
        /// 核心類型
        /// </summary>
        [JsonProperty("v_core_type")]
        public override string? VCoreType { get; set; }

        /// <summary>
        /// 核心等級
        /// </summary>
        [JsonProperty("v_core_level")]
        public override long VCoreLevel { get; set; }

        /// <summary>
        /// 對應核心的技能名稱
        /// </summary>
        [JsonProperty("v_core_skill_1")]
        public override string VCoreSkill1 { get; set; }

        /// <summary>
        /// (若為強化核心) 對應核心的第二個技能名稱
        /// </summary>
        [JsonProperty("v_core_skill_2")]
        public override string? VCoreSkill2 { get; set; }

        /// <summary>
        /// (若為強化核心) 對應核心的第三個技能名稱
        /// </summary>
        [JsonProperty("v_core_skill_3")]
        public override string? VCoreSkill3 { get; set; }
    }
}
