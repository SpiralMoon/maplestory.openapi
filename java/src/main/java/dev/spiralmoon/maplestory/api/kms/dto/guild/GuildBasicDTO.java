package dev.spiralmoon.maplestory.api.kms.dto.guild;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 길드 기본 정보
 */
@AllArgsConstructor
@Data
@ToString
public class GuildBasicDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildBasicDTO<GuildSkillDTO> {

    /**
     * 조회 기준일 (KST, 일 단위 데이터로 시, 분은 일괄 0으로 표기)
     */
    @SerializedName("date")
    private String date;

    /**
     * 월드 명
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 길드 명
     */
    @SerializedName("guild_name")
    private String guildName;

    /**
     * 길드 레벨
     */
    @SerializedName("guild_level")
    private long guildLevel;

    /**
     * 길드 명성치
     */
    @SerializedName("guild_fame")
    private long guildFame;

    /**
     * 길드 포인트(GP)
     */
    @SerializedName("guild_point")
    private long guildPoint;

    /**
     * 길드 마스터 캐릭터 명
     */
    @SerializedName("guild_master_name")
    private String guildMasterName;

    /**
     * 길드원 수
     */
    @SerializedName("guild_member_count")
    private long guildMemberCount;

    /**
     * 길드원 목록
     */
    @SerializedName("guild_member")
    private List<String> guildMember;

    /**
     * 길드 스킬 목록
     */
    @SerializedName("guild_skill")
    private List<GuildSkillDTO> guildSkill;

    /**
     * 노블레스 스킬 목록
     */
    @SerializedName("guild_noblesse_skill")
    private List<GuildSkillDTO> guildNoblesseSkill;

    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
