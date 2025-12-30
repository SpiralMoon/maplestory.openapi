package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;

public interface CharacterItemEquipmentDragonInfoDTO<
        CharacterItemEquipmentTotalOption extends CharacterItemEquipmentTotalOptionDTO,
        CharacterItemEquipmentBaseOption extends CharacterItemEquipmentBaseOptionDTO,
        CharacterItemEquipmentExceptionalOption extends CharacterItemEquipmentExceptionalOptionDTO,
        CharacterItemEquipmentAddOption extends CharacterItemEquipmentAddOptionDTO,
        CharacterItemEquipmentEtcOption extends CharacterItemEquipmentEtcOptionDTO,
        CharacterItemEquipmentStarforceOption extends CharacterItemEquipmentStarforceOptionDTO> {
    String getItemEquipmentPart();
    String getItemEquipmentSlot();
    String getItemName();
    String getItemIcon();
    String getItemDescription();
    String getItemShapeName();
    String getItemShapeIcon();
    String getItemGender();
    CharacterItemEquipmentTotalOption getItemTotalOption();
    CharacterItemEquipmentBaseOption getItemBaseOption();
    long getEquipmentLevelIncrease();
    CharacterItemEquipmentExceptionalOption getItemExceptionalOption();
    CharacterItemEquipmentAddOption getItemAddOption();
    long getGrowthExp();
    long getGrowthLevel();
    String getScrollUpgrade();
    String getCuttableCount();
    String getGoldenHammerFlag();
    String getScrollResilienceCount();
    String getScrollUpgradeableCount();
    String getSoulName();
    String getSoulOption();
    CharacterItemEquipmentEtcOption getItemEtcOption();
    String getStarforce();
    String getStarforceScrollFlag();
    CharacterItemEquipmentStarforceOption getItemStarforceOption();
    long getSpecialRingLevel();
    ZonedDateTime getDateExpire();
    Boolean isExpired();
    String getFreestyleFlag();
}
