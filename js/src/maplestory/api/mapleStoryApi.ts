import {CubeHistoryResponseDto} from "./dto/cubeHistoryResponseDto";
import {InspectionInfoDto} from "./dto/inspectionInfoDto";
import {MapleStoryApiError} from "./mapleStoryApiError";
import {CubeHistoryResponseDtoBody} from "./response/cubeHistoryResponseDtoBody";
import {InspectionInfoSoapBody} from "./response/inspectionInfoSoapBody";
import {CharacterDtoBody} from "./response/characterDtoBody";
import {CharacterDto} from "./dto/characterDto";
import {CharacterBasicDto} from "./dto/characterBasicDto";
import {CharacterBasicDtoBody} from "./response/characterBasicDtoBody";
import {CharacterPopularityDto} from "./dto/characterPopularityDto";
import {CharacterPopularityDtoBody} from "./response/characterPopularityDtoBody";
import {CharacterStatDto} from "./dto/characterStatDto";
import {CharacterStatDtoBody} from "./response/characterStatDtoBody";
import {CharacterHyperStatDto} from "./dto/characterHyperStatDto";
import {CharacterHyperStatDtoBody} from "./response/characterHyperStatDtoBody";
import {CharacterPropensityDto} from "./dto/characterPropensityDto";
import {CharacterPropensityDtoBody} from "./response/characterPropensityDtoBody";
import {CharacterAbilityDto} from "./dto/characterAbilityDto";
import {CharacterAbilityDtoBody} from "./response/characterAbilityDtoBody";
import {CharacterItemEquipmentDto} from "./dto/characterItemEquipmentDto";
import {CharacterItemEquipmentDtoBody} from "./response/characterItemEquipmentDtoBody";
import {CharacterCashItemEquipmentDto} from "./dto/characterCashItemEquipmentDto";
import {CharacterCashItemEquipmentDtoBody} from "./response/characterCashItemEquipmentDtoBody";
import {CharacterSymbolEquipmentDto} from "./dto/characterSymbolEquipmentDto";
import {CharacterSymbolEquipmentDtoBody} from "./response/characterSymbolEquipmentDtoBody";
import {CharacterSetEffectDto} from "./dto/characterSetEffectDto";
import {CharacterSetEffectDtoBody} from "./response/characterSetEffectDtoBody";
import {CharacterBeautyEquipmentDto} from "./dto/characterBeautyEquipmentDto";
import {CharacterBeautyEquipmentDtoBody} from "./response/characterBeautyEquipmentDtoBody";
import {CharacterAndroidEquipmentDto} from "./dto/characterAndroidEquipmentDto";
import {CharacterAndroidEquipmentDtoBody} from "./response/characterAndroidEquipmentDtoBody";
import {CharacterPetEquipmentDto} from "./dto/characterPetEquipmentDto";
import {CharacterPetEquipmentDtoBody} from "./response/characterPetEquipmentDtoBody";
import {CharacterSkillDto} from "./dto/characterSkillDto";
import {CharacterSkillDtoBody} from "./response/characterSkillDtoBody";
import {CharacterLinkSkillDto} from "./dto/characterLinkSkillDto";
import {CharacterLinkSkillDtoBody} from "./response/characterLinkSkillDtoBody";
import {CharacterVMatrixDto} from "./dto/characterVMatrixDto";
import {CharacterVMatrixDtoBody} from "./response/characterVMatrixDtoBody";
import {CharacterHexaMatrixDto} from "./dto/characterHexaMatrixDto";
import {CharacterHexaMatrixDtoBody} from "./response/characterHexaMatrixDtoBody";
import {CharacterDojangDto} from "./dto/characterDojangDto";
import {CharacterDojangDtoBody} from "./response/characterDojangDtoBody";
import {CharacterHexaMatrixStatDto} from "./dto/characterHexaMatrixStatDto";
import {CharacterHexaMatrixStatDtoBody} from "./response/characterHexaMatrixStatDtoBody";

import axios, {AxiosError} from "axios";
import dayjs from "dayjs";
import timezone from "dayjs/plugin/timezone";
import utc from "dayjs/plugin/utc";
import xml2js from 'xml2js';
import {UnionDto} from "./dto/unionDto";
import {UnionDtoBody} from "./response/unionDtoBody";
import {UnionRaiderDto} from "./dto/unionRaiderDto";
import {UnionRaiderDtoBody} from "./response/unionRaiderDtoBody";
import {GuildDto} from "./dto/guildDto";
import {GuildDtoBody} from "./response/guildDtoBody";
import {GuildBasicDto} from "./dto/guildBasicDto";
import {GuildBasicDtoBody} from "./response/guildBasicDtoBody";
import {OverallRankingResponseDto} from "./dto/overallRankingResponseDto";
import {OverallRankingResponseDtoBody} from "./response/overallRankingResponseDtoBody";
import {UnionRankingResponseDto} from "./dto/unionRankingResponseDto";
import {UnionRankingResponseDtoBody} from "./response/unionRankingResponseDtoBody";
import {GuildRankingResponseDto} from "./dto/guildRankingResponseDto";
import {GuildRankingResponseDtoBody} from "./response/guildRankingResponseDtoBody";
import {DojangRankingResponseDto} from "./dto/dojangRankingResponseDto";
import {DojangRankingResponseDtoBody} from "./response/dojangRankingResponseDtoBody";
import {TheSeedRankingResponseDto} from "./dto/theSeedRankingResponseDto";
import {TheSeedRankingResponseDtoBody} from "./response/theSeedRankingResponseDtoBody";
import {AchievementRankingResponseDto} from "./dto/achievementRankingResponseDto";
import {AchievementRankingResponseDtoBody} from "./response/achievementRankingResponseDtoBody";

dayjs.extend(timezone);
dayjs.extend(utc);

/**
 * MapleStory OpenAPI client.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a>
 */
class MapleStoryApi {

    private readonly apiKey: string;

    private static BASE_URL: string = 'https://open.api.nexon.com/';

    private static kstOffset: number = 540;

    public timeout: number;

    public constructor(apiKey: string) {
        this.apiKey = apiKey;
        this.timeout = 5000;
    }

    //#region 캐릭터 정보 조회

    /**
     * 캐릭터 식별자(ocid)를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param characterName    캐릭터 명
     */
    public async getCharacter(characterName: string): Promise<CharacterDto> {

        try {
            const path = 'maplestory/v1/id';
            const response = await axios.get<CharacterDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    character_name: characterName
                }
            });

            return new CharacterDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 기본 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterBasicInfo(ocid: string, date: string): Promise<CharacterBasicDto> {
        try {
            const path = 'maplestory/v1/character/basic';
            const response = await axios.get<CharacterBasicDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterBasicDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 인기도 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterPopularity(ocid: string, date: string): Promise<CharacterPopularityDto> {
        try {
            const path = 'maplestory/v1/character/popularity';
            const response = await axios.get<CharacterPopularityDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterPopularityDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 종합 능력치 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterStat(ocid: string, date: string): Promise<CharacterStatDto> {
        try {
            const path = 'maplestory/v1/character/stat';
            const response = await axios.get<CharacterStatDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterStatDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 하이퍼스탯 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterHyperStat(ocid: string, date: string): Promise<CharacterHyperStatDto> {
        try {
            const path = 'maplestory/v1/character/hyper-stat';
            const response = await axios.get<CharacterHyperStatDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterHyperStatDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 성향 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterPropensity(ocid: string, date: string): Promise<CharacterPropensityDto> {
        try {
            const path = 'maplestory/v1/character/propensity';
            const response = await axios.get<CharacterPropensityDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterPropensityDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 어빌리티 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterAbility(ocid: string, date: string): Promise<CharacterAbilityDto> {
        try {
            const path = 'maplestory/v1/character/ability';
            const response = await axios.get<CharacterAbilityDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterAbilityDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterItemEquipment(ocid: string, date: string): Promise<CharacterItemEquipmentDto> {
        try {
            const path = 'maplestory/v1/character/item-equipment';
            const response = await axios.get<CharacterItemEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterItemEquipmentDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 장착한 캐시 장비 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterCashItemEquipment(ocid: string, date: string): Promise<CharacterCashItemEquipmentDto> {
        try {
            const path = 'maplestory/v1/character/cashitem-equipment';
            const response = await axios.get<CharacterCashItemEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterCashItemEquipmentDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 장착한 심볼 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterSymbolEquipment(ocid: string, date: string): Promise<CharacterSymbolEquipmentDto> {
        try {
            const path = 'maplestory/v1/character/symbol-equipment';
            const response = await axios.get<CharacterSymbolEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterSymbolEquipmentDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 적용받고 있는 세트 효과 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterSetEffect(ocid: string, date: string): Promise<CharacterSetEffectDto> {
        try {
            const path = 'maplestory/v1/character/set-effect';
            const response = await axios.get<CharacterSetEffectDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterSetEffectDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterBeautyEquipment(ocid: string, date: string): Promise<CharacterBeautyEquipmentDto> {
        try {
            const path = 'maplestory/v1/character/beauty-equipment';
            const response = await axios.get<CharacterBeautyEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterBeautyEquipmentDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 장착한 안드로이드 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterAndroidEquipment(ocid: string, date: string): Promise<CharacterAndroidEquipmentDto> {
        try {
            const path = 'maplestory/v1/character/android-equipment';
            const response = await axios.get<CharacterAndroidEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterAndroidEquipmentDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterPetEquipment(ocid: string, date: string): Promise<CharacterPetEquipmentDto> {
        try {
            const path = 'maplestory/v1/character/pet-equipment';
            const response = await axios.get<CharacterPetEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterPetEquipmentDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     * @param characterSkillGrade 조회하고자 하는 전직 차수
     *  - 0: 0차 스킬 및 제로 공용스킬
     *  - 1: 1차 스킬
     *  - 1.5: 1.5차 스킬
     *  - 2: 2차 스킬
     *  - 2.5: 2.5차 스킬
     *  - 3: 3차 스킬
     *  - 4: 4차 스킬 및 제로 알파/베타 스킬
     *  - hyperpassive: 하이퍼 패시브 스킬
     *  - hyperactive: 하이퍼 액티브 스킬
     *  - 5: 5차 스킬
     *  - 6: 6차 스킬
     */
    public async getCharacterSkill(ocid: string, date: string, characterSkillGrade: string): Promise<CharacterSkillDto> {
        try {
            const path = 'maplestory/v1/character/skill';
            const response = await axios.get<CharacterSkillDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date,
                    character_skill_grade: characterSkillGrade
                }
            });

            return new CharacterSkillDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 장착 링크 스킬 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterLinkSkill(ocid: string, date: string): Promise<CharacterLinkSkillDto> {
        try {
            const path = 'maplestory/v1/character/link-skill';
            const response = await axios.get<CharacterLinkSkillDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterLinkSkillDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterVMatrix(ocid: string, date: string): Promise<CharacterVMatrixDto> {
        try {
            const path = 'maplestory/v1/character/vmatrix';
            const response = await axios.get<CharacterVMatrixDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterVMatrixDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterHexaMatrix(ocid: string, date: string): Promise<CharacterHexaMatrixDto> {
        try {
            const path = 'maplestory/v1/character/hexamatrix';
            const response = await axios.get<CharacterHexaMatrixDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterHexaMatrixDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterHexaMatrixStat(ocid: string, date: string): Promise<CharacterHexaMatrixStatDto> {
        try {
            const path = 'maplestory/v1/character/hexamatrix-stat';
            const response = await axios.get<CharacterHexaMatrixStatDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterHexaMatrixStatDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getCharacterDojang(ocid: string, date: string): Promise<CharacterDojangDto> {
        try {
            const path = 'maplestory/v1/character/dojang';
            const response = await axios.get<CharacterDojangDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid: ocid,
                    date: date
                }
            });

            return new CharacterDojangDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    //#endregion

    //#region 유니온 정보 조회

    /**
     * 유니온 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getUnionInfo(ocid: string, date: string): Promise<UnionDto> {
        try {
            const path = 'maplestory/v1/user/union';
            const response = await axios.get<UnionDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid,
                    date,
                }
            });

            return new UnionDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 유니온 공격대 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getUnionRaiderInfo(ocid: string, date: string): Promise<UnionRaiderDto> {
        try {
            const path = 'maplestory/v1/user/union-raider';
            const response = await axios.get<UnionRaiderDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid,
                    date,
                }
            });

            return new UnionRaiderDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    //#endregion

    //#region 길드 정보 조회

    /**
     * 길드 식별자(oguild_id) 정보를 조회합니다.
     *
     * @param guildName 길드 명
     * @param worldName 월드 명
     */
    public async getGuild(guildName: string, worldName: string): Promise<GuildDto> {
        try {
            const path = 'maplestory/v1/guild/id';
            const response = await axios.get<GuildDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    guild_name: guildName,
                    world_name: worldName,
                },
            });

            return new GuildDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 길드 기본 정보를 조회합니다.
     *
     * @param guildId 길드 식별자
     * @param date 조회 기준일 (KST)
     */
    public async getGuildBasic(guildId: string, date: string): Promise<GuildBasicDto> {
        try {
            const path = 'maplestory/v1/guild/basic';
            const response = await axios.get<GuildBasicDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    oguild_id: guildId,
                    date: date,
                },
            });

            return new GuildBasicDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    //#endregion

    //#region 확률 정보 조회

    /**
     * 오늘 날짜의 큐브 사용 결과를 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public async getCubeResult(count: number): Promise<CubeHistoryResponseDto>;

    /**
     * 지목한 날짜의 큐브 사용 결과를 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCubeResult(count: number, dateOptions: DateOptions): Promise<CubeHistoryResponseDto>;

    /**
     * 큐브 사용 결과를 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public async getCubeResult(count: number, cursor: string): Promise<CubeHistoryResponseDto>;

    public async getCubeResult(count: number, parameter?: DateOptions | string): Promise<CubeHistoryResponseDto> {

        const query: CubeApiQuery = {
            count,
        };

        if (typeof parameter === 'string') {
            query.cursor = parameter;
        } else if (typeof parameter === 'object') {
            const {year, month, day} = parameter;

            if (year <= 2022 && month <= 11 && day < 25) {
                throw new Error('You can only retrieve data after 2022-11-25.');
            }

            const date = dayjs(`${year}-${month}-${day}`).utcOffset(MapleStoryApi.kstOffset);
            query.date_kst = date.format('YYYYMMDD')
        } else {
            const now = dayjs().utcOffset(MapleStoryApi.kstOffset);
            query.date_kst = now.format('YYYYMMDD');
        }

        try {
            const path = 'maplestory/v1/history/cube';
            const response = await axios.get<CubeHistoryResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
            });

            return new CubeHistoryResponseDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    //#endregion

    //#region 랭킹 정보 조회

    /**
     * 종합 랭킹 정보를 조회합니다.
     *
     * @param date 조회 기준일 (KST)
     * @param worldName 월드 명
     * - 스카니아
     * - 베라
     * - 루나
     * - 제니스
     * - 크로아
     * - 유니온
     * - 엘리시움
     * - 이노시스
     * - 레드
     * - 오로라
     * - 아케인
     * - 노바
     * - 리부트
     * - 리부트2
     * - 버닝
     * - 버닝2
     * - 버닝3
     * @param worldType 월드 타입
     * - 0: 일반
     * - 1: 리부트
     * @param jobClass 직업 및 전직
     * - 초보자-전체 전직
     * - 전사-전체 전직
     * - 전사-검사
     * - 전사-파이터
     * - 전사-페이지
     * - 전사-스피어맨
     * - 전사-크루세이더
     * - 전사-나이트
     * - 전사-버서커
     * - 전사-히어로
     * - 전사-팔라딘
     * - 전사-다크나이트
     * - 마법사-전체 전직
     * - 마법사-매지션
     * - 마법사-위자드(불,독)
     * - 마법사-위자드(썬,콜)
     * - 마법사-클레릭
     * - 마법사-메이지(불,독)
     * - 마법사-메이지(썬,콜)
     * - 마법사-프리스트
     * - 마법사-아크메이지(불,독)
     * - 마법사-아크메이지(썬,콜)
     * - 마법사-비숍
     * - 궁수-전체 전직
     * - 궁수-아처
     * - 궁수-헌터
     * - 궁수-사수
     * - 궁수-레인저
     * - 궁수-저격수
     * - 궁수-보우마스터
     * - 궁수-신궁
     * - 궁수-아처(패스파인더)
     * - 궁수-에인션트아처
     * - 궁수-체이서
     * - 궁수-패스파인더
     * - 도적-전체 전직
     * - 도적-로그
     * - 도적-어쌔신
     * - 도적-시프
     * - 도적-허밋
     * - 도적-시프마스터
     * - 도적-나이트로드
     * - 도적-섀도어
     * - 도적-세미듀어러
     * - 도적-듀어러
     * - 도적-듀얼마스터
     * - 도적-슬래셔
     * - 도적-듀얼블레이더
     * - 해적-전체 전직
     * - 해적-해적
     * - 해적-인파이터
     * - 해적-건슬링거
     * - 해적-캐논슈터
     * - 해적-버커니어
     * - 해적-발키리
     * - 해적-캐논블래스터
     * - 해적-바이퍼
     * - 해적-캡틴
     * - 해적-캐논마스터
     * - 기사단-전체 전직
     * - 기사단-노블레스
     * - 기사단-소울마스터
     * - 기사단-플레임위자드
     * - 기사단-윈드브레이커
     * - 기사단-나이트워커
     * - 기사단-스트라이커
     * - 기사단-미하일
     * - 아란-전체 전직
     * - 에반-전체 전직
     * - 레지스탕스-전체 전직
     * - 레지스탕스-시티즌
     * - 레지스탕스-배틀메이지
     * - 레지스탕스-와일드헌터
     * - 레지스탕스-메카닉
     * - 레지스탕스-데몬슬레이어
     * - 레지스탕스-데몬어벤져
     * - 레지스탕스-제논
     * - 레지스탕스-블래스터
     * - 메르세데스-전체 전직
     * - 팬텀-전체 전직
     * - 루미너스-전체 전직
     * - 카이저-전체 전직
     * - 엔젤릭버스터-전체 전직
     * - 초월자-전체 전직
     * - 초월자-제로
     * - 은월-전체 전직
     * - 프렌즈 월드-전체 전직
     * - 프렌즈 월드-키네시스
     * - 카데나-전체 전직
     * - 일리움-전체 전직
     * - 아크-전체 전직
     * - 호영-전체 전직
     * - 아델-전체 전직
     * - 카인-전체 전직
     * - 라라-전체 전직
     * - 칼리-전체 전직
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public async getOverallRanking(
        date: string,
        worldName: string,
        worldType: number,
        jobClass: string,
        ocid: string,
        page: number
    ): Promise<OverallRankingResponseDto> {
        try {
            const path = 'maplestory/v1/ranking/overall';
            const response = await axios.get<OverallRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    date,
                    world_name: worldName,
                    world_type: worldType,
                    class: jobClass,
                    ocid,
                    page,
                },
            });

            return new OverallRankingResponseDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 유니온 랭킹 정보를 조회합니다.
     *
     * @param date 조회 기준일 (KST)
     * @param worldName 월드 명
     * - 스카니아
     * - 베라
     * - 루나
     * - 제니스
     * - 크로아
     * - 유니온
     * - 엘리시움
     * - 이노시스
     * - 레드
     * - 오로라
     * - 아케인
     * - 노바
     * - 리부트
     * - 리부트2
     * - 버닝
     * - 버닝2
     * - 버닝3
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public async getUnionRanking(date: string, worldName: string, ocid: string, page: number): Promise<UnionRankingResponseDto> {
        try {
            const path = 'maplestory/v1/ranking/union';
            const response = await axios.get<UnionRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    date,
                    world_name: worldName,
                    ocid,
                    page,
                },
            });

            return new UnionRankingResponseDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 길드 랭킹 정보를 조회합니다.
     *
     * @param date 조회 기준일 (KST)
     * @param worldName 월드 명
     * - 스카니아
     * - 베라
     * - 루나
     * - 제니스
     * - 크로아
     * - 유니온
     * - 엘리시움
     * - 이노시스
     * - 레드
     * - 오로라
     * - 아케인
     * - 노바
     * - 리부트
     * - 리부트2
     * - 버닝
     * - 버닝2
     * - 버닝3
     * @param rankingType 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     * @param guildName 길드 명
     * @param page 페이지 번호
     */
    public async getGuildRanking(date: string, worldName: string, rankingType: number, guildName: string, page: number): Promise<GuildRankingResponseDto> {
        try {
            const path = 'maplestory/v1/ranking/guild';
            const response = await axios.get<GuildRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    date,
                    world_name: worldName,
                    ranking_type: rankingType,
                    guild_name: guildName,
                    page,
                },
            });

            return new GuildRankingResponseDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 무릉도장 랭킹 정보를 조회합니다.
     *
     * @param date 조회 기준일 (KST)
     * @param worldName 월드 명
     * - 스카니아
     * - 베라
     * - 루나
     * - 제니스
     * - 크로아
     * - 유니온
     * - 엘리시움
     * - 이노시스
     * - 레드
     * - 오로라
     * - 아케인
     * - 노바
     * - 리부트
     * - 리부트2
     * - 버닝
     * - 버닝2
     * - 버닝3
     * @param difficulty 구간 (0:일반, 1:통달)
     * @param className 직업 및 전직
     * - 초보자-전체 전직
     * - 전사-전체 전직
     * - 전사-검사
     * - 전사-파이터
     * - 전사-페이지
     * - 전사-스피어맨
     * - 전사-크루세이더
     * - 전사-나이트
     * - 전사-버서커
     * - 전사-히어로
     * - 전사-팔라딘
     * - 전사-다크나이트
     * - 마법사-전체 전직
     * - 마법사-매지션
     * - 마법사-위자드(불,독)
     * - 마법사-위자드(썬,콜)
     * - 마법사-클레릭
     * - 마법사-메이지(불,독)
     * - 마법사-메이지(썬,콜)
     * - 마법사-프리스트
     * - 마법사-아크메이지(불,독)
     * - 마법사-아크메이지(썬,콜)
     * - 마법사-비숍
     * - 궁수-전체 전직
     * - 궁수-아처
     * - 궁수-헌터
     * - 궁수-사수
     * - 궁수-레인저
     * - 궁수-저격수
     * - 궁수-보우마스터
     * - 궁수-신궁
     * - 궁수-아처(패스파인더)
     * - 궁수-에인션트아처
     * - 궁수-체이서
     * - 궁수-패스파인더
     * - 도적-전체 전직
     * - 도적-로그
     * - 도적-어쌔신
     * - 도적-시프
     * - 도적-허밋
     * - 도적-시프마스터
     * - 도적-나이트로드
     * - 도적-섀도어
     * - 도적-세미듀어러
     * - 도적-듀어러
     * - 도적-듀얼마스터
     * - 도적-슬래셔
     * - 도적-듀얼블레이더
     * - 해적-전체 전직
     * - 해적-해적
     * - 해적-인파이터
     * - 해적-건슬링거
     * - 해적-캐논슈터
     * - 해적-버커니어
     * - 해적-발키리
     * - 해적-캐논블래스터
     * - 해적-바이퍼
     * - 해적-캡틴
     * - 해적-캐논마스터
     * - 기사단-전체 전직
     * - 기사단-노블레스
     * - 기사단-소울마스터
     * - 기사단-플레임위자드
     * - 기사단-윈드브레이커
     * - 기사단-나이트워커
     * - 기사단-스트라이커
     * - 기사단-미하일
     * - 아란-전체 전직
     * - 에반-전체 전직
     * - 레지스탕스-전체 전직
     * - 레지스탕스-시티즌
     * - 레지스탕스-배틀메이지
     * - 레지스탕스-와일드헌터
     * - 레지스탕스-메카닉
     * - 레지스탕스-데몬슬레이어
     * - 레지스탕스-데몬어벤져
     * - 레지스탕스-제논
     * - 레지스탕스-블래스터
     * - 메르세데스-전체 전직
     * - 팬텀-전체 전직
     * - 루미너스-전체 전직
     * - 카이저-전체 전직
     * - 엔젤릭버스터-전체 전직
     * - 초월자-전체 전직
     * - 초월자-제로
     * - 은월-전체 전직
     * - 프렌즈 월드-전체 전직
     * - 프렌즈 월드-키네시스
     * - 카데나-전체 전직
     * - 일리움-전체 전직
     * - 아크-전체 전직
     * - 호영-전체 전직
     * - 아델-전체 전직
     * - 카인-전체 전직
     * - 라라-전체 전직
     * - 칼리-전체 전직
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public async getDojangRanking(date: string, worldName: string, difficulty: number, className: string, ocid: string, page: number): Promise<DojangRankingResponseDto> {
        try {
            const path = 'maplestory/v1/ranking/dojang';
            const response = await axios.get<DojangRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    date,
                    world_name: worldName,
                    difficulty,
                    class_name: className,
                    ocid,
                    page,
                },
            });

            return new DojangRankingResponseDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 더 시드 랭킹 정보를 조회합니다.
     *
     * @param date 조회 기준일 (KST)
     * @param worldName 월드 명
     * - 스카니아
     * - 베라
     * - 루나
     * - 제니스
     * - 크로아
     * - 유니온
     * - 엘리시움
     * - 이노시스
     * - 레드
     * - 오로라
     * - 아케인
     * - 노바
     * - 리부트
     * - 리부트2
     * - 버닝
     * - 버닝2
     * - 버닝3
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public async getSeedRanking(date: string, worldName: string, ocid: string, page: number): Promise<TheSeedRankingResponseDto> {
        try {
            const path = 'maplestory/v1/ranking/theseed';
            const response = await axios.get<TheSeedRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    date,
                    world_name: worldName,
                    ocid,
                    page,
                },
            });

            return new TheSeedRankingResponseDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    /**
     * 업적 랭킹 정보를 조회합니다.
     *
     * @param date 조회 기준일 (KST)
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public async getAchievementRanking(date: string, ocid: string, page: number): Promise<AchievementRankingResponseDto> {
        try {
            const path = 'maplestory/v1/ranking/achievement';
            const response = await axios.get<AchievementRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    date,
                    ocid,
                    page,
                },
            });

            return new AchievementRankingResponseDto(response.data);
        } catch (e: any) {
            if (e instanceof AxiosError) {
                const errorBody = (e as AxiosError<MapleStoryErrorBody>).response!.data;

                throw new MapleStoryApiError(errorBody);
            }

            throw e;
        }
    }

    //#endregion

    /**
     * 서버 점검 정보를 조회합니다.
     */
    public async getInspectionInfo(): Promise<InspectionInfoDto> {

        const xmlBuilder = new xml2js.Builder();
        const soapEnvelop = {
            'soap:Envelope': {
                $: {
                    'xmlns:xsi': 'http://www.w3.org/2001/XMLSchema-instance',
                    'xmlns:xsd': 'http://www.w3.org/2001/XMLSchema',
                    'xmlns:soap': 'http://schemas.xmlsoap.org/soap/envelope/'
                },
                'soap:Body': {
                    'GetInspectionInfo': {
                        $: {
                            'xmlns': 'https://api.maplestory.nexon.com/soap/'
                        }
                    }
                }
            }
        };

        const baseUrl = 'https://api.maplestory.nexon.com/';
        const path = 'soap/maplestory.asmx'
        const headers = {
            'SOAPAction': 'https://api.maplestory.nexon.com/soap/GetInspectionInfo',
            'Content-Type': 'text/xml; charset=utf-8'
        };
        const body = xmlBuilder.buildObject(soapEnvelop);

        const response = await axios.post<string>(path, body, {
            baseURL: baseUrl,
            timeout: this.timeout,
            headers,
        });

        const xml = await xml2js.parseStringPromise(response.data) as InspectionInfoSoapBody;

        return new InspectionInfoDto(xml);
    }

    private buildHeaders(): { [key: string]: string } {
        return {
            'x-nxopen-api-key': this.apiKey
        }
    }
}

type DateOptions = {
    year: number;
    month: number;
    day: number;
}

type CubeApiQuery = {
    count: number;
    date_kst?: string;
    cursor?: string;
}

type MapleStoryErrorBody = {
    error: {
        name: string;
        message: string;
    }
}

export {MapleStoryApi, MapleStoryErrorBody}
