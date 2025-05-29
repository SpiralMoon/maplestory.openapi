import * as process from 'process';

import { toString } from './utils';
import { MapleStoryApi } from '../src/maplestory/api/kms/mapleStoryApi';

const apiKey = process.env.API_KEY!; // Your API Key
const api = new MapleStoryApi(apiKey);

const ocid = 'e0a4f439e53c369866b55297d2f5f4eb';

describe('캐릭터 정보 조회', () => {
  test('캐릭터 식별자(ocid) 조회', async () => {
    const nickname = '아델';
    const response = await api.getCharacter(nickname);

    console.log(toString(response));
  });

  test('캐릭터 목록 조회', async () => {
    const response = await api.getCharacterList();

    console.log(toString(response));
  });

  test('기본 정보 조회', async () => {
    const response = await api.getCharacterBasic(ocid);

    console.log(toString(response));
  });

  test('외형 이미지 조회', async () => {
    const response = await api.getCharacterImage(ocid);

    console.log(toString(response));
  });

  test('인기도 정보 조회', async () => {
    const response = await api.getCharacterPopularity(ocid);

    console.log(toString(response));
  });

  test('종합 능력치 정보 조회', async () => {
    const response = await api.getCharacterStat(ocid);

    console.log(toString(response));
  });

  test('하이퍼스탯 정보 조회', async () => {
    const response = await api.getCharacterHyperStat(ocid);

    console.log(toString(response));
  });

  test('성향 정보 조회', async () => {
    const response = await api.getCharacterPropensity(ocid);

    console.log(toString(response));
  });

  test('어빌리티 정보 조회', async () => {
    const response = await api.getCharacterAbility(ocid);

    console.log(toString(response));
  });

  test('장착 장비 정보 조회 (캐시 장비 제외)', async () => {
    const response = await api.getCharacterItemEquipment(ocid);

    console.log(toString(response));
  });

  test('장착 캐시 장비 정보 조회', async () => {
    const response = await api.getCharacterCashItemEquipment(ocid);

    console.log(toString(response));
  });

  test('장착 심볼 정보 조회', async () => {
    const response = await api.getCharacterSymbolEquipment(ocid);

    console.log(toString(response));
  });

  test('적용 세트 효과 정보 조회', async () => {
    const response = await api.getCharacterSetEffect(ocid);

    console.log(toString(response));
  });

  test('장착 헤어, 성형, 피부 정보 조회', async () => {
    const response = await api.getCharacterBeautyEquipment(ocid);

    console.log(toString(response));
  });

  test('장착 안드로이드 정보 조회', async () => {
    const response = await api.getCharacterAndroidEquipment(ocid);

    console.log(toString(response));
  });

  test('장착 펫 정보 조회', async () => {
    const response = await api.getCharacterPetEquipment(ocid);

    console.log(toString(response));
  });

  test('스킬 정보 조회', async () => {
    const skillGrade = '6';
    const response = await api.getCharacterSkill(ocid, skillGrade);

    console.log(toString(response));
  });

  test('장착 링크 스킬 정보 조회', async () => {
    const response = await api.getCharacterLinkSkill(ocid);

    console.log(toString(response));
  });

  test('V매트릭스 정보 조회', async () => {
    const response = await api.getCharacterVMatrix(ocid);

    console.log(toString(response));
  });

  test('HEXA 코어 정보 조회', async () => {
    const response = await api.getCharacterHexaMatrix(ocid);

    console.log(toString(response));
  });

  test('HEXA 매트릭스 설정 HEXA 스탯 정보 조회', async () => {
    const response = await api.getCharacterHexaMatrixStat(ocid);

    console.log(toString(response));
  });

  test('무릉도장 최고 기록 정보 조회', async () => {
    const response = await api.getCharacterDojang(ocid);

    console.log(toString(response));
  });
});
