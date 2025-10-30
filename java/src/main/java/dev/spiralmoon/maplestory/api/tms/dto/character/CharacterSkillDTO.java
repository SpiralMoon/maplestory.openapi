package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色技能與超技能資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSkillDTO<CharacterSkillInfoDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 角色職業
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 技能轉職次數
     */
    @JsonProperty("character_skill_grade")
    private String characterSkillGrade;

    /**
     * 技能資訊
     */
    @JsonProperty("character_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterSkillInfoDTO> characterSkill;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
