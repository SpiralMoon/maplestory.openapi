import {GuildDtoBody} from "../response/guildDtoBody";

/**
 * 길드 식별자 정보
 */
class GuildDto {

    /**
     * 길드 식별자
     */
    oguildId: string;

    constructor(obj: GuildDtoBody) {
        const {oguild_id} = obj;

        this.oguildId = oguild_id;
    }
}

export {GuildDto};
