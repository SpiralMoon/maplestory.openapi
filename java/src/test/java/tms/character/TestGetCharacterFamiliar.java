package tms.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.tms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.tms.dto.character.CharacterFamiliarDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterFamiliar")
public class TestGetCharacterFamiliar {
    private static final String apiKey = System.getProperty("API_KEY_TMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "ab918948538b1b79046df133fff52092";

    @Test
    @DisplayName("success: getCharacterFamiliar")
    void getCharacterFamiliar() {
        CharacterFamiliarDTO response = api.getCharacterFamiliar(ocid).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterFamiliar")
    void getCharacterFamiliar_async() {
        api.getCharacterFamiliar(ocid).thenAcceptAsync(response -> {
            assertThat(response).isNotNull();
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("fail: getCharacterFamiliar with invalid ocid throw OPENAPI00003")
    void getCharacterFamiliar_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getCharacterFamiliar(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterFamiliar with invalid date")
    void getCharacterFamiliar_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 10, 14, 0, 0);
        assertThatThrownBy(() -> api.getCharacterFamiliar(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-10-15.");
                    System.out.println(error.getMessage());
                });
    }
}
