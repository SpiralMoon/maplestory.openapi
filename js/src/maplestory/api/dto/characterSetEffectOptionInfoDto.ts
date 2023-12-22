import {CharacterSetEffectOptionInfoDtoBody} from "../response/characterSetEffectDtoBody";

/**
 * 캐릭터 세트 효과 옵션 정보
 */
class CharacterSetEffectOptionInfoDto {

    /**
     * 세트 효과 레벨 (장비 수)
     */
    setCount: number;

    /**
     * 적용 중인 세트 효과
     */
    setOption: string;

    constructor(obj: CharacterSetEffectOptionInfoDtoBody) {
        const {set_count, set_option} = obj;

        this.setCount = set_count;
        this.setOption = set_option;
    }
}

export {CharacterSetEffectOptionInfoDto};
