import { CharacterSkillInfoDto } from './characterSkillInfoDto';
import { CharacterSkillDtoBody } from '../../response/character/characterSkillDtoBody';

/**
 * 캐릭터 스킬 정보
 */
class CharacterSkillDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 직업
   */
  characterClass: string | null;

  /**
   * 스킬 전직 차수
   */
  characterSkillGrade: string | null;

  /**
   * 스킬 정보
   */
  characterSkill: CharacterSkillInfoDto[];

  constructor(obj: CharacterSkillDtoBody) {
    const { date, character_class, character_skill_grade, character_skill } =
      obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.characterSkillGrade = character_skill_grade;
    this.characterSkill = character_skill.map(
      (skill) => new CharacterSkillInfoDto(skill),
    );
  }
}

export { CharacterSkillDto };
