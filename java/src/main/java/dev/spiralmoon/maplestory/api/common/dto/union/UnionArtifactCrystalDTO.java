package dev.spiralmoon.maplestory.api.common.dto.union;

import java.time.ZonedDateTime;

public interface UnionArtifactCrystalDTO {
    String getName();
    String getValidityFlag();
    ZonedDateTime getDateExpire();
    int getLevel();
    String getCrystalOptionName1();
    String getCrystalOptionName2();
    String getCrystalOptionName3();
    Boolean isExpired();
}
