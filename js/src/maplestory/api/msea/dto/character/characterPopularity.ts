import * as base from '../../../common/dto/character/characterPopularity';
import { CharacterPopularityBody } from '../../response/character/characterPopularityBody';

/**
 * Character popularity information
 */
export class CharacterPopularityDto extends base.CharacterPopularityDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Character popularity
   */
  public override popularity: number;

  constructor(obj: CharacterPopularityBody) {
    super();

    const { date, popularity } = obj;

    this.date = date ? new Date(date) : null;
    this.popularity = popularity;
  }
}
