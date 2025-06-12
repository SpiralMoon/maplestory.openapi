package dev.spiralmoon.maplestory.api.kms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 캐릭터 헤어, 성형, 피부 정보
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentDTO<
        CharacterBeautyEquipmentHairDTO,
        CharacterBeautyEquipmentFaceDTO,
        CharacterBeautyEquipmentSkinDTO> {

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
     * 캐릭터 헤어 정보
     * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
     */
    @SerializedName("character_hair")
    private CharacterBeautyEquipmentHairDTO characterHair;

    /**
     * 캐릭터 성형 정보
     * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
     */
    @SerializedName("character_face")
    private CharacterBeautyEquipmentFaceDTO characterFace;

    /**
     * 캐릭터 피부 정보
     * (제로인 경우 알파, 엔젤릭버스터인 경우 일반 모드)
     */
    @SerializedName("character_skin")
    private CharacterBeautyEquipmentSkinDTO characterSkin;

    /**
     * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 헤어 정보
     */
    @SerializedName("additional_character_hair")
    private CharacterBeautyEquipmentHairDTO additionalCharacterHair;

    /**
     * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 성형 정보
     */
    @SerializedName("additional_character_face")
    private CharacterBeautyEquipmentFaceDTO additionalCharacterFace;

    /**
     * 제로인 경우 베타, 엔젤릭버스터인 경우 드레스 업 모드에 적용 중인 피부 정보
     */
    @SerializedName("additional_character_skin")
    private CharacterBeautyEquipmentSkinDTO additionalCharacterSkin;

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
