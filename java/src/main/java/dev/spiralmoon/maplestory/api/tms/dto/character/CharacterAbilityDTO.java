package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色能力資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityDTO<
        CharacterAbilityInfoDTO,
        CharacterAbilityPresetDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 能力階級
     */
    @SerializedName("ability_grade")
    private String abilityGrade;

    /**
     * 能力資訊
     */
    @SerializedName("ability_info")
    private List<CharacterAbilityInfoDTO> abilityInfo;

    /**
     * 名聲值
     */
    @SerializedName("remain_fame")
    private Long remainFame;

    /**
     * 目前套用的能力預設編號
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * 能力 1 預設完整資訊
     */
    @SerializedName("ability_preset_1")
    private CharacterAbilityPresetDTO abilityPreset1;

    /**
     * 能力 2 預設完整資訊
     */
    @SerializedName("ability_preset_2")
    private CharacterAbilityPresetDTO abilityPreset2;

    /**
     * 能力 3 預設完整資訊
     */
    @SerializedName("ability_preset_3")
    private CharacterAbilityPresetDTO abilityPreset3;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
