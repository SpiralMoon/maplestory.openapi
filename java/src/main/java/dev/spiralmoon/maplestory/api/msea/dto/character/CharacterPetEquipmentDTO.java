package dev.spiralmoon.maplestory.api.msea.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Character equipped pet information
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentDTO<
        CharacterPetEquipmentItemDTO,
        CharacterPetEquipmentAutoSkillDTO> {
    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * Name of pet 1
     */
    @SerializedName("pet_1_name")
    private String pet1Name;

    /**
     * Nickname of pet 1
     */
    @SerializedName("pet_1_nickname")
    private String pet1Nickname;

    /**
     * Icon of pet 1
     */
    @SerializedName("pet_1_icon")
    private String pet1Icon;

    /**
     * Description of pet 1
     */
    @SerializedName("pet_1_description")
    private String pet1Description;

    /**
     * Equipment information for pet 1
     */
    @SerializedName("pet_1_equipment")
    private CharacterPetEquipmentItemDTO pet1Equipment;

    /**
     * Auto buff skill information for pet 1
     */
    @SerializedName("pet_1_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet1AutoSkill;

    /**
     * Wonder pet type of pet 1
     */
    @SerializedName("pet_1_pet_type")
    private String pet1PetType;

    /**
     * Skills possessed by pet 1
     */
    @SerializedName("pet_1_skill")
    private List<String> pet1Skill;

    /**
     * Magic time for pet 1 (SGT, data with minutes set to 0)
     */
    @SerializedName("pet_1_date_expire")
    private String pet1DateExpire;

    /**
     * Appearance of pet 1
     */
    @SerializedName("pet_1_appearance")
    private String pet1Appearance;

    /**
     * Appearance icon of pet 1
     */
    @SerializedName("pet_1_appearance_icon")
    private String Pet1AppearanceIcon;

    /**
     * Name of pet 2
     */
    @SerializedName("pet_2_name")
    private String pet2Name;

    /**
     * Nickname of pet 2
     */
    @SerializedName("pet_2_nickname")
    private String pet2Nickname;

    /**
     * Icon of pet 2
     */
    @SerializedName("pet_2_icon")
    private String pet2Icon;

    /**
     * Description of pet 2
     */
    @SerializedName("pet_2_description")
    private String pet2Description;

    /**
     * Equipment information for pet 2
     */
    @SerializedName("pet_2_equipment")
    private CharacterPetEquipmentItemDTO pet2Equipment;

    /**
     * Auto buff skill information for pet 2
     */
    @SerializedName("pet_2_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet2AutoSkill;

    /**
     * Wonder pet type of pet 2
     */
    @SerializedName("pet_2_pet_type")
    private String pet2PetType;

    /**
     * Skills possessed by pet 2
     */
    @SerializedName("pet_2_skill")
    private List<String> pet2Skill;

    /**
     * Magic time for pet 2 (SGT, data with minutes set to 0)
     */
    @SerializedName("pet_2_date_expire")
    private String pet2DateExpire;

    /**
     * Appearance of pet 2
     */
    @SerializedName("pet_2_appearance")
    private String pet2Appearance;

    /**
     * Appearance icon of pet 2
     */
    @SerializedName("pet_2_appearance_icon")
    private String Pet2AppearanceIcon;

    /**
     * Name of pet 3
     */
    @SerializedName("pet_3_name")
    private String pet3Name;

    /**
     * Nickname of pet 3
     */
    @SerializedName("pet_3_nickname")
    private String pet3Nickname;

    /**
     * Icon of pet 3
     */
    @SerializedName("pet_3_icon")
    private String pet3Icon;

    /**
     * Description of pet 3
     */
    @SerializedName("pet_3_description")
    private String pet3Description;

    /**
     * Equipment information for pet 3
     */
    @SerializedName("pet_3_equipment")
    private CharacterPetEquipmentItemDTO pet3Equipment;

    /**
     * Auto buff skill information for pet 3
     */
    @SerializedName("pet_3_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet3AutoSkill;

    /**
     * Wonder pet type of pet 3
     */
    @SerializedName("pet_3_pet_type")
    private String pet3PetType;

    /**
     * Skills possessed by pet 3
     */
    @SerializedName("pet_3_skill")
    private List<String> pet3Skill;

    /**
     * Magic time for pet 3 (SGT, data with minutes set to 0)
     */
    @SerializedName("pet_3_date_expire")
    private String pet3DateExpire;

    /**
     * Appearance of pet 3
     */
    @SerializedName("pet_3_appearance")
    private String pet3Appearance;

    /**
     * Appearance icon of pet 3
     */
    @SerializedName("pet_3_appearance_icon")
    private String Pet3AppearanceIcon;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }

    /**
     * Magic time for pet 1 (SGT, data with minutes set to 0)
     */
    public ZonedDateTime getPet1DateExpire() {
        if (this.pet1DateExpire != null && !"expired".equals(this.pet1DateExpire)) {
            return Utils.toZonedDateTime(this.pet1DateExpire);
        } else {
            return null;
        }
    }

    /**
     * Whether pet 1's magic time is expired
     */
    public Boolean isPet1Expired() {

        if (this.pet1DateExpire == null) {
            return null;
        }

        return "expired".equals(this.pet1DateExpire);
    }

    /**
     * Magic time for pet 2 (SGT, data with minutes set to 0)
     */
    public ZonedDateTime getPet2DateExpire() {
        if (this.pet2DateExpire != null && !"expired".equals(this.pet2DateExpire)) {
            return Utils.toZonedDateTime(this.pet2DateExpire);
        } else {
            return null;
        }
    }

    /**
     * Whether pet 2's magic time is expired
     */
    public Boolean isPet2Expired() {

        if (this.pet2DateExpire == null) {
            return null;
        }

        return "expired".equals(this.pet2DateExpire);
    }

    /**
     * Magic time for pet 3 (SGT, data with minutes set to 0)
     */
    public ZonedDateTime getPet3DateExpire() {
        if (this.pet3DateExpire != null && !"expired".equals(this.pet3DateExpire)) {
            return Utils.toZonedDateTime(this.pet3DateExpire);
        } else {
            return null;
        }
    }

    /**
     * Whether pet 3's magic time is expired
     */
    public Boolean isPet3Expired() {

        if (this.pet3DateExpire == null) {
            return null;
        }

        return "expired".equals(this.pet3DateExpire);
    }
}
