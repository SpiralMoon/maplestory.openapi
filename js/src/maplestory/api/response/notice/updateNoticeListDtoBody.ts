type UpdateNoticeListDtoBody = {
  update_notice: UpdateNoticeListItemDtoBody[];
};

type UpdateNoticeListItemDtoBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
};

export type { UpdateNoticeListDtoBody, UpdateNoticeListItemDtoBody };
