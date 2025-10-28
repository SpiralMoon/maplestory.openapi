package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 角色基本資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBasicDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBasicDTO {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 角色名稱
     */
    @SerializedName("character_name")
    private String characterName;

    /**
     * 世界名稱
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 角色性別
     */
    @SerializedName("character_gender")
    private String characterGender;

    /**
     * 角色職業
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 角色轉職次數
     */
    @SerializedName("character_class_level")
    private String characterClassLevel;

    /**
     * 角色等級
     */
    @SerializedName("character_level")
    private long characterLevel;

    /**
     * 當前等級的經驗值
     */
    @SerializedName("character_exp")
    private long characterExp;

    /**
     * 當前等級的經驗值百分比
     */
    @SerializedName("character_exp_rate")
    private String characterExpRate;

    /**
     * 角色所屬公會的名稱
     */
    @SerializedName("character_guild_name")
    private String characterGuildName;

    /**
     * 角色外型圖片
     */
    @SerializedName("character_image")
    private String characterImage;

    /**
     * 角色建立日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("character_date_create")
    private String characterDateCreate;

    /**
     * 過去 7 天的登入狀態 (true：已登入，false：未登入)
     */
    @SerializedName("access_flag")
    private String accessFlag;

    /**
     * 解放任務完成狀態 (0：未完成，1：創世武器已解放)
     */
    @SerializedName("liberation_quest_clear")
    private String liberationQuestClear;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }

    /**
     * 角色建立日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getCharacterDateCreate() {
        return characterDateCreate != null
                ? Utils.toZonedDateTime(this.characterDateCreate)
                : null;
    }

    /**
     * Login status in the past 7 days
     */
    public boolean isAccessFlag() {
        return "true".equals(this.accessFlag);
    }
}
