import { CashshopNoticeListItemDtoBody } from '../../response/notice/cashshopNoticeListBody';

/**
 * 캐시샵 공지
 */
class CashshopNoticeListItemDto {

  /**
   * 공지 제목
   */
  title: string;

  /**
   * 공지 링크
   */
  url: string;

  /**
   * 공지 식별자
   */
  noticeId: number;

  /**
   * 공지 등록일
   */
  date: Date;

  /**
   * 판매 시작일
   */
  dateSaleStart: Date | null;

  /**
   * 판매 종료일
   */
  dateSaleEnd: Date | null;

  /**
   * 상시 판매 여부 (true - 상시)
   */
  ongoingFlag: string;

  constructor(obj: CashshopNoticeListItemDtoBody) {

    const { title, url, notice_id, date, date_sale_start, date_sale_end, ongoing_flag } = obj;

    this.title = title;
    this.url = url;
    this.noticeId = notice_id;
    this.date = new Date(date);
    this.dateSaleStart = date_sale_start ? new Date(date_sale_start) : null;
    this.dateSaleEnd = date_sale_end ? new Date(date_sale_end) : null;
    this.ongoingFlag = ongoing_flag;
  }


  /**
   * 상시 판매 여부 (true - 상시)
   */
  get isOnGoing() {
    return this.ongoingFlag === 'true';
  }
}

export { CashshopNoticeListItemDto };
