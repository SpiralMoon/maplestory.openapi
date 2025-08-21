using MapleStory.OpenAPI.Common.Enum;
using Base = MapleStory.OpenAPI.Common.Param;

namespace MapleStory.OpenAPI.KMS.Param
{
    public class CharacterImageOption : Base.CharacterImageOption
    {
        /// <summary>
        /// 캐릭터 액션
        /// </summary>
        public override CharacterImageAction Action { get; set; } = CharacterImageAction.Stand1;

        /// <summary>
        /// 캐릭터 감정표현
        /// </summary>
        public override CharacterImageEmotion Emotion { get; set; } = CharacterImageEmotion.Default;

        /// <summary>
        /// 캐릭터 무기 모션
        /// </summary>
        public override CharacterImageWeaponMotion Wmotion { get; set; } = CharacterImageWeaponMotion.Default;

        /// <summary>
        /// 캐릭터 액션 프레임
        /// </summary>
        public override int ActionFrame { get; set; } = 0;

        /// <summary>
        /// 캐릭터 감정표현 프레임
        /// </summary>
        public override int EmotionFrame { get; set; } = 0;
    }
}
