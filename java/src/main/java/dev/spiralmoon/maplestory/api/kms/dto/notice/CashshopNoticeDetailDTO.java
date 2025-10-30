package dev.spiralmoon.maplestory.api.kms.dto.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐시샵 공지 상세
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CashshopNoticeDetailDTO {

    /**
     * 공지 제목
     */
    @JsonProperty("id")
    private String title;

    /**
     * 공지 링크
     */
    @JsonProperty("url")
    private String url;

    /**
     * 공지 본문
     */
    @JsonProperty("contents")
    private String contents;

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
