package kms.guild;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.guild.GuildBasicDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getGuildBasic")
public class TestGetGuildBasic {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ogid = "f5992063d46d6f8718e514fca5428960";

    @Test
    @DisplayName("success: getGuildBasic")
    void getGuildBasic() {
        GuildBasicDTO response = api.getGuildBasic(ogid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getGuildBasic")
    void getGuildBasic_async() {
        api.getGuildBasic(ogid).thenAcceptAsync(response -> {
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getGuildBasic with date")
    void getGuildBasic_with_date() {
        LocalDateTime date = LocalDateTime.of(2023, 12, 22, 0, 0);
        GuildBasicDTO response = api.getGuildBasic(ogid, date).join();
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
        LocalDateTime invalidDate = LocalDateTime.of(2023, 12, 20, 0, 0);
        assertThatThrownBy(() -> api.getGuildBasic(ogid, invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2023-12-21.");
                    System.out.println(error.getMessage());
                });
    }
}
