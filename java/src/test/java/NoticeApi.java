import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.notice.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("공지 정보 조회")
public class NoticeApi {

    private static final String apiKey = System.getProperty("API_KEY"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);

    @Test
    @DisplayName("공지사항 목록 조회")
    void getNotice() throws IOException {
        NoticeListDTO response = api.getNoticeList().join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("공지사항 상세 조회")
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
    @DisplayName("업데이트 목록 조회")
    void getUpdateNotice() throws IOException {
        UpdateNoticeListDTO response = api.getUpdateNoticeList().join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("업데이트 상세 조회")
    void getUpdateNoticeDetail() throws Exception {
        UpdateNoticeListDTO notice = api.getUpdateNoticeList().join();

        if (notice.getUpdateNotice().isEmpty()) {
            throw new Exception("Notice muse be not empty.");
        }

        int noticeId = notice.getUpdateNotice().get(0).getNoticeId();
        UpdateNoticeDetailDTO response = api.getUpdateNoticeDetail(noticeId).join();

        System.out.println(response.toString());
    }

    @Test
    @DisplayName("진행 중 이벤트 목록 조회")
    void getEventNotice() throws IOException {
        EventNoticeListDTO response = api.getEventNoticeList().join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("진행 중 이벤트 상세 조회")
    void getEventNoticeDetail() throws Exception {
        EventNoticeListDTO notice = api.getEventNoticeList().join();

        if (notice.getEventNotice().isEmpty()) {
            throw new Exception("Notice muse be not empty.");
        }

        int noticeId = notice.getEventNotice().get(0).getNoticeId();
        EventNoticeDetailDTO response = api.getEventNoticeDetail(noticeId).join();

        System.out.println(response.toString());
    }

    @Test
    @DisplayName("캐시샵 공지 목록 조회")
    void getCashshopNotice() throws IOException {
        CashshopNoticeListDTO response = api.getCashshopNoticeList().join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("캐시샵 공지 상세 조회")
    void getCashshopNoticeDetail() throws Exception {
        CashshopNoticeListDTO notice = api.getCashshopNoticeList().join();

        if (notice.getCashshopNotice().isEmpty()) {
            throw new Exception("Notice muse be not empty.");
        }

        int noticeId = notice.getCashshopNotice().get(0).getNoticeId();
        CashshopNoticeDetailDTO response = api.getCashshopNoticeDetail(noticeId).join();

        System.out.println(response.toString());
    }
}
