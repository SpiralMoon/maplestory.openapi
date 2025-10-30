package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 道具特殊選項資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentExceptionalOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentExceptionalOptionDTO {

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
     * 已套用的卓越強化次數
     */
    @JsonProperty("exceptional_upgrade")
    private int exceptionalUpgrade;
}