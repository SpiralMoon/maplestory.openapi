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
 * Character HEXA Matrix configured HEXA stats information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatDTO<
        CharacterHexaMatrixStatCoreDTO> {

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
     * Information for HEXA Stat Node I
     */
    @JsonProperty("character_hexa_stat_core")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore;

    /**
     * Information for HEXA Stat Node II
     */
    @JsonProperty("character_hexa_stat_core_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore2;

    /**
     * Information for HEXA Stat Node III
     */
    @JsonProperty("character_hexa_stat_core_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore3;

    /**
     * Preset HEXA Stat Node I information
     */
    @JsonProperty("preset_hexa_stat_core")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore;

    /**
     * Preset HEXA Stat Node II information
     */
    @JsonProperty("preset_hexa_stat_core_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore2;

    /**
     * Preset HEXA Stat Node III information
     */
    @JsonProperty("preset_hexa_stat_core_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore3;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
