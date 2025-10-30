package dev.spiralmoon.maplestory.api.kms.dto.character;

import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터 외형 이미지 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterImageDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterImageDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    private ZonedDateTime date;

    /**
     * 캐릭터 외형 이미지 원본 (URL)
     */
    private String originUrl;

    /**
     * 캐릭터 외형 기본 이미지 (base64)
     */
    private String originImage;

    /**
     * 캐릭터 외형 이미지 (base64)
     */
    private String image;

    /**
     * 캐릭터 액션
     */
    private CharacterImageAction action;

    /**
     * 캐릭터 감정표현
     */
    private CharacterImageEmotion emotion;

    /**
     * 캐릭터 무기 모션
     */
    private CharacterImageWeaponMotion wmotion;

    /**
     * 캐릭터 액션 프레임
     */
    private int actionFrame;

    /**
     * 캐릭터 감정표현 프레임
     */
    private int emotionFrame;

    /**
     * 가로 길이. 배경 크기에 해당함
     */
    private Integer width;

    /**
     * 세로 길이. 배경 크기에 해당함
     */
    private Integer height;

    /**
     * 캐릭터의 가로 좌표
     */
    private Integer x;

    /**
     * 캐릭터의 세로 좌표
     */
    private Integer y;
}
