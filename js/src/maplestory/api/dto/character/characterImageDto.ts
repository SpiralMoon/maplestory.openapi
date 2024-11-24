/**
 * 캐릭터 외형 이미지 정보
 */
class CharacterImageDto {

  /**
   * 조회 기준일
   */
  date: Date | null;

  /**
   * 캐릭터 외형 이미지 원본 (URL)
   */
  originUrl: string;

  /**
   * 캐릭터 외형 기본 이미지 (base64)
   */
  originImage: string;

  /**
   * 캐릭터 외형 이미지 (base64)
   */
  image: string;

  /**
   * 캐릭터 액션
   */
  action: CharacterImageAction;

  /**
   * 캐릭터 감정표현
   */
  emotion: CharacterImageEmotion;

  /**
   * 캐릭터 무기 모션
   */
  wmotion: CharacterImageWeaponMotion;

  /**
   * 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
   */
  width: number;

  /**
   * 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
   */
  height: number;

  /**
   * 캐릭터의 가로 좌표
   */
  x: number | null;

  /**
   * 캐릭터의 세로 좌표.
   */
  y: number | null;

  constructor(obj: {
    date: Date | null;
    originUrl: string;
    originImage: string;
    image: string;
    action: CharacterImageAction;
    emotion: CharacterImageEmotion;
    wmotion: CharacterImageWeaponMotion;
    width: number;
    height: number;
    x: number | null;
    y: number | null;
  }) {
    this.date = obj.date;
    this.originUrl = obj.originUrl;
    this.originImage = obj.originImage;
    this.image = obj.image;
    this.action = obj.action;
    this.emotion = obj.emotion;
    this.wmotion = obj.wmotion;
    this.width = obj.width;
    this.height = obj.height;
    this.x = obj.x;
    this.y = obj.y;
  }
}

/**
 * 캐릭터 액션
 */
enum CharacterImageAction {
  Stand1 = 'A00',
  Stand2 = 'A01',
  Walk1 = 'A02',
  Walk2 = 'A03',
  Prone = 'A04',
  Fly = 'A05',
  Jump = 'A06',
  Sit = 'A07',
}

/**
 * 캐릭터 감정표현
 */
enum CharacterImageEmotion {
  Default = 'E00',
  Wink = 'E01',
  Smile = 'E02',
  Cry = 'E03',
  Angry = 'E04',
  Bewildered = 'E05',
}

/**
 * 캐릭터 무기 모션
 */
enum CharacterImageWeaponMotion {
  Default = 'W00',
  OneHand = 'W01',
  TwoHands = 'W02',
  Gun = 'W03',
}

export { CharacterImageDto, CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion };
