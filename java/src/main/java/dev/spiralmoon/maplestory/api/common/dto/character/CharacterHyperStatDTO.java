package dev.spiralmoon.maplestory.api.common.dto.character;

import java.time.ZonedDateTime;
import java.util.List;

public interface CharacterHyperStatDTO<CharacterHyperStatPreset extends CharacterHyperStatPresetDTO> {
    ZonedDateTime getDate();
    String getCharacterClass();
    String getUsePresetNo();
    Integer getUseAvailableHyperStat();
    List<CharacterHyperStatPreset> getHyperStatPreset1();
    Integer getHyperStatPreset1RemainPoint();
    List<CharacterHyperStatPreset> getHyperStatPreset2();
    Integer getHyperStatPreset2RemainPoint();
    List<CharacterHyperStatPreset> getHyperStatPreset3();
    Integer getHyperStatPreset3RemainPoint();
}
