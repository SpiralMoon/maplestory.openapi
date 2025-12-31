package tms.union;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.tms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.tms.dto.union.UnionChampionDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getUnionChampion")
public class TestGetUnionChampion {
    private static final String apiKey = System.getProperty("API_KEY_TMS"); // Your API Key
    private static final dev.spiralmoon.maplestory.api.tms.MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "ab918948538b1b79046df133fff52092";

    @Test
    @DisplayName("success: getUnionChampion")
    void getUnionChampion() {
        UnionChampionDTO response = api.getUnionChampion(ocid).join();
        // nothing to assert because some characters may not have union champion
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getUnionChampion with date")
    void getUnionChampion_with_date() {
        LocalDateTime date = LocalDateTime.of(2025, 12, 19, 0, 0);
        UnionChampionDTO response = api.getUnionChampion(ocid, date).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getUnionChampion with invalid date")
    void getUnionChampion_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 12, 17, 0, 0);
        assertThatThrownBy(() -> api.getUnionChampion(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-12-18.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getUnionChampion with invalid ocid throw OPENAPI00003")
    void getUnionChampion_with_invalid_ocid_throw_OPENAPI00003() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getUnionChampion(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
