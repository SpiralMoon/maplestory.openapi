package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 道具其他選項資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentEtcOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentEtcOptionDTO {

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
}