package kms.user;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.user.CharacterListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("getNoticeList")
public class TestGetCharacterList {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getCharacterList")
    void getNoticeList() {
        CharacterListDTO response = api.getCharacterList().join();
        assertThat(response).isNotNull();
        System.out.println(response.toString());
    }
}
