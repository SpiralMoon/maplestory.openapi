import { EventNoticeListItemDto } from '@src/maplestory/api/dto/notice/eventNoticeListItemDto';
import { EventNoticeListDtoBody } from '@src/maplestory/api/response/notice/eventNoticeListDtoBody';

/**
 * 진행 중 이벤트 공지 목록
 */
class EventNoticeListDto {

  /**
   * 공지 목록
   */
  eventNotice: EventNoticeListItemDto[];

  constructor(obj: EventNoticeListDtoBody) {
    const { event_notice } = obj;

    this.eventNotice = event_notice.map(notice => new EventNoticeListItemDto(notice));
  }
}

export { EventNoticeListDto };
