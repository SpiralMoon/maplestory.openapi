import { CubeHistoryDtoBody } from './cubeHistoryDtoBody';

export type CubeHistoryResponseDtoBody = {
  count: number;
  cube_history: CubeHistoryDtoBody[];
  next_cursor: string | null;
};
