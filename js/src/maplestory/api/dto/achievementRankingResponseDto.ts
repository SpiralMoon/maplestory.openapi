import {AchievementRankingDto} from "./achievementRankingDto";
import {AchievementRankingResponseDtoBody} from "../response/achievementRankingResponseDtoBody";

/**
 * 업적 랭킹 응답 정보
 */
class AchievementRankingResponseDto {

    /**
     * 업적 랭킹 정보
     */
    ranking: AchievementRankingDto[];

    constructor(obj: AchievementRankingResponseDtoBody) {
        const {ranking} = obj;

        this.ranking = ranking.map(rank => new AchievementRankingDto(rank));
    }
}

export {AchievementRankingResponseDto};
