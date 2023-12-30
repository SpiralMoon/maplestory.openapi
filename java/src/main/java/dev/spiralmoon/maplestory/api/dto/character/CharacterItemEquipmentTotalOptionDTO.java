package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 장비 최종 옵션 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentTotalOptionDTO {

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
     * 방어력
     */
    @SerializedName("armor")
    private String armor;

    /**
     * 이동속도
     */
    @SerializedName("speed")
    private String speed;

    /**
     * 점프력
     */
    @SerializedName("jump")
    private String jump;

    /**
     * 보스 공격 시 데미지 증가(%)
     */
    @SerializedName("boss_damage")
    private String bossDamage;

    /**
     * 몬스터 방어율 무시(%)
     */
    @SerializedName("ignore_monster_armor")
    private String ignoreMonsterArmor;

    /**
     * 올스탯(%)
     */
    @SerializedName("all_stat")
    private String allStat;

    /**
     * 데미지(%)
     */
    private String damage;

    /**
     * 착용 레벨 감소
     */
    @SerializedName("equipment_level_decrease")
    private Long equipmentLevelDecrease;

    /**
     * 최대 HP(%)
     */
    @SerializedName("max_hp_rate")
    private String maxHpRate;

    /**
     * 최대 MP(%)
     */
    @SerializedName("max_mp_rate")
    private String maxMpRate;
}
