package kms.character;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterVMatrixDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterVMatrix")
public class TestGetCharacterVMatrix {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getCharacterVMatrix")
    void getCharacterVMatrix() {
        CharacterVMatrixDTO response = api.getCharacterVMatrix(ocid).join();
        // nothing to assert because some characters may not have v matrix
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterVMatrix")
    void getCharacterVMatrix_async() {
        api.getCharacterVMatrix(ocid).thenAcceptAsync(response -> {
            // nothing to assert because some characters may not have v matrix
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterVMatrix with date")
    void getCharacterVMatrix_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 22, 0, 0);
        CharacterVMatrixDTO response = api.getCharacterVMatrix(ocid, date).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterVMatrix on date with no data")
    void getCharacterVMatrix_on_date_with_no_data() {
        String ocid = "b0187493ec48ddd7b1d304fe8982d0b0";
        LocalDateTime date = LocalDateTime.of(2025, 6, 18, 0, 0);
        CharacterVMatrixDTO response = api.getCharacterVMatrix(ocid, date).join();
        assertThat(response).isNull();
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
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 20, 0, 0);
        assertThatThrownBy(() -> api.getCharacterVMatrix(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-21.");
                    System.out.println(error.getMessage());
                });
    }
}
