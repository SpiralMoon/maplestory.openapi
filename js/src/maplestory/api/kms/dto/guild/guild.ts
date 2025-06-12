import * as base from '../../../common/dto/guild/guild';
import { GuildBody } from '../../response/guild/guildBody';

/**
 * 길드 식별자 정보
 */
export class GuildDto extends base.GuildDto {
  /**
   * 길드 식별자
   */
  public override oguildId: string;

  constructor(obj: GuildBody) {
    super();

    const { oguild_id } = obj;

    this.oguildId = oguild_id;
  }
}
