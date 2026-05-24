package dev.spiralmoon.maplestory.api.kms.dto.battlepractice;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 연무장 입장 시 캐릭터 능력치 관련 정보
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class BattlePracticeCharacterInfoDTO {

    /**
     * 캐릭터 기본 정보
     */
    @JsonProperty("basic_object")
    private BattlePracticeCharacterBasicDTO basicObject;

    /**
     * 캐릭터 스탯 정보
     */
    @JsonProperty("stat_object")
    private BattlePracticeCharacterStatDTO statObject;

    /**
     * 캐릭터 하이퍼스탯 정보
     */
    @JsonProperty("hyper_stat_object")
    private BattlePracticeCharacterHyperStatObjectDTO hyperStatObject;

    /**
     * 캐릭터 성향 정보
     */
    @JsonProperty("propensity_object")
    private BattlePracticeCharacterPropensityDTO propensityObject;

    /**
     * 캐릭터 어빌리티 정보
     */
    @JsonProperty("ability_object")
    private BattlePracticeCharacterAbilityObjectDTO abilityObject;

    /**
     * 캐릭터 장비 정보
     */
    @JsonProperty("item_object")
    private BattlePracticeCharacterItemObjectDTO itemObject;

    /**
     * 캐릭터 캐시 장비 정보
     */
    @JsonProperty("cash_item_object")
    private BattlePracticeCharacterCashItemObjectDTO cashItemObject;

    /**
     * 캐릭터 펫 장비 정보
     */
    @JsonProperty("pet_object")
    private BattlePracticeCharacterPetObjectDTO petObject;

    /**
     * 캐릭터 스킬 정보
     */
    @JsonProperty("skill_object")
    private BattlePracticeCharacterSkillObjectDTO skillObject;

    /**
     * 캐릭터 링크 스킬 정보
     */
    @JsonProperty("link_skill_object")
    private BattlePracticeCharacterLinkSkillObjectDTO linkSkillObject;

    /**
     * 캐릭터 V매트릭스 정보
     */
    @JsonProperty("v_matrix_object")
    private BattlePracticeCharacterVMatrixObjectDTO vMatrixObject;

    /**
     * 캐릭터 HEXA 매트릭스 정보
     */
    @JsonProperty("hexa_matrix_object")
    private BattlePracticeCharacterHexaMatrixObjectDTO hexaMatrixObject;

    /**
     * 캐릭터 예비 특수 반지 장착 정보
     */
    @JsonProperty("ring_reserve_skill_object")
    private BattlePracticeCharacterRingReserveSkillObjectDTO ringReserveSkillObject;

    /**
     * 유니온 공격대 정보
     */
    @JsonProperty("union_raider_object")
    private BattlePracticeUnionRaiderObjectDTO unionRaiderObject;

    /**
     * 유니온 아티팩트 정보
     */
    @JsonProperty("union_artifact_object")
    private BattlePracticeUnionArtifactObjectDTO unionArtifactObject;

    /**
     * 유니온 챔피언 정보
     */
    @JsonProperty("union_champion_object")
    private BattlePracticeUnionChampionObjectDTO unionChampionObject;

    /**
     * 길드 정보
     */
    @JsonProperty("guild_object")
    private BattlePracticeGuildObjectDTO guildObject;
}
