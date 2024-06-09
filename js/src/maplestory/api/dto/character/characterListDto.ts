import { CharacterListAccountDto } from '@src/maplestory/api/dto/character/characterListAccountDto';
import { CharacterListDtoBody } from '@src/maplestory/api/response/character/characterListDtoBody';

/**
 * 계정의 보유 캐릭터 목록
 */
class CharacterListDto {

  /**
   * 메이플스토리 계정 목록
   */
  accountList:  CharacterListAccountDto[];

  constructor(obj: CharacterListDtoBody) {
    const { account_list } = obj;

    this.accountList = account_list.map(account => new CharacterListAccountDto(account));
  }
}

export { CharacterListDto };
