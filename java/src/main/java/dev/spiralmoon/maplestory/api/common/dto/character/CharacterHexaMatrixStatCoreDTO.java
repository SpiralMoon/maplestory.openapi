package dev.spiralmoon.maplestory.api.common.dto.character;

public interface CharacterHexaMatrixStatCoreDTO {
    String getSlotId();
    String getMainStatName();
    String getSubStatName1();
    String getSubStatName2();
    long getMainStatLevel();
    long getSubStatLevel1();
    long getSubStatLevel2();
    long getStatGrade();
}
