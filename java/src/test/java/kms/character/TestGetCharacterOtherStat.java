package kms.character;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterOtherStatDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterOtherStat")
public class TestGetCharacterOtherStat {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getCharacterOtherStat")
    void getCharacterOtherStat() {
        CharacterOtherStatDTO response = api.getCharacterOtherStat(ocid).join();
        // nothing to assert because some characters may not have other stats
        if (response != null) {
            System.out.println(response.toString());
        }
    }

    @Test
    @DisplayName("success: async getCharacterOtherStat")
    void getCharacterOtherStat_async() {
        api.getCharacterOtherStat(ocid).thenAcceptAsync(response -> {
            // nothing to assert because some characters may not have other stats
            if (response != null) {
                System.out.println(response.toString());
            }
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterOtherStat with date")
    void getCharacterOtherStat_with_date() {
        String ocid = "2e4c361fa884731a4c7984eb88127015";
        LocalDateTime date = LocalDateTime.of(2025, 8, 21, 0, 0);
        CharacterOtherStatDTO response = api.getCharacterOtherStat(ocid, date).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterOtherStat on date with no data")
    void getCharacterOtherStat_on_date_with_no_data() {
        String ocid = "b0187493ec48ddd7b1d304fe8982d0b0";
        LocalDateTime date = LocalDateTime.of(2025, 8, 21, 0, 0);
        CharacterOtherStatDTO response = api.getCharacterOtherStat(ocid, date).join();
        assertThat(response).isNull();
    }

    @Test
    @DisplayName("fail: getCharacterOtherStat with invalid ocid throw OPENAPI00003")
    void getCharacterOtherStat_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getCharacterOtherStat(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterOtherStat with invalid date")
    void getCharacterOtherStat_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 8, 20, 0, 0);
        assertThatThrownBy(() -> api.getCharacterOtherStat(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-08-21.");
                    System.out.println(error.getMessage());
                });
    }
}
