package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 角色已裝備連結技能資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterLinkSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterLinkSkillDTO<CharacterLinkSkillInfoDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 角色職業
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 連結技能資訊
     */
    @SerializedName("character_link_skill")
    private List<CharacterLinkSkillInfoDTO> characterLinkSkill;

    /**
     * 連結技能 1 預設資訊
     */
    @SerializedName("character_link_skill_preset_1")
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset1;

    /**
     * 連結技能 2 預設資訊
     */
    @SerializedName("character_link_skill_preset_2")
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset2;

    /**
     * 連結技能 3 預設資訊
     */
    @SerializedName("character_link_skill_preset_3")
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset3;

    /**
     * 我的連結技能資訊
     */
    @SerializedName("character_owned_link_skill")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkill;

    /**
     * 我的連結技能 1 預設資訊
     */
    @SerializedName("character_owned_link_skill_preset_1")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset1;

    /**
     * 我的連結技能 2 預設資訊
     */
    @SerializedName("character_owned_link_skill_preset_2")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset2;

    /**
     * 我的連結技能 3 預設資訊
     */
    @SerializedName("character_owned_link_skill_preset_3")
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
