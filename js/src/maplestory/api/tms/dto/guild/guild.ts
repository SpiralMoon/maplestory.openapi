import * as base from '../../../common/dto/guild/guild';
import { GuildBody } from '../../response/guild/guildBody';

/**
 * 公會識別碼資訊
 */
export class GuildDto extends base.GuildDto {
  /**
   * 公會識別碼
   */
  public override oguildId: string;

  constructor(obj: GuildBody) {
    super();

    const { oguild_id } = obj;

    this.oguildId = oguild_id;
  }
}
