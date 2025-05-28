import { UnionRaiderBlockPositionDto } from './unionRaiderBlockPositionDto';
import { UnionRaiderBlockControlPointDto } from './unionRaiderControlPointDto';
import { UnionRaiderBlockBody } from '../../response/union/unionRaiderBody';

/**
 * 유니온 블록 정보
 */
class UnionRaiderBlockDto {
  /**
   * 블록 모양 (전사, 마법사, 궁수, 도적, 해적, 메이플m, 하이브리드)
   */
  blockType: string;

  /**
   * 블록 해당 캐릭터 직업
   */
  blockClass: string;

  /**
   * 블록 해당 캐릭터 레벨
   */
  blockLevel: string;

  /**
   * 블록 기준점 좌표
   */
  blockControlPoint: UnionRaiderBlockControlPointDto;

  /**
   * 블록이 차지하고 있는 영역 좌표들 (null:미 배치 시)
   */
  blockPosition: UnionRaiderBlockPositionDto[] | null;

  constructor(obj: UnionRaiderBlockBody) {
    const {
      block_type,
      block_class,
      block_level,
      block_control_point,
      block_position,
    } = obj;

    this.blockType = block_type;
    this.blockClass = block_class;
    this.blockLevel = block_level;
    this.blockControlPoint = new UnionRaiderBlockControlPointDto(
      block_control_point,
    );
    this.blockPosition = block_position
      ? block_position.map(
          (position) => new UnionRaiderBlockPositionDto(position),
        )
      : null;
  }
}

export { UnionRaiderBlockDto };
