package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 스킬 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterSkillDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterSkillDTO<CharacterSkillInfoDTO> {

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
     * 스킬 전직 차수
     */
    @SerializedName("character_skill_grade")
    private String characterSkillGrade;

    /**
     * 스킬 정보 리스트
     */
    @SerializedName("character_skill")
    private List<CharacterSkillInfoDTO> characterSkill;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
