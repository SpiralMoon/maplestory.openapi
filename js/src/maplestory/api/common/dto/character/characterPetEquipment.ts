export abstract class CharacterPetEquipmentDto {
  public abstract date: Date | null;
  public abstract pet1Name: string | null;
  public abstract pet1Nickname: string | null;
  public abstract pet1Icon: string | null;
  public abstract pet1Description: string | null;
  public abstract pet1Equipment: CharacterPetEquipmentItemDto | null;
  public abstract pet1AutoSkill: CharacterPetEquipmentAutoSkillDto | null;
  public abstract pet1PetType: string | null;
  public abstract pet1Skill: string[];
  public abstract pet1DateExpire: Date | null;
  public abstract pet1Expired: boolean | null;
  public abstract pet1Appearance: string | null;
  public abstract pet1AppearanceIcon: string | null;
  public abstract pet2Name: string | null;
  public abstract pet2Nickname: string | null;
  public abstract pet2Icon: string | null;
  public abstract pet2Description: string | null;
  public abstract pet2Equipment: CharacterPetEquipmentItemDto | null;
  public abstract pet2AutoSkill: CharacterPetEquipmentAutoSkillDto | null;
  public abstract pet2PetType: string | null;
  public abstract pet2Skill: string[];
  public abstract pet2DateExpire: Date | null;
  public abstract pet2Expired: boolean | null;
  public abstract pet2Appearance: string | null;
  public abstract pet2AppearanceIcon: string | null;
  public abstract pet3Name: string | null;
  public abstract pet3Nickname: string | null;
  public abstract pet3Icon: string | null;
  public abstract pet3Description: string | null;
  public abstract pet3Equipment: CharacterPetEquipmentItemDto | null;
  public abstract pet3AutoSkill: CharacterPetEquipmentAutoSkillDto | null;
  public abstract pet3PetType: string | null;
  public abstract pet3Skill: string[];
  public abstract pet3DateExpire: Date | null;
  public abstract pet3Expired: boolean | null;
  public abstract pet3Appearance: string | null;
  public abstract pet3AppearanceIcon: string | null;
}

export abstract class CharacterPetEquipmentAutoSkillDto {
  public abstract skill1: string | null;
  public abstract skill1Icon: string | null;
  public abstract skill2: string | null;
  public abstract skill2Icon: string | null;
}

export abstract class CharacterPetEquipmentItemOptionDto {
  public abstract optionType: string;
  public abstract optionValue: string;
}

export abstract class CharacterPetEquipmentItemDto {
  public abstract itemName: string | null;
  public abstract itemIcon: string | null;
  public abstract itemDescription: string | null;
  public abstract itemOption: CharacterPetEquipmentItemOptionDto[];
  public abstract scrollUpgrade: number;
  public abstract scrollUpgradable: number;
  public abstract itemShape: string | null;
  public abstract itemShapeIcon: string | null;
}
