using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 장비 스타포스 옵션 정보
    /// </summary>
    public class CharacterItemEquipmentStarforceOptionDTO
    {
        /// <summary>
        /// STR
        /// </summary>
        [JsonProperty("str")]
        public string Strength { get; set; }

        /// <summary>
        /// DEX
        /// </summary>
        [JsonProperty("dex")]
        public string Dexterity { get; set; }

        /// <summary>
        /// INT
        /// </summary>
        [JsonProperty("int")]
        public string Intelligence { get; set; }

        /// <summary>
        /// LUK
        /// </summary>
        [JsonProperty("luk")]
        public string Luck { get; set; }

        /// <summary>
        /// 최대 HP
        /// </summary>
        [JsonProperty("max_hp")]
        public string MaxHp { get; set; }

        /// <summary>
        /// 최대 MP
        /// </summary>
        [JsonProperty("max_mp")]
        public string MaxMp { get; set; }

        /// <summary>
        /// 공격력
        /// </summary>
        [JsonProperty("attack_power")]
        public string AttackPower { get; set; }

        /// <summary>
        /// 마력
        /// </summary>
        [JsonProperty("magic_power")]
        public string MagicPower { get; set; }

        /// <summary>
        /// 방어력
        /// </summary>
        [JsonProperty("armor")]
        public string Armor { get; set; }

        /// <summary>
        /// 이동속도
        /// </summary>
        [JsonProperty("speed")]
        public string Speed { get; set; }

        /// <summary>
        /// 점프력
        /// </summary>
        [JsonProperty("jump")]
        public string Jump { get; set; }
    }
}
