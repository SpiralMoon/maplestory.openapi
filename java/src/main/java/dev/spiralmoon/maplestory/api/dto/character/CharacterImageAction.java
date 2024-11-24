package dev.spiralmoon.maplestory.api.dto.character;

public enum CharacterImageAction {
    Stand1("A00"),
    Stand2("A01"),
    Walk1("A02"),
    Walk2("A03"),
    Prone("A04"),
    Fly("A05"),
    Jump("A06"),
    Sit("A07");

    private final String action;

    CharacterImageAction(String action) {
        this.action = action;
    }

    public String getValue() {
        return action;
    }
}
