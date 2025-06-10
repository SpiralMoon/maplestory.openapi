using MapleStory.OpenAPI.Common.Enum;
using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.MSEA.DTO
{
    /// <summary>
    /// Character image information
    /// </summary>
    public class CharacterImageDTO : Base.CharacterImageDTO
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
        /// Character image original (URL)
        /// </summary>
        public override string OriginUrl { get; set; }

        /// <summary>
        /// Character image original (base64)
        /// </summary>
        public override string OriginImage { get; set; }

        /// <summary>
        /// Character image (base64)
        /// </summary>
        public override string Image { get; set; }

        /// <summary>
        /// Character action
        /// </summary>
        public override CharacterImageAction Action { get; set; }

        /// <summary>
        /// Character emotion
        /// </summary>
        public override CharacterImageEmotion Emotion { get; set; }

        /// <summary>
        /// Character weapon motion
        /// </summary>
        public override CharacterImageWeaponMotion Wmotion { get; set; }

        /// <summary>
        /// Character action frame
        /// </summary>
        public override int? ActionFrame { get; set; }

        /// <summary>
        /// Character emotion frame
        /// </summary>
        public override int? EmotionFrame { get; set; }

        /// <summary>
        /// Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
        /// </summary>
        public override int Width { get; set; }

        /// <summary>
        /// Vertical length (corresponding to the background size, 96 (default) ~ 1000)
        /// </summary>
        public override int Height { get; set; }

        /// <summary>
        /// Horizontal coordinate of the character
        /// </summary>
        public override int? X { get; set; }

        /// <summary>
        /// Vertical coordinate of the character
        /// </summary>
        public override int? Y { get; set; }
    }
}
