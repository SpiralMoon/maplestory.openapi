import { UnionChampionBadgeInfoDtoBody } from '../../response/union/unionChampionDtoBody';

/**
 * 유니온 챔피언 휘장 정보
 */
class UnionChampionBadgeInfoDto {

  /**
   * 유니온 챔피언 휘장 효과
   */
  stat: string;

  constructor(obj: UnionChampionBadgeInfoDtoBody) {
    const { stat } = obj;

    this.stat = stat;
  }
}

export { UnionChampionBadgeInfoDto };
