import { StarforceHistoryDtoBody } from './starforceHistoryDtoBody'

type StarforceHistoryResponseDtoBody = {
  count: number;

  starforce_history: StarforceHistoryDtoBody[];

  next_cursor: string;
};

export type { StarforceHistoryResponseDtoBody };
