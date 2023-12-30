using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 장비 기본 옵션 정보
    /// </summary>
    public class CharacterItemEquipmentBaseOptionDTO
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

        /// <summary>
        /// 보스 공격 시 데미지 증가(%)
        /// </summary>
        [JsonProperty("boss_damage")]
        public string BossDamage { get; set; }

        /// <summary>
        /// 몬스터 방어율 무시(%)
        /// </summary>
        [JsonProperty("ignore_monster_armor")]
        public string IgnoreMonsterArmor { get; set; }

        /// <summary>
        /// 올스탯(%)
        /// </summary>
        [JsonProperty("all_stat")]
        public string AllStat { get; set; }

        /// <summary>
        /// 최대 HP(%)
        /// </summary>
        [JsonProperty("max_hp_rate")]
        public string MaxHpRate { get; set; }

        /// <summary>
        /// 최대 MP(%)
        /// </summary>
        [JsonProperty("max_mp_rate")]
        public string MaxMpRate { get; set; }

        /// <summary>
        /// 착용 레벨 감소
        /// </summary>
        [JsonProperty("base_equipment_level")]
        public long BaseEquipmentLevel { get; set; }
    }
}
