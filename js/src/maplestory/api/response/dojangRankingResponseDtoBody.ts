import {RankingResponseDtoBody} from "./rankingResponseDtoBody";

type DojangRankingResponseDtoBody = RankingResponseDtoBody<DojangRankingDtoBody>;

type DojangRankingDtoBody = {
    date: string;
    ranking: number;
    character_name: string;
    world_name: string;
    class_name: string;
    sub_class_name: string;
    character_level: number;
    dojang_floor: number;
    dojang_time_record: number;
}

export type {DojangRankingResponseDtoBody, DojangRankingDtoBody};
