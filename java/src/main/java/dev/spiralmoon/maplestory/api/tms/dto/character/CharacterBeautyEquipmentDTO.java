package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 角色目前已裝備的髮型、臉型與膚色資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterBeautyEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterBeautyEquipmentDTO<
        CharacterBeautyEquipmentHairDTO,
        CharacterBeautyEquipmentFaceDTO,
        CharacterBeautyEquipmentSkinDTO> {

    /**
     * 要搜尋的日期 (TST)
     */
    @SerializedName("date")
    private String date;

    /**
     * 角色性別
     */
    @SerializedName("character_gender")
    private String characterGender;

    /**
     * 角色職業
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 角色髮型資訊<br>
     * (神之子為 Alpha、天使破壞者為一般模式時)
     */
    @SerializedName("character_hair")
    private CharacterBeautyEquipmentHairDTO characterHair;

    /**
     * 角色臉型資訊<br>
     * (神之子為 Alpha、天使破壞者為一般模式時)
     */
    @SerializedName("character_face")
    private CharacterBeautyEquipmentFaceDTO characterFace;

    /**
     * 角色膚色資訊<br>
     * (神之子為 Alpha、天使破壞者為一般模式時)
     */
    @SerializedName("character_skin")
    private CharacterBeautyEquipmentSkinDTO characterSkin;

    /**
     * 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備髮型資訊
     */
    @SerializedName("additional_character_hair")
    private CharacterBeautyEquipmentHairDTO additionalCharacterHair;

    /**
     * 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備臉型資訊
     */
    @SerializedName("additional_character_face")
    private CharacterBeautyEquipmentFaceDTO additionalCharacterFace;

    /**
     * 神之子為 Beta 及天使破壞者為變裝模式時的目前已裝備膚色資訊
     */
    @SerializedName("additional_character_skin")
    private CharacterBeautyEquipmentSkinDTO additionalCharacterSkin;

    /**
     * 要搜尋的日期 (TST)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
