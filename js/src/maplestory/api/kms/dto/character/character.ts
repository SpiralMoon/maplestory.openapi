import * as base from '../../../common/dto/character/character';
import { CharacterBody } from '../../response/character/characterBody';

/**
 * 캐릭터 식별 정보
 */
export class CharacterDto extends base.CharacterDto {
  /**
   * 캐릭터 식별자
   */
  public override ocid: string;

  constructor(obj: CharacterBody) {
    super();

    const { ocid } = obj;

    this.ocid = ocid;
  }
}
