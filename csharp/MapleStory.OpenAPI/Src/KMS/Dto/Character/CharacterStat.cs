using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 스탯 정보
    /// </summary>
    public class CharacterStatDTO : Base.CharacterStatDTO<CharacterFinalStatDTO>
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
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public override string? CharacterClass { get; set; }

        /// <summary>
        /// 현재 스탯 정보
        /// </summary>
        [JsonProperty("final_stat")]
        public override List<CharacterFinalStatDTO> FinalStat { get; set; }

        /// <summary>
        /// 잔여 AP
        /// </summary>
        [JsonProperty("remain_ap")]
        public override int? RemainAp { get; set; }
    }

    /// <summary>
    /// 캐릭터 최종 스탯 정보
    /// </summary>
    public class CharacterFinalStatDTO : Base.CharacterFinalStatDTO
    {
        /// <summary>
        /// 스탯 명
        /// </summary>
        [JsonProperty("stat_name")]
        public override string StatName { get; set; }

        /// <summary>
        /// 스탯 값
        /// </summary>
        [JsonProperty("stat_value")]
        public override string StatValue { get; set; }
    }
}
