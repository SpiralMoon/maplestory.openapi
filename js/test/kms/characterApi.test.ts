import { AxiosError } from 'axios';
import * as process from 'process';

import {
  CharacterImageAction,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
  MapleStoryApiError,
  MapleStoryApiErrorCode,
} from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'e0a4f439e53c369866b55297d2f5f4eb';

describe('Character Information Retrieval', () => {
  describe('getCharacter', () => {
    test('success: getCharacter', async () => {
      const nickname = '아델';
      const response = await api.getCharacter(nickname);
      expect(response.ocid).toEqual(ocid);
      console.log(toString(response));
    });

    test('fail: getCharacter with invalid name throw OPENAPI00004', async () => {
      const invalidNickname = 'invalid_nickname_123_';
      try {
        await api.getCharacter(invalidNickname);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00004);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getCharacterBasic', () => {
    test('success: getCharacterBasic', async () => {
      const response = await api.getCharacterBasic(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterBasic with date', async () => {
      const response = await api.getCharacterBasic(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterBasic on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterBasic(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterName).toBeNull();
      expect(response.worldName).toBeNull();
      expect(response.characterGender).toBeNull();
      expect(response.characterClass).toBeNull();
      expect(response.characterClassLevel).toBeNull();
      expect(response.characterLevel).toBeNull();
      expect(response.characterExp).toBeNull();
      expect(response.characterExpRate).toBeNull();
      expect(response.characterGuildName).toBeNull();
      expect(response.characterImage).toBeNull();
      expect(response.characterDateCreate).toBeNull();
      expect(response.accessFlag).toBeNull();
      expect(response.liberationQuestClear).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterBasic with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterBasic(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterBasic with invalid date', async () => {
      try {
        await api.getCharacterBasic(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterImage', () => {
    test('success: getCharacterImage', async () => {
      const response = await api.getCharacterImage(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterImage with options', async () => {
      const response = await api.getCharacterImage(ocid, {
        action: CharacterImageAction.Jump,
        actionFrame: 0,
        emotion: CharacterImageEmotion.Chu,
        emotionFrame: 0,
        wmotion: CharacterImageWeaponMotion.Nothing,
      });
      console.log(toString(response));
    });

    test('success: getCharacterImage with date', async () => {
      const response = await api.getCharacterImage(ocid, {}, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('fail: getCharacterImage on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      try {
        await api.getCharacterImage(ocid, {}, {
          year: 2025,
          month: 6,
          day: 18,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as AxiosError;
        expect(error).toBeInstanceOf(AxiosError);
        console.log(error.message);
      }
    });

    test('fail: getCharacterImage with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterImage(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterImage with invalid date', async () => {
      try {
        await api.getCharacterImage(ocid, {}, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterPopularity', () => {
    test('success: getCharacterPopularity', async () => {
      const response = await api.getCharacterPopularity(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterPopularity with date', async () => {
      const response = await api.getCharacterPopularity(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterPopularity on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterPopularity(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.popularity).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterPopularity with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterPopularity(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterPopularity with invalid date', async () => {
      try {
        await api.getCharacterPopularity(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterStat', () => {
    test('success: getCharacterStat', async () => {
      const response = await api.getCharacterStat(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterStat with date', async () => {
      const response = await api.getCharacterStat(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterStat on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterStat(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeNull();
      expect(response.finalStat).toEqual([]);
      expect(response.remainAP).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterStat with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterStat(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterStat with invalid date', async () => {
      try {
        await api.getCharacterStat(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterHyperStat', () => {
    test('success: getCharacterHyperStat', async () => {
      const response = await api.getCharacterHyperStat(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterHyperStat with date', async () => {
      const response = await api.getCharacterHyperStat(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterHyperStat on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterHyperStat(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeNull();
      expect(response.usePresetNo).toBeNull();
      expect(response.useAvailableHyperStat).toBeNull();
      expect(response.hyperStatPreset1).toEqual([]);
      expect(response.hyperStatPreset1RemainPoint).toBeNull();
      expect(response.hyperStatPreset2).toEqual([]);
      expect(response.hyperStatPreset2RemainPoint).toBeNull();
      expect(response.hyperStatPreset3).toEqual([]);
      expect(response.hyperStatPreset3RemainPoint).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterHyperStat with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterHyperStat(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterHyperStat with invalid date', async () => {
      try {
        await api.getCharacterHyperStat(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterPropensity', () => {
    test('success: getCharacterPropensity', async () => {
      const response = await api.getCharacterPropensity(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterPropensity with date', async () => {
      const response = await api.getCharacterPropensity(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterPropensity on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterPropensity(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.charismaLevel).toBeNull();
      expect(response.sensibilityLevel).toBeNull();
      expect(response.insightLevel).toBeNull();
      expect(response.willingnessLevel).toBeNull();
      expect(response.handicraftLevel).toBeNull();
      expect(response.charmLevel).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterPropensity with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterPropensity(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterPropensity with invalid date', async () => {
      try {
        await api.getCharacterPropensity(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterAbility', () => {
    test('success: getCharacterAbility', async () => {
      const response = await api.getCharacterAbility(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterAbility with date', async () => {
      const response = await api.getCharacterAbility(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterAbility on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterAbility(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.abilityGrade).toBeNull();
      expect(response.abilityInfo).toEqual([]);
      expect(response.remainFame).toBeNull();
      expect(response.presetNo).toBeNull();
      expect(response.abilityPreset1).toBeNull();
      expect(response.abilityPreset2).toBeNull();
      expect(response.abilityPreset3).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterAbility with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterAbility(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterAbility with invalid date', async () => {
      try {
        await api.getCharacterAbility(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterItemEquipment', () => {
    test('success: getCharacterItemEquipment', async () => {
      const response = await api.getCharacterItemEquipment(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterItemEquipment with date', async () => {
      const response = await api.getCharacterItemEquipment(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterItemEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterItemEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterGender).toBeNull();
      expect(response.characterClass).toBeNull();
      expect(response.presetNo).toBeNull();
      expect(response.itemEquipment).toEqual([]);
      expect(response.itemEquipmentPreset1).toEqual([]);
      expect(response.itemEquipmentPreset2).toEqual([]);
      expect(response.itemEquipmentPreset3).toEqual([]);
      expect(response.title).toBeNull();
      expect(response.medalShape).toBeNull();
      expect(response.dragonEquipment).toEqual([]);
      expect(response.mechanicEquipment).toEqual([]);
      console.log(toString(response));
    });

    test('fail: getCharacterItemEquipment with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterItemEquipment(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterItemEquipment with invalid date', async () => {
      try {
        await api.getCharacterItemEquipment(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterCashItemEquipment', () => {
    test('success: getCharacterCashItemEquipment', async () => {
      const response = await api.getCharacterCashItemEquipment(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterCashItemEquipment with date', async () => {
      const response = await api.getCharacterCashItemEquipment(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterCashItemEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterCashItemEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterGender).toBeNull();
      expect(response.characterClass).toBeNull();
      expect(response.characterLookMode).toBeNull();
      expect(response.presetNo).toBeNull();
      expect(response.cashItemEquipmentBase).toEqual([]);
      expect(response.cashItemEquipmentPreset1).toEqual([]);
      expect(response.cashItemEquipmentPreset2).toEqual([]);
      expect(response.cashItemEquipmentPreset3).toEqual([]);
      expect(response.additionalCashItemEquipmentBase).toEqual([]);
      expect(response.additionalCashItemEquipmentPreset1).toEqual([]);
      expect(response.additionalCashItemEquipmentPreset2).toEqual([]);
      expect(response.additionalCashItemEquipmentPreset3).toEqual([]);
      console.log(toString(response));
    });

    test('fail: getCharacterCashItemEquipment with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterCashItemEquipment(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterCashItemEquipment with invalid date', async () => {
      try {
        await api.getCharacterCashItemEquipment(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterSymbolEquipment', () => {
    test('success: getCharacterSymbolEquipment', async () => {
      const response = await api.getCharacterSymbolEquipment(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterSymbolEquipment with date', async () => {
      const response = await api.getCharacterSymbolEquipment(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterSymbolEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterSymbolEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeNull();
      expect(response.symbol).toEqual([]);
      console.log(toString(response));
    });

    test('fail: getCharacterSymbolEquipment with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterSymbolEquipment(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterSymbolEquipment with invalid date', async () => {
      try {
        await api.getCharacterSymbolEquipment(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterSetEffect', () => {
    test('success: getCharacterSetEffect', async () => {
      const response = await api.getCharacterSetEffect(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterSetEffect with date', async () => {
      const response = await api.getCharacterSetEffect(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterSetEffect on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterSetEffect(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.setEffect).toEqual([]);
      console.log(toString(response));
    });

    test('fail: getCharacterSetEffect with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterSetEffect(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterSetEffect with invalid date', async () => {
      try {
        await api.getCharacterSetEffect(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterBeautyEquipment', () => {
    test('success: getCharacterBeautyEquipment', async () => {
      const response = await api.getCharacterBeautyEquipment(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterBeautyEquipment with date', async () => {
      const response = await api.getCharacterBeautyEquipment(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterBeautyEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterBeautyEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterGender).toBeNull();
      expect(response.characterClass).toBeNull();
      expect(response.characterHair).toBeNull();
      expect(response.characterFace).toBeNull();
      expect(response.characterSkin).toBeNull();
      expect(response.additionalCharacterHair).toBeNull();
      expect(response.additionalCharacterFace).toBeNull();
      expect(response.additionalCharacterSkin).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterBeautyEquipment with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterBeautyEquipment(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterBeautyEquipment with invalid date', async () => {
      try {
        await api.getCharacterBeautyEquipment(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterAndroidEquipment', () => {
    test('success: getCharacterAndroidEquipment', async () => {
      const response = await api.getCharacterAndroidEquipment(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterAndroidEquipment with date', async () => {
      const response = await api.getCharacterAndroidEquipment(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterAndroidEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterAndroidEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.androidName).toBeNull();
      expect(response.androidNickname).toBeNull();
      expect(response.androidIcon).toBeNull();
      expect(response.androidDescription).toBeNull();
      expect(response.androidHair).toBeNull();
      expect(response.androidFace).toBeNull();
      expect(response.androidSkin).toBeNull();
      expect(response.androidCashItemEquipment).toEqual([]);
      expect(response.androidEarSensorClipFlag).toBeNull();
      expect(response.androidGender).toBeNull();
      expect(response.androidGrade).toBeNull();
      expect(response.androidNonHumanoidFlag).toBeNull();
      expect(response.androidShopUsableFlag).toBeNull();
      expect(response.presetNo).toBeNull();
      expect(response.androidPreset1).toBeNull();
      expect(response.androidPreset2).toBeNull();
      expect(response.androidPreset3).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterAndroidEquipment with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterAndroidEquipment(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterAndroidEquipment with invalid date', async () => {
      try {
        await api.getCharacterAndroidEquipment(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterPetEquipment', () => {
    test('success: getCharacterPetEquipment', async () => {
      const response = await api.getCharacterPetEquipment(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterPetEquipment with date', async () => {
      const response = await api.getCharacterPetEquipment(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterPetEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterPetEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.pet1Name).toBeNull();
      expect(response.pet1Nickname).toBeNull();
      expect(response.pet1Icon).toBeNull();
      expect(response.pet1Description).toBeNull();
      expect(response.pet1Equipment).toBeNull();
      expect(response.pet1AutoSkill).toBeNull();
      expect(response.pet1PetType).toBeNull();
      expect(response.pet1Skill).toEqual([]);
      expect(response.pet1DateExpire).toBeNull();
      expect(response.pet1Expired).toBeNull();
      expect(response.pet1Appearance).toBeNull();
      expect(response.pet1AppearanceIcon).toBeNull();
      expect(response.pet2Name).toBeNull();
      expect(response.pet2Nickname).toBeNull();
      expect(response.pet2Icon).toBeNull();
      expect(response.pet2Description).toBeNull();
      expect(response.pet2Equipment).toBeNull();
      expect(response.pet2AutoSkill).toBeNull();
      expect(response.pet2PetType).toBeNull();
      expect(response.pet2Skill).toEqual([]);
      expect(response.pet2DateExpire).toBeNull();
      expect(response.pet2Expired).toBeNull();
      expect(response.pet2Appearance).toBeNull();
      expect(response.pet2AppearanceIcon).toBeNull();
      expect(response.pet3Name).toBeNull();
      expect(response.pet3Nickname).toBeNull();
      expect(response.pet3Icon).toBeNull();
      expect(response.pet3Description).toBeNull();
      expect(response.pet3Equipment).toBeNull();
      expect(response.pet3AutoSkill).toBeNull();
      expect(response.pet3PetType).toBeNull();
      expect(response.pet3Skill).toEqual([]);
      expect(response.pet3DateExpire).toBeNull();
      expect(response.pet3Expired).toBeNull();
      expect(response.pet3Appearance).toBeNull();
      expect(response.pet3AppearanceIcon).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterPetEquipment with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterPetEquipment(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterPetEquipment with invalid date', async () => {
      try {
        await api.getCharacterPetEquipment(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterSkill', () => {
    test('success: getCharacterSkill with skill grade', async () => {
      const skillGrade = '6';
      const response = await api.getCharacterSkill(ocid, skillGrade);
      console.log(toString(response));
    });

    test('success: getCharacterSkill with date', async () => {
      const skillGrade = '6';
      const response = await api.getCharacterSkill(ocid, skillGrade, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterSkill on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterSkill(ocid, '6', {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeNull();
      expect(response.characterSkillGrade).toBeNull();
      expect(response.characterSkill).toEqual([]);
      console.log(toString(response));
    });

    test('fail: getCharacterSkill with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterSkill(invalidOcid, '6');
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterSkill with invalid date', async () => {
      const skillGrade = '6';
      try {
        await api.getCharacterSkill(ocid, skillGrade, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterLinkSkill', () => {
    test('success: getCharacterLinkSkill', async () => {
      const response = await api.getCharacterLinkSkill(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterLinkSkill with date', async () => {
      const response = await api.getCharacterLinkSkill(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterLinkSkill on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterLinkSkill(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeNull();
      expect(response.characterLinkSkill).toEqual([]);
      expect(response.characterLinkSkillPreset1).toEqual([]);
      expect(response.characterLinkSkillPreset2).toEqual([]);
      expect(response.characterLinkSkillPreset3).toEqual([]);
      expect(response.characterOwnedLinkSkill).toBeNull();
      expect(response.characterOwnedLinkSkillPreset1).toBeNull();
      expect(response.characterOwnedLinkSkillPreset2).toBeNull();
      expect(response.characterOwnedLinkSkillPreset3).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterLinkSkill with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterLinkSkill(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterLinkSkill with invalid date', async () => {
      try {
        await api.getCharacterLinkSkill(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterVMatrix', () => {
    test('success: getCharacterVMatrix', async () => {
      const response = await api.getCharacterVMatrix(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterVMatrix with date', async () => {
      const response = await api.getCharacterVMatrix(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterVMatrix on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterVMatrix(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeNull();
      expect(response.characterVCoreEquipment).toEqual([]);
      expect(response.characterVMatrixRemainSlotUpgradePoint).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterVMatrix with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterVMatrix(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterVMatrix with invalid date', async () => {
      try {
        await api.getCharacterVMatrix(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterHexaMatrix', () => {
    test('success: getCharacterHexaMatrix', async () => {
      const response = await api.getCharacterHexaMatrix(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterHexaMatrix with date', async () => {
      const response = await api.getCharacterHexaMatrix(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterHexaMatrix on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterHexaMatrix(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterHexaCoreEquipment).toEqual([]);
      console.log(toString(response));
    });

    test('fail: getCharacterHexaMatrix with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterHexaMatrix(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterHexaMatrix with invalid date', async () => {
      try {
        await api.getCharacterHexaMatrix(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterHexaMatrixStat', () => {
    test('success: getCharacterHexaMatrixStat', async () => {
      const response = await api.getCharacterHexaMatrixStat(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterHexaMatrixStat with date', async () => {
      const response = await api.getCharacterHexaMatrixStat(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterHexaMatrixStat on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterHexaMatrixStat(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeDefined();
      expect(response.characterHexaStatCore).toEqual([]);
      expect(response.characterHexaStatCore2).toEqual([]);
      expect(response.characterHexaStatCore3).toEqual([]);
      expect(response.presetHexaStatCore).toEqual([]);
      expect(response.presetHexaStatCore2).toEqual([]);
      expect(response.presetHexaStatCore3).toEqual([]);
      console.log(toString(response));
    });

    test('fail: getCharacterHexaMatrixStat with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterHexaMatrixStat(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterHexaMatrixStat with invalid date', async () => {
      try {
        await api.getCharacterHexaMatrixStat(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterDojang', () => {
    test('success: getCharacterDojang', async () => {
      const response = await api.getCharacterDojang(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterDojang with date', async () => {
      const response = await api.getCharacterDojang(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('success: getCharacterDojang on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterDojang(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeNull();
      expect(response.worldName).toBeNull();
      expect(response.dojangBestFloor).toBeNull();
      expect(response.dateDojangRecord).toBeNull();
      expect(response.dojangBestTime).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterDojang with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterDojang(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterDojang with invalid date', async () => {
      try {
        await api.getCharacterDojang(ocid, {
          year: 2023,
          month: 12,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterOtherStat', () => {
    test('success: getCharacterOtherStat', async () => {
      const response = await api.getCharacterOtherStat(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterOtherStat with date', async () => {
      const response = await api.getCharacterOtherStat(ocid, {
        year: 2025,
        month: 8,
        day: 21,
      });
      console.log(toString(response));
    });

    test('success: getCharacterOtherStat on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterOtherStat(ocid, {
        year: 2025,
        month: 8,
        day: 21,
      });
      expect(response.date).toBeDefined();
      expect(response.otherStat).toEqual([]);
      console.log(toString(response));
    });

    test('fail: getCharacterOtherStat with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterOtherStat(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterOtherStat with invalid date', async () => {
      try {
        await api.getCharacterOtherStat(ocid, {
          year: 2025,
          month: 8,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-08-21.');
        console.log(error.message);
      }
    });
  });

  describe('getCharacterRingExchangeSkillEquipment', () => {
    test('success: getCharacterRingExchangeSkillEquipment', async () => {
      const response = await api.getCharacterRingExchangeSkillEquipment(ocid);
      console.log(toString(response));
    });

    test('success: getCharacterRingExchangeSkillEquipment with date', async () => {
      const response = await api.getCharacterRingExchangeSkillEquipment(ocid, {
        year: 2025,
        month: 8,
        day: 21,
      });
      console.log(toString(response));
    });

    test('success: getCharacterRingExchangeSkillEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterRingExchangeSkillEquipment(ocid, {
        year: 2025,
        month: 8,
        day: 21,
      });
      expect(response.date).toBeDefined();
      expect(response.characterClass).toBeNull();
      expect(response.specialRingExchangeName).toBeNull();
      expect(response.specialRingExchangeLevel).toBeNull();
      expect(response.specialRingExchangeIcon).toBeNull();
      expect(response.specialRingExchangeDescription).toBeNull();
      console.log(toString(response));
    });

    test('fail: getCharacterRingExchangeSkillEquipment with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getCharacterRingExchangeSkillEquipment(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCharacterRingExchangeSkillEquipment with invalid date', async () => {
      try {
        await api.getCharacterRingExchangeSkillEquipment(ocid, {
          year: 2025,
          month: 8,
          day: 20,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-08-21.');
        console.log(error.message);
      }
    });
  });
});
