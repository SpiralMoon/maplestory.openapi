type UnionArtifactDtoBody = {
  date: string;
  union_artifact_effect: UnionArtifactEffectDtoBody[];
  union_artifact_crystal: UnionArtifactCrystalDtoBody[];
  union_artifact_remain_ap: number | null;
};

type UnionArtifactEffectDtoBody = {
  name: string;
  level: number;
};

type UnionArtifactCrystalDtoBody = {
  name: string;
  validity_flag: string;
  date_expire: string;
  level: number;
  crystal_option_name_1: string;
  crystal_option_name_2: string;
  crystal_option_name_3: string;
};

export type {
  UnionArtifactDtoBody,
  UnionArtifactEffectDtoBody,
  UnionArtifactCrystalDtoBody,
};
