import { CharacterDtoBody } from '@src/maplestory/api/response/character/characterDtoBody';

/**
 * 캐릭터 식별 정보
 */
class CharacterDto {
  /**
   * 캐릭터 식별자
   */
  ocid: string;

  constructor(obj: CharacterDtoBody) {
    const { ocid } = obj;

    this.ocid = ocid;
  }
}

export { CharacterDto };
