import process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/msea';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_MSEA!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'caee7cf6ec6cb067c33b899f2779f3d1';

describe('Union Information Retrieval', () => {
  describe('getUnion', () => {
    test('success: getUnion', async () => {
      const response = await api.getUnion(ocid);
      // nothing to assert because some characters may not have union
      console.log(toString(response));
    });

    test('fail: getUnion with invalid date', async () => {
      try {
        await api.getUnion(ocid, {
          year: 2025,
          month: 4,
          day: 19,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-04-20.');
        console.log(error.message);
      }
    });

    test('fail: getUnion with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getUnion(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getUnionRaider', () => {
    test('success: getUnionRaider', async () => {
      const response = await api.getUnionRaider(ocid);
      // nothing to assert because some characters may not have union raider
      console.log(toString(response));
    });

    test('fail: getUnionRaider with invalid date', async () => {
      try {
        await api.getUnionRaider(ocid, {
          year: 2025,
          month: 4,
          day: 19,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-04-20.');
        console.log(error.message);
      }
    });

    test('fail: getUnionRaider with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getUnionRaider(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getUnionArtifact', () => {
    test('success: getUnionArtifact', async () => {
      const response = await api.getUnionArtifact(ocid);
      // nothing to assert because some characters may not have union artifact
      console.log(toString(response));
    });

    test('fail: getUnionArtifact with invalid date', async () => {
      try {
        await api.getUnionArtifact(ocid, {
          year: 2025,
          month: 4,
          day: 19,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-04-20.');
        console.log(error.message);
      }
    });

    test('fail: getUnionArtifact with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getUnionArtifact(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getUnionChampion', () => {
    test('success: getUnionChampion', async () => {
      const response = await api.getUnionChampion(ocid);
      // nothing to assert because some characters may not have union champion
      console.log(toString(response));
    });

    test('success: getUnionChampion with date', async () => {
      const response = await api.getUnionChampion(ocid, {
        year: 2025,
        month: 12,
        day: 19,
      })
      expect(response).toBeDefined()
      console.log(toString(response))
    })

    test('fail: getUnionChampion with invalid date', async () => {
      try {
        await api.getUnionChampion(ocid, {
          year: 2025,
          month: 12,
          day: 17,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2025-12-18.');
        console.log(error.message);
      }
    });

    test('fail: getUnionChampion with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getUnionChampion(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });
});
