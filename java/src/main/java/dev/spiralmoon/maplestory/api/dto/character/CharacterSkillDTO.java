package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 스킬 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSkillDTO {

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
     * 스킬 전직 차수
     */
    @SerializedName("character_skill_grade")
    private String characterSkillGrade;

    /**
     * 스킬 정보 리스트
     */
    @SerializedName("character_skill")
    private List<CharacterLinkSkillInfoDTO> characterSkill;

    public LocalDateTime getDate() {
        return date != null
                ? Utils.toLocalDateTime(this.date)
                : null;
    }
}
