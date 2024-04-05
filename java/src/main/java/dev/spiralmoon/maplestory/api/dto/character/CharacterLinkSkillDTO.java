package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 링크 스킬 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterLinkSkillDTO {

    /**
     * 조회 기준일 (KST)
     */
    @SerializedName("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 링크 스킬 정보
     */
    @SerializedName("character_link_skill")
    private List<CharacterLinkSkillInfoDTO> characterLinkSkill;

    /**
     * 링크 스킬 1번 프리셋 정보
     */
    @SerializedName("character_link_skill_preset_1")
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset1;

    /**
     * 링크 스킬 2번 프리셋 정보
     */
    @SerializedName("character_link_skill_preset_2")
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset2;

    /**
     * 링크 스킬 3번 프리셋 정보
     */
    @SerializedName("character_link_skill_preset_3")
    private List<CharacterLinkSkillInfoDTO> characterLinkSkillPreset3;

    /**
     * 내 링크 스킬 정보
     */
    @SerializedName("character_owned_link_skill")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkill;

    /**
     * 내 링크 스킬 1번 프리셋 정보
     */
    @SerializedName("character_owned_link_skill_preset_1")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset1;

    /**
     * 내 링크 스킬 2번 프리셋 정보
     */
    @SerializedName("character_owned_link_skill_preset_2")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset2;

    /**
     * 내 링크 스킬 3번 프리셋 정보
     */
    @SerializedName("character_owned_link_skill_preset_3")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkillPreset3;

    public LocalDateTime getDate() {
        return date != null
                ? Utils.toLocalDateTime(this.date)
                : null;
    }
}
