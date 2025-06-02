package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * Character image information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterImageDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterImageDTO {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private ZonedDateTime date;

    /**
     * Character image original (URL)
     */
    @SerializedName("origin_url")
    private String originUrl;

    /**
     * Character image original (base64)
     */
    @SerializedName("origin_image")
    private String originImage;

    /**
     * Character image (base64)
     */
    @SerializedName("image")
    private String image;

    /**
     * Character action
     */
    @SerializedName("action")
    private CharacterImageAction action;

    /**
     * Character emotion
     */
    @SerializedName("emotion")
    private CharacterImageEmotion emotion;

    /**
     * Character weapon motion
     */
    @SerializedName("wmotion")
    private CharacterImageWeaponMotion wmotion;

    /**
     * Character action frame
     */
    @SerializedName("action_frame")
    private int actionFrame;

    /**
     * Character emotion frame
     */
    @SerializedName("emotion_frame")
    private int emotionFrame;

    /**
     * Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
     */
    @SerializedName("width")
    private Integer width;

    /**
     * Vertical length (corresponding to the background size, 96 (default) ~ 1000)
     */
    @SerializedName("height")
    private Integer height;

    /**
     * Horizontal coordinate of the character
     */
    @SerializedName("x")
    private Integer x;

    /**
     * Vertical coordinate of the character
     */
    @SerializedName("y")
    private Integer y;
}
