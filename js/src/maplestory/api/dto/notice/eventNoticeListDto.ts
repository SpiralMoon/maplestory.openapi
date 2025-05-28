import { EventNoticeListItemDto } from './eventNoticeListItemDto';
import { EventNoticeListBody } from '../../response/notice/eventNoticeListBody';

/**
 * 진행 중 이벤트 공지 목록
 */
class EventNoticeListDto {

  /**
   * 공지 목록
   */
  eventNotice: EventNoticeListItemDto[];

  constructor(obj: EventNoticeListBody) {
    const { event_notice } = obj;

    this.eventNotice = event_notice.map(notice => new EventNoticeListItemDto(notice));
  }
}

export { EventNoticeListDto };
