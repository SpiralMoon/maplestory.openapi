import * as base from '../../../common/dto/character/characterPopularity';
import { CharacterPopularityBody } from '../../response/character/characterPopularityBody';

/**
 * 角色名聲資訊
 */
export class CharacterPopularityDto extends base.CharacterPopularityDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色名聲
   */
  public override popularity: number;

  constructor(obj: CharacterPopularityBody) {
    super();

    const { date, popularity } = obj;

    this.date = date ? new Date(date) : null;
    this.popularity = popularity!;
  }
}
