package dev.spiralmoon.maplestory.api.kms.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NoticeApi {

    @GET("maplestory/v1/notice")
    Call<ResponseBody> getNoticeList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/notice/detail")
    Call<ResponseBody> getNoticeDetail(@Header("x-nxopen-api-key") String apiKey, @Query("notice_id") int noticeId);

    @GET("maplestory/v1/notice-update")
    Call<ResponseBody> getUpdateNoticeList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/notice-update/detail")
    Call<ResponseBody> getUpdateNoticeDetail(@Header("x-nxopen-api-key") String apiKey, @Query("notice_id") int noticeId);

    @GET("maplestory/v1/notice-event")
    Call<ResponseBody> getEventNoticeList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/notice-event/detail")
    Call<ResponseBody> getEventNoticeDetail(@Header("x-nxopen-api-key") String apiKey, @Query("notice_id") int noticeId);

    @GET("maplestory/v1/notice-cashshop")
    Call<ResponseBody> getCashshopNoticeList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/notice-cashshop/detail")
    Call<ResponseBody> getCashshopNoticeDetail(@Header("x-nxopen-api-key") String apiKey, @Query("notice_id") int noticeId);
}
