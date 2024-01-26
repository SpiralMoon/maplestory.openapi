type CharacterLinkSkillDtoBody = {
  date: string;
  character_class: string;
  character_link_skill: CharacterLinkSkillInfoDtoBody[];
  character_link_skill_preset_1: CharacterLinkSkillInfoDtoBody[];
  character_link_skill_preset_2: CharacterLinkSkillInfoDtoBody[];
  character_link_skill_preset_3: CharacterLinkSkillInfoDtoBody[];
  character_owned_link_skill: CharacterLinkSkillInfoDtoBody;
  character_owned_link_skill_preset_1: CharacterLinkSkillInfoDtoBody | null;
  character_owned_link_skill_preset_2: CharacterLinkSkillInfoDtoBody | null;
  character_owned_link_skill_preset_3: CharacterLinkSkillInfoDtoBody | null;
};

type CharacterLinkSkillInfoDtoBody = {
  skill_name: string;
  skill_description: string;
  skill_level: number;
  skill_effect: string;
  skill_icon: string;
};

export type { CharacterLinkSkillDtoBody, CharacterLinkSkillInfoDtoBody };
