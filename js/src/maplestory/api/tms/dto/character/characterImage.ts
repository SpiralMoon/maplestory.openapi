import * as base from '../../../common/dto/character/characterImage';
import {
  CharacterImageAction,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
} from '../../../common/enum/characterImage';

/**
 * 角色外型圖片資訊
 */
export class CharacterImageDto extends base.CharacterImageDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色外型圖片原始 (URL)
   */
  public override originUrl: string;

  /**
   * 角色外型圖片原始 (base64)
   */
  public override originImage: string;

  /**
   * 角色外型圖片 (base64)
   */
  public override image: string;

  /**
   * 角色動作
   */
  public override action: CharacterImageAction;

  /**
   * 角色表情
   */
  public override emotion: CharacterImageEmotion;

  /**
   * 角色武器動作
   */
  public override wmotion: CharacterImageWeaponMotion;

  /**
   * 角色動作影格
   */
  public override actionFrame: number | null;

  /**
   * 角色表情影格
   */
  public override emotionFrame: number | null;

  /**
   * 寬度 (對應背景大小，96 (預設) 至 1000)
   */
  public override width: number;

  /**
   * 高度 (對應背景大小，96 (預設) 至 1000)
   */
  public override height: number;

  /**
   * 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
   */
  public override x: number | null;

  /**
   * 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
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
