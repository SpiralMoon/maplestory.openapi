package dev.spiralmoon.maplestory.api.param;

import dev.spiralmoon.maplestory.api.dto.character.CharacterImageAction;
import dev.spiralmoon.maplestory.api.dto.character.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.dto.character.CharacterImageWeaponMotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 캐릭터 외형 이미지 파라미터
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CharacterImageOption {

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
     * 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
     */
    private Integer width = 96;

    /**
     * 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
     */
    private Integer height = 96;

    /**
     * 캐릭터의 가로 좌표
     */
    private Integer x;

    /**
     * 캐릭터의 세로 좌표
     */
    private Integer y;
}
