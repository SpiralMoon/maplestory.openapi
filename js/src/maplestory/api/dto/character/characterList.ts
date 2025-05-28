import {
  CharacterListAccountBody,
  CharacterListAccountCharacterBody,
  CharacterListBody,
} from '../../response/character/characterListBody';

/**
 * 계정의 보유 캐릭터 목록
 */
export class CharacterListDto {

  /**
   * 메이플스토리 계정 목록
   */
  accountList:  CharacterListAccountDto[];

  constructor(obj: CharacterListBody) {
    const { account_list } = obj;

    this.accountList = account_list.map(account => new CharacterListAccountDto(account));
  }
}

/**
 * 캐릭터 정보
 */
export class CharacterListAccountCharacterDto {

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

  constructor(obj: CharacterListAccountCharacterBody) {
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

/**
 * 메이플스토리 계정
 */
export class CharacterListAccountDto {

  /**
   * 메이플스토리 계정 식별자
   */
  accountId: string;

  /**
   * 캐릭터 목록
   */
  characterList: CharacterListAccountCharacterDto[];

  constructor(obj: CharacterListAccountBody) {
    const { account_id, character_list } = obj;

    this.accountId = account_id;
    this.characterList = character_list.map(character => new CharacterListAccountCharacterDto(character));
  }
}
