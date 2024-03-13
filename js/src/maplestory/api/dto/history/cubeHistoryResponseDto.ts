import { CubeHistoryDto } from '@src/maplestory/api/dto/history/cubeHistoryDto';
import { CubeHistoryResponseDtoBody } from '@src/maplestory/api/response/history/cubeHistoryResponseDtoBody';

/**
 * 큐브 히스토리 응답 정보
 */
class CubeHistoryResponseDto {
  /**
   * 결과 건 수
   */
  count: number;

  /**
   * 큐브 히스토리
   */
  cubeHistory: CubeHistoryDto[];

  /**
   * 페이징 처리를 위한 cursor
   */
  nextCursor: string | null;

  constructor(obj: CubeHistoryResponseDtoBody) {
    const { count, cube_history, next_cursor } = obj;

    this.count = count;
    this.cubeHistory = cube_history.map((origin) => new CubeHistoryDto(origin));
    this.nextCursor = next_cursor;
  }
}

export { CubeHistoryResponseDto };
