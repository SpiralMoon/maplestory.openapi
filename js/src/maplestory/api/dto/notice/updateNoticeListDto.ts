import { UpdateNoticeListItemDto } from './updateNoticeListItemDto';
import { UpdateNoticeListBody } from '../../response/notice/updateNoticeListBody';

/**
 * 업데이트 목록
 */
class UpdateNoticeListDto {

  /**
   * 공지 목록
   */
  updateNotice: UpdateNoticeListItemDto[];

  constructor(obj: UpdateNoticeListBody) {
    const { update_notice } = obj;

    this.updateNotice = update_notice.map(notice => new UpdateNoticeListItemDto(notice));
  }
}

export { UpdateNoticeListDto };
