type EventNoticeListDtoBody = {
  event_notice: EventNoticeListItemDtoBody[];
}

type EventNoticeListItemDtoBody = {
  title: string;
  url: string;
  notice_id: number;
  date: string;
  date_event_start: string;
  date_event_end: string;
};

export type { EventNoticeListDtoBody, EventNoticeListItemDtoBody };
