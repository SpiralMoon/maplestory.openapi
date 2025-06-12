export type NoticeListBody = {
  notice: NoticeListItemBody[];
};

export type NoticeListItemBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
};
