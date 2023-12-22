import {CharacterBeautyEquipmentFaceDtoBody} from "../response/characterBeautyEquipmentDtoBody";

/**
 * 캐릭터 성형 정보
 */
class CharacterBeautyEquipmentFaceDto {

    /**
     * 성형 명
     */
    faceName: string;

    /**
     * 성형 베이스 컬러
     */
    baseColor: string;

    /**
     * 성형 믹스 컬러
     */
    mixColor: string;

    /**
     * 성형 믹스 컬러의 염색 비율
     */
    mixRate: string;

    constructor(obj: CharacterBeautyEquipmentFaceDtoBody) {
        const {face_name, base_color, mix_color, mix_rate} = obj;

        this.faceName = face_name;
        this.baseColor = base_color;
        this.mixColor = mix_color;
        this.mixRate = mix_rate;
    }
}

export {CharacterBeautyEquipmentFaceDto};
