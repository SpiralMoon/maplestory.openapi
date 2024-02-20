import { CharacterAndroidCashItemEquipmentDto } from './characterAndroidCashItemEquipmentDto';
import { CharacterAndroidEquipmentFaceDto } from './characterAndroidEquipmentFaceDto';
import { CharacterAndroidEquipmentHairDto } from './characterAndroidEquipmentHairDto';
import { CharacterAndroidEquipmentPresetDto } from './characterAndroidEquipmentPresetDto'
import { CharacterAndroidEquipmentDtoBody } from '../../response/character/characterAndroidEquipmentDtoBody';

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
  androidHair: CharacterAndroidEquipmentHairDto;

  /**
   * 안드로이드 성형 정보
   */
  androidFace: CharacterAndroidEquipmentFaceDto;

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

  /**
   * 안드로이드 성별
   */
  androidGender: string | null;

  /**
   * 안드로이드 등급
   */
  androidGrade: string | null;

  /**
   * 비인간형 안드로이드 여부
   */
  androidNonHumanoidFlag: string | null;

  /**
   * 잡화상점 기능 이용 가능 여부
   */
  androidShopUsableFlag: string | null;

  /**
   * 적용 중인 장비 프리셋 번호
   */
  presetNo: number | null;

  /**
   * 1번 프리셋 안드로이드 정보
   */
  androidPreset1: CharacterAndroidEquipmentPresetDto | null;

  /**
   * 2번 프리셋 안드로이드 정보
   */
  androidPreset2: CharacterAndroidEquipmentPresetDto | null;

  /**
   * 3번 프리셋 안드로이드 정보
   */
  androidPreset3: CharacterAndroidEquipmentPresetDto | null;

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
      android_gender,
      android_grade,
      android_non_humanoid_flag,
      android_shop_usable_flag,
      preset_no,
      android_preset_1,
      android_preset_2,
      android_preset_3,
    } = obj;

    this.date = new Date(date);
    this.androidName = android_name;
    this.androidNickname = android_nickname;
    this.androidIcon = android_icon;
    this.androidDescription = android_description;
    this.androidHair = new CharacterAndroidEquipmentHairDto(android_hair);
    this.androidFace = new CharacterAndroidEquipmentFaceDto(android_face);
    this.androidSkinName = android_skin_name;
    this.androidCashItemEquipment = android_cash_item_equipment.map(
      (equipment) => new CharacterAndroidCashItemEquipmentDto(equipment),
    );
    this.androidEarSensorClipFlag = android_ear_sensor_clip_flag ?? null;
    this.androidGender = android_gender;
    this.androidGrade = android_grade;
    this.androidNonHumanoidFlag = android_non_humanoid_flag;
    this.androidShopUsableFlag = android_shop_usable_flag;
    this.presetNo = preset_no;
    this.androidPreset1 = android_preset_1 ? new CharacterAndroidEquipmentPresetDto(android_preset_1) : null;
    this.androidPreset2 = android_preset_2 ? new CharacterAndroidEquipmentPresetDto(android_preset_2) : null;
    this.androidPreset3 = android_preset_3 ? new CharacterAndroidEquipmentPresetDto(android_preset_3) : null;
  }
}

export { CharacterAndroidEquipmentDto };
