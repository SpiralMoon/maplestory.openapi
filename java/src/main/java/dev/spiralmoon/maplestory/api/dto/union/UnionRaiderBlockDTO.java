package dev.spiralmoon.maplestory.api.dto.union;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 유니온 블록 정보
 */
@AllArgsConstructor
@Data
@ToString
public class UnionRaiderBlockDTO {

    /**
     * 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
     */
    @SerializedName("block_type")
    private String blockType;

    /**
     * 블록 해당 캐릭터 직업
     */
    @SerializedName("block_class")
    private String blockClass;

    /**
     * 블록 해당 캐릭터 레벨
     */
    @SerializedName("block_level")
    private String blockLevel;

    /**
     * 블록 기준점 좌표
     */
    @SerializedName("block_control_point")
    private UnionRaiderBlockControlPointDTO blockControlPoint;

    /**
     * 블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
     */
    @SerializedName("block_position")
    private List<UnionRaiderBlockPositionDTO> blockPosition;
}
