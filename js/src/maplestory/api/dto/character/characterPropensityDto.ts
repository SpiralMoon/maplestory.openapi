import { CharacterPropensityDtoBody } from '../../response/character/characterPropensityDtoBody';

/**
 * 캐릭터 성향 정보
 */
class CharacterPropensityDto {
  date: Date | null;

  /**
   * 카리스마 레벨
   */
  charismaLevel: number | null;

  /**
   * 감성 레벨
   */
  sensibilityLevel: number | null;

  /**
   * 통찰력 레벨
   */
  insightLevel: number | null;

  /**
   *  의지 레벨
   */
  willingnessLevel: number | null;

  /**
   * 손재주 레벨
   */
  handicraftLevel: number | null;

  /**
   * 매력 레벨
   */
  charmLevel: number | null;

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

    this.date = date ? new Date(date) : null;
    this.charismaLevel = charisma_level;
    this.sensibilityLevel = sensibility_level;
    this.insightLevel = insight_level;
    this.willingnessLevel = willingness_level;
    this.handicraftLevel = handicraft_level;
    this.charmLevel = charm_level;
  }
}

export { CharacterPropensityDto };
