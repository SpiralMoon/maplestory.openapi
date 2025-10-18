package dev.spiralmoon.maplestory.api.tms.template;

import dev.spiralmoon.maplestory.api.tms.dto.union.UnionArtifactDTO;
import dev.spiralmoon.maplestory.api.tms.dto.union.UnionDTO;
import dev.spiralmoon.maplestory.api.tms.dto.union.UnionRaiderDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UnionApi {

    @GET("maplestorytw/v1/user/union")
    Call<UnionDTO> getUnion(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorytw/v1/user/union-raider")
    Call<UnionRaiderDTO> getUnionRaider(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorytw/v1/user/union-artifact")
    Call<UnionArtifactDTO> getUnionArtifact(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);
}
