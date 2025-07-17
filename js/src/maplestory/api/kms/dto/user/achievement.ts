import {
  AchievementAccountListBody,
  AchievementAchieveBody,
  AchievementBody,
} from '../../response/user/achievementBody';

/**
 * 계정의 업적 목록
 */
export class AchievementDto {
  /**
   * 메이플스토리 계정 목록
   */
  public accountList: AchievementAccountListDto[];

  constructor(obj: AchievementBody) {
    const { account_list } = obj;

    this.accountList = account_list.map(
      (account) => new AchievementAccountListDto(account),
    );
  }
}

/**
 * 메이플스토리 계정
 */
export class AchievementAccountListDto {
  /**
   * 메이플스토리 계정 식별자
   */
  public accountId: string;

  /**
   * 달성 업적 정보
   */
  public achievementAchieve: AchievementAchieveDto[];

  constructor(obj: AchievementAccountListBody) {
    const { account_id, achievement_achieve } = obj;

    this.accountId = account_id;
    this.achievementAchieve = achievement_achieve.map(
      (achieve) => new AchievementAchieveDto(achieve),
    );
  }
}

/**
 * 달성 업적 정보
 */
export class AchievementAchieveDto {
  /**
   * 업적 명
   */
  public achievementName: string;

  /**
   * 업적 설명
   */
  public achievementDescription: string;

  constructor(obj: AchievementAchieveBody) {
    const { achievement_name, achievement_description } = obj;

    this.achievementName = achievement_name;
    this.achievementDescription = achievement_description;
  }
}
