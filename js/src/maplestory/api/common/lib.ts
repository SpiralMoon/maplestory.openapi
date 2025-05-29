import { PotentialOptionGrade } from './enum/potentialOptionGrade';

type PotentialOptionGradeKeys = '레어' | '에픽' | '유니크' | '레전드리';

/**
 * 한글로 정의된 잠재옵션 등급을 PotentialOptionGrade으로 변환합니다.
 *
 * @param text support only "레어", "에픽", "유니크", "레전드리"
 */
export const potentialOptionGradeFromString = (
  text: string,
): PotentialOptionGrade => {
  const potentialOptionGradeMap: {
    [key in PotentialOptionGradeKeys]: PotentialOptionGrade;
  } = {
    레어: PotentialOptionGrade.RARE,
    에픽: PotentialOptionGrade.EPIC,
    유니크: PotentialOptionGrade.UNIQUE,
    레전드리: PotentialOptionGrade.LEGENDARY,
  };

  const grade = potentialOptionGradeMap[text as PotentialOptionGradeKeys];

  if (!grade) {
    throw new TypeError('No enum constant for string: ' + text);
  }

  return grade;
};
