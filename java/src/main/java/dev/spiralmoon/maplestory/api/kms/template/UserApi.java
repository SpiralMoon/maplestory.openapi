package dev.spiralmoon.maplestory.api.kms.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface UserApi {

    @GET("maplestory/v1/character/list")
    Call<ResponseBody> getCharacterList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/user/achievement")
    Call<ResponseBody> getAchievement(@Header("x-nxopen-api-key") String apiKey);
}
