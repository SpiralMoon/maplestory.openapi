import {
  CashshopNoticeListBody,
  CashshopNoticeListItemBody,
} from '../../response/notice/cashshopNoticeListBody';

/**
 * 캐시샵 공지 목록
 */
export class CashshopNoticeListDto {
  /**
   * 공지 목록
   */
  cashshopNotice: CashshopNoticeListItemDto[];

  constructor(obj: CashshopNoticeListBody) {
    const { cashshop_notice } = obj;

    this.cashshopNotice = cashshop_notice.map(
      (notice) => new CashshopNoticeListItemDto(notice),
    );
  }
}

/**
 * 캐시샵 공지
 */
export class CashshopNoticeListItemDto {
  /**
   * 공지 제목
   */
  title: string;

  /**
   * 공지 링크
   */
  url: string;

  /**
   * 썸네일 링크
   */
  thumbnailUrl: string;

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

  constructor(obj: CashshopNoticeListItemBody) {
    const {
      title,
      url,
      thumbnail_url,
      notice_id,
      date,
      date_sale_start,
      date_sale_end,
      ongoing_flag,
    } = obj;

    this.title = title;
    this.url = url;
    this.thumbnailUrl = thumbnail_url;
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
