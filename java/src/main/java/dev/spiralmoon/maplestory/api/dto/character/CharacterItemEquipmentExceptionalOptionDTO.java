package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 장비 특별 옵션 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentExceptionalOptionDTO {
    /**
     * STR
     */
    @SerializedName("str")
    private String strength;

    /**
     * DEX
     */
    @SerializedName("dex")
    private String dexterity;

    /**
     * INT
     */
    @SerializedName("int")
    private String intelligence;

    /**
     * LUK
     */
    @SerializedName("luk")
    private String luck;

    /**
     * 최대 HP
     */
    @SerializedName("max_hp")
    private String maxHp;

    /**
     * 최대 MP
     */
    @SerializedName("max_mp")
    private String maxMp;

    /**
     * 공격력
     */
    @SerializedName("attack_power")
    private String attackPower;

    /**
     * 마력
     */
    @SerializedName("magic_power")
    private String magicPower;
}
