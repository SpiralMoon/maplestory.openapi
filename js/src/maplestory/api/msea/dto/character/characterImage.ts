import * as base from '../../../common/dto/character/characterImage';
import {
  CharacterImageAction,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
} from '../../../common/enum/characterImage';

/**
 * Character image information
 */
export class CharacterImageDto extends base.CharacterImageDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character image original (URL)
   */
  public override originUrl: string;

  /**
   * Character image original (base64)
   */
  public override originImage: string;

  /**
   * Character image (base64)
   */
  public override image: string;

  /**
   * Character action
   */
  public override action: CharacterImageAction;

  /**
   * Character emotion
   */
  public override emotion: CharacterImageEmotion;

  /**
   * Character weapon motion
   */
  public override wmotion: CharacterImageWeaponMotion;

  /**
   * Character action frame
   */
  public override actionFrame: number | null;

  /**
   * Character emotion frame
   */
  public override emotionFrame: number | null;

  /**
   * Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
   */
  public override width: number;

  /**
   * Vertical length (corresponding to the background size, 96 (default) ~ 1000)
   */
  public override height: number;

  /**
   * Horizontal coordinate of the character
   */
  public override x: number | null;

  /**
   * Vertical coordinate of the character
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
