import * as base from '../../../common/dto/character/characterPropensity';
import { CharacterPropensityBody } from '../../response/character/characterPropensityBody';

/**
 * 角色性向資訊
 */
export class CharacterPropensityDto extends base.CharacterPropensityDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 領導力等級
   */
  public override charismaLevel: number;

  /**
   * 感性等級
   */
  public override sensibilityLevel: number;

  /**
   * 洞察力等級
   */
  public override insightLevel: number;

  /**
   * 意志等級
   */
  public override willingnessLevel: number;

  /**
   * 手藝等級
   */
  public override handicraftLevel: number;

  /**
   * 魅力等級
   */
  public override charmLevel: number;

  constructor(obj: CharacterPropensityBody) {
    super();

    const {
      date,
      charisma_level,
      sensibility_level,
      insight_level,
      willingness_level,
      handicraft_level,
      charm_level,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.charismaLevel = charisma_level!;
    this.sensibilityLevel = sensibility_level!;
    this.insightLevel = insight_level!;
    this.willingnessLevel = willingness_level!;
    this.handicraftLevel = handicraft_level!;
    this.charmLevel = charm_level!;
  }
}
