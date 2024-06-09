using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 계정의 보유 캐릭터 목록
    /// </summary>
    public class CharacterListDTO
    {
        /// <summary>
        /// 메이플스토리 계정 목록
        /// </summary>
        [JsonProperty("account_list")]
        public List<CharacterListAccountDTO> AccountList { get; set; }
    }
}
