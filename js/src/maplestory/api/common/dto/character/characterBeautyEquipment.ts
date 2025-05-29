export abstract class CharacterBeautyEquipmentDto {
  public abstract date: Date | null;
  public abstract characterGender: string;
  public abstract characterClass: string;
  public abstract characterHair: CharacterBeautyEquipmentHairDto | null;
  public abstract characterFace: CharacterBeautyEquipmentFaceDto | null;
  public abstract characterSkin: CharacterBeautyEquipmentSkinDto | null;
  public abstract additionalCharacterHair: CharacterBeautyEquipmentHairDto | null;
  public abstract additionalCharacterFace: CharacterBeautyEquipmentFaceDto | null;
  public abstract additionalCharacterSkin: CharacterBeautyEquipmentSkinDto | null;
}

export abstract class CharacterBeautyEquipmentFaceDto {
  public abstract faceName: string;
  public abstract baseColor: string;
  public abstract mixColor: string | null;
  public abstract mixRate: string;
}

export abstract class CharacterBeautyEquipmentHairDto {
  public abstract hairName: string;
  public abstract baseColor: string;
  public abstract mixColor: string | null;
  public abstract mixRate: string;
}

export abstract class CharacterBeautyEquipmentSkinDto {
  public abstract skinName: string;
  public abstract colorStyle: string | null;
  public abstract hue: number | null;
  public abstract saturation: number | null;
  public abstract brightness: number | null;
}
