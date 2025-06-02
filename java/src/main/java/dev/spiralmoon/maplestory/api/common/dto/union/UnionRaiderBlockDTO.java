package dev.spiralmoon.maplestory.api.common.dto.union;

import java.util.List;

public interface UnionRaiderBlockDTO<UnionRaiderBlockControlPoint extends UnionRaiderBlockControlPointDTO, UnionRaiderBlockPosition extends UnionRaiderBlockPositionDTO> {
    String getBlockType();
    String getBlockClass();
    String getBlockLevel();
    UnionRaiderBlockControlPoint getBlockControlPoint();
    List<UnionRaiderBlockPosition> getBlockPosition();
}
