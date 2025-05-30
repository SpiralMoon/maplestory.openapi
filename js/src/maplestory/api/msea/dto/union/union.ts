import * as base from '../../../common/dto/union/union';
import { UnionBody } from '../../response/union/unionBody';

/**
 * Union information
 */
export class UnionDto extends base.UnionDto {
  /**
   * Reference date for query (SGT, daily data with hours and minutes set to 0)
   */
  public override date: Date | null;

  /**
   * Union level
   */
  public override unionLevel: number | null;

  /**
   * Union grade
   */
  public override unionGrade: string | null;

  /**
   * Artifact level
   */
  public override unionArtifactLevel: number | null;

  /**
   * Earned Artifact EXP
   */
  public override unionArtifactExp: number | null;

  /**
   * Earned Artifact Points
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
