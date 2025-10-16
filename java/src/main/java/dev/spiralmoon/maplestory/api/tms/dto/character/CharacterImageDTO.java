package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 角色外型圖片資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterImageDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterImageDTO {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private ZonedDateTime date;

    /**
     * 角色外型圖片原始 (URL)
     */
    @SerializedName("origin_url")
    private String originUrl;

    /**
     * 角色外型圖片原始 (base64)
     */
    @SerializedName("origin_image")
    private String originImage;

    /**
     * 角色外型圖片 (base64)
     */
    @SerializedName("image")
    private String image;

    /**
     * 角色動作
     */
    @SerializedName("action")
    private CharacterImageAction action;

    /**
     * 角色表情
     */
    @SerializedName("emotion")
    private CharacterImageEmotion emotion;

    /**
     * 角色武器動作
     */
    @SerializedName("wmotion")
    private CharacterImageWeaponMotion wmotion;

    /**
     * 角色動作影格
     */
    @SerializedName("action_frame")
    private int actionFrame;

    /**
     * 角色表情影格
     */
    @SerializedName("emotion_frame")
    private int emotionFrame;

    /**
     * 寬度 (對應背景大小，96 (預設) 至 1000)
     */
    @SerializedName("width")
    private Integer width;

    /**
     * 高度 (對應背景大小，96 (預設) 至 1000)
     */
    @SerializedName("height")
    private Integer height;

    /**
     * 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
     */
    @SerializedName("x")
    private Integer x;

    /**
     * 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
     */
    @SerializedName("y")
    private Integer y;
}
