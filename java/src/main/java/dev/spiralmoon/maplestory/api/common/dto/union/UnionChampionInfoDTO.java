package dev.spiralmoon.maplestory.api.common.dto.union;

import java.util.List;

public interface UnionChampionInfoDTO<UnionChampionBadgeInfo extends UnionChampionBadgeInfoDTO> {
    String getChampionName();
    int getChampionSlot();
    String getChampionGrade();
    String getChampionClass();
    List<UnionChampionBadgeInfo> getChampionBadgeInfo();
}
