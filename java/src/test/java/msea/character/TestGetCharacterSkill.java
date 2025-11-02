package msea.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.msea.MapleStoryApi;
import dev.spiralmoon.maplestory.api.msea.dto.character.CharacterSkillDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterSkill")
public class TestGetCharacterSkill {
    private static final String apiKey = System.getProperty("API_KEY_MSEA"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "caee7cf6ec6cb067c33b899f2779f3d1";

    @Test
    @DisplayName("success: getCharacterSkill with skill grade")
    void getCharacterSkill() {
        String skillGrade = "6";
        CharacterSkillDTO response = api.getCharacterSkill(ocid, skillGrade).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterSkill")
    void getCharacterSkill_async() {
        String skillGrade = "6";
        api.getCharacterSkill(ocid, skillGrade).thenAcceptAsync(response -> {
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterSkill with date")
    void getCharacterSkill_with_date() {
        String skillGrade = "6";
        LocalDateTime date = LocalDateTime.of(2025, 4, 20, 0, 0);
        CharacterSkillDTO response = api.getCharacterSkill(ocid, skillGrade, date).join();
        System.out.println(response.toString());
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
        LocalDateTime invalidDate = LocalDateTime.of(2025, 4, 19, 0, 0);
        assertThatThrownBy(() -> api.getCharacterSkill(ocid, skillGrade, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-04-20.");
                    System.out.println(error.getMessage());
                });
    }
}
