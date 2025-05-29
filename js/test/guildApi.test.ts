import process from 'process';

import { toString } from './utils';
import { MapleStoryApi } from '../src/maplestory/api/kms/mapleStoryApi';

const apiKey = process.env.API_KEY!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ogid = 'f5992063d46d6f8718e514fca5428960';

describe('길드 정보 조회', () => {
  test('길드 식별자(oguild_id) 정보 조회', async () => {
    const guildName = '붕붕';
    const worldName = '크로아';
    const response = await api.getGuild(guildName, worldName);

    console.log(toString(response));
  });

  test('기본 정보 조회', async () => {
    const response = await api.getGuildBasic(ogid);

    console.log(toString(response));
  });
});
