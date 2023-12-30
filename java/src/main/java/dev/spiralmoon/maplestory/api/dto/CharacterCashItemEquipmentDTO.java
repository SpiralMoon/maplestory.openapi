package dev.spiralmoon.maplestory.api.dto;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 캐시 장비 아이템 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterCashItemEquipmentDTO {

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
     * 적용 중인 캐시 장비 프리셋 번호
     */
    @SerializedName("preset_no")
    private long presetNo;

    /**
     * 1번 프리셋 장착 캐시 장비 정보 목록
     */
    @SerializedName("cash_item_equipment_preset_1")
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset1;

    /**
     * 2번 프리셋 장착 캐시 장비 정보 목록
     */
    @SerializedName("cash_item_equipment_preset_2")
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset2;

    /**
     * 3번 프리셋 장착 캐시 장비 정보 목록
     */
    @SerializedName("cash_item_equipment_preset_3")
    private List<CharacterCashItemEquipmentPresetDTO> cashItemEquipmentPreset3;

    /**
     * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 1번 프리셋 장착 캐시 장비 정보 목록
     */
    @SerializedName("additional_cash_item_equipment_preset_1")
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset1;

    /**
     * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 2번 프리셋 장착 캐시 장비 정보 목록
     */
    @SerializedName("additional_cash_item_equipment_preset_2")
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset2;

    /**
     * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드의 3번 프리셋 장착 캐시 장비 정보 목록
     */
    @SerializedName("additional_cash_item_equipment_preset_3")
    private List<CharacterCashItemEquipmentPresetDTO> additionalCashItemEquipmentPreset3;

    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }
}
