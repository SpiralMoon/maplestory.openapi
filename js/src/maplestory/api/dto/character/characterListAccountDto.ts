import { CharacterListAccountCharacterDto } from './characterListAccountCharacterDto';
import { CharacterListAccountDtoBody } from '../../response/character/characterListDtoBody';

/**
 * 메이플스토리 계정
 */
class CharacterListAccountDto {

  /**
   * 메이플스토리 계정 식별자
   */
  accountId: string;

  /**
   * 캐릭터 목록
   */
  characterList: CharacterListAccountCharacterDto[];

  constructor(obj: CharacterListAccountDtoBody) {
    const { account_id, character_list } = obj;

    this.accountId = account_id;
    this.characterList = character_list.map(character => new CharacterListAccountCharacterDto(character));
  }
}

export { CharacterListAccountDto };
