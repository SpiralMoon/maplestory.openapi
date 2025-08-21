package dev.spiralmoon.maplestory.api.kms.param;

import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CharacterImageOption implements dev.spiralmoon.maplestory.api.common.param.CharacterImageOption {

    /**
     * 캐릭터 액션
     */
    private CharacterImageAction action = CharacterImageAction.Stand1;

    /**
     * 캐릭터 감정표현
     */
    private CharacterImageEmotion emotion = CharacterImageEmotion.Default;

    /**
     * 캐릭터 무기 모션
     */
    private CharacterImageWeaponMotion wmotion = CharacterImageWeaponMotion.Default;

    /**
     * 캐릭터 액션 프레임
     */
    private int actionFrame = 0;

    /**
     * 캐릭터 감정표현 프레임
     */
    private int emotionFrame = 0;
}
