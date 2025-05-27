import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.dto.history.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("확률 정보 조회")
public class HistoryApi {

    private static final String apiKey = System.getProperty("API_KEY"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("스타포스 강화 결과 조회")
    void getStarforceHistory() throws IOException {
        int count = 1000;
        StarforceHistoryResponseDTO response = api.getStarforceHistory(count).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("잠재능력 재설정 이용 결과 조회")
    void getPotentialHistory() throws IOException {
        int count = 1000;
        PotentialHistoryResponseDTO response = api.getPotentialHistory(count).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("큐브 사용 결과 조회")
    void getCubeHistory() throws IOException {
        int count = 1000;
        CubeHistoryResponseDTO response = api.getCubeHistory(count).join();
        System.out.println(response.toString());
    }
}
