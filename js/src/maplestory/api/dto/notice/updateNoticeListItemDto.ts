import { UpdateNoticeListItemDtoBody } from '../../response/notice/updateNoticeListDtoBody';

/**
 * 업데이트 공지
 */
class UpdateNoticeListItemDto {

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

  constructor(obj: UpdateNoticeListItemDtoBody) {
    const { title, url, notice_id, date } = obj;

    this.title = title;
    this.url = url;
    this.noticeId = notice_id;
    this.date = new Date(date);
  }
}

export { UpdateNoticeListItemDto };
