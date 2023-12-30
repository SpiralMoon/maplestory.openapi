package dev.spiralmoon.maplestory.api.dto.guild;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 길드 식별자 정보
 */
@AllArgsConstructor
@Data
@ToString
public class GuildDTO {

    /**
     * 길드 식별자
     */
    @SerializedName("oguild_id")
    private String oGuildId;
}
