import process from 'process';

import { toString } from './utils';
import { MapleStoryApi } from '../src/maplestory/api/mapleStoryApi';

const apiKey = process.env.API_KEY!; // Your API Key
const api = new MapleStoryApi(apiKey);

describe('랭킹 정보 조회', () => {
  test('종합 랭킹 정보 조회', async () => {
    const response = await api.getOverallRanking();

    console.log(toString(response));
  });

  test('유니온 랭킹 정보 조회', async () => {
    const response = await api.getUnionRanking();

    console.log(toString(response));
  });

  test('길드 랭킹 정보 조회', async () => {
    const response = await api.getGuildRanking();

    console.log(toString(response));
  });

  test('무릉도장 랭킹 정보 조회', async () => {
    const response = await api.getDojangRanking();

    console.log(toString(response));
  });

  test('더 시드 랭킹 정보 조회', async () => {
    const response = await api.getSeedRanking();

    console.log(toString(response));
  });

  test('업적 랭킹 정보 조회', async () => {
    const response = await api.getAchievementRanking();

    console.log(toString(response));
  });
});
