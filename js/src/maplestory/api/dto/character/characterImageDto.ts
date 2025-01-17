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
   * 캐릭터 액션 프레임
   */
  actionFrame: number | null;

  /**
   * 캐릭터 감정표현 프레임
   */
  emotionFrame: number | null;

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
    actionFrame: number | null;
    emotionFrame: number | null;
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
    this.actionFrame = obj.actionFrame;
    this.emotionFrame = obj.emotionFrame;
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
  Ladder = 'A08',
  Rope = 'A09',
  Heal = 'A10',
  Alert = 'A11',
  ProneStab = 'A12',
  SwingO1 = 'A13',
  SwingO2 = 'A14',
  SwingO3 = 'A15',
  SwingOF = 'A16',
  SwingP1 = 'A17',
  SwingP2 = 'A18',
  SwingPF = 'A19',
  SwingT1 = 'A20',
  SwingT2 = 'A21',
  SwingT3 = 'A22',
  SwingTF = 'A23',
  StabO1 = 'A24',
  StabO2 = 'A25',
  StabOF = 'A26',
  StabT1 = 'A27',
  StabT2 = 'A28',
  StabTF = 'A29',
  Shoot1 = 'A30',
  Shoot2 = 'A31',
  ShootF = 'A32',
  Dead = 'A33',
  GhostWalk = 'A34',
  GhostStand = 'A35',
  GhostJump = 'A36',
  GhostProneStab = 'A37',
  GhostLadder = 'A38',
  GhostRope = 'A39',
  GhostFly = 'A40',
  GhostSit = 'A41',
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
  Blink = 'E06',
  Blaze = 'E07',
  Bowing = 'E08',
  Cheers = 'E09',
  Chu = 'E10',
  Dam = 'E11',
  Despair = 'E12',
  Glitter = 'E13',
  Hit = 'E14',
  Hot = 'E15',
  Hum = 'E16',
  Love = 'E17',
  Oops = 'E18',
  Pain = 'E19',
  Troubled = 'E20',
  QBlue = 'E21',
  Shine = 'E22',
  Stunned = 'E23',
  Vomit = 'E24',
}

/**
 * 캐릭터 무기 모션
 */
enum CharacterImageWeaponMotion {
  Default = 'W00',
  OneHand = 'W01',
  TwoHands = 'W02',
  Gun = 'W03',
  Nothing = 'W04',
}

export { CharacterImageDto, CharacterImageAction, CharacterImageEmotion, CharacterImageWeaponMotion };
