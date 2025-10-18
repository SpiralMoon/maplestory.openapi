package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 道具基本選項資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentBaseOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentBaseOptionDTO {

    /**
     * 力量 (STR)
     */
    @SerializedName("str")
    private String strength;

    /**
     * 敏捷 (DEX)
     */
    @SerializedName("dex")
    private String dexterity;

    /**
     * 敏捷 (DEX)
     */
    @SerializedName("int")
    private String intelligence;

    /**
     * 幸運 (LUK)
     */
    @SerializedName("luk")
    private String luck;

    /**
     * 最大體力 (HP)
     */
    @SerializedName("max_hp")
    private String maxHp;

    /**
     * 最大 MP
     */
    @SerializedName("max_mp")
    private String maxMp;

    /**
     * 攻擊力
     */
    @SerializedName("attack_power")
    private String attackPower;

    /**
     * 魔力
     */
    @SerializedName("magic_power")
    private String magicPower;

    /**
     * 防禦力
     */
    @SerializedName("armor")
    private String armor;

    /**
     * 移動速度
     */
    @SerializedName("speed")
    private String speed;

    /**
     * 跳躍力
     */
    @SerializedName("jump")
    private String jump;

    /**
     * 對首領傷害增加 (%)
     */
    @SerializedName("boss_damage")
    private String bossDamage;

    /**
     * 無視怪物防禦力 (%)
     */
    @SerializedName("ignore_monster_armor")
    private String ignoreMonsterArmor;

    /**
     * 全部能力值 (%)
     */
    @SerializedName("all_stat")
    private String allStat;

    /**
     * 最大體力 (HP) (%)
     */
    @SerializedName("max_hp_rate")
    private String maxHpRate;

    /**
     * 最大 MP (%)
     */
    @SerializedName("max_mp_rate")
    private String maxMpRate;

    /**
     *裝備基本等級
     */
    @SerializedName("base_equipment_level")
    private Long baseEquipmentLevel;
}