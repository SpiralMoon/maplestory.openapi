package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * 캐릭터 외형 설정에 등록한 훈장 외형 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentMedalShapeDTO {

    /**
     * 외형 설정에 등록한 훈장 장비 명
     */
    @SerializedName("medal_shape_name")
    private String medalShapeName;

    /**
     * 외형 설정에 등록한 훈장 아이콘
     */
    @SerializedName("medal_shape_icon")
    private String medalShapeIcon;

    /**
     * 외형 설정에 등록한 훈장 설명
     */
    @SerializedName("medal_shape_description")
    private String medalShapeDescription;

    /**
     * 외형 설정에 등록한 훈장의 모루 적용 장비 명
     */
    @SerializedName("medal_shape_changed_name")
    private String medalShapeChangedName;

    /**
     * 외형 설정에 등록한 훈장의 모루 적용 아이콘
     */
    @SerializedName("medal_shape_changed_icon")
    private String medalShapeChangedIcon;

    /**
     * 외형 설정에 등록한 훈장의 모루 적용 훈장 설명
     */
    @SerializedName("medal_shape_changed_description")
    private String medalShapeChangedDescription;
}
