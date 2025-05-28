export type NoticeListBody = {
  notice: NoticeListItemDtoBody[];
};

export type NoticeListItemDtoBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
};
