using MapleStory.OpenAPI.Common.Enum;

namespace MapleStory.OpenAPI.Common.Param
{
    public abstract class CharacterImageOption
    {
        /// <summary>
        /// Character action
        /// </summary>
        public abstract CharacterImageAction Action { get; set; }

        /// <summary>
        /// Character emotion
        /// </summary>
        public abstract CharacterImageEmotion Emotion { get; set; }

        /// <summary>
        /// Character weapon motion
        /// </summary>
        public abstract CharacterImageWeaponMotion Wmotion { get; set; }

        /// <summary>
        /// Character action frame
        /// </summary>
        public abstract int ActionFrame { get; set; }

        /// <summary>
        /// Character emotion frame
        /// </summary>
        public abstract int EmotionFrame { get; set; }
    }
}
