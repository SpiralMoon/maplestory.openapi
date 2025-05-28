import { UnionRankingBody } from '../../response/ranking/unionRankingBody';

/**
 * 유니온 랭킹 정보
 */
class UnionRankingDto {
  /**
   * 랭킹 업데이트 일자 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  date: Date;

  /**
   * 유니온 랭킹 순위
   */
  ranking: number;

  /**
   * 캐릭터 명
   */
  characterName: string;

  /**
   * 월드 명
   */
  worldName: string;

  /**
   * 직업 명
   */
  className: string;

  /**
   * 전직 직업 명
   */
  subClassName: string;

  /**
   * 유니온 레벨
   */
  unionLevel: number;

  /**
   * 유니온 파워
   */
  unionPower: number;

  constructor(obj: UnionRankingBody) {
    const {
      date,
      ranking,
      character_name,
      world_name,
      class_name,
      sub_class_name,
      union_level,
      union_power,
    } = obj;

    this.date = new Date(date);
    this.ranking = ranking;
    this.characterName = character_name;
    this.worldName = world_name;
    this.className = class_name;
    this.subClassName = sub_class_name;
    this.unionLevel = union_level;
    this.unionPower = union_power;
  }
}

export { UnionRankingDto };
