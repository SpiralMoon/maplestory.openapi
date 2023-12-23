package dev.spiralmoon.maplestory.api;

import com.google.gson.Gson;
import dev.spiralmoon.maplestory.api.callback.FailureCallback;
import dev.spiralmoon.maplestory.api.callback.SuccessCallback;
import dev.spiralmoon.maplestory.api.dto.*;
import dev.spiralmoon.maplestory.api.template.*;
import lombok.Getter;
import lombok.NonNull;
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
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * MapleStory OpenAPI client.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a>
 */
public class MapleStoryApi {

    private final String apiKey;

    private static final String BASE_URL = "https://open.api.nexon.com/";

    // in milliseconds
    @Getter
    @Setter
    private long timeout;

    public MapleStoryApi(String apiKey) {
        this.apiKey = apiKey;
        this.timeout = 5000;
    }

    //#region 캐릭터 정보 조회

    /**
     * 캐릭터 식별자(ocid)를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param characterName 캐릭터 명
     */
    public CharacterDTO getCharacter(String characterName) throws IOException {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterDTO> call = characterApi.getCharacter(this.apiKey, characterName);

        final Response<CharacterDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 캐릭터 식별자(ocid)를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param characterName 캐릭터 명
     */
    public void getCharacterAsync(String characterName, SuccessCallback<CharacterDTO> onSuccess, FailureCallback onFailure) {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterDTO> call = characterApi.getCharacter(this.apiKey, characterName);

        call.enqueue(new Callback<CharacterDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterDTO> call, Response<CharacterDTO> response) {
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
            public void onFailure(Call<CharacterDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 기본 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterBasicDTO getCharacterBasic(String ocid) throws IOException {
        return this.getCharacterBasic(ocid, now());
    }

    /**
     * 기본 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterBasicDTO getCharacterBasic(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterBasicDTO> call = characterApi.getCharacterBasic(this.apiKey, ocid, date);

        final Response<CharacterBasicDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 기본 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid      캐릭터 식별자
     * @param onSuccess 성공 시 콜백
     * @param onFailure 실패 시 콜백
     */
    public void getCharacterBasicAsync(String ocid, SuccessCallback<CharacterBasicDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterBasicAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 기본 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterBasicAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterBasicDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterBasicDTO> call = characterApi.getCharacterBasic(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterBasicDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterBasicDTO> call, Response<CharacterBasicDTO> response) {
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
            public void onFailure(Call<CharacterBasicDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 인기도 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterPopularityDTO getCharacterPopularity(String ocid) throws IOException {
        return this.getCharacterPopularity(ocid, now());
    }

    /**
     * 인기도 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterPopularityDTO getCharacterPopularity(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterPopularityDTO> call = characterApi.getCharacterPopularity(this.apiKey, ocid, date);

        final Response<CharacterPopularityDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 인기도 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterPopularityAsync(String ocid, SuccessCallback<CharacterPopularityDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterPopularityAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 인기도 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterPopularityAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterPopularityDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterPopularityDTO> call = characterApi.getCharacterPopularity(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterPopularityDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterPopularityDTO> call, Response<CharacterPopularityDTO> response) {
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
            public void onFailure(Call<CharacterPopularityDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 종합 능력치 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterStatDTO getCharacterStat(String ocid) throws IOException {
        return this.getCharacterStat(ocid, now());
    }

    /**
     * 종합 능력치 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterStatDTO getCharacterStat(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterStatDTO> call = characterApi.getCharacterStat(this.apiKey, ocid, date);

        final Response<CharacterStatDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 종합 능력치 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterStatAsync(String ocid, SuccessCallback<CharacterStatDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterStatAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 종합 능력치 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterStatAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterStatDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterStatDTO> call = characterApi.getCharacterStat(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterStatDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterStatDTO> call, Response<CharacterStatDTO> response) {
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
            public void onFailure(Call<CharacterStatDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 하이퍼스탯 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterHyperStatDTO getCharacterHyperStat(String ocid) throws IOException {
        return this.getCharacterHyperStat(ocid, now());
    }

    /**
     * 하이퍼스탯 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterHyperStatDTO getCharacterHyperStat(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterHyperStatDTO> call = characterApi.getCharacterHyperStat(this.apiKey, ocid, date);

        final Response<CharacterHyperStatDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 하이퍼스탯 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterHyperStatAsync(String ocid, SuccessCallback<CharacterHyperStatDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterHyperStatAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 하이퍼스탯 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterHyperStatAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterHyperStatDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterHyperStatDTO> call = characterApi.getCharacterHyperStat(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterHyperStatDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterHyperStatDTO> call, Response<CharacterHyperStatDTO> response) {
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
            public void onFailure(Call<CharacterHyperStatDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 성향 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterPropensityDTO getCharacterPropensity(String ocid) throws IOException {
        return this.getCharacterPropensity(ocid, now());
    }

    /**
     * 성향 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterPropensityDTO getCharacterPropensity(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterPropensityDTO> call = characterApi.getCharacterPropensity(this.apiKey, ocid, date);

        final Response<CharacterPropensityDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 성향 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterPropensityAsync(String ocid, SuccessCallback<CharacterPropensityDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterPropensityAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 성향 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterPropensityAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterPropensityDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterPropensityDTO> call = characterApi.getCharacterPropensity(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterPropensityDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterPropensityDTO> call, Response<CharacterPropensityDTO> response) {
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
            public void onFailure(Call<CharacterPropensityDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 어빌리티 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterAbilityDTO getCharacterAbility(String ocid) throws IOException {
        return getCharacterAbility(ocid, now());
    }

    /**
     * 어빌리티 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterAbilityDTO getCharacterAbility(String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterAbilityDTO> call = characterApi.getCharacterAbility(this.apiKey, ocid, date);

        final Response<CharacterAbilityDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 어빌리티 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterAbilityAsync(String ocid, SuccessCallback<CharacterAbilityDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterAbilityAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 어빌리티 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterAbilityAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterAbilityDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterAbilityDTO> call = characterApi.getCharacterAbility(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterAbilityDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterAbilityDTO> call, Response<CharacterAbilityDTO> response) {
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
            public void onFailure(Call<CharacterAbilityDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterItemEquipmentDTO getCharacterItemEquipment(String ocid) throws IOException {
        return this.getCharacterItemEquipment(ocid, now());
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterItemEquipmentDTO getCharacterItemEquipment(String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterItemEquipmentDTO> call = characterApi.getCharacterItemEquipment(this.apiKey, ocid, date);

        final Response<CharacterItemEquipmentDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterItemEquipmentAsync(String ocid, SuccessCallback<CharacterItemEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterItemEquipmentAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterItemEquipmentAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterItemEquipmentDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterItemEquipmentDTO> call = characterApi.getCharacterItemEquipment(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterItemEquipmentDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterItemEquipmentDTO> call, Response<CharacterItemEquipmentDTO> response) {
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
            public void onFailure(Call<CharacterItemEquipmentDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 장착한 캐시 장비 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterAndroidCashItemEquipmentDTO getCharacterCashItemEquipment(String ocid) throws IOException {
        return this.getCharacterCashItemEquipment(ocid, now());
    }

    /**
     * 장착한 캐시 장비 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterAndroidCashItemEquipmentDTO getCharacterCashItemEquipment(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterAndroidCashItemEquipmentDTO> call = characterApi.getCharacterCashItemEquipment(this.apiKey, ocid, date);

        final Response<CharacterAndroidCashItemEquipmentDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 캐시 장비 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterCashItemEquipmentAsync(String ocid, SuccessCallback<CharacterAndroidCashItemEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterCashItemEquipmentAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 장착한 캐시 장비 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterCashItemEquipmentAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterAndroidCashItemEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterAndroidCashItemEquipmentDTO> call = characterApi.getCharacterCashItemEquipment(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterAndroidCashItemEquipmentDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterAndroidCashItemEquipmentDTO> call, Response<CharacterAndroidCashItemEquipmentDTO> response) {
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
            public void onFailure(Call<CharacterAndroidCashItemEquipmentDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 장착한 심볼 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterSymbolEquipmentDTO getCharacterSymbolEquipment(String ocid) throws IOException {
        return this.getCharacterSymbolEquipment(ocid, now());
    }

    /**
     * 장착한 심볼 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterSymbolEquipmentDTO getCharacterSymbolEquipment(String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterSymbolEquipmentDTO> call = characterApi.getCharacterSymbolEquipment(this.apiKey, ocid, date);

        final Response<CharacterSymbolEquipmentDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 심볼 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterSymbolEquipmentAsync(String ocid, SuccessCallback<CharacterSymbolEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterSymbolEquipmentAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 장착한 심볼 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterSymbolEquipmentAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterSymbolEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterSymbolEquipmentDTO> call = characterApi.getCharacterSymbolEquipment(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterSymbolEquipmentDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterSymbolEquipmentDTO> call, Response<CharacterSymbolEquipmentDTO> response) {
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
            public void onFailure(Call<CharacterSymbolEquipmentDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 적용받고 있는 세트 효과 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterSetEffectDTO getCharacterSetEffectAsync(String ocid) throws IOException {
        return this.getCharacterSetEffectAsync(ocid, now());
    }

    /**
     * 적용받고 있는 세트 효과 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterSetEffectDTO getCharacterSetEffectAsync(String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterSetEffectDTO> call = characterApi.getCharacterSetEffect(this.apiKey, ocid, date);

        final Response<CharacterSetEffectDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 적용받고 있는 세트 효과 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterSetEffectAsync(String ocid, SuccessCallback<CharacterSetEffectDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterSetEffectAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 적용받고 있는 세트 효과 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterSetEffectAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterSetEffectDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterSetEffectDTO> call = characterApi.getCharacterSetEffect(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterSetEffectDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterSetEffectDTO> call, Response<CharacterSetEffectDTO> response) {
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
            public void onFailure(Call<CharacterSetEffectDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterBeautyEquipmentDTO getCharacterBeautyEquipment(String ocid) throws IOException {
        return this.getCharacterBeautyEquipment(ocid, now());
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterBeautyEquipmentDTO getCharacterBeautyEquipment(String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterBeautyEquipmentDTO> call = characterApi.getCharacterBeautyEquipment(this.apiKey, ocid, date);

        final Response<CharacterBeautyEquipmentDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterBeautyEquipmentAsync(String ocid, SuccessCallback<CharacterBeautyEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterBeautyEquipmentAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterBeautyEquipmentAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterBeautyEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterBeautyEquipmentDTO> call = characterApi.getCharacterBeautyEquipment(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterBeautyEquipmentDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterBeautyEquipmentDTO> call, Response<CharacterBeautyEquipmentDTO> response) {
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
            public void onFailure(Call<CharacterBeautyEquipmentDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 장착한 안드로이드 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterAndroidEquipmentDTO getCharacterAndroidEquipment(String ocid) throws IOException {
        return getCharacterAndroidEquipment(ocid, now());
    }

    /**
     * 장착한 안드로이드 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterAndroidEquipmentDTO getCharacterAndroidEquipment(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterAndroidEquipmentDTO> call = characterApi.getCharacterAndroidEquipment(this.apiKey, ocid, date);

        final Response<CharacterAndroidEquipmentDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 안드로이드 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterAndroidEquipmentAsync(String ocid, SuccessCallback<CharacterAndroidEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterAndroidEquipmentAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 장착한 안드로이드 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterAndroidEquipmentAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterAndroidEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterAndroidEquipmentDTO> call = characterApi.getCharacterAndroidEquipment(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterAndroidEquipmentDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterAndroidEquipmentDTO> call, Response<CharacterAndroidEquipmentDTO> response) {
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
            public void onFailure(Call<CharacterAndroidEquipmentDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterPetEquipmentDTO getCharacterPetEquipment(String ocid) throws IOException {
        return this.getCharacterPetEquipment(ocid, now());
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterPetEquipmentDTO getCharacterPetEquipment(String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterPetEquipmentDTO> call = characterApi.getCharacterPetEquipment(this.apiKey, ocid, date);

        final Response<CharacterPetEquipmentDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterPetEquipmentAsync(String ocid, SuccessCallback<CharacterPetEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterPetEquipmentAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterPetEquipmentAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterPetEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterPetEquipmentDTO> call = characterApi.getCharacterPetEquipment(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterPetEquipmentDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterPetEquipmentDTO> call, Response<CharacterPetEquipmentDTO> response) {
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
            public void onFailure(Call<CharacterPetEquipmentDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid                캐릭터 식별자
     * @param characterSkillGrade 조회하고자 하는 전직 차수<br>
     *                            0: 0차 스킬 및 제로 공용스킬<br>
     *                            1: 1차 스킬<br>
     *                            1.5: 1.5차 스킬<br>
     *                            2: 2차 스킬<br>
     *                            2.5: 2.5차 스킬<br>
     *                            3: 3차 스킬<br>
     *                            4: 4차 스킬 및 제로 알파/베타 스킬<br>
     *                            hyperpassive: 하이퍼 패시브 스킬<br>
     *                            hyperactive: 하이퍼 액티브 스킬<br>
     *                            5: 5차 스킬<br>
     *                            6: 6차 스킬<br>
     */
    public CharacterSkillDTO getCharacterSkill(String ocid, String characterSkillGrade) throws IOException {
        return this.getCharacterSkill(ocid, now(), characterSkillGrade);
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid                캐릭터 식별자
     * @param localDateTime       조회 기준일 (KST) - Example: 2023-12-21
     * @param characterSkillGrade 조회하고자 하는 전직 차수<br>
     *                            0: 0차 스킬 및 제로 공용스킬<br>
     *                            1: 1차 스킬<br>
     *                            1.5: 1.5차 스킬<br>
     *                            2: 2차 스킬<br>
     *                            2.5: 2.5차 스킬<br>
     *                            3: 3차 스킬<br>
     *                            4: 4차 스킬 및 제로 알파/베타 스킬<br>
     *                            hyperpassive: 하이퍼 패시브 스킬<br>
     *                            hyperactive: 하이퍼 액티브 스킬<br>
     *                            5: 5차 스킬<br>
     *                            6: 6차 스킬<br>
     */
    public CharacterSkillDTO getCharacterSkill(String ocid, LocalDateTime localDateTime, String characterSkillGrade) throws IOException {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterSkillDTO> call = characterApi.getCharacterSkill(this.apiKey, ocid, date, characterSkillGrade);

        final Response<CharacterSkillDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid                캐릭터 식별자
     * @param characterSkillGrade 조회하고자 하는 전직 차수<br>
     *                            0: 0차 스킬 및 제로 공용스킬<br>
     *                            1: 1차 스킬<br>
     *                            1.5: 1.5차 스킬<br>
     *                            2: 2차 스킬<br>
     *                            2.5: 2.5차 스킬<br>
     *                            3: 3차 스킬<br>
     *                            4: 4차 스킬 및 제로 알파/베타 스킬<br>
     *                            hyperpassive: 하이퍼 패시브 스킬<br>
     *                            hyperactive: 하이퍼 액티브 스킬<br>
     *                            5: 5차 스킬<br>
     *                            6: 6차 스킬<br>
     */
    public void getCharacterSkillAsync(String ocid, String characterSkillGrade, SuccessCallback<CharacterSkillDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterSkillAsync(ocid, now(), characterSkillGrade, onSuccess, onFailure);
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid                캐릭터 식별자
     * @param localDateTime       조회 기준일 (KST) - Example: 2023-12-21
     * @param characterSkillGrade 조회하고자 하는 전직 차수<br>
     *                            0: 0차 스킬 및 제로 공용스킬<br>
     *                            1: 1차 스킬<br>
     *                            1.5: 1.5차 스킬<br>
     *                            2: 2차 스킬<br>
     *                            2.5: 2.5차 스킬<br>
     *                            3: 3차 스킬<br>
     *                            4: 4차 스킬 및 제로 알파/베타 스킬<br>
     *                            hyperpassive: 하이퍼 패시브 스킬<br>
     *                            hyperactive: 하이퍼 액티브 스킬<br>
     *                            5: 5차 스킬<br>
     *                            6: 6차 스킬<br>
     */
    public void getCharacterSkillAsync(String ocid, LocalDateTime localDateTime, String characterSkillGrade, SuccessCallback<CharacterSkillDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterSkillDTO> call = characterApi.getCharacterSkill(this.apiKey, ocid, date, characterSkillGrade);

        call.enqueue(new Callback<CharacterSkillDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterSkillDTO> call, Response<CharacterSkillDTO> response) {
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
            public void onFailure(Call<CharacterSkillDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 장착 링크 스킬 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterLinkSkillDTO getCharacterLinkSkill(String ocid) throws IOException {
        return this.getCharacterLinkSkill(ocid, now());
    }

    /**
     * 장착 링크 스킬 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterLinkSkillDTO getCharacterLinkSkill(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterLinkSkillDTO> call = characterApi.getCharacterLinkSkill(this.apiKey, ocid, date);

        final Response<CharacterLinkSkillDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착 링크 스킬 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterLinkSkillAsync(String ocid, SuccessCallback<CharacterLinkSkillDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterLinkSkillAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 장착 링크 스킬 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterLinkSkillAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterLinkSkillDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterLinkSkillDTO> call = characterApi.getCharacterLinkSkill(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterLinkSkillDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterLinkSkillDTO> call, Response<CharacterLinkSkillDTO> response) {
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
            public void onFailure(Call<CharacterLinkSkillDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterVMatrixDTO getCharacterVMatrix(String ocid) throws IOException {
        return this.getCharacterVMatrix(ocid, now());
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterVMatrixDTO getCharacterVMatrix(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime); // 이름은 date로 고정

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterVMatrixDTO> call = characterApi.getCharacterVMatrix(this.apiKey, ocid, date);

        final Response<CharacterVMatrixDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterVMatrixAsync(String ocid, SuccessCallback<CharacterVMatrixDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterVMatrixAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterVMatrixAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterVMatrixDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterVMatrixDTO> call = characterApi.getCharacterVMatrix(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterVMatrixDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterVMatrixDTO> call, Response<CharacterVMatrixDTO> response) {
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
            public void onFailure(Call<CharacterVMatrixDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterHexaMatrixDTO getCharacterHexaMatrix(String ocid) throws IOException {
        return this.getCharacterHexaMatrix(ocid, now());
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterHexaMatrixDTO getCharacterHexaMatrix(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterHexaMatrixDTO> call = characterApi.getCharacterHexaMatrix(this.apiKey, ocid, date);

        final Response<CharacterHexaMatrixDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterHexaMatrixAsync(String ocid, SuccessCallback<CharacterHexaMatrixDTO> onSuccess, FailureCallback onFailure) {
        getCharacterHexaMatrixAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterHexaMatrixAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterHexaMatrixDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterHexaMatrixDTO> call = characterApi.getCharacterHexaMatrix(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterHexaMatrixDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterHexaMatrixDTO> call, Response<CharacterHexaMatrixDTO> response) {
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
            public void onFailure(Call<CharacterHexaMatrixDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterHexaMatrixStatDTO getCharacterHexaMatrixStat(String ocid) throws IOException {
        return this.getCharacterHexaMatrixStat(ocid, now());
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterHexaMatrixStatDTO getCharacterHexaMatrixStat(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterHexaMatrixStatDTO> call = characterApi.getCharacterHexaMatrixStat(this.apiKey, ocid, date);

        final Response<CharacterHexaMatrixStatDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterHexaMatrixStatAsync(String ocid, SuccessCallback<CharacterHexaMatrixStatDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterHexaMatrixStatAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterHexaMatrixStatAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterHexaMatrixStatDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterHexaMatrixStatDTO> call = characterApi.getCharacterHexaMatrixStat(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterHexaMatrixStatDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterHexaMatrixStatDTO> call, Response<CharacterHexaMatrixStatDTO> response) {
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
            public void onFailure(Call<CharacterHexaMatrixStatDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterDojangDTO getCharacterDojang(String ocid) throws IOException {
        return this.getCharacterDojang(ocid, now());
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterDojangDTO getCharacterDojang(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterDojangDTO> call = characterApi.getCharacterDojang(this.apiKey, ocid, date);

        final Response<CharacterDojangDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterDojangAsync(String ocid, SuccessCallback<CharacterDojangDTO> onSuccess, FailureCallback onFailure) {
        getCharacterDojangAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterDojangAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterDojangDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterDojangDTO> call = characterApi.getCharacterDojang(this.apiKey, ocid, date);

        call.enqueue(new Callback<CharacterDojangDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<CharacterDojangDTO> call, Response<CharacterDojangDTO> response) {
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
            public void onFailure(Call<CharacterDojangDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    //#endregion

    //#region 유니온 정보 조회

    /**
     * 유니온 레벨 및 유니온 등급 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public UnionDTO getUnion(String ocid) throws IOException {
        return this.getUnion(ocid, now());
    }

    /**
     * 유니온 레벨 및 유니온 등급 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public UnionDTO getUnion(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final UnionApi unionApi = retrofit.create(UnionApi.class);
        final Call<UnionDTO> call = unionApi.getUnion(this.apiKey, ocid, date);

        final Response<UnionDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 유니온 레벨 및 유니온 등급 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getUnionAsync(String ocid, SuccessCallback<UnionDTO> onSuccess, FailureCallback onFailure) {
        this.getUnionAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 유니온 레벨 및 유니온 등급 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getUnionAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<UnionDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final UnionApi unionApi = retrofit.create(UnionApi.class);
        final Call<UnionDTO> call = unionApi.getUnion(this.apiKey, ocid, date);

        call.enqueue(new Callback<UnionDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<UnionDTO> call, Response<UnionDTO> response) {
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
            public void onFailure(Call<UnionDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public UnionRaiderDTO getUnionRaider(String ocid) throws IOException {
        return this.getUnionRaider(ocid, now());
    }

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public UnionRaiderDTO getUnionRaider(String ocid, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final UnionApi unionApi = retrofit.create(UnionApi.class);
        final Call<UnionRaiderDTO> call = unionApi.getUnionRaider(this.apiKey, ocid, date);

        final Response<UnionRaiderDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getUnionRaiderAsync(String ocid, SuccessCallback<UnionRaiderDTO> onSuccess, FailureCallback onFailure) {
        this.getUnionRaiderAsync(ocid, now(), onSuccess, onFailure);
    }

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getUnionRaiderAsync(String ocid, LocalDateTime localDateTime, SuccessCallback<UnionRaiderDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final UnionApi unionApi = retrofit.create(UnionApi.class);
        final Call<UnionRaiderDTO> call = unionApi.getUnionRaider(this.apiKey, ocid, date);

        call.enqueue(new Callback<UnionRaiderDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<UnionRaiderDTO> call, Response<UnionRaiderDTO> response) {
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
            public void onFailure(Call<UnionRaiderDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    //#endregion

    //#region 길드 정보 조회

    /**
     * 길드 식별자(oguild_id) 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param guildName 길드 명
     * @param worldName 월드 명<br>
     *                  스카니아<br>
     *                  베라<br>
     *                  루나<br>
     *                  제니스<br>
     *                  크로아<br>
     *                  유니온<br>
     *                  엘리시움<br>
     *                  이노시스<br>
     *                  레드<br>
     *                  오로라<br>
     *                  아케인<br>
     *                  노바<br>
     *                  리부트<br>
     *                  리부트2<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     */
    public GuildDTO getGuild(String guildName, String worldName) throws IOException {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final GuildApi guildApi = retrofit.create(GuildApi.class);
        final Call<GuildDTO> call = guildApi.getGuild(this.apiKey, guildName, worldName);

        final Response<GuildDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 길드 식별자(oguild_id) 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param guildName 길드 명
     * @param worldName 월드 명<br>
     *                  스카니아<br>
     *                  베라<br>
     *                  루나<br>
     *                  제니스<br>
     *                  크로아<br>
     *                  유니온<br>
     *                  엘리시움<br>
     *                  이노시스<br>
     *                  레드<br>
     *                  오로라<br>
     *                  아케인<br>
     *                  노바<br>
     *                  리부트<br>
     *                  리부트2<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     */
    public void getGuildAsync(String guildName, String worldName, SuccessCallback<GuildDTO> onSuccess, FailureCallback onFailure) {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final GuildApi guildApi = retrofit.create(GuildApi.class);
        final Call<GuildDTO> call = guildApi.getGuild(this.apiKey, guildName, worldName);

        call.enqueue(new Callback<GuildDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<GuildDTO> call, Response<GuildDTO> response) {
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
            public void onFailure(Call<GuildDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 길드 기본 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param oguildId 길드 식별자
     */
    public GuildBasicDTO getGuildBasic(String oguildId) throws IOException {
        return this.getGuildBasic(oguildId, now());
    }

    /**
     * 길드 기본 정보를 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param oguildId      길드 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public GuildBasicDTO getGuildBasic(String oguildId, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final GuildApi guildApi = retrofit.create(GuildApi.class);
        final Call<GuildBasicDTO> call = guildApi.getGuildBasic(this.apiKey, oguildId, date);

        final Response<GuildBasicDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 길드 기본 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param oguildId 길드 식별자
     */
    public void getGuildBasicAsync(String oguildId, SuccessCallback<GuildBasicDTO> onSuccess, FailureCallback onFailure) {
        this.getGuildBasicAsync(oguildId, now(), onSuccess, onFailure);
    }

    /**
     * 길드 기본 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param oguildId      길드 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getGuildBasicAsync(String oguildId, LocalDateTime localDateTime, SuccessCallback<GuildBasicDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 21), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final GuildApi guildApi = retrofit.create(GuildApi.class);
        final Call<GuildBasicDTO> call = guildApi.getGuildBasic(this.apiKey, oguildId, date);

        call.enqueue(new Callback<GuildBasicDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<GuildBasicDTO> call, Response<GuildBasicDTO> response) {
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
            public void onFailure(Call<GuildBasicDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    //#endregion

    //#region 확률 정보 조회

    /**
     * 오늘 날짜의 큐브 사용 결과를 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public CubeHistoryResponseDTO getCubeHistory(int count) throws IOException {
        return this.getCubeHistory(count, now());
    }

    /**
     * 오늘 날짜의 큐브 사용 결과를 비동기로 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public void getCubeHistoryAsync(int count, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getCubeHistoryAsync(count, now(), onSuccess, onFailure);
    }

    /**
     * 지목한 날짜의 큐브 사용 결과를 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public CubeHistoryResponseDTO getCubeHistory(int count, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2022, 11, 25), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CubeApi cubeApi = retrofit.create(CubeApi.class);
        final Call<CubeHistoryResponseDTO> call = cubeApi.getCubeHistoryByDate(this.apiKey, count, date);

        final Response<CubeHistoryResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 지목한 날짜의 큐브 사용 결과를 비동기로 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCubeHistoryAsync(int count, LocalDateTime localDateTime, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2022, 11, 25), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CubeApi cubeApi = retrofit.create(CubeApi.class);
        final Call<CubeHistoryResponseDTO> call = cubeApi.getCubeHistoryByDate(this.apiKey, count, date);

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
     * 큐브 사용 결과를 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public CubeHistoryResponseDTO getCubeHistory(int count, String cursor) throws IOException {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CubeApi cubeApi = retrofit.create(CubeApi.class);
        final Call<CubeHistoryResponseDTO> call = cubeApi.getCubeHistoryByCursor(this.apiKey, count, cursor);

        final Response<CubeHistoryResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public void getCubeHistoryAsync(int count, String cursor, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CubeApi cubeApi = retrofit.create(CubeApi.class);
        final Call<CubeHistoryResponseDTO> call = cubeApi.getCubeHistoryByCursor(this.apiKey, count, cursor);

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

    //#endregion

    //#region 랭킹 정보 조회

    /**
     * 종합 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName      월드 명<br>
     *                       스카니아<br>
     *                       베라<br>
     *                       루나<br>
     *                       제니스<br>
     *                       크로아<br>
     *                       유니온<br>
     *                       엘리시움<br>
     *                       이노시스<br>
     *                       레드<br>
     *                       오로라<br>
     *                       아케인<br>
     *                       노바<br>
     *                       리부트<br>
     *                       리부트2<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param worldType      월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, worldName 입력 시 미 반영)
     * @param characterClass 직업 및 전직<br>
     *                       초보자-전체 전직<br>
     *                       전사-전체 전직<br>
     *                       전사-검사<br>
     *                       전사-파이터<br>
     *                       전사-페이지<br>
     *                       전사-스피어맨<br>
     *                       전사-크루세이더<br>
     *                       전사-나이트<br>
     *                       전사-버서커<br>
     *                       전사-히어로<br>
     *                       전사-팔라딘<br>
     *                       전사-다크나이트<br>
     *                       마법사-전체 전직<br>
     *                       마법사-매지션<br>
     *                       마법사-위자드(불,독)<br>
     *                       마법사-위자드(썬,콜)<br>
     *                       마법사-클레릭<br>
     *                       마법사-메이지(불,독)<br>
     *                       마법사-메이지(썬,콜)<br>
     *                       마법사-프리스트<br>
     *                       마법사-아크메이지(불,독)<br>
     *                       마법사-아크메이지(썬,콜)<br>
     *                       마법사-비숍<br>
     *                       궁수-전체 전직<br>
     *                       궁수-아처<br>
     *                       궁수-헌터<br>
     *                       궁수-사수<br>
     *                       궁수-레인저<br>
     *                       궁수-저격수<br>
     *                       궁수-보우마스터<br>
     *                       궁수-신궁<br>
     *                       궁수-아처(패스파인더)<br>
     *                       궁수-에인션트아처<br>
     *                       궁수-체이서<br>
     *                       궁수-패스파인더<br>
     *                       도적-전체 전직<br>
     *                       도적-로그<br>
     *                       도적-어쌔신<br>
     *                       도적-시프<br>
     *                       도적-허밋<br>
     *                       도적-시프마스터<br>
     *                       도적-나이트로드<br>
     *                       도적-섀도어<br>
     *                       도적-세미듀어러<br>
     *                       도적-듀어러<br>
     *                       도적-듀얼마스터<br>
     *                       도적-슬래셔<br>
     *                       도적-듀얼블레이더<br>
     *                       해적-전체 전직<br>
     *                       해적-해적<br>
     *                       해적-인파이터<br>
     *                       해적-건슬링거<br>
     *                       해적-캐논슈터<br>
     *                       해적-버커니어<br>
     *                       해적-발키리<br>
     *                       해적-캐논블래스터<br>
     *                       해적-바이퍼<br>
     *                       해적-캡틴<br>
     *                       해적-캐논마스터<br>
     *                       기사단-전체 전직<br>
     *                       기사단-노블레스<br>
     *                       기사단-소울마스터<br>
     *                       기사단-플레임위자드<br>
     *                       기사단-윈드브레이커<br>
     *                       기사단-나이트워커<br>
     *                       기사단-스트라이커<br>
     *                       기사단-미하일<br>
     *                       아란-전체 전직<br>
     *                       에반-전체 전직<br>
     *                       레지스탕스-전체 전직<br>
     *                       레지스탕스-시티즌<br>
     *                       레지스탕스-배틀메이지<br>
     *                       레지스탕스-와일드헌터<br>
     *                       레지스탕스-메카닉<br>
     *                       레지스탕스-데몬슬레이어<br>
     *                       레지스탕스-데몬어벤져<br>
     *                       레지스탕스-제논<br>
     *                       레지스탕스-블래스터<br>
     *                       메르세데스-전체 전직<br>
     *                       팬텀-전체 전직<br>
     *                       루미너스-전체 전직<br>
     *                       카이저-전체 전직<br>
     *                       엔젤릭버스터-전체 전직<br>
     *                       초월자-전체 전직<br>
     *                       초월자-제로<br>
     *                       은월-전체 전직<br>
     *                       프렌즈 월드-전체 전직<br>
     *                       프렌즈 월드-키네시스<br>
     *                       카데나-전체 전직<br>
     *                       일리움-전체 전직<br>
     *                       아크-전체 전직<br>
     *                       호영-전체 전직<br>
     *                       아델-전체 전직<br>
     *                       카인-전체 전직<br>
     *                       라라-전체 전직<br>
     *                       칼리-전체 전직<br>
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     */
    public OverallRankingResponseDTO getOverallRanking(String worldName, Integer worldType, String characterClass, String ocid, Integer page) throws IOException {
        return this.getOverallRanking(worldName, worldType, characterClass, ocid, page, now());
    }

    /**
     * 종합 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName      월드 명<br>
     *                       스카니아<br>
     *                       베라<br>
     *                       루나<br>
     *                       제니스<br>
     *                       크로아<br>
     *                       유니온<br>
     *                       엘리시움<br>
     *                       이노시스<br>
     *                       레드<br>
     *                       오로라<br>
     *                       아케인<br>
     *                       노바<br>
     *                       리부트<br>
     *                       리부트2<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param worldType      월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, worldName 입력 시 미 반영)
     * @param characterClass 직업 및 전직<br>
     *                       초보자-전체 전직<br>
     *                       전사-전체 전직<br>
     *                       전사-검사<br>
     *                       전사-파이터<br>
     *                       전사-페이지<br>
     *                       전사-스피어맨<br>
     *                       전사-크루세이더<br>
     *                       전사-나이트<br>
     *                       전사-버서커<br>
     *                       전사-히어로<br>
     *                       전사-팔라딘<br>
     *                       전사-다크나이트<br>
     *                       마법사-전체 전직<br>
     *                       마법사-매지션<br>
     *                       마법사-위자드(불,독)<br>
     *                       마법사-위자드(썬,콜)<br>
     *                       마법사-클레릭<br>
     *                       마법사-메이지(불,독)<br>
     *                       마법사-메이지(썬,콜)<br>
     *                       마법사-프리스트<br>
     *                       마법사-아크메이지(불,독)<br>
     *                       마법사-아크메이지(썬,콜)<br>
     *                       마법사-비숍<br>
     *                       궁수-전체 전직<br>
     *                       궁수-아처<br>
     *                       궁수-헌터<br>
     *                       궁수-사수<br>
     *                       궁수-레인저<br>
     *                       궁수-저격수<br>
     *                       궁수-보우마스터<br>
     *                       궁수-신궁<br>
     *                       궁수-아처(패스파인더)<br>
     *                       궁수-에인션트아처<br>
     *                       궁수-체이서<br>
     *                       궁수-패스파인더<br>
     *                       도적-전체 전직<br>
     *                       도적-로그<br>
     *                       도적-어쌔신<br>
     *                       도적-시프<br>
     *                       도적-허밋<br>
     *                       도적-시프마스터<br>
     *                       도적-나이트로드<br>
     *                       도적-섀도어<br>
     *                       도적-세미듀어러<br>
     *                       도적-듀어러<br>
     *                       도적-듀얼마스터<br>
     *                       도적-슬래셔<br>
     *                       도적-듀얼블레이더<br>
     *                       해적-전체 전직<br>
     *                       해적-해적<br>
     *                       해적-인파이터<br>
     *                       해적-건슬링거<br>
     *                       해적-캐논슈터<br>
     *                       해적-버커니어<br>
     *                       해적-발키리<br>
     *                       해적-캐논블래스터<br>
     *                       해적-바이퍼<br>
     *                       해적-캡틴<br>
     *                       해적-캐논마스터<br>
     *                       기사단-전체 전직<br>
     *                       기사단-노블레스<br>
     *                       기사단-소울마스터<br>
     *                       기사단-플레임위자드<br>
     *                       기사단-윈드브레이커<br>
     *                       기사단-나이트워커<br>
     *                       기사단-스트라이커<br>
     *                       기사단-미하일<br>
     *                       아란-전체 전직<br>
     *                       에반-전체 전직<br>
     *                       레지스탕스-전체 전직<br>
     *                       레지스탕스-시티즌<br>
     *                       레지스탕스-배틀메이지<br>
     *                       레지스탕스-와일드헌터<br>
     *                       레지스탕스-메카닉<br>
     *                       레지스탕스-데몬슬레이어<br>
     *                       레지스탕스-데몬어벤져<br>
     *                       레지스탕스-제논<br>
     *                       레지스탕스-블래스터<br>
     *                       메르세데스-전체 전직<br>
     *                       팬텀-전체 전직<br>
     *                       루미너스-전체 전직<br>
     *                       카이저-전체 전직<br>
     *                       엔젤릭버스터-전체 전직<br>
     *                       초월자-전체 전직<br>
     *                       초월자-제로<br>
     *                       은월-전체 전직<br>
     *                       프렌즈 월드-전체 전직<br>
     *                       프렌즈 월드-키네시스<br>
     *                       카데나-전체 전직<br>
     *                       일리움-전체 전직<br>
     *                       아크-전체 전직<br>
     *                       호영-전체 전직<br>
     *                       아델-전체 전직<br>
     *                       카인-전체 전직<br>
     *                       라라-전체 전직<br>
     *                       칼리-전체 전직<br>
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     * @param localDateTime  조회 기준일 (KST) - Example: 2023-12-22
     */
    public OverallRankingResponseDTO getOverallRanking(String worldName, Integer worldType, String characterClass, String ocid, Integer page, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<OverallRankingResponseDTO> call = rankingApi.getOverallRanking(this.apiKey, date, worldName, worldType, characterClass, ocid, page);

        final Response<OverallRankingResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 종합 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName      월드 명<br>
     *                       스카니아<br>
     *                       베라<br>
     *                       루나<br>
     *                       제니스<br>
     *                       크로아<br>
     *                       유니온<br>
     *                       엘리시움<br>
     *                       이노시스<br>
     *                       레드<br>
     *                       오로라<br>
     *                       아케인<br>
     *                       노바<br>
     *                       리부트<br>
     *                       리부트2<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param worldType      월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, worldName 입력 시 미 반영)
     * @param characterClass 직업 및 전직<br>
     *                       초보자-전체 전직<br>
     *                       전사-전체 전직<br>
     *                       전사-검사<br>
     *                       전사-파이터<br>
     *                       전사-페이지<br>
     *                       전사-스피어맨<br>
     *                       전사-크루세이더<br>
     *                       전사-나이트<br>
     *                       전사-버서커<br>
     *                       전사-히어로<br>
     *                       전사-팔라딘<br>
     *                       전사-다크나이트<br>
     *                       마법사-전체 전직<br>
     *                       마법사-매지션<br>
     *                       마법사-위자드(불,독)<br>
     *                       마법사-위자드(썬,콜)<br>
     *                       마법사-클레릭<br>
     *                       마법사-메이지(불,독)<br>
     *                       마법사-메이지(썬,콜)<br>
     *                       마법사-프리스트<br>
     *                       마법사-아크메이지(불,독)<br>
     *                       마법사-아크메이지(썬,콜)<br>
     *                       마법사-비숍<br>
     *                       궁수-전체 전직<br>
     *                       궁수-아처<br>
     *                       궁수-헌터<br>
     *                       궁수-사수<br>
     *                       궁수-레인저<br>
     *                       궁수-저격수<br>
     *                       궁수-보우마스터<br>
     *                       궁수-신궁<br>
     *                       궁수-아처(패스파인더)<br>
     *                       궁수-에인션트아처<br>
     *                       궁수-체이서<br>
     *                       궁수-패스파인더<br>
     *                       도적-전체 전직<br>
     *                       도적-로그<br>
     *                       도적-어쌔신<br>
     *                       도적-시프<br>
     *                       도적-허밋<br>
     *                       도적-시프마스터<br>
     *                       도적-나이트로드<br>
     *                       도적-섀도어<br>
     *                       도적-세미듀어러<br>
     *                       도적-듀어러<br>
     *                       도적-듀얼마스터<br>
     *                       도적-슬래셔<br>
     *                       도적-듀얼블레이더<br>
     *                       해적-전체 전직<br>
     *                       해적-해적<br>
     *                       해적-인파이터<br>
     *                       해적-건슬링거<br>
     *                       해적-캐논슈터<br>
     *                       해적-버커니어<br>
     *                       해적-발키리<br>
     *                       해적-캐논블래스터<br>
     *                       해적-바이퍼<br>
     *                       해적-캡틴<br>
     *                       해적-캐논마스터<br>
     *                       기사단-전체 전직<br>
     *                       기사단-노블레스<br>
     *                       기사단-소울마스터<br>
     *                       기사단-플레임위자드<br>
     *                       기사단-윈드브레이커<br>
     *                       기사단-나이트워커<br>
     *                       기사단-스트라이커<br>
     *                       기사단-미하일<br>
     *                       아란-전체 전직<br>
     *                       에반-전체 전직<br>
     *                       레지스탕스-전체 전직<br>
     *                       레지스탕스-시티즌<br>
     *                       레지스탕스-배틀메이지<br>
     *                       레지스탕스-와일드헌터<br>
     *                       레지스탕스-메카닉<br>
     *                       레지스탕스-데몬슬레이어<br>
     *                       레지스탕스-데몬어벤져<br>
     *                       레지스탕스-제논<br>
     *                       레지스탕스-블래스터<br>
     *                       메르세데스-전체 전직<br>
     *                       팬텀-전체 전직<br>
     *                       루미너스-전체 전직<br>
     *                       카이저-전체 전직<br>
     *                       엔젤릭버스터-전체 전직<br>
     *                       초월자-전체 전직<br>
     *                       초월자-제로<br>
     *                       은월-전체 전직<br>
     *                       프렌즈 월드-전체 전직<br>
     *                       프렌즈 월드-키네시스<br>
     *                       카데나-전체 전직<br>
     *                       일리움-전체 전직<br>
     *                       아크-전체 전직<br>
     *                       호영-전체 전직<br>
     *                       아델-전체 전직<br>
     *                       카인-전체 전직<br>
     *                       라라-전체 전직<br>
     *                       칼리-전체 전직<br>
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     */
    public void getOverallRankingAsync(String worldName, Integer worldType, String characterClass, String ocid, Integer page, SuccessCallback<OverallRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getOverallRankingAsync(worldName, worldType, characterClass, ocid, page, now(), onSuccess, onFailure);
    }

    /**
     * 종합 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName      월드 명<br>
     *                       스카니아<br>
     *                       베라<br>
     *                       루나<br>
     *                       제니스<br>
     *                       크로아<br>
     *                       유니온<br>
     *                       엘리시움<br>
     *                       이노시스<br>
     *                       레드<br>
     *                       오로라<br>
     *                       아케인<br>
     *                       노바<br>
     *                       리부트<br>
     *                       리부트2<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param worldType      월드 타입 (0:일반, 1:리부트) (기본 값은 0이며, worldName 입력 시 미 반영)
     * @param characterClass 직업 및 전직<br>
     *                       초보자-전체 전직<br>
     *                       전사-전체 전직<br>
     *                       전사-검사<br>
     *                       전사-파이터<br>
     *                       전사-페이지<br>
     *                       전사-스피어맨<br>
     *                       전사-크루세이더<br>
     *                       전사-나이트<br>
     *                       전사-버서커<br>
     *                       전사-히어로<br>
     *                       전사-팔라딘<br>
     *                       전사-다크나이트<br>
     *                       마법사-전체 전직<br>
     *                       마법사-매지션<br>
     *                       마법사-위자드(불,독)<br>
     *                       마법사-위자드(썬,콜)<br>
     *                       마법사-클레릭<br>
     *                       마법사-메이지(불,독)<br>
     *                       마법사-메이지(썬,콜)<br>
     *                       마법사-프리스트<br>
     *                       마법사-아크메이지(불,독)<br>
     *                       마법사-아크메이지(썬,콜)<br>
     *                       마법사-비숍<br>
     *                       궁수-전체 전직<br>
     *                       궁수-아처<br>
     *                       궁수-헌터<br>
     *                       궁수-사수<br>
     *                       궁수-레인저<br>
     *                       궁수-저격수<br>
     *                       궁수-보우마스터<br>
     *                       궁수-신궁<br>
     *                       궁수-아처(패스파인더)<br>
     *                       궁수-에인션트아처<br>
     *                       궁수-체이서<br>
     *                       궁수-패스파인더<br>
     *                       도적-전체 전직<br>
     *                       도적-로그<br>
     *                       도적-어쌔신<br>
     *                       도적-시프<br>
     *                       도적-허밋<br>
     *                       도적-시프마스터<br>
     *                       도적-나이트로드<br>
     *                       도적-섀도어<br>
     *                       도적-세미듀어러<br>
     *                       도적-듀어러<br>
     *                       도적-듀얼마스터<br>
     *                       도적-슬래셔<br>
     *                       도적-듀얼블레이더<br>
     *                       해적-전체 전직<br>
     *                       해적-해적<br>
     *                       해적-인파이터<br>
     *                       해적-건슬링거<br>
     *                       해적-캐논슈터<br>
     *                       해적-버커니어<br>
     *                       해적-발키리<br>
     *                       해적-캐논블래스터<br>
     *                       해적-바이퍼<br>
     *                       해적-캡틴<br>
     *                       해적-캐논마스터<br>
     *                       기사단-전체 전직<br>
     *                       기사단-노블레스<br>
     *                       기사단-소울마스터<br>
     *                       기사단-플레임위자드<br>
     *                       기사단-윈드브레이커<br>
     *                       기사단-나이트워커<br>
     *                       기사단-스트라이커<br>
     *                       기사단-미하일<br>
     *                       아란-전체 전직<br>
     *                       에반-전체 전직<br>
     *                       레지스탕스-전체 전직<br>
     *                       레지스탕스-시티즌<br>
     *                       레지스탕스-배틀메이지<br>
     *                       레지스탕스-와일드헌터<br>
     *                       레지스탕스-메카닉<br>
     *                       레지스탕스-데몬슬레이어<br>
     *                       레지스탕스-데몬어벤져<br>
     *                       레지스탕스-제논<br>
     *                       레지스탕스-블래스터<br>
     *                       메르세데스-전체 전직<br>
     *                       팬텀-전체 전직<br>
     *                       루미너스-전체 전직<br>
     *                       카이저-전체 전직<br>
     *                       엔젤릭버스터-전체 전직<br>
     *                       초월자-전체 전직<br>
     *                       초월자-제로<br>
     *                       은월-전체 전직<br>
     *                       프렌즈 월드-전체 전직<br>
     *                       프렌즈 월드-키네시스<br>
     *                       카데나-전체 전직<br>
     *                       일리움-전체 전직<br>
     *                       아크-전체 전직<br>
     *                       호영-전체 전직<br>
     *                       아델-전체 전직<br>
     *                       카인-전체 전직<br>
     *                       라라-전체 전직<br>
     *                       칼리-전체 전직<br>
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     * @param localDateTime  조회 기준일 (KST) - Example: 2023-12-22
     */
    public void getOverallRankingAsync(String worldName, Integer worldType, String characterClass, String ocid, Integer page, LocalDateTime localDateTime, SuccessCallback<OverallRankingResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<OverallRankingResponseDTO> call = rankingApi.getOverallRanking(this.apiKey, date, worldName, worldType, characterClass, ocid, page);

        call.enqueue(new Callback<OverallRankingResponseDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<OverallRankingResponseDTO> call, Response<OverallRankingResponseDTO> response) {
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
            public void onFailure(Call<OverallRankingResponseDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 유니온 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName 월드 명<br>
     *                  스카니아<br>
     *                  베라<br>
     *                  루나<br>
     *                  제니스<br>
     *                  크로아<br>
     *                  유니온<br>
     *                  엘리시움<br>
     *                  이노시스<br>
     *                  레드<br>
     *                  오로라<br>
     *                  아케인<br>
     *                  노바<br>
     *                  리부트<br>
     *                  리부트2<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     * @param ocid      캐릭터 식별자
     * @param page      페이지 번호
     */
    public UnionRankingResponseDTO getUnionRanking(String worldName, String ocid, Integer page) throws IOException {
        return this.getUnionRanking(worldName, ocid, page, now());
    }

    /**
     * 유니온 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName     월드 명<br>
     *                      스카니아<br>
     *                      베라<br>
     *                      루나<br>
     *                      제니스<br>
     *                      크로아<br>
     *                      유니온<br>
     *                      엘리시움<br>
     *                      이노시스<br>
     *                      레드<br>
     *                      오로라<br>
     *                      아케인<br>
     *                      노바<br>
     *                      리부트<br>
     *                      리부트2<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public UnionRankingResponseDTO getUnionRanking(String worldName, String ocid, Integer page, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<UnionRankingResponseDTO> call = rankingApi.getUnionRanking(this.apiKey, date, worldName, ocid, page);

        final Response<UnionRankingResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 유니온 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName 월드 명<br>
     *                  스카니아<br>
     *                  베라<br>
     *                  루나<br>
     *                  제니스<br>
     *                  크로아<br>
     *                  유니온<br>
     *                  엘리시움<br>
     *                  이노시스<br>
     *                  레드<br>
     *                  오로라<br>
     *                  아케인<br>
     *                  노바<br>
     *                  리부트<br>
     *                  리부트2<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     * @param ocid      캐릭터 식별자
     * @param page      페이지 번호
     */
    public void getUnionRankingAsync(String worldName, String ocid, Integer page, SuccessCallback<UnionRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getUnionRankingAsync(worldName, ocid, page, now(), onSuccess, onFailure);
    }

    /**
     * 유니온 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName     월드 명<br>
     *                      스카니아<br>
     *                      베라<br>
     *                      루나<br>
     *                      제니스<br>
     *                      크로아<br>
     *                      유니온<br>
     *                      엘리시움<br>
     *                      이노시스<br>
     *                      레드<br>
     *                      오로라<br>
     *                      아케인<br>
     *                      노바<br>
     *                      리부트<br>
     *                      리부트2<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getUnionRankingAsync(String worldName, String ocid, Integer page, LocalDateTime localDateTime, SuccessCallback<UnionRankingResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<UnionRankingResponseDTO> call = rankingApi.getUnionRanking(this.apiKey, date, worldName, ocid, page);

        call.enqueue(new Callback<UnionRankingResponseDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<UnionRankingResponseDTO> call, Response<UnionRankingResponseDTO> response) {
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
            public void onFailure(Call<UnionRankingResponseDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 길드 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName   월드 명<br>
     *                    스카니아<br>
     *                    베라<br>
     *                    루나<br>
     *                    제니스<br>
     *                    크로아<br>
     *                    유니온<br>
     *                    엘리시움<br>
     *                    이노시스<br>
     *                    레드<br>
     *                    오로라<br>
     *                    아케인<br>
     *                    노바<br>
     *                    리부트<br>
     *                    리부트2<br>
     *                    버닝<br>
     *                    버닝2<br>
     *                    버닝3<br>
     * @param rankingType 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     * @param guildName   길드 명
     * @param page        페이지 번호
     */
    public GuildRankingResponseDTO getGuildRanking(String worldName, Integer rankingType, String guildName, Integer page) throws IOException {
        return this.getGuildRanking(worldName, rankingType, guildName, page, now());
    }

    /**
     * 길드 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName     월드 명<br>
     *                      스카니아<br>
     *                      베라<br>
     *                      루나<br>
     *                      제니스<br>
     *                      크로아<br>
     *                      유니온<br>
     *                      엘리시움<br>
     *                      이노시스<br>
     *                      레드<br>
     *                      오로라<br>
     *                      아케인<br>
     *                      노바<br>
     *                      리부트<br>
     *                      리부트2<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param rankingType   랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     * @param guildName     길드 명
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-22
     */
    public GuildRankingResponseDTO getGuildRanking(String worldName, Integer rankingType, String guildName, Integer page, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<GuildRankingResponseDTO> call = rankingApi.getGuildRanking(this.apiKey, date, worldName, rankingType, guildName, page);

        final Response<GuildRankingResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 길드 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName   월드 명<br>
     *                    스카니아<br>
     *                    베라<br>
     *                    루나<br>
     *                    제니스<br>
     *                    크로아<br>
     *                    유니온<br>
     *                    엘리시움<br>
     *                    이노시스<br>
     *                    레드<br>
     *                    오로라<br>
     *                    아케인<br>
     *                    노바<br>
     *                    리부트<br>
     *                    리부트2<br>
     *                    버닝<br>
     *                    버닝2<br>
     *                    버닝3<br>
     * @param rankingType 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     * @param guildName   길드 명
     * @param page        페이지 번호
     */
    public void getGuildRankingAsync(String worldName, Integer rankingType, String guildName, Integer page, SuccessCallback<GuildRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getGuildRankingAsync(worldName, rankingType, guildName, page, now(), onSuccess, onFailure);
    }

    /**
     * 길드 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName     월드 명<br>
     *                      스카니아<br>
     *                      베라<br>
     *                      루나<br>
     *                      제니스<br>
     *                      크로아<br>
     *                      유니온<br>
     *                      엘리시움<br>
     *                      이노시스<br>
     *                      레드<br>
     *                      오로라<br>
     *                      아케인<br>
     *                      노바<br>
     *                      리부트<br>
     *                      리부트2<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param rankingType   랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     * @param guildName     길드 명
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-22
     */
    public void getGuildRankingAsync(String worldName, Integer rankingType, String guildName, Integer page, LocalDateTime localDateTime, SuccessCallback<GuildRankingResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<GuildRankingResponseDTO> call = rankingApi.getGuildRanking(this.apiKey, date, worldName, rankingType, guildName, page);

        call.enqueue(new Callback<GuildRankingResponseDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<GuildRankingResponseDTO> call, Response<GuildRankingResponseDTO> response) {
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
            public void onFailure(Call<GuildRankingResponseDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 무릉도장 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName      월드 명<br>
     *                       스카니아<br>
     *                       베라<br>
     *                       루나<br>
     *                       제니스<br>
     *                       크로아<br>
     *                       유니온<br>
     *                       엘리시움<br>
     *                       이노시스<br>
     *                       레드<br>
     *                       오로라<br>
     *                       아케인<br>
     *                       노바<br>
     *                       리부트<br>
     *                       리부트2<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param difficulty     구간 (0:일반, 1:통달)
     * @param characterClass 직업 및 전직
     * @param characterClass 직업 및 전직<br>
     *                       초보자-전체 전직<br>
     *                       전사-전체 전직<br>
     *                       전사-검사<br>
     *                       전사-파이터<br>
     *                       전사-페이지<br>
     *                       전사-스피어맨<br>
     *                       전사-크루세이더<br>
     *                       전사-나이트<br>
     *                       전사-버서커<br>
     *                       전사-히어로<br>
     *                       전사-팔라딘<br>
     *                       전사-다크나이트<br>
     *                       마법사-전체 전직<br>
     *                       마법사-매지션<br>
     *                       마법사-위자드(불,독)<br>
     *                       마법사-위자드(썬,콜)<br>
     *                       마법사-클레릭<br>
     *                       마법사-메이지(불,독)<br>
     *                       마법사-메이지(썬,콜)<br>
     *                       마법사-프리스트<br>
     *                       마법사-아크메이지(불,독)<br>
     *                       마법사-아크메이지(썬,콜)<br>
     *                       마법사-비숍<br>
     *                       궁수-전체 전직<br>
     *                       궁수-아처<br>
     *                       궁수-헌터<br>
     *                       궁수-사수<br>
     *                       궁수-레인저<br>
     *                       궁수-저격수<br>
     *                       궁수-보우마스터<br>
     *                       궁수-신궁<br>
     *                       궁수-아처(패스파인더)<br>
     *                       궁수-에인션트아처<br>
     *                       궁수-체이서<br>
     *                       궁수-패스파인더<br>
     *                       도적-전체 전직<br>
     *                       도적-로그<br>
     *                       도적-어쌔신<br>
     *                       도적-시프<br>
     *                       도적-허밋<br>
     *                       도적-시프마스터<br>
     *                       도적-나이트로드<br>
     *                       도적-섀도어<br>
     *                       도적-세미듀어러<br>
     *                       도적-듀어러<br>
     *                       도적-듀얼마스터<br>
     *                       도적-슬래셔<br>
     *                       도적-듀얼블레이더<br>
     *                       해적-전체 전직<br>
     *                       해적-해적<br>
     *                       해적-인파이터<br>
     *                       해적-건슬링거<br>
     *                       해적-캐논슈터<br>
     *                       해적-버커니어<br>
     *                       해적-발키리<br>
     *                       해적-캐논블래스터<br>
     *                       해적-바이퍼<br>
     *                       해적-캡틴<br>
     *                       해적-캐논마스터<br>
     *                       기사단-전체 전직<br>
     *                       기사단-노블레스<br>
     *                       기사단-소울마스터<br>
     *                       기사단-플레임위자드<br>
     *                       기사단-윈드브레이커<br>
     *                       기사단-나이트워커<br>
     *                       기사단-스트라이커<br>
     *                       기사단-미하일<br>
     *                       아란-전체 전직<br>
     *                       에반-전체 전직<br>
     *                       레지스탕스-전체 전직<br>
     *                       레지스탕스-시티즌<br>
     *                       레지스탕스-배틀메이지<br>
     *                       레지스탕스-와일드헌터<br>
     *                       레지스탕스-메카닉<br>
     *                       레지스탕스-데몬슬레이어<br>
     *                       레지스탕스-데몬어벤져<br>
     *                       레지스탕스-제논<br>
     *                       레지스탕스-블래스터<br>
     *                       메르세데스-전체 전직<br>
     *                       팬텀-전체 전직<br>
     *                       루미너스-전체 전직<br>
     *                       카이저-전체 전직<br>
     *                       엔젤릭버스터-전체 전직<br>
     *                       초월자-전체 전직<br>
     *                       초월자-제로<br>
     *                       은월-전체 전직<br>
     *                       프렌즈 월드-전체 전직<br>
     *                       프렌즈 월드-키네시스<br>
     *                       카데나-전체 전직<br>
     *                       일리움-전체 전직<br>
     *                       아크-전체 전직<br>
     *                       호영-전체 전직<br>
     *                       아델-전체 전직<br>
     *                       카인-전체 전직<br>
     *                       라라-전체 전직<br>
     *                       칼리-전체 전직<br>
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     */
    public DojangRankingResponseDTO getDojangRanking(String worldName, Integer difficulty, String characterClass, String ocid, Integer page) throws IOException {
        return this.getDojangRanking(worldName, difficulty, characterClass, ocid, page, now());
    }

    /**
     * 무릉도장 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName      월드 명<br>
     *                       스카니아<br>
     *                       베라<br>
     *                       루나<br>
     *                       제니스<br>
     *                       크로아<br>
     *                       유니온<br>
     *                       엘리시움<br>
     *                       이노시스<br>
     *                       레드<br>
     *                       오로라<br>
     *                       아케인<br>
     *                       노바<br>
     *                       리부트<br>
     *                       리부트2<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param difficulty     구간 (0:일반, 1:통달)
     * @param characterClass 직업 및 전직
     * @param characterClass 직업 및 전직<br>
     *                       초보자-전체 전직<br>
     *                       전사-전체 전직<br>
     *                       전사-검사<br>
     *                       전사-파이터<br>
     *                       전사-페이지<br>
     *                       전사-스피어맨<br>
     *                       전사-크루세이더<br>
     *                       전사-나이트<br>
     *                       전사-버서커<br>
     *                       전사-히어로<br>
     *                       전사-팔라딘<br>
     *                       전사-다크나이트<br>
     *                       마법사-전체 전직<br>
     *                       마법사-매지션<br>
     *                       마법사-위자드(불,독)<br>
     *                       마법사-위자드(썬,콜)<br>
     *                       마법사-클레릭<br>
     *                       마법사-메이지(불,독)<br>
     *                       마법사-메이지(썬,콜)<br>
     *                       마법사-프리스트<br>
     *                       마법사-아크메이지(불,독)<br>
     *                       마법사-아크메이지(썬,콜)<br>
     *                       마법사-비숍<br>
     *                       궁수-전체 전직<br>
     *                       궁수-아처<br>
     *                       궁수-헌터<br>
     *                       궁수-사수<br>
     *                       궁수-레인저<br>
     *                       궁수-저격수<br>
     *                       궁수-보우마스터<br>
     *                       궁수-신궁<br>
     *                       궁수-아처(패스파인더)<br>
     *                       궁수-에인션트아처<br>
     *                       궁수-체이서<br>
     *                       궁수-패스파인더<br>
     *                       도적-전체 전직<br>
     *                       도적-로그<br>
     *                       도적-어쌔신<br>
     *                       도적-시프<br>
     *                       도적-허밋<br>
     *                       도적-시프마스터<br>
     *                       도적-나이트로드<br>
     *                       도적-섀도어<br>
     *                       도적-세미듀어러<br>
     *                       도적-듀어러<br>
     *                       도적-듀얼마스터<br>
     *                       도적-슬래셔<br>
     *                       도적-듀얼블레이더<br>
     *                       해적-전체 전직<br>
     *                       해적-해적<br>
     *                       해적-인파이터<br>
     *                       해적-건슬링거<br>
     *                       해적-캐논슈터<br>
     *                       해적-버커니어<br>
     *                       해적-발키리<br>
     *                       해적-캐논블래스터<br>
     *                       해적-바이퍼<br>
     *                       해적-캡틴<br>
     *                       해적-캐논마스터<br>
     *                       기사단-전체 전직<br>
     *                       기사단-노블레스<br>
     *                       기사단-소울마스터<br>
     *                       기사단-플레임위자드<br>
     *                       기사단-윈드브레이커<br>
     *                       기사단-나이트워커<br>
     *                       기사단-스트라이커<br>
     *                       기사단-미하일<br>
     *                       아란-전체 전직<br>
     *                       에반-전체 전직<br>
     *                       레지스탕스-전체 전직<br>
     *                       레지스탕스-시티즌<br>
     *                       레지스탕스-배틀메이지<br>
     *                       레지스탕스-와일드헌터<br>
     *                       레지스탕스-메카닉<br>
     *                       레지스탕스-데몬슬레이어<br>
     *                       레지스탕스-데몬어벤져<br>
     *                       레지스탕스-제논<br>
     *                       레지스탕스-블래스터<br>
     *                       메르세데스-전체 전직<br>
     *                       팬텀-전체 전직<br>
     *                       루미너스-전체 전직<br>
     *                       카이저-전체 전직<br>
     *                       엔젤릭버스터-전체 전직<br>
     *                       초월자-전체 전직<br>
     *                       초월자-제로<br>
     *                       은월-전체 전직<br>
     *                       프렌즈 월드-전체 전직<br>
     *                       프렌즈 월드-키네시스<br>
     *                       카데나-전체 전직<br>
     *                       일리움-전체 전직<br>
     *                       아크-전체 전직<br>
     *                       호영-전체 전직<br>
     *                       아델-전체 전직<br>
     *                       카인-전체 전직<br>
     *                       라라-전체 전직<br>
     *                       칼리-전체 전직<br>
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     * @param localDateTime  조회 기준일 (KST) - Example: 2023-12-22
     */
    public DojangRankingResponseDTO getDojangRanking(String worldName, Integer difficulty, String characterClass, String ocid, Integer page, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<DojangRankingResponseDTO> call = rankingApi.getDojangRanking(this.apiKey, date, worldName, difficulty, characterClass, ocid, page);

        final Response<DojangRankingResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 무릉도장 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName      월드 명<br>
     *                       스카니아<br>
     *                       베라<br>
     *                       루나<br>
     *                       제니스<br>
     *                       크로아<br>
     *                       유니온<br>
     *                       엘리시움<br>
     *                       이노시스<br>
     *                       레드<br>
     *                       오로라<br>
     *                       아케인<br>
     *                       노바<br>
     *                       리부트<br>
     *                       리부트2<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param difficulty     구간 (0:일반, 1:통달)
     * @param characterClass 직업 및 전직
     * @param characterClass 직업 및 전직<br>
     *                       초보자-전체 전직<br>
     *                       전사-전체 전직<br>
     *                       전사-검사<br>
     *                       전사-파이터<br>
     *                       전사-페이지<br>
     *                       전사-스피어맨<br>
     *                       전사-크루세이더<br>
     *                       전사-나이트<br>
     *                       전사-버서커<br>
     *                       전사-히어로<br>
     *                       전사-팔라딘<br>
     *                       전사-다크나이트<br>
     *                       마법사-전체 전직<br>
     *                       마법사-매지션<br>
     *                       마법사-위자드(불,독)<br>
     *                       마법사-위자드(썬,콜)<br>
     *                       마법사-클레릭<br>
     *                       마법사-메이지(불,독)<br>
     *                       마법사-메이지(썬,콜)<br>
     *                       마법사-프리스트<br>
     *                       마법사-아크메이지(불,독)<br>
     *                       마법사-아크메이지(썬,콜)<br>
     *                       마법사-비숍<br>
     *                       궁수-전체 전직<br>
     *                       궁수-아처<br>
     *                       궁수-헌터<br>
     *                       궁수-사수<br>
     *                       궁수-레인저<br>
     *                       궁수-저격수<br>
     *                       궁수-보우마스터<br>
     *                       궁수-신궁<br>
     *                       궁수-아처(패스파인더)<br>
     *                       궁수-에인션트아처<br>
     *                       궁수-체이서<br>
     *                       궁수-패스파인더<br>
     *                       도적-전체 전직<br>
     *                       도적-로그<br>
     *                       도적-어쌔신<br>
     *                       도적-시프<br>
     *                       도적-허밋<br>
     *                       도적-시프마스터<br>
     *                       도적-나이트로드<br>
     *                       도적-섀도어<br>
     *                       도적-세미듀어러<br>
     *                       도적-듀어러<br>
     *                       도적-듀얼마스터<br>
     *                       도적-슬래셔<br>
     *                       도적-듀얼블레이더<br>
     *                       해적-전체 전직<br>
     *                       해적-해적<br>
     *                       해적-인파이터<br>
     *                       해적-건슬링거<br>
     *                       해적-캐논슈터<br>
     *                       해적-버커니어<br>
     *                       해적-발키리<br>
     *                       해적-캐논블래스터<br>
     *                       해적-바이퍼<br>
     *                       해적-캡틴<br>
     *                       해적-캐논마스터<br>
     *                       기사단-전체 전직<br>
     *                       기사단-노블레스<br>
     *                       기사단-소울마스터<br>
     *                       기사단-플레임위자드<br>
     *                       기사단-윈드브레이커<br>
     *                       기사단-나이트워커<br>
     *                       기사단-스트라이커<br>
     *                       기사단-미하일<br>
     *                       아란-전체 전직<br>
     *                       에반-전체 전직<br>
     *                       레지스탕스-전체 전직<br>
     *                       레지스탕스-시티즌<br>
     *                       레지스탕스-배틀메이지<br>
     *                       레지스탕스-와일드헌터<br>
     *                       레지스탕스-메카닉<br>
     *                       레지스탕스-데몬슬레이어<br>
     *                       레지스탕스-데몬어벤져<br>
     *                       레지스탕스-제논<br>
     *                       레지스탕스-블래스터<br>
     *                       메르세데스-전체 전직<br>
     *                       팬텀-전체 전직<br>
     *                       루미너스-전체 전직<br>
     *                       카이저-전체 전직<br>
     *                       엔젤릭버스터-전체 전직<br>
     *                       초월자-전체 전직<br>
     *                       초월자-제로<br>
     *                       은월-전체 전직<br>
     *                       프렌즈 월드-전체 전직<br>
     *                       프렌즈 월드-키네시스<br>
     *                       카데나-전체 전직<br>
     *                       일리움-전체 전직<br>
     *                       아크-전체 전직<br>
     *                       호영-전체 전직<br>
     *                       아델-전체 전직<br>
     *                       카인-전체 전직<br>
     *                       라라-전체 전직<br>
     *                       칼리-전체 전직<br>
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     */
    public void getDojangRankingAsync(String worldName, Integer difficulty, String characterClass, String ocid, Integer page, SuccessCallback<DojangRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getDojangRankingAsync(worldName, difficulty, characterClass, ocid, page, now(), onSuccess, onFailure);
    }

    /**
     * 무릉도장 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName      월드 명<br>
     *                       스카니아<br>
     *                       베라<br>
     *                       루나<br>
     *                       제니스<br>
     *                       크로아<br>
     *                       유니온<br>
     *                       엘리시움<br>
     *                       이노시스<br>
     *                       레드<br>
     *                       오로라<br>
     *                       아케인<br>
     *                       노바<br>
     *                       리부트<br>
     *                       리부트2<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param difficulty     구간 (0:일반, 1:통달)
     * @param characterClass 직업 및 전직
     * @param characterClass 직업 및 전직<br>
     *                       초보자-전체 전직<br>
     *                       전사-전체 전직<br>
     *                       전사-검사<br>
     *                       전사-파이터<br>
     *                       전사-페이지<br>
     *                       전사-스피어맨<br>
     *                       전사-크루세이더<br>
     *                       전사-나이트<br>
     *                       전사-버서커<br>
     *                       전사-히어로<br>
     *                       전사-팔라딘<br>
     *                       전사-다크나이트<br>
     *                       마법사-전체 전직<br>
     *                       마법사-매지션<br>
     *                       마법사-위자드(불,독)<br>
     *                       마법사-위자드(썬,콜)<br>
     *                       마법사-클레릭<br>
     *                       마법사-메이지(불,독)<br>
     *                       마법사-메이지(썬,콜)<br>
     *                       마법사-프리스트<br>
     *                       마법사-아크메이지(불,독)<br>
     *                       마법사-아크메이지(썬,콜)<br>
     *                       마법사-비숍<br>
     *                       궁수-전체 전직<br>
     *                       궁수-아처<br>
     *                       궁수-헌터<br>
     *                       궁수-사수<br>
     *                       궁수-레인저<br>
     *                       궁수-저격수<br>
     *                       궁수-보우마스터<br>
     *                       궁수-신궁<br>
     *                       궁수-아처(패스파인더)<br>
     *                       궁수-에인션트아처<br>
     *                       궁수-체이서<br>
     *                       궁수-패스파인더<br>
     *                       도적-전체 전직<br>
     *                       도적-로그<br>
     *                       도적-어쌔신<br>
     *                       도적-시프<br>
     *                       도적-허밋<br>
     *                       도적-시프마스터<br>
     *                       도적-나이트로드<br>
     *                       도적-섀도어<br>
     *                       도적-세미듀어러<br>
     *                       도적-듀어러<br>
     *                       도적-듀얼마스터<br>
     *                       도적-슬래셔<br>
     *                       도적-듀얼블레이더<br>
     *                       해적-전체 전직<br>
     *                       해적-해적<br>
     *                       해적-인파이터<br>
     *                       해적-건슬링거<br>
     *                       해적-캐논슈터<br>
     *                       해적-버커니어<br>
     *                       해적-발키리<br>
     *                       해적-캐논블래스터<br>
     *                       해적-바이퍼<br>
     *                       해적-캡틴<br>
     *                       해적-캐논마스터<br>
     *                       기사단-전체 전직<br>
     *                       기사단-노블레스<br>
     *                       기사단-소울마스터<br>
     *                       기사단-플레임위자드<br>
     *                       기사단-윈드브레이커<br>
     *                       기사단-나이트워커<br>
     *                       기사단-스트라이커<br>
     *                       기사단-미하일<br>
     *                       아란-전체 전직<br>
     *                       에반-전체 전직<br>
     *                       레지스탕스-전체 전직<br>
     *                       레지스탕스-시티즌<br>
     *                       레지스탕스-배틀메이지<br>
     *                       레지스탕스-와일드헌터<br>
     *                       레지스탕스-메카닉<br>
     *                       레지스탕스-데몬슬레이어<br>
     *                       레지스탕스-데몬어벤져<br>
     *                       레지스탕스-제논<br>
     *                       레지스탕스-블래스터<br>
     *                       메르세데스-전체 전직<br>
     *                       팬텀-전체 전직<br>
     *                       루미너스-전체 전직<br>
     *                       카이저-전체 전직<br>
     *                       엔젤릭버스터-전체 전직<br>
     *                       초월자-전체 전직<br>
     *                       초월자-제로<br>
     *                       은월-전체 전직<br>
     *                       프렌즈 월드-전체 전직<br>
     *                       프렌즈 월드-키네시스<br>
     *                       카데나-전체 전직<br>
     *                       일리움-전체 전직<br>
     *                       아크-전체 전직<br>
     *                       호영-전체 전직<br>
     *                       아델-전체 전직<br>
     *                       카인-전체 전직<br>
     *                       라라-전체 전직<br>
     *                       칼리-전체 전직<br>
     * @param ocid           캐릭터 식별자
     * @param page           페이지 번호
     * @param localDateTime  조회 기준일 (KST) - Example: 2023-12-22
     */
    public void getDojangRankingAsync(String worldName, Integer difficulty, String characterClass, String ocid, Integer page, LocalDateTime localDateTime, SuccessCallback<DojangRankingResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<DojangRankingResponseDTO> call = rankingApi.getDojangRanking(this.apiKey, date, worldName, difficulty, characterClass, ocid, page);

        call.enqueue(new Callback<DojangRankingResponseDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<DojangRankingResponseDTO> call, Response<DojangRankingResponseDTO> response) {
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
            public void onFailure(Call<DojangRankingResponseDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 더 시드 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName 월드 명<br>
     *                  스카니아<br>
     *                  베라<br>
     *                  루나<br>
     *                  제니스<br>
     *                  크로아<br>
     *                  유니온<br>
     *                  엘리시움<br>
     *                  이노시스<br>
     *                  레드<br>
     *                  오로라<br>
     *                  아케인<br>
     *                  노바<br>
     *                  리부트<br>
     *                  리부트2<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     * @param ocid      캐릭터 식별자
     * @param page      페이지 번호
     */
    public TheSeedRankingResponseDTO getTheSeedRanking(String worldName, String ocid, Integer page) throws IOException {
        return this.getTheSeedRanking(worldName, ocid, page, now());
    }

    /**
     * 더 시드 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName     월드 명<br>
     *                      스카니아<br>
     *                      베라<br>
     *                      루나<br>
     *                      제니스<br>
     *                      크로아<br>
     *                      유니온<br>
     *                      엘리시움<br>
     *                      이노시스<br>
     *                      레드<br>
     *                      오로라<br>
     *                      아케인<br>
     *                      노바<br>
     *                      리부트<br>
     *                      리부트2<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-22
     */
    public TheSeedRankingResponseDTO getTheSeedRanking(String worldName, String ocid, Integer page, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        return rankingApi.getTheSeedRanking(this.apiKey, date, worldName, ocid, page).execute().body();
    }

    /**
     * 더 시드 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName 월드 명<br>
     *                  스카니아<br>
     *                  베라<br>
     *                  루나<br>
     *                  제니스<br>
     *                  크로아<br>
     *                  유니온<br>
     *                  엘리시움<br>
     *                  이노시스<br>
     *                  레드<br>
     *                  오로라<br>
     *                  아케인<br>
     *                  노바<br>
     *                  리부트<br>
     *                  리부트2<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     * @param ocid      캐릭터 식별자
     * @param page      페이지 번호
     */
    public void getTheSeedRankingAsync(String worldName, String ocid, Integer page, SuccessCallback<TheSeedRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getTheSeedRankingAsync(worldName, ocid, page, now(), onSuccess, onFailure);
    }

    /**
     * 더 시드 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param worldName     월드 명<br>
     *                      스카니아<br>
     *                      베라<br>
     *                      루나<br>
     *                      제니스<br>
     *                      크로아<br>
     *                      유니온<br>
     *                      엘리시움<br>
     *                      이노시스<br>
     *                      레드<br>
     *                      오로라<br>
     *                      아케인<br>
     *                      노바<br>
     *                      리부트<br>
     *                      리부트2<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-22
     */
    public void getTheSeedRankingAsync(String worldName, String ocid, Integer page, LocalDateTime localDateTime, SuccessCallback<TheSeedRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<TheSeedRankingResponseDTO> call = rankingApi.getTheSeedRanking(this.apiKey, date, worldName, ocid, page);

        call.enqueue(new Callback<TheSeedRankingResponseDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<TheSeedRankingResponseDTO> call, Response<TheSeedRankingResponseDTO> response) {
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
            public void onFailure(Call<TheSeedRankingResponseDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    /**
     * 업적 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public AchievementRankingResponseDTO getAchievementRanking(String ocid, Integer page) throws IOException {
        return this.getAchievementRanking(ocid, page, now());
    }

    /**
     * 업적 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-22
     */
    public AchievementRankingResponseDTO getAchievementRanking(String ocid, Integer page, LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<AchievementRankingResponseDTO> call = rankingApi.getAchievementRanking(this.apiKey, date, ocid, page);

        final Response<AchievementRankingResponseDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 업적 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public void getAchievementRankingAsync(String ocid, Integer page, SuccessCallback<AchievementRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getAchievementRankingAsync(ocid, page, now(), onSuccess, onFailure);
    }

    /**
     * 업적 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 1시부터 전일 데이터 조회가 가능합니다<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST) - Example: 2023-12-22
     */
    public void getAchievementRankingAsync(String ocid, Integer page, LocalDateTime localDateTime, SuccessCallback<AchievementRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final RankingApi rankingApi = retrofit.create(RankingApi.class);
        final Call<AchievementRankingResponseDTO> call = rankingApi.getAchievementRanking(this.apiKey, date, ocid, page);

        call.enqueue(new Callback<AchievementRankingResponseDTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<AchievementRankingResponseDTO> call, Response<AchievementRankingResponseDTO> response) {
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
            public void onFailure(Call<AchievementRankingResponseDTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        });
    }

    //#endregion

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
            throw new MapleStoryApiException(MapleStoryApiErrorCode.OPENAPI00003, "Bad Request");
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

    private static LocalDateTime now() {
        return LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    }

    private static LocalDateTime minDate(int year, int month, int day) {
        return LocalDateTime.of(year, month, day, 0, 0, 0, 0);
    }

    private static String toDateString(@NonNull LocalDateTime minDate, @NonNull LocalDateTime date) {

        if (date == null) {
            date = now();
        }

        final int minYear = minDate.getYear();
        final int minMonth = minDate.getMonthValue();
        final int minDay = minDate.getDayOfMonth();

        final int year = date.getYear();
        final int month = date.getMonthValue();
        final int day = date.getDayOfMonth();

        if (year < minYear || (year == minYear && month < minMonth) || (year == minYear && month == minMonth && day < minDay)) {
            throw new IllegalArgumentException(String.format("You can only retrieve data after %d-%02d-%02d.", minYear, minMonth, minDay));
        }

        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final String yyyyMMdd = date.format(formatter);

        return yyyyMMdd;
    }
}

