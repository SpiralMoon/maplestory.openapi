export type UnionArtifactBody = {
  date: string | null;
  union_artifact_effect: UnionArtifactEffectBody[];
  union_artifact_crystal: UnionArtifactCrystalBody[];
  union_artifact_remain_ap: number | null;
};

export type UnionArtifactEffectBody = {
  name: string;
  level: number;
};

export type UnionArtifactCrystalBody = {
  name: string;
  validity_flag: string;
  date_expire: string;
  level: number;
  crystal_option_name_1: string;
  crystal_option_name_2: string;
  crystal_option_name_3: string;
};
