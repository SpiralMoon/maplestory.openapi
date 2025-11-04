package dev.spiralmoon.maplestory.api.msea.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface GuildApi {

    @GET("maplestorysea/v1/guild/id")
    Call<ResponseBody> getGuild(@Header("x-nxopen-api-key") String apiKey, @Query("guild_name") String guildName, @Query("world_name") String worldName);

    @GET("maplestorysea/v1/guild/basic")
    Call<ResponseBody> getGuildBasic(@Header("x-nxopen-api-key") String apiKey, @Query("oguild_id") String oguildId, @Query("date") String date);
}
