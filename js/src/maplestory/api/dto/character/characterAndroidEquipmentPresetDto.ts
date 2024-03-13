import { CharacterAndroidEquipmentFaceDto } from '@src/maplestory/api/dto/character/characterAndroidEquipmentFaceDto';
import { CharacterAndroidEquipmentHairDto } from '@src/maplestory/api/dto/character/characterAndroidEquipmentHairDto';
import {
  CharacterAndroidEquipmentPresetDtoBody
} from '@src/maplestory/api/response/character/characterAndroidEquipmentDtoBody';

/**
 * 캐릭터 안드로이드 프리셋 정보
 */
class CharacterAndroidEquipmentPresetDto {

  /**
   * 안드로이드 명
   */
  androidName: string;

  /**
   * 안드로이드 닉네임
   */
  androidNickname: string;

  /**
   * 안드로이드 아이콘
   */
  androidIcon: string;

  /**
   * 안드로이드 아이템 설명
   */
  androidDescription: string;

  /**
   * 안드로이드 성별
   */
  androidGender: string | null;

  /**
   * 안드로이드 등급
   */
  androidGrade: string;

  /**
   * 안드로이드 피부 명
   */
  androidSkinName: string;

  /**
   * 안드로이드 헤어 정보
   */
  androidHair: CharacterAndroidEquipmentHairDto;

  /**
   * 안드로이드 성형 정보
   */
  androidFace: CharacterAndroidEquipmentFaceDto;

  /**
   * 안드로이드 이어센서 클립 적용 여부
   */
  androidEarSensorClipFlag: string;

  /**
   * 비인간형 안드로이드 여부
   */
  androidNonHumanoidFlag: string;

  /**
   * 잡화상점 기능 이용 가능 여부
   */
  androidShopUsableFlag: string;

  constructor(obj: CharacterAndroidEquipmentPresetDtoBody) {
    const {
      android_name,
      android_nickname,
      android_icon,
      android_description,
      android_gender,
      android_grade,
      android_skin_name,
      android_hair,
      android_face,
      android_ear_sensor_clip_flag,
      android_non_humanoid_flag,
      android_shop_usable_flag,
    } = obj;

    this.androidName = android_name;
    this.androidNickname = android_nickname;
    this.androidIcon = android_icon;
    this.androidDescription = android_description;
    this.androidGender = android_gender;
    this.androidGrade = android_grade;
    this.androidSkinName = android_skin_name;
    this.androidHair = new CharacterAndroidEquipmentHairDto(android_hair);
    this.androidFace = new CharacterAndroidEquipmentFaceDto(android_face);
    this.androidEarSensorClipFlag = android_ear_sensor_clip_flag;
    this.androidNonHumanoidFlag = android_non_humanoid_flag;
    this.androidShopUsableFlag = android_shop_usable_flag;
  }
}

export { CharacterAndroidEquipmentPresetDto };
