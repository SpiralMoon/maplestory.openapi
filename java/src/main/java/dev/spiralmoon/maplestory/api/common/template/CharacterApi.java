package dev.spiralmoon.maplestory.api.common.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface CharacterApi {
    @GET("{path}")
    Call<ResponseBody> getCharacterImage(@Path(value = "path", encoded = true) String path, @Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date, @QueryMap Map<String, String> queries);
}
