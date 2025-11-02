package kms.character;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterCashItemEquipmentDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterCashItemEquipment")
public class TestGetCharacterCashItemEquipment {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

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
        LocalDateTime date = LocalDateTime.of(2023, 12, 22, 0, 0);
        CharacterCashItemEquipmentDTO response = api.getCharacterCashItemEquipment(ocid, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterCashItemEquipment on date with no data")
    void getCharacterCashItemEquipment_on_date_with_no_data() {
        String noDataOcid = "b0187493ec48ddd7b1d304fe8982d0b0";
        LocalDateTime date = LocalDateTime.of(2025, 6, 18, 0, 0);
        CharacterCashItemEquipmentDTO response = api.getCharacterCashItemEquipment(noDataOcid, date).join();
        assertThat(response.getDate()).isNotNull();
        assertThat(response.getCharacterGender()).isNull();
        assertThat(response.getCharacterClass()).isNull();
        assertThat(response.getCharacterLookMode()).isNull();
        assertThat(response.getPresetNo()).isNull();
        assertThat(response.getCashItemEquipmentBase()).isEmpty();
        assertThat(response.getCashItemEquipmentPreset1()).isEmpty();
        assertThat(response.getCashItemEquipmentPreset2()).isEmpty();
        assertThat(response.getCashItemEquipmentPreset3()).isEmpty();
        assertThat(response.getAdditionalCashItemEquipmentBase()).isEmpty();
        assertThat(response.getAdditionalCashItemEquipmentPreset1()).isEmpty();
        assertThat(response.getAdditionalCashItemEquipmentPreset2()).isEmpty();
        assertThat(response.getAdditionalCashItemEquipmentPreset3()).isEmpty();
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
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 20, 0, 0);
        assertThatThrownBy(() -> api.getCharacterCashItemEquipment(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-21.");
                    System.out.println(error.getMessage());
                });
    }
}
