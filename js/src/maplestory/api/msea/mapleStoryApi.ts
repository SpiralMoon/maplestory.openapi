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
import { UnionRaiderBody } from './response/union/unionRaiderBody';
import {
  CharacterImageAction,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
} from '../common/enum/characterImage';
import { DateOptions } from '../common/mapleStoryApi';
import * as base from '../common/mapleStoryApi';

/**
 * MapleStory OpenAPI client for MSEA.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestorysea">MapleStory API</a>
 */
export class MapleStoryApi extends base.MapleStoryApi {

  protected override subUrl: string = 'maplestorysea';

  protected override timezoneOffset: number = 480;

  public constructor(apiKey: string) {
    super(apiKey);
  }

  //#region Character Information Retrieval

  /**
   * Retrieves the character identifier (ocid).
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param characterName Character name
   */
  public async getCharacter(characterName: string): Promise<CharacterDto> {
    const path = `${this.subUrl}/v1/id`;
    const { data } = await this.client.get<CharacterBody>(path, {
      params: {
        character_name: characterName,
      },
    });

    return new CharacterDto(data);
  }

  /**
   * Retrieves basic character information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterBasic(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterBasicDto> {
    const path = `${this.subUrl}/v1/character/basic`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterBasicBody>(path, {
      params: query,
    });

    return new CharacterBasicDto(data);
  }

  /**
   * Retrieves character image information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param imageOptions Image options
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterImage(
    ocid: string,
    imageOptions?: CharacterImageOptions,
    dateOptions?: DateOptions,
  ): Promise<CharacterImageDto> {
    const { date, characterImage: path } = await this.getCharacterBasic(
      ocid,
      dateOptions,
    );
    const action = imageOptions?.action ?? CharacterImageAction.Stand1;
    const emotion = imageOptions?.emotion ?? CharacterImageEmotion.Default;
    const wmotion = imageOptions?.wmotion ?? CharacterImageWeaponMotion.Default;
    const actionFrame = imageOptions?.actionFrame ?? 0;
    const emotionFrame = imageOptions?.emotionFrame ?? 0;
    const width = 96;
    const height = 96;
    const x = imageOptions?.x ?? null;
    const y = imageOptions?.y ?? null;

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
   * Retrieves popularity information of a character.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterPopularity(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPopularityDto> {
    const path = `${this.subUrl}/v1/character/popularity`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPopularityBody>(path, {
      params: query,
    });

    return new CharacterPopularityDto(data);
  }

  /**
   * Retrieves comprehensive character stats information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterStatDto> {
    const path = `${this.subUrl}/v1/character/stat`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterStatBody>(path, {
      params: query,
    });

    return new CharacterStatDto(data);
  }

  /**
   * Retrieves Hyper Stat information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterHyperStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHyperStatDto> {
    const path = `${this.subUrl}/v1/character/hyper-stat`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHyperStatBody>(path, {
      params: query,
    });

    return new CharacterHyperStatDto(data);
  }

  /**
   * Retrieves traits information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterPropensity(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPropensityDto> {
    const path = `${this.subUrl}/v1/character/propensity`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPropensityBody>(path, {
      params: query,
    });

    return new CharacterPropensityDto(data);
  }

  /**
   * Retrieves Ability information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterAbility(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterAbilityDto> {
    const path = `${this.subUrl}/v1/character/ability`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterAbilityBody>(path, {
      params: query,
    });

    return new CharacterAbilityDto(data);
  }

  /**
   * Retrieves information about equipped equipment, excluding cash items.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterItemEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterItemEquipmentDto> {
    const path = `${this.subUrl}/v1/character/item-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterItemEquipmentBody>(path, {
      params: query,
    });

    return new CharacterItemEquipmentDto(data);
  }

  /**
   * Retrieves equipped cash item information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterCashItemEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterCashItemEquipmentDto> {
    const path = `${this.subUrl}/v1/character/cashitem-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
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

    return new CharacterCashItemEquipmentDto(data);
  }

  /**
   * Retrieves information about equipped symbols.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterSymbolEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterSymbolEquipmentDto> {
    const path = `${this.subUrl}/v1/character/symbol-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterSymbolEquipmentBody>(path, {
      params: query,
    });

    return new CharacterSymbolEquipmentDto(data);
  }

  /**
   * Retrieves information about equipped set item effects.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterSetEffect(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterSetEffectDto> {
    const path = `${this.subUrl}/v1/character/set-effect`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterSetEffectBody>(path, {
      params: query,
    });

    return new CharacterSetEffectDto(data);
  }

  /**
   * Retrieves information about equipped hair, face, and skin.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterBeautyEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterBeautyEquipmentDto> {
    const path = `${this.subUrl}/v1/character/beauty-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterBeautyEquipmentBody>(path, {
      params: query,
    });

    return new CharacterBeautyEquipmentDto(data);
  }

  /**
   * Retrieves equipped andriod information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterAndroidEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterAndroidEquipmentDto> {
    const path = `${this.subUrl}/v1/character/android-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
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

    return new CharacterAndroidEquipmentDto(data);
  }

  /**
   * Retrieves information about equipped pets, including pet skills and equipment.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterPetEquipment(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterPetEquipmentDto> {
    const path = `${this.subUrl}/v1/character/pet-equipment`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterPetEquipmentBody>(path, {
      params: query,
    });

    return new CharacterPetEquipmentDto(data);
  }

  /**
   * Retrieves information about character skills and Hyper Skills.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param characterSkillGrade Job advancement tier to query
   * - 0: 0th job skills and Zero shared skills
   * - 1: 1st job skills
   * - 1.5: 1.5th job skills
   * - 2: 2nd job skills
   * - 2.5: 2.5th job skills
   * - 3: 3rd job skills
   * - 4: 4th job skills and Zero Alpha/Beta skills
   * - hyperpassive: Hyper passive skills
   * - hyperactive: Hyper active skills
   * - 5: 5th job skills
   * - 6: 6th job skills
   *  @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterSkill(
    ocid: string,
    characterSkillGrade: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterSkillDto> {
    const path = `${this.subUrl}/v1/character/skill`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
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

    return new CharacterSkillDto(data);
  }

  /**
   * Retrieves information about equipped Link Skills.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterLinkSkill(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterLinkSkillDto> {
    const path = `${this.subUrl}/v1/character/link-skill`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterLinkSkillBody>(path, {
      params: query,
    });

    return new CharacterLinkSkillDto(data);
  }

  /**
   * Retrieves V Matrix slot and equipped Node information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterVMatrix(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterVMatrixDto> {
    const path = `${this.subUrl}/v1/character/vmatrix`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterVMatrixBody>(path, {
      params: query,
    });

    return new CharacterVMatrixDto(data);
  }

  /**
   * Retrieves information about HEXA Nodes equipped in the HEXA Matrix.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterHexaMatrix(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHexaMatrixDto> {
    const path = `${this.subUrl}/v1/character/hexamatrix`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHexaMatrixBody>(path, {
      params: query,
    });

    return new CharacterHexaMatrixDto(data);
  }

  /**
   * Retrieves information about HEXA stats configured in the HEXA Matrix.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterHexaMatrixStat(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterHexaMatrixStatDto> {
    const path = `${this.subUrl}/v1/character/hexamatrix-stat`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterHexaMatrixStatBody>(path, {
      params: query,
    });

    return new CharacterHexaMatrixStatDto(data);
  }

  /**
   * Retrieves the character's highest record information in Mu Lung Garden.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getCharacterDojang(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<CharacterDojangDto> {
    const path = `${this.subUrl}/v1/character/dojang`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: CharacterApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<CharacterDojangBody>(path, {
      params: query,
    });

    return new CharacterDojangDto(data);
  }

  //#endregion

  //#region Union Information Retrieval

  /**
   * Retrieves Union level and Union rank information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getUnion(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionDto> {
    const path = `${this.subUrl}/v1/user/union`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionBody>(path, {
      params: query,
    });

    return new UnionDto(data);
  }

  /**
   * Retrieves detailed information about raid member effects and capture effects deployed in the Union.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getUnionRaider(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionRaiderDto> {
    const path = `${this.subUrl}/v1/user/union-raider`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionRaiderBody>(path, {
      params: query,
    });

    return new UnionRaiderDto(data);
  }

  /**
   * Retrieves Union Artifact information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param ocid Character identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getUnionArtifact(
    ocid: string,
    dateOptions?: DateOptions,
  ): Promise<UnionArtifactDto> {
    const path = `${this.subUrl}/v1/user/union-artifact`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: UnionApiQuery = {
      ocid: ocid,
      date: date,
    };
    const { data } = await this.client.get<UnionArtifactBody>(path, {
      params: query,
    });

    return new UnionArtifactDto(data);
  }

  //#endregion

  //#region Guild Information Retrieval

  /**
   * Retrieves information for the guild identifier (oguild_id).
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param guildName Guild name
   * @param worldName World name
   */
  public async getGuild(
    guildName: string,
    worldName: string,
  ): Promise<GuildDto> {
    const path = `${this.subUrl}/v1/guild/id`;
    const { data } = await this.client.get<GuildBody>(path, {
      params: {
        guild_name: guildName,
        world_name: worldName,
      },
    });

    return new GuildDto(data);
  }

  /**
   * Retrieves guild basic information.
   * - MapleStory game data can be verified approximately 15 minutes after updates.
   * - Data is available starting from April 20, 2025.
   * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)
   * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.
   * - This API provides data for MapleStory SEA.
   * @param guildId Guild identifier
   * @param dateOptions Reference date for query (SGT)
   */
  public async getGuildBasic(
    guildId: string,
    dateOptions?: DateOptions,
  ): Promise<GuildBasicDto> {
    const path = `${this.subUrl}/v1/guild/basic`;
    const date = dateOptions
      ? this.toDateString(dateOptions, {
          year: 2025,
          month: 4,
          day: 20,
        })
      : undefined;
    const query: GuildApiQuery = {
      oguild_id: guildId,
      date: date,
    };
    const { data } = await this.client.get<GuildBasicBody>(path, {
      params: query,
    });

    return new GuildBasicDto(data);
  }

  //#endregion
}

type CharacterImageOptions = {
  /**
   * 캐릭터 액션
   */
  action?: CharacterImageAction;
  /**
   * 캐릭터 감정표현
   */
  emotion?: CharacterImageEmotion;
  /**
   * 캐릭터 무기 모션
   */
  wmotion?: CharacterImageWeaponMotion;
  /**
   * 캐릭터 액션 프레임.
   */
  actionFrame?: number;
  /**
   * 캐릭터 감정표현 프레임
   */
  emotionFrame?: number;
  /**
   * 가로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
   */
  width?: number;
  /**
   * 세로 길이. 배경 크기에 해당함, 96 (default) ~ 1000
   */
  height?: number;
  /**
   * 캐릭터의 가로 좌표
   */
  x?: number;
  /**
   * 캐릭터의 세로 좌표.
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
