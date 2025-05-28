export type EventNoticeListBody = {
  event_notice: EventNoticeListItemDtoBody[];
}

export type EventNoticeListItemDtoBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
  date_event_start: string;
  date_event_end: string;
};
