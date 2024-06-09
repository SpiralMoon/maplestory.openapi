import { CharacterBasicDtoBody } from '@src/maplestory/api/response/character/characterBasicDtoBody';

/**
 * 캐릭터 기본 정보
 */
class CharacterBasicDto {
  date: Date | null;

  /**
   * 캐릭터 명
   */
  characterName: string;

  /**
   * 월드 명
   */
  worldName: string;

  /**
   * 캐릭터 성별
   */
  characterGender: string;

  /**
   * 캐릭터 직업
   */
  characterClass: string;

  /**
   * 캐릭터 전직 차수
   */
  characterClassLevel: string;

  /**
   * 캐릭터 레벨
   */
  characterLevel: number;

  /**
   * 현재 레벨에서 보유한 경험치
   */
  characterExp: number;

  /**
   * 현재 레벨에서 경험치 퍼센트
   */
  characterExpRate: string;

  /**
   * 캐릭터 소속 길드 명
   */
  characterGuildName: string | null;

  /**
   * 캐릭터 외형 이미지
   */
  characterImage: string;

  /**
   * 캐릭터 생성일
   */
  characterDateCreate: Date;

  /**
   * 최근 7일간 접속 여부
   */
  accessFlag: 'true' | 'false';

  /**
   * 해방 퀘스트 완료 여부
   */
  liberationQuestClearFlag: 'true' | 'false';

  constructor(obj: CharacterBasicDtoBody) {
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
      liberation_quest_clear_flag,
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
    this.characterDateCreate = new Date(character_date_create);
    this.accessFlag = access_flag;
    this.liberationQuestClearFlag = liberation_quest_clear_flag;
  }

  /**
   * 최근 7일간 접속 여부
   */
  get isAccessFlag() {
    return this.accessFlag === 'true';
  }

  /**
   * 해방 퀘스트 완료 여부
   */
  get isLiberationQuestClearFlag() {
    return this.liberationQuestClearFlag === 'true';
  }
}

export { CharacterBasicDto };
