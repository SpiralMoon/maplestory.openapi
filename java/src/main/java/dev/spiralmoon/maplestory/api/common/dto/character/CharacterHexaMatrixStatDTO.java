package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterHexaMatrixStatDTO<CharacterHexaMatrixStatCore extends CharacterHexaMatrixStatCoreDTO> {
    ZonedDateTime getDate();
    String getCharacterClass();
    List<CharacterHexaMatrixStatCore> getCharacterHexaStatCore();
    List<CharacterHexaMatrixStatCore> getCharacterHexaStatCore2();
    List<CharacterHexaMatrixStatCore> getCharacterHexaStatCore3();
    List<CharacterHexaMatrixStatCore> getPresetHexaStatCore();
    List<CharacterHexaMatrixStatCore> getPresetHexaStatCore2();
    List<CharacterHexaMatrixStatCore> getPresetHexaStatCore3();
}
