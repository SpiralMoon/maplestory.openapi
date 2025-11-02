package kms.ranking;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.ranking.GuildRankingResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getGuildRanking")
public class TestGetGuildRanking {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getGuildRanking")
    void getGuildRanking() {
        GuildRankingResponseDTO response = api.getGuildRanking(null, 0, null, null).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getGuildRanking with paging")
    void getGuildRanking_with_paging() {
        GuildRankingResponseDTO response = api.getGuildRanking(null, 0, null, 2).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getGuildRanking with guild name")
    void getGuildRanking_with_guild_name() {
        GuildRankingResponseDTO response = api.getGuildRanking(null, 0, "리더", null).join();
        assertThat(response.getRanking()).hasSizeGreaterThan(0);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getGuildRanking with world name")
    void getGuildRanking_with_world_name() {
        GuildRankingResponseDTO response = api.getGuildRanking("스카니아", 0, null, null).join();
        assertThat(response.getRanking()).hasSizeGreaterThan(0);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getGuildRanking with world and guild name")
    void getGuildRanking_with_world_and_guild_name() {
        GuildRankingResponseDTO response = api.getGuildRanking("스카니아", 0, "리더", null).join();
        assertThat(response.getRanking()).hasSizeLessThanOrEqualTo(1);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getGuildRanking with date")
    void getGuildRanking_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 23, 0, 0);
        GuildRankingResponseDTO response = api.getGuildRanking(null, 0, null, null, date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getGuildRanking with invalid date")
    void getGuildRanking_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 21, 0, 0);
        assertThatThrownBy(() -> api.getGuildRanking(null, 0, null, null, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-22.");
                    System.out.println(error.getMessage());
                });
    }

    @Test
    @DisplayName("success: getGuildRanking with invalid guild name")
    void getGuildRanking_with_invalid_guild_name() {
        final String invalidGuildName = "invalid_guild_name_123";
        GuildRankingResponseDTO response = api.getGuildRanking(null, 0, invalidGuildName, null).join();
        assertThat(response.getRanking()).isEmpty();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getGuildRanking with invalid ranking type throw OPENAPI00004")
    void getGuildRanking_with_invalid_ranking_type_throw_OPENAPI00004() {
        assertThatThrownBy(() -> api.getGuildRanking(null, -1, null, null).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
