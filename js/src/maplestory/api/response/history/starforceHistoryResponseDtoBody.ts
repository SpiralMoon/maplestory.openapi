import { StarforceHistoryDtoBody } from './starforceHistoryDtoBody';

export type StarforceHistoryResponseDtoBody = {
  count: number;
  starforce_history: StarforceHistoryDtoBody[];
  next_cursor: string | null;
};
