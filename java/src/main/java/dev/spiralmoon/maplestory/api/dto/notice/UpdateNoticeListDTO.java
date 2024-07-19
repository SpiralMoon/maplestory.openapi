package dev.spiralmoon.maplestory.api.dto.notice;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 업데이트 목록
 */
@AllArgsConstructor
@Data
@ToString
public class UpdateNoticeListDTO {

    /**
     * 공지 목록
     */
    @SerializedName("update_notice")
    private List<UpdateNoticeListItemDTO> updateNotice;
}
