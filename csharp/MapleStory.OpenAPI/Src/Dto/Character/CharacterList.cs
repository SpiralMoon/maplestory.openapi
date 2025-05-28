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

    /// <summary>
    /// 캐릭터 정보
    /// </summary>
    public class CharacterListAccountCharacterDTO
    {
        /// <summary>
        /// 캐릭터 식별자
        /// </summary>
        [JsonProperty("ocid")]
        public string OCID { get; set; }

        /// <summary>
        /// 캐릭터 명
        /// </summary>
        [JsonProperty("character_name")]
        public string CharacterName { get; set; }

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public string WorldName { get; set; }

        /// <summary>
        /// 캐릭터 직업
        /// </summary>
        [JsonProperty("character_class")]
        public string CharacterClass { get; set; }

        /// <summary>
        /// 캐릭터 레벨
        /// </summary>
        [JsonProperty("character_level")]
        public int CharacterLevel { get; set; }
    }

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
