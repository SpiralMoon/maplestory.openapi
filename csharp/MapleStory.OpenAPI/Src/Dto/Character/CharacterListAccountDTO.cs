using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 메이플스토리 계정
    /// </summary>
    public class CharacterListAccountDTO
    {
        /// <summary>
        /// 메이플스토리 계정 식별자
        /// </summary>
        [JsonProperty("account_id")]
        public string AccountId { get; set; }

        /// <summary>
        /// 캐릭터 목록
        /// </summary>
        [JsonProperty("character_list")]
        public List<CharacterListAccountCharacterDTO> CharacterList { get; set; }
    }
}
