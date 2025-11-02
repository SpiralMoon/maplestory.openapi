package kms.notice;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.notice.UpdateNoticeDetailDTO;
import dev.spiralmoon.maplestory.api.kms.dto.notice.UpdateNoticeListDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("getUpdateNoticeDetail")
public class TestGetUpdateNoticeDetail {
    private static final String apiKey = System.getProperty("API_KEY_KMS"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("success: getUpdateNoticeDetail")
    void getUpdateNoticeDetail() throws Exception {
        UpdateNoticeListDTO notice = api.getUpdateNoticeList().join();

        if (notice.getUpdateNotice().isEmpty()) {
            throw new Exception("Notice must not be empty.");
        }

        int noticeId = notice.getUpdateNotice().get(0).getNoticeId();
        UpdateNoticeDetailDTO response = api.getUpdateNoticeDetail(noticeId).join();

        System.out.println(response.toString());
    }

    @Test
    @DisplayName("fail: getUpdateNoticeDetail with invalid notice id throw OPENAPI00004")
    void getUpdateNoticeDetail_with_invalid_notice_id_throw_OPENAPI00004() {
        int invalidNoticeId = -1;
        assertThatThrownBy(() -> api.getUpdateNoticeDetail(invalidNoticeId).join())
                .hasCauseInstanceOf(MapleStoryApiException.class)
                .satisfies(e -> {
                    MapleStoryApiException apiException = (MapleStoryApiException) e.getCause();
                    assertThat(apiException.getErrorCode()).isEqualTo(MapleStoryApiErrorCode.OPENAPI00004);
                    System.out.println(apiException.getErrorCode() + " " + apiException.getMessage());
                });
    }
}
