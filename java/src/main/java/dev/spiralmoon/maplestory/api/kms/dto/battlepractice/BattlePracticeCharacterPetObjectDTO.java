package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

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
import java.util.ArrayList;

/**
 * 연무장 입장 시 캐릭터 장착 펫 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterPetObjectDTO {

    /**
     * 활성화된 펫 유형 (0:캐릭터 펫, 1:월드 공유 펫)
     */
    @JsonProperty("pet_activate_flag")
    private String petActivateFlag;

    /**
     * 펫1 명
     */
    @JsonProperty("pet_1_name")
    private String pet1Name;

    /**
     * 펫1 닉네임
     */
    @JsonProperty("pet_1_nickname")
    private String pet1Nickname;

    /**
     * 펫1 아이콘
     */
    @JsonProperty("pet_1_icon")
    private String pet1Icon;

    /**
     * 펫1 설명
     */
    @JsonProperty("pet_1_description")
    private String pet1Description;

    /**
     * 펫1 장착 정보
     */
    @JsonProperty("pet_1_equipment")
    private BattlePracticeCharacterPetEquipmentDTO pet1Equipment;

    /**
     * 펫1 버프 자동스킬 정보
     */
    @JsonProperty("pet_1_auto_skill")
    private BattlePracticeCharacterPetAutoSkillDTO pet1AutoSkill;

    /**
     * 펫1 원더 펫 종류
     */
    @JsonProperty("pet_1_pet_type")
    private String pet1PetType;

    /**
     * 펫1 펫 보유 스킬
     */
    @JsonProperty("pet_1_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> pet1Skill;

    /**
     * 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @JsonProperty("pet_1_date_expire")
    private String pet1DateExpire;

    /**
     * 펫2 명
     */
    @JsonProperty("pet_2_name")
    private String pet2Name;

    /**
     * 펫2 닉네임
     */
    @JsonProperty("pet_2_nickname")
    private String pet2Nickname;

    /**
     * 펫2 아이콘
     */
    @JsonProperty("pet_2_icon")
    private String pet2Icon;

    /**
     * 펫2 설명
     */
    @JsonProperty("pet_2_description")
    private String pet2Description;

    /**
     * 펫2 장착 정보
     */
    @JsonProperty("pet_2_equipment")
    private BattlePracticeCharacterPetEquipmentDTO pet2Equipment;

    /**
     * 펫2 버프 자동스킬 정보
     */
    @JsonProperty("pet_2_auto_skill")
    private BattlePracticeCharacterPetAutoSkillDTO pet2AutoSkill;

    /**
     * 펫2 원더 펫 종류
     */
    @JsonProperty("pet_2_pet_type")
    private String pet2PetType;

    /**
     * 펫2 펫 보유 스킬
     */
    @JsonProperty("pet_2_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> pet2Skill;

    /**
     * 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @JsonProperty("pet_2_date_expire")
    private String pet2DateExpire;

    /**
     * 펫3 명
     */
    @JsonProperty("pet_3_name")
    private String pet3Name;

    /**
     * 펫3 닉네임
     */
    @JsonProperty("pet_3_nickname")
    private String pet3Nickname;

    /**
     * 펫3 아이콘
     */
    @JsonProperty("pet_3_icon")
    private String pet3Icon;

    /**
     * 펫3 설명
     */
    @JsonProperty("pet_3_description")
    private String pet3Description;

    /**
     * 펫3 장착 정보
     */
    @JsonProperty("pet_3_equipment")
    private BattlePracticeCharacterPetEquipmentDTO pet3Equipment;

    /**
     * 펫3 버프 자동스킬 정보
     */
    @JsonProperty("pet_3_auto_skill")
    private BattlePracticeCharacterPetAutoSkillDTO pet3AutoSkill;

    /**
     * 펫3 원더 펫 종류
     */
    @JsonProperty("pet_3_pet_type")
    private String pet3PetType;

    /**
     * 펫3 펫 보유 스킬
     */
    @JsonProperty("pet_3_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> pet3Skill;

    /**
     * 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @JsonProperty("pet_3_date_expire")
    private String pet3DateExpire;

    /**
     * 월드 공유 펫1 명
     */
    @JsonProperty("world_share_pet_1_name")
    private String worldSharePet1Name;

    /**
     * 월드 공유 펫1 닉네임
     */
    @JsonProperty("world_share_pet_1_nickname")
    private String worldSharePet1Nickname;

    /**
     * 월드 공유 펫1 아이콘
     */
    @JsonProperty("world_share_pet_1_icon")
    private String worldSharePet1Icon;

    /**
     * 월드 공유 펫1 설명
     */
    @JsonProperty("world_share_pet_1_description")
    private String worldSharePet1Description;

    /**
     * 월드 공유 펫1 원더 펫 종류
     */
    @JsonProperty("world_share_pet_1_pet_type")
    private String worldSharePet1PetType;

    /**
     * 월드 공유 펫1 장착 정보
     */
    @JsonProperty("world_share_pet_1_equipment")
    private BattlePracticeCharacterPetEquipmentDTO worldSharePet1Equipment;

    /**
     * 월드 공유 펫1 버프 자동스킬 정보
     */
    @JsonProperty("world_share_pet_1_auto_skill")
    private BattlePracticeCharacterPetAutoSkillDTO worldSharePet1AutoSkill;

    /**
     * 월드 공유 펫1 펫 보유 스킬
     */
    @JsonProperty("world_share_pet_1_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> worldSharePet1Skill = new ArrayList<>();

    /**
     * 월드 공유 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @JsonProperty("world_share_pet_1_date_expire")
    private String worldSharePet1DateExpire;

    /**
     * 월드 공유 펫2 명
     */
    @JsonProperty("world_share_pet_2_name")
    private String worldSharePet2Name;

    /**
     * 월드 공유 펫2 닉네임
     */
    @JsonProperty("world_share_pet_2_nickname")
    private String worldSharePet2Nickname;

    /**
     * 월드 공유 펫2 아이콘
     */
    @JsonProperty("world_share_pet_2_icon")
    private String worldSharePet2Icon;

    /**
     * 월드 공유 펫2 설명
     */
    @JsonProperty("world_share_pet_2_description")
    private String worldSharePet2Description;

    /**
     * 월드 공유 펫2 원더 펫 종류
     */
    @JsonProperty("world_share_pet_2_pet_type")
    private String worldSharePet2PetType;

    /**
     * 월드 공유 펫2 장착 정보
     */
    @JsonProperty("world_share_pet_2_equipment")
    private BattlePracticeCharacterPetEquipmentDTO worldSharePet2Equipment;

    /**
     * 월드 공유 펫2 버프 자동스킬 정보
     */
    @JsonProperty("world_share_pet_2_auto_skill")
    private BattlePracticeCharacterPetAutoSkillDTO worldSharePet2AutoSkill;

    /**
     * 월드 공유 펫2 펫 보유 스킬
     */
    @JsonProperty("world_share_pet_2_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> worldSharePet2Skill = new ArrayList<>();

    /**
     * 월드 공유 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @JsonProperty("world_share_pet_2_date_expire")
    private String worldSharePet2DateExpire;

    /**
     * 월드 공유 펫3 명
     */
    @JsonProperty("world_share_pet_3_name")
    private String worldSharePet3Name;

    /**
     * 월드 공유 펫3 닉네임
     */
    @JsonProperty("world_share_pet_3_nickname")
    private String worldSharePet3Nickname;

    /**
     * 월드 공유 펫3 아이콘
     */
    @JsonProperty("world_share_pet_3_icon")
    private String worldSharePet3Icon;

    /**
     * 월드 공유 펫3 설명
     */
    @JsonProperty("world_share_pet_3_description")
    private String worldSharePet3Description;

    /**
     * 월드 공유 펫3 원더 펫 종류
     */
    @JsonProperty("world_share_pet_3_pet_type")
    private String worldSharePet3PetType;

    /**
     * 월드 공유 펫3 장착 정보
     */
    @JsonProperty("world_share_pet_3_equipment")
    private BattlePracticeCharacterPetEquipmentDTO worldSharePet3Equipment;

    /**
     * 월드 공유 펫3 버프 자동스킬 정보
     */
    @JsonProperty("world_share_pet_3_auto_skill")
    private BattlePracticeCharacterPetAutoSkillDTO worldSharePet3AutoSkill;

    /**
     * 월드 공유 펫3 펫 보유 스킬
     */
    @JsonProperty("world_share_pet_3_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> worldSharePet3Skill = new ArrayList<>();

    /**
     * 월드 공유 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    @JsonProperty("world_share_pet_3_date_expire")
    private String worldSharePet3DateExpire;

    /**
     * 루나 쁘띠 펫 스킬 정보
     */
    @JsonProperty("petite_luna_pet_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<BattlePracticeCharacterPetiteLunaPetSkillDTO> petiteLunaPetSkill = new ArrayList<>();

    /**
     * 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getPet1DateExpire() {
        return pet1DateExpire != null
                ? Utils.toZonedDateTime(this.pet1DateExpire)
                : null;
    }

    /**
     * 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getPet2DateExpire() {
        return pet2DateExpire != null
                ? Utils.toZonedDateTime(this.pet2DateExpire)
                : null;
    }

    /**
     * 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getPet3DateExpire() {
        return pet3DateExpire != null
                ? Utils.toZonedDateTime(this.pet3DateExpire)
                : null;
    }

    /**
     * 월드 공유 펫1 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getWorldSharePet1DateExpire() {
        return worldSharePet1DateExpire != null
                ? Utils.toZonedDateTime(this.worldSharePet1DateExpire)
                : null;
    }

    /**
     * 월드 공유 펫2 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getWorldSharePet2DateExpire() {
        return worldSharePet2DateExpire != null
                ? Utils.toZonedDateTime(this.worldSharePet2DateExpire)
                : null;
    }

    /**
     * 월드 공유 펫3 마법의 시간 (KST, 시간 단위 데이터로 분은 일괄 0으로 표기)
     */
    public ZonedDateTime getWorldSharePet3DateExpire() {
        return worldSharePet3DateExpire != null
                ? Utils.toZonedDateTime(this.worldSharePet3DateExpire)
                : null;
    }
}
