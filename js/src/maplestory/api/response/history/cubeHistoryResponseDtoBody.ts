import { CubeHistoryDtoBody } from '@src/maplestory/api/response/history/cubeHistoryDtoBody';

type CubeHistoryResponseDtoBody = {
  count: number;

  cube_history: CubeHistoryDtoBody[];

  next_cursor: string | null;
};

export type { CubeHistoryResponseDtoBody };
