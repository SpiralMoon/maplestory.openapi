using MapleStory.OpenAPI.Dto;

namespace MapleStory.OpenAPI.Param
{
    /// <summary>
    /// 캐릭터 외형 이미지 파라미터
    /// </summary>
    public class CharacterImageOption
    {
        /// <summary>
        /// 캐릭터 액션
        /// </summary>
        public CharacterImageAction Action { get; set; } = CharacterImageAction.Stand1;

        /// <summary>
        /// 캐릭터 감정표현
        /// </summary>
        public CharacterImageEmotion Emotion { get; set; } = CharacterImageEmotion.Default;

        /// <summary>
        /// 캐릭터 무기 모션
        /// </summary>
        public CharacterImageWeaponMotion Wmotion { get; set; } = CharacterImageWeaponMotion.Default;

        /// <summary>
        /// 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
        /// </summary>
        public int Width { get; set; } = 96;

        /// <summary>
        /// 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
        /// </summary>
        public int Height { get; set; } = 96;

        /// <summary>
        ///  캐릭터의 가로 좌표
        /// </summary>
        public int? X { get; set; }

        /// <summary>
        ///  캐릭터의 세로 좌표
        /// </summary>
        public int? Y { get; set; }
    }
}
