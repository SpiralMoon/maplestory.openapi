package dev.spiralmoon.maplestory.api.kms.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Friends Cube API template with Bearer token authentication.
 */
public interface FriendsCubeApi {

    @GET("maplestory/v1/history/cube")
    Call<ResponseBody> getCubeHistoryByDate(@Header("Authorization") String authorization, @Query("count") int count, @Query("date") String date);

    @GET("maplestory/v1/history/cube")
    Call<ResponseBody> getCubeHistoryByCursor(@Header("Authorization") String authorization, @Query("count") int count, @Query("cursor") String cursor);
}
