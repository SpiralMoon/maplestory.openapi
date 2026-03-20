package kms.character;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterRingReserveSkillEquipmentDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterRingReserveSkillEquipment")
public class TestGetCharacterRingReserveSkillEquipment {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getCharacterRingReserveSkillEquipment")
    void getCharacterRingReserveSkillEquipment() {
        CharacterRingReserveSkillEquipmentDTO response = api.getCharacterRingReserveSkillEquipment(ocid).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterRingReserveSkillEquipment")
    void getCharacterRingReserveSkillEquipment_async() {
        api.getCharacterRingReserveSkillEquipment(ocid).thenAcceptAsync(response -> {
            assertThat(response).isNotNull();
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterRingReserveSkillEquipment with date")
    void getCharacterRingReserveSkillEquipment_with_date() {
        LocalDateTime date = LocalDateTime.of(2026, 3, 19, 0, 0);
        CharacterRingReserveSkillEquipmentDTO response = api.getCharacterRingReserveSkillEquipment(ocid, date).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterRingReserveSkillEquipment on date with no data")
    void getCharacterRingReserveSkillEquipment_on_date_with_no_data() {
        String ocid = "b0187493ec48ddd7b1d304fe8982d0b0";
        LocalDateTime date = LocalDateTime.of(2026, 3, 19, 0, 0);
        CharacterRingReserveSkillEquipmentDTO response = api.getCharacterRingReserveSkillEquipment(ocid, date).join();
        assertThat(response).isNull();
    }

    @Test
    @DisplayName("fail: getCharacterRingReserveSkillEquipment with invalid ocid throw OPENAPI00003")
    void getCharacterRingReserveSkillEquipment_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getCharacterRingReserveSkillEquipment(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterRingReserveSkillEquipment with invalid date")
    void getCharacterRingReserveSkillEquipment_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2026, 3, 18, 0, 0);
        assertThatThrownBy(() -> api.getCharacterRingReserveSkillEquipment(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2026-03-19.");
                    System.out.println(error.getMessage());
                });
    }
}
