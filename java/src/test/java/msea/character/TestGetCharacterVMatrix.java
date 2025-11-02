package msea.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.msea.MapleStoryApi;
import dev.spiralmoon.maplestory.api.msea.dto.character.CharacterVMatrixDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterVMatrix")
public class TestGetCharacterVMatrix {
    private static final String apiKey = System.getProperty("API_KEY_MSEA"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "caee7cf6ec6cb067c33b899f2779f3d1";

    @Test
    @DisplayName("success: getCharacterVMatrix")
    void getCharacterVMatrix() {
        CharacterVMatrixDTO response = api.getCharacterVMatrix(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterVMatrix")
    void getCharacterVMatrix_async() {
        api.getCharacterVMatrix(ocid).thenAcceptAsync(response -> {
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterVMatrix with date")
    void getCharacterVMatrix_with_date() {
        LocalDateTime date = LocalDateTime.of(2025, 4, 20, 0, 0);
        CharacterVMatrixDTO response = api.getCharacterVMatrix(ocid, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getCharacterVMatrix with invalid ocid throw OPENAPI00003")
    void getCharacterVMatrix_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getCharacterVMatrix(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterVMatrix with invalid date")
    void getCharacterVMatrix_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 4, 19, 0, 0);
        assertThatThrownBy(() -> api.getCharacterVMatrix(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-04-20.");
                    System.out.println(error.getMessage());
                });
    }
}
