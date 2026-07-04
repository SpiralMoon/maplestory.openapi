import * as process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

describe('Scheduler Information Retrieval', () => {
  describe('getSchedulerCharacterState', () => {
    test('success: getSchedulerCharacterState', async () => {
      const characterList = await api.getCharacterList();
      const ocid = characterList.accountList[0].characterList[0].ocid;
      const response = await api.getSchedulerCharacterState(ocid);
      console.log(toString(response));
    });

    test('fail: getSchedulerCharacterState with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getSchedulerCharacterState(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('success: getSchedulerCharacterState within the 14-day window', async () => {
      const characterList = await api.getCharacterList();
      const ocid = characterList.accountList[0].characterList[0].ocid;
      const date = new Date(Date.now() - 13 * 24 * 60 * 60 * 1000);
      const response = await api.getSchedulerCharacterState(ocid, date);
      console.log(toString(response));
    });

    test('fail: getSchedulerCharacterState outside the 14-day window throw OPENAPI00004', async () => {
      const characterList = await api.getCharacterList();
      const ocid = characterList.accountList[0].characterList[0].ocid;
      const date = new Date(Date.now() - 14 * 24 * 60 * 60 * 1000);
      try {
        await api.getSchedulerCharacterState(ocid, date);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00004);
        console.log(error.errorCode, error.message);
      }
    });
  });
});
