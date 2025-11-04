package kms.history;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.history.StarforceHistoryResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

@DisplayName("getStarforceHistory")
public class TestGetStarforceHistory {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getStarforceHistory")
    void getStarforceHistory() {
        int count = 1000;
        StarforceHistoryResponseDTO response = api.getStarforceHistory(count).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getStarforceHistory with date")
    void getStarforceHistory_with_date() {
        int count = 1000;
        LocalDateTime date = LocalDateTime.of(2025, 9, 21, 0, 0);
        StarforceHistoryResponseDTO response = api.getStarforceHistory(count, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getStarforceHistory with cursor")
    void getStarforceHistory_with_cursor() {
        int count = 10;
        LocalDateTime date = LocalDateTime.of(2025, 9, 21, 0, 0);
        StarforceHistoryResponseDTO response = api.getStarforceHistory(count, date).join();
        String nextCursor = response.getNextCursor(); // 결과가 count 보다 많은 경우에만 nextCursor가 반환 됩니다.
        assertThat(nextCursor).isNotNull();
        StarforceHistoryResponseDTO nextResponse = api.getStarforceHistory(count, nextCursor).join();
        System.out.println(nextResponse.toString());
    }

    @Test
    @DisplayName("fail: getStarforceHistory with invalid date")
    void getStarforceHistory_with_invalid_date() {
        int count = 1000;
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 26, 0, 0);
        assertThatThrownBy(() -> api.getStarforceHistory(count, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-27.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getStarforceHistory with invalid cursor throw OPENAPI00003")
    void getStarforceHistory_with_invalid_cursor() {
        int count = 1000;
        String invalidCursor = "invalid_cursor_123";
        assertThatThrownBy(() -> api.getStarforceHistory(count, invalidCursor).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getStarforceHistory with excessive count throw OPENAPI00004")
    void getStarforceHistory_with_excessive_count() {
        int count = 9999;
        assertThatThrownBy(() -> api.getStarforceHistory(count).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
