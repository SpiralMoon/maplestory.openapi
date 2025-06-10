package dev.spiralmoon.maplestory.api.common.dto.union;

import java.time.ZonedDateTime;

public interface UnionDTO {
    ZonedDateTime getDate();
    Integer getUnionLevel();
    String getUnionGrade();
    Integer getUnionArtifactLevel();
    Integer getUnionArtifactExp();
    Integer getUnionArtifactPoint();
}
