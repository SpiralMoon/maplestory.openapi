import process from 'process';

import { MapleStoryApiError, MapleStoryApiErrorCode } from '../../src';
import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!; // Your API Key
const api = new MapleStoryApi(apiKey);

describe('Notice Information Retrieval', () => {
  describe('getNoticeList', () => {
    test('success: getNoticeList', async () => {
      const response = await api.getNoticeList();
      console.log(toString(response));
    });
  });

  describe('getNoticeDetail', () => {
    test('success: getNoticeDetail', async () => {
      const { notice } = await api.getNoticeList();

      if (notice.length === 0) {
        throw Error('Notice muse be not empty.');
      }

      const { noticeId } = notice[0];
      const response = await api.getNoticeDetail(noticeId);

      console.log(toString(response));
    });

    test('fail: getNoticeDetail with invalid notice id throw OPENAPI00004', async () => {
      const invalidNoticeId = -1;
      try {
        await api.getNoticeDetail(invalidNoticeId);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00004);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getUpdateNoticeList', () => {
    test('success: getUpdateNoticeList', async () => {
      const response = await api.getUpdateNoticeList();
      console.log(toString(response));
    });
  });

  describe('getUpdateNoticeDetail', () => {
    test('success: getUpdateNoticeDetail', async () => {
      const { updateNotice } = await api.getUpdateNoticeList();

      if (updateNotice.length === 0) {
        throw Error('Notice muse be not empty.');
      }

      const { noticeId } = updateNotice[0];
      const response = await api.getUpdateNoticeDetail(noticeId);

      console.log(toString(response));
    });

    test('fail: getUpdateNoticeDetail with invalid notice id throw OPENAPI00004', async () => {
      const invalidNoticeId = -1;
      try {
        await api.getUpdateNoticeDetail(invalidNoticeId);
        fail('An error should have been thrown.');
      } catch (e) {
        const error = e as MapleStoryApiError;
        expect(error).toBeInstanceOf(MapleStoryApiError);
        expect(error.errorCode).toBe(MapleStoryApiErrorCode.OPENAPI00004);
        console.log(error.errorCode, error.message);
      }
    });
  });

  describe('getEventNoticeList', () => {
    test('success: getEventNoticeList', async () => {
      const response = await api.getEventNoticeList();
      console.log(toString(response));
    });
  });

  describe('getEventNoticeDetail', () => {
    test('success: getEventNoticeDetail', async () => {
      const { eventNotice } = await api.getEventNoticeList();

      if (eventNotice.length === 0) {
        throw Error('Notice muse be not empty.');
      }

      const { noticeId } = eventNotice[0];
      const response = await api.getEventNoticeDetail(noticeId);

      console.log(toString(response));
    });

    test('fail: getEventNoticeDetail with invalid notice id throw OPENAPI00004', async () => {
      const invalidNoticeId = -1;
      try {
        await api.getEventNoticeDetail(invalidNoticeId);
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
