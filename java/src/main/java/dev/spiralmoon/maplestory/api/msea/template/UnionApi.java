package dev.spiralmoon.maplestory.api.msea.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface UnionApi {

    @GET("maplestorysea/v1/user/union")
    Call<ResponseBody> getUnion(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/user/union-raider")
    Call<ResponseBody> getUnionRaider(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/user/union-artifact")
    Call<ResponseBody> getUnionArtifact(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/user/union-champion")
    Call<ResponseBody> getUnionChampion(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);
}
