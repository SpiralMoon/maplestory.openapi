import process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'e0a4f439e53c369866b55297d2f5f4eb';

describe('Union Information Retrieval', () => {
  describe('getUnion', () => {
    test('success: getUnion', async () => {
      const response = await api.getUnion(ocid);
      console.log(toString(response));
    });

    test('success: getUnion with date', async () => {
      const response = await api.getUnion(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('fail: getUnion with invalid date', async () => {
      try {
        await api.getUnion(ocid, {
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
      console.log(toString(response));
    });

    test('success: getUnionRaider with date', async () => {
      const response = await api.getUnionRaider(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('fail: getUnionRaider with invalid date', async () => {
      try {
        await api.getUnionRaider(ocid, {
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
      console.log(toString(response));
    });

    test('success: getUnionArtifact with date', async () => {
      const response = await api.getUnionArtifact(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('fail: getUnionArtifact with invalid date', async () => {
      try {
        await api.getUnionArtifact(ocid, {
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
      console.log(toString(response));
    });

    test('success: getUnionChampion with date', async () => {
      const response = await api.getUnionChampion(ocid, {
        year: 2023,
        month: 12,
        day: 22,
      });
      console.log(toString(response));
    });

    test('fail: getUnionChampion with invalid date', async () => {
      try {
        await api.getUnionChampion(ocid, {
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
