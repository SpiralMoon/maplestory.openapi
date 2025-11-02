package tms.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.tms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.tms.dto.character.CharacterCashItemEquipmentDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterCashItemEquipment")
public class TestGetCharacterCashItemEquipment {
    private static final String apiKey = System.getProperty("API_KEY_TMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "ab918948538b1b79046df133fff52092";

    @Test
    @DisplayName("success: getCharacterCashItemEquipment")
    void getCharacterCashItemEquipment() {
        CharacterCashItemEquipmentDTO response = api.getCharacterCashItemEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterCashItemEquipment")
    void getCharacterCashItemEquipment_async() {
        api.getCharacterCashItemEquipment(ocid).thenAcceptAsync(response -> {
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterCashItemEquipment with date")
    void getCharacterCashItemEquipment_with_date() {
        LocalDateTime date = LocalDateTime.of(2025, 10, 15, 0, 0);
        CharacterCashItemEquipmentDTO response = api.getCharacterCashItemEquipment(ocid, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getCharacterCashItemEquipment with invalid ocid throw OPENAPI00003")
    void getCharacterCashItemEquipment_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getCharacterCashItemEquipment(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterCashItemEquipment with invalid date")
    void getCharacterCashItemEquipment_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 10, 14, 0, 0);
        assertThatThrownBy(() -> api.getCharacterCashItemEquipment(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-10-15.");
                    System.out.println(error.getMessage());
                });
    }
}
