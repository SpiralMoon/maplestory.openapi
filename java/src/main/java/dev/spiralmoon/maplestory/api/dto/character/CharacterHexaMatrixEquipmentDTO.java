package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 캐릭터 HEXA 코어 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixEquipmentDTO {

    /**
     * 코어 명
     */
    @SerializedName("hexa_core_name")
    private String hexaCoreName;

    /**
     * 코어 레벨
     */
    @SerializedName("hexa_core_level")
    private Long hexaCoreLevel;

    /**
     * 코어 타입
     */
    @SerializedName("hexa_core_type")
    private String hexaCoreType;

    /**
     * 연결된 스킬
     */
    @SerializedName("linked_skill")
    private List<CharacterHexaMatrixEquipmentLinkedSkillDTO> linkedSkill;
}
