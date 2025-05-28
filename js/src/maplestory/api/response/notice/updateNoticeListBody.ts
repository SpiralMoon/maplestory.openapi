export type UpdateNoticeListBody = {
  update_notice: UpdateNoticeListItemDtoBody[];
};

export type UpdateNoticeListItemDtoBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
};
