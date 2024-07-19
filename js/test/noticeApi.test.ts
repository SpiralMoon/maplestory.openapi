import process from 'process';

import { MapleStoryApi } from '@src/maplestory/api/mapleStoryApi';

import { toString } from './utils';

const apiKey = process.env.API_KEY!; // Your API Key
const api = new MapleStoryApi(apiKey);

describe('공지 정보 조회', () => {

  test('공지사항 목록 조회', async () => {
    const response = await api.getNoticeList();

    console.log(toString(response));
  });

  test('공지사항 상세 조회', async () => {
    const { notice } = await api.getNoticeList();

    if (notice.length === 0) {
      throw Error('Notice muse be not empty.');
    }

    const { noticeId } = notice[0];
    const response = await api.getNoticeDetail(noticeId);

    console.log(toString(response));
  });

  test('업데이트 목록 조회', async () => {
    const response = await api.getUpdateNoticeList();

    console.log(toString(response));
  });

  test('업데이트 상세 조회', async () => {
    const { updateNotice } = await api.getUpdateNoticeList();

    if (updateNotice.length === 0) {
      throw Error('Notice muse be not empty.');
    }

    const { noticeId } = updateNotice[0];
    const response = await api.getUpdateNoticeDetail(noticeId);

    console.log(toString(response));
  });

  test('진행 중 이벤트 목록 조회', async () => {
    const response = await api.getEventNoticeList();

    console.log(toString(response));
  });

  test('진행 중 이벤트 상세 조회', async () => {
    const { eventNotice } = await api.getEventNoticeList();

    if (eventNotice.length === 0) {
      throw Error('Notice muse be not empty.');
    }

    const { noticeId } = eventNotice[0];
    const response = await api.getEventNoticeDetail(noticeId);

    console.log(toString(response));
  });

  test('캐시샵 공지 목록 조회', async () => {
    const response = await api.getCashshopNoticeList();

    console.log(toString(response));
  });

  test('캐시샵 공지 상세 조회', async () => {
    const { cashshopNotice } = await api.getCashshopNoticeList();

    if (cashshopNotice.length === 0) {
      throw Error('Notice muse be not empty.');
    }

    const { noticeId } = cashshopNotice[0];
    const response = await api.getCashshopNoticeDetail(noticeId);

    console.log(toString(response));
  });
});
