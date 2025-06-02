package dev.spiralmoon.maplestory.api.common.dto.union;

import java.time.ZonedDateTime;
import java.util.List;

public interface UnionRaiderDTO<UnionRaiderInnerStat extends UnionRaiderInnerStatDTO,UnionRaiderBlock extends UnionRaiderBlockDTO<?, ?>, UnionRaiderPreset extends UnionRaiderPresetDTO<?, ?>> {
    ZonedDateTime getDate();
    List<String> getUnionRaiderStat();
    List<String> getUnionOccupiedStat();
    List<UnionRaiderInnerStat> getUnionInnerStat();
    List<UnionRaiderBlock> getUnionBlock();
    int getUsePresetNo();
    UnionRaiderPreset getUnionRaiderPreset1();
    UnionRaiderPreset getUnionRaiderPreset2();
    UnionRaiderPreset getUnionRaiderPreset3();
    UnionRaiderPreset getUnionRaiderPreset4();
    UnionRaiderPreset getUnionRaiderPreset5();
}
