package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 캐릭터 장비 아이템 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterItemEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterItemEquipmentDTO<
        CharacterItemEquipmentInfoDTO,
        CharacterItemEquipmentTitleDTO,
        CharacterItemEquipmentDragonInfoDTO,
        CharacterItemEquipmentMechanicInfoDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 캐릭터 성별
     */
    @JsonProperty("character_gender")
    private String characterGender;

    /**
     * 캐릭터 직업
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * 적용 중인 장비 프리셋 번호
     */
    @JsonProperty("preset_no")
    private Integer presetNo;

    /**
     * 장비 정보
     */
    @JsonProperty("item_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipment;

    /**
     * 1번 프리셋 장비 정보
     */
    @JsonProperty("item_equipment_preset_1")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset1;

    /**
     * 2번 프리셋 장비 정보
     */
    @JsonProperty("item_equipment_preset_2")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset2;

    /**
     * 3번 프리셋 장비 정보
     */
    @JsonProperty("item_equipment_preset_3")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentInfoDTO> itemEquipmentPreset3;

    /**
     * 칭호 정보
     */
    @JsonProperty("title")
    private CharacterItemEquipmentTitleDTO title;

    /**
     * 외형 설정에 등록한 훈장 외형 정보
     */
    @JsonProperty("medal_shape")
    private CharacterItemEquipmentMedalShapeDTO medalShape;

    /**
     * 에반 드래곤 장비 정보 (에반인 경우 응답)
     */
    @JsonProperty("dragon_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentDragonInfoDTO> dragonEquipment;

    /**
     * 메카닉 장비 정보 (메카닉인 경우 응답)
     */
    @JsonProperty("mechanic_equipment")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterItemEquipmentMechanicInfoDTO> mechanicEquipment;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
