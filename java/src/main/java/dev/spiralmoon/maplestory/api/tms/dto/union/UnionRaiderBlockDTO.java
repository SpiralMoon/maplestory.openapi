package dev.spiralmoon.maplestory.api.tms.dto.union;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 聯盟方塊資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UnionRaiderBlockDTO implements dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderBlockDTO<UnionRaiderBlockControlPointDTO, UnionRaiderBlockPositionDTO> {

    /**
     * 方塊編制 (戰士、法師、弓箭手、盜賊、海盜、混合)
     */
    @JsonProperty("block_type")
    private String blockType;

    /**
     * 方塊角色職業
     */
    @JsonProperty("block_class")
    private String blockClass;

    /**
     * 方塊角色等級
     */
    @JsonProperty("block_level")
    private String blockLevel;

    /**
     * 方塊基準點座標
     */
    @JsonProperty("block_control_point")
    private UnionRaiderBlockControlPointDTO blockControlPoint;

    /**
     * 方塊佔領區域的座標 (null：未部署時)
     */
    @JsonProperty("block_position")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UnionRaiderBlockPositionDTO> blockPosition;
}
