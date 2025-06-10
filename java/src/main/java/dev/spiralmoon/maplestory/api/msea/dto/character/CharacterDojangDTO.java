package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Character Mu Lung Garden highest record information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterDojangDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDojangDTO {

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
     * World name
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * Highest floor record in Mu Lung Garden
     */
    @SerializedName("dojang_best_floor")
    private Integer dojangBestFloor;

    /**
     * Achievement date of the highest Mu Lung Garden record (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date_dojang_record")
    private String dateDojangRecord;

    /**
     * Time taken to clear the highest floor in Mu Lung Garden (in seconds)
     */
    @SerializedName("dojang_best_time")
    private Integer dojangBestTime;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null ? Utils.toZonedDateTime(this.date) : null;
    }

    /**
     * Achievement date of the highest Mu Lung Garden record (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDateDojangRecord() {
        return dateDojangRecord != null ? Utils.toZonedDateTime(this.dateDojangRecord) : null;
    }
}
