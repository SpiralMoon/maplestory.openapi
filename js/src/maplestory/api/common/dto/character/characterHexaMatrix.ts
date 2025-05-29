export abstract class CharacterHexaMatrixDto {
  public abstract date: Date | null;
  public abstract characterHexaCoreEquipment: CharacterHexaMatrixEquipmentDto[];
}

export abstract class CharacterHexaMatrixEquipmentLinkedSkillDto {
  public abstract hexaSkillId: string;
}

export abstract class CharacterHexaMatrixEquipmentDto {
  public abstract hexaCoreName: string;
  public abstract hexaCoreLevel: number;
  public abstract hexaCoreType: string;
  public abstract linkedSkill: CharacterHexaMatrixEquipmentLinkedSkillDto[];
}
