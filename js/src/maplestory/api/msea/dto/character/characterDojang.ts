import * as base from '../../../common/dto/character/characterDojang';
import { CharacterDojangBody } from '../../response/character/characterDojangBody';

/**
 * Character Mu Lung Garden highest record information
 */
export class CharacterDojangDto extends base.CharacterDojangDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character job
   */
  public override characterClass: string;

  /**
   * World name
   */
  public override worldName: string;

  /**
   * Highest floor record in Mu Lung Garden
   */
  public override dojangBestFloor: number;

  /**
   * Achievement date of the highest Mu Lung Garden record (SGT, daily data with hours and minutes set to 0)
   */
  public override dateDojangRecord: Date | null;

  /**
   * Time taken to clear the highest floor in Mu Lung Garden (in seconds)
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
