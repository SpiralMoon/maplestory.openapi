import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.user.AchievementDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("계정 정보 조회")
public class UserApi {

    private static final String apiKey = System.getProperty("API_KEY"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("업적 정보 조회")
    void getAchievement() throws IOException {
        AchievementDTO response = api.getAchievement().join();
        System.out.println(response.toString());
    }
}
