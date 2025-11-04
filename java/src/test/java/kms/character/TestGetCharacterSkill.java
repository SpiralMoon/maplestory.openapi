package kms.character;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterSkillDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterSkill")
public class TestGetCharacterSkill {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getCharacterSkill with skill grade")
    void getCharacterSkill() {
        String skillGrade = "6";
        CharacterSkillDTO response = api.getCharacterSkill(ocid, skillGrade).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterSkill")
    void getCharacterSkill_async() {
        String skillGrade = "6";
        api.getCharacterSkill(ocid, skillGrade).thenAcceptAsync(response -> {
            assertThat(response).isNotNull();
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterSkill with date")
    void getCharacterSkill_with_date() {
        String skillGrade = "6";
        LocalDateTime date = LocalDateTime.of(2023, 12, 22, 0, 0);
        CharacterSkillDTO response = api.getCharacterSkill(ocid, skillGrade, date).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterSkill with has no skill grade")
    void getCharacterSkill_with_has_no_skill_grade() {
        String ocid = "c0ee173596c89da990c6fae8106e62f0"; // This character is 2nd job
        String skillGrade = "hyperactive";
        CharacterSkillDTO response = api.getCharacterSkill(ocid, skillGrade).join();
        assertThat(response).isNotNull();
        assertThat(response.getCharacterSkillGrade()).isNull();
        assertThat(response.getCharacterSkill().size()).isEqualTo(0);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterSkill on date with no data")
    void getCharacterSkill_on_date_with_no_data() {
        String ocid = "b0187493ec48ddd7b1d304fe8982d0b0";
        String skillGrade = "6";
        LocalDateTime date = LocalDateTime.of(2025, 6, 18, 0, 0);
        CharacterSkillDTO response = api.getCharacterSkill(ocid, skillGrade, date).join();
        assertThat(response).isNull();
    }

    @Test
    @DisplayName("fail: getCharacterSkill with invalid ocid throw OPENAPI00003")
    void getCharacterSkill_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        String skillGrade = "6";
        assertThatThrownBy(() -> api.getCharacterSkill(invalidOcid, skillGrade).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterSkill with invalid date")
    void getCharacterSkill_with_invalid_date() {
        String skillGrade = "6";
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 20, 0, 0);
        assertThatThrownBy(() -> api.getCharacterSkill(ocid, skillGrade, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-21.");
                    System.out.println(error.getMessage());
                });
    }
}
