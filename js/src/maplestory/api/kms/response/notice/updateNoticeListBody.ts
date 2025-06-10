export type UpdateNoticeListBody = {
  update_notice: UpdateNoticeListItemBody[];
};

export type UpdateNoticeListItemBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
};
