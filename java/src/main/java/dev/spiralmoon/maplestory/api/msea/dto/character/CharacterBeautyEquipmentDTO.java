package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * Character equipped hair, face, and skin information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentDTO<
        CharacterBeautyEquipmentHairDTO,
        CharacterBeautyEquipmentFaceDTO,
        CharacterBeautyEquipmentSkinDTO> {

    /**
     * Reference date for query (SGT)
     */
    @JsonProperty("date")
    private String date;

    /**
     * Character gender
     */
    @JsonProperty("character_gender")
    private String characterGender;

    /**
     * Character job
     */
    @JsonProperty("character_class")
    private String characterClass;

    /**
     * Character hair information
     */
    @JsonProperty("character_hair")
    private CharacterBeautyEquipmentHairDTO characterHair;

    /**
     * Character face information
     */
    @JsonProperty("character_face")
    private CharacterBeautyEquipmentFaceDTO characterFace;

    /**
     * Character skin information
     */
    @JsonProperty("character_skin")
    private CharacterBeautyEquipmentSkinDTO characterSkin;

    /**
     * Hair information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
     */
    @JsonProperty("additional_character_hair")
    private CharacterBeautyEquipmentHairDTO additionalCharacterHair;

    /**
     * Face information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
     */
    @JsonProperty("additional_character_face")
    private CharacterBeautyEquipmentFaceDTO additionalCharacterFace;

    /**
     * Skin information applied in Beta mode for Zero or Dress-up mode for Angelic Buster
     */
    @JsonProperty("additional_character_skin")
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
