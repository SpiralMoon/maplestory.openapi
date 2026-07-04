package kms.scheduler;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.scheduler.SchedulerCharacterStateDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getSchedulerCharacterState")
public class TestGetSchedulerCharacterState {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getSchedulerCharacterState")
    void getSchedulerCharacterState() {
        String ocid = api.getCharacterList().join().getAccountList().get(0).getCharacterList().get(0).getOcid();
        SchedulerCharacterStateDTO response = api.getSchedulerCharacterState(ocid).join();
        System.out.println(response != null ? response.toString() : "null");
    }

    @Test
    @DisplayName("fail: getSchedulerCharacterState with invalid ocid throw OPENAPI00003")
    void getSchedulerCharacterState_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getSchedulerCharacterState(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("success: getSchedulerCharacterState within the 14-day window")
    void getSchedulerCharacterState_within_window() {
        String ocid = api.getCharacterList().join().getAccountList().get(0).getCharacterList().get(0).getOcid();
        LocalDateTime date = LocalDateTime.now(ZoneId.of("Asia/Seoul")).minusDays(13);
        SchedulerCharacterStateDTO response = api.getSchedulerCharacterState(ocid, date).join();
        System.out.println(response != null ? response.toString() : "null");
    }

    @Test
    @DisplayName("fail: getSchedulerCharacterState outside the 14-day window throw OPENAPI00004")
    void getSchedulerCharacterState_outside_window() {
        String ocid = api.getCharacterList().join().getAccountList().get(0).getCharacterList().get(0).getOcid();
        LocalDateTime date = LocalDateTime.now(ZoneId.of("Asia/Seoul")).minusDays(14);
        assertThatThrownBy(() -> api.getSchedulerCharacterState(ocid, date).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
