package kms.user;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.user.AchievementDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("getAchievement")
public class TestGetAchievement {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getAchievement")
    void getNoticeList() {
        AchievementDTO response = api.getAchievement().join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }
}
