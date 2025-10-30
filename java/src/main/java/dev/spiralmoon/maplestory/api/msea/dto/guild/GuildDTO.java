package dev.spiralmoon.maplestory.api.msea.dto.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Guild identifier information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuildDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildDTO {

    /**
     * Guild identifier
     */
    @JsonProperty("oguild_id")
    private String oGuildId;
}

