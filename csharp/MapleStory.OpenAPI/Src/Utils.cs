using MapleStory.OpenAPI.Dto;

namespace MapleStory.OpenAPI
{
    public static class Utils
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

        public static string GetValue(this CharacterImageAction source)
        {
            var actionMap = new Dictionary<CharacterImageAction, string>
            {
                { CharacterImageAction.Stand1, "A00" },
                { CharacterImageAction.Stand2, "A01" },
                { CharacterImageAction.Walk1, "A02" },
                { CharacterImageAction.Walk2, "A03" },
                { CharacterImageAction.Prone, "A04" },
                { CharacterImageAction.Fly, "A05" },
                { CharacterImageAction.Jump, "A06" },
                { CharacterImageAction.Sit, "A07" },
            };

            if (actionMap.TryGetValue(source, out string value))
            {
                return value;
            }
            else
            {
                throw new ArgumentException("No enum constant for string: " + source.ToString());
            }
        }

        public static string GetValue(this CharacterImageEmotion source)
        {
            var actionMap = new Dictionary<CharacterImageEmotion, string>
            {
                { CharacterImageEmotion.Default, "E00" },
                { CharacterImageEmotion.Wink, "E01" },
                { CharacterImageEmotion.Smile, "E02" },
                { CharacterImageEmotion.Cry, "E03" },
                { CharacterImageEmotion.Angry, "E04" },
                { CharacterImageEmotion.Bewildered, "E05" },
            };

            if (actionMap.TryGetValue(source, out string value))
            {
                return value;
            }
            else
            {
                throw new ArgumentException("No enum constant for string: " + source.ToString());
            }
        }

        public static string GetValue(this CharacterImageWeaponMotion source)
        {
            var actionMap = new Dictionary<CharacterImageWeaponMotion, string>
            {
                { CharacterImageWeaponMotion.Default, "W00" },
                { CharacterImageWeaponMotion.OneHand, "W01" },
                { CharacterImageWeaponMotion.TwoHands, "W02" },
                { CharacterImageWeaponMotion.Gun, "W03" },
            };

            if (actionMap.TryGetValue(source, out string value))
            {
                return value;
            }
            else
            {
                throw new ArgumentException("No enum constant for string: " + source.ToString());
            }
        }
    }
}
