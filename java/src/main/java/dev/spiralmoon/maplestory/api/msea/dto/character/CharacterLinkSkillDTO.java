package dev.spiralmoon.maplestory.api.msea.dto.character;

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
 * Character equipped link skill information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterLinkSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterLinkSkillDTO<
        CharacterLinkSkillInfoDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Character job
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * Link Skill information
     */
    @JsonProperty("character_link_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterLinkSkillInfoDTO> characterLinkSkill;

    /**
     * Link Skill information for preset 1
     */
    @JsonProperty("character_link_skill_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset1;

    /**
     * Link Skill information for preset 2
     */
    @JsonProperty("character_link_skill_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset2;

    /**
     * Link Skill information for preset 3
     */
    @JsonProperty("character_link_skill_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset3;

    /**
     * My Link Skill information
     */
    @JsonProperty("character_owned_link_skill")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkill;

    /**
     * My Link Skill information for preset 1
     */
    @JsonProperty("character_owned_link_skill_preset_1")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset1;

    /**
     * My Link Skill information for preset 2
     */
    @JsonProperty("character_owned_link_skill_preset_2")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset2;

    /**
     * My Link Skill information for preset 3
     */
    @JsonProperty("character_owned_link_skill_preset_3")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset3;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
