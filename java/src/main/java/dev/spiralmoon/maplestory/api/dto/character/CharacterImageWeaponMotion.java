package dev.spiralmoon.maplestory.api.dto.character;

public enum CharacterImageWeaponMotion {
    Default("W00"),
    OneHand("W01"),
    TwoHands("W02"),
    Gun("W03");

    private final String wmotion;

    CharacterImageWeaponMotion(String wmotion) {
        this.wmotion = wmotion;
    }

    public String getValue() {
        return wmotion;
    }
}
