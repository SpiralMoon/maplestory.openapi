import process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'e0a4f439e53c369866b55297d2f5f4eb';

describe('Ranking Information Retrieval', () => {
  describe('getOverallRanking', () => {
    test('success: getOverallRanking', async () => {
      const response = await api.getOverallRanking();
      console.log(toString(response));
    });

    test('success: getOverallRanking with paging', async () => {
      const response = await api.getOverallRanking({
        page: 2,
      });
      console.log(toString(response));
    });

    test('success: getOverallRanking with ocid', async () => {
      const response = await api.getOverallRanking({
        ocid: ocid,
      });
      console.log(toString(response));
    });

    test('success: getOverallRanking with specific job', async () => {
      const response = await api.getOverallRanking({
        characterClass: '전사-히어로',
      });
      console.log(toString(response));
    });

    test('success: getOverallRanking with job group', async () => {
      const response = await api.getOverallRanking({
        characterClass: '전사-전체 전직',
      });
      console.log(toString(response));
    });

    test('success: getOverallRanking with world name', async () => {
      const response = await api.getOverallRanking({
        worldName: '스카니아',
      });
      console.log(toString(response));
    });

    test('success: getOverallRanking with world type', async () => {
      const response = await api.getOverallRanking({
        worldType: 0,
      });
      console.log(toString(response));
    });

    test('success: getOverallRanking with world and job', async () => {
      const response = await api.getOverallRanking({
        worldName: '스카니아',
        characterClass: '아델-전체 전직'
      });
      console.log(toString(response));
    });

    test('success: getOverallRanking with date', async () => {
      const response = await api.getOverallRanking(undefined, {
        year: 2023,
        month: 12,
        day: 23,
      });
      console.log(toString(response));
    });

    test('fail: getOverallRanking with invalid date', async () => {
      try {
        await api.getOverallRanking(undefined, {
          year: 2023,
          month: 12,
          day: 21,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-22.');
        console.log(error.message);
      }
    });

    test('fail: getOverallRanking with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getOverallRanking({ ocid: invalidOcid });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getUnionRanking', () => {
    test('success: getUnionRanking', async () => {
      const response = await api.getUnionRanking();
      console.log(toString(response));
    });

    test('success: getUnionRanking with paging', async () => {
      const response = await api.getUnionRanking({
        page: 2,
      });
      console.log(toString(response));
    });

    test('success: getUnionRanking with ocid', async () => {
      const response = await api.getUnionRanking({
        ocid: ocid,
      });
      expect(response.ranking.length).toBe(1);
      console.log(toString(response));
    });

    test('success: getUnionRanking with world name', async () => {
      const response = await api.getUnionRanking({
        worldName: '스카니아',
      });
      expect(response.ranking.length).toBeGreaterThan(0);
      console.log(toString(response));
    });

    test('success: getUnionRanking with date', async () => {
      const response = await api.getUnionRanking(undefined, {
        year: 2023,
        month: 12,
        day: 23,
      });
      console.log(toString(response));
    });

    test('fail: getUnionRanking with invalid date', async () => {
      try {
        await api.getUnionRanking(undefined, {
          year: 2023,
          month: 12,
          day: 21,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-22.');
        console.log(error.message);
      }
    });

    test('fail: getUnionRanking with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getUnionRanking({ ocid: invalidOcid });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getGuildRanking', () => {
    test('success: getGuildRanking', async () => {
      const response = await api.getGuildRanking();
      console.log(toString(response));
    });

    test('success: getGuildRanking with paging', async () => {
      const response = await api.getGuildRanking({
        rankingType: 0,
        page: 2,
      });
      console.log(toString(response));
    });

    test('success: getGuildRanking with guild name', async () => {
      const response = await api.getGuildRanking({
        rankingType: 0,
        guildName: '리더',
      });
      expect(response.ranking.length).toBeGreaterThan(0);
      console.log(toString(response));
    });

    test('success: getGuildRanking with world name', async () => {
      const response = await api.getGuildRanking({
        rankingType: 0,
        worldName: '스카니아',
      });
      expect(response.ranking.length).toBeGreaterThan(0);
      console.log(toString(response));
    });

    test('success: getGuildRanking with world and guild name', async () => {
      const response = await api.getGuildRanking({
        rankingType: 0,
        worldName: '스카니아',
        guildName: '리더',
      });
      expect(response.ranking.length).toBeLessThanOrEqual(1);
      console.log(toString(response));
    });

    test('success: getGuildRanking with date', async () => {
      const response = await api.getGuildRanking(undefined, {
        year: 2023,
        month: 12,
        day: 23,
      });
      console.log(toString(response));
    });

    test('fail: getGuildRanking with invalid date', async () => {
      try {
        await api.getGuildRanking(undefined, {
          year: 2023,
          month: 12,
          day: 21,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-22.');
        console.log(error.message);
      }
    });

    test('success: getGuildRanking with invalid guild name', async () => {
      const invalidGuildName = 'invalid_guild_name_123';
      const response = await api.getGuildRanking({
        rankingType: 0,
        guildName: invalidGuildName,
      });
      expect(response.ranking.length).toBe(0);
      console.log(toString(response));
    });

    test('fail: getGuildRanking with invalid ranking type throw OPENAPI00004', async () => {
      try {
        await api.getGuildRanking({
          rankingType: -1,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00004);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getDojangRanking', () => {
    test('success: getDojangRanking', async () => {
      const response = await api.getDojangRanking();
      console.log(toString(response));
    });

    test('success: getDojangRanking with paging', async () => {
      const response = await api.getDojangRanking({
        difficulty: 1,
        page: 2,
      });
      console.log(toString(response));
    });

    test('success: getDojangRanking with ocid', async () => {
      const response = await api.getDojangRanking({
        difficulty: 1,
        ocid: ocid,
      });
      expect(response.ranking.length).toBeGreaterThanOrEqual(0);
      console.log(toString(response));
    });

    test('success: getDojangRanking with world name', async () => {
      const response = await api.getDojangRanking({
        difficulty: 1,
        worldName: '스카니아',
      });
      console.log(toString(response));
    });

    test('success: getDojangRanking with specific job', async () => {
      const response = await api.getDojangRanking({
        difficulty: 1,
        characterClass: '전사-히어로',
      });
      console.log(toString(response));
    });

    test('success: getDojangRanking with date', async () => {
      const response = await api.getDojangRanking(undefined, {
        year: 2023,
        month: 12,
        day: 23,
      });
      console.log(toString(response));
    });

    test('fail: getDojangRanking with invalid date', async () => {
      try {
        await api.getDojangRanking(undefined, {
          year: 2023,
          month: 12,
          day: 21,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-22.');
        console.log(error.message);
      }
    });

    test('fail: getDojangRanking with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getDojangRanking({ difficulty: 1, ocid: invalidOcid });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getSeedRanking', () => {
    test('success: getSeedRanking', async () => {
      const response = await api.getSeedRanking();
      console.log(toString(response));
    });

    test('success: getSeedRanking with paging', async () => {
      const response = await api.getSeedRanking({
        page: 2,
      });
      console.log(toString(response));
    });

    test('success: getSeedRanking with ocid', async () => {
      const response = await api.getSeedRanking({
        ocid: ocid,
      });
      expect(response.ranking.length).toBeGreaterThanOrEqual(0);
      console.log(toString(response));
    });

    test('success: getSeedRanking with world name', async () => {
      const response = await api.getSeedRanking({
        worldName: '스카니아',
      });
      expect(response.ranking.length).toBeGreaterThan(0);
      console.log(toString(response));
    });

    test('success: getSeedRanking with date', async () => {
      const response = await api.getSeedRanking(undefined, {
        year: 2023,
        month: 12,
        day: 23,
      });
      console.log(toString(response));
    });

    test('fail: getSeedRanking with invalid date', async () => {
      try {
        await api.getSeedRanking(undefined, {
          year: 2023,
          month: 12,
          day: 21,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-22.');
        console.log(error.message);
      }
    });

    test('fail: getSeedRanking with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getSeedRanking({ ocid: invalidOcid });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getAchievementRanking', () => {
    test('success: getAchievementRanking', async () => {
      const response = await api.getAchievementRanking();
      console.log(toString(response));
    });

    test('success: getAchievementRanking with paging', async () => {
      const response = await api.getAchievementRanking({
        page: 2,
      });
      console.log(toString(response));
    });

    test('success: getAchievementRanking with ocid', async () => {
      const response = await api.getAchievementRanking({
        ocid: ocid,
      });
      expect(response.ranking.length).toBeGreaterThanOrEqual(0);
      console.log(toString(response));
    });

    test('success: getAchievementRanking with date', async () => {
      const response = await api.getAchievementRanking(undefined, {
        year: 2023,
        month: 12,
        day: 23,
      });
      console.log(toString(response));
    });

    test('fail: getAchievementRanking with invalid date', async () => {
      try {
        await api.getAchievementRanking(undefined, {
          year: 2023,
          month: 12,
          day: 21,
        });
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as Error;
        expect(error).toBeInstanceOf(Error);
        expect(error.message).toContain('You can only retrieve data after 2023-12-22.');
        console.log(error.message);
      }
    });

    test('fail: getAchievementRanking with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getAchievementRanking({ ocid: invalidOcid });
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
