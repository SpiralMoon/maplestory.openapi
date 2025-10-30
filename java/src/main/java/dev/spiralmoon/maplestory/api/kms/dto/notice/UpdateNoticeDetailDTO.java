package dev.spiralmoon.maplestory.api.kms.dto.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 업데이트 상세
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UpdateNoticeDetailDTO {

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
     * 공지 등록일
     */
    public ZonedDateTime getDate() {
        return Utils.toZonedDateTime(this.date);
    }
}
