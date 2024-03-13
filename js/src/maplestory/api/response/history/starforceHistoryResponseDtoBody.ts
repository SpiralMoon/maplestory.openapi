import { StarforceHistoryDtoBody } from '@src/maplestory/api/response/history/starforceHistoryDtoBody';

type StarforceHistoryResponseDtoBody = {
  count: number;

  starforce_history: StarforceHistoryDtoBody[];

  next_cursor: string | null;
};

export type { StarforceHistoryResponseDtoBody };
