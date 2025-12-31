package dev.spiralmoon.maplestory.api.common.dto.union;

import java.time.ZonedDateTime;
import java.util.List;

public interface UnionChampionDTO<
        UnionChampionInfo extends UnionChampionInfoDTO<?>,
        UnionChampionBadgeInfo extends UnionChampionBadgeInfoDTO> {
    ZonedDateTime getDate();
    List<UnionChampionInfo> getUnionChampion();
    List<UnionChampionBadgeInfo> getChampionBadgeTotalInfo();
}
