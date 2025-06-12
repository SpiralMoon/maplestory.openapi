package dev.spiralmoon.maplestory.api.msea.template;

import dev.spiralmoon.maplestory.api.msea.dto.guild.GuildBasicDTO;
import dev.spiralmoon.maplestory.api.msea.dto.guild.GuildDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface GuildApi {

    @GET("maplestorysea/v1/guild/id")
    Call<GuildDTO> getGuild(@Header("x-nxopen-api-key") String apiKey, @Query("guild_name") String guildName, @Query("world_name") String worldName);

    @GET("maplestorysea/v1/guild/basic")
    Call<GuildBasicDTO> getGuildBasic(@Header("x-nxopen-api-key") String apiKey, @Query("oguild_id") String oguildId, @Query("date") String date);
}
