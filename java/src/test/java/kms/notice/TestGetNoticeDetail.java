package kms.notice;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.notice.NoticeDetailDTO;
import dev.spiralmoon.maplestory.api.kms.dto.notice.NoticeListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getNoticeDetail")
public class TestGetNoticeDetail {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getNoticeDetail")
    void getNoticeDetail() throws Exception {
        NoticeListDTO notice = api.getNoticeList().join();

        if (notice.getNotice().isEmpty()) {
            throw new Exception("Notice muse be not empty.");
        }

        int noticeId = notice.getNotice().get(0).getNoticeId();
        NoticeDetailDTO response = api.getNoticeDetail(noticeId).join();

        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getNoticeDetail with invalid notice id throw OPENAPI00004")
    void getNoticeDetail_with_invalid_notice_id_throw_OPENAPI00004() {
        int invalidNoticeId = -1;
        assertThatThrownBy(() -> api.getNoticeDetail(invalidNoticeId).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
