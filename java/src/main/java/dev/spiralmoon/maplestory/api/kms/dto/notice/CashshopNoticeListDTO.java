package dev.spiralmoon.maplestory.api.kms.dto.notice;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 캐시샵 공지 목록
 */
@AllArgsConstructor
@Data
@ToString
public class CashshopNoticeListDTO {

    /**
     * 공지 목록
     */
    @SerializedName("cashshop_notice")
    private List<CashshopNoticeListItemDTO> cashshopNotice;
}
