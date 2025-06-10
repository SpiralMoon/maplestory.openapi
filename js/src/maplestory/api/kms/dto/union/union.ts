import * as base from '../../../common/dto/union/union';
import { UnionBody } from '../../response/union/unionBody';

/**
 * 유니온 정보
 */
export class UnionDto extends base.UnionDto {
  /**
   * 조회 기준일
   */
  public override date: Date | null;

  /**
   * 유니온 레벨
   */
  public override unionLevel: number | null;

  /**
   * 유니온 등급
   */
  public override unionGrade: string | null;

  /**
   * 아티팩트 레벨
   */
  public override unionArtifactLevel: number | null;

  /**
   * 보유 아티팩트 경험치
   */
  public override unionArtifactExp: number | null;

  /**
   * 보유 아티팩트 포인트
   */
  public override unionArtifactPoint: number | null;

  constructor(obj: UnionBody) {
    super();

    const {
      date,
      union_level,
      union_grade,
      union_artifact_level,
      union_artifact_exp,
      union_artifact_point,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.unionLevel = union_level;
    this.unionGrade = union_grade;
    this.unionArtifactLevel = union_artifact_level;
    this.unionArtifactExp = union_artifact_exp;
    this.unionArtifactPoint = union_artifact_point;
  }
}
