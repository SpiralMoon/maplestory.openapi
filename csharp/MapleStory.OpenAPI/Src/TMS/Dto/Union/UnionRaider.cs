using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 戰地攻擊隊資訊
    /// </summary>
    public class UnionRaiderDTO : Base.UnionRaiderDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO, UnionRaiderPresetDTO>
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
        /// 戰地攻擊隊員效果
        /// </summary>
        [JsonProperty("union_raider_stat")]
        public override List<string> UnionRaiderStat { get; set; }

        /// <summary>
        /// 戰地攻擊隊佔領效果
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        public override List<string> UnionOccupiedStat { get; set; }

        /// <summary>
        /// 戰地攻擊隊部署
        /// </summary>
        [JsonProperty("union_inner_stat")]
        public override List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; }

        /// <summary>
        /// 聯盟方塊資訊
        /// </summary>
        [JsonProperty("union_block")]
        public override List<UnionRaiderBlockDTO> UnionBlock { get; set; }

        /// <summary>
        /// 目前套用的預設編號
        /// </summary>
        [JsonProperty("use_preset_no")]
        public override int UsePresetNo { get; set; }

        /// <summary>
        /// 聯盟預設 1 資訊
        /// </summary>
        [JsonProperty("union_raider_preset_1")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset1 { get; set; }

        /// <summary>
        /// 聯盟預設 2 資訊
        /// </summary>
        [JsonProperty("union_raider_preset_2")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset2 { get; set; }

        /// <summary>
        /// 聯盟預設 3 資訊
        /// </summary>
        [JsonProperty("union_raider_preset_3")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset3 { get; set; }

        /// <summary>
        /// 聯盟預設 4 資訊
        /// </summary>
        [JsonProperty("union_raider_preset_4")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset4 { get; set; }

        /// <summary>
        /// 聯盟預設 5 資訊
        /// </summary>
        [JsonProperty("union_raider_preset_5")]
        public override UnionRaiderPresetDTO? UnionRaiderPreset5 { get; set; }
    }

    /// <summary>
    /// 方塊基準點座標
    /// </summary>
    public class UnionRaiderBlockControlPointDTO : Base.UnionRaiderBlockControlPointDTO
    {
        /// <summary>
        /// 方塊基準點 x 座標
        /// </summary>
        [JsonProperty("x")]
        public override long X { get; set; }

        /// <summary>
        /// 方塊基準點 y 座標
        /// </summary>
        [JsonProperty("y")]
        public override long Y { get; set; }
    }

    /// <summary>
    /// 方塊佔領區域的座標
    /// </summary>
    public class UnionRaiderBlockPositionDTO : Base.UnionRaiderBlockPositionDTO
    {
        /// <summary>
        /// 方塊 x 座標
        /// </summary>
        [JsonProperty("x")]
        public override long X { get; set; }

        /// <summary>
        /// 方塊 y 座標
        /// </summary>
        [JsonProperty("y")]
        public override long Y { get; set; }
    }

    /// <summary>
    /// 聯盟方塊資訊
    /// </summary>
    public class UnionRaiderBlockDTO : Base.UnionRaiderBlockDTO<UnionRaiderBlockControlPointDTO, UnionRaiderBlockPositionDTO>
    {
        /// <summary>
        /// 方塊編制 (戰士、法師、弓箭手、盜賊、海盜、混合)
        /// </summary>
        [JsonProperty("block_type")]
        public override string BlockType { get; set; }

        /// <summary>
        /// 方塊角色職業
        /// </summary>
        [JsonProperty("block_class")]
        public override string BlockClass { get; set; }

        /// <summary>
        /// 方塊角色等級
        /// </summary>
        [JsonProperty("block_level")]
        public override string BlockLevel { get; set; }

        /// <summary>
        /// 方塊基準點座標
        /// </summary>
        [JsonProperty("block_control_point")]
        public override UnionRaiderBlockControlPointDTO BlockControlPoint { get; set; }

        /// <summary>
        /// 方塊佔領區域的座標 (null：未部署時)
        /// </summary>
        [JsonProperty("block_position")]
        public override List<UnionRaiderBlockPositionDTO> BlockPosition { get; set; }
    }

    /// <summary>
    /// 戰地攻擊隊部署
    /// </summary>
    public class UnionRaiderInnerStatDTO : Base.UnionRaiderInnerStatDTO
    {
        /// <summary>
        /// 攻擊單位部署位置 (以 11 點鐘方向為起點，順時針 0-7)
        /// </summary>
        [JsonProperty("stat_field_id")]
        public override string StatFieldId { get; set; }

        /// <summary>
        /// 相關區域佔領效果
        /// </summary>
        [JsonProperty("stat_field_effect")]
        public override string StatFieldEffect { get; set; }
    }

    /// <summary>
    /// 聯盟預設 資訊
    /// </summary>
    public class UnionRaiderPresetDTO : Base.UnionRaiderPresetDTO<UnionRaiderInnerStatDTO, UnionRaiderBlockDTO>
    {
        /// <summary>
        /// 戰地攻擊隊員效果
        /// </summary>
        [JsonProperty("union_raider_stat")]
        public override List<string> UnionRaiderStat { get; set; }

        /// <summary>
        /// 戰地攻擊隊佔領效果
        /// </summary>
        [JsonProperty("union_occupied_stat")]
        public override List<string> UnionOccupiedStat { get; set; }

        /// <summary>
        /// 戰地攻擊隊部署
        /// </summary>
        [JsonProperty("union_inner_stat")]
        public override List<UnionRaiderInnerStatDTO> UnionInnerStat { get; set; }

        /// <summary>
        /// 聯盟方塊資訊
        /// </summary>
        [JsonProperty("union_block")]
        public override List<UnionRaiderBlockDTO> UnionBlock { get; set; }
    }
}
