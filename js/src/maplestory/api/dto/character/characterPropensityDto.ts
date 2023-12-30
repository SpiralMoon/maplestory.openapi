import { CharacterPropensityDtoBody } from '../../response/character/characterPropensityDtoBody';

/**
 * 캐릭터 성향 정보
 */
class CharacterPropensityDto {
  date: Date;

  /**
   * 카리스마 레벨
   */
  charismaLevel: number;

  /**
   * 감성 레벨
   */
  sensibilityLevel: number;

  /**
   * 통찰력 레벨
   */
  insightLevel: number;

  /**
   *  의지 레벨
   */
  willingnessLevel: number;

  /**
   * 손재주 레벨
   */
  handicraftLevel: number;

  /**
   * 매력 레벨
   */
  charmLevel: number;

  constructor(obj: CharacterPropensityDtoBody) {
    const {
      date,
      charisma_level,
      sensibility_level,
      insight_level,
      willingness_level,
      handicraft_level,
      charm_level,
    } = obj;

    this.date = new Date(date);
    this.charismaLevel = charisma_level;
    this.sensibilityLevel = sensibility_level;
    this.insightLevel = insight_level;
    this.willingnessLevel = willingness_level;
    this.handicraftLevel = handicraft_level;
    this.charmLevel = charm_level;
  }
}

export { CharacterPropensityDto };
