export abstract class CharacterHexaMatrixStatDto {
  public abstract date: Date | null;
  public abstract characterClass: string | null;
  public abstract characterHexaStatCore: CharacterHexaMatrixStatCoreDto[];
  public abstract characterHexaStatCore2: CharacterHexaMatrixStatCoreDto[];
  public abstract characterHexaStatCore3: CharacterHexaMatrixStatCoreDto[];
  public abstract presetHexaStatCore: CharacterHexaMatrixStatCoreDto[];
  public abstract presetHexaStatCore2: CharacterHexaMatrixStatCoreDto[];
  public abstract presetHexaStatCore3: CharacterHexaMatrixStatCoreDto[];
}

export abstract class CharacterHexaMatrixStatCoreDto {
  public abstract slotId: string;
  public abstract mainStatName: string;
  public abstract subStatName1: string;
  public abstract subStatName2: string;
  public abstract mainStatLevel: number;
  public abstract subStatLevel1: number;
  public abstract subStatLevel2: number;
  public abstract statGrade: number;
}
