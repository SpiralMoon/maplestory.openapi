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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterBasic with date', async () => {
      const response = await api.getCharacterBasic(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterBasic on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterBasic(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterImage with date', async () => {
      const response = await api.getCharacterImage(ocid, {}, {
        year: 2023,
        month: 12,
        day: 22,
      });
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterImage on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterImage(ocid, {}, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterPopularity with date', async () => {
      const response = await api.getCharacterPopularity(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterPopularity on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterPopularity(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterStat with date', async () => {
      const response = await api.getCharacterStat(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterStat on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterStat(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterHyperStat with date', async () => {
      const response = await api.getCharacterHyperStat(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterHyperStat on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterHyperStat(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterPropensity on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterPropensity(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterAbility on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterAbility(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      })
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterItemEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterItemEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterCashItemEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterCashItemEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterSymbolEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterSymbolEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      // nothing to assert because some characters may not have set effects
      console.log(toString(response));
    });

    test('success: getCharacterSetEffect on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterSetEffect(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterBeautyEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterBeautyEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterAndroidEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterAndroidEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      // nothing to assert because some characters may not have pets
      console.log(toString(response));
    });

    test('success: getCharacterPetEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterPetEquipment(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterSkill on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterSkill(ocid, '6', {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
    });

    test('success: getCharacterSkill on date with has no skill grade', async () => {
      const ocid = 'c0ee173596c89da990c6fae8106e62f0'; // This character is 2nd job
      const response = await api.getCharacterSkill(ocid, 'hyperactive');
      expect(response).toBeDefined();
      expect(response?.characterSkillGrade).toBeNull();
      expect(response?.characterSkill.length).toBe(0);
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterLinkSkill on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterLinkSkill(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      // nothing to assert because some characters may not have v matrix
      console.log(toString(response));
    });

    test('success: getCharacterVMatrix on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterVMatrix(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      // nothing to assert because some characters may not have hexa matrix
      console.log(toString(response));
    });

    test('success: getCharacterHexaMatrix on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterHexaMatrix(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterHexaMatrixStat on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterHexaMatrixStat(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterDojang on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterDojang(ocid, {
        year: 2025,
        month: 6,
        day: 18,
      });
      expect(response).toBeNull();
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
      // nothing to assert because some characters may not have other stats
      console.log(toString(response));
    });

    test('success: getCharacterOtherStat with date', async () => {
      const ocid = '17886f88aca85174fe898b739b7fd0d9';
      const response = await api.getCharacterOtherStat(ocid, {
        year: 2025,
        month: 11,
        day: 20,
      });
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterOtherStat on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterOtherStat(ocid, {
        year: 2025,
        month: 8,
        day: 21,
      });
      expect(response).toBeNull();
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
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getCharacterRingExchangeSkillEquipment on date with no data', async () => {
      const ocid = 'b0187493ec48ddd7b1d304fe8982d0b0';
      const response = await api.getCharacterRingExchangeSkillEquipment(ocid, {
        year: 2025,
        month: 8,
        day: 21,
      });
      expect(response).toBeNull();
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
