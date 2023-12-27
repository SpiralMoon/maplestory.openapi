import { CharacterDojangDtoBody } from '../response/characterDojangDtoBody';

/**
 * 캐릭터 도장 정보
 */
class CharacterDojangDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * 월드 명
   */
  worldName: string;

  /**
   * 무릉도장 최고 기록 층수
   */
  dojangBestFloor: number;

  /**
   * 무릉도장 최고 기록 달성 일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  dateDojangRecord: Date;

  /**
   * 무릉도장 최고 층수 클리어에 걸린 시간 (초)
   */
  dojangBestTime: number;

  constructor(obj: CharacterDojangDtoBody) {
    const {
      date,
      character_class,
      world_name,
      dojang_best_floor,
      date_dojang_record,
      dojang_best_time,
    } = obj;

    this.date = new Date(date);
    this.characterClass = character_class;
    this.worldName = world_name;
    this.dojangBestFloor = dojang_best_floor;
    this.dateDojangRecord = new Date(date_dojang_record);
    this.dojangBestTime = dojang_best_time;
  }
}

export { CharacterDojangDto };
