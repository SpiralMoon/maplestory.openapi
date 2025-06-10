import * as base from '../../../common/dto/character/characterPropensity';
import { CharacterPropensityBody } from '../../response/character/characterPropensityBody';

/**
 * 캐릭터 성향 정보
 */
export class CharacterPropensityDto extends base.CharacterPropensityDto {
  public override date: Date | null;

  /**
   * 카리스마 레벨
   */
  public override charismaLevel: number | null;

  /**
   * 감성 레벨
   */
  public override sensibilityLevel: number | null;

  /**
   * 통찰력 레벨
   */
  public override insightLevel: number | null;

  /**
   *  의지 레벨
   */
  public override willingnessLevel: number | null;

  /**
   * 손재주 레벨
   */
  public override handicraftLevel: number | null;

  /**
   * 매력 레벨
   */
  public override charmLevel: number | null;

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
    this.charismaLevel = charisma_level;
    this.sensibilityLevel = sensibility_level;
    this.insightLevel = insight_level;
    this.willingnessLevel = willingness_level;
    this.handicraftLevel = handicraft_level;
    this.charmLevel = charm_level;
  }
}
