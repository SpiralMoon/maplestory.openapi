using MapleStory.OpenAPI.Common.Enum;
using Base = MapleStory.OpenAPI.Common.Param;

namespace MapleStory.OpenAPI.TMS.Param
{
    public class CharacterImageOption : Base.CharacterImageOption
    {
        /// <summary>
        /// 角色動作
        /// </summary>
        public override CharacterImageAction Action { get; set; } = CharacterImageAction.Stand1;

        /// <summary>
        /// 角色表情
        /// </summary>
        public override CharacterImageEmotion Emotion { get; set; } = CharacterImageEmotion.Default;

        /// <summary>
        /// 角色武器動作
        /// </summary>
        public override CharacterImageWeaponMotion Wmotion { get; set; } = CharacterImageWeaponMotion.Default;

        /// <summary>
        /// 角色動作影格
        /// </summary>
        public override int ActionFrame { get; set; } = 0;

        /// <summary>
        /// 角色表情影格
        /// </summary>
        public override int EmotionFrame { get; set; } = 0;

        /// <summary>
        /// 寬度 (對應背景大小，96 (預設) 至 1000)
        /// </summary>
        public int Width { get; set; } = 96;

        /// <summary>
        /// 高度 (對應背景大小，96 (預設) 至 1000)
        /// </summary>
        public int Height { get; set; } = 96;

        /// <summary>
        /// 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
        /// </summary>
        public int? X { get; set; }

        /// <summary>
        /// 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
        /// </summary>
        public int? Y { get; set; }
    }
}
