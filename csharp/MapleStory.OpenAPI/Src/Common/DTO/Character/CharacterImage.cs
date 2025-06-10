using MapleStory.OpenAPI.Common.Enum;

namespace MapleStory.OpenAPI.Common.DTO
{
    public abstract class CharacterImageDTO
    {
        public abstract DateTimeOffset? Date { get; set; }
        public abstract string OriginUrl { get; set; }
        public abstract string OriginImage { get; set; }
        public abstract string Image { get; set; }
        public abstract CharacterImageAction Action { get; set; }
        public abstract CharacterImageEmotion Emotion { get; set; }
        public abstract CharacterImageWeaponMotion Wmotion { get; set; }
        public abstract int? ActionFrame { get; set; }
        public abstract int? EmotionFrame { get; set; }
        public abstract int Width { get; set; }
        public abstract int Height { get; set; }
        public abstract int? X { get; set; }
        public abstract int? Y { get; set; }
    }
}
