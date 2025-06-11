package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character skill information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSkillDTO<CharacterSkillInfoDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Character job
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * Job advancement tier required to acquire the skill
     */
    @SerializedName("character_skill_grade")
    private String characterSkillGrade;

    /**
     * Skill information
     */
    @SerializedName("character_skill")
    private List<CharacterSkillInfoDTO> characterSkill;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
