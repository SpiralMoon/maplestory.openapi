import {CubeHistoryDtoBody} from "./cubeHistoryDtoBody";

type CubeHistoryResponseDtoBody = {
	count: number;

	cube_histories: CubeHistoryDtoBody[];

	next_cursor: string;
}

export type {CubeHistoryResponseDtoBody};
