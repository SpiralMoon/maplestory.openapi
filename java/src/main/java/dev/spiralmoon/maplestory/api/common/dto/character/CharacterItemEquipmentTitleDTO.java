package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;

public interface CharacterItemEquipmentTitleDTO {
    String getTitleName();
    String getTitleIcon();
    String getTitleDescription();
    ZonedDateTime getDateExpire();
    Boolean isExpired();
    ZonedDateTime getDateOptionExpire();
    Boolean isOptionExpired();
    String getTitleShapeName();
    String getTitleShapeIcon();
    String getTitleShapeDescription();
}
