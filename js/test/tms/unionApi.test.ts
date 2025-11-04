import process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/tms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_TMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'ab918948538b1b79046df133fff52092';

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
});
