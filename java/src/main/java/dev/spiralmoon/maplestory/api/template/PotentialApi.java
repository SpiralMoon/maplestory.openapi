package dev.spiralmoon.maplestory.api.template;

import dev.spiralmoon.maplestory.api.dto.history.PotentialHistoryResponseDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface PotentialApi {

    @GET("maplestory/v1/history/potential")
    Call<PotentialHistoryResponseDTO> getPotentialHistoryByDate(@Header("x-nxopen-api-key") String apiKey, @Query("count") int count, @Query("date") String date);

    @GET("maplestory/v1/history/potential")
    Call<PotentialHistoryResponseDTO> getPotentialHistoryByCursor(@Header("x-nxopen-api-key") String apiKey, @Query("count") int count, @Query("cursor") String cursor);
}
