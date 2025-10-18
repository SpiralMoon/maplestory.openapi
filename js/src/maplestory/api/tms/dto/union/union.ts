import * as base from '../../../common/dto/union/union';
import { UnionBody } from '../../response/union/unionBody';

/**
 * 戰地資訊
 */
export class UnionDto extends base.UnionDto {
  /**
   * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
   */
  public override date: Date | null;

  /**
   * 聯盟等級
   */
  public override unionLevel: number | null;

  /**
   * 聯盟階級
   */
  public override unionGrade: string | null;

  /**
   * 神器等級
   */
  public override unionArtifactLevel: number | null;

  /**
   * 持有的神器經驗值
   */
  public override unionArtifactExp: number | null;

  /**
   * 持有的神器點數
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
