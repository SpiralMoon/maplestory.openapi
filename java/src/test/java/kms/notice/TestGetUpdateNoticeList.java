package kms.notice;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.notice.UpdateNoticeListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("getUpdateNoticeList")
public class TestGetUpdateNoticeList {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getUpdateNoticeList")
    void getUpdateNoticeList() {
        UpdateNoticeListDTO response = api.getUpdateNoticeList().join();
        System.out.println(response.toString());
    }
}
