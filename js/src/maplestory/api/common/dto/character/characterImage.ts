import {
  CharacterImageAction,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
} from '../../enum/characterImage';

export abstract class CharacterImageDto {
  public abstract date: Date | null;
  public abstract originUrl: string;
  public abstract originImage: string;
  public abstract image: string;
  public abstract action: CharacterImageAction;
  public abstract emotion: CharacterImageEmotion;
  public abstract wmotion: CharacterImageWeaponMotion;
  public abstract actionFrame: number | null;
  public abstract emotionFrame: number | null;
  public abstract width: number;
  public abstract height: number;
  public abstract x: number | null;
  public abstract y: number | null;
}
