package dev.spiralmoon.maplestory.api.tms.dto.guild;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * 公會基本資訊
 */
@AllArgsConstructor
@Data
@ToString
public class GuildBasicDTO implements dev.spiralmoon.maplestory.api.common.dto.guild.GuildBasicDTO<GuildSkillDTO> {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 世界名稱
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 公會名稱
     */
    @SerializedName("guild_name")
    private String guildName;

    /**
     * 公會等級
     */
    @SerializedName("guild_level")
    private long guildLevel;

    /**
     * 公會名聲值
     */
    @SerializedName("guild_fame")
    private long guildFame;

    /**
     * 公會點數 (GP)
     */
    @SerializedName("guild_point")
    private long guildPoint;

    /**
     * 公會會長角色名稱
     */
    @SerializedName("guild_master_name")
    private String guildMasterName;

    /**
     * 公會成員人數
     */
    @SerializedName("guild_member_count")
    private long guildMemberCount;

    /**
     * 公會成員清單
     */
    @SerializedName("guild_member")
    private List<String> guildMember;

    /**
     * 公會技能清單
     */
    @SerializedName("guild_skill")
    private List<GuildSkillDTO> guildSkill;

    /**
     * 貴族技能清單
     */
    @SerializedName("guild_noblesse_skill")
    private List<GuildSkillDTO> guildNoblesseSkill;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }
}
