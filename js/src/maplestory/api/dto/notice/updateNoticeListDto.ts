import { UpdateNoticeListItemDto } from '@src/maplestory/api/dto/notice/updateNoticeListItemDto';
import { UpdateNoticeListDtoBody } from '@src/maplestory/api/response/notice/updateNoticeListDtoBody';

/**
 * 업데이트 목록
 */
class UpdateNoticeListDto {

  /**
   * 공지 목록
   */
  updateNotice: UpdateNoticeListItemDto[];

  constructor(obj: UpdateNoticeListDtoBody) {
    const { update_notice } = obj;

    this.updateNotice = update_notice.map(notice => new UpdateNoticeListItemDto(notice));
  }
}

export { UpdateNoticeListDto };
