import { CharacterBody } from '../../response/character/characterBody';

/**
 * 캐릭터 식별 정보
 */
export class CharacterDto {
  /**
   * 캐릭터 식별자
   */
  ocid: string;

  constructor(obj: CharacterBody) {
    const { ocid } = obj;

    this.ocid = ocid;
  }
}
