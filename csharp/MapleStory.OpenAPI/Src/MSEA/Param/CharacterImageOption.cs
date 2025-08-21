using MapleStory.OpenAPI.Common.Enum;
using Base = MapleStory.OpenAPI.Common.Param;

namespace MapleStory.OpenAPI.MSEA.Param
{
    public class CharacterImageOption : Base.CharacterImageOption
    {
        /// <summary>
        /// Character action
        /// </summary>
        public override CharacterImageAction Action { get; set; } = CharacterImageAction.Stand1;

        /// <summary>
        /// Character emotion
        /// </summary>
        public override CharacterImageEmotion Emotion { get; set; } = CharacterImageEmotion.Default;

        /// <summary>
        /// Character weapon motion
        /// </summary>
        public override CharacterImageWeaponMotion Wmotion { get; set; } = CharacterImageWeaponMotion.Default;

        /// <summary>
        /// Character action frame
        /// </summary>
        public override int ActionFrame { get; set; } = 0;

        /// <summary>
        /// Character emotion frame
        /// </summary>
        public override int EmotionFrame { get; set; } = 0;

        /// <summary>
        /// Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
        /// </summary>
        public int Width { get; set; } = 96;

        /// <summary>
        /// Vertical length (corresponding to the background size, 96 (default) ~ 1000)
        /// </summary>
        public int Height { get; set; } = 96;

        /// <summary>
        /// Horizontal coordinate of the character (coordinate range 0 < x < width, 0 is the left starting point)
        /// </summary>
        public int? X { get; set; }

        /// <summary>
        /// Vertical coordinate of the character (coordinate range 0 < y < height, 0 is the top starting point)
        /// </summary>
        public int? Y { get; set; }
    }
}
