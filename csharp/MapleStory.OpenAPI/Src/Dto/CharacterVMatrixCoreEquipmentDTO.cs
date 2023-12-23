using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 V코어 정보
    /// </summary>
    public class CharacterVMatrixCoreEquipmentDTO
    {
        /// <summary>
        /// 슬롯 인덱스
        /// </summary>
        [JsonProperty("slot_id")]
        public string SlotId { get; set; }

        /// <summary>
        /// 슬롯 레벨
        /// </summary>
        [JsonProperty("slot_level")]
        public long SlotLevel { get; set; }

        /// <summary>
        /// 코어 명
        /// </summary>
        [JsonProperty("v_core_name")]
        public string VCoreName { get; set; }

        /// <summary>
        /// 코어 타입
        /// </summary>
        [JsonProperty("v_core_type")]
        public string VCoreType { get; set; }

        /// <summary>
        /// 코어 레벨
        /// </summary>
        [JsonProperty("v_core_level")]
        public long VCoreLevel { get; set; }

        /// <summary>
        /// 코어에 해당하는 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_1")]
        public string VCoreSkill1 { get; set; }

        /// <summary>
        /// 강화 코어인 경우 코어에 해당하는 두 번째 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_2")]
        public string VCoreSkill2 { get; set; }

        /// <summary>
        /// 강화 코어인 경우 코어에 해당하는 세 번째 스킬 명
        /// </summary>
        [JsonProperty("v_core_skill_3")]
        public string VCoreSkill3 { get; set; }
    }
}
