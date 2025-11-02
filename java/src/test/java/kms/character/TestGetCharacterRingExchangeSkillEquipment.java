package kms.character;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterRingExchangeSkillEquipmentDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterRingExchangeSkillEquipment")
public class TestGetCharacterRingExchangeSkillEquipment {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getCharacterRingExchangeSkillEquipment")
    void getCharacterRingExchangeSkillEquipment() {
        CharacterRingExchangeSkillEquipmentDTO response = api.getCharacterRingExchangeSkillEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterRingExchangeSkillEquipment")
    void getCharacterRingExchangeSkillEquipment_async() {
        api.getCharacterRingExchangeSkillEquipment(ocid).thenAcceptAsync(response -> {
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterRingExchangeSkillEquipment with date")
    void getCharacterRingExchangeSkillEquipment_with_date() {
        LocalDateTime date = LocalDateTime.of(2025, 8, 21, 0, 0);
        CharacterRingExchangeSkillEquipmentDTO response = api.getCharacterRingExchangeSkillEquipment(ocid, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterRingExchangeSkillEquipment on date with no data")
    void getCharacterRingExchangeSkillEquipment_on_date_with_no_data() {
        String noDataOcid = "b0187493ec48ddd7b1d304fe8982d0b0";
        LocalDateTime date = LocalDateTime.of(2025, 8, 21, 0, 0);
        CharacterRingExchangeSkillEquipmentDTO response = api.getCharacterRingExchangeSkillEquipment(noDataOcid, date).join();
        assertThat(response.getDate()).isNotNull();
        assertThat(response.getCharacterClass()).isNull();
        assertThat(response.getSpecialRingExchangeName()).isNull();
        assertThat(response.getSpecialRingExchangeLevel()).isNull();
        assertThat(response.getSpecialRingExchangeIcon()).isNull();
        assertThat(response.getSpecialRingExchangeDescription()).isNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getCharacterRingExchangeSkillEquipment with invalid ocid throw OPENAPI00003")
    void getCharacterRingExchangeSkillEquipment_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getCharacterRingExchangeSkillEquipment(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterRingExchangeSkillEquipment with invalid date")
    void getCharacterRingExchangeSkillEquipment_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 8, 20, 0, 0);
        assertThatThrownBy(() -> api.getCharacterRingExchangeSkillEquipment(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-08-21.");
                    System.out.println(error.getMessage());
                });
    }
}
