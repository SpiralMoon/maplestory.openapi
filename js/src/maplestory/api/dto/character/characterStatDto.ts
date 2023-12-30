import { CharacterStatDtoBody } from '../../response/character/characterStatDtoBody';

/**
 * 캐릭터 스탯 정보
 */
class CharacterStatDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * 현재 스탯 정보
   */
  finalStat: {
    statName: string;
    statValue: string;
  }[];

  /**
   * 잔여 AP
   */
  remainAP: number;

  constructor(obj: CharacterStatDtoBody) {
    const { date, character_class, final_stat, remain_ap } = obj;

    this.date = new Date(date);
    this.characterClass = character_class;
    this.finalStat = final_stat.map((stat) => {
      return {
        statName: stat.stat_name,
        statValue: stat.stat_value,
      };
    });
    this.remainAP = remain_ap;
  }
}

// 외부에서 재사용 가능하도록 export
export { CharacterStatDto };
