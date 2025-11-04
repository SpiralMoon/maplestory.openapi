package dev.spiralmoon.maplestory.api.kms.dto.character;

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
 * 캐릭터 어빌리티 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterAbilityDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterAbilityDTO<
        CharacterAbilityInfoDTO,
        CharacterAbilityPresetDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 어빌리티 등급
     */
    @JsonProperty("ability_grade")
    private String abilityGrade;

    /**
     * 어빌리티 정보 리스트
     */
    @JsonProperty("ability_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterAbilityInfoDTO> abilityInfo;

    /**
     * 보유 명성치
     */
    @JsonProperty("remain_fame")
    private long remainFame;

    /**
     * 적용 중인 어빌리티 프리셋 번호
     */
    @JsonProperty("preset_no")
    private Integer presetNo;

    /**
     * 어빌리티 1번 프리셋 전체 정보
     */
    @JsonProperty("ability_preset_1")
    private CharacterAbilityPresetDTO abilityPreset1;

    /**
     * 어빌리티 2번 프리셋 전체 정보
     */
    @JsonProperty("ability_preset_2")
    private CharacterAbilityPresetDTO abilityPreset2;

    /**
     * 어빌리티 3번 프리셋 전체 정보
     */
    @JsonProperty("ability_preset_3")
    private CharacterAbilityPresetDTO abilityPreset3;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
