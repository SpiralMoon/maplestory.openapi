import * as base from '../../../common/dto/character/characterCashItemEquipment';
import {
  CharacterCashItemEquipmentBody,
  CharacterCashItemEquipmentColoringPrismBody,
  CharacterCashItemEquipmentOptionBody,
  CharacterCashItemEquipmentPresetBody,
} from '../../response/character/characterCashItemEquipmentBody';

/**
 * 캐릭터 캐시 장비 아이템 정보
 */
export class CharacterCashItemEquipmentDto extends base.CharacterCashItemEquipmentDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 캐릭터 성별
   */
  public override characterGender: string;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string;

  /**
   * 캐릭터 외형 모드(0:일반 모드, 1:제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
   */
  public override characterLookMode: string | null;

  /**
   * 적용 중인 캐시 장비 프리셋 번호
   */
  public override presetNo: number;

  /**
   * 장착 중인 캐시 장비
   */
  public override cashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * 1번 코디 프리셋
   */
  public override cashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * 2번 코디 프리셋
   */
  public override cashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * 3번 코디 프리셋
   */
  public override cashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
   */
  public override additionalCashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 1번 코디 프리셋
   */
  public override additionalCashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 2번 코디 프리셋
   */
  public override additionalCashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 3번 코디 프리셋
   */
  public override additionalCashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  constructor(obj: CharacterCashItemEquipmentBody) {
    super();

    const {
      date,
      character_gender,
      character_class,
      character_look_mode,
      preset_no,
      cash_item_equipment_base,
      cash_item_equipment_preset_1,
      cash_item_equipment_preset_2,
      cash_item_equipment_preset_3,
      additional_cash_item_equipment_base,
      additional_cash_item_equipment_preset_1,
      additional_cash_item_equipment_preset_2,
      additional_cash_item_equipment_preset_3,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterGender = character_gender!;
    this.characterClass = character_class!;
    this.characterLookMode = character_look_mode;
    this.presetNo = preset_no!;
    this.cashItemEquipmentBase = cash_item_equipment_base.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset1 = cash_item_equipment_preset_1.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset2 = cash_item_equipment_preset_2.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.cashItemEquipmentPreset3 = cash_item_equipment_preset_3.map(
      (preset) => new CharacterCashItemEquipmentPresetDto(preset),
    );
    this.additionalCashItemEquipmentBase =
      additional_cash_item_equipment_base.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset1 =
      additional_cash_item_equipment_preset_1.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset2 =
      additional_cash_item_equipment_preset_2.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
    this.additionalCashItemEquipmentPreset3 =
      additional_cash_item_equipment_preset_3.map(
        (preset) => new CharacterCashItemEquipmentPresetDto(preset),
      );
  }
}

/**
 * 캐릭터 캐시 장비 컬러링프리즘
 */
export class CharacterCashItemEquipmentColoringPrismDto extends base.CharacterCashItemEquipmentColoringPrismDto {
  /**
   * 컬러링프리즘 색상 범위
   */
  public override colorRange: string;

  /**
   * 컬러링프리즘 색조
   */
  public override hue: number;

  /**
   * 컬러링프리즘 채도
   */
  public override saturation: number;

  /**
   * 컬러링프리즘 명도
   */
  public override value: number;

  constructor(obj: CharacterCashItemEquipmentColoringPrismBody) {
    super();

    const { color_range, hue, saturation, value } = obj;

    this.colorRange = color_range;
    this.hue = hue;
    this.saturation = saturation;
    this.value = value;
  }
}

/**
 * 캐릭터 캐시 장비 옵션
 */
export class CharacterCashItemEquipmentOptionDto extends base.CharacterCashItemEquipmentOptionDto {
  /**
   * 옵션 타입
   */
  public override optionType: string;

  /**
   * 옵션 값
   */
  public override optionValue: string;

  constructor(obj: CharacterCashItemEquipmentOptionBody) {
    super();

    const { option_type, option_value } = obj;

    this.optionType = option_type;
    this.optionValue = option_value;
  }
}

/**
 * 캐릭터 프리셋 장착 캐시 장비 정보
 */
export class CharacterCashItemEquipmentPresetDto extends base.CharacterCashItemEquipmentPresetDto {
  /**
   * 캐시 장비 부위 명
   */
  public override cashItemEquipmentPart: string;

  /**
   * 캐시 장비 슬롯 위치
   */
  public override cashItemEquipmentSlot: string;

  /**
   * 캐시 장비 명
   */
  public override cashItemName: string;

  /**
   * 캐시 장비 아이콘
   */
  public override cashItemIcon: string;

  /**
   * 캐시 장비 설명
   */
  public override cashItemDescription: string | null;

  /**
   * 캐시 장비 옵션
   */
  public override cashItemOption: CharacterCashItemEquipmentOptionDto[];

  /**
   * 캐시 장비 유효 기간 (KST)
   */
  public override dateExpire: Date | null = null;

  /**
   * 캐시 장비 유효 기간 만료 여부
   */
  public override isExpired: boolean | null = null;

  /**
   * 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  public override dateOptionExpire: Date | null = null;

  /**
   * 캐시 장비 옵션 유효 기간 만료 여부
   */
  public override isOptionExpired: boolean | null = null;

  /**
   * 캐시 장비 라벨 정보
   */
  public override cashItemLabel: string | null;

  /**
   * 캐시 장비 컬러링프리즘 정보
   */
  public override cashItemColoringPrism: CharacterCashItemEquipmentColoringPrismDto | null;

  /**
   * 아이템 장착 가능 성별
   */
  public override itemGender: string | null;

  /**
   * 스킬명
   */
  public skills: string[];

  /**
   * 프리스타일 쿠폰 적용 여부 (0:미적용, 1:적용)
   */
  public freestyleFlag: string | null;

  constructor(obj: CharacterCashItemEquipmentPresetBody) {
    super();

    const {
      cash_item_equipment_part,
      cash_item_equipment_slot,
      cash_item_name,
      cash_item_icon,
      cash_item_description,
      cash_item_option,
      date_expire,
      date_option_expire,
      cash_item_label,
      cash_item_coloring_prism,
      item_gender,
      skills,
      freestyle_flag,
    } = obj;

    this.cashItemEquipmentPart = cash_item_equipment_part;
    this.cashItemEquipmentSlot = cash_item_equipment_slot;
    this.cashItemName = cash_item_name;
    this.cashItemIcon = cash_item_icon;
    this.cashItemDescription = cash_item_description;
    this.cashItemOption = cash_item_option.map(
      (option) => new CharacterCashItemEquipmentOptionDto(option),
    );
    this.cashItemLabel = cash_item_label;
    this.cashItemColoringPrism = cash_item_coloring_prism
      ? new CharacterCashItemEquipmentColoringPrismDto(cash_item_coloring_prism)
      : null;
    this.itemGender = item_gender;
    this.skills = skills;
    this.freestyleFlag = freestyle_flag;

    if (date_expire === 'expired') {
      this.isExpired = true;
    } else if (typeof date_expire === 'string') {
      this.dateExpire = date_expire ? new Date(date_expire) : null;
    }

    if (date_option_expire === 'expired') {
      this.isOptionExpired = true;
    } else if (typeof date_option_expire === 'string') {
      this.dateOptionExpire = date_option_expire
        ? new Date(date_option_expire)
        : null;
    }
  }

  /**
   * 프리스타일 쿠폰 적용 여부
   */
  public get isFreestyleFlag() {
    return this.freestyleFlag === '1';
  }
}
