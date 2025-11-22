package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Character basic information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterBasicDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBasicDTO {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Character name
     */
    @JsonProperty("character_name")
    private String characterName;

    /**
     * World name
     */
    @JsonProperty("world_name")
    private String worldName;

    /**
     * Character gender
     */
    @JsonProperty("character_gender")
    private String characterGender;

    /**
     * Character job
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * Character job advancement tier
     */
    @JsonProperty("character_class_level")
    private String characterClassLevel;

    /**
     * Character level
     */
    @JsonProperty("character_level")
    private long characterLevel;

    /**
     * Experience points gained at the current level
     */
    @JsonProperty("character_exp")
    private long characterExp;

    /**
     * Percentage of experience points at the current level
     */
    @JsonProperty("character_exp_rate")
    private String characterExpRate;

    /**
     * Guild name the character belongs to
     */
    @JsonProperty("character_guild_name")
    private String characterGuildName;

    /**
     * Character appearance image
     */
    @JsonProperty("character_image")
    private String characterImage;

    public void setCharacterImage(String characterImage) {
        this.characterImage = Utils.removeQuery(characterImage);
    }

    /**
     * Character creation date (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("character_date_create")
    private String characterDateCreate;

    /**
     * Login status in the past 7 days (true:logged in, false:not logged in)
     */
    @JsonProperty("access_flag")
    private String accessFlag;

    /**
     * Liberation quest completion status (true:completed, false:not completed)
     */
    @JsonProperty("liberation_quest_clear_flag")
    private String liberationQuestClearFlag;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }

    /**
     * Character creation date (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getCharacterDateCreate() {
        return characterDateCreate != null
                ? Utils.toZonedDateTime(this.characterDateCreate)
                : null;
    }

    /**
     * Login status in the past 7 days
     */
    public boolean isAccessFlag() {
        return "true".equals(this.accessFlag);
    }

    /**
     * Liberation quest completion status
     */
    public boolean isLiberationQuestClearFlag() {
        return "true".equals(this.liberationQuestClearFlag);
    }
}
