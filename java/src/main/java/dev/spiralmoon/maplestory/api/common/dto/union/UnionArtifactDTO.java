package dev.spiralmoon.maplestory.api.common.dto.union;

import java.time.ZonedDateTime;
import java.util.List;

public interface UnionArtifactDTO<UnionArtifactEffect extends UnionArtifactEffectDTO, UnionArtifactCrystal extends UnionArtifactCrystalDTO> {
    ZonedDateTime getDate();
    List<UnionArtifactEffect> getUnionArtifactEffect();
    List<UnionArtifactCrystal> getUnionArtifactCrystal();
    Integer getUnionArtifactRemainAp();
}
