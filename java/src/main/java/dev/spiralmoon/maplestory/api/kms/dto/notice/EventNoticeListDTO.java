package dev.spiralmoon.maplestory.api.kms.dto.notice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 진행 중 이벤트 목록
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class EventNoticeListDTO {

    /**
     * 공지 목록
     */
    @JsonProperty("event_notice")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<EventNoticeListItemDTO> eventNotice;
}
