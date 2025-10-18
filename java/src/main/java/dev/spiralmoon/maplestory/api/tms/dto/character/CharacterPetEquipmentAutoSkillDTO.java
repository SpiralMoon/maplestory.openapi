package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 寵物的寵物自動加持技能資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentAutoSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentAutoSkillDTO {

    /**
     * 登錄於第一欄位的自動加持技能
     */
    @SerializedName("skill_1")
    private String skill1;

    /**
     * 登錄於第一欄位的自動加持技能圖示
     */
    @SerializedName("skill_1_icon")
    private String skill1Icon;

    /**
     * 登錄於第二欄位的自動加持技能
     */
    @SerializedName("skill_2")
    private String skill2;

    /**
     * 登錄於第二欄位的自動加持技能圖示
     */
    @SerializedName("skill_2_icon")
    private String skill2Icon;
}
