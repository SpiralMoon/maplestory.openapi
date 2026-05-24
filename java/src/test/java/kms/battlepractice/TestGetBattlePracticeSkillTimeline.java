package kms.battlepractice;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.battlepractice.BattlePracticeSkillTimelineDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getBattlePracticeSkillTimeline")
public class TestGetBattlePracticeSkillTimeline {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String replayId = "8ac5ac350d67765e4c49db94cc61f83d";

    @Test
    @DisplayName("success: getBattlePracticeSkillTimeline (default page)")
    void getBattlePracticeSkillTimeline() {
        BattlePracticeSkillTimelineDTO response = api.getBattlePracticeSkillTimeline(replayId).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getBattlePracticeSkillTimeline with pageNo")
    void getBattlePracticeSkillTimeline_with_page_no() {
        BattlePracticeSkillTimelineDTO response = api.getBattlePracticeSkillTimeline(replayId, 1).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getBattlePracticeSkillTimeline with invalid replay_id")
    void getBattlePracticeSkillTimeline_with_invalid_replay_id() {
        String invalidReplayId = "invalid_replay_id_123";
        assertThatThrownBy(() -> api.getBattlePracticeSkillTimeline(invalidReplayId).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
