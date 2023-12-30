package dev.spiralmoon.maplestory.api.template;

import dev.spiralmoon.maplestory.api.dto.union.UnionDTO;
import dev.spiralmoon.maplestory.api.dto.union.UnionRaiderDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UnionApi {

    @GET("maplestory/v1/user/union")
    Call<UnionDTO> getUnion(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/user/union-raider")
    Call<UnionRaiderDTO> getUnionRaider(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);
}
