package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 능력치에 영향을 주는 요소 및 스탯 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterOtherStatDetailDTO {

    /**
     * 스탯 타입
     */
    @JsonProperty("other_stat_type")
    private String otherStatType;

    /**
     * 스탯 정보
     */
    @JsonProperty("stat_info")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterOtherStatInfoDTO> statInfo;
}
