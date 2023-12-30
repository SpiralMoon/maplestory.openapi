package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 장비 아이템 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentDTO {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 캐릭터 성별
     */
    @SerializedName("character_gender")
    private String characterGender;

    /**
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 장비 정보 리스트
     */
    @SerializedName("item_equipment")
    private List<CharacterItemEquipmentInfoDTO> itemEquipment;

    /**
     * 칭호 정보
     */
    @SerializedName("title")
    private CharacterItemEquipmentTitleDTO title;

    /**
     * 에반 드래곤 장비 정보 (에반인 경우 응답)
     */
    @SerializedName("dragon_equipment")
    private List<CharacterItemEquipmentInfoDTO> dragonEquipment;

    /**
     * 메카닉 장비 정보 (메카닉인 경우 응답)
     */
    @SerializedName("mechanic_equipment")
    private List<CharacterItemEquipmentInfoDTO> mechanicEquipment;

    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }
}
