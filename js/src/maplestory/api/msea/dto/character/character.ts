import * as base from '../../../common/dto/character/character';
import { CharacterBody } from '../../response/character/characterBody';

/**
 * Character identifier information
 */
export class CharacterDto extends base.CharacterDto {
  /**
   * Character identifier
   */
  public override ocid: string;

  constructor(obj: CharacterBody) {
    super();

    const { ocid } = obj;

    this.ocid = ocid;
  }
}
