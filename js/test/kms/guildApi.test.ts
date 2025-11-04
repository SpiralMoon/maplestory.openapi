import process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ogid = 'f5992063d46d6f8718e514fca5428960';

describe('Guild Information Retrieval', () => {
  describe('getGuild', () => {
    test('success: getGuild', async () => {
      const guildName = '붕붕';
      const worldName = '크로아';
      const response = await api.getGuild(guildName, worldName);
      expect(response).toBeDefined();
      expect(response!.oguildId).toBe(ogid);
      console.log(toString(response));
    });

    test('fail: getGuild with invalid world name throw OPENAPI00004', async () => {
      try {
        const guildName = '붕붕';
        const worldName = '_InvalidWorld';
        await api.getGuild(guildName, worldName);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00004);
        console.log(error.errorCode, error.message);
      }
    });

    test('success: getGuild with invalid guild name', async () => {
      const guildName = '_InvalidGuild';
      const worldName = '크로아';
      const response = await api.getGuild(guildName, worldName);
      expect(response).toBeNull();
    });
  });

  describe('getGuildBasic', () => {
    test('success: getGuildBasic', async () => {
      const response = await api.getGuildBasic(ogid);
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('fail: getGuildBasic with invalid date', async () => {
      try {
        await api.getGuildBasic(ogid, {
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

    test('fail: getGuildBasic with invalid ogid throw OPENAPI00003', async () => {
      const invalidOgid = 'invalid_ogid_123';
      try {
        await api.getGuildBasic(invalidOgid);
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
