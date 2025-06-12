package dev.spiralmoon.maplestory.api.kms.template;

import dev.spiralmoon.maplestory.api.kms.dto.notice.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface NoticeApi {

    @GET("maplestory/v1/notice")
    Call<NoticeListDTO> getNoticeList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/notice/detail")
    Call<NoticeDetailDTO> getNoticeDetail(@Header("x-nxopen-api-key") String apiKey, @Query("notice_id") int noticeId);

    @GET("maplestory/v1/notice-update")
    Call<UpdateNoticeListDTO> getUpdateNoticeList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/notice-update/detail")
    Call<UpdateNoticeDetailDTO> getUpdateNoticeDetail(@Header("x-nxopen-api-key") String apiKey, @Query("notice_id") int noticeId);

    @GET("maplestory/v1/notice-event")
    Call<EventNoticeListDTO> getEventNoticeList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/notice-event/detail")
    Call<EventNoticeDetailDTO> getEventNoticeDetail(@Header("x-nxopen-api-key") String apiKey, @Query("notice_id") int noticeId);

    @GET("maplestory/v1/notice-cashshop")
    Call<CashshopNoticeListDTO> getCashshopNoticeList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/notice-cashshop/detail")
    Call<CashshopNoticeDetailDTO> getCashshopNoticeDetail(@Header("x-nxopen-api-key") String apiKey, @Query("notice_id") int noticeId);
}
