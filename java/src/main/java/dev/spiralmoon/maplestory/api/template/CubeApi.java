package dev.spiralmoon.maplestory.api.template;

import dev.spiralmoon.maplestory.api.dto.CubeHistoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CubeApi {

    @GET("maplestory/v1/history/cube")
    Call<CubeHistoryResponseDTO> getCubeResultByDate(@Header("x-nxopen-api-key") String apiKey, @Query("count") int count, @Query("date_kst") String date);

    @GET("maplestory/v1/history/cube")
    Call<CubeHistoryResponseDTO> getCubeResultByCursor(@Header("x-nxopen-api-key") String apiKey, @Query("count") int count, @Query("cursor") String cursor);
}
