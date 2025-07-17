package dev.spiralmoon.maplestory.api.kms.template;

import dev.spiralmoon.maplestory.api.kms.dto.user.AchievementDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface UserApi {

    @GET("maplestory/v1/user/achievement")
    Call<AchievementDTO> getAchievement(@Header("x-nxopen-api-key") String apiKey);
}
