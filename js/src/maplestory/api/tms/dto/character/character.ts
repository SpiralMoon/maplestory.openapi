import * as base from '../../../common/dto/character/character';
import { CharacterBody } from '../../response/character/characterBody';

/**
 * 角色辨識器資訊
 */
export class CharacterDto extends base.CharacterDto {
  /**
   * 角色辨識器
   */
  public override ocid: string;

  constructor(obj: CharacterBody) {
    super();

    const { ocid } = obj;

    this.ocid = ocid;
  }
}
