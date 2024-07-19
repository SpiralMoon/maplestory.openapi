package dev.spiralmoon.maplestory.api;

import com.google.gson.Gson;
import dev.spiralmoon.maplestory.api.callback.FailureCallback;
import dev.spiralmoon.maplestory.api.callback.SuccessCallback;
import dev.spiralmoon.maplestory.api.dto.*;
import dev.spiralmoon.maplestory.api.dto.character.*;
import dev.spiralmoon.maplestory.api.dto.guild.*;
import dev.spiralmoon.maplestory.api.dto.history.*;
import dev.spiralmoon.maplestory.api.dto.notice.*;
import dev.spiralmoon.maplestory.api.dto.ranking.*;
import dev.spiralmoon.maplestory.api.dto.union.*;
import dev.spiralmoon.maplestory.api.template.*;
import lombok.*;
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
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param characterName 캐릭터 명
     */
    public CharacterDTO getCharacter(@NonNull String characterName) throws IOException {

        final Response<CharacterDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacter(this.apiKey, characterName)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 캐릭터 식별자(ocid)를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param characterName 캐릭터 명
     */
    public void getCharacterAsync(@NonNull String characterName, SuccessCallback<CharacterDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacter(this.apiKey, characterName)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 계정의 보유 캐릭터 목록을 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     */
    public CharacterListDTO getCharacterList() throws IOException {

        final Response<CharacterListDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterList(this.apiKey)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 계정의 보유 캐릭터 목록을 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     */
    public void getCharacterListAsync(SuccessCallback<CharacterListDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterList(this.apiKey)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 기본 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterBasicDTO getCharacterBasic(@NonNull String ocid) throws IOException {
        return this.getCharacterBasic(ocid, null);
    }

    /**
     * 기본 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterBasicDTO getCharacterBasic(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterBasicDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterBasic(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 기본 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid      캐릭터 식별자
     * @param onSuccess 성공 시 콜백
     * @param onFailure 실패 시 콜백
     */
    public void getCharacterBasicAsync(@NonNull String ocid, SuccessCallback<CharacterBasicDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterBasicAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 기본 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterBasicAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterBasicDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterBasic(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 인기도 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterPopularityDTO getCharacterPopularity(@NonNull String ocid) throws IOException {
        return this.getCharacterPopularity(ocid, null);
    }

    /**
     * 인기도 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterPopularityDTO getCharacterPopularity(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterPopularityDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterPopularity(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 인기도 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterPopularityAsync(@NonNull String ocid, SuccessCallback<CharacterPopularityDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterPopularityAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 인기도 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterPopularityAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterPopularityDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterPopularity(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 종합 능력치 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterStatDTO getCharacterStat(@NonNull String ocid) throws IOException {
        return this.getCharacterStat(ocid, null);
    }

    /**
     * 종합 능력치 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterStatDTO getCharacterStat(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterStatDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterStat(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 종합 능력치 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterStatAsync(@NonNull String ocid, SuccessCallback<CharacterStatDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterStatAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 종합 능력치 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterStatAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterStatDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterStat(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 하이퍼스탯 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterHyperStatDTO getCharacterHyperStat(@NonNull String ocid) throws IOException {
        return this.getCharacterHyperStat(ocid, null);
    }

    /**
     * 하이퍼스탯 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterHyperStatDTO getCharacterHyperStat(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterHyperStatDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterHyperStat(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 하이퍼스탯 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterHyperStatAsync(@NonNull String ocid, SuccessCallback<CharacterHyperStatDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterHyperStatAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 하이퍼스탯 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterHyperStatAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterHyperStatDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterHyperStat(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 성향 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterPropensityDTO getCharacterPropensity(@NonNull String ocid) throws IOException {
        return this.getCharacterPropensity(ocid, null);
    }

    /**
     * 성향 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterPropensityDTO getCharacterPropensity(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterPropensityDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterPropensity(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 성향 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterPropensityAsync(@NonNull String ocid, SuccessCallback<CharacterPropensityDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterPropensityAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 성향 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterPropensityAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterPropensityDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterPropensity(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 어빌리티 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterAbilityDTO getCharacterAbility(@NonNull String ocid) throws IOException {
        return getCharacterAbility(ocid, null);
    }

    /**
     * 어빌리티 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterAbilityDTO getCharacterAbility(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterAbilityDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterAbility(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 어빌리티 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterAbilityAsync(@NonNull String ocid, SuccessCallback<CharacterAbilityDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterAbilityAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 어빌리티 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterAbilityAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterAbilityDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterAbility(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterItemEquipmentDTO getCharacterItemEquipment(@NonNull String ocid) throws IOException {
        return this.getCharacterItemEquipment(ocid, null);
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterItemEquipmentDTO getCharacterItemEquipment(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterItemEquipmentDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterItemEquipment(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterItemEquipmentAsync(@NonNull String ocid, SuccessCallback<CharacterItemEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterItemEquipmentAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 장착한 장비 중 캐시 장비를 제외한 나머지 장비 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterItemEquipmentAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterItemEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterItemEquipment(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 장착한 캐시 장비 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterCashItemEquipmentDTO getCharacterCashItemEquipment(@NonNull String ocid) throws IOException {
        return this.getCharacterCashItemEquipment(ocid, null);
    }

    /**
     * 장착한 캐시 장비 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterCashItemEquipmentDTO getCharacterCashItemEquipment(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterCashItemEquipmentDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterCashItemEquipment(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 캐시 장비 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterCashItemEquipmentAsync(@NonNull String ocid, SuccessCallback<CharacterCashItemEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterCashItemEquipmentAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 장착한 캐시 장비 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterCashItemEquipmentAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterCashItemEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterCashItemEquipment(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 장착한 심볼 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterSymbolEquipmentDTO getCharacterSymbolEquipment(@NonNull String ocid) throws IOException {
        return this.getCharacterSymbolEquipment(ocid, null);
    }

    /**
     * 장착한 심볼 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterSymbolEquipmentDTO getCharacterSymbolEquipment(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterSymbolEquipmentDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterSymbolEquipment(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 심볼 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterSymbolEquipmentAsync(@NonNull String ocid, SuccessCallback<CharacterSymbolEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterSymbolEquipmentAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 장착한 심볼 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterSymbolEquipmentAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterSymbolEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterSymbolEquipment(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 적용받고 있는 세트 효과 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterSetEffectDTO getCharacterSetEffect(@NonNull String ocid) throws IOException {
        return this.getCharacterSetEffect(ocid, null);
    }

    /**
     * 적용받고 있는 세트 효과 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterSetEffectDTO getCharacterSetEffect(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterSetEffectDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterSetEffect(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 적용받고 있는 세트 효과 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterSetEffectAsync(@NonNull String ocid, SuccessCallback<CharacterSetEffectDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterSetEffectAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 적용받고 있는 세트 효과 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterSetEffectAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterSetEffectDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterSetEffect(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterBeautyEquipmentDTO getCharacterBeautyEquipment(@NonNull String ocid) throws IOException {
        return this.getCharacterBeautyEquipment(ocid, null);
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterBeautyEquipmentDTO getCharacterBeautyEquipment(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterBeautyEquipmentDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterBeautyEquipment(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterBeautyEquipmentAsync(@NonNull String ocid, SuccessCallback<CharacterBeautyEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterBeautyEquipmentAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 장착 중인 헤어, 성형, 피부 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterBeautyEquipmentAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterBeautyEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterBeautyEquipment(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 장착한 안드로이드 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterAndroidEquipmentDTO getCharacterAndroidEquipment(@NonNull String ocid) throws IOException {
        return getCharacterAndroidEquipment(ocid, null);
    }

    /**
     * 장착한 안드로이드 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterAndroidEquipmentDTO getCharacterAndroidEquipment(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterAndroidEquipmentDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterAndroidEquipment(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 안드로이드 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterAndroidEquipmentAsync(@NonNull String ocid, SuccessCallback<CharacterAndroidEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterAndroidEquipmentAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 장착한 안드로이드 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterAndroidEquipmentAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterAndroidEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterAndroidEquipment(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterPetEquipmentDTO getCharacterPetEquipment(@NonNull String ocid) throws IOException {
        return this.getCharacterPetEquipment(ocid, null);
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterPetEquipmentDTO getCharacterPetEquipment(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterPetEquipmentDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterPetEquipment(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterPetEquipmentAsync(@NonNull String ocid, SuccessCallback<CharacterPetEquipmentDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterPetEquipmentAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 장착한 펫 및 펫 스킬, 장비 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterPetEquipmentAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterPetEquipmentDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterPetEquipment(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
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
    public CharacterSkillDTO getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade) throws IOException {
        return this.getCharacterSkill(ocid, characterSkillGrade, null);
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
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
     * @param localDateTime       조회 기준일 (KST)
     */
    public CharacterSkillDTO getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterSkillDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterSkill(this.apiKey, ocid, date, characterSkillGrade)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
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
    public void getCharacterSkillAsync(@NonNull String ocid, @NonNull String characterSkillGrade, SuccessCallback<CharacterSkillDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterSkillAsync(ocid, null, characterSkillGrade, onSuccess, onFailure);
    }

    /**
     * 캐릭터 스킬과 하이퍼 스킬 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid                캐릭터 식별자
     * @param localDateTime       조회 기준일 (KST)
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
    public void getCharacterSkillAsync(@NonNull String ocid, LocalDateTime localDateTime, String characterSkillGrade, SuccessCallback<CharacterSkillDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterSkill(this.apiKey, ocid, date, characterSkillGrade)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 장착 링크 스킬 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterLinkSkillDTO getCharacterLinkSkill(@NonNull String ocid) throws IOException {
        return this.getCharacterLinkSkill(ocid, null);
    }

    /**
     * 장착 링크 스킬 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterLinkSkillDTO getCharacterLinkSkill(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterLinkSkillDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterLinkSkill(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 장착 링크 스킬 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterLinkSkillAsync(@NonNull String ocid, SuccessCallback<CharacterLinkSkillDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterLinkSkillAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 장착 링크 스킬 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterLinkSkillAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterLinkSkillDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterLinkSkill(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterVMatrixDTO getCharacterVMatrix(@NonNull String ocid) throws IOException {
        return this.getCharacterVMatrix(ocid, null);
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterVMatrixDTO getCharacterVMatrix(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterVMatrixDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterVMatrix(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterVMatrixAsync(@NonNull String ocid, SuccessCallback<CharacterVMatrixDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterVMatrixAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * V매트릭스 슬롯 정보와 장착한 V코어 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterVMatrixAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterVMatrixDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterVMatrix(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterHexaMatrixDTO getCharacterHexaMatrix(@NonNull String ocid) throws IOException {
        return this.getCharacterHexaMatrix(ocid, null);
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterHexaMatrixDTO getCharacterHexaMatrix(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterHexaMatrixDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterHexaMatrix(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterHexaMatrixAsync(@NonNull String ocid, SuccessCallback<CharacterHexaMatrixDTO> onSuccess, FailureCallback onFailure) {
        getCharacterHexaMatrixAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * HEXA 매트릭스에 장착한 HEXA 코어 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterHexaMatrixAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterHexaMatrixDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterHexaMatrix(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterHexaMatrixStatDTO getCharacterHexaMatrixStat(@NonNull String ocid) throws IOException {
        return this.getCharacterHexaMatrixStat(ocid, null);
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterHexaMatrixStatDTO getCharacterHexaMatrixStat(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterHexaMatrixStatDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterHexaMatrixStat(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterHexaMatrixStatAsync(@NonNull String ocid, SuccessCallback<CharacterHexaMatrixStatDTO> onSuccess, FailureCallback onFailure) {
        this.getCharacterHexaMatrixStatAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * HEXA 매트릭스에 설정한 HEXA 스탯 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterHexaMatrixStatAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterHexaMatrixStatDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterHexaMatrixStat(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CharacterDojangDTO getCharacterDojang(@NonNull String ocid) throws IOException {
        return this.getCharacterDojang(ocid, null);
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CharacterDojangDTO getCharacterDojang(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<CharacterDojangDTO> response = buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterDojang(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getCharacterDojangAsync(@NonNull String ocid, SuccessCallback<CharacterDojangDTO> onSuccess, FailureCallback onFailure) {
        getCharacterDojangAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 캐릭터 무릉도장 최고 기록 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getCharacterDojangAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<CharacterDojangDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterDojang(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    //#endregion

    //#region 유니온 정보 조회

    /**
     * 유니온 레벨 및 유니온 등급 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public UnionDTO getUnion(@NonNull String ocid) throws IOException {
        return this.getUnion(ocid, null);
    }

    /**
     * 유니온 레벨 및 유니온 등급 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public UnionDTO getUnion(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<UnionDTO> response = buildRetrofit()
                .create(UnionApi.class)
                .getUnion(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 유니온 레벨 및 유니온 등급 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getUnionAsync(@NonNull String ocid, SuccessCallback<UnionDTO> onSuccess, FailureCallback onFailure) {
        this.getUnionAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 유니온 레벨 및 유니온 등급 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getUnionAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<UnionDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(UnionApi.class)
                .getUnion(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public UnionRaiderDTO getUnionRaider(@NonNull String ocid) throws IOException {
        return this.getUnionRaider(ocid, null);
    }

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public UnionRaiderDTO getUnionRaider(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<UnionRaiderDTO> response = buildRetrofit()
                .create(UnionApi.class)
                .getUnionRaider(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getUnionRaiderAsync(@NonNull String ocid, SuccessCallback<UnionRaiderDTO> onSuccess, FailureCallback onFailure) {
        this.getUnionRaiderAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 유니온에 배치된 공격대원 효과 및 공격대 점령 효과 등 상세 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getUnionRaiderAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<UnionRaiderDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(UnionApi.class)
                .getUnionRaider(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 유니온 아티팩트 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public UnionArtifactDTO getUnionArtifact(@NonNull String ocid) throws IOException {
        return this.getUnionArtifact(ocid, null);
    }

    /**
     * 유니온 아티팩트 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public UnionArtifactDTO getUnionArtifact(@NonNull String ocid, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<UnionArtifactDTO> response = buildRetrofit()
                .create(UnionApi.class)
                .getUnionArtifact(this.apiKey, ocid, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 유니온 아티팩트 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public void getUnionArtifactAsync(@NonNull String ocid, SuccessCallback<UnionArtifactDTO> onSuccess, FailureCallback onFailure) {
        this.getUnionArtifactAsync(ocid, null, onSuccess, onFailure);
    }

    /**
     * 유니온 아티팩트 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getUnionArtifactAsync(@NonNull String ocid, LocalDateTime localDateTime, SuccessCallback<UnionArtifactDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(UnionApi.class)
                .getUnionArtifact(this.apiKey, ocid, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    //#endregion

    //#region 길드 정보 조회

    /**
     * 길드 식별자(oguild_id) 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
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
    public GuildDTO getGuild(@NonNull String guildName, @NonNull String worldName) throws IOException {

        final Response<GuildDTO> response = buildRetrofit()
                .create(GuildApi.class)
                .getGuild(this.apiKey, guildName, worldName)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 길드 식별자(oguild_id) 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
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
    public void getGuildAsync(@NonNull String guildName, @NonNull String worldName, SuccessCallback<GuildDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(GuildApi.class)
                .getGuild(this.apiKey, guildName, worldName)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 길드 기본 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param oguildId 길드 식별자
     */
    public GuildBasicDTO getGuildBasic(@NonNull String oguildId) throws IOException {
        return this.getGuildBasic(oguildId, null);
    }

    /**
     * 길드 기본 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param oguildId      길드 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public GuildBasicDTO getGuildBasic(@NonNull String oguildId, LocalDateTime localDateTime) throws IOException {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        final Response<GuildBasicDTO> response = buildRetrofit()
                .create(GuildApi.class)
                .getGuildBasic(this.apiKey, oguildId, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 길드 기본 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param oguildId 길드 식별자
     */
    public void getGuildBasicAsync(@NonNull String oguildId, SuccessCallback<GuildBasicDTO> onSuccess, FailureCallback onFailure) {
        this.getGuildBasicAsync(oguildId, null, onSuccess, onFailure);
    }

    /**
     * 길드 기본 정보를 비동기로 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param oguildId      길드 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getGuildBasicAsync(@NonNull String oguildId, LocalDateTime localDateTime, SuccessCallback<GuildBasicDTO> onSuccess, FailureCallback onFailure) {

        final String date = localDateTime != null
                ? toDateString(minDate(2023, 12, 21), localDateTime)
                : null;

        buildRetrofit()
                .create(GuildApi.class)
                .getGuildBasic(this.apiKey, oguildId, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    //#endregion

    //#region 확률 정보 조회

    /**
     * 스타포스 강화 결과를 조회합니다.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public StarforceHistoryResponseDTO getStarforceHistory(int count) throws IOException {
        return this.getStarforceHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(0, 0, 0)));
    }

    /**
     * 스타포스 강화 결과를 조회합니다.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public void getStarforceHistoryAsync(int count, SuccessCallback<StarforceHistoryResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getStarforceHistoryAsync(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(0, 0, 0)), onSuccess, onFailure);
    }

    /**
     * 지목한 날짜의 스타포스 강화 결과를 조회합니다.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public StarforceHistoryResponseDTO getStarforceHistory(int count, @NonNull LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 27), localDateTime);

        final Response<StarforceHistoryResponseDTO> response = buildRetrofit()
                .create(StarforceApi.class)
                .getStarforceHistoryByDate(this.apiKey, count, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 지목한 날짜의 스타포스 강화 결과를 비동기로 조회합니다.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getStarforceHistoryAsync(int count, @NonNull LocalDateTime localDateTime, SuccessCallback<StarforceHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 27), localDateTime);

        buildRetrofit()
                .create(StarforceApi.class)
                .getStarforceHistoryByDate(this.apiKey, count, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 지목한 날짜의 스타포스 강화 결과를 조회합니다.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public StarforceHistoryResponseDTO getStarforceHistory(int count, @NonNull String cursor) throws IOException {

        final Response<StarforceHistoryResponseDTO> response = buildRetrofit()
                .create(StarforceApi.class)
                .getStarforceHistoryByCursor(this.apiKey, count, cursor)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 스타포스 강화 결과를 조회합니다.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public void getStarforceHistoryAsync(int count, @NonNull String cursor, SuccessCallback<StarforceHistoryResponseDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(StarforceApi.class)
                .getStarforceHistoryByCursor(this.apiKey, count, cursor)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 큐브 사용 결과를 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public CubeHistoryResponseDTO getCubeHistory(int count) throws IOException {
        return this.getCubeHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(4, 0, 1)));
    }

    /**
     * 큐브 사용 결과를 비동기로 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public void getCubeHistoryAsync(int count, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getCubeHistoryAsync(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(4, 0, 1)), onSuccess, onFailure);
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
    public CubeHistoryResponseDTO getCubeHistory(int count, @NonNull LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2022, 11, 25), localDateTime);

        final Response<CubeHistoryResponseDTO> response = buildRetrofit()
                .create(CubeApi.class)
                .getCubeHistoryByDate(this.apiKey, count, date)
                .execute();

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
    public void getCubeHistoryAsync(int count, @NonNull LocalDateTime localDateTime, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2022, 11, 25), localDateTime);

        buildRetrofit()
                .create(CubeApi.class)
                .getCubeHistoryByDate(this.apiKey, count, date)
                .enqueue(createCallback(onSuccess, onFailure));
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
    public CubeHistoryResponseDTO getCubeHistory(int count, @NonNull String cursor) throws IOException {

        final Response<CubeHistoryResponseDTO> response = buildRetrofit()
                .create(CubeApi.class)
                .getCubeHistoryByCursor(this.apiKey, count, cursor)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 큐브 사용 결과를 비동기로 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 큐브 확률 정보 조회 시, 어제의 큐브 확률 정보 데이터를 조회할 수 있습니다.<br>
     * - 2022년 11월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public void getCubeHistoryAsync(int count, @NonNull String cursor, SuccessCallback<CubeHistoryResponseDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(CubeApi.class)
                .getCubeHistoryByCursor(this.apiKey, count, cursor)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 잠재능력 재설정 이용 결과를 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.<br>
     * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public PotentialHistoryResponseDTO getPotentialHistory(int count) throws IOException {
        return this.getPotentialHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(4, 0, 1)));
    }

    /**
     * 잠재능력 재설정 이용 결과를 비동기로 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.<br>
     * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public void getPotentialHistoryAsync(int count, SuccessCallback<PotentialHistoryResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getPotentialHistoryAsync(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(4, 0, 1)), onSuccess, onFailure);
    }

    /**
     * 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.<br>
     * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public PotentialHistoryResponseDTO getPotentialHistory(int count, @NonNull LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2024, 1, 25), localDateTime);

        final Response<PotentialHistoryResponseDTO> response = buildRetrofit()
                .create(PotentialApi.class)
                .getPotentialHistoryByDate(this.apiKey, count, date)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 지목한 날짜의 잠재능력 재설정 이용 결과를 비동기로 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.<br>
     * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getPotentialHistoryAsync(int count, @NonNull LocalDateTime localDateTime, SuccessCallback<PotentialHistoryResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2022, 11, 25), localDateTime);

        buildRetrofit()
                .create(PotentialApi.class)
                .getPotentialHistoryByDate(this.apiKey, count, date)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 잠재능력 재설정 이용 결과를 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.<br>
     * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public PotentialHistoryResponseDTO getPotentialHistory(int count, @NonNull String cursor) throws IOException {

        final Response<PotentialHistoryResponseDTO> response = buildRetrofit()
                .create(PotentialApi.class)
                .getPotentialHistoryByCursor(this.apiKey, count, cursor)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 잠재능력 재설정 이용 결과를 비동기로 조회합니다.<br>
     * - 데이터는 매일 오전 4시, 전일 데이터가 갱신됩니다.<br>
     * - e.g. 오늘 오후 3시 5분 잠재능력 재설정 정보 조회 시, 어제의 잠재능력 재설정 정보 데이터를 조회할 수 있습니다.<br>
     * - 2024년 1월 25일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public void getPotentialHistoryAsync(int count, @NonNull String cursor, SuccessCallback<PotentialHistoryResponseDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(PotentialApi.class)
                .getPotentialHistoryByCursor(this.apiKey, count, cursor)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    //#endregion

    //#region 랭킹 정보 조회

    /**
     * 종합 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
        return this.getOverallRanking(worldName, worldType, characterClass, ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)));
    }

    /**
     * 종합 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime  조회 기준일 (KST)
     */
    public OverallRankingResponseDTO getOverallRanking(String worldName, Integer worldType, String characterClass, String ocid, Integer page, @NonNull LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Response<OverallRankingResponseDTO> response = buildRetrofit()
                .create(RankingApi.class)
                .getOverallRanking(this.apiKey, date, worldName, worldType, characterClass, ocid, page)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 종합 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
        this.getOverallRankingAsync(worldName, worldType, characterClass, ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)), onSuccess, onFailure);
    }

    /**
     * 종합 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime  조회 기준일 (KST)
     */
    public void getOverallRankingAsync(String worldName, Integer worldType, String characterClass, String ocid, Integer page, @NonNull LocalDateTime localDateTime, SuccessCallback<OverallRankingResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        buildRetrofit()
                .create(RankingApi.class)
                .getOverallRanking(this.apiKey, date, worldName, worldType, characterClass, ocid, page)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 유니온 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
        return this.getUnionRanking(worldName, ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)));
    }

    /**
     * 유니온 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime 조회 기준일 (KST)
     */
    public UnionRankingResponseDTO getUnionRanking(String worldName, String ocid, Integer page, @NonNull LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Response<UnionRankingResponseDTO> response = buildRetrofit()
                .create(RankingApi.class)
                .getUnionRanking(this.apiKey, date, worldName, ocid, page)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 유니온 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
        this.getUnionRankingAsync(worldName, ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)), onSuccess, onFailure);
    }

    /**
     * 유니온 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getUnionRankingAsync(String worldName, String ocid, Integer page, LocalDateTime localDateTime, SuccessCallback<UnionRankingResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        buildRetrofit()
                .create(RankingApi.class)
                .getUnionRanking(this.apiKey, date, worldName, ocid, page)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 길드 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
    public GuildRankingResponseDTO getGuildRanking(String worldName, int rankingType, String guildName, Integer page) throws IOException {
        return this.getGuildRanking(worldName, rankingType, guildName, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)));
    }

    /**
     * 길드 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime 조회 기준일 (KST)
     */
    public GuildRankingResponseDTO getGuildRanking(String worldName, int rankingType, String guildName, Integer page, @NonNull LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Response<GuildRankingResponseDTO> response = buildRetrofit()
                .create(RankingApi.class)
                .getGuildRanking(this.apiKey, date, worldName, rankingType, guildName, page)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 길드 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
    public void getGuildRankingAsync(String worldName, int rankingType, String guildName, Integer page, SuccessCallback<GuildRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getGuildRankingAsync(worldName, rankingType, guildName, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)), onSuccess, onFailure);
    }

    /**
     * 길드 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getGuildRankingAsync(String worldName, int rankingType, String guildName, Integer page, @NonNull LocalDateTime localDateTime, SuccessCallback<GuildRankingResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        buildRetrofit()
                .create(RankingApi.class)
                .getGuildRanking(this.apiKey, date, worldName, rankingType, guildName, page)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 무릉도장 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
    public DojangRankingResponseDTO getDojangRanking(String worldName, int difficulty, String characterClass, String ocid, Integer page) throws IOException {
        return this.getDojangRanking(worldName, difficulty, characterClass, ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)));
    }

    /**
     * 무릉도장 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime  조회 기준일 (KST)
     */
    public DojangRankingResponseDTO getDojangRanking(String worldName, int difficulty, String characterClass, String ocid, Integer page, @NonNull LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Response<DojangRankingResponseDTO> response = buildRetrofit()
                .create(RankingApi.class)
                .getDojangRanking(this.apiKey, date, worldName, difficulty, characterClass, ocid, page)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 무릉도장 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
    public void getDojangRankingAsync(String worldName, int difficulty, String characterClass, String ocid, Integer page, SuccessCallback<DojangRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getDojangRankingAsync(worldName, difficulty, characterClass, ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)), onSuccess, onFailure);
    }

    /**
     * 무릉도장 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime  조회 기준일 (KST)
     */
    public void getDojangRankingAsync(String worldName, int difficulty, String characterClass, String ocid, Integer page, @NonNull LocalDateTime localDateTime, SuccessCallback<DojangRankingResponseDTO> onSuccess, FailureCallback onFailure) {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        buildRetrofit()
                .create(RankingApi.class)
                .getDojangRanking(this.apiKey, date, worldName, difficulty, characterClass, ocid, page)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 더 시드 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
        return this.getTheSeedRanking(worldName, ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)));
    }

    /**
     * 더 시드 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime 조회 기준일 (KST)
     */
    public TheSeedRankingResponseDTO getTheSeedRanking(String worldName, String ocid, Integer page, LocalDateTime localDateTime) throws IOException {

        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Response<TheSeedRankingResponseDTO> response = buildRetrofit()
                .create(RankingApi.class)
                .getTheSeedRanking(this.apiKey, date, worldName, ocid, page)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 더 시드 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
        this.getTheSeedRankingAsync(worldName, ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)), onSuccess, onFailure);
    }

    /**
     * 더 시드 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
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
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getTheSeedRankingAsync(String worldName, String ocid, Integer page, @NonNull LocalDateTime localDateTime, SuccessCallback<TheSeedRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        buildRetrofit()
                .create(RankingApi.class)
                .getTheSeedRanking(this.apiKey, date, worldName, ocid, page)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 업적 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public AchievementRankingResponseDTO getAchievementRanking(String ocid, Integer page) throws IOException {
        return this.getAchievementRanking(ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)));
    }

    /**
     * 업적 랭킹 정보를 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST)
     */
    public AchievementRankingResponseDTO getAchievementRanking(String ocid, Integer page, @NonNull LocalDateTime localDateTime) throws IOException {
        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        final Response<AchievementRankingResponseDTO> response = buildRetrofit()
                .create(RankingApi.class)
                .getAchievementRanking(this.apiKey, date, ocid, page)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 업적 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     * @param page 페이지 번호
     */
    public void getAchievementRankingAsync(String ocid, Integer page, SuccessCallback<AchievementRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        this.getAchievementRankingAsync(ocid, page, getProperDefaultDateTime(new LatestApiUpdateTimeOption(8, 30, 0)), onSuccess, onFailure);
    }

    /**
     * 업적 랭킹 정보를 비동기로 조회합니다.<br>
     * - 2023년 12월 22일 데이터부터 조회할 수 있습니다.<br>
     * - 오전 8시 30분부터 오늘의 랭킹 정보를 조회할 수 있습니다.<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST)
     */
    public void getAchievementRankingAsync(String ocid, Integer page, @NonNull LocalDateTime localDateTime, SuccessCallback<AchievementRankingResponseDTO> onSuccess, FailureCallback onFailure) {
        final String date = toDateString(minDate(2023, 12, 22), localDateTime);

        buildRetrofit()
                .create(RankingApi.class)
                .getAchievementRanking(this.apiKey, date, ocid, page)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    //#endregion

    //#region 공지 정보 조회

    /**
     * 메이플스토리 공지사항에 최근 등록된 게시글 20개를 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public NoticeListDTO getNoticeList() throws IOException {

        final Response<NoticeListDTO> response = buildRetrofit()
                .create(NoticeApi.class)
                .getNoticeList(this.apiKey)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 메이플스토리 공지사항에 최근 등록된 게시글 20개를 비동기로 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public void getNoticeListAsync(SuccessCallback<NoticeListDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(NoticeApi.class)
                .getNoticeList(this.apiKey)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 메이플스토리 공지사항 게시글 세부 사항을 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public NoticeDetailDTO getNoticeDetail(int noticeId) throws IOException {

        final Response<NoticeDetailDTO> response = buildRetrofit()
                .create(NoticeApi.class)
                .getNoticeDetail(this.apiKey, noticeId)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 메이플스토리 공지사항 게시글 세부 사항을 비동기로 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public void getNoticeDetailAsync(int noticeId, SuccessCallback<NoticeDetailDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(NoticeApi.class)
                .getNoticeDetail(this.apiKey, noticeId)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 메이플스토리 업데이트에 최근 등록된 게시글 20개를 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public UpdateNoticeListDTO getUpdateNoticeList() throws IOException {

        final Response<UpdateNoticeListDTO> response = buildRetrofit()
                .create(NoticeApi.class)
                .getUpdateNoticeList(this.apiKey)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 메이플스토리 업데이트에 최근 등록된 게시글 20개를 비동기로 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public void getUpdateNoticeListAsync(SuccessCallback<UpdateNoticeListDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(NoticeApi.class)
                .getUpdateNoticeList(this.apiKey)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 메이플스토리 업데이트 게시글 세부 사항을 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public UpdateNoticeDetailDTO getUpdateNoticeDetail(int noticeId) throws IOException {

        final Response<UpdateNoticeDetailDTO> response = buildRetrofit()
                .create(NoticeApi.class)
                .getUpdateNoticeDetail(this.apiKey, noticeId)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 메이플스토리 업데이트 게시글 세부 사항을 비동기로 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public void getUpdateNoticeDetailAsync(int noticeId, SuccessCallback<UpdateNoticeDetailDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(NoticeApi.class)
                .getUpdateNoticeDetail(this.apiKey, noticeId)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 메이플스토리 진행 중 이벤트에 최근 등록된 공지사항 20개를 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public EventNoticeListDTO getEventNoticeList() throws IOException {

        final Response<EventNoticeListDTO> response = buildRetrofit()
                .create(NoticeApi.class)
                .getEventNoticeList(this.apiKey)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 메이플스토리 진행 중 이벤트에 최근 등록된 공지사항 20개를 비동기로 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public void getEventNoticeListAsync(SuccessCallback<EventNoticeListDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(NoticeApi.class)
                .getEventNoticeList(this.apiKey)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 메이플스토리 진행 중 이벤트 게시글 세부 사항을 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public EventNoticeDetailDTO getEventNoticeDetail(int noticeId) throws IOException {

        final Response<EventNoticeDetailDTO> response = buildRetrofit()
                .create(NoticeApi.class)
                .getEventNoticeDetail(this.apiKey, noticeId)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 메이플스토리 진행 중 이벤트 게시글 세부 사항을 비동기로 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public void getEventNoticeDetailAsync(int noticeId, SuccessCallback<EventNoticeDetailDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(NoticeApi.class)
                .getEventNoticeDetail(this.apiKey, noticeId)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 메이플스토리 캐시샵 공지에 최근 등록된 공지사항 20개를 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public CashshopNoticeListDTO getCashshopNoticeList() throws IOException {

        final Response<CashshopNoticeListDTO> response = buildRetrofit()
                .create(NoticeApi.class)
                .getCashshopNoticeList(this.apiKey)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 메이플스토리 캐시샵 공지에 최근 등록된 공지사항 20개를 비동기로 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public void getCashshopNoticeListAsync(SuccessCallback<CashshopNoticeListDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(NoticeApi.class)
                .getCashshopNoticeList(this.apiKey)
                .enqueue(createCallback(onSuccess, onFailure));
    }

    /**
     * 메이플스토리 캐시샵 공지 게시글 세부 사항을 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public CashshopNoticeDetailDTO getCashshopNoticeDetail(int noticeId) throws IOException {

        final Response<CashshopNoticeDetailDTO> response = buildRetrofit()
                .create(NoticeApi.class)
                .getCashshopNoticeDetail(this.apiKey, noticeId)
                .execute();

        if (!response.isSuccessful()) {
            throw parseError(response);
        }

        return response.body();
    }

    /**
     * 메이플스토리 캐시샵 공지 게시글 세부 사항을 비동기로 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public void getCashshopNoticeDetailAsync(int noticeId, SuccessCallback<CashshopNoticeDetailDTO> onSuccess, FailureCallback onFailure) {
        buildRetrofit()
                .create(NoticeApi.class)
                .getCashshopNoticeDetail(this.apiKey, noticeId)
                .enqueue(createCallback(onSuccess, onFailure));
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

        final InspectionInfoApi api = retrofit.create(InspectionInfoApi.class);
        final Call<String> call = api.getInspectionInfo(body);

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

        final InspectionInfoApi api = retrofit.create(InspectionInfoApi.class);
        final Call<String> call = api.getInspectionInfo(body);

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

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(this.buildClient())
                .build();
    }

    private OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .build();
    }

    private <DTO> Callback<DTO> createCallback(SuccessCallback<DTO> onSuccess, FailureCallback onFailure) {
        return new Callback<DTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<DTO> call, Response<DTO> response) {
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
            public void onFailure(Call<DTO> call, Throwable t) {
                if (onFailure != null) {
                    onFailure.callback(t);
                }
            }
        };
    }

    private static MapleStoryApiException parseError(Response<?> response) throws IOException {
        final Gson gson = new Gson();
        final MapleStoryApiErrorBody error = gson.fromJson(response.errorBody().string(), MapleStoryApiErrorBody.class);

        return new MapleStoryApiException(error);
    }

    private static LocalDateTime minDate(int year, int month, int day) {
        return LocalDateTime.of(year, month, day, 0, 0, 0, 0);
    }

    /**
     * API 서버의 데이터 갱신 시간에 따라 데이터를 조회 가능한 최신 날짜를 반환합니다.
     *
     * @param option
     */
    private static LocalDateTime getProperDefaultDateTime(LatestApiUpdateTimeOption option) {

        final int hour = option.getHour();
        final int minute = option.getMinute();
        final Integer dateOffset = option.getDateOffset();

        final LocalDateTime kstNow = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        final LocalDateTime updateDate = LocalDateTime
                .now(ZoneId.of("Asia/Seoul"))
                .withHour(hour)
                .withMinute(minute);

        LocalDateTime adjustedDateTime;

        if (kstNow.isAfter(updateDate)) {
            adjustedDateTime = kstNow;
        } else {
            adjustedDateTime = kstNow.minusDays(1);
        }

        return adjustedDateTime.minusDays(dateOffset != null ? dateOffset : 0);
    }

    /**
     * 날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.
     *
     * @param minDate API 호출 가능한 최소 날짜
     * @param date    조회 하려는 날짜
     * @return
     */
    private static String toDateString(@NonNull LocalDateTime minDate, @NonNull LocalDateTime date) {

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

/**
 * API 서버의 데이터 갱신 시각과 조회 가능한 최근 날짜와 현재 날짜와의 차이
 */
@AllArgsConstructor
@Data
class LatestApiUpdateTimeOption {

    private int hour;

    private int minute;

    private Integer dateOffset;
}

