package dev.spiralmoon.maplestory.api.kms.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Friends User API template with Bearer token authentication.
 */
public interface FriendsUserApi {

    @GET("maplestory/v1/character/list")
    Call<ResponseBody> getCharacterList(@Header("Authorization") String authorization);

    @GET("maplestory/v1/user/achievement")
    Call<ResponseBody> getAchievement(@Header("Authorization") String authorization);
}
