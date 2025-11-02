import * as process from 'process';

import {
  CharacterImageAction,
  CharacterImageEmotion,
  CharacterImageWeaponMotion,
  MapleStoryApiError,
  MapleStoryApiErrorCode,
} from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/tms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_TMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'ab918948538b1b79046df133fff52092';

describe('Character Information Retrieval', () => {
  describe('getCharacter', () => {
    test('success: getCharacter', async () => {
      const nickname = '吳獨秀x';
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
      console.log(toString(response));
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
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
        year: 2025,
        month: 10,
        day: 15,
      });
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
          year: 2025,
          month: 10,
          day: 14,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-10-15.');
        console.log(error.message);
      }
    });
  });
});
