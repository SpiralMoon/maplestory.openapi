import * as base from '../../../common/dto/character/characterDojang';
import { CharacterDojangBody } from '../../response/character/characterDojangBody';

/**
 * 캐릭터 무릉도장 정보
 */
export class CharacterDojangDto extends base.CharacterDojangDto {
  /**
   * 조회 기준일
   */
  public override date: Date | null;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string | null;

  /**
   * 월드 명
   */
  public override worldName: string | null;

  /**
   * 무릉도장 최고 기록 층수
   */
  public override dojangBestFloor: number | null;

  /**
   * 무릉도장 최고 기록 달성 일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override dateDojangRecord: Date | null;

  /**
   * 무릉도장 최고 층수 클리어에 걸린 시간 (초)
   */
  public override dojangBestTime: number | null;

  constructor(obj: CharacterDojangBody) {
    super();

    const {
      date,
      character_class,
      world_name,
      dojang_best_floor,
      date_dojang_record,
      dojang_best_time,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterClass = character_class;
    this.worldName = world_name;
    this.dojangBestFloor = dojang_best_floor;
    this.dateDojangRecord = date_dojang_record
      ? new Date(date_dojang_record)
      : null;
    this.dojangBestTime = dojang_best_time;
  }
}
