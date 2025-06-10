using MapleStory.OpenAPI.Common.Enum;
using Newtonsoft.Json;
using Base = MapleStory.OpenAPI.Common.DTO;

namespace MapleStory.OpenAPI.KMS.DTO
{
    /// <summary>
    /// 캐릭터 외형 이미지 정보
    /// </summary>
    public class CharacterImageDTO : Base.CharacterImageDTO
    {
        /// <summary>
        /// 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
        /// </summary>
        [JsonProperty("date")]
        public override DateTimeOffset? Date
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
        public override string OriginUrl { get; set; }

        /// <summary>
        /// 캐릭터 외형 기본 이미지 (base64)
        /// </summary>
        public override string OriginImage { get; set; }

        /// <summary>
        /// 캐릭터 외형 이미지 (base64)
        /// </summary>
        public override string Image { get; set; }

        /// <summary>
        /// 캐릭터 액션
        /// </summary>
        public override CharacterImageAction Action { get; set; }

        /// <summary>
        /// 캐릭터 감정표현
        /// </summary>
        public override CharacterImageEmotion Emotion { get; set; }

        /// <summary>
        /// 캐릭터 무기 모션
        /// </summary>
        public override CharacterImageWeaponMotion Wmotion { get; set; }

        /// <summary>
        /// 캐릭터 액션 프레임
        /// </summary>
        public override int? ActionFrame { get; set; }

        /// <summary>
        /// 캐릭터 감정표현 프레임
        /// </summary>
        public override int? EmotionFrame { get; set; }

        /// <summary>
        /// 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
        /// </summary>
        public override int Width { get; set; }

        /// <summary>
        /// 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
        /// </summary>
        public override int Height { get; set; }

        /// <summary>
        ///  캐릭터의 가로 좌표
        /// </summary>
        public override int? X { get; set; }

        /// <summary>
        ///  캐릭터의 세로 좌표
        /// </summary>
        public override int? Y { get; set; }
    }
}
