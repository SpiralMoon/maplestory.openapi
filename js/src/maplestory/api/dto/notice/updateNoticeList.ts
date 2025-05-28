import { UpdateNoticeListBody, UpdateNoticeListItemBody } from '../../response/notice/updateNoticeListBody';

/**
 * 업데이트 목록
 */
export class UpdateNoticeListDto {

  /**
   * 공지 목록
   */
  updateNotice: UpdateNoticeListItemDto[];

  constructor(obj: UpdateNoticeListBody) {
    const { update_notice } = obj;

    this.updateNotice = update_notice.map(notice => new UpdateNoticeListItemDto(notice));
  }
}

/**
 * 업데이트 공지
 */
export class UpdateNoticeListItemDto {

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

  constructor(obj: UpdateNoticeListItemBody) {
    const { title, url, notice_id, date } = obj;

    this.title = title;
    this.url = url;
    this.noticeId = notice_id;
    this.date = new Date(date);
  }
}
