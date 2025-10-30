package dev.spiralmoon.maplestory.api.tms.dto.guild;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 公會識別碼資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuildDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildDTO {

    /**
     * 公會識別碼
     */
    @JsonProperty("oguild_id")
    private String oGuildId;
}
