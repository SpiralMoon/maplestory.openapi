package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Character equipped hair, face, and skin information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentDTO<
        CharacterBeautyEquipmentHairDTO,
        CharacterBeautyEquipmentFaceDTO,
        CharacterBeautyEquipmentSkinDTO> {

    /**
     * Reference date for query (SGT)
     */
    @SerializedName("date")
    private String date;

    /**
     * Character gender
     */
    @SerializedName("character_gender")
    private String characterGender;

    /**
     * Character job
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * Character hair information
     */
    @SerializedName("character_hair")
    private CharacterBeautyEquipmentHairDTO characterHair;

    /**
     * Character face information
     */
    @SerializedName("character_face")
    private CharacterBeautyEquipmentFaceDTO characterFace;

    /**
     * Character skin information
     */
    @SerializedName("character_skin")
    private CharacterBeautyEquipmentSkinDTO characterSkin;

    /**
     * Hair information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
     */
    @SerializedName("additional_character_hair")
    private CharacterBeautyEquipmentHairDTO additionalCharacterHair;

    /**
     * Face information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
     */
    @SerializedName("additional_character_face")
    private CharacterBeautyEquipmentFaceDTO additionalCharacterFace;

    /**
     * Skin information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
     */
    @SerializedName("additional_character_skin")
    private CharacterBeautyEquipmentSkinDTO additionalCharacterSkin;

    /**
     * Reference date for query (SGT)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
