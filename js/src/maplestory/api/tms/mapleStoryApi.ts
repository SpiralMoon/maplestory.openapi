import axios from 'axios';
import { Buffer } from 'buffer/'; // polyfill of Buffer for browser

import { CharacterDto } from './dto/character/character';
import { CharacterAbilityDto } from './dto/character/characterAbility';
import { CharacterAndroidEquipmentDto } from './dto/character/characterAndroidEquipment';
import { CharacterBasicDto } from './dto/character/characterBasic';
import { CharacterBeautyEquipmentDto } from './dto/character/characterBeautyEquipment';
import { CharacterCashItemEquipmentDto } from './dto/character/characterCashItemEquipment';
import { CharacterDojangDto } from './dto/character/characterDojang';
import { CharacterHexaMatrixDto } from './dto/character/characterHexaMatrix';
import { CharacterHexaMatrixStatDto } from './dto/character/characterHexaMatrixStat';
import { CharacterHyperStatDto } from './dto/character/characterHyperStat';
import { CharacterImageDto } from './dto/character/characterImage';
import { CharacterItemEquipmentDto } from './dto/character/characterItemEquipment';
import { CharacterLinkSkillDto } from './dto/character/characterLinkSkill';
import { CharacterPetEquipmentDto } from './dto/character/characterPetEquipment';
import { CharacterPopularityDto } from './dto/character/characterPopularity';
import { CharacterPropensityDto } from './dto/character/characterPropensity';
import { CharacterSetEffectDto } from './dto/character/characterSetEffect';
import { CharacterSkillDto } from './dto/character/characterSkill';
import { CharacterStatDto } from './dto/character/characterStat';
import { CharacterSymbolEquipmentDto } from './dto/character/characterSymbolEquipment';
import { CharacterVMatrixDto } from './dto/character/characterVMatrix';
import { GuildDto } from './dto/guild/guild';
import { GuildBasicDto } from './dto/guild/guildBasic';
import { UnionDto } from './dto/union/union';
import { UnionArtifactDto } from './dto/union/unionArtifact';
import { UnionChampionDto } from './dto/union/unionChampion';
import { UnionRaiderDto } from './dto/union/unionRaider';
import { CharacterAbilityBody } from './response/character/characterAbilityBody';
import { CharacterAndroidEquipmentBody } from './response/character/characterAndroidEquipmentBody';
import { CharacterBasicBody } from './response/character/characterBasicBody';
import { CharacterBeautyEquipmentBody } from './response/character/characterBeautyEquipmentBody';
import { CharacterBody } from './response/character/characterBody';
import { CharacterCashItemEquipmentBody } from './response/character/characterCashItemEquipmentBody';
import { CharacterDojangBody } from './response/character/characterDojangBody';
import { CharacterHexaMatrixBody } from './response/character/characterHexaMatrixBody';
import { CharacterHexaMatrixStatBody } from './response/character/characterHexaMatrixStatBody';
import { CharacterHyperStatBody } from './response/character/characterHyperStatBody';
import { CharacterItemEquipmentBody } from './response/character/characterItemEquipmentBody';
import { CharacterLinkSkillBody } from './response/character/characterLinkSkillBody';
import { CharacterPetEquipmentBody } from './response/character/characterPetEquipmentBody';
import { CharacterPopularityBody } from './response/character/characterPopularityBody';
import { CharacterPropensityBody } from './response/character/characterPropensityBody';
import { CharacterSetEffectBody } from './response/character/characterSetEffectBody';
import { CharacterSkillBody } from './response/character/characterSkillBody';
import { CharacterStatBody } from './response/character/characterStatBody';
import { CharacterSymbolEquipmentBody } from './response/character/characterSymbolEquipmentBody';
import { CharacterVMatrixBody } from './response/character/characterVMatrixBody';
import { GuildBasicBody } from './response/guild/guildBasicBody';
import { GuildBody } from './response/guild/guildBody';
import { UnionArtifactBody } from './response/union/unionArtifactBody';
import { UnionBody } from './response/union/unionBody';
import { UnionChampionBody } from './response/union/unionChampionBody';
import { UnionRaiderBody } from './response/union/unionRaiderBody';
import {
  CharacterImageAction,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
} from '../common/enum/characterImage';
import { DateOptions } from '../common/mapleStoryApi';
import * as base from '../common/mapleStoryApi';
import { removeQuery } from '../common/lib'

/**
 * MapleStory OpenAPI client for TMS.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestorytw">MapleStory API</a>
 */
export class MapleStoryApi extends base.MapleStoryApi {

  protected override subUrl: string = 'maplestorytw';

  protected override timezoneOffset: number = 480;

  public constructor(apiKey: string) {
    super(apiKey);
  }

  //#region 檢視角色資訊

  /**
   * 檢視角色辨識器 (OCID)。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param characterName 角色名稱
   */
  public override async getCharacter(characterName: string): Promise<CharacterDto> {
    const path = `${this.subUrl}/v1/id`;
    const { data } = await this.client.get<CharacterBody>(path, {
      params: {
        character_name: characterName,
      },
    });

    return new CharacterDto(data);
  }

  /**
   * 檢視基本資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterBasic(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterBasicDto | null> {
    const path = `${this.subUrl}/v1/character/basic`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterBasicBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterBasicDto(data);
  }

  /**
   * 檢視角色外型圖片資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param imageOptions 圖像選項
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterImage(
    ocid: string,
    imageOptions?: CharacterImageOptions,
    dateOptions?: DateOptions,
  ): Promise<CharacterImageDto | null> {
    const basic = await this.getCharacterBasic(ocid, dateOptions);

    if (!basic) {
      return null;
    }

    const { date, characterImage } = basic;
    const action = imageOptions?.action ?? CharacterImageAction.Stand1;
    const emotion = imageOptions?.emotion ?? CharacterImageEmotion.Default;
    const wmotion = imageOptions?.wmotion ?? CharacterImageWeaponMotion.Default;
    const actionFrame = imageOptions?.actionFrame ?? 0;
    const emotionFrame = imageOptions?.emotionFrame ?? 0;
    const width = 96;
    const height = 96;
    const x = imageOptions?.x ?? null;
    const y = imageOptions?.y ?? null;

    const path = removeQuery(characterImage);
    const query = {
      action: `${action}.${actionFrame}`,
      emotion: `${emotion}.${emotionFrame}`,
      wmotion,
      width,
      height,
      x,
      y,
    };

    const urlImageToBase64 = async (
      path: string,
      query?: object,
    ): Promise<string> => {
      const { data, headers } = await axios.get<string>(path, {
        params: query,
        responseType: 'arraybuffer',
      });
      const base64 = Buffer.from(data, 'binary').toString('base64');
      const mimeType = headers['content-type'];

      return `data:${mimeType};base64,${base64}`;
    };

    const [originImage, image] = await Promise.all([
      urlImageToBase64(path),
      urlImageToBase64(path, query),
    ]);

    return new CharacterImageDto({
      date,
      originUrl: path,
      originImage,
      image,
      action,
      emotion,
      wmotion,
      actionFrame,
      emotionFrame,
      width,
      height,
      x,
      y,
    });
  }

  /**
   * 檢視名聲資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterPopularity(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPopularityDto | null> {
    const path = `${this.subUrl}/v1/character/popularity`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPopularityBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterPopularityDto(data);
  }

  /**
   * 檢視綜合能力值資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterStatDto | null> {
    const path = `${this.subUrl}/v1/character/stat`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterStatBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterStatDto(data);
  }

  /**
   * 檢視極限屬性資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterHyperStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHyperStatDto | null> {
    const path = `${this.subUrl}/v1/character/hyper-stat`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHyperStatBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterHyperStatDto(data);
  }

  /**
   * 檢視性向資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterPropensity(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPropensityDto | null> {
    const path = `${this.subUrl}/v1/character/propensity`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPropensityBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterPropensityDto(data);
  }

  /**
   * 檢視能力資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterAbility(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterAbilityDto | null> {
    const path = `${this.subUrl}/v1/character/ability`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterAbilityBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterAbilityDto(data);
  }

  /**
   * 檢視已裝備道具資訊 (不含現金道具)。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterItemEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterItemEquipmentDto | null> {
    const path = `${this.subUrl}/v1/character/item-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterItemEquipmentBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterItemEquipmentDto(data);
  }

  /**
   * 檢視已裝備現金道具資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterCashItemEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterCashItemEquipmentDto | null> {
    const path = `${this.subUrl}/v1/character/cashitem-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterCashItemEquipmentBody>(
      path,
      {
        params: query,
      },
    );

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterCashItemEquipmentDto(data);
  }

  /**
   * 檢視已裝備符文資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterSymbolEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterSymbolEquipmentDto | null> {
    const path = `${this.subUrl}/v1/character/symbol-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterSymbolEquipmentBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterSymbolEquipmentDto(data);
  }

  /**
   * 檢視目前套用的套裝效果資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterSetEffect(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterSetEffectDto | null> {
    const path = `${this.subUrl}/v1/character/set-effect`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterSetEffectBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterSetEffectDto(data);
  }

  /**
   * 檢視目前已裝備的髮型、臉型與膚色資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterBeautyEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterBeautyEquipmentDto | null> {
    const path = `${this.subUrl}/v1/character/beauty-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterBeautyEquipmentBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterBeautyEquipmentDto(data);
  }

  /**
   * 檢視已裝備機器人資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterAndroidEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterAndroidEquipmentDto | null> {
    const path = `${this.subUrl}/v1/character/android-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterAndroidEquipmentBody>(
      path,
      {
        params: query,
      },
    );

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterAndroidEquipmentDto(data);
  }

  /**
   * 檢視已裝備寵物、寵物技能與寵物道具資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterPetEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPetEquipmentDto | null> {
    const path = `${this.subUrl}/v1/character/pet-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPetEquipmentBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterPetEquipmentDto(data);
  }

  /**
   * 檢視角色技能與超技能資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param characterSkillGrade 您要檢視的轉職階段 <a href="https://openapi.nexon.com/game/maplestorytw/?id=49">Available values</a>
   *  @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterSkill(
    ocid: string,
    characterSkillGrade: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterSkillDto | null> {
    const path = `${this.subUrl}/v1/character/skill`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterSkillApiQuery = {
      ocid: ocid,
      character_skill_grade: characterSkillGrade,
      date: date,
    };
    const { data } = await this.client.get<CharacterSkillBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterSkillDto(data);
  }

  /**
   * 檢視已裝備連結技能資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterLinkSkill(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterLinkSkillDto | null> {
    const path = `${this.subUrl}/v1/character/link-skill`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterLinkSkillBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterLinkSkillDto(data);
  }

  /**
   * 檢視 V 矩陣欄位資訊與已裝備 V 核心資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterVMatrix(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterVMatrixDto | null> {
    const path = `${this.subUrl}/v1/character/vmatrix`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterVMatrixBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterVMatrixDto(data);
  }

  /**
   * 檢視已裝備於 HEXA 矩陣的 HEXA 核心資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterHexaMatrix(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHexaMatrixDto | null> {
    const path = `${this.subUrl}/v1/character/hexamatrix`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHexaMatrixBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterHexaMatrixDto(data);
  }

  /**
   * 檢視設定於 HEXA 矩陣中的 HEXA 屬性資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterHexaMatrixStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHexaMatrixStatDto | null> {
    const path = `${this.subUrl}/v1/character/hexamatrix-stat`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHexaMatrixStatBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterHexaMatrixStatDto(data);
  }

  /**
   * 檢視角色在武陵道場的最高紀錄資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getCharacterDojang(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterDojangDto | null> {
    const path = `${this.subUrl}/v1/character/dojang`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterDojangBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new CharacterDojangDto(data);
  }

  //#endregion

  //#region 檢視聯盟資訊

  /**
   * 檢視戰地等級與戰地階級資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getUnion(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionDto | null> {
    const path = `${this.subUrl}/v1/user/union`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new UnionDto(data);
  }

  /**
   * 檢視詳細資訊，例如派遣至聯盟的攻擊單位成員效果，以及攻擊單位佔領效果。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getUnionRaider(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionRaiderDto | null> {
    const path = `${this.subUrl}/v1/user/union-raider`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionRaiderBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new UnionRaiderDto(data);
  }

  /**
   * 檢視戰地神器資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getUnionArtifact(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionArtifactDto | null> {
    const path = `${this.subUrl}/v1/user/union-artifact`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionArtifactBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new UnionArtifactDto(data);
  }

  /**
   * 查詢聯盟冠軍資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 12 月 18 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param ocid 角色辨識器
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getUnionChampion(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionChampionDto | null> {
    const path = `${this.subUrl}/v1/user/union-champion`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 12,
          day: 18,
        })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionChampionBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new UnionChampionDto(data);
  }

  //#endregion

  //#region 檢視公會資訊

  /**
   * 檢視公會識別碼 (oguild_id) 資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param guildName 公會名稱
   * @param worldName 世界名稱 <a href="https://openapi.nexon.com/game/maplestorytw/?id=51">Available values</a>
   */
  public override async getGuild(
    guildName: string,
    worldName: string,
  ): Promise<GuildDto | null> {
    const path = `${this.subUrl}/v1/guild/id`;
    const { data } = await this.client.get<GuildBody>(path, {
      params: {
        guild_name: guildName,
        world_name: worldName,
      },
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new GuildDto(data);
  }

  /**
   * 檢視公會基本資訊。
   * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。
   * - 您可以從 2025 年 10 月 15 日起搜尋資料。
   * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)
   * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。
   * - 此 API 提供來自楓之谷台灣的資料。
   * @param guildId 公會識別碼
   * @param dateOptions 要搜尋的日期 (TST)
   */
  public override async getGuildBasic(
    guildId: string,
    dateOptions?: DateOptions,
  ): Promise<GuildBasicDto | null> {
    const path = `${this.subUrl}/v1/guild/basic`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 10,
          day: 15,
        })
      : undefined;
    const query: GuildApiQuery = {
      oguild_id: guildId,
      date: date,
    };
    const { data } = await this.client.get<GuildBasicBody>(path, {
      params: query,
    });

    if (this.isEmptyResponse(data)) {
      return null;
    }

    return new GuildBasicDto(data);
  }

  //#endregion
}

type CharacterImageOptions = {
  /**
   * 角色動作
   */
  action?: CharacterImageAction;
  /**
   * 角色表情
   */
  emotion?: CharacterImageEmotion;
  /**
   * 角色武器動作
   */
  wmotion?: CharacterImageWeaponMotion;
  /**
   * 角色動作影格
   */
  actionFrame?: number;
  /**
   * 角色表情影格
   */
  emotionFrame?: number;
  /**
   * 寬度 (對應背景大小，96 (預設) 至 1000)
   */
  width?: number;
  /**
   * 高度 (對應背景大小，96 (預設) 至 1000)
   */
  height?: number;
  /**
   * 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
   */
  x?: number;
  /**
   * 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
   */
  y?: number;
};

type CharacterApiQuery = {
  ocid: string;
  date?: string;
};

type CharacterSkillApiQuery = {
  ocid: string;
  date?: string;
  character_skill_grade: string;
};

type UnionApiQuery = {
  ocid: string;
  date?: string;
};

type GuildApiQuery = {
  oguild_id: string;
  date?: string;
};
