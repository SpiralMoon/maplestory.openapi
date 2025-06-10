using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 HEXA 스탯 코어 정보
    /// </summary>
    public class CharacterHexaMatrixStatDTO : Base.CharacterHexaMatrixStatDTO<CharacterHexaMatrixStatCoreDTO>
    {
        /// <summary>
        /// 조회 기준일 (KST)
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
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// HEXA 스탯 I 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core")]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore { get; set; }

        /// <summary>
        /// HEXA 스탯 II 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core_2")]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore2 { get; set; }

        /// <summary>
        /// HEXA 스탯 III 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_stat_core_3")]
        public override List<CharacterHexaMatrixStatCoreDTO> CharacterHexaStatCore3 { get; set; }

        /// <summary>
        /// 프리셋 HEXA 스탯 I 코어 정보
        /// </summary>
        [JsonProperty("preset_hexa_stat_core")]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore { get; set; }

        /// <summary>
        /// 프리셋 HEXA 스탯 II 코어 정보
        /// </summary>
        [JsonProperty("preset_hexa_stat_core_2")]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore2 { get; set; }

        /// <summary>
        /// 프리셋 HEXA 스탯 III 코어 정보
        /// </summary>
        [JsonProperty("preset_hexa_stat_core_3")]
        public override List<CharacterHexaMatrixStatCoreDTO> PresetHexaStatCore3 { get; set; }
    }

    /// <summary>
    /// 캐릭터 HEXA 스탯 코어 정보
    /// </summary>
    public class CharacterHexaMatrixStatCoreDTO : Base.CharacterHexaMatrixStatCoreDTO
    {
        /// <summary>
        /// 슬롯 인덱스
        /// </summary>
        [JsonProperty("slot_id")]
        public override string SlotId { get; set; }

        /// <summary>
        /// 메인 스탯 명
        /// </summary>
        [JsonProperty("main_stat_name")]
        public override string MainStatName { get; set; }

        /// <summary>
        /// 첫 번째 서브 명
        /// </summary>
        [JsonProperty("sub_stat_name_1")]
        public override string SubStatName1 { get; set; }

        /// <summary>
        /// 두 번째 서브 명
        /// </summary>
        [JsonProperty("sub_stat_name_2")]
        public override string SubStatName2 { get; set; }

        /// <summary>
        /// 메인 스탯 레벨
        /// </summary>
        [JsonProperty("main_stat_level")]
        public override long MainStatLevel { get; set; }

        /// <summary>
        /// 첫 번째 서브 레벨
        /// </summary>
        [JsonProperty("sub_stat_level_1")]
        public override long SubStatLevel1 { get; set; }

        /// <summary>
        /// 두 번째 서브 레벨
        /// </summary>
        [JsonProperty("sub_stat_level_2")]
        public override long SubStatLevel2 { get; set; }

        /// <summary>
        /// 스탯 코어 등급
        /// </summary>
        [JsonProperty("stat_grade")]
        public override long StatGrade { get; set; }
    }
}
