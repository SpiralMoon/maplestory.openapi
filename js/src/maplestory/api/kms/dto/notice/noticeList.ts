import {
  NoticeListBody,
  NoticeListItemBody,
} from '../../response/notice/noticeListBody';

/**
 * 공지사항 목록
 */
export class NoticeListDto {
  /**
   * 공지 목록
   */
  notice: NoticeListItemDto[];

  constructor(obj: NoticeListBody) {
    const { notice } = obj;

    this.notice = notice.map((notice) => new NoticeListItemDto(notice));
  }
}

/**
 * 공지사항
 */
export class NoticeListItemDto {
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

  constructor(obj: NoticeListItemBody) {
    const { title, url, notice_id, date } = obj;

    this.title = title;
    this.url = url;
    this.noticeId = notice_id;
    this.date = new Date(date);
  }
}
