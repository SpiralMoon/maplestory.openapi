import * as process from 'process';

import { MapleStoryApi } from '../../src/maplestory/api/kms';
import { toString } from '../utils';

const apiKey = process.env.API_KEY_KMS!;
const api = new MapleStoryApi(apiKey);

describe('User Information Retrieval', () => {
  test('success: getCharacterList', async () => {
    const response = await api.getCharacterList();
    expect(response).toBeDefined();
    console.log(toString(response));
  });

  test('success: getAchievement', async () => {
    const response = await api.getAchievement();
    expect(response).toBeDefined();
    console.log(toString(response));
  });
});
