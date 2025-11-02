package kms.notice;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.notice.NoticeListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("getNoticeList")
public class TestGetNoticeList {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getNoticeList")
    void getNoticeList() {
        NoticeListDTO response = api.getNoticeList().join();
        System.out.println(response.toString());
    }
}
