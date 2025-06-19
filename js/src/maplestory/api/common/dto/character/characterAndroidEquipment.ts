export abstract class CharacterAndroidEquipmentDto {
  public abstract date: Date | null;
  public abstract androidName: string | null;
  public abstract androidNickname: string | null;
  public abstract androidIcon: string | null;
  public abstract androidDescription: string | null;
  public abstract androidHair: CharacterAndroidEquipmentHairDto | null;
  public abstract androidFace: CharacterAndroidEquipmentFaceDto | null;
  public abstract androidSkin: CharacterAndroidEquipmentSkinDto | null;
  public abstract androidCashItemEquipment: CharacterAndroidCashItemEquipmentDto[];
  public abstract androidEarSensorClipFlag: string | null;
  public abstract androidGender: string | null;
  public abstract androidGrade: string | null;
  public abstract androidNonHumanoidFlag: string | null;
  public abstract androidShopUsableFlag: string | null;
  public abstract presetNo: number | null;
  public abstract androidPreset1: CharacterAndroidEquipmentPresetDto | null;
  public abstract androidPreset2: CharacterAndroidEquipmentPresetDto | null;
  public abstract androidPreset3: CharacterAndroidEquipmentPresetDto | null;
}

export abstract class CharacterAndroidEquipmentFaceDto {
  public abstract faceName: string | null;
  public abstract baseColor: string | null;
  public abstract mixColor: string | null;
  public abstract mixRate: string;
}

export abstract class CharacterAndroidEquipmentHairDto {
  public abstract hairName: string | null;
  public abstract baseColor: string | null;
  public abstract mixColor: string | null;
  public abstract mixRate: string;
}

export abstract class CharacterAndroidEquipmentSkinDto {
  public abstract skinName: string;
  public abstract colorStyle: string | null;
  public abstract hue: number | null;
  public abstract saturation: number | null;
  public abstract brightness: number | null;
}

export abstract class CharacterAndroidEquipmentPresetDto {
  public abstract androidName: string;
  public abstract androidNickname: string;
  public abstract androidIcon: string;
  public abstract androidDescription: string;
  public abstract androidGender: string | null;
  public abstract androidGrade: string;
  public abstract androidHair: CharacterAndroidEquipmentHairDto;
  public abstract androidFace: CharacterAndroidEquipmentFaceDto;
  public abstract androidSkin: CharacterAndroidEquipmentSkinDto | null;
  public abstract androidEarSensorClipFlag: string;
  public abstract androidNonHumanoidFlag: string;
  public abstract androidShopUsableFlag: string;
}

export abstract class CharacterAndroidCashItemEquipmentColoringPrismDto {
  public abstract colorRange: string;
  public abstract hue: number;
  public abstract saturation: number;
  public abstract value: number;
}

export abstract class CharacterAndroidCashItemEquipmentOptionDto {
  public abstract optionType: string;
  public abstract optionValue: string;
}

export abstract class CharacterAndroidCashItemEquipmentDto {
  public abstract cashItemEquipmentPart: string;
  public abstract cashItemEquipmentSlot: string;
  public abstract cashItemName: string;
  public abstract cashItemIcon: string;
  public abstract cashItemDescription: string | null;
  public abstract cashItemOption: CharacterAndroidCashItemEquipmentOptionDto[];
  public abstract dateExpire: Date | null;
  public abstract isExpired: boolean | null;
  public abstract dateOptionExpire: Date | null;
  public abstract isOptionExpired: boolean | null;
  public abstract cashItemLabel: string | null;
  public abstract cashItemColoringPrism: CharacterAndroidCashItemEquipmentColoringPrismDto | null;
  public abstract androidItemGender: string | null;
}
