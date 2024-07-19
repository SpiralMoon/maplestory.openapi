package dev.spiralmoon.maplestory.api.dto.notice;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 공지사항 목록
 */
@AllArgsConstructor
@Data
@ToString
public class NoticeListDTO {

    /**
     * 공지 목록
     */
    @SerializedName("notice")
    private List<NoticeListItemDTO> notice;
}
