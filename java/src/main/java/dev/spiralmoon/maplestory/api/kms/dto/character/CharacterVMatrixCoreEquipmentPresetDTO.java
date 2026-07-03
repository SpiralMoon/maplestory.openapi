package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 V코어 프리셋 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterVMatrixCoreEquipmentPresetDTO {

    /**
     * 코어 명
     */
    @JsonProperty("v_core_name")
    private String vCoreName;

    /**
     * 코어 타입
     */
    @JsonProperty("v_core_type")
    private String vCoreType;

    /**
     * 코어의 레벨
     */
    @JsonProperty("v_core_level")
    private long vCoreLevel;
}
