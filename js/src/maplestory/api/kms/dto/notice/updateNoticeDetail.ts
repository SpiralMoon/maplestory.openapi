import { UpdateNoticeDetailBody } from '../../response/notice/updateNoticeDetailBody';

/**
 * 업데이트 상세
 */
export class UpdateNoticeDetailDto {
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

  constructor(obj: UpdateNoticeDetailBody) {
    const { title, url, contents, date } = obj;

    this.title = title;
    this.url = url;
    this.contents = contents;
    this.date = new Date(date);
  }
}
