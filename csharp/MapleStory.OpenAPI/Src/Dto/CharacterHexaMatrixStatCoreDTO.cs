using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 HEXA 스탯 코어 정보
    /// </summary>
    public class CharacterHexaMatrixStatCoreDTO
    {
        /// <summary>
        /// 슬롯 인덱스
        /// </summary>
        [JsonProperty("slot_id")]
        public string SlotId { get; set; }

        /// <summary>
        /// 메인 스탯 명
        /// </summary>
        [JsonProperty("main_stat_name")]
        public string MainStatName { get; set; }

        /// <summary>
        /// 첫 번째 서브 명
        /// </summary>
        [JsonProperty("sub_stat_name_1")]
        public string SubStatName1 { get; set; }

        /// <summary>
        /// 두 번째 서브 명
        /// </summary>
        [JsonProperty("sub_stat_name_2")]
        public string SubStatName2 { get; set; }

        /// <summary>
        /// 메인 스탯 레벨
        /// </summary>
        [JsonProperty("main_stat_level")]
        public long MainStatLevel { get; set; }

        /// <summary>
        /// 첫 번째 서브 레벨
        /// </summary>
        [JsonProperty("sub_stat_level_1")]
        public long SubStatLevel1 { get; set; }

        /// <summary>
        /// 두 번째 서브 레벨
        /// </summary>
        [JsonProperty("sub_stat_level_2")]
        public long SubStatLevel2 { get; set; }

        /// <summary>
        /// 스탯 코어 등급
        /// </summary>
        [JsonProperty("stat_grade")]
        public long StatGrade { get; set; }
    }
}
