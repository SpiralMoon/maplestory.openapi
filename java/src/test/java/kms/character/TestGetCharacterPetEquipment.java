package kms.character;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterPetEquipmentDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterPetEquipment")
public class TestGetCharacterPetEquipment {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getCharacterPetEquipment")
    void getCharacterPetEquipment() {
        CharacterPetEquipmentDTO response = api.getCharacterPetEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterPetEquipment")
    void getCharacterPetEquipment_async() {
        api.getCharacterPetEquipment(ocid).thenAcceptAsync(response -> {
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterPetEquipment with date")
    void getCharacterPetEquipment_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 22, 0, 0);
        CharacterPetEquipmentDTO response = api.getCharacterPetEquipment(ocid, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterPetEquipment on date with no data")
    void getCharacterPetEquipment_on_date_with_no_data() {
        String noDataOcid = "b0187493ec48ddd7b1d304fe8982d0b0";
        LocalDateTime date = LocalDateTime.of(2025, 6, 18, 0, 0);
        CharacterPetEquipmentDTO response = api.getCharacterPetEquipment(noDataOcid, date).join();
        assertThat(response.getDate()).isNotNull();
        assertThat(response.getPet1Name()).isNull();
        assertThat(response.getPet1Nickname()).isNull();
        assertThat(response.getPet1Icon()).isNull();
        assertThat(response.getPet1Description()).isNull();
        assertThat(response.getPet1Equipment()).isNull();
        assertThat(response.getPet1AutoSkill()).isNull();
        assertThat(response.getPet1PetType()).isNull();
        assertThat(response.getPet1Skill()).isEmpty();
        assertThat(response.getPet1DateExpire()).isNull();
        assertThat(response.isPet1Expired()).isNull();
        assertThat(response.getPet1Appearance()).isNull();
        assertThat(response.getPet1AppearanceIcon()).isNull();
        assertThat(response.getPet2Name()).isNull();
        assertThat(response.getPet2Nickname()).isNull();
        assertThat(response.getPet2Icon()).isNull();
        assertThat(response.getPet2Description()).isNull();
        assertThat(response.getPet2Equipment()).isNull();
        assertThat(response.getPet2AutoSkill()).isNull();
        assertThat(response.getPet2PetType()).isNull();
        assertThat(response.getPet2Skill()).isEmpty();
        assertThat(response.getPet2DateExpire()).isNull();
        assertThat(response.isPet2Expired()).isNull();
        assertThat(response.getPet2Appearance()).isNull();
        assertThat(response.getPet2AppearanceIcon()).isNull();
        assertThat(response.getPet3Name()).isNull();
        assertThat(response.getPet3Nickname()).isNull();
        assertThat(response.getPet3Icon()).isNull();
        assertThat(response.getPet3Description()).isNull();
        assertThat(response.getPet3Equipment()).isNull();
        assertThat(response.getPet3AutoSkill()).isNull();
        assertThat(response.getPet3PetType()).isNull();
        assertThat(response.getPet3Skill()).isEmpty();
        assertThat(response.getPet3DateExpire()).isNull();
        assertThat(response.isPet3Expired()).isNull();
        assertThat(response.getPet3Appearance()).isNull();
        assertThat(response.getPet3AppearanceIcon()).isNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getCharacterPetEquipment with invalid ocid throw OPENAPI00003")
    void getCharacterPetEquipment_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getCharacterPetEquipment(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterPetEquipment with invalid date")
    void getCharacterPetEquipment_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 20, 0, 0);
        assertThatThrownBy(() -> api.getCharacterPetEquipment(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-21.");
                    System.out.println(error.getMessage());
                });
    }
}
