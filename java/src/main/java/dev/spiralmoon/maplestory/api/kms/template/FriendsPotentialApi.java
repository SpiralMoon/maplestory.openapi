package dev.spiralmoon.maplestory.api.kms.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Friends Potential API template with Bearer token authentication.
 */
public interface FriendsPotentialApi {

    @GET("maplestory/v1/history/potential")
    Call<ResponseBody> getPotentialHistoryByDate(@Header("Authorization") String authorization, @Query("count") int count, @Query("date") String date);

    @GET("maplestory/v1/history/potential")
    Call<ResponseBody> getPotentialHistoryByCursor(@Header("Authorization") String authorization, @Query("count") int count, @Query("cursor") String cursor);
}
