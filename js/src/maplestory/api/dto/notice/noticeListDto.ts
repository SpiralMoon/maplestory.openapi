import { NoticeListItemDto } from './noticeListItemDto';
import { NoticeListDtoBody } from '../../response/notice/noticeListDtoBody';

/**
 * 공지사항 목록
 */
class NoticeListDto {

  /**
   * 공지 목록
   */
  notice: NoticeListItemDto[];

  constructor(obj: NoticeListDtoBody) {
    const { notice } = obj;

    this.notice = notice.map(notice => new NoticeListItemDto(notice));
  }
}

export { NoticeListDto };
