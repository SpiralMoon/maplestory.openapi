using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.TMS.DTO
{
    /// <summary>
    /// 角色辨識器資訊
    /// </summary>
    public class CharacterDTO : Base.CharacterDTO
    {
        /// <summary>
        /// 角色辨識器
        /// </summary>
        [JsonProperty("ocid")]

        public override string OCID { get; set; }
    }
}
