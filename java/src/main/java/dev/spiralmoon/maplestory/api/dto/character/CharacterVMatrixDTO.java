package dev.spiralmoon.maplestory.api.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 캐릭터 V매트릭스 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterVMatrixDTO {

    /**
     * 조회 기준일 (KST)
     */
    @SerializedName("date")
    private String date;

    /**
     * 캐릭터 직업
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * V 코어 정보를 나타내는 DTO 클래스입니다.
     */
    @SerializedName("character_v_core_equipment")
    private List<CharacterVMatrixCodeEquipmentDTO> characterVCoreEquipment;

    /**
     * 캐릭터 잔여 매트릭스 강화 포인트
     */
    @SerializedName("character_v_matrix_remain_slot_upgrade_point")
    private Long characterVMatrixRemainSlotUpgradePoint;

    public LocalDateTime getDate() {
        return Utils.toLocalDateTime(this.date);
    }
}
