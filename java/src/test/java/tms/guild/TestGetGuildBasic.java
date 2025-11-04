package tms.guild;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.tms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.tms.dto.guild.GuildBasicDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getGuildBasic")
public class TestGetGuildBasic {
    private static final String apiKey = System.getProperty("API_KEY_TMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ogid = "e046b388ffd7d4f807f1dd09215381ca";

    @Test
    @DisplayName("success: getGuildBasic")
    void getGuildBasic() {
        GuildBasicDTO response = api.getGuildBasic(ogid).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getGuildBasic")
    void getGuildBasic_async() {
        api.getGuildBasic(ogid).thenAcceptAsync(response -> {
            assertThat(response).isNotNull();
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getGuildBasic with date")
    void getGuildBasic_with_date() {
        LocalDateTime date = LocalDateTime.of(2025, 10, 15, 0, 0);
        GuildBasicDTO response = api.getGuildBasic(ogid, date).join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getGuildBasic with invalid ogid throw OPENAPI00003")
    void getGuildBasic_with_invalid_ogid() {
        String invalidOgid = "invalid_ogid_123";
        assertThatThrownBy(() -> api.getGuildBasic(invalidOgid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getGuildBasic with invalid date")
    void getGuildBasic_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 10, 14, 0, 0);
        assertThatThrownBy(() -> api.getGuildBasic(ogid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-10-15.");
                    System.out.println(error.getMessage());
                });
    }
}
