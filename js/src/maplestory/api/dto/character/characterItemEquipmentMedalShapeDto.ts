import { CharacterItemEquipmentMedalShapeBody } from '../../response/character/characterItemEquipmentBody';

/**
 * 캐릭터 외형 설정에 등록한 훈장 외형 정보
 */
class CharacterItemEquipmentMedalShapeDto {
  /**
   * 외형 설정에 등록한 훈장 장비 명
   */
  medalShapeName: string;

  /**
   * 외형 설정에 등록한 훈장 아이콘
   */
  medalShapeIcon: string;

  /**
   * 외형 설정에 등록한 훈장 설명
   */
  medalShapeDescription: string;

  /**
   * 외형 설정에 등록한 훈장의 모루 적용 장비 명
   */
  medalShapeChangedName: string;

  /**
   * 외형 설정에 등록한 훈장의 모루 적용 아이콘
   */
  medalShapeChangedIcon: string;

  /**
   * 외형 설정에 등록한 훈장의 모루 적용 훈장 설명
   */
  medalShapeChangedDescription: string;

  constructor(obj: CharacterItemEquipmentMedalShapeBody) {
    const {
      medal_shape_name,
      medal_shape_icon,
      medal_shape_description,
      medal_shape_changed_name,
      medal_shape_changed_icon,
      medal_shape_changed_description,
    } = obj;

    this.medalShapeName = medal_shape_name;
    this.medalShapeIcon = medal_shape_icon;
    this.medalShapeDescription = medal_shape_description;
    this.medalShapeChangedName = medal_shape_changed_name;
    this.medalShapeChangedIcon = medal_shape_changed_icon;
    this.medalShapeChangedDescription = medal_shape_changed_description;
  }
}

export { CharacterItemEquipmentMedalShapeDto };
