import { PotentialHistoryDto } from './potentialHistoryDto';
import { PotentialHistoryResponseBody } from '../../response/history/potentialHistoryBody';

/**
 * 잠재능력 재설정 히스토리 응답 정보
 */
class PotentialHistoryResponseDto {
  /**
   * 결과 건 수
   */
  count: number;

  /**
   * 잠재능력 재설정 히스토리
   */
  potentialHistory: PotentialHistoryDto[];

  /**
   * 페이징 처리를 위한 cursor
   */
  nextCursor: string | null;

  constructor(obj: PotentialHistoryResponseBody) {
    const { count, potential_history, next_cursor } = obj;

    this.count = count;
    this.potentialHistory = potential_history.map(
      (origin) => new PotentialHistoryDto(origin),
    );
    this.nextCursor = next_cursor;
  }
}

export { PotentialHistoryResponseDto };
