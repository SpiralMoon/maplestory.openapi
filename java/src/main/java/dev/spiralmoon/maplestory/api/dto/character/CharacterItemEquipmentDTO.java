package dev.spiralmoon.maplestory.api.dto.character;

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
     * 적용 중인 장비 프리셋 번호
     */
    @SerializedName("preset_no")
    private Integer presetNo;

    /**
     * 장비 정보
     */
    @SerializedName("item_equipment")
    private List<CharacterItemEquipmentInfoDTO> itemEquipment;

    /**
     * 1번 프리셋 장비 정보
     */
    @SerializedName("item_equipment_preset_1")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset1;

    /**
     * 2번 프리셋 장비 정보
     */
    @SerializedName("item_equipment_preset_2")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset2;

    /**
     * 3번 프리셋 장비 정보
     */
    @SerializedName("item_equipment_preset_3")
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset3;

    /**
     * 칭호 정보
     */
    @SerializedName("title")
    private CharacterItemEquipmentTitleDTO title;

    /**
     * 외형 설정에 등록한 훈장 외형 정보
     */
    @SerializedName("medal_shape")
    private CharacterItemEquipmentMedalShapeDTO medalShape;

    /**
     * 에반 드래곤 장비 정보 (에반인 경우 응답)
     */
    @SerializedName("dragon_equipment")
    private List<CharacterItemEquipmentDragonInfoDTO> dragonEquipment;

    /**
     * 메카닉 장비 정보 (메카닉인 경우 응답)
     */
    @SerializedName("mechanic_equipment")
    private List<CharacterItemEquipmentMechanicInfoDTO> mechanicEquipment;

    public LocalDateTime getDate() {
        return date != null
                ? Utils.toLocalDateTime(this.date)
                : null;
    }
}
