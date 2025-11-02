package kms.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("getCharacter")
public class TestGetCharacter {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("success: getCharacter")
    void getCharacter() {
        String nickname = "아델";
        CharacterDTO response = api.getCharacter(nickname).join();
        assertThat(response.getOcid()).isEqualTo(ocid);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacter")
    void getCharacter_async() {
        String nickname = "아델";
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
