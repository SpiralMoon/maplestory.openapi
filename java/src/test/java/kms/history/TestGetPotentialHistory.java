package kms.history;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.history.PotentialHistoryResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

@DisplayName("getPotentialHistory")
public class TestGetPotentialHistory {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getPotentialHistory")
    void getPotentialHistory() {
        int count = 1000;
        PotentialHistoryResponseDTO response = api.getPotentialHistory(count).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getPotentialHistory with date")
    void getPotentialHistory_with_date() {
        int count = 1000;
        LocalDateTime date = LocalDateTime.of(2025, 7, 31, 0, 0);
        PotentialHistoryResponseDTO response = api.getPotentialHistory(count, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getPotentialHistory with cursor")
    void getPotentialHistory_with_cursor() {
        int count = 10;
        LocalDateTime date = LocalDateTime.of(2025, 7, 31, 0, 0);
        PotentialHistoryResponseDTO response = api.getPotentialHistory(count, date).join();
        String nextCursor = response.getNextCursor();
        assertThat(nextCursor).isNotNull();

        PotentialHistoryResponseDTO nextResponse = api.getPotentialHistory(count, nextCursor).join();
        System.out.println(nextResponse.toString());
    }

    @Test
    @DisplayName("fail: getPotentialHistory with invalid date")
    void getPotentialHistory_with_invalid_date() {
        int count = 1000;
        LocalDateTime invalidDate = LocalDateTime.of(2024, 1, 24, 0, 0);
        assertThatThrownBy(() -> api.getPotentialHistory(count, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2024-01-25.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getPotentialHistory with invalid cursor throw OPENAPI00003")
    void getPotentialHistory_with_invalid_cursor() {
        int count = 1000;
        String invalidCursor = "invalid_cursor_123";
        assertThatThrownBy(() -> api.getPotentialHistory(count, invalidCursor).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getPotentialHistory with excessive count throw OPENAPI00004")
    void getPotentialHistory_with_excessive_count() {
        int count = 9999;
        assertThatThrownBy(() -> api.getPotentialHistory(count).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
