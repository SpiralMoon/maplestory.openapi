package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 펫 장비 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentDTO {
    /**
     * 조회 기준일 (KST)
     */
    @SerializedName("date")
    private String date;

    /**
     * 펫1 명
     */
    @SerializedName("pet_1_name")
    private String pet1Name;

    /**
     * 펫1 닉네임
     */
    @SerializedName("pet_1_nickname")
    private String pet1Nickname;

    /**
     * 펫1 아이콘
     */
    @SerializedName("pet_1_icon")
    private String pet1Icon;

    /**
     * 펫1 설명
     */
    @SerializedName("pet_1_description")
    private String pet1Description;

    /**
     * 펫1 장착 정보
     */
    @SerializedName("pet_1_equipment")
    private CharacterPetEquipmentItemDTO pet1Equipment;

    /**
     * 펫1 펫 버프 자동스킬 정보
     */
    @SerializedName("pet_1_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet1AutoSkill;

    /**
     * 펫1 원더 펫 종류
     */
    @SerializedName("pet_1_pet_type")
    private String pet1PetType;

    /**
     * 펫1 펫 보유 스킬
     */
    @SerializedName("pet_1_skill")
    private List<String> pet1Skill;

    /**
     * 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @SerializedName("pet_1_date_expire")
    private String pet1DateExpire;

    /**
     * 펫2 명
     */
    @SerializedName("pet_2_name")
    private String pet2Name;

    /**
     * 펫2 닉네임
     */
    @SerializedName("pet_2_nickname")
    private String pet2Nickname;

    /**
     * 펫2 아이콘
     */
    @SerializedName("pet_2_icon")
    private String pet2Icon;

    /**
     * 펫2 설명
     */
    @SerializedName("pet_2_description")
    private String pet2Description;

    /**
     * 펫2 장착 정보
     */
    @SerializedName("pet_2_equipment")
    private CharacterPetEquipmentItemDTO pet2Equipment;

    /**
     * 펫2 펫 버프 자동스킬 정보
     */
    @SerializedName("pet_2_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet2AutoSkill;

    /**
     * 펫2 원더 펫 종류
     */
    @SerializedName("pet_2_pet_type")
    private String pet2PetType;

    /**
     * 펫2 펫 보유 스킬
     */
    @SerializedName("pet_2_skill")
    private List<String> pet2Skill;

    /**
     * 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @SerializedName("pet_2_date_expire")
    private String pet2DateExpire;

    /**
     * 펫3 명
     */
    @SerializedName("pet_3_name")
    private String pet3Name;

    /**
     * 펫3 닉네임
     */
    @SerializedName("pet_3_nickname")
    private String pet3Nickname;

    /**
     * 펫3 아이콘
     */
    @SerializedName("pet_3_icon")
    private String pet3Icon;

    /**
     * 펫3 설명
     */
    @SerializedName("pet_3_description")
    private String pet3Description;

    /**
     * 펫3 장착 정보
     */
    @SerializedName("pet_3_equipment")
    private CharacterPetEquipmentItemDTO pet3Equipment;

    /**
     * 펫3 펫 버프 자동스킬 정보
     */
    @SerializedName("pet_3_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet3AutoSkill;

    /**
     * 펫3 원더 펫 종류
     */
    @SerializedName("pet_3_pet_type")
    private String pet3PetType;

    /**
     * 펫3 펫 보유 스킬
     */
    @SerializedName("pet_3_skill")
    private List<String> pet3Skill;

    /**
     * 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @SerializedName("pet_3_date_expire")
    private String pet3DateExpire;
}
