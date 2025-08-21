package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * 능력치에 영향을 주는 요소 및 스탯 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterOtherStatDetailDTO {

    /**
     * 스탯 타입
     */
    @SerializedName("other_stat_type")
    private String otherStatType;

    /**
     * 스탯 정보
     */
    @SerializedName("stat_info")
    private List<CharacterOtherStatInfoDTO> statInfo;
}