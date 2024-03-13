import { StarforceHistoryDto } from '@src/maplestory/api/dto/history/starforceHistoryDto';
import { StarforceHistoryResponseDtoBody } from '@src/maplestory/api/response/history/starforceHistoryResponseDtoBody';

/**
 * 스타포스 히스토리 응답 정보
 */
class StarforceHistoryResponseDto {
  /**
   * 결과 건 수
   */
  count: number;

  /**
   * 스타포스 히스토리
   */
  starforceHistory: StarforceHistoryDto[];

  /**
   * 페이징 처리를 위한 cursor
   */
  nextCursor: string | null;

  constructor(obj: StarforceHistoryResponseDtoBody) {
    const { count, starforce_history, next_cursor } = obj;

    this.count = count;
    this.starforceHistory = starforce_history.map(
      (origin) => new StarforceHistoryDto(origin),
    );
    this.nextCursor = next_cursor;
  }
}

export { StarforceHistoryResponseDto };
