export abstract class CharacterItemEquipmentDto {
  public abstract date: Date | null;
  public abstract characterGender: string | null;
  public abstract characterClass: string | null;
  public abstract presetNo: number | null;
  public abstract itemEquipment: CharacterItemEquipmentInfoDto[];
  public abstract itemEquipmentPreset1: CharacterItemEquipmentInfoDto[];
  public abstract itemEquipmentPreset2: CharacterItemEquipmentInfoDto[];
  public abstract itemEquipmentPreset3: CharacterItemEquipmentInfoDto[];
  public abstract title: CharacterItemEquipmentTitleDto | null;
  public abstract dragonEquipment: CharacterItemEquipmentDragonInfoDto[];
  public abstract mechanicEquipment: CharacterItemEquipmentMechanicInfoDto[];
}

export abstract class CharacterItemEquipmentTitleDto {
  public abstract titleName: string | null;
  public abstract titleIcon: string | null;
  public abstract titleDescription: string | null;
  public abstract dateExpire: Date | null;
  public abstract isExpired: boolean | null;
  public abstract dateOptionExpire: Date | null;
  public abstract isOptionExpired: boolean | null;
  public abstract titleShapeName: string | null;
  public abstract titleShapeIcon: string | null;
  public abstract titleShapeDescription: string | null;
}

export abstract class CharacterItemEquipmentAddOptionDto {
  public abstract str: string;
  public abstract dex: string;
  public abstract int: string;
  public abstract luk: string;
  public abstract maxHp: string;
  public abstract maxMp: string;
  public abstract attackPower: string;
  public abstract magicPower: string;
  public abstract armor: string;
  public abstract speed: string;
  public abstract jump: string;
  public abstract bossDamage: string;
  public abstract damage: string;
  public abstract allStat: string;
  public abstract equipmentLevelDecrease: number;
}

export abstract class CharacterItemEquipmentBaseOptionDto {
  public abstract str: string;
  public abstract dex: string;
  public abstract int: string;
  public abstract luk: string;
  public abstract maxHp: string;
  public abstract maxMp: string;
  public abstract attackPower: string;
  public abstract magicPower: string;
  public abstract armor: string;
  public abstract speed: string;
  public abstract jump: string;
  public abstract bossDamage: string;
  public abstract ignoreMonsterArmor: string;
  public abstract allStat: string;
  public abstract maxHpRate: string;
  public abstract maxMpRate: string;
  public abstract baseEquipmentLevel: number;
}

export abstract class CharacterItemEquipmentEtcOptionDto {
  public abstract str: string;
  public abstract dex: string;
  public abstract int: string;
  public abstract luk: string;
  public abstract maxHp: string;
  public abstract maxMp: string;
  public abstract attackPower: string;
  public abstract magicPower: string;
  public abstract armor: string;
  public abstract speed: string;
  public abstract jump: string;
}

export abstract class CharacterItemEquipmentExceptionalOptionDto {
  public abstract str: string;
  public abstract dex: string;
  public abstract int: string;
  public abstract luk: string;
  public abstract maxHp: string;
  public abstract maxMp: string;
  public abstract attackPower: string;
  public abstract magicPower: string;
  public abstract exceptionalUpgrade: number;
}

export abstract class CharacterItemEquipmentStarforceOptionDto {
  public abstract str: string;
  public abstract dex: string;
  public abstract int: string;
  public abstract luk: string;
  public abstract maxHp: string;
  public abstract maxMp: string;
  public abstract attackPower: string;
  public abstract magicPower: string;
  public abstract armor: string;
  public abstract speed: string;
  public abstract jump: string;
}

export abstract class CharacterItemEquipmentTotalOptionDto {
  public abstract str: string;
  public abstract dex: string;
  public abstract int: string;
  public abstract luk: string;
  public abstract maxHp: string;
  public abstract maxMp: string;
  public abstract attackPower: string;
  public abstract magicPower: string;
  public abstract armor: string;
  public abstract speed: string;
  public abstract jump: string;
  public abstract bossDamage: string;
  public abstract ignoreMonsterArmor: string;
  public abstract allStat: string;
  public abstract damage: string;
  public abstract equipmentLevelDecrease: number;
  public abstract maxHpRate: string;
  public abstract maxMpRate: string;
}

export abstract class CharacterItemEquipmentDragonInfoDto {
  public abstract itemEquipmentPart: string;
  public abstract itemEquipmentSlot: string;
  public abstract itemName: string;
  public abstract itemIcon: string;
  public abstract itemDescription: string | null;
  public abstract itemShapeName: string;
  public abstract itemShapeIcon: string;
  public abstract itemGender: string | null;
  public abstract itemTotalOption: CharacterItemEquipmentTotalOptionDto;
  public abstract itemBaseOption: CharacterItemEquipmentBaseOptionDto;
  public abstract equipmentLevelIncrease: number;
  public abstract itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;
  public abstract itemAddOption: CharacterItemEquipmentAddOptionDto;
  public abstract growthExp: number;
  public abstract growthLevel: number;
  public abstract scrollUpgrade: string;
  public abstract cuttableCount: string;
  public abstract goldenHammerFlag: string;
  public abstract scrollResilienceCount: string;
  public abstract scrollUpgradeableCount: string;
  public abstract soulName: string | null;
  public abstract soulOption: string | null;
  public abstract itemEtcOption: CharacterItemEquipmentEtcOptionDto;
  public abstract starforce: string;
  public abstract starforceScrollFlag: string;
  public abstract itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;
  public abstract specialRingLevel: number;
  public abstract dateExpire: Date | null;
  public abstract isExpired: boolean | null;
}

export abstract class CharacterItemEquipmentMechanicInfoDto {
  public abstract itemEquipmentPart: string;
  public abstract itemEquipmentSlot: string;
  public abstract itemName: string;
  public abstract itemIcon: string;
  public abstract itemDescription: string | null;
  public abstract itemShapeName: string;
  public abstract itemShapeIcon: string;
  public abstract itemGender: string | null;
  public abstract itemTotalOption: CharacterItemEquipmentTotalOptionDto;
  public abstract itemBaseOption: CharacterItemEquipmentBaseOptionDto;
  public abstract equipmentLevelIncrease: number;
  public abstract itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;
  public abstract itemAddOption: CharacterItemEquipmentAddOptionDto;
  public abstract growthExp: number;
  public abstract growthLevel: number;
  public abstract scrollUpgrade: string;
  public abstract cuttableCount: string;
  public abstract goldenHammerFlag: string;
  public abstract scrollResilienceCount: string;
  public abstract scrollUpgradeableCount: string;
  public abstract soulName: string | null;
  public abstract soulOption: string | null;
  public abstract itemEtcOption: CharacterItemEquipmentEtcOptionDto;
  public abstract starforce: string;
  public abstract starforceScrollFlag: string;
  public abstract itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;
  public abstract specialRingLevel: number;
  public abstract dateExpire: Date | null;
  public abstract isExpired: boolean | null;
}

export abstract class CharacterItemEquipmentInfoDto {
  public abstract itemEquipmentPart: string;
  public abstract itemEquipmentSlot: string;
  public abstract itemName: string;
  public abstract itemIcon: string;
  public abstract itemDescription: string | null;
  public abstract itemShapeName: string;
  public abstract itemShapeIcon: string;
  public abstract itemGender: string | null;
  public abstract itemTotalOption: CharacterItemEquipmentTotalOptionDto;
  public abstract itemBaseOption: CharacterItemEquipmentBaseOptionDto;
  public abstract potentialOptionGrade: string | null;
  public abstract additionalPotentialOptionGrade: string | null;
  public abstract potentialOption1: string | null;
  public abstract potentialOption2: string | null;
  public abstract potentialOption3: string | null;
  public abstract additionalPotentialOption1: string | null;
  public abstract additionalPotentialOption2: string | null;
  public abstract additionalPotentialOption3: string | null;
  public abstract equipmentLevelIncrease: number;
  public abstract itemExceptionalOption: CharacterItemEquipmentExceptionalOptionDto;
  public abstract itemAddOption: CharacterItemEquipmentAddOptionDto;
  public abstract growthExp: number;
  public abstract growthLevel: number;
  public abstract scrollUpgrade: string;
  public abstract cuttableCount: string;
  public abstract goldenHammerFlag: string;
  public abstract scrollResilienceCount: string;
  public abstract scrollUpgradeableCount: string;
  public abstract soulName: string | null;
  public abstract soulOption: string | null;
  public abstract itemEtcOption: CharacterItemEquipmentEtcOptionDto;
  public abstract starforce: string;
  public abstract starforceScrollFlag: string;
  public abstract itemStarforceOption: CharacterItemEquipmentStarforceOptionDto;
  public abstract specialRingLevel: number;
  public abstract dateExpire: Date | null;
  public abstract isExpired: boolean | null;
}
