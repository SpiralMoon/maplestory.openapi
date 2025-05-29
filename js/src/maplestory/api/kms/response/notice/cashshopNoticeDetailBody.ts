export type CashshopNoticeDetailBody = {
  title: string;
  url: string;
  contents: string;
  date: string;
  date_sale_start: string | null;
  date_sale_end: string | null;
  ongoing_flag: string;
};
