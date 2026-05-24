package kms.battlepractice;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.battlepractice.BattlePracticeResultDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getBattlePracticeResult")
public class TestGetBattlePracticeResult {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String replayId = "8ac5ac350d67765e4c49db94cc61f83d";

    @Test
    @DisplayName("success: getBattlePracticeResult")
    void getBattlePracticeResult() {
        BattlePracticeResultDTO response = api.getBattlePracticeResult(replayId).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getBattlePracticeResult with invalid replay_id")
    void getBattlePracticeResult_with_invalid_replay_id() {
        String invalidReplayId = "invalid_replay_id_123";
        assertThatThrownBy(() -> api.getBattlePracticeResult(invalidReplayId).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
