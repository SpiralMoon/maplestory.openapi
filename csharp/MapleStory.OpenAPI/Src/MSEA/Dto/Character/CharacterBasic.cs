using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character basic information
    /// </summary>
    public class CharacterBasicDTO : Base.CharacterBasicDTO
    {
        /// <summary>
        /// Reference date for query (SGT, daily data with hours and minutes set to 0)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(8));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// Character name
        /// </summary>
        [JsonProperty("character_name")]
        public override string CharacterName { get; set; }

        /// <summary>
        /// Character gender
        /// </summary>
        [JsonProperty("world_name")]
        public override string WorldName { get; set; }

        /// <summary>
        /// Character gender
        /// </summary>
        [JsonProperty("character_gender")]
        public override string CharacterGender { get; set; }

        /// <summary>
        /// Character job
        /// </summary>
        [JsonProperty("character_class")]
        public override string CharacterClass { get; set; }

        /// <summary>
        /// Character job advancement tier
        /// </summary>
        [JsonProperty("character_class_level")]
        public override string CharacterClassLevel { get; set; }

        /// <summary>
        /// Character level
        /// </summary>
        [JsonProperty("character_level")]
        public override long CharacterLevel { get; set; }

        /// <summary>
        /// Experience points gained at the current level
        /// </summary>
        [JsonProperty("character_exp")]
        public override long CharacterExp { get; set; }

        /// <summary>
        /// Percentage of experience points at the current level
        /// </summary>
        [JsonProperty("character_exp_rate")]
        public override string CharacterExpRate { get; set; }

        /// <summary>
        /// Guild name the character belongs to
        /// </summary>
        [JsonProperty("character_guild_name")]
        public override string? CharacterGuildName { get; set; }

        /// <summary>
        /// Character appearance image
        /// </summary>
        [JsonProperty("character_image")]
        public override string CharacterImage
        {
            get
            {
                return _characterImage;
            }
            set
            {
                _characterImage = Utils.RemoveQuery(value);
            }
        }

        private string _characterImage;

        /// <summary>
        /// Character creation date (SGT, daily data with hours and minutes set to 0)
        /// </summary>
        [JsonProperty("character_date_create")]
        public override DateTimeOffset? CharacterDateCreate
        {
            get
            {
                return _characterDateCreate?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _characterDateCreate = value;
            }
        }

        private DateTimeOffset? _characterDateCreate;

        /// <summary>
        /// Login status in the past 7 days (true:logged in, false:not logged in)
        /// </summary>
        public override bool AccessFlag
        {
            get
            {
                return _accessFlag == "true";
            }
        }

        [JsonProperty("access_flag")]
        private string _accessFlag { get; set; }

        /// <summary>
        /// Liberation quest completion status (true:completed, false:not completed)
        /// </summary>
        public bool LiberationQuestClearFlag
        {
            get
            {
                return _liberationQuestClearFlag == "true";
            }
        }

        [JsonProperty("liberation_quest_clear_flag")]
        private string _liberationQuestClearFlag { get; set; }
    }
}
