package dev.spiralmoon.maplestory.api.dto.character;

public enum CharacterImageEmotion {
    Default("E00"),
    Wink("E01"),
    Smile("E02"),
    Cry("E03"),
    Angry("E04"),
    Bewildered("E05");

    private final String emotion;

    CharacterImageEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getValue() {
        return emotion;
    }
}
