import * as base from '../../../common/dto/character/characterBasic';
import { CharacterBasicBody } from '../../response/character/characterBasicBody';

/**
 * 캐릭터 기본 정보
 */
export class CharacterBasicDto extends base.CharacterBasicDto {
  /**
   * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
   */
  public override date: Date | null;

  /**
   * 캐릭터 명
   */
  public override characterName: string;

  /**
   * 월드 명
   */
  public override worldName: string;

  /**
   * 캐릭터 성별
   */
  public override characterGender: string;

  /**
   * 캐릭터 직업
   */
  public override characterClass: string;

  /**
   * 캐릭터 전직 차수
   */
  public override characterClassLevel: string;

  /**
   * 캐릭터 레벨
   */
  public override characterLevel: number;

  /**
   * 현재 레벨에서 보유한 경험치
   */
  public override characterExp: number;

  /**
   * 현재 레벨에서 경험치 퍼센트
   */
  public override characterExpRate: string;

  /**
   * 캐릭터 소속 길드 명
   */
  public override characterGuildName: string | null;

  /**
   * 캐릭터 외형 이미지
   */
  public override characterImage: string;

  /**
   * 캐릭터 생성일
   */
  public override characterDateCreate: Date | null;

  /**
   * 최근 7일간 접속 여부
   */
  public override accessFlag: 'true' | 'false';

  /**
   * 해방 퀘스트 완료 여부 (0:미완료, 1:제네시스 무기 해방, 2:데스티니 무기 1차 해방)
   */
  public liberationQuestClear: string;

  constructor(obj: CharacterBasicBody) {
    super();

    const {
      date,
      character_name,
      world_name,
      character_gender,
      character_class,
      character_class_level,
      character_level,
      character_exp,
      character_exp_rate,
      character_guild_name,
      character_image,
      character_date_create,
      access_flag,
      liberation_quest_clear,
    } = obj;

    this.date = date ? new Date(date) : null;
    this.characterName = character_name;
    this.worldName = world_name;
    this.characterGender = character_gender;
    this.characterClass = character_class;
    this.characterClassLevel = character_class_level;
    this.characterLevel = character_level;
    this.characterExp = character_exp;
    this.characterExpRate = character_exp_rate;
    this.characterGuildName = character_guild_name;
    this.characterImage = character_image;
    this.characterDateCreate = character_date_create ? new Date(character_date_create) : null;
    this.accessFlag = access_flag;
    this.liberationQuestClear = liberation_quest_clear;
  }

  /**
   * 최근 7일간 접속 여부
   */
  public override get isAccessFlag() {
    return super.isAccessFlag;
  }
}
