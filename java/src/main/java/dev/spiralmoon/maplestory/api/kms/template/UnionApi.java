package dev.spiralmoon.maplestory.api.kms.template;

import dev.spiralmoon.maplestory.api.kms.dto.union.UnionArtifactDTO;
import dev.spiralmoon.maplestory.api.kms.dto.union.UnionChampionDTO;
import dev.spiralmoon.maplestory.api.kms.dto.union.UnionDTO;
import dev.spiralmoon.maplestory.api.kms.dto.union.UnionRaiderDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UnionApi {

    @GET("maplestory/v1/user/union")
    Call<UnionDTO> getUnion(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/user/union-raider")
    Call<UnionRaiderDTO> getUnionRaider(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/user/union-artifact")
    Call<UnionArtifactDTO> getUnionArtifact(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/user/union-champion")
    Call<UnionChampionDTO> getUnionChampion(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);
}
