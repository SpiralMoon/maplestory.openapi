package kms.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterBasicDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterBasic")
public class TestGetCharacterBasic {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getCharacterBasic")
    void getCharacterBasic() {
        CharacterBasicDTO response = api.getCharacterBasic(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterBasic")
    void getCharacterBasic_async() {
        api.getCharacterBasic(ocid).thenAcceptAsync(response -> {
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterBasic with date")
    void getCharacterBasic_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 22, 0, 0);
        CharacterBasicDTO response = api.getCharacterBasic(ocid, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterBasic on date with no data")
    void getCharacterBasic_on_date_with_no_data() {
        String ocid = "b0187493ec48ddd7b1d304fe8982d0b0";
        LocalDateTime date = LocalDateTime.of(2025, 6, 18, 0, 0);
        CharacterBasicDTO response = api.getCharacterBasic(ocid, date).join();
        assertThat(response.getDate()).isNotNull();
        assertThat(response.getCharacterName()).isNull();
        assertThat(response.getWorldName()).isNull();
        assertThat(response.getCharacterGender()).isNull();
        assertThat(response.getCharacterClass()).isNull();
        assertThat(response.getCharacterClassLevel()).isNull();
        assertThat(response.getCharacterLevel()).isEqualTo(0);
        assertThat(response.getCharacterExp()).isEqualTo(0);
        assertThat(response.getCharacterExpRate()).isNull();
        assertThat(response.getCharacterGuildName()).isNull();
        assertThat(response.getCharacterImage()).isNull();
        assertThat(response.getCharacterDateCreate()).isNull();
        assertThat(response.getAccessFlag()).isNull();
        assertThat(response.getLiberationQuestClear()).isNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getCharacterBasic with invalid ocid throw OPENAPI00003")
    void getCharacterBasic_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123_";
        assertThatThrownBy(() -> api.getCharacterBasic(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterBasic with invalid date")
    void getCharacterBasic_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 20, 0, 0);
        assertThatThrownBy(() -> api.getCharacterBasic(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-21.");
                    System.out.println(error.getMessage());
                });
    }
}
