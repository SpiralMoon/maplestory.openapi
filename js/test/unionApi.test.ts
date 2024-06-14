import process from 'process';

import { MapleStoryApi } from '@src/maplestory/api/mapleStoryApi';

import { toString } from './utils';

const apiKey = process.env.API_KEY!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'e0a4f439e53c369866b55297d2f5f4eb';

describe('유니온 정보 조회', () => {

  test('유니온 정보 조회', async () => {
    const response = await api.getUnion(ocid);

    console.log(toString(response));
  });

  test('유니온 공격대 정보 조회', async () => {
    const response = await api.getUnionRaider(ocid);

    console.log(toString(response));
  });

  test('유니온 아티팩트 정보 조회', async () => {
    const response = await api.getUnionArtifact(ocid);

    console.log(toString(response));
  });
});
