export type CharacterSkillBody = {
  date: string | null;
  character_class: string | null;
  character_skill_grade: string | null;
  character_skill: CharacterSkillInfoBody[];
};

export type CharacterSkillInfoBody = {
  skill_name: string;
  skill_description: string;
  skill_level: number;
  skill_effect: string | null;
  skill_effect_next: string | null;
  skill_icon: string;
};
