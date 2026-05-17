import * as process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'e0a4f439e53c369866b55297d2f5f4eb';
const replayId = '8ac5ac350d67765e4c49db94cc61f83d';

describe('Battle Practice Information Retrieval', () => {
  describe('getBattlePracticeReplayId', () => {
    test('success: getBattlePracticeReplayId', async () => {
      const response = await api.getBattlePracticeReplayId(ocid);
      expect(response).toBeDefined();
      expect(response.replayList).toBeDefined();
      console.log(toString(response));
    });

    test('fail: getBattlePracticeReplayId with invalid ocid throw OPENAPI00003', async () => {
      const invalidOcid = 'invalid_ocid_123';
      try {
        await api.getBattlePracticeReplayId(invalidOcid);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00003);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getBattlePracticeResult', () => {
    test('success: getBattlePracticeResult', async () => {
      const response = await api.getBattlePracticeResult(replayId);
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('fail: getBattlePracticeResult with invalid replay_id', async () => {
      const invalidReplayId = 'invalid_replay_id_123';
      try {
        await api.getBattlePracticeResult(invalidReplayId);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getBattlePracticeSkillTimeline', () => {
    test('success: getBattlePracticeSkillTimeline (default page)', async () => {
      const response = await api.getBattlePracticeSkillTimeline(replayId);
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('success: getBattlePracticeSkillTimeline with pageNo', async () => {
      const response = await api.getBattlePracticeSkillTimeline(replayId, 1);
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('fail: getBattlePracticeSkillTimeline with invalid replay_id', async () => {
      const invalidReplayId = 'invalid_replay_id_123';
      try {
        await api.getBattlePracticeSkillTimeline(invalidReplayId);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getBattlePracticeCharacterInfo', () => {
    test('success: getBattlePracticeCharacterInfo', async () => {
      const response = await api.getBattlePracticeCharacterInfo(replayId);
      expect(response).toBeDefined();
      console.log(toString(response));
    });

    test('fail: getBattlePracticeCharacterInfo with invalid replay_id', async () => {
      const invalidReplayId = 'invalid_replay_id_123';
      try {
        await api.getBattlePracticeCharacterInfo(invalidReplayId);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        console.log(error.errorCode, error.message);
      }
    });
  });
});
