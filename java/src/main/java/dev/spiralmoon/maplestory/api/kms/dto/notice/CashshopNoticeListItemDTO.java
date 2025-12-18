package dev.spiralmoon.maplestory.api.kms.dto.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐시샵 공지
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CashshopNoticeListItemDTO {

    /**
     * 공지 제목
     */
    @JsonProperty("title")
    private String title;

    /**
     * 공지 링크
     */
    @JsonProperty("url")
    private String url;

    /**
     * 썸네일 링크
     */
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    /**
     * 공지 식별자
     */
    @JsonProperty("notice_id")
    private int noticeId;

    /**
     * 공지 등록일
     */
    @JsonProperty("date")
    private String date;

    /**
     * 판매 시작일
     */
    @JsonProperty("date_sale_start")
    private String dateSaleStart;

    /**
     * 판매 종료일
     */
    @JsonProperty("date_sale_end")
    private String dateSaleEnd;

    /**
     * 상시 판매 여부 (true - 상시)
     */
    @JsonProperty("ongoing_flag")
    private String ongoingFlag;

    /**
     * 공지 등록일
     */
    public ZonedDateTime getDate() {
        return Utils.toZonedDateTime(this.date);
    }

    /**
     * 판매 시작일
     */
    public ZonedDateTime getDateSaleStart() {
        return this.dateSaleStart != null ? Utils.toZonedDateTime(this.dateSaleStart) : null;
    }

    /**
     * 판매 종료일
     */
    public ZonedDateTime getDateSaleEnd() {
        return this.dateSaleEnd != null ? Utils.toZonedDateTime(this.dateSaleEnd) : null;
    }

    /**
     * 상시 판매 여부 (true - 상시)
     */
    public boolean isOnGoing() {
        return "true".equals(this.ongoingFlag);
    }
}
