import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.dto.ranking.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("랭킹 정보 조회")
public class RankingApi {

    private static final String apiKey = System.getProperty("API_KEY"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("종합 랭킹 정보 조회")
    void getOverallRanking() throws IOException {
        OverallRankingResponseDTO response = api.getOverallRanking(null, null, null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("유니온 랭킹 정보 조회")
    void getUnionRanking() throws IOException {
        UnionRankingResponseDTO response = api.getUnionRanking(null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("길드 랭킹 정보 조회")
    void getGuildRanking() throws IOException {
        GuildRankingResponseDTO response = api.getGuildRanking(null, 0, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("무릉도장 랭킹 정보 조회")
    void getDojangRanking() throws IOException {
        DojangRankingResponseDTO response = api.getDojangRanking(null, 0, null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("더 시드 랭킹 정보 조회")
    void getSeedRanking() throws IOException {
        TheSeedRankingResponseDTO response = api.getTheSeedRanking(null, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("업적 랭킹 정보 조회")
    void getAchievementRanking() throws IOException {
        AchievementRankingResponseDTO response = api.getAchievementRanking(null, null).join();
        System.out.println(response.toString());
    }
}
