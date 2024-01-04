type GuildBasicDtoBody = {
  date: string;
  world_name: string;
  guild_name: string;
  guild_level: number;
  guild_fame: number;
  guild_point: number;
  guild_master_name: string;
  guild_member_count: number;
  guild_member: string[];
  guild_skill: GuildSkillDtoBody[];
  guild_noblesse_skill: GuildSkillDtoBody[];
  guild_mark: string | null;
  guild_mark_custom: string | null;
};

type GuildSkillDtoBody = {
  skill_name: string;
  skill_description: string;
  skill_level: number;
  skill_effect: string;
  skill_icon: string;
};

export type { GuildBasicDtoBody, GuildSkillDtoBody };
