package dev.spiralmoon.maplestory.api.tms.dto.character;

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
 * 角色外型圖片資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterImageDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterImageDTO {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private ZonedDateTime date;

    /**
     * 角色外型圖片原始 (URL)
     */
    @JsonProperty("origin_url")
    private String originUrl;

    /**
     * 角色外型圖片原始 (base64)
     */
    @JsonProperty("origin_image")
    private String originImage;

    /**
     * 角色外型圖片 (base64)
     */
    @JsonProperty("image")
    private String image;

    /**
     * 角色動作
     */
    @JsonProperty("action")
    private CharacterImageAction action;

    /**
     * 角色表情
     */
    @JsonProperty("emotion")
    private CharacterImageEmotion emotion;

    /**
     * 角色武器動作
     */
    @JsonProperty("wmotion")
    private CharacterImageWeaponMotion wmotion;

    /**
     * 角色動作影格
     */
    @JsonProperty("action_frame")
    private int actionFrame;

    /**
     * 角色表情影格
     */
    @JsonProperty("emotion_frame")
    private int emotionFrame;

    /**
     * 寬度 (對應背景大小，96 (預設) 至 1000)
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * 高度 (對應背景大小，96 (預設) 至 1000)
     */
    @JsonProperty("height")
    private Integer height;

    /**
     * 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
     */
    @JsonProperty("x")
    private Integer x;

    /**
     * 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
     */
    @JsonProperty("y")
    private Integer y;
}
