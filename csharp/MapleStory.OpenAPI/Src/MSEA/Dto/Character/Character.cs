using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character identifier information
    /// </summary>
    public class CharacterDTO : Base.CharacterDTO
    {
        /// <summary>
        /// Character identifier
        /// </summary>
        [JsonProperty("ocid")]

        public override string OCID { get; set; }
    }
}
