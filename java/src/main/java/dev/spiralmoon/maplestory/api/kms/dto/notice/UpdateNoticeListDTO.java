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
 * 업데이트 목록
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UpdateNoticeListDTO {

    /**
     * 공지 목록
     */
    @JsonProperty("update_notice")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<UpdateNoticeListItemDTO> updateNotice;
}
