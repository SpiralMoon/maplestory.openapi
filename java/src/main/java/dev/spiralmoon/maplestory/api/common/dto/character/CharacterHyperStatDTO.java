package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterHyperStatDTO<CharacterHyperStatPreset extends CharacterHyperStatPresetDTO> {
    ZonedDateTime getDate();
    String getCharacterClass();
    String getUsePresetNo();
    int getUseAvailableHyperStat();
    List<CharacterHyperStatPreset> getHyperStatPreset1();
    int getHyperStatPreset1RemainPoint();
    List<CharacterHyperStatPreset> getHyperStatPreset2();
    int getHyperStatPreset2RemainPoint();
    List<CharacterHyperStatPreset> getHyperStatPreset3();
    int getHyperStatPreset3RemainPoint();
}
