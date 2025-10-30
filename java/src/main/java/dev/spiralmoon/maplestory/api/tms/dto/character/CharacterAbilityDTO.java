package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色能力資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAbilityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityDTO<
        CharacterAbilityInfoDTO,
        CharacterAbilityPresetDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 能力階級
     */
    @JsonProperty("ability_grade")
    private String abilityGrade;

    /**
     * 能力資訊
     */
    @JsonProperty("ability_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAbilityInfoDTO> abilityInfo;

    /**
     * 名聲值
     */
    @JsonProperty("remain_fame")
    private Long remainFame;

    /**
     * 目前套用的能力預設編號
     */
    @JsonProperty("preset_no")
    private Integer presetNo;

    /**
     * 能力 1 預設完整資訊
     */
    @JsonProperty("ability_preset_1")
    private CharacterAbilityPresetDTO abilityPreset1;

    /**
     * 能力 2 預設完整資訊
     */
    @JsonProperty("ability_preset_2")
    private CharacterAbilityPresetDTO abilityPreset2;

    /**
     * 能力 3 預設完整資訊
     */
    @JsonProperty("ability_preset_3")
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
