export abstract class UnionDto {
  public abstract date: Date | null;
  public abstract unionLevel: number | null;
  public abstract unionGrade: string | null;
  public abstract unionArtifactLevel: number | null;
  public abstract unionArtifactExp: number | null;
  public abstract unionArtifactPoint: number | null;
}
