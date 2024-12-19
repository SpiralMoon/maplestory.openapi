package dev.spiralmoon.maplestory.api.dto.character;

public enum CharacterImageEmotion {
    Default("E00"),
    Wink("E01"),
    Smile("E02"),
    Cry("E03"),
    Angry("E04"),
    Bewildered("E05"),
    Blink("E06"),
    Blaze("E07"),
    Bowing("E08"),
    Cheers("E09"),
    Chu("E10"),
    Dam("E11"),
    Despair("E12"),
    Glitter("E13"),
    Hit("E14"),
    Hot("E15"),
    Hum("E16"),
    Love("E17"),
    Oops("E18"),
    Pain("E19"),
    Troubled("E20"),
    QBlue("E21"),
    Shine("E22"),
    Stunned("E23"),
    Vomit("E24");

    private final String emotion;

    CharacterImageEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getValue() {
        return emotion;
    }
}
