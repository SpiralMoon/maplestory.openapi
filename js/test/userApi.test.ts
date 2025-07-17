import * as process from 'process';

import { toString } from './utils';
import { MapleStoryApi } from '../src/maplestory/api/kms/mapleStoryApi';

const apiKey = process.env.API_KEY! // Your API Key
const api = new MapleStoryApi(apiKey);

describe('계정 정보 조회', () => {
  test('업적 정보 조회', async () => {
    const response = await api.getAchievement();

    console.log(toString(response));
  });
});
