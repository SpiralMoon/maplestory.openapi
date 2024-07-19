package dev.spiralmoon.maplestory.api.dto.notice;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 진행 중 이벤트 상세
 */
@AllArgsConstructor
@Data
@ToString
public class EventNoticeDetailDTO {

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
     * 공지 본문
     */
    @SerializedName("contents")
    private String contents;

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
    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }

    /**
     * 이벤트 시작일
     */
    public LocalDateTime getDateEventStart() {
        return Utils.toLocalDateTime(this.dateEventStart);
    }

    /**
     * 이벤트 종료일
     */
    public LocalDateTime getDateEventEnd() {
        return Utils.toLocalDateTime(this.dateEventEnd);
    }
}
