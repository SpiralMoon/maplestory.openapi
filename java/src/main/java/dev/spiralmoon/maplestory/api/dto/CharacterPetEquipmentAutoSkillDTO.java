package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 펫 장비 자동 스킬 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentAutoSkillDTO {

    /**
     * 첫 번째 슬롯에 등록된 자동 스킬
     */
    @SerializedName("skill_1")
    private String skill1;

    /**
     * 첫 번째 슬롯에 등록된 자동 스킬 아이콘
     */
    @SerializedName("skill_1_icon")
    private String skill1Icon;

    /**
     * 두 번째 슬롯에 등록된 자동 스킬
     */
    @SerializedName("skill_2")
    private String skill2;

    /**
     * 두 번째 슬롯에 등록된 자동 스킬 아이콘
     */
    @SerializedName("skill_2_icon")
    private String skill2Icon;
}
