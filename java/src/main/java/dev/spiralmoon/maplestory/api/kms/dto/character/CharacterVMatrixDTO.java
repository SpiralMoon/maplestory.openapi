package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 V매트릭스 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterVMatrixDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterVMatrixDTO<CharacterVMatrixCoreEquipmentDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * V코어 정보
     */
    @SerializedName("character_v_core_equipment")
    private List<CharacterVMatrixCoreEquipmentDTO> characterVCoreEquipment;

    /**
     * 캐릭터 잔여 매트릭스 강화 포인트
     */
    @SerializedName("character_v_matrix_remain_slot_upgrade_point")
    private Long characterVMatrixRemainSlotUpgradePoint;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
