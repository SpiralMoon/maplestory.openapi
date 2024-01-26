using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 잠재능력 재설정 결과 옵션 정보
    /// </summary>
    public class PotentialResultOptionDTO
    {
        /// <summary>
        /// 옵션 명
        /// </summary>
        [JsonProperty("value")]
        public string Value { get; set; }

        /// <summary>
        /// 옵션 등급
        /// </summary>
        [JsonProperty("grade")]
        public string Grade { get; set; }

        public PotentialOptionGrade GradeEnum
        {
            get {
                return Utils.PotentialOptionGradeFromString(this.Grade);
            }
        }
    }
}
