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

    @SerializedName("skill_1")
    private String skill1;

    @SerializedName("skill_1_icon")
    private String skill1Icon;

    @SerializedName("skill_2")
    private String skill2;

    @SerializedName("skill_2_icon")
    private String skill2Icon;
}
