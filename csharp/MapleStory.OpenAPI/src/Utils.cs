using MapleStory.OpenAPI.src.dto;

namespace MapleStory.OpenAPI.src
{
    public class Utils
    {
        /// <summary>
        /// 한글로 정의된 잠재옵션 등급을 PotentialOptionGrade으로 변환합니다.
        /// </summary>
        /// <param name="text"></param>
        /// <returns></returns>
        public static PotentialOptionGrade PotentialOptionGradeFromString(string text)
        {
            var potentialOptionGradeMap = new Dictionary<string, PotentialOptionGrade>
            {
                { "레어", PotentialOptionGrade.RARE },
                { "에픽", PotentialOptionGrade.EPIC },
                { "유니크", PotentialOptionGrade.UNIQUE },
                { "레전드리", PotentialOptionGrade.LEGENDARY },
            };

            if (potentialOptionGradeMap.TryGetValue(text, out PotentialOptionGrade grade))
            {
                return grade;
            }
            else
            {
                throw new ArgumentException("No enum constant for string: " + text);
            }
        }
    }
}
