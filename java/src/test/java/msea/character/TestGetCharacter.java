package msea.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.msea.MapleStoryApi;
import dev.spiralmoon.maplestory.api.msea.dto.character.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacter")
public class TestGetCharacter {
    private static final String apiKey = System.getProperty("API_KEY_MSEA"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "caee7cf6ec6cb067c33b899f2779f3d1";

    @Test
    @DisplayName("success: getCharacter")
    void getCharacter() {
        String nickname = "Arid";
        CharacterDTO response = api.getCharacter(nickname).join();
        assertThat(response.getOcid()).isEqualTo(ocid);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacter")
    void getCharacter_async() {
        String nickname = "Arid";
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
