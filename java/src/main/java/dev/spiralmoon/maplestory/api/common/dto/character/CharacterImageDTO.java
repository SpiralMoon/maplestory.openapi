package dev.spiralmoon.maplestory.api.common.dto.character;

import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;

import java.time.ZonedDateTime;

public interface CharacterImageDTO {
    ZonedDateTime getDate();
    String getOriginUrl();
    String getOriginImage();
    String getImage();
    CharacterImageAction getAction();
    CharacterImageEmotion getEmotion();
    CharacterImageWeaponMotion getWmotion();
    int getActionFrame();
    int getEmotionFrame();
    Integer getWidth();
    Integer getHeight();
    Integer getX();
    Integer getY();
}
