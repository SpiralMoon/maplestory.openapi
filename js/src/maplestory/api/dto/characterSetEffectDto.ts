import {CharacterSetEffectInfoDto} from "./characterSetEffectInfoDto";
import {CharacterSetEffectDtoBody} from "../response/characterSetEffectDtoBody";

/**
 * 캐릭터 세트 효과 정보
 */
class CharacterSetEffectDto {

    /**
     * 조회 기준일
     */
    date: Date;

    /**
     * 세트 효과 정보
     */
    setEffect: CharacterSetEffectInfoDto[]

    constructor(obj: CharacterSetEffectDtoBody) {
        const {date, set_effect} = obj;
        this.date = new Date(date);
        this.setEffect = set_effect.map(effect => new CharacterSetEffectInfoDto(effect));
    }
}

export {CharacterSetEffectDto};
