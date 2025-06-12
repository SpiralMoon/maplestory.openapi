package dev.spiralmoon.maplestory.api.kms.dto.notice;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 업데이트 상세
 */
@AllArgsConstructor
@Data
@ToString
public class UpdateNoticeDetailDTO {

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
     * 공지 등록일
     */
    public ZonedDateTime getDate() {
        return Utils.toZonedDateTime(this.date);
    }
}
