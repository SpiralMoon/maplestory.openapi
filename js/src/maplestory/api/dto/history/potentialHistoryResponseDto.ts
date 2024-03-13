import { PotentialHistoryDto } from '@src/maplestory/api/dto/history/potentialHistoryDto';
import { PotentialHistoryResponseDtoBody } from '@src/maplestory/api/response/history/potentialHistoryResponseDtoBody';

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

  constructor(obj: PotentialHistoryResponseDtoBody) {
    const { count, potential_history, next_cursor } = obj;

    this.count = count;
    this.potentialHistory = potential_history.map(
      (origin) => new PotentialHistoryDto(origin),
    );
    this.nextCursor = next_cursor;
  }
}

export { PotentialHistoryResponseDto };
