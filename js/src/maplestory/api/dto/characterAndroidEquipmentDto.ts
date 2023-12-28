import { CharacterAndroidCashItemEquipmentDto } from './characterAndroidCashItemEquipmentDto';
import { CharacterAndroidEquipmentFaceDto } from './characterAndroidEquipmentFaceDto';
import { CharacterAndroidEquipmentHairDto } from './characterAndroidEquipmentHairDto';
import { CharacterAndroidEquipmentDtoBody } from '../response/characterAndroidEquipmentDtoBody';

/**
 * 캐릭터 안드로이드 장비 정보
 */
class CharacterAndroidEquipmentDto {
  /**
   * 조회 기준일
   */
  date: Date;

  /**
   * 안드로이드 명
   */
  androidName: string | null;

  /**
   * 안드로이드 닉네임
   */
  androidNickname: string | null;

  /**
   * 안드로이드 아이콘
   */
  androidIcon: string | null;

  /**
   * 안드로이드 아이템 설명
   */
  androidDescription: string | null;

  /**
   * 안드로이드 헤어 정보
   */
  androidHair: CharacterAndroidEquipmentHairDto | null;

  /**
   * 안드로이드 성형 정보
   */
  androidFace: CharacterAndroidEquipmentFaceDto | null;

  /**
   * 안드로이드 피부 명
   */
  androidSkinName: string | null;

  /**
   * 안드로이드 캐시 아이템 장착 정보
   */
  androidCashItemEquipment: CharacterAndroidCashItemEquipmentDto[];

  /**
   * 안드로이드 이어센서 클립 적용 여부
   */
  androidEarSensorClipFlag: string | null;

  constructor(obj: CharacterAndroidEquipmentDtoBody) {
    const {
      date,
      android_name,
      android_nickname,
      android_icon,
      android_description,
      android_hair,
      android_face,
      android_skin_name,
      android_cash_item_equipment,
      android_ear_sensor_clip_flag,
    } = obj;

    this.date = new Date(date);
    this.androidName = android_name;
    this.androidNickname = android_nickname;
    this.androidIcon = android_icon;
    this.androidDescription = android_description;
    this.androidHair = android_hair
      ? new CharacterAndroidEquipmentHairDto(android_hair)
      : null;
    this.androidFace = android_face
      ? new CharacterAndroidEquipmentFaceDto(android_face)
      : null;
    this.androidSkinName = android_skin_name;
    this.androidCashItemEquipment = android_cash_item_equipment.map(
      (equipment) => new CharacterAndroidCashItemEquipmentDto(equipment),
    );
    this.androidEarSensorClipFlag = android_ear_sensor_clip_flag ?? null;
  }
}

export { CharacterAndroidEquipmentDto };
