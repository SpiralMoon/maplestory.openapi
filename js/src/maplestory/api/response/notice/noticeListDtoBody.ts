type NoticeListDtoBody = {
  notice: NoticeListItemDtoBody[];
};

type NoticeListItemDtoBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
};

export type { NoticeListDtoBody, NoticeListItemDtoBody };
