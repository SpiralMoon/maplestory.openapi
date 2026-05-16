export type BattlePracticeSkillTimelineBody = {
  page_no: number;
  total_page_no: number;
  skill_timeline: BattlePracticeSkillTimelineEventBody[];
};

export type BattlePracticeSkillTimelineEventBody = {
  elapse_time: number;
  skill_name: string;
  hexa_skill_specificity_flag: string;
  sequence_name: string | null;
  sequence_key: string | null;
};
