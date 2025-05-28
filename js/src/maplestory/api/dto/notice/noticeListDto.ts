import { NoticeListItemDto } from './noticeListItemDto';
import { NoticeListBody } from '../../response/notice/noticeListBody';

/**
 * 공지사항 목록
 */
class NoticeListDto {

  /**
   * 공지 목록
   */
  notice: NoticeListItemDto[];

  constructor(obj: NoticeListBody) {
    const { notice } = obj;

    this.notice = notice.map(notice => new NoticeListItemDto(notice));
  }
}

export { NoticeListDto };
