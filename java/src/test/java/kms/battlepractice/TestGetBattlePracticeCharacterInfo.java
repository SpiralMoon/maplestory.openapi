package kms.battlepractice;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.battlepractice.BattlePracticeCharacterInfoDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getBattlePracticeCharacterInfo")
public class TestGetBattlePracticeCharacterInfo {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String replayId = "8ac5ac350d67765e4c49db94cc61f83d";

    @Test
    @DisplayName("success: getBattlePracticeCharacterInfo")
    void getBattlePracticeCharacterInfo() {
        BattlePracticeCharacterInfoDTO response = api.getBattlePracticeCharacterInfo(replayId).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getBattlePracticeCharacterInfo with invalid replay_id")
    void getBattlePracticeCharacterInfo_with_invalid_replay_id() {
        String invalidReplayId = "invalid_replay_id_123";
        assertThatThrownBy(() -> api.getBattlePracticeCharacterInfo(invalidReplayId).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
