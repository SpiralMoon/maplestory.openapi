package dev.spiralmoon.maplestory.api.dto;

import lombok.Getter;

@Getter
public enum PotentialOptionGrade {

    RARE("레어"),
    EPIC("에픽"),
    UNIQUE("유니크"),
    LEGENDARY("레전드리");

    private final String grade;

    PotentialOptionGrade (String grade) {
        this.grade = grade;
    }

    /**
     * 한글로 정의된 잠재옵션 등급을 PotentialOptionGrade으로 변환합니다.
     *
     * @param text support only "레어", "에픽", "유니크", "레전드리"
     */
    public static PotentialOptionGrade fromString(String text) {
        for (PotentialOptionGrade grade : PotentialOptionGrade.values()) {
            if (grade.grade.equals(text)) {
                return grade;
            }
        }

        throw new IllegalArgumentException("No enum constant for string: " + text);
    }
}
