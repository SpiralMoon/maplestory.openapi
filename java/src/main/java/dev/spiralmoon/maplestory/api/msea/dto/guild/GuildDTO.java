package dev.spiralmoon.maplestory.api.msea.dto.guild;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Guild identifier information
 */
@AllArgsConstructor
@Data
@ToString
public class GuildDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildDTO {

    /**
     * Guild identifier
     */
    @SerializedName("oguild_id")
    private String oGuildId;
}

