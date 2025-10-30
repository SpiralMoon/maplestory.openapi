package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Character image information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterImageDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterImageDTO {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private ZonedDateTime date;

    /**
     * Character image original (URL)
     */
    @JsonProperty("origin_url")
    private String originUrl;

    /**
     * Character image original (base64)
     */
    @JsonProperty("origin_image")
    private String originImage;

    /**
     * Character image (base64)
     */
    @JsonProperty("image")
    private String image;

    /**
     * Character action
     */
    @JsonProperty("action")
    private CharacterImageAction action;

    /**
     * Character emotion
     */
    @JsonProperty("emotion")
    private CharacterImageEmotion emotion;

    /**
     * Character weapon motion
     */
    @JsonProperty("wmotion")
    private CharacterImageWeaponMotion wmotion;

    /**
     * Character action frame
     */
    @JsonProperty("action_frame")
    private int actionFrame;

    /**
     * Character emotion frame
     */
    @JsonProperty("emotion_frame")
    private int emotionFrame;

    /**
     * Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * Vertical length (corresponding to the background size, 96 (default) ~ 1000)
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * Horizontal coordinate of the character
     */
    @JsonProperty("x")
    private Integer x;

    /**
     * Vertical coordinate of the character
     */
    @JsonProperty("y")
    private Integer y;
}
