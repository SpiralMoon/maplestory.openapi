package dev.spiralmoon.maplestory.api.common.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CharacterApi {
    @GET("{path}")
    Call<ResponseBody> getCharacterImage(@Path(value = "path", encoded = true) String path, @Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date, @Query("action") String action, @Query("emotion") String emotion, @Query("wmotion") String wmotion, @Query("width") Integer width, @Query("height") Integer height, @Query("x") Integer x, @Query("y") Integer y);
}
