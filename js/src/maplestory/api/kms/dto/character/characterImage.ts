import * as base from '../../../common/dto/character/characterImage';
import {
  CharacterImageAction,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
} from '../../../common/enum/characterImage';

/**
 * 캐릭터 외형 이미지 정보
 */
export class CharacterImageDto extends base.CharacterImageDto {
  /**
   * 조회 기준일
   */
  public override date: Date | null;

  /**
   * 캐릭터 외형 이미지 원본 (URL)
   */
  public override originUrl: string;

  /**
   * 캐릭터 외형 기본 이미지 (base64)
   */
  public override originImage: string;

  /**
   * 캐릭터 외형 이미지 (base64)
   */
  public override image: string;

  /**
   * 캐릭터 액션
   */
  public override action: CharacterImageAction;

  /**
   * 캐릭터 감정표현
   */
  public override emotion: CharacterImageEmotion;

  /**
   * 캐릭터 무기 모션
   */
  public override wmotion: CharacterImageWeaponMotion;

  /**
   * 캐릭터 액션 프레임
   */
  public override actionFrame: number | null;

  /**
   * 캐릭터 감정표현 프레임
   */
  public override emotionFrame: number | null;

  /**
   * 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
   */
  public override width: number;

  /**
   * 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
   */
  public override height: number;

  /**
   * 캐릭터의 가로 좌표
   */
  public override x: number | null;

  /**
   * 캐릭터의 세로 좌표.
   */
  public override y: number | null;

  constructor(obj: {
    date: Date | null;
    originUrl: string;
    originImage: string;
    image: string;
    action: CharacterImageAction;
    emotion: CharacterImageEmotion;
    wmotion: CharacterImageWeaponMotion;
    actionFrame: number | null;
    emotionFrame: number | null;
    width: number;
    height: number;
    x: number | null;
    y: number | null;
  }) {
    super();

    this.date = obj.date;
    this.originUrl = obj.originUrl;
    this.originImage = obj.originImage;
    this.image = obj.image;
    this.action = obj.action;
    this.emotion = obj.emotion;
    this.wmotion = obj.wmotion;
    this.actionFrame = obj.actionFrame;
    this.emotionFrame = obj.emotionFrame;
    this.width = obj.width;
    this.height = obj.height;
    this.x = obj.x;
    this.y = obj.y;
  }
}
