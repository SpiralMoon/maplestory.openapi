import { NoticeDetailBody } from '../../response/notice/noticeDetailBody';

/**
 * 공지사항 상세
 */
class NoticeDetailDto {

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

  constructor(obj: NoticeDetailBody) {
    const { title, url, contents, date } = obj;

    this.title = title;
    this.url = url;
    this.contents = contents;
    this.date = new Date(date);
  }
}

export { NoticeDetailDto };
