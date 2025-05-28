export type CashshopNoticeListBody = {
  cashshop_notice: CashshopNoticeListItemDtoBody[];
}

export type CashshopNoticeListItemDtoBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
  date_sale_start: string | null;
  date_sale_end: string | null;
  ongoing_flag: string;
}
