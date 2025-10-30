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
 * 角色已裝備連結技能資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterLinkSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterLinkSkillDTO<CharacterLinkSkillInfoDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 角色職業
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 連結技能資訊
     */
    @JsonProperty("character_link_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterLinkSkillInfoDTO> characterLinkSkill;

    /**
     * 連結技能 1 預設資訊
     */
    @JsonProperty("character_link_skill_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset1;

    /**
     * 連結技能 2 預設資訊
     */
    @JsonProperty("character_link_skill_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset2;

    /**
     * 連結技能 3 預設資訊
     */
    @JsonProperty("character_link_skill_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset3;

    /**
     * 我的連結技能資訊
     */
    @JsonProperty("character_owned_link_skill")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkill;

    /**
     * 我的連結技能 1 預設資訊
     */
    @JsonProperty("character_owned_link_skill_preset_1")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset1;

    /**
     * 我的連結技能 2 預設資訊
     */
    @JsonProperty("character_owned_link_skill_preset_2")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset2;

    /**
     * 我的連結技能 3 預設資訊
     */
    @JsonProperty("character_owned_link_skill_preset_3")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset3;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
