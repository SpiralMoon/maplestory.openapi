package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character HEXA Matrix configured HEXA stats information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixStatDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixStatDTO<
        CharacterHexaMatrixStatCoreDTO> {

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
     * Information for HEXA Stat Node I
     */
    @SerializedName("character_hexa_stat_core")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore;

    /**
     * Information for HEXA Stat Node II
     */
    @SerializedName("character_hexa_stat_core_2")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore2;

    /**
     * Information for HEXA Stat Node III
     */
    @SerializedName("character_hexa_stat_core_3")
    private List<CharacterHexaMatrixStatCoreDTO> characterHexaStatCore3;

    /**
     * Preset HEXA Stat Node I information
     */
    @SerializedName("preset_hexa_stat_core")
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore;

    /**
     * Preset HEXA Stat Node II information
     */
    @SerializedName("preset_hexa_stat_core_2")
    private List<CharacterHexaMatrixStatCoreDTO> presetHexaStatCore2;

    /**
     * Preset HEXA Stat Node III information
     */
    @SerializedName("preset_hexa_stat_core_3")
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
