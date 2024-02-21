import { UnionDtoBody } from '../../response/union/unionDtoBody';

/**
 * 유니온 정보
 */
class UnionDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 유니온 레벨
   */
  unionLevel: number;

  /**
   * 유니온 등급
   */
  unionGrade: string;

  /**
   * 아티팩트 레벨
   */
  unionArtifactLevel: number | null;

  /**
   * 보유 아티팩트 경험치
   */
  unionArtifactExp: number | null;

  /**
   * 보유 아티팩트 포인트
   */
  unionArtifactPoint: number | null;

  constructor(obj: UnionDtoBody) {
    const { date, union_level, union_grade, union_artifact_level, union_artifact_exp, union_artifact_point } = obj;

    this.date = new Date(date);
    this.unionLevel = union_level;
    this.unionGrade = union_grade;
    this.unionArtifactLevel = union_artifact_level;
    this.unionArtifactExp = union_artifact_exp;
    this.unionArtifactPoint = union_artifact_point;
  }
}

export { UnionDto };
