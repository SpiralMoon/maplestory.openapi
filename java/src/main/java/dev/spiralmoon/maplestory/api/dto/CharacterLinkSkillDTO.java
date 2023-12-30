package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

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
    private CharacterLinkSkillInfoDTO characterLinkSkill;

    /**
     * 내 링크 스킬 정보
     */
    @SerializedName("character_owned_link_skill")
    private CharacterLinkSkillInfoDTO characterOwnedLinkSkill;

    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }
}
