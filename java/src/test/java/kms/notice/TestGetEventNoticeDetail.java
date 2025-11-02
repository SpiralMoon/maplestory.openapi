package kms.notice;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.notice.EventNoticeDetailDTO;
import dev.spiralmoon.maplestory.api.kms.dto.notice.EventNoticeListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getEventNoticeDetail")
public class TestGetEventNoticeDetail {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getEventNoticeDetail")
    void getEventNoticeDetail() throws Exception {
        EventNoticeListDTO notice = api.getEventNoticeList().join();

        if (notice.getEventNotice().isEmpty()) {
            throw new Exception("Notice must not be empty.");
        }

        int noticeId = notice.getEventNotice().get(0).getNoticeId();
        EventNoticeDetailDTO response = api.getEventNoticeDetail(noticeId).join();

        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getEventNoticeDetail with invalid notice id throw OPENAPI00004")
    void getEventNoticeDetail_with_invalid_notice_id_throw_OPENAPI00004() {
        int invalidNoticeId = -1;
        assertThatThrownBy(() -> api.getEventNoticeDetail(invalidNoticeId).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
