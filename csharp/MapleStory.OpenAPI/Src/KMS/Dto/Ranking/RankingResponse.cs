using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    public class RankingResponseDTO<RankingDTO>
    {
        [JsonConverter(typeof(NullAsEmptyConverter))]
        public List<RankingDTO> Ranking { get; set; } = new();
    }
}
