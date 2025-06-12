package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 HEXA 코어 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterHexaMatrixDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterHexaMatrixDTO<
        CharacterHexaMatrixEquipmentDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * HEXA 코어 정보
     */
    @SerializedName("character_hexa_core_equipment")
    private List<CharacterHexaMatrixEquipmentDTO> characterHexaCoreEquipment;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
