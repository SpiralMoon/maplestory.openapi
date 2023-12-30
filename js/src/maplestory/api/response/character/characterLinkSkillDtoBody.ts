type CharacterLinkSkillDtoBody = {
  date: string;
  character_class: string;
  character_link_skill: CharacterLinkSkillInfoDtoBody;
  character_owned_link_skill: CharacterLinkSkillInfoDtoBody;
};

type CharacterLinkSkillInfoDtoBody = {
  skill_name: string;
  skill_description: string;
  skill_level: number;
  skill_effect: string;
  skill_icon: string;
};

export type { CharacterLinkSkillDtoBody, CharacterLinkSkillInfoDtoBody };
