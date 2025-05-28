import { CharacterItemEquipmentTitleBody } from '../../response/character/characterItemEquipmentBody';

/**
 * 캐릭터 칭호 아이템 정보
 */
class CharacterItemEquipmentTitleDto {
  /**
   * 칭호 장비 명
   */
  titleName: string | null;

  /**
   * 칭호 아이콘
   */
  titleIcon: string | null;

  /**
   * 칭호 설명
   */
  titleDescription: string | null;

  /**
   * 칭호 유효 기간
   */
  dateExpire: Date | null = null;

  /**
   * 칭호 유효 기간 만료 여부
   */
  isExpired: boolean | null = null;

  /**
   * 칭호 옵션 유효 기간
   */
  dateOptionExpire: Date | null = null;

  /**
   * 칭호 옵션 유효 기간 만료 여부
   */
  isOptionExpired: boolean | null = null;

  /**
   * 외형 설정에 등록한 칭호 장비 명
   */
  titleShapeName: string | null;

  /**
   * 외형 설정에 등록한 칭호 아이콘
   */
  titleShapeIcon: string | null;

  /**
   * 외형 설정에 등록한 칭호 설명
   */
  titleShapeDescription: string | null;

  constructor(obj: CharacterItemEquipmentTitleBody) {
    const {
      title_name,
      title_icon,
      title_description,
      date_expire,
      date_option_expire,
      title_shape_name,
      title_shape_icon,
      title_shape_description,
    } = obj;

    this.titleName = title_name;
    this.titleIcon = title_icon;
    this.titleDescription = title_description;
    this.titleShapeName = title_shape_name;
    this.titleShapeIcon = title_shape_icon;
    this.titleShapeDescription = title_shape_description;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire
        ? new Date(date_expire)
        : null;
    }

    if (date_option_expire === 'expired') {
      this.isOptionExpired = true;
    } else if (typeof date_option_expire === 'string') {
      this.dateOptionExpire = date_option_expire
        ? new Date(date_option_expire)
        : null;
    }
  }
}

export { CharacterItemEquipmentTitleDto };
