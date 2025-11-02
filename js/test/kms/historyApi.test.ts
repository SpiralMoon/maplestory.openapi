import process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

describe('History Information Retrieval', () => {
  describe('getStarforceHistory', () => {
    test('success: getStarforceHistory', async () => {
      const count = 1000;
      const response = await api.getStarforceHistory(count);
      console.log(toString(response));
    });

    test('success: getStarforceHistory with date', async () => {
      const count = 1000;
      const response = await api.getStarforceHistory(count, {
        year: 2025,
        month: 9,
        day: 21,
      });
      console.log(toString(response));
    });

    test('success: getStarforceHistory with cursor', async () => {
      const count = 10;
      const response = await api.getStarforceHistory(count, {
        year: 2025,
        month: 9,
        day: 21,
      });
      const { nextCursor } = response; // 결과가 count 보다 많은 경우에만 nextCursor가 반환 됩니다.
      expect(nextCursor).toBeDefined();
      const nextResponse = await api.getStarforceHistory(count, nextCursor!);
      console.log(toString(nextResponse));
    });

    test('fail: getStarforceHistory with invalid date', async () => {
      try {
        await api.getStarforceHistory(1000, {
          year: 2023,
          month: 12,
          day: 26,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-27.');
        console.log(error.message);
      }
    });

    test('fail: getStarforceHistory with invalid cursor throw OPENAPI00003', async () => {
      const invalidCursor = 'invalid_cursor_123';
      try {
        await api.getStarforceHistory(1000, invalidCursor);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getStarforceHistory with excessive count throw OPENAPI00004', async () => {
      try {
        const count = 9999;
        await api.getStarforceHistory(count);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00004);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getPotentialHistory', () => {
    test('success: getPotentialHistory', async () => {
      const count = 1000;
      const response = await api.getPotentialHistory(count);

      console.log(toString(response));
    });

    test('success: getPotentialHistory with date', async () => {
      const count = 1000;
      const response = await api.getPotentialHistory(count, {
        year: 2025,
        month: 7,
        day: 31,
      });
      console.log(toString(response));
    });

    test('success: getPotentialHistory with cursor', async () => {
      const count = 10;
      const response = await api.getPotentialHistory(count, {
        year: 2025,
        month: 7,
        day: 31,
      });
      const { nextCursor } = response; // 결과가 count 보다 많은 경우에만 nextCursor가 반환 됩니다.
      expect(nextCursor).toBeDefined();
      const nextResponse = await api.getPotentialHistory(count, nextCursor!);
      console.log(toString(nextResponse));
    });

    test('fail: getPotentialHistory with invalid date', async () => {
      try {
        await api.getPotentialHistory(1000, {
          year: 2024,
          month: 1,
          day: 24,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2024-01-25.');
        console.log(error.message);
      }
    });

    test('fail: getPotentialHistory with invalid cursor throw OPENAPI00003', async () => {
      const invalidCursor = 'invalid_cursor_123';
      try {
        await api.getPotentialHistory(1000, invalidCursor);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getPotentialHistory with excessive count throw OPENAPI00004', async () => {
      try {
        const count = 9999;
        await api.getPotentialHistory(count);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00004);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getCubeHistory', () => {
    test('success: getCubeHistory', async () => {
      const count = 1000;
      const response = await api.getCubeHistory(count);

      console.log(toString(response));
    });

    test('success: getCubeHistory with date', async () => {
      const count = 1000;
      const response = await api.getCubeHistory(count, {
        year: 2025,
        month: 10,
        day: 23,
      });
      console.log(toString(response));
    });

    test('success: getCubeHistory with cursor', async () => {
      const count = 10;
      const response = await api.getCubeHistory(count, {
        year: 2025,
        month: 10,
        day: 23,
      });
      const { nextCursor } = response; // 결과가 count 보다 많은 경우에만 nextCursor가 반환 됩니다.
      expect(nextCursor).toBeDefined();
      const nextResponse = await api.getCubeHistory(count, nextCursor!);
      console.log(toString(nextResponse));
    });

    test('fail: getCubeHistory with invalid cursor throw OPENAPI00003', async () => {
      const invalidCursor = 'invalid_cursor_123';
      try {
        await api.getCubeHistory(1000, invalidCursor);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });

    test('fail: getCubeHistory with excessive count throw OPENAPI00004', async () => {
      try {
        const count = 9999;
        await api.getPotentialHistory(count);
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
