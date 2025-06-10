package dev.spiralmoon.maplestory.api.kms.dto.notice;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * 진행 중 이벤트 공지
 */
@AllArgsConstructor
@Data
@ToString
public class EventNoticeListItemDTO {

    /**
     * 공지 제목
     */
    @SerializedName("id")
    private String title;

    /**
     * 공지 링크
     */
    @SerializedName("url")
    private String url;

    /**
     * 공지 식별자
     */
    @SerializedName("notice_id")
    private int noticeId;

    /**
     * 공지 등록일
     */
    @SerializedName("date")
    private String date;

    /**
     * 이벤트 시작일
     */
    @SerializedName("date_event_start")
    private String dateEventStart;

    /**
     * 이벤트 종료일
     */
    @SerializedName("date_event_end")
    private String dateEventEnd;

    /**
     * 공지 등록일
     */
    public ZonedDateTime getDate() {
        return Utils.toZonedDateTime(this.date);
    }

    /**
     * 이벤트 시작일
     */
    public ZonedDateTime getDateEventStart() {
        return Utils.toZonedDateTime(this.dateEventStart);
    }

    /**
     * 이벤트 종료일
     */
    public ZonedDateTime getDateEventEnd() {
        return Utils.toZonedDateTime(this.dateEventEnd);
    }
}
