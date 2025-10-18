package dev.spiralmoon.maplestory.api.tms.template;

import dev.spiralmoon.maplestory.api.tms.dto.guild.GuildBasicDTO;
import dev.spiralmoon.maplestory.api.tms.dto.guild.GuildDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface GuildApi {

    @GET("maplestorytw/v1/guild/id")
    Call<GuildDTO> getGuild(@Header("x-nxopen-api-key") String apiKey, @Query("guild_name") String guildName, @Query("world_name") String worldName);

    @GET("maplestorytw/v1/guild/basic")
    Call<GuildBasicDTO> getGuildBasic(@Header("x-nxopen-api-key") String apiKey, @Query("oguild_id") String oguildId, @Query("date") String date);
}
