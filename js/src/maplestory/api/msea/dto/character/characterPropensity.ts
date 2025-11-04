import * as base from '../../../common/dto/character/characterPropensity';
import { CharacterPropensityBody } from '../../response/character/characterPropensityBody';

/**
 * Character traits information
 */
export class CharacterPropensityDto extends base.CharacterPropensityDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Ambition level
   */
  public override charismaLevel: number;

  /**
   * Empathy level
   */
  public override sensibilityLevel: number;

  /**
   * Insight level
   */
  public override insightLevel: number;

  /**
   * Willpower level
   */
  public override willingnessLevel: number;

  /**
   * Diligence level
   */
  public override handicraftLevel: number;

  /**
   * Charm level
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
