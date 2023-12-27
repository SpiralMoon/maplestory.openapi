import { CharacterLinkSkillInfoDto } from './characterLinkSkillInfoDto';
import { CharacterLinkSkillDtoBody } from '../response/characterLinkSkillDtoBody';

/**
 * 캐릭터 링크 스킬 정보
 */
class CharacterLinkSkillDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * 링크 스킬 정보
   */
  characterLinkSkill: CharacterLinkSkillInfoDto;

  /**
   * 내 링크 스킬 정보
   */
  characterOwnedLinkSkill: CharacterLinkSkillInfoDto;

  constructor(obj: CharacterLinkSkillDtoBody) {
    const {
      date,
      character_class,
      character_link_skill,
      character_owned_link_skill,
    } = obj;

    this.date = new Date(date);
    this.characterClass = character_class;
    this.characterLinkSkill = new CharacterLinkSkillInfoDto(
      character_link_skill,
    );
    this.characterOwnedLinkSkill = new CharacterLinkSkillInfoDto(
      character_owned_link_skill,
    );
  }
}

export { CharacterLinkSkillDto };
