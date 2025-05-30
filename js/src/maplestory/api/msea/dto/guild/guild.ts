import * as base from '../../../common/dto/guild/guild';
import { GuildBody } from '../../response/guild/guildBody';

/**
 * Guild identifier information
 */
export class GuildDto extends base.GuildDto {
  /**
   * Guild identifier
   */
  public override oguildId: string;

  constructor(obj: GuildBody) {
    super();

    const { oguild_id } = obj;

    this.oguildId = oguild_id;
  }
}
