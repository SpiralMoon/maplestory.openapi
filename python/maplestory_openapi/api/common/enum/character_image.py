from enum import Enum


class CharacterImageAction(Enum):
    """
    Character action
    """
    Stand1 = 'A00'
    Stand2 = 'A01'
    Walk1 = 'A02'
    Walk2 = 'A03'
    Prone = 'A04'
    Fly = 'A05'
    Jump = 'A06'
    Sit = 'A07'
    Ladder = 'A08'
    Rope = 'A09'
    Heal = 'A10'
    Alert = 'A11'
    ProneStab = 'A12'
    SwingO1 = 'A13'
    SwingO2 = 'A14'
    SwingO3 = 'A15'
    SwingOF = 'A16'
    SwingP1 = 'A17'
    SwingP2 = 'A18'
    SwingPF = 'A19'
    SwingT1 = 'A20'
    SwingT2 = 'A21'
    SwingT3 = 'A22'
    SwingTF = 'A23'
    StabO1 = 'A24'
    StabO2 = 'A25'
    StabOF = 'A26'
    StabT1 = 'A27'
    StabT2 = 'A28'
    StabTF = 'A29'
    Shoot1 = 'A30'
    Shoot2 = 'A31'
    ShootF = 'A32'
    Dead = 'A33'
    GhostWalk = 'A34'
    GhostStand = 'A35'
    GhostJump = 'A36'
    GhostProneStab = 'A37'
    GhostLadder = 'A38'
    GhostRope = 'A39'
    GhostFly = 'A40'
    GhostSit = 'A41'

class CharacterImageEmotion(Enum):
    """
    Character emotion
    """
    Default = 'E00'
    Wink = 'E01'
    Smile = 'E02'
    Cry = 'E03'
    Angry = 'E04'
    Bewildered = 'E05'
    Blink = 'E06'
    Blaze = 'E07'
    Bowing = 'E08'
    Cheers = 'E09'
    Chu = 'E10'
    Dam = 'E11'
    Despair = 'E12'
    Glitter = 'E13'
    Hit = 'E14'
    Hot = 'E15'
    Hum = 'E16'
    Love = 'E17'
    Oops = 'E18'
    Pain = 'E19'
    Troubled = 'E20'
    QBlue = 'E21'
    Shine = 'E22'
    Stunned = 'E23'
    Vomit = 'E24'

class CharacterImageWeaponMotion(Enum):
    """
    Character weapon motion
    """
    Default = 'W00'
    OneHand = 'W01'
    TwoHands = 'W02'
    Gun = 'W03'
    Nothing = 'W04'
