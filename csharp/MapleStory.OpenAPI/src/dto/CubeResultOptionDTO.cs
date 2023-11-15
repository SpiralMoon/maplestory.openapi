using Newtonsoft.Json;

namespace MapleStory.OpenAPI.src.dto
{
    /// <summary>
    /// 큐브 결과 옵션 정보
    /// </summary>
    public class CubeResultOptionDTO
    {
        /// <summary>
        /// 옵션 이름
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
