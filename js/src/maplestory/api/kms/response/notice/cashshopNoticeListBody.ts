export type CashshopNoticeListBody = {
  cashshop_notice: CashshopNoticeListItemBody[];
};

export type CashshopNoticeListItemBody = {
  title: string;
  url: string;
  thumbnail_url: string;
  notice_id: number;
  date: string;
  date_sale_start: string | null;
  date_sale_end: string | null;
  ongoing_flag: string;
};
