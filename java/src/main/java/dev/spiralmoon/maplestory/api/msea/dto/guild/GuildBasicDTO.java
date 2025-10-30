package dev.spiralmoon.maplestory.api.msea.dto.guild;

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
 * Guild basic information
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class GuildBasicDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildBasicDTO<GuildSkillDTO> {

    /**
     * Reference date for query (SGT, daily data with hours and minutes set to 0)
     */
    @JsonProperty("date")
    private String date;

    /**
     * World name
     */
    @JsonProperty("world_name")
    private String worldName;

    /**
     * Guild name
     */
    @JsonProperty("guild_name")
    private String guildName;

    /**
     * Guild level
     */
    @JsonProperty("guild_level")
    private long guildLevel;

    /**
     * Honor EXP
     */
    @JsonProperty("guild_fame")
    private long guildFame;

    /**
     * Guild Points (GP)
     */
    @JsonProperty("guild_point")
    private long guildPoint;

    /**
     * Character name of the Guild Master
     */
    @JsonProperty("guild_master_name")
    private String guildMasterName;

    /**
     * Number of guild members
     */
    @JsonProperty("guild_member_count")
    private long guildMemberCount;

    /**
     * List of guild members
     */
    @JsonProperty("guild_member")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<String> guildMember;

    /**
     * List of guild skills
     */
    @JsonProperty("guild_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
    private List<GuildSkillDTO> guildSkill;

    /**
     * List of Noblesse Guild Skills
     */
    @JsonProperty("guild_noblesse_skill")
    @JsonSetter(nulls = Nulls.AS_EMPTY)
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
