package msea.union;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.msea.MapleStoryApi;
import dev.spiralmoon.maplestory.api.msea.dto.union.UnionRaiderDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getUnionRaider")
public class TestGetUnionRaider {
    private static final String apiKey = System.getProperty("API_KEY_MSEA"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "caee7cf6ec6cb067c33b899f2779f3d1";

    @Test
    @DisplayName("success: getUnionRaider")
    void getUnionRaider() {
        UnionRaiderDTO response = api.getUnionRaider(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getUnionRaider with date")
    void getUnionRaider_with_date() {
        LocalDateTime date = LocalDateTime.of(2025, 4, 20, 0, 0);
        UnionRaiderDTO response = api.getUnionRaider(ocid, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getUnionRaider with invalid date")
    void getUnionRaider_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 4, 19, 0, 0);
        assertThatThrownBy(() -> api.getUnionRaider(ocid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-04-20.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getUnionRaider with invalid ocid throw OPENAPI00003")
    void getUnionRaider_with_invalid_ocid_throw_OPENAPI00003() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getUnionRaider(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
