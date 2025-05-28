export type CharacterLinkSkillDtoBody = {
  date: string | null;
  character_class: string | null;
  character_link_skill: CharacterLinkSkillInfoDtoBody[];
  character_link_skill_preset_1: CharacterLinkSkillInfoDtoBody[];
  character_link_skill_preset_2: CharacterLinkSkillInfoDtoBody[];
  character_link_skill_preset_3: CharacterLinkSkillInfoDtoBody[];
  character_owned_link_skill: CharacterLinkSkillInfoDtoBody | null;
  character_owned_link_skill_preset_1: CharacterLinkSkillInfoDtoBody | null;
  character_owned_link_skill_preset_2: CharacterLinkSkillInfoDtoBody | null;
  character_owned_link_skill_preset_3: CharacterLinkSkillInfoDtoBody | null;
};

export type CharacterLinkSkillInfoDtoBody = {
  skill_name: string;
  skill_description: string;
  skill_level: number;
  skill_effect: string;
  skill_effect_next: string | null;
  skill_icon: string;
};
