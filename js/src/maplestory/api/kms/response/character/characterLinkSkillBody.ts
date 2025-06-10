export type CharacterLinkSkillBody = {
  date: string | null;
  character_class: string | null;
  character_link_skill: CharacterLinkSkillInfoBody[];
  character_link_skill_preset_1: CharacterLinkSkillInfoBody[];
  character_link_skill_preset_2: CharacterLinkSkillInfoBody[];
  character_link_skill_preset_3: CharacterLinkSkillInfoBody[];
  character_owned_link_skill: CharacterLinkSkillInfoBody | null;
  character_owned_link_skill_preset_1: CharacterLinkSkillInfoBody | null;
  character_owned_link_skill_preset_2: CharacterLinkSkillInfoBody | null;
  character_owned_link_skill_preset_3: CharacterLinkSkillInfoBody | null;
};

export type CharacterLinkSkillInfoBody = {
  skill_name: string;
  skill_description: string;
  skill_level: number;
  skill_effect: string;
  skill_effect_next: string | null;
  skill_icon: string;
};
