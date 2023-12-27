import { CubeHistoryDtoBody } from './cubeHistoryDtoBody';

type CubeHistoryResponseDtoBody = {
  count: number;

  cube_history: CubeHistoryDtoBody[];

  next_cursor: string;
};

export type { CubeHistoryResponseDtoBody };
