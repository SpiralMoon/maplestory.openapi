import { CharacterSkillInfoDto } from '@src/maplestory/api/dto/character/characterSkillInfoDto';
import { CharacterSkillDtoBody } from '@src/maplestory/api/response/character/characterSkillDtoBody';

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
  characterClass: string;

  /**
   * 스킬 전직 차수
   */
  characterSkillGrade: string;

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
