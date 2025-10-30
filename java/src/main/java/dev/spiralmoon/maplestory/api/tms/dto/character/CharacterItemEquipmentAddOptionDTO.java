package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 附加道具選項
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentAddOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentAddOptionDTO {

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
     * 傷害 (%)
     */
    @JsonProperty("damage")
    private String damage;

    /**
     * 全部能力值 (%)
     */
    @JsonProperty("all_stat")
    private String allStat;

    /**
     * 裝備等級減少
     */
    @JsonProperty("equipment_level_decrease")
    private Long equipmentLevelDecrease;
}