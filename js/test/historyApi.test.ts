import process from 'process';

import { toString } from './utils';
import { MapleStoryApi } from '../src/maplestory/api/kms/mapleStoryApi';

const apiKey = process.env.API_KEY!; // Your API Key
const api = new MapleStoryApi(apiKey);

describe('확률 정보 조회', () => {
  test('스타포스 강화 결과 조회', async () => {
    const count = 1000;
    const response = await api.getStarforceHistory(count);

    console.log(toString(response));
  });

  test('잠재능력 재설정 이용 결과 조회', async () => {
    const count = 1000;
    const response = await api.getPotentialHistory(count);

    console.log(toString(response));
  });

  test('큐브 사용 결과 조회', async () => {
    const count = 1000;
    const response = await api.getCubeHistory(count);

    console.log(toString(response));
  });
});
