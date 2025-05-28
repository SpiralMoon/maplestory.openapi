import { UnionRaiderBlockPositionBody } from '../../response/union/unionRaiderBody';

/**
 * 유니온 블록이 차지하고 있는 영역 좌표들
 */
class UnionRaiderBlockPositionDto {
  /**
   * 블록 X좌표
   */
  x: number;

  /**
   * 블록 Y좌표
   */
  y: number;

  constructor(obj: UnionRaiderBlockPositionBody) {
    const { x, y } = obj;

    this.x = x;
    this.y = y;
  }
}

export { UnionRaiderBlockPositionDto };
