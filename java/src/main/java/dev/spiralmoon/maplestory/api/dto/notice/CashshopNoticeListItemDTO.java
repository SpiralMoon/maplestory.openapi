package dev.spiralmoon.maplestory.api.dto.notice;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 캐시샵 공지
 */
@AllArgsConstructor
@Data
@ToString
public class CashshopNoticeListItemDTO {

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
     * 판매 시작일
     */
    @SerializedName("date_sale_start")
    private String dateSaleStart;

    /**
     * 판매 종료일
     */
    @SerializedName("date_sale_end")
    private String dateSaleEnd;

    /**
     * 상시 판매 여부 (true - 상시)
     */
    @SerializedName("ongoing_flag")
    private String ongoingFlag;

    /**
     * 공지 등록일
     */
    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }

    /**
     * 판매 시작일
     */
    public LocalDateTime getDateSaleStart() {
        return this.dateSaleStart != null ? Utils.toLocalDateTime(this.dateSaleStart) : null;
    }

    /**
     * 판매 종료일
     */
    public LocalDateTime getDateSaleEnd() {
        return this.dateSaleEnd != null ? Utils.toLocalDateTime(this.dateSaleEnd) : null;
    }

    /**
     * 상시 판매 여부 (true - 상시)
     */
    public boolean isOnGoing() {
        return "true".equals(this.ongoingFlag);
    }
}
