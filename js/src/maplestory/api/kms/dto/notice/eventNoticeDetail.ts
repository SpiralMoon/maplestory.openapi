import { EventNoticeDetailBody } from '../../response/notice/eventNoticeDetailBody';

/**
 * 진행 중 이벤트 상세
 */
export class EventNoticeDetailDto {

  /**
   * 공지 제목
   */
  title: string;

  /**
   * 공지 링크
   */
  url: string;

  /**
   * 공지 본문
   */
  contents: string;

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

  constructor(obj: EventNoticeDetailBody) {
    const { title, url, contents, date, date_event_start, date_event_end } = obj;

    this.title = title;
    this.url = url;
    this.contents = contents;
    this.date = new Date(date);
    this.dateEventStart = new Date(date_event_start);
    this.dateEventEnd = new Date(date_event_end);
  }
}
