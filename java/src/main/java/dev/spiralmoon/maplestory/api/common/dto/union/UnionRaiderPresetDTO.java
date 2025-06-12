package dev.spiralmoon.maplestory.api.common.dto.union;

import java.util.List;

public interface UnionRaiderPresetDTO<UnionRaiderInnerStat extends UnionRaiderInnerStatDTO, UnionRaiderBlock extends UnionRaiderBlockDTO<?, ?>> {
    List<String> getUnionRaiderStat();
    List<String> getUnionOccupiedStat();
    List<UnionRaiderInnerStat> getUnionInnerStat();
    List<UnionRaiderBlock> getUnionBlock();
}
