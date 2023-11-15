package dev.spiralmoon.maplestory.api.template;

import dev.spiralmoon.maplestory.api.dto.CubeHistoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CubeApi {

    @GET("openapi/maplestory/v1/cube-use-results")
    Call<CubeHistoryResponseDTO> getCubeResultByDate(@Header("authorization") String authorization, @Query("count") int count, @Query("date") String date);

    @GET("openapi/maplestory/v1/cube-use-results")
    Call<CubeHistoryResponseDTO> getCubeResultByCursor(@Header("authorization") String authorization, @Query("count") int count, @Query("cursor") String cursor);
}
