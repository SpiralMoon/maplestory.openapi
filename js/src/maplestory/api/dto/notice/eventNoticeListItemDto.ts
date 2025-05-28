import { EventNoticeListItemDtoBody } from '../../response/notice/eventNoticeListBody';

/**
 * 진행 중 이벤트 공지
 */
class EventNoticeListItemDto {

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

  constructor(obj: EventNoticeListItemDtoBody) {
    const { title, url, notice_id, date, date_event_start, date_event_end } = obj;

    this.title = title;
    this.url = url;
    this.noticeId = notice_id;
    this.date = new Date(date);
    this.dateEventStart = new Date(date_event_start);
    this.dateEventEnd = new Date(date_event_end);
  }
}

export { EventNoticeListItemDto };
