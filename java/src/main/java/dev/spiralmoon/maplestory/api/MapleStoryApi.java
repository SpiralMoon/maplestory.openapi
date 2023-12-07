package dev.spiralmoon.maplestory.api;

import com.google.gson.Gson;
import dev.spiralmoon.maplestory.api.callback.FailureCallback;
import dev.spiralmoon.maplestory.api.callback.SuccessCallback;
import dev.spiralmoon.maplestory.api.dto.CubeHistoryResponseDTO;
import dev.spiralmoon.maplestory.api.dto.InspectionInfoDTO;
import dev.spiralmoon.maplestory.api.template.CubeApi;
import dev.spiralmoon.maplestory.api.template.InspectionInfoApi;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * MapleStory OpenAPI client.<br>
 * This is an implementation of <a href="https://developers.nexon.com/Maplestory/apiList">MapleStory API</a>
 */
public class MapleStoryApi {

    private final String apiKey;

    private static final String BASE_URL = "https://public.api.nexon.com/";

    // in milliseconds
    @Getter
    @Setter
    private long timeout;

    public MapleStoryApi(String apiKey) {
        this.apiKey = apiKey;
        this.timeout = 5000;
    }

    /**
     * 오늘 날짜의 확률형 아이템 큐브의 사용 결과를 조회합니다.<br>
     * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
     * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
     */
    public CubeHistoryResponseDTO getCubeResult(int count) throws IOException {

        final LocalDate kstNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
        final int year = kstNow.getYear();
        final int month = kstNow.getMonthValue();
        final int day = kstNow.getDayOfMonth();

        return this.getCubeResult(count, year, month, day);
    }

    /**
     * 오늘 날짜의 확률형 아이템 큐브의 사용 결과를 비동기로 조회합니다.<br>
     * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
     * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
     */
    public void getCubeResult(int count, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        final LocalDate kstNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
        final int year = kstNow.getYear();
        final int month = kstNow.getMonthValue();
        final int day = kstNow.getDayOfMonth();

        this.getCubeResult(count, year, month, day, onSuccess, onFailure);
    }

    /**
     * 지목한 날짜의 확률형 아이템 큐브의 사용 결과를 조회합니다.<br>
     * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
     * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
     * @param year  조회할 연도
     * @param month 조회할 월
     * @param day   조회할 월의 날짜
     */
    public CubeHistoryResponseDTO getCubeResult(int count, int year, int month, int day) throws IOException {

        if (year <= 2022 && month <= 11 && day < 25) {
            throw new IllegalArgumentException("You can only retrieve data after 2022-11-25.");
        }

        final LocalDate date = LocalDate.of(year, month, day);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final String yyyyMMdd = date.format(formatter);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CubeApi cubeApi = retrofit.create(CubeApi.class);
        final Call<CubeHistoryResponseDTO> call = cubeApi.getCubeResultByDate(this.apiKey, count, yyyyMMdd);

        final Response<CubeHistoryResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 지목한 날짜의 확률형 아이템 큐브의 사용 결과를 비동기로 조회합니다.<br>
     * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
     * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
     * @param year  조회할 연도
     * @param month 조회할 월
     * @param day   조회할 월의 날짜
     */
    public void getCubeResult(int count, int year, int month, int day, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        if (year <= 2022 && month <= 11 && day < 25) {
            throw new IllegalArgumentException("You can only retrieve data after 2022-11-25.");
        }

        final LocalDate date = LocalDate.of(year, month, day);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final String yyyyMMdd = date.format(formatter);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CubeApi cubeApi = retrofit.create(CubeApi.class);
        final Call<CubeHistoryResponseDTO> call = cubeApi.getCubeResultByDate(this.apiKey, count, yyyyMMdd);

        call.enqueue(new Callback<CubeHistoryResponseDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CubeHistoryResponseDTO> call, Response<CubeHistoryResponseDTO> response) {
                if (response.isSuccessful()) {
                    if (onSuccess != null) {
                        onSuccess.callback(response.body());
                    }
                } else {
                    if (onFailure != null) {
                        onFailure.callback(parseError(response));
                    }
                }
            }

            @Override
            public void onFailure(Call<CubeHistoryResponseDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 확률형 아이템 큐브의 사용 결과를 조회합니다.<br>
     * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
     * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
     */
    public CubeHistoryResponseDTO getCubeResult(int count, String cursor) throws IOException {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CubeApi cubeApi = retrofit.create(CubeApi.class);
        final Call<CubeHistoryResponseDTO> call = cubeApi.getCubeResultByCursor(this.apiKey, count, cursor);

        final Response<CubeHistoryResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 확률형 아이템 큐브의 사용 결과를 비동기로 조회합니다.<br>
     * 데이터는 일단위로 갱신되며, 오전 4시 조회 시 전일 데이터를 조회할 수 있습니다.<br>
     * 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 갯수(최소 10, 최대 1000) Default value : 10
     */
    public void getCubeResult(int count, String cursor, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CubeApi cubeApi = retrofit.create(CubeApi.class);
        final Call<CubeHistoryResponseDTO> call = cubeApi.getCubeResultByCursor(this.apiKey, count, cursor);

        call.enqueue(new Callback<CubeHistoryResponseDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CubeHistoryResponseDTO> call, Response<CubeHistoryResponseDTO> response) {
                if (response.isSuccessful()) {
                    if (onSuccess != null) {
                        onSuccess.callback(response.body());
                    }
                } else {
                    if (onFailure != null) {
                        onFailure.callback(parseError(response));
                    }
                }
            }

            @Override
            public void onFailure(Call<CubeHistoryResponseDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 서버 점검 정보를 조회합니다.
     */
    public InspectionInfoDTO getInspectionInfo() throws IOException {

        final String baseUrl = "https://api.maplestory.nexon.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(this.buildClient())
                .build();

        final String soapEnvelop =
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "  <soap:Body>\n" +
                "    <GetInspectionInfo xmlns=\"https://api.maplestory.nexon.com/soap/\" />\n" +
                "  </soap:Body>\n" +
                "</soap:Envelope>";
        final RequestBody body = RequestBody.create(MediaType.parse("text/xml; charset=utf-8"), soapEnvelop);

        final InspectionInfoApi inspectionInfoApi = retrofit.create(InspectionInfoApi.class);
        final Call<String> call = inspectionInfoApi.getInspectionInfo(body);

        final Response<String> response = call.execute();

        if (!response.isSuccessful()) {
            throw new MapleStoryApiException(400, "Bad Request");
        }

        return new InspectionInfoDTO(response.body());
    }

    /**
     * 서버 점검 정보를 비동기로 조회합니다.
     */
    public void getInspectionInfo(SuccessCallback<InspectionInfoDTO> onSuccess, FailureCallback onFailure) {

        final String baseUrl = "https://api.maplestory.nexon.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(this.buildClient())
                .build();

        final String soapEnvelop =
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "  <soap:Body>\n" +
                        "    <GetInspectionInfo xmlns=\"https://api.maplestory.nexon.com/soap/\" />\n" +
                        "  </soap:Body>\n" +
                        "</soap:Envelope>";
        final RequestBody body = RequestBody.create(MediaType.parse("text/xml; charset=utf-8"), soapEnvelop);

        final InspectionInfoApi inspectionInfoApi = retrofit.create(InspectionInfoApi.class);
        final Call<String> call = inspectionInfoApi.getInspectionInfo(body);

        call.enqueue(new Callback<String>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    if (onSuccess != null) {
                        onSuccess.callback(new InspectionInfoDTO(response.body()));
                    }
                } else {
                    if (onFailure != null) {
                        onFailure.callback(parseError(response));
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    private OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .build();
    }

    private static MapleStoryApiException parseError(Response<?> response) throws IOException {
        final Gson gson = new Gson();
        final MapleStoryApiErrorBody error = gson.fromJson(response.errorBody().string(), MapleStoryApiErrorBody.class);

        return new MapleStoryApiException(error);
    }
}

