export type EventNoticeListBody = {
  event_notice: EventNoticeListItemBody[];
};

export type EventNoticeListItemBody = {
  title: string;
  url: string;
  thumbnail_url: string;
  notice_id: number;
  date: string;
  date_event_start: string;
  date_event_end: string;
};
