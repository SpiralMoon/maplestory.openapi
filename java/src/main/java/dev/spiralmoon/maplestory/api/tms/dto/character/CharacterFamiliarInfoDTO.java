package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * 萌獸 細節
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CharacterFamiliarInfoDTO {

    /**
     * 萌獸 名稱
     */
    @JsonProperty("familiar_name")
    private String familiarName;

    /**
     * 萌獸 暱稱
     */
    @JsonProperty("familiar_nickname")
    private String familiarNickname;

    /**
     * 特別與否
     */
    @JsonProperty("familiar_special_flag")
    private String familiarSpecialFlag;

    /**
     * 萌獸 情況
     */
    @JsonProperty("familiar_state")
    private String familiarState;

    /**
     * 等級
     */
    @JsonProperty("familiar_level")
    private long familiarLevel;

    /**
     * 經驗
     */
    @JsonProperty("familiar_exp")
    private long familiarExp;

    /**
     * 具備的技能
     */
    @JsonProperty("skill_name")
    private String skillName;

    /**
     * 選項等級
     */
    @JsonProperty("option_level")
    private long optionLevel;

    /**
     * 選項訊息
     */
    @JsonProperty("option")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<CharacterFamiliarInfoOptionDTO> option;

    /**
     * 等級
     */
    @JsonProperty("familiar_grade")
    private String familiarGrade;

    /**
     * 外觀名稱
     */
    @JsonProperty("look_name")
    private String lookName;

    /**
     * 當前是否已被召喚
     */
    @JsonProperty("summoned_flag")
    private String summonedFlag;

    /**
     * 連結槽索引 (1~3, vip, not link)
     */
    @JsonProperty("slot_id")
    private String slotId;
}
