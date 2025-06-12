package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 링크 스킬 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterLinkSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterLinkSkillDTO<
        CharacterLinkSkillInfoDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
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

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
