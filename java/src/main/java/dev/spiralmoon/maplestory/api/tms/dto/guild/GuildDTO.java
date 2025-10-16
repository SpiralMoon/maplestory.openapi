package dev.spiralmoon.maplestory.api.tms.dto.guild;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 公會識別碼資訊
 */
@AllArgsConstructor
@Data
@ToString
public class GuildDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildDTO {

    /**
     * 公會識別碼
     */
    @SerializedName("oguild_id")
    private String oGuildId;
}
