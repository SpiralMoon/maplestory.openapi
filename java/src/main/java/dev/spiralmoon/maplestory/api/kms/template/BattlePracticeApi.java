package dev.spiralmoon.maplestory.api.kms.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface BattlePracticeApi {

    @GET("maplestory/v1/battle-practice/replay-id")
    Call<ResponseBody> getBattlePracticeReplayId(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid);

    @GET("maplestory/v1/battle-practice/result")
    Call<ResponseBody> getBattlePracticeResult(@Header("x-nxopen-api-key") String apiKey, @Query("replay_id") String replayId);

    @GET("maplestory/v1/battle-practice/skill-timeline")
    Call<ResponseBody> getBattlePracticeSkillTimeline(@Header("x-nxopen-api-key") String apiKey, @Query("replay_id") String replayId, @Query("page_no") Integer pageNo);

    @GET("maplestory/v1/battle-practice/character-info")
    Call<ResponseBody> getBattlePracticeCharacterInfo(@Header("x-nxopen-api-key") String apiKey, @Query("replay_id") String replayId);
}
