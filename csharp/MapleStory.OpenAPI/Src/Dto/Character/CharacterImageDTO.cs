using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 외형 이미지 정보
    /// </summary>
    public class CharacterImageDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// 캐릭터 외형 이미지 원본 (URL)
        /// </summary>
        public string OriginUrl { get; set; }

        /// <summary>
        /// 캐릭터 외형 기본 이미지 (base64)
        /// </summary>
        public string OriginImage { get; set; }

        /// <summary>
        /// 캐릭터 외형 이미지 (base64)
        /// </summary>
        public string Image { get; set; }

        /// <summary>
        /// 캐릭터 액션
        /// </summary>
        public CharacterImageAction Action { get; set; }

        /// <summary>
        /// 캐릭터 감정표현
        /// </summary>
        public CharacterImageEmotion Emotion { get; set; }

        /// <summary>
        /// 캐릭터 무기 모션
        /// </summary>
        public CharacterImageWeaponMotion Wmotion { get; set; }

        /// <summary>
        /// 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
        /// </summary>
        public int Width { get; set; }

        /// <summary>
        /// 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
        /// </summary>
        public int Height { get; set; }

        /// <summary>
        ///  캐릭터의 가로 좌표
        /// </summary>
        public int? X { get; set; }

        /// <summary>
        ///  캐릭터의 세로 좌표
        /// </summary>
        public int? Y { get; set; }
    }

    /// <summary>
    /// 캐릭터 액션
    /// </summary>
    public enum CharacterImageAction
    {
        Stand1,
        Stand2,
        Walk1,
        Walk2,
        Prone,
        Fly,
        Jump,
        Sit,
        Ladder,
        Rope,
        Heal,
        Alert,
        ProneStab,
        SwingO1,
        SwingO2,
        SwingO3,
        SwingOF,
        SwingP1,
        SwingP2,
        SwingPF,
        SwingT1,
        SwingT2,
        SwingT3,
        SwingTF,
        StabO1,
        StabO2,
        StabOF,
        StabT1,
        StabT2,
        StabTF,
        Shoot1,
        Shoot2,
        ShootF,
        Dead,
        GhostWalk,
        GhostStand,
        GhostJump,
        GhostProneStab,
        GhostLadder,
        GhostRope,
        GhostFly,
        GhostSit,
    }

    /// <summary>
    /// 캐릭터 감정표현
    /// </summary>
    public enum CharacterImageEmotion
    {
        Default,
        Wink,
        Smile,
        Cry,
        Angry,
        Bewildered,
        Blink,
        Blaze,
        Bowing,
        Cheers,
        Chu,
        Dam,
        Despair,
        Glitter,
        Hit,
        Hot,
        Hum,
        Love,
        Oops,
        Pain,
        Troubled,
        QBlue,
        Shine,
        Stunned,
        Vomit,
    }

    /// <summary>
    /// 캐릭터 무기 모션
    /// </summary>
    public enum CharacterImageWeaponMotion
    {
        Default,
        OneHand,
        TwoHands,
        Gun,
        Nothing,
    }
}
