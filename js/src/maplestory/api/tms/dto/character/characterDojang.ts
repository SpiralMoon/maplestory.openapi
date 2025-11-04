import * as base from '../../../common/dto/character/characterDojang';
import { CharacterDojangBody } from '../../response/character/characterDojangBody';

/**
 * 角色在武陵道場的最高紀錄資訊
 */
export class CharacterDojangDto extends base.CharacterDojangDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 角色職業
   */
  public override characterClass: string;

  /**
   * 世界名稱
   */
  public override worldName: string;

  /**
   * 武陵道場最高紀錄層數
   */
  public override dojangBestFloor: number;

  /**
   * 達成武陵道場最高紀錄的日期 (TST，每日資料的小時與分鐘顯示為 0)
   */
  public override dateDojangRecord: Date | null;

  /**
   * 通關武陵道場最高樓層所花費的時間 (秒)
   */
  public override dojangBestTime: number;

  constructor(obj: CharacterDojangBody) {
    super();

    const {
      date,
      character_class,
      world_name,
      dojang_best_floor,
      date_dojang_record,
      dojang_best_time,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class!;
    this.worldName = world_name!;
    this.dojangBestFloor = dojang_best_floor!;
    this.dateDojangRecord = date_dojang_record
      ? new Date(date_dojang_record)
      : null;
    this.dojangBestTime = dojang_best_time!;
  }
}
