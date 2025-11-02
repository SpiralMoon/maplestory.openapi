package kms.notice;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.notice.EventNoticeListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("getEventNoticeList")
public class TestGetEventNoticeList {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getEventNoticeList")
    void getEventNoticeList() {
        EventNoticeListDTO response = api.getEventNoticeList().join();
        System.out.println(response.toString());
    }
}
