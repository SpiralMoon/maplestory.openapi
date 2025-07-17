using Newtonsoft.Json;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 계정의 업적 목록
    /// </summary>
    public class AchievementDTO
    {
        /// <summary>
        /// 메이플스토리 계정
        /// </summary>
        [JsonProperty("account_list")]
        public List<AchievementAccountListDTO> AccountList { get; set; }
    }

    public class AchievementAccountListDTO
    {
        /// <summary>
        /// 메이플스토리 계정 식별자
        /// </summary>
        [JsonProperty("account_id")]
        public string AccountId { get; set; }

        /// <summary>
        /// 달성 업적 정보
        /// </summary>
        [JsonProperty("achievement_achieve")]
        public List<AchievementAchieveDTO> AchievementAchieve { get; set; }
    }

    public class AchievementAchieveDTO
    {
        /// <summary>
        /// 업적 명
        /// </summary>
        [JsonProperty("achievement_name")]
        public string AchievementName { get; set; }

        /// <summary>
        /// 업적 설명
        /// </summary>
        [JsonProperty("achievement_description")]
        public string AchievementDescription { get; set; }
    }
}
