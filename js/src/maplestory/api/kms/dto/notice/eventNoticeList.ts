import {
  EventNoticeListBody,
  EventNoticeListItemBody,
} from '../../response/notice/eventNoticeListBody';

/**
 * 진행 중 이벤트 공지 목록
 */
export class EventNoticeListDto {
  /**
   * 공지 목록
   */
  eventNotice: EventNoticeListItemDto[];

  constructor(obj: EventNoticeListBody) {
    const { event_notice } = obj;

    this.eventNotice = event_notice.map(
      (notice) => new EventNoticeListItemDto(notice),
    );
  }
}

/**
 * 진행 중 이벤트 공지
 */
export class EventNoticeListItemDto {
  /**
   * 공지 제목
   */
  title: string;

  /**
   * 공지 링크
   */
  url: string;

  /**
   * 공지 식별자
   */
  noticeId: number;

  /**
   * 공지 등록일
   */
  date: Date;

  /**
   * 이벤트 시작일
   */
  dateEventStart: Date;

  /**
   * 이벤트 종료일
   */
  dateEventEnd: Date;

  constructor(obj: EventNoticeListItemBody) {
    const { title, url, notice_id, date, date_event_start, date_event_end } =
      obj;

    this.title = title;
    this.url = url;
    this.noticeId = notice_id;
    this.date = new Date(date);
    this.dateEventStart = new Date(date_event_start);
    this.dateEventEnd = new Date(date_event_end);
  }
}
