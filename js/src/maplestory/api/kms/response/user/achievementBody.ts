export type AchievementBody = {
  account_list: AchievementAccountListBody[];
};

export type AchievementAccountListBody = {
  account_id: string;
  achievement_achieve: AchievementAchieveBody[];
};

export type AchievementAchieveBody = {
  achievement_name: string;
  achievement_description: string;
};
