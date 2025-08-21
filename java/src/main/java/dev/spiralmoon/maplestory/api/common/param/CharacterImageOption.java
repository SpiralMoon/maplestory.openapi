package dev.spiralmoon.maplestory.api.common.param;

import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;

public interface CharacterImageOption {
    CharacterImageAction getAction();
    void setAction(CharacterImageAction action);

    CharacterImageEmotion getEmotion();
    void setEmotion(CharacterImageEmotion emotion);

    CharacterImageWeaponMotion getWmotion();
    void setWmotion(CharacterImageWeaponMotion wmotion);

    int getActionFrame();
    void setActionFrame(int actionFrame);

    int getEmotionFrame();
    void setEmotionFrame(int emotionFrame);
}
