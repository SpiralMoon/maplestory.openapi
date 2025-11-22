using MapleStory.OpenAPI.Common.Enum;

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
            var map = new Dictionary<CharacterImageAction, string>
            {
                { CharacterImageAction.Stand1, "A00" },
                { CharacterImageAction.Stand2, "A01" },
                { CharacterImageAction.Walk1, "A02" },
                { CharacterImageAction.Walk2, "A03" },
                { CharacterImageAction.Prone, "A04" },
                { CharacterImageAction.Fly, "A05" },
                { CharacterImageAction.Jump, "A06" },
                { CharacterImageAction.Sit, "A07" },
                { CharacterImageAction.Ladder, "A08" },
                { CharacterImageAction.Rope, "A09" },
                { CharacterImageAction.Heal, "A10" },
                { CharacterImageAction.Alert, "A11" },
                { CharacterImageAction.ProneStab, "A12" },
                { CharacterImageAction.SwingO1, "A13" },
                { CharacterImageAction.SwingO2, "A14" },
                { CharacterImageAction.SwingO3, "A15" },
                { CharacterImageAction.SwingOF, "A16" },
                { CharacterImageAction.SwingP1, "A17" },
                { CharacterImageAction.SwingP2, "A18" },
                { CharacterImageAction.SwingPF, "A19" },
                { CharacterImageAction.SwingT1, "A20" },
                { CharacterImageAction.SwingT2, "A21" },
                { CharacterImageAction.SwingT3, "A22" },
                { CharacterImageAction.SwingTF, "A23" },
                { CharacterImageAction.StabO1, "A24" },
                { CharacterImageAction.StabO2, "A25" },
                { CharacterImageAction.StabOF, "A26" },
                { CharacterImageAction.StabT1, "A27" },
                { CharacterImageAction.StabT2, "A28" },
                { CharacterImageAction.StabTF, "A29" },
                { CharacterImageAction.Shoot1, "A30" },
                { CharacterImageAction.Shoot2, "A31" },
                { CharacterImageAction.ShootF, "A32" },
                { CharacterImageAction.Dead, "A33" },
                { CharacterImageAction.GhostWalk, "A34" },
                { CharacterImageAction.GhostStand, "A35" },
                { CharacterImageAction.GhostJump, "A36" },
                { CharacterImageAction.GhostProneStab, "A37" },
                { CharacterImageAction.GhostLadder, "A38" },
                { CharacterImageAction.GhostRope, "A39" },
                { CharacterImageAction.GhostFly, "A40" },
                { CharacterImageAction.GhostSit, "A41" },
            };

            if (map.TryGetValue(source, out string value))
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
            var map = new Dictionary<CharacterImageEmotion, string>
            {
                { CharacterImageEmotion.Default, "E00" },
                { CharacterImageEmotion.Wink, "E01" },
                { CharacterImageEmotion.Smile, "E02" },
                { CharacterImageEmotion.Cry, "E03" },
                { CharacterImageEmotion.Angry, "E04" },
                { CharacterImageEmotion.Bewildered, "E05" },
                { CharacterImageEmotion.Blink, "E06" },
                { CharacterImageEmotion.Blaze, "E07" },
                { CharacterImageEmotion.Bowing, "E08" },
                { CharacterImageEmotion.Cheers, "E09" },
                { CharacterImageEmotion.Chu, "E10" },
                { CharacterImageEmotion.Dam, "E11" },
                { CharacterImageEmotion.Despair, "E12" },
                { CharacterImageEmotion.Glitter, "E13" },
                { CharacterImageEmotion.Hit, "E14" },
                { CharacterImageEmotion.Hot, "E15" },
                { CharacterImageEmotion.Hum, "E16" },
                { CharacterImageEmotion.Love, "E17" },
                { CharacterImageEmotion.Oops, "E18" },
                { CharacterImageEmotion.Pain, "E19" },
                { CharacterImageEmotion.Troubled, "E20" },
                { CharacterImageEmotion.QBlue, "E21" },
                { CharacterImageEmotion.Shine, "E22" },
                { CharacterImageEmotion.Stunned, "E23" },
                { CharacterImageEmotion.Vomit, "E24" },
            };

            if (map.TryGetValue(source, out string value))
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
            var map = new Dictionary<CharacterImageWeaponMotion, string>
            {
                { CharacterImageWeaponMotion.Default, "W00" },
                { CharacterImageWeaponMotion.OneHand, "W01" },
                { CharacterImageWeaponMotion.TwoHands, "W02" },
                { CharacterImageWeaponMotion.Gun, "W03" },
                { CharacterImageWeaponMotion.Nothing, "W04" },
            };

            if (map.TryGetValue(source, out string value))
            {
                return value;
            }
            else
            {
                throw new ArgumentException("No enum constant for string: " + source.ToString());
            }
        }

        public static string RemoveQuery(string url)
        {
            if (string.IsNullOrEmpty(url))
            {
                return url;
            }

            int queryIndex = url.IndexOf('?');
            return queryIndex >= 0 ? url.Substring(0, queryIndex) : url;
        }
    }
}
