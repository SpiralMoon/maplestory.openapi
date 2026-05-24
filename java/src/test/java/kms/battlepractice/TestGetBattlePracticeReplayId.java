package kms.battlepractice;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.battlepractice.BattlePracticeReplayIdDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getBattlePracticeReplayId")
public class TestGetBattlePracticeReplayId {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getBattlePracticeReplayId")
    void getBattlePracticeReplayId() {
        BattlePracticeReplayIdDTO response = api.getBattlePracticeReplayId(ocid).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getBattlePracticeReplayId with invalid ocid throw OPENAPI00003")
    void getBattlePracticeReplayId_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123";
        assertThatThrownBy(() -> api.getBattlePracticeReplayId(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
