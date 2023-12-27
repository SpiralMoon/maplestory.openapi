import { UnionDtoBody } from '../response/unionDtoBody';

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

  constructor(obj: UnionDtoBody) {
    const { date, union_level, union_grade } = obj;

    this.date = new Date(date);
    this.unionLevel = union_level;
    this.unionGrade = union_grade;
  }
}

export { UnionDto };
