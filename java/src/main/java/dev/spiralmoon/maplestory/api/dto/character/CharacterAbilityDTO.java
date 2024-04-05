package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 어빌리티 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterAbilityDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 어빌리티 등급
     */
    @SerializedName("ability_grade")
    private String abilityGrade;

    /**
     * 어빌리티 정보 리스트
     */
    @SerializedName("ability_info")
    private List<CharacterAbilityInfoDTO> abilityInfo;

    /**
     * 보유 명성치
     */
    @SerializedName("remain_fame")
    private long remainFame;

    /**
     * 적용 중인 어빌리티 프리셋 번호
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * 어빌리티 1번 프리셋 전체 정보
     */
    @SerializedName("ability_preset_1")
    private CharacterAbilityPresetDTO abilityPreset1;

    /**
     * 어빌리티 2번 프리셋 전체 정보
     */
    @SerializedName("ability_preset_2")
    private CharacterAbilityPresetDTO abilityPreset2;

    /**
     * 어빌리티 3번 프리셋 전체 정보
     */
    @SerializedName("ability_preset_3")
    private CharacterAbilityPresetDTO abilityPreset3;

    public LocalDateTime getDate() {
        return date != null
                ? Utils.toLocalDateTime(this.date)
                : null;
    }
}
