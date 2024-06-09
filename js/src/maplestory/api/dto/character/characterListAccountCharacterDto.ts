import {
  CharacterListAccountCharacterDtoBody,
} from '@src/maplestory/api/response/character/characterListDtoBody';

/**
 * 캐릭터 정보
 */
class CharacterListAccountCharacterDto {

  /**
   * 캐릭터 식별자
   */
  ocid: string;

  /**
   * 캐릭터 명
   */
  characterName: string;

  /**
   * 월드 명
   */
  worldName: string;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * 캐릭터 레벨
   */
  characterLevel: number;

  constructor(obj: CharacterListAccountCharacterDtoBody) {
    const {
      ocid,
      character_name,
      world_name,
      character_class,
      character_level,
    } = obj;

    this.ocid = ocid;
    this.characterName = character_name;
    this.worldName = world_name;
    this.characterClass = character_class;
    this.characterLevel = character_level;
  }
}

export { CharacterListAccountCharacterDto };
