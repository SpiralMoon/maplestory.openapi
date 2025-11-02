package tms.character;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;
import dev.spiralmoon.maplestory.api.tms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.tms.dto.character.CharacterImageDTO;
import dev.spiralmoon.maplestory.api.tms.param.CharacterImageOption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getCharacterImage")
public class TestGetCharacterImage {
    private static final String apiKey = System.getProperty("API_KEY_TMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "ab918948538b1b79046df133fff52092";

    @Test
    @DisplayName("success: getCharacterImage")
    void getCharacterImage() {
        CharacterImageDTO response = api.getCharacterImage(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: async getCharacterImage")
    void getCharacterImage_async() {
        api.getCharacterImage(ocid).thenAcceptAsync(response -> {
            System.out.println(response.toString());
        }).join();
    }

    @Test
    @DisplayName("success: getCharacterImage with options")
    void getCharacterImage_with_options() {
        CharacterImageOption options = new CharacterImageOption();
        options.setAction(CharacterImageAction.Jump);
        options.setActionFrame(0);
        options.setEmotion(CharacterImageEmotion.Chu);
        options.setEmotionFrame(0);
        options.setWmotion(CharacterImageWeaponMotion.Nothing);
        CharacterImageDTO response = api.getCharacterImage(ocid, options).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("success: getCharacterImage with date")
    void getCharacterImage_with_date() {
        LocalDateTime date = LocalDateTime.of(2025, 10, 15, 0, 0);
        CharacterImageDTO response = api.getCharacterImage(ocid, new CharacterImageOption(), date).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getCharacterImage with invalid ocid throw OPENAPI00003")
    void getCharacterImage_with_invalid_ocid() {
        String invalidOcid = "invalid_ocid_123_";
        assertThatThrownBy(() -> api.getCharacterImage(invalidOcid).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00003);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }

    @Test
    @DisplayName("fail: getCharacterImage with invalid date")
    void getCharacterImage_with_invalid_date() {
        LocalDateTime invalidDate = LocalDateTime.of(2025, 10, 14, 0, 0);
        assertThatThrownBy(() -> api.getCharacterImage(ocid, new CharacterImageOption(), invalidDate).join())
                .hasCauseInstanceOf(IllegalArgumentException.class)
                .satisfies(e -> {
                    Throwable error = e.getCause();
                    assertThat(error.getMessage()).contains("You can only retrieve data after 2025-10-15.");
                    System.out.println(error.getMessage());
                });
    }
}
