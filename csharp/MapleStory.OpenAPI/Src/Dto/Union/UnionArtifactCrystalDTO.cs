using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Src.Dto.Union
{
    /// <summary>
    /// 유니온 아티팩트 크리스탈 정보
    /// </summary>
    public class UnionArtifactCrystalDTO
    {
        /// <summary>
        /// 아티팩트 효과 명
        /// </summary>
        [JsonProperty("name")]
        public string Name { get; set; }

        /// <summary>
        /// 능력치 유효 여부 (0:유효, 1:유효하지 않음)
        /// </summary>
        [JsonProperty("validity_flag")]
        public string ValidityFlag { get; set; }

        /// <summary>
        /// 능력치 유효 기간(KST)
        /// </summary>
        [JsonProperty("date_expire")]
        public DateTimeOffset DateExpire
        {
            get
            {
                return _dateExpire.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateExpire = value;
            }
        }

        private DateTimeOffset _dateExpire;

        /// <summary>
        /// 아티팩트 크리스탈 등급
        /// </summary>
        [JsonProperty("level")]
        public int Level { get; set; }

        /// <summary>
        /// 아티팩트 크리스탈 첫 번째 옵션 명
        /// </summary>
        [JsonProperty("crystal_option_name_1")]
        public string CrystalOptionName1 { get; set; }

        /// <summary>
        /// 아티팩트 크리스탈 두 번째 옵션 명
        /// </summary>
        [JsonProperty("crystal_option_name_2")]
        public string CrystalOptionName2 { get; set; }

        /// <summary>
        /// 아티팩트 크리스탈 세 번째 옵션 명
        /// </summary>
        [JsonProperty("crystal_option_name_3")]
        public string CrystalOptionName3 { get; set; }
    }
}
