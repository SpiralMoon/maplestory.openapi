package dev.spiralmoon.maplestory.api.template;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface InspectionInfoApi {

    @POST("soap/maplestory.asmx")
    @Headers({
            "SOAPAction: https://api.maplestory.nexon.com/soap/GetInspectionInfo",
            "Content-Type: text/xml; charset=utf-8"
    })
    Call<String> getInspectionInfo(@Body RequestBody soapEnvelop);
}
