type CashshopNoticeListDtoBody = {
  cashshop_notice: CashshopNoticeListItemDtoBody[];
}

type CashshopNoticeListItemDtoBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
  date_sale_start: string | null;
  date_sale_end: string | null;
  ongoing_flag: string;
}

export type { CashshopNoticeListDtoBody, CashshopNoticeListItemDtoBody };
