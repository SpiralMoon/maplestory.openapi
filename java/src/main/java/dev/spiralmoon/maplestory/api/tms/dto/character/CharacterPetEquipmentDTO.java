package dev.spiralmoon.maplestory.api.tms.dto.character;

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
 * 角色已裝備寵物資訊
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterPetEquipmentDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterPetEquipmentDTO<CharacterPetEquipmentItemDTO, CharacterPetEquipmentAutoSkillDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * 寵物 1 名稱
     */
    @JsonProperty("pet_1_name")
    private String pet1Name;

    /**
     * 寵物 1 暱稱
     */
    @JsonProperty("pet_1_nickname")
    private String pet1Nickname;

    /**
     * 寵物 1 圖示
     */
    @JsonProperty("pet_1_icon")
    private String pet1Icon;

    /**
     * 寵物 1 描述
     */
    @JsonProperty("pet_1_description")
    private String pet1Description;

    /**
     * 寵物 1 道具資訊
     */
    @JsonProperty("pet_1_equipment")
    private CharacterPetEquipmentItemDTO pet1Equipment;

    /**
     * 寵物 1 的寵物自動加持技能資訊
     */
    @JsonProperty("pet_1_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet1AutoSkill;

    /**
     * 寵物 1 神奇寵物類型
     */
    @JsonProperty("pet_1_pet_type")
    private String pet1PetType;

    /**
     * 寵物 1 技能
     */
    @JsonProperty("pet_1_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> pet1Skill;

    /**
     * 寵物 1 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
     */
    @JsonProperty("pet_1_date_expire")
    private String pet1DateExpire;

    /**
     * 寵物 1 外型
     */
    @JsonProperty("pet_1_appearance")
    private String pet1Appearance;

    /**
     * 寵物 1 外型圖示
     */
    @JsonProperty("pet_1_appearance_icon")
    private String pet1AppearanceIcon;

    /**
     * 寵物 2 名稱
     */
    @JsonProperty("pet_2_name")
    private String pet2Name;

    /**
     * 寵物 2 暱稱
     */
    @JsonProperty("pet_2_nickname")
    private String pet2Nickname;

    /**
     * 寵物 2 圖示
     */
    @JsonProperty("pet_2_icon")
    private String pet2Icon;

    /**
     * 寵物 2 描述
     */
    @JsonProperty("pet_2_description")
    private String pet2Description;

    /**
     * 寵物 2 道具資訊
     */
    @JsonProperty("pet_2_equipment")
    private CharacterPetEquipmentItemDTO pet2Equipment;

    /**
     * 寵物 2 的寵物自動加持技能資訊
     */
    @JsonProperty("pet_2_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet2AutoSkill;

    /**
     * 寵物 2 神奇寵物類型
     */
    @JsonProperty("pet_2_pet_type")
    private String pet2PetType;

    /**
     * 寵物 2 技能
     */
    @JsonProperty("pet_2_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> pet2Skill;

    /**
     * 寵物 2 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
     */
    @JsonProperty("pet_2_date_expire")
    private String pet2DateExpire;

    /**
     * 寵物 2 外型
     */
    @JsonProperty("pet_2_appearance")
    private String pet2Appearance;

    /**
     * 寵物 2 外型圖示
     */
    @JsonProperty("pet_2_appearance_icon")
    private String pet2AppearanceIcon;

    /**
     * 寵物 3 名稱
     */
    @JsonProperty("pet_3_name")
    private String pet3Name;

    /**
     * 寵物 3 暱稱
     */
    @JsonProperty("pet_3_nickname")
    private String pet3Nickname;

    /**
     * 寵物 3 圖示
     */
    @JsonProperty("pet_3_icon")
    private String pet3Icon;

    /**
     * 寵物 3 描述
     */
    @JsonProperty("pet_3_description")
    private String pet3Description;

    /**
     * 寵物 3 道具資訊
     */
    @JsonProperty("pet_3_equipment")
    private CharacterPetEquipmentItemDTO pet3Equipment;

    /**
     * 寵物 3 的寵物自動加持技能資訊
     */
    @JsonProperty("pet_3_auto_skill")
    private CharacterPetEquipmentAutoSkillDTO pet3AutoSkill;

    /**
     * 寵物 3 神奇寵物類型
     */
    @JsonProperty("pet_3_pet_type")
    private String pet3PetType;

    /**
     * 寵物 3 技能
     */
    @JsonProperty("pet_3_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> pet3Skill;

    /**
     * 寵物 3 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
     */
    @JsonProperty("pet_3_date_expire")
    private String pet3DateExpire;

    /**
     * 寵物 3 外型
     */
    @JsonProperty("pet_3_appearance")
    private String pet3Appearance;

    /**
     * 寵物 3 外型圖示
     */
    @JsonProperty("pet_3_appearance_icon")
    private String pet3AppearanceIcon;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }

    /**
     * 寵物 2 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
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
     * 寵物 2 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
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
     * 寵物 3 魔法時間 (TST，時間單位資料中的分鐘顯示為 0)
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
