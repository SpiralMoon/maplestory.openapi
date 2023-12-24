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
	 * @param dateOptions 조회 기준일 (KST)
	 */
	public async getCharacterBasic(ocid: string, dateOptions?: DateOptions): Promise<CharacterBasicDto> {

		const query: CharacterApiQuery = {
			ocid: ocid,
			date: MapleStoryApi.toDateString({
				year: 2023,
				month: 12,
				day: 21
			}, dateOptions)
		};

		try {
			const path = 'maplestory/v1/character/basic';
			const response = await axios.get<CharacterBasicDtoBody>(path, {
				baseURL: MapleStoryApi.BASE_URL,
				timeout: this.timeout,
				headers: this.buildHeaders(),
				params: query
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
     * 기본 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param dateOptions 조회 기준일 (KST)
     * @deprecated since 2.2 ver
     */
    public getCharacterBasicInfo(ocid: string, dateOptions?: DateOptions): Promise<CharacterBasicDto> {
        return this.getCharacterBasic(ocid, dateOptions);
    }

    /**
     * 인기도 정보를 조회합니다.
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterPopularity(ocid: string, dateOptions?: DateOptions): Promise<CharacterPopularityDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/popularity';
            const response = await axios.get<CharacterPopularityDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterStat(ocid: string, dateOptions?: DateOptions): Promise<CharacterStatDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/stat';
            const response = await axios.get<CharacterStatDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterHyperStat(ocid: string, dateOptions?: DateOptions): Promise<CharacterHyperStatDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/hyper-stat';
            const response = await axios.get<CharacterHyperStatDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterPropensity(ocid: string, dateOptions?: DateOptions): Promise<CharacterPropensityDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/propensity';
            const response = await axios.get<CharacterPropensityDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterAbility(ocid: string, dateOptions?: DateOptions): Promise<CharacterAbilityDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/ability';
            const response = await axios.get<CharacterAbilityDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterItemEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterItemEquipmentDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/item-equipment';
            const response = await axios.get<CharacterItemEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterCashItemEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterCashItemEquipmentDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/cashitem-equipment';
            const response = await axios.get<CharacterCashItemEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterSymbolEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterSymbolEquipmentDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/symbol-equipment';
            const response = await axios.get<CharacterSymbolEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterSetEffect(ocid: string, dateOptions?: DateOptions): Promise<CharacterSetEffectDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/set-effect';
            const response = await axios.get<CharacterSetEffectDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterBeautyEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterBeautyEquipmentDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/beauty-equipment';
            const response = await axios.get<CharacterBeautyEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterAndroidEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterAndroidEquipmentDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/android-equipment';
            const response = await axios.get<CharacterAndroidEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterPetEquipment(ocid: string, dateOptions?: DateOptions): Promise<CharacterPetEquipmentDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/pet-equipment';
            const response = await axios.get<CharacterPetEquipmentDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     *  @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterSkill(ocid: string, characterSkillGrade: string, dateOptions?: DateOptions): Promise<CharacterSkillDto> {

        const query: CharacterSkillApiQuery = {
            ocid: ocid,
            character_skill_grade: '0',
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/skill';
            const response = await axios.get<CharacterSkillDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterLinkSkill(ocid: string, dateOptions?: DateOptions): Promise<CharacterLinkSkillDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/link-skill';
            const response = await axios.get<CharacterLinkSkillDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterVMatrix(ocid: string, dateOptions?: DateOptions): Promise<CharacterVMatrixDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/vmatrix';
            const response = await axios.get<CharacterVMatrixDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterHexaMatrix(ocid: string, dateOptions?: DateOptions): Promise<CharacterHexaMatrixDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/hexamatrix';
            const response = await axios.get<CharacterHexaMatrixDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterHexaMatrixStat(ocid: string, dateOptions?: DateOptions): Promise<CharacterHexaMatrixStatDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/hexamatrix-stat';
            const response = await axios.get<CharacterHexaMatrixStatDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCharacterDojang(ocid: string, dateOptions?: DateOptions): Promise<CharacterDojangDto> {

        const query: CharacterApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOptions)
        };

        try {
            const path = 'maplestory/v1/character/dojang';
            const response = await axios.get<CharacterDojangDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param dateOption 조회 기준일 (KST)
     */
    public async getUnionInfo(ocid: string, dateOption?: DateOptions): Promise<UnionDto> {

        const query: UnionApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOption)
        };

        try {
            const path = 'maplestory/v1/user/union';
            const response = await axios.get<UnionDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param ocid 캐릭터 식별자
     * @param dateOption 조회 기준일 (KST)
     */
    public async getUnionRaiderInfo(ocid: string, dateOption?: DateOptions): Promise<UnionRaiderDto> {

        const query: UnionApiQuery = {
            ocid: ocid,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21
            }, dateOption)
        };

        try {
            const path = 'maplestory/v1/user/union-raider';
            const response = await axios.get<UnionRaiderDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: {
                    ocid,
                    date: dateOption,
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
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다.
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
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
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.
     * - 오전 1시부터 전일 데이터 조회가 가능합니다.
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param guildId 길드 식별자
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getGuildBasic(guildId: string, dateOptions?: DateOptions): Promise<GuildBasicDto> {

        const query: GuildApiQuery = {
            oguild_id: guildId,
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 21,
            }, dateOptions),
        };

        try {
            const path = 'maplestory/v1/guild/basic';
            const response = await axios.get<GuildBasicDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query,
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
     * 오늘 날짜의 큐브 사용 결과를 조회합니다.
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public async getCubeHistory(count: number): Promise<CubeHistoryResponseDto>;

    /**
     * 지목한 날짜의 큐브 사용 결과를 조회합니다.
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getCubeHistory(count: number, dateOptions: DateOptions): Promise<CubeHistoryResponseDto>;

    /**
     * 큐브 사용 결과를 조회합니다.
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public async getCubeHistory(count: number, cursor: string): Promise<CubeHistoryResponseDto>;

    public async getCubeHistory(count: number, parameter?: DateOptions | string): Promise<CubeHistoryResponseDto> {

        const query: CubeApiQuery = {
            count,
        };

        if (typeof parameter === 'string') {
            query.cursor = parameter;
        } else if (typeof parameter === 'object') {
            query.date = MapleStoryApi.toDateString({
                year: 2022,
                month: 11,
                day: 25
            }, parameter);
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
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param filterOptions 검색 기준
     * @param dateOptions 조회 기준일 (KST).
     *
     */
    public async getOverallRanking(
        filterOptions?: OverallRankingApiFilterOptions,
        dateOptions?: DateOptions,
    ): Promise<OverallRankingResponseDto> {

        const query: OverallRankingApiQuery = {
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 22,
            }, dateOptions),
        }

        if (filterOptions) {

            const {worldName, worldType, characterClass, ocid, page} = filterOptions;

            query.world_name = worldName;
            query.world_type = worldType;
            query.class = characterClass;
            query.ocid = ocid;
            query.page = page;
        }

        try {
            const path = 'maplestory/v1/ranking/overall';
            const response = await axios.get<OverallRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param filterOptions 검색 기준
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getUnionRanking(filterOptions?: UnionRankingApiFilterOptions, dateOptions?: DateOptions): Promise<UnionRankingResponseDto> {

        const query: UnionRankingApiQuery = {
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 22
            }, dateOptions)
        };

        if (filterOptions) {

            const {worldName, ocid, page} = filterOptions;

            query.world_name = worldName;
            query.ocid = ocid;
            query.page = page;
        }

        try {
            const path = 'maplestory/v1/ranking/union';
            const response = await axios.get<UnionRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query,
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
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param filterOptions 검색 기준
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getGuildRanking(filterOptions?: GuildRankingApiFilterOptions, dateOptions?: DateOptions): Promise<GuildRankingResponseDto> {

        const query: GuildRankingApiQuery = {
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 22
            }, dateOptions),
            ranking_type: 0,
        };

        if (filterOptions) {

            const {worldName, rankingType, ocid, page} = filterOptions;

            query.world_name = worldName;
            query.ranking_type = rankingType;
            query.ocid = ocid;
            query.page = page;
        }

        try {
            const path = 'maplestory/v1/ranking/guild';
            const response = await axios.get<GuildRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query,
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
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param filterOptions 검색 기준
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getDojangRanking(filterOptions?: DojangRankingApiFilterOptions, dateOptions?: DateOptions): Promise<DojangRankingResponseDto> {

        const query: DojangRankingApiQuery = {
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 22
            }, dateOptions),
            difficulty: 0,
        };

        if (filterOptions) {

            const {worldName, difficulty, characterClass, ocid, page} = filterOptions;

            query.world_name = worldName;
            query.difficulty = difficulty;
            query.class = characterClass;
            query.ocid = ocid;
            query.page = page;
        }

        try {
            const path = 'maplestory/v1/ranking/dojang';
            const response = await axios.get<DojangRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param filterOptions 검색 기준
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getSeedRanking(filterOptions?: TheSeedRankingApiFilterOptions, dateOptions?: DateOptions): Promise<TheSeedRankingResponseDto> {

        const query: TheSeedRankingApiQuery = {
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 22
            }, dateOptions),
        };

        if (filterOptions) {

            const {worldName, ocid, page} = filterOptions;

            query.world_name = worldName;
            query.ocid = ocid;
            query.page = page;
        }

        try {
            const path = 'maplestory/v1/ranking/theseed';
            const response = await axios.get<TheSeedRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query,
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
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.
     *
     * @param filterOptions 검색 기준
     * @param dateOptions 조회 기준일 (KST)
     */
    public async getAchievementRanking(filterOptions?: AchievementRankingApiFilterOptions, dateOptions?: DateOptions): Promise<AchievementRankingResponseDto> {

        const query: AchievementRankingApiQuery = {
            date: MapleStoryApi.toDateString({
                year: 2023,
                month: 12,
                day: 22
            }, dateOptions),
        };

        if (filterOptions) {

            const {ocid, page} = filterOptions;

            query.ocid = ocid;
            query.page = page;
        }

        try {
            const path = 'maplestory/v1/ranking/achievement';
            const response = await axios.get<AchievementRankingResponseDtoBody>(path, {
                baseURL: MapleStoryApi.BASE_URL,
                timeout: this.timeout,
                headers: this.buildHeaders(),
                params: query
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

    private static toDateString(minDateOptions: DateOptions, dateOptions?: DateOptions): string | never {

        let date;

        if (dateOptions) {
            const {year: minYear, month: minMonth, day: minDay} = minDateOptions;
            const {year, month, day} = dateOptions;

            if (year < minYear || (year === minYear && month < minMonth) || (year === minYear && month === minMonth && day < minDay)) {
                throw new Error(`You can only retrieve data after ${minYear}-${minMonth}-${minDay}.`);
            }

            date = dayjs(`${year}-${month}-${day}`).utcOffset(MapleStoryApi.kstOffset);
        } else {
            date = dayjs().utcOffset(MapleStoryApi.kstOffset);
        }

        return date.format('YYYY-MM-DD');
    }
}

type OverallRankingApiFilterOptions = {

    /**
     * 월드 명
     *
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
     */
    worldName?: string;

    /**
     * 월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, world_name 입력 시 미 반영)
     */
    worldType?: number;

    /**
     * 직업 및 전직
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
     */
    characterClass?: string;

    /**
     * 캐릭터 식별자
     */
    ocid?: string;

    /**
     * 페이지 번호
     */
    page?: number;
}

type UnionRankingApiFilterOptions = {

    /**
     * 월드 명
     *
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
     */
    worldName?: string;

    /**
     * 캐릭터 식별자
     */
    ocid?: string;

    /**
     * 페이지 번호
     */
    page?: number;
};

type GuildRankingApiFilterOptions = {

    /**
     * 월드 명
     *
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
     */
    worldName?: string;

    /**
     * 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     */
    rankingType: number;

    /**
     * 캐릭터 식별자
     */
    ocid?: string;

    /**
     * 페이지 번호
     */
    page?: number;
};

type DojangRankingApiFilterOptions = {

    /**
     * 월드 명
     *
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
     */
    worldName?: string;

    /**
     * 구간 (0:일반, 1:통달)
     */
    difficulty: number;

    /**
     * 직업 및 전직
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
     */
    characterClass?: string;

    /**
     * 캐릭터 식별자
     */
    ocid?: string;

    /**
     * 페이지 번호
     */
    page?: number;
};

type TheSeedRankingApiFilterOptions = {

    /**
     * 월드 명
     *
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
     */
    worldName?: string;

    /**
     * 캐릭터 식별자
     */
    ocid?: string;

    /**
     * 페이지 번호
     */
    page?: number;
};

type AchievementRankingApiFilterOptions = {

    /**
     * 캐릭터 식별자
     */
    ocid?: string;

    /**
     * 페이지 번호
     */
    page?: number;
};

type DateOptions = {
    year: number;
    month: number;
    day: number;
}

type CharacterApiQuery = {
    ocid: string;
    date: string;
}

type CharacterSkillApiQuery = {
    ocid: string;
    date: string;
    character_skill_grade: string;
}

type CubeApiQuery = {
    count: number;
    date?: string;
    cursor?: string;
}

type UnionApiQuery = {
    ocid: string;
    date: string;
}

type GuildApiQuery = {
    oguild_id: string;
    date: string;
}

type OverallRankingApiQuery = {
    date: string;
    world_name?: string;
    world_type?: number;
    class?: string;
    ocid?: string;
    page?: number;
};

type UnionRankingApiQuery = {
    date: string;
    world_name?: string;
    ocid?: string;
    page?: number;
};

type GuildRankingApiQuery = {
    date: string;
    world_name?: string;
    ranking_type: number;
    ocid?: string;
    page?: number;
};

type DojangRankingApiQuery = {
    date: string;
    world_name?: string;
    difficulty: number;
    class?: string;
    ocid?: string;
    page?: number;
};

type TheSeedRankingApiQuery = {
    date: string;
    world_name?: string;
    ocid?: string;
    page?: number;
};

type AchievementRankingApiQuery = {
    date: string;
    ocid?: string;
    page?: number;
};

type MapleStoryErrorBody = {
    error: {
        name: string;
        message: string;
    }
}

export {MapleStoryApi, MapleStoryErrorBody}
