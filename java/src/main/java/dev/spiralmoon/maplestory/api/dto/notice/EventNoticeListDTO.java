package dev.spiralmoon.maplestory.api.dto.notice;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 진행 중 이벤트 목록
 */
@AllArgsConstructor
@Data
@ToString
public class EventNoticeListDTO {

    /**
     * 공지 목록
     */
    @SerializedName("event_notice")
    private List<EventNoticeListItemDTO> eventNotice;
}
