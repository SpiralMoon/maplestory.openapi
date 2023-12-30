package dev.spiralmoon.maplestory.api.template;

import dev.spiralmoon.maplestory.api.dto.ranking.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RankingApi {

    @GET("maplestory/v1/ranking/overall")
    Call<OverallRankingResponseDTO> getOverallRanking(
            @Header("x-nxopen-api-key") String apiKey,
            @Query("date") String date,
            @Query("world_name") String worldName,
            @Query("world_type") Integer worldType,
            @Query("class") String characterClass,
            @Query("ocid") String ocid,
            @Query("page") Integer page
    );

    /**
     * 유니온 랭킹 정보 조회
     */
    @GET("maplestory/v1/ranking/union")
    Call<UnionRankingResponseDTO> getUnionRanking(
            @Header("x-nxopen-api-key") String apiKey,
            @Query("date") String date,
            @Query("world_name") String worldName,
            @Query("ocid") String ocid,
            @Query("page") Integer page
    );

    /**
     * 길드 랭킹 정보 조회
     */
    @GET("maplestory/v1/ranking/guild")
    Call<GuildRankingResponseDTO> getGuildRanking(
            @Header("x-nxopen-api-key") String apiKey,
            @Query("date") String date,
            @Query("world_name") String worldName,
            @Query("ranking_type") int rankingType,
            @Query("guild_name") String guildName,
            @Query("page") Integer page
    );

    /**
     * 무릉도장 랭킹 정보 조회
     */
    @GET("maplestory/v1/ranking/dojang")
    Call<DojangRankingResponseDTO> getDojangRanking(
            @Header("x-nxopen-api-key") String apiKey,
            @Query("date") String date,
            @Query("world_name") String worldName,
            @Query("difficulty") int difficulty,
            @Query("class") String characterClass,
            @Query("ocid") String ocid,
            @Query("page") Integer page
    );

    /**
     * 더 시드 랭킹 정보 조회
     */
    @GET("maplestory/v1/ranking/theseed")
    Call<TheSeedRankingResponseDTO> getTheSeedRanking(
            @Header("x-nxopen-api-key") String apiKey,
            @Query("date") String date,
            @Query("world_name") String worldName,
            @Query("ocid") String ocid,
            @Query("page") Integer page
    );

    /**
     * 업적 랭킹 정보 조회
     */
    @GET("maplestory/v1/ranking/achievement")
    Call<AchievementRankingResponseDTO> getAchievementRanking(
            @Header("x-nxopen-api-key") String apiKey,
            @Query("date") String date,
            @Query("ocid") String ocid,
            @Query("page") Integer page
    );
}
