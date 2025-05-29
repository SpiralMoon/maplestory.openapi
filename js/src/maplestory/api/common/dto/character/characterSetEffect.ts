export abstract class CharacterSetEffectDto {
  public abstract date: Date | null;
  public abstract setEffect: CharacterSetEffectSetDto[];
}

export abstract class CharacterSetEffectInfoDto {
  public abstract setCount: number;
  public abstract setOption: string;
}

export abstract class CharacterSetEffectOptionFullDto {
  public abstract setCount: number;
  public abstract setOption: string;
}

export abstract class CharacterSetEffectSetDto {
  public abstract setName: string;
  public abstract totalSetCount: number;
  public abstract setEffectInfo: CharacterSetEffectInfoDto[];
  public abstract setOptionFull: CharacterSetEffectOptionFullDto[];
}
