package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 道具基本選項資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentBaseOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentBaseOptionDTO {

    /**
     * 力量 (STR)
     */
    @JsonProperty("str")
    private String strength;

    /**
     * 敏捷 (DEX)
     */
    @JsonProperty("dex")
    private String dexterity;

    /**
     * 敏捷 (DEX)
     */
    @JsonProperty("int")
    private String intelligence;

    /**
     * 幸運 (LUK)
     */
    @JsonProperty("luk")
    private String luck;

    /**
     * 最大體力 (HP)
     */
    @JsonProperty("max_hp")
    private String maxHp;

    /**
     * 最大 MP
     */
    @JsonProperty("max_mp")
    private String maxMp;

    /**
     * 攻擊力
     */
    @JsonProperty("attack_power")
    private String attackPower;

    /**
     * 魔力
     */
    @JsonProperty("magic_power")
    private String magicPower;

    /**
     * 防禦力
     */
    @JsonProperty("armor")
    private String armor;

    /**
     * 移動速度
     */
    @JsonProperty("speed")
    private String speed;

    /**
     * 跳躍力
     */
    @JsonProperty("jump")
    private String jump;

    /**
     * 對首領傷害增加 (%)
     */
    @JsonProperty("boss_damage")
    private String bossDamage;

    /**
     * 無視怪物防禦力 (%)
     */
    @JsonProperty("ignore_monster_armor")
    private String ignoreMonsterArmor;

    /**
     * 全部能力值 (%)
     */
    @JsonProperty("all_stat")
    private String allStat;

    /**
     * 最大體力 (HP) (%)
     */
    @JsonProperty("max_hp_rate")
    private String maxHpRate;

    /**
     * 最大 MP (%)
     */
    @JsonProperty("max_mp_rate")
    private String maxMpRate;

    /**
     *裝備基本等級
     */
    @JsonProperty("base_equipment_level")
    private Long baseEquipmentLevel;
}