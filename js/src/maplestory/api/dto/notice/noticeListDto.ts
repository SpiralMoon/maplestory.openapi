import { NoticeListItemDto } from '@src/maplestory/api/dto/notice/noticeListItemDto';
import { NoticeListDtoBody } from '@src/maplestory/api/response/notice/noticeListDtoBody';

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
