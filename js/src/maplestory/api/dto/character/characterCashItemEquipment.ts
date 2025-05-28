import {
  CharacterCashItemEquipmentBody,
  CharacterCashItemEquipmentColoringPrismBody,
  CharacterCashItemEquipmentOptionBody,
  CharacterCashItemEquipmentPresetBody,
} from '../../response/character/characterCashItemEquipmentBody';

/**
 * 캐릭터 캐시 장비 아이템 정보
 */
export class CharacterCashItemEquipmentDto {
  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 성별
   */
  characterGender: string | null;

  /**
   * 캐릭터 직업
   */
  characterClass: string | null;

  /**
   * 캐릭터 외형 모드(0:일반 모드, 1:제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드)
   */
  characterLookMode: string | null;

  /**
   * 적용 중인 캐시 장비 프리셋 번호
   */
  presetNo: number | null;

  /**
   * 장착 중인 캐시 장비
   */
  cashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * 1번 코디 프리셋
   */
  cashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * 2번 코디 프리셋
   */
  cashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * 3번 코디 프리셋
   */
  cashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에서 장착 중인 캐시 장비
   */
  additionalCashItemEquipmentBase: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 1번 코디 프리셋
   */
  additionalCashItemEquipmentPreset1: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 2번 코디 프리셋
   */
  additionalCashItemEquipmentPreset2: CharacterCashItemEquipmentPresetDto[];

  /**
   * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 3번 코디 프리셋
   */
  additionalCashItemEquipmentPreset3: CharacterCashItemEquipmentPresetDto[];

  constructor(obj: CharacterCashItemEquipmentBody) {
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
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.characterLookMode = character_look_mode;
    this.presetNo = preset_no;
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
export class CharacterCashItemEquipmentColoringPrismDto {
  /**
   * 컬러링프리즘 색상 범위
   */
  colorRange: string;

  /**
   * 컬러링프리즘 색조
   */
  hue: number;

  /**
   * 컬러링프리즘 채도
   */
  saturation: number;

  /**
   * 컬러링프리즘 명도
   */
  value: number;

  constructor(obj: CharacterCashItemEquipmentColoringPrismBody) {
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
export class CharacterCashItemEquipmentOptionDto {
  /**
   * 옵션 타입
   */
  optionType: string;

  /**
   * 옵션 값
   */
  optionValue: string;

  constructor(obj: CharacterCashItemEquipmentOptionBody) {
    const { option_type, option_value } = obj;

    this.optionType = option_type;
    this.optionValue = option_value;
  }
}

/**
 * 캐릭터 프리셋 장착 캐시 장비 정보
 */
export class CharacterCashItemEquipmentPresetDto {
  /**
   * 캐시 장비 부위 명
   */
  cashItemEquipmentPart: string;

  /**
   * 캐시 장비 슬롯 위치
   */
  cashItemEquipmentSlot: string;

  /**
   * 캐시 장비 명
   */
  cashItemName: string;

  /**
   * 캐시 장비 아이콘
   */
  cashItemIcon: string;

  /**
   * 캐시 장비 설명
   */
  cashItemDescription: string | null;

  /**
   * 캐시 장비 옵션
   */
  cashItemOption: CharacterCashItemEquipmentOptionDto[];

  /**
   * 캐시 장비 유효 기간 (KST)
   */
  dateExpire: Date | null = null;

  /**
   * 캐시 장비 유효 기간 만료 여부
   */
  isExpired: boolean | null = null;

  /**
   * 캐시 장비 옵션 유효 기간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
   */
  dateOptionExpire: Date | null = null;

  /**
   * 캐시 장비 옵션 유효 기간 만료 여부
   */
  isOptionExpired: boolean | null = null;

  /**
   * 캐시 장비 라벨 정보
   */
  cashItemLabel: string | null;

  /**
   * 캐시 장비 컬러링프리즘 정보
   */
  cashItemColoringPrism: CharacterCashItemEquipmentColoringPrismDto | null;

  /**
   * 아이템 장착 가능 성별
   */
  itemGender: string | null;

  /**
   * 스킬명
   */
  skills: string[];

  constructor(obj: CharacterCashItemEquipmentPresetBody) {
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
