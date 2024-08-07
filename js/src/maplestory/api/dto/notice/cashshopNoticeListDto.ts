import { CashshopNoticeListItemDto } from './cashshopNoticeListItemDto';
import { CashshopNoticeListDtoBody } from '../../response/notice/cashshopNoticeListDtoBody';

/**
 * 캐시샵 공지 목록
 */
class CashshopNoticeListDto {

  /**
   * 공지 목록
   */
  cashshopNotice: CashshopNoticeListItemDto[];

  constructor(obj: CashshopNoticeListDtoBody) {
    const { cashshop_notice } = obj;

    this.cashshopNotice = cashshop_notice.map(notice => new CashshopNoticeListItemDto(notice));
  }
}

export { CashshopNoticeListDto };
