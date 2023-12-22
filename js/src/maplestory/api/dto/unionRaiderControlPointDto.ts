import {UnionRaiderBlockControlPointDtoBody} from "../response/unionRaiderDtoBody";

/**
 * 유니온 블록 기준점 좌표 정보
 */
class UnionRaiderBlockControlPointDto {

    /**
     * 블록 기준점 X좌표
     */
    x: number;

    /**
     * 블록 기준점 Y좌표
     */
    y: number;

    constructor(obj: UnionRaiderBlockControlPointDtoBody) {
        const {x, y} = obj;

        this.x = x;
        this.y = y;
    }
}

export {UnionRaiderBlockControlPointDto};
