package dev.spiralmoon.maplestory.api.kms.dto.character;

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
public class CharacterItemEquipmentExceptionalOptionDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentExceptionalOptionDTO {
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

    /**
     * 익셉셔널 강화 적용 횟수
     */
    @SerializedName("exceptional_upgrade")
    private int exceptionalUpgrade;
}
