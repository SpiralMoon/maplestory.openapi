package dev.spiralmoon.maplestory.api.kms.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Friends Starforce API template with Bearer token authentication.
 */
public interface FriendsStarforceApi {

    @GET("maplestory/v1/history/starforce")
    Call<ResponseBody> getStarforceHistoryByDate(@Header("Authorization") String authorization, @Query("count") int count, @Query("date") String date);

    @GET("maplestory/v1/history/starforce")
    Call<ResponseBody> getStarforceHistoryByCursor(@Header("Authorization") String authorization, @Query("count") int count, @Query("cursor") String cursor);
}
