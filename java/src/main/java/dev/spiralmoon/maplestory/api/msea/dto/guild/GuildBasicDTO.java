package dev.spiralmoon.maplestory.api.msea.dto.guild;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Guild basic information
 */
@AllArgsConstructor
@Data
@ToString
public class GuildBasicDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildBasicDTO<GuildSkillDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * World name
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * Guild name
     */
    @SerializedName("guild_name")
    private String guildName;

    /**
     * Guild level
     */
    @SerializedName("guild_level")
    private long guildLevel;

    /**
     * Honor EXP
     */
    @SerializedName("guild_fame")
    private long guildFame;

    /**
     * Guild Points (GP)
     */
    @SerializedName("guild_point")
    private long guildPoint;

    /**
     * Character name of the Guild Master
     */
    @SerializedName("guild_master_name")
    private String guildMasterName;

    /**
     * Number of guild members
     */
    @SerializedName("guild_member_count")
    private long guildMemberCount;

    /**
     * List of guild members
     */
    @SerializedName("guild_member")
    private List<String> guildMember;

    /**
     * List of guild skills
     */
    @SerializedName("guild_skill")
    private List<GuildSkillDTO> guildSkill;

    /**
     * List of Noblesse Guild Skills
     */
    @SerializedName("guild_noblesse_skill")
    private List<GuildSkillDTO> guildNoblesseSkill;

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
