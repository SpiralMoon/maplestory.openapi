export type UnionArtifactDtoBody = {
  date: string | null;
  union_artifact_effect: UnionArtifactEffectDtoBody[];
  union_artifact_crystal: UnionArtifactCrystalDtoBody[];
  union_artifact_remain_ap: number | null;
};

export type UnionArtifactEffectDtoBody = {
  name: string;
  level: number;
};

export type UnionArtifactCrystalDtoBody = {
  name: string;
  validity_flag: string;
  date_expire: string;
  level: number;
  crystal_option_name_1: string;
  crystal_option_name_2: string;
  crystal_option_name_3: string;
};
