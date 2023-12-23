package dev.spiralmoon.maplestory.api;

import com.google.gson.Gson;
import dev.spiralmoon.maplestory.api.callback.FailureCallback;
import dev.spiralmoon.maplestory.api.callback.SuccessCallback;
import dev.spiralmoon.maplestory.api.dto.*;
import dev.spiralmoon.maplestory.api.template.CharacterApi;
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
     * 캐릭터 식별자(ocid)를 조회합니다.
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
     * 캐릭터 식별자(ocid)를 비동기로 조회합니다.
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
     * 기본 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterBasicDTO getCharacterBasic(String ocid, String date) throws IOException {

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
     * 기본 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterBasicAsync(String ocid, String date, SuccessCallback<CharacterBasicDTO> onSuccess, FailureCallback onFailure) {

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
     * 인기도 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterPopularityDTO getCharacterPopularity(String ocid, String date) throws IOException {

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
     * 인기도 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterPopularityAsync(String ocid, String date, SuccessCallback<CharacterPopularityDTO> onSuccess, FailureCallback onFailure) {

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
     * 종합 능력치 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterStatDTO getCharacterStat(String ocid, String date) throws IOException {

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
     * 종합 능력치 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterStatAsync(String ocid, String date, SuccessCallback<CharacterStatDTO> onSuccess, FailureCallback onFailure) {

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
     * 하이퍼스탯 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterHyperStatDTO getCharacterHyperStat(String ocid, String date) throws IOException {

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
     * 하이퍼스탯 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterHyperStatAsync(String ocid, String date, SuccessCallback<CharacterHyperStatDTO> onSuccess, FailureCallback onFailure) {

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
     * 성향 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterPropensityDTO getCharacterPropensity(String ocid, String date) throws IOException {

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
     * 성향 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterPropensityAsync(String ocid, String date, SuccessCallback<CharacterPropensityDTO> onSuccess, FailureCallback onFailure) {

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
     * 어빌리티 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterAbilityDTO getCharacterAbility(String ocid, String date) throws IOException {

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
     * 어빌리티 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterAbilityAsync(String ocid, String date, SuccessCallback<CharacterAbilityDTO> onSuccess, FailureCallback onFailure) {

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
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterItemEquipmentDTO getCharacterItemEquipment(String ocid, String date) throws IOException {

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
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterItemEquipmentAsync(String ocid, String date, SuccessCallback<CharacterItemEquipmentDTO> onSuccess, FailureCallback onFailure) {

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
     * 장착한 캐시 장비 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterAndroidCashItemEquipmentDTO getCharacterCashItemEquipment(String ocid, String date) throws IOException {

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
     * 장착한 캐시 장비 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterCashItemEquipmentAsync(String ocid, String date, SuccessCallback<CharacterAndroidCashItemEquipmentDTO> onSuccess, FailureCallback onFailure) {

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
     * 장착한 심볼 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterSymbolEquipmentDTO getCharacterSymbolEquipment(String ocid, String date) throws IOException {

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
     * 장착한 심볼 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterSymbolEquipmentAsync(String ocid, String date, SuccessCallback<CharacterSymbolEquipmentDTO> onSuccess, FailureCallback onFailure) {

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
     * 적용받고 있는 세트 효과 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterSetEffectDTO getCharacterSetEffect(String ocid, String date) throws IOException {

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
     * 적용받고 있는 세트 효과 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterSetEffectAsync(String ocid, String date, SuccessCallback<CharacterSetEffectDTO> onSuccess, FailureCallback onFailure) {

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
     * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterBeautyEquipmentDTO getCharacterBeautyEquipment(String ocid, String date) throws IOException {

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
     * 장착 중인 헤어, 성형, 피부 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterBeautyEquipmentAsync(String ocid, String date, SuccessCallback<CharacterBeautyEquipmentDTO> onSuccess, FailureCallback onFailure) {

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
     * 장착한 안드로이드 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterAndroidEquipmentDTO getCharacterAndroidEquipment(String ocid, String date) throws IOException {

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
     * 장착한 안드로이드 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterAndroidEquipmentAsync(String ocid, String date, SuccessCallback<CharacterAndroidEquipmentDTO> onSuccess, FailureCallback onFailure) {

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
     * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterPetEquipmentDTO getCharacterPetEquipment(String ocid, String date) throws IOException {

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
     * 장착한 펫 및 펫 스킬, 장비 정보를 비동기로 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public void getCharacterPetEquipmentAsync(String ocid, String date, SuccessCallback<CharacterPetEquipmentDTO> onSuccess, FailureCallback onFailure) {

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
     * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.
     *
     * @param ocid                캐릭터 식별자
     * @param date                조회 기준일 (KST) - Example: 2023-12-21
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
    public CharacterSkillDTO getCharacterSkill(String ocid, String date, String characterSkillGrade) throws IOException {

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
     * 캐릭터 스킬과 하이퍼 스킬 정보를 비동기로 조회합니다.
     *
     * @param ocid                캐릭터 식별자
     * @param date                조회 기준일 (KST) - Example: 2023-12-21
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
    public void getCharacterSkillAsync(String ocid, String date, String characterSkillGrade, SuccessCallback<CharacterSkillDTO> onSuccess, FailureCallback onFailure) {

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
     * 장착 링크 스킬 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterLinkSkillDTO getCharacterLinkSkill(String ocid, String date) throws IOException {

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
     * 장착 링크 스킬 정보를 비동기로 조회합니다.
     *
     * @param ocid      캐릭터 식별자
     * @param date      조회 기준일 (KST) - Example: 2023-12-21
     * @param onSuccess 성공 시 호출될 콜백
     * @param onFailure 실패 시 호출될 콜백
     */
    public void getCharacterLinkSkillAsync(String ocid, String date, SuccessCallback<CharacterLinkSkillDTO> onSuccess, FailureCallback onFailure) {

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
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterVMatrixDTO getCharacterVMatrix(String ocid, String date) throws IOException {

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
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 비동기로 조회합니다.
     *
     * @param ocid      캐릭터 식별자
     * @param date      조회 기준일 (KST) - Example: 2023-12-21
     * @param onSuccess 성공 시 호출될 콜백
     * @param onFailure 실패 시 호출될 콜백
     */
    public void getCharacterVMatrixAsync(String ocid, String date, SuccessCallback<CharacterVMatrixDTO> onSuccess, FailureCallback onFailure) {

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
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterHexaMatrixDTO getCharacterHexaMatrix(String ocid, String date) throws IOException {

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
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 비동기로 조회합니다.
     *
     * @param ocid      캐릭터 식별자
     * @param date      조회 기준일 (KST) - Example: 2023-12-21
     * @param onSuccess 성공 시 호출될 콜백
     * @param onFailure 실패 시 호출될 콜백
     */
    public void getCharacterHexaMatrixAsync(String ocid, String date, SuccessCallback<CharacterHexaMatrixDTO> onSuccess, FailureCallback onFailure) {

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
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.
     *
     * @param ocid 캐릭터 식별자
     * @param date 조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterHexaMatrixStatDTO getCharacterHexaMatrixStat(String ocid, String date) throws IOException {

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
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 비동기로 조회합니다.
     *
     * @param ocid      캐릭터 식별자
     * @param date      조회 기준일 (KST) - Example: 2023-12-21
     * @param onSuccess 성공 시 호출될 콜백
     * @param onFailure 실패 시 호출될 콜백
     */
    public void getCharacterHexaMatrixStatAsync(String ocid, String date, SuccessCallback<CharacterHexaMatrixStatDTO> onSuccess, FailureCallback onFailure) {

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
     * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.
     *
     * @param ocid      캐릭터 식별자
     * @param worldName 월드 이름
     * @param date      조회 기준일 (KST) - Example: 2023-12-21
     */
    public CharacterDojangDTO getCharacterDojang(String ocid, String worldName, String date) throws IOException {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterDojangDTO> call = characterApi.getCharacterDojang(this.apiKey, ocid, worldName, date);

        final Response<CharacterDojangDTO> response = call.execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 비동기로 조회합니다.
     *
     * @param ocid      캐릭터 식별자
     * @param worldName 월드 이름
     * @param date      조회 기준일 (KST) - Example: 2023-12-21
     * @param onSuccess 성공 시 호출될 콜백
     * @param onFailure 실패 시 호출될 콜백
     */
    public void getCharacterDojangAsync(String ocid, String worldName, String date, SuccessCallback<CharacterDojangDTO> onSuccess, FailureCallback onFailure) {

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();

        final CharacterApi characterApi = retrofit.create(CharacterApi.class);
        final Call<CharacterDojangDTO> call = characterApi.getCharacterDojang(this.apiKey, ocid, worldName, date);

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

    /**
     * 오늘 날짜의 큐브 사용 결과를 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public CubeHistoryResponseDTO getCubeResult(int count) throws IOException {

        final LocalDate kstNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
        final int year = kstNow.getYear();
        final int month = kstNow.getMonthValue();
        final int day = kstNow.getDayOfMonth();

        return this.getCubeResult(count, year, month, day);
    }

    /**
     * 오늘 날짜의 큐브 사용 결과를 비동기로 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public void getCubeResultAsync(int count, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        final LocalDate kstNow = LocalDate.now(ZoneId.of("Asia/Seoul"));
        final int year = kstNow.getYear();
        final int month = kstNow.getMonthValue();
        final int day = kstNow.getDayOfMonth();

        this.getCubeResultAsync(count, year, month, day, onSuccess, onFailure);
    }

    /**
     * 지목한 날짜의 큐브 사용 결과를 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param year  조회 기준일 (KST) 연도
     * @param month 조회 기준일 (KST) 월
     * @param day   조회 기준일 (KST) 월의 날짜
     */
    public CubeHistoryResponseDTO getCubeResult(int count, int year, int month, int day) throws IOException {

        if (year <= 2022 && month <= 11 && day < 25) {
            throw new IllegalArgumentException("You can only retrieve data after 2022-11-25.");
        }

        final LocalDate date = LocalDate.of(year, month, day);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
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
     * 지목한 날짜의 큐브 사용 결과를 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public CubeHistoryResponseDTO getCubeResult(int count, LocalDateTime localDateTime) throws IOException {
        return this.getCubeResult(count, localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth());
    }

    /**
     * 지목한 날짜의 큐브 사용 결과를 비동기로 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param year  조회 기준일 (KST) 연도
     * @param month 조회 기준일 (KST) 월
     * @param day   조회 기준일 (KST) 월의 날짜
     */
    public void getCubeResultAsync(int count, int year, int month, int day, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        if (year <= 2022 && month <= 11 && day < 25) {
            throw new IllegalArgumentException("You can only retrieve data after 2022-11-25.");
        }

        final LocalDate date = LocalDate.of(year, month, day);
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
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
     * 지목한 날짜의 큐브 사용 결과를 비동기로 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCubeResultAsync(int count, LocalDateTime localDateTime, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getCubeResultAsync(count, localDateTime.getYear(), localDateTime.getMonthValue(), localDateTime.getDayOfMonth(), onSuccess, onFailure);
    }

    /**
     * 큐브 사용 결과를 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
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
     * 큐브 사용 결과를 비동기로 조회합니다.<br>
     * 큐브 사용 결과 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * 큐브 사용 결과 데이터는 2022년 11월 25일부터 조회할 수 있습니다.<br>
     * e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public void getCubeResultAsync(int count, String cursor, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

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
}

