package tms.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.tms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.tms.dto.character.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacter")
public class TestGetCharacter {
    private static final String apiKey = System.getProperty("API_KEY_TMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "ab918948538b1b79046df133fff52092";

    @Test
    @DisplayName("success: getCharacter")
    void getCharacter() {
        String nickname = "吳獨秀x";
        CharacterDTO response = api.getCharacter(nickname).join();
        assertThat(response.getOcid()).isEqualTo(ocid);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacter")
    void getCharacter_async() {
        String nickname = "吳獨秀x";
        api.getCharacter(nickname).thenAcceptAsync(response -> {
            assertThat(response.getOcid()).isEqualTo(ocid);
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("fail: getCharacter with invalid name throw OPENAPI00004")
    void getCharacter_with_invalid_name() {
        String invalidNickname = "invalid_nickname_123_";
        assertThatThrownBy(() -> api.getCharacter(invalidNickname).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
