package kms.guild;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.guild.GuildDTO;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getGuild")
public class TestGetGuild {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ogid = "f5992063d46d6f8718e514fca5428960";

    @Test
    @DisplayName("success: getGuild")
    void getGuild() {
        String guildName = "붕붕";
        String worldName = "크로아";
        GuildDTO response = api.getGuild(guildName, worldName).join();
        assertThat(response.getOGuildId()).isEqualTo(ogid);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getGuild")
    void getGuild_async() {
        String guildName = "붕붕";
        String worldName = "크로아";
        api.getGuild(guildName, worldName).thenAcceptAsync(response -> {
            assertThat(response.getOGuildId()).isEqualTo(ogid);
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getGuild with invalid guild name")
    void getGuild_with_invalid_guild_name() {
        String guildName = "_InvalidGuild";
        String worldName = "크로아";
        GuildDTO response = api.getGuild(guildName, worldName).join();
        assertThat(response.getOGuildId()).isNull();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getGuild with invalid world name throw OPENAPI00004")
    void getGuild_with_invalid_world_name() {
        String guildName = "붕붕";
        String worldName = "_InvalidWorld";
        assertThatThrownBy(() -> api.getGuild(guildName, worldName).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
