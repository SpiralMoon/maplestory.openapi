import { CharacterLinkSkillInfoDto } from '@src/maplestory/api/dto/character/characterLinkSkillInfoDto';
import { CharacterLinkSkillDtoBody } from '@src/maplestory/api/response/character/characterLinkSkillDtoBody';

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
  characterLinkSkill: CharacterLinkSkillInfoDto[];

  /**
   * 링크 스킬 1번 프리셋 정보
   */
  characterLinkSkillPreset1: CharacterLinkSkillInfoDto[];

  /**
   * 링크 스킬 2번 프리셋 정보
   */
  characterLinkSkillPreset2: CharacterLinkSkillInfoDto[];

  /**
   * 링크 스킬 3번 프리셋 정보
   */
  characterLinkSkillPreset3: CharacterLinkSkillInfoDto[];

  /**
   * 내 링크 스킬 정보
   */
  characterOwnedLinkSkill: CharacterLinkSkillInfoDto;

  /**
   * 내 링크 스킬 1번 프리셋 정보
   */
  characterOwnedLinkSkillPreset1: CharacterLinkSkillInfoDto | null;

  /**
   * 내 링크 스킬 2번 프리셋 정보
   */
  characterOwnedLinkSkillPreset2: CharacterLinkSkillInfoDto | null;

  /**
   * 내 링크 스킬 3번 프리셋 정보
   */
  characterOwnedLinkSkillPreset3: CharacterLinkSkillInfoDto | null;

  constructor(obj: CharacterLinkSkillDtoBody) {
    const {
      date,
      character_class,
      character_link_skill,
      character_link_skill_preset_1,
      character_link_skill_preset_2,
      character_link_skill_preset_3,
      character_owned_link_skill,
      character_owned_link_skill_preset_1,
      character_owned_link_skill_preset_2,
      character_owned_link_skill_preset_3,
    } = obj;

    this.date = new Date(date);
    this.characterClass = character_class;
    this.characterLinkSkill = character_link_skill.map(
      (skill) => new CharacterLinkSkillInfoDto(skill),
    );
    this.characterLinkSkillPreset1 = character_link_skill_preset_1.map(
      (skill) => new CharacterLinkSkillInfoDto(skill),
    );
    this.characterLinkSkillPreset2 = character_link_skill_preset_2.map(
      (skill) => new CharacterLinkSkillInfoDto(skill),
    );
    this.characterLinkSkillPreset3 = character_link_skill_preset_3.map(
      (skill) => new CharacterLinkSkillInfoDto(skill),
    );
    this.characterOwnedLinkSkill = new CharacterLinkSkillInfoDto(
      character_owned_link_skill,
    );
    this.characterOwnedLinkSkillPreset1 = character_owned_link_skill_preset_1 ? new CharacterLinkSkillInfoDto(
      character_owned_link_skill_preset_1,
    ) : null;
    this.characterOwnedLinkSkillPreset2 = character_owned_link_skill_preset_2 ?  new CharacterLinkSkillInfoDto(
      character_owned_link_skill_preset_2,
    ) : null;
    this.characterOwnedLinkSkillPreset3 =  character_owned_link_skill_preset_3 ? new CharacterLinkSkillInfoDto(
      character_owned_link_skill_preset_3,
    ) : null;
  }
}

export { CharacterLinkSkillDto };
