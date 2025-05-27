package dev.spiralmoon.maplestory.api;

import com.google.gson.Gson;
import dev.spiralmoon.maplestory.api.dto.*;
import dev.spiralmoon.maplestory.api.dto.character.*;
import dev.spiralmoon.maplestory.api.dto.guild.*;
import dev.spiralmoon.maplestory.api.dto.history.*;
import dev.spiralmoon.maplestory.api.dto.notice.*;
import dev.spiralmoon.maplestory.api.dto.ranking.*;
import dev.spiralmoon.maplestory.api.dto.union.*;
import dev.spiralmoon.maplestory.api.param.CharacterImageOption;
import dev.spiralmoon.maplestory.api.template.*;
import lombok.*;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
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
import java.util.Base64;
import java.util.concurrent.CompletableFuture;
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
    public CompletableFuture<CharacterDTO> getCharacter(@NonNull String characterName) {
        final CompletableFuture<CharacterDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacter(this.apiKey, characterName)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 계정의 보유 캐릭터 목록을 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     */
    public CompletableFuture<CharacterListDTO> getCharacterList() {
        final CompletableFuture<CharacterListDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterList(this.apiKey)
                .enqueue(createCallback(future));

        return future;
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
    public CompletableFuture<CharacterBasicDTO> getCharacterBasic(@NonNull String ocid) {
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
    public CompletableFuture<CharacterBasicDTO> getCharacterBasic(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterBasicDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterBasic(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 캐릭터 외형 이미지 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid) {
        return this.getCharacterImage(ocid, new CharacterImageOption(), null);
    }

    /**
     * 캐릭터 외형 이미지 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid        캐릭터 식별자
     * @param imageOption 캐릭터 외형 파라미터
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid, @NonNull CharacterImageOption imageOption) {
        return this.getCharacterImage(ocid, imageOption, null);
    }

    /**
     * 캐릭터 외형 이미지 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param imageOption   캐릭터 외형 파라미터
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid, @NonNull CharacterImageOption imageOption, LocalDateTime localDateTime) {
        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            return getCharacterBasic(ocid, localDateTime)
                    .thenCompose(basic -> {
                        final String path = basic.getCharacterImage().replace(MapleStoryApi.BASE_URL, "");

                        CompletableFuture<String> originImageFuture =
                                getCharacterUrlImageToBase64(ocid, path, new CharacterImageOption(), date);

                        CompletableFuture<String> imageFuture =
                                getCharacterUrlImageToBase64(ocid, path, imageOption, date);

                        return originImageFuture.thenCombine(imageFuture, (originImage, image) ->
                                new CharacterImageDTO(
                                        basic.getDate(),
                                        basic.getCharacterImage(),
                                        originImage,
                                        image,
                                        imageOption.getAction(),
                                        imageOption.getEmotion(),
                                        imageOption.getWmotion(),
                                        imageOption.getActionFrame(),
                                        imageOption.getEmotionFrame(),
                                        imageOption.getWidth(),
                                        imageOption.getHeight(),
                                        imageOption.getX(),
                                        imageOption.getY()
                                )
                        );
                    });
        } catch (Exception e) {
            final CompletableFuture<CharacterImageDTO> failed = new CompletableFuture<>();
            failed.completeExceptionally(e);

            return failed;
        }
    }

    private CompletableFuture<String> getCharacterUrlImageToBase64(@NonNull String ocid, @NonNull String path, @NonNull CharacterImageOption imageOption, String date) {
        final CharacterImageAction action = imageOption.getAction();
        final CharacterImageEmotion emotion = imageOption.getEmotion();
        final CharacterImageWeaponMotion wmotion = imageOption.getWmotion();
        final int actionFrame = imageOption.getActionFrame();
        final int emotionFrame = imageOption.getEmotionFrame();
        final Integer width = imageOption.getWidth();
        final Integer height = imageOption.getHeight();
        final Integer x = imageOption.getX();
        final Integer y = imageOption.getY();

        final CompletableFuture<String> future = new CompletableFuture<>();

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterImage(
                        path,
                        this.apiKey,
                        ocid,
                        date,
                        action.getValue() + "." + actionFrame,
                        emotion.getValue() + "." + emotionFrame,
                        wmotion.getValue(),
                        width,
                        height,
                        x,
                        y
                )
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        try {
                            if (!response.isSuccessful()) {
                                throw parseError(response);
                            }

                            final String base64 = Base64.getEncoder().encodeToString(response.body().bytes());
                            final String mimeType = response.headers().get("content-type");

                            future.complete("data:" + mimeType + ";base64," + base64);
                        } catch (Exception e) {
                            future.completeExceptionally(e);
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        future.completeExceptionally(t);
                    }
                });

        return future;
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
    public CompletableFuture<CharacterPopularityDTO> getCharacterPopularity(@NonNull String ocid) {
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
    public CompletableFuture<CharacterPopularityDTO> getCharacterPopularity(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPopularityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterPopularity(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterStatDTO> getCharacterStat(@NonNull String ocid) {
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
    public CompletableFuture<CharacterStatDTO> getCharacterStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterStat(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));

        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterHyperStatDTO> getCharacterHyperStat(@NonNull String ocid) {
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
    public CompletableFuture<CharacterHyperStatDTO> getCharacterHyperStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHyperStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterHyperStat(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterPropensityDTO> getCharacterPropensity(@NonNull String ocid) {
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
    public CompletableFuture<CharacterPropensityDTO> getCharacterPropensity(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPropensityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterPropensity(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterAbilityDTO> getCharacterAbility(@NonNull String ocid) {
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
    public CompletableFuture<CharacterAbilityDTO> getCharacterAbility(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterAbilityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterAbility(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterItemEquipmentDTO> getCharacterItemEquipment(@NonNull String ocid) {
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
    public CompletableFuture<CharacterItemEquipmentDTO> getCharacterItemEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterItemEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterItemEquipment(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterCashItemEquipmentDTO> getCharacterCashItemEquipment(@NonNull String ocid) {
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
    public CompletableFuture<CharacterCashItemEquipmentDTO> getCharacterCashItemEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterCashItemEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterCashItemEquipment(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterSymbolEquipmentDTO> getCharacterSymbolEquipment(@NonNull String ocid) {
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
    public CompletableFuture<CharacterSymbolEquipmentDTO> getCharacterSymbolEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSymbolEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterSymbolEquipment(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterSetEffectDTO> getCharacterSetEffect(@NonNull String ocid) {
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
    public CompletableFuture<CharacterSetEffectDTO> getCharacterSetEffect(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSetEffectDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterSetEffect(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterBeautyEquipmentDTO> getCharacterBeautyEquipment(@NonNull String ocid) {
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
    public CompletableFuture<CharacterBeautyEquipmentDTO> getCharacterBeautyEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterBeautyEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterBeautyEquipment(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterAndroidEquipmentDTO> getCharacterAndroidEquipment(@NonNull String ocid) {
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
    public CompletableFuture<CharacterAndroidEquipmentDTO> getCharacterAndroidEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterAndroidEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterAndroidEquipment(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterPetEquipmentDTO> getCharacterPetEquipment(@NonNull String ocid) {
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
    public CompletableFuture<CharacterPetEquipmentDTO> getCharacterPetEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPetEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterPetEquipment(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterSkillDTO> getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade) {
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
    public CompletableFuture<CharacterSkillDTO> getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSkillDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterSkill(this.apiKey, ocid, date, characterSkillGrade)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterLinkSkillDTO> getCharacterLinkSkill(@NonNull String ocid) {
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
    public CompletableFuture<CharacterLinkSkillDTO> getCharacterLinkSkill(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterLinkSkillDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterLinkSkill(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterVMatrixDTO> getCharacterVMatrix(@NonNull String ocid) {
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
    public CompletableFuture<CharacterVMatrixDTO> getCharacterVMatrix(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterVMatrixDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterVMatrix(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterHexaMatrixDTO> getCharacterHexaMatrix(@NonNull String ocid) {
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
    public CompletableFuture<CharacterHexaMatrixDTO> getCharacterHexaMatrix(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHexaMatrixDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterHexaMatrix(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterHexaMatrixStatDTO> getCharacterHexaMatrixStat(@NonNull String ocid) {
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
    public CompletableFuture<CharacterHexaMatrixStatDTO> getCharacterHexaMatrixStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHexaMatrixStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterHexaMatrixStat(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<CharacterDojangDTO> getCharacterDojang(@NonNull String ocid) {
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
    public CompletableFuture<CharacterDojangDTO> getCharacterDojang(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterDojangDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterDojang(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<UnionDTO> getUnion(@NonNull String ocid) {
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
    public CompletableFuture<UnionDTO> getUnion(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(UnionApi.class)
                    .getUnion(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<UnionRaiderDTO> getUnionRaider(@NonNull String ocid) {
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
    public CompletableFuture<UnionRaiderDTO> getUnionRaider(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionRaiderDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(UnionApi.class)
                    .getUnionRaider(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<UnionArtifactDTO> getUnionArtifact(@NonNull String ocid) {
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
    public CompletableFuture<UnionArtifactDTO> getUnionArtifact(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionArtifactDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(UnionApi.class)
                    .getUnionArtifact(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 유니온 챔피언 정보를 조회합니다.<br>
     * 유니온 챔피언 정보는 2025년 2월 20일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CompletableFuture<UnionChampionDTO> getUnionChampion(@NonNull String ocid) {
        return this.getUnionChampion(ocid, null);
    }

    /**
     * 유니온 챔피언 정보를 조회합니다.<br>
     * 유니온 챔피언 정보는 2025년 2월 20일 메이플스토리 점검 이후 데이터부터 조회 가능합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<UnionChampionDTO> getUnionChampion(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionChampionDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(UnionApi.class)
                    .getUnionChampion(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
     *                  에오스<br>
     *                  헬리오스<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     */
    public CompletableFuture<GuildDTO> getGuild(@NonNull String guildName, @NonNull String worldName) {
        final CompletableFuture<GuildDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(GuildApi.class)
                .getGuild(this.apiKey, guildName, worldName)
                .enqueue(createCallback(future));

        return future;
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
    public CompletableFuture<GuildBasicDTO> getGuildBasic(@NonNull String oguildId) {
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
    public CompletableFuture<GuildBasicDTO> getGuildBasic(@NonNull String oguildId, LocalDateTime localDateTime) {
        final CompletableFuture<GuildBasicDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2023, 12, 21))
                    : null;

            buildRetrofit()
                    .create(GuildApi.class)
                    .getGuildBasic(this.apiKey, oguildId, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<StarforceHistoryResponseDTO> getStarforceHistory(int count) {
        return this.getStarforceHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(0, 0, 0)));
    }

    /**
     * 지목한 날짜의 스타포스 강화 결과를 조회합니다.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<StarforceHistoryResponseDTO> getStarforceHistory(int count, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<StarforceHistoryResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2023, 12, 27));

            buildRetrofit()
                    .create(StarforceApi.class)
                    .getStarforceHistoryByDate(this.apiKey, count, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 지목한 날짜의 스타포스 강화 결과를 조회합니다.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 2023년 12월 27일 데이터부터 조회할 수 있습니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public CompletableFuture<StarforceHistoryResponseDTO> getStarforceHistory(int count, @NonNull String cursor) {
        final CompletableFuture<StarforceHistoryResponseDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(StarforceApi.class)
                .getStarforceHistoryByCursor(this.apiKey, count, cursor)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 큐브 사용 결과를 조회합니다.<br>
     * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.<br>
     * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public CompletableFuture<CubeHistoryResponseDTO> getCubeHistory(int count) {
        return this.getCubeHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(0, 0, 0)));
    }

    /**
     * 지목한 날짜의 큐브 사용 결과를 조회합니다.<br>
     * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.<br>
     * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<CubeHistoryResponseDTO> getCubeHistory(int count, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<CubeHistoryResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime);

            buildRetrofit()
                    .create(CubeApi.class)
                    .getCubeHistoryByDate(this.apiKey, count, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 큐브 사용 결과를 조회합니다.<br>
     * - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.<br>
     * - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public CompletableFuture<CubeHistoryResponseDTO> getCubeHistory(int count, @NonNull String cursor) {
        final CompletableFuture<CubeHistoryResponseDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(CubeApi.class)
                .getCubeHistoryByCursor(this.apiKey, count, cursor)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 잠재능력 재설정 이용 결과를 조회합니다.<br>
     * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.<br>
     * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     *
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public CompletableFuture<PotentialHistoryResponseDTO> getPotentialHistory(int count) {
        return this.getPotentialHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(0, 0, 0)));
    }

    /**
     * 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.<br>
     * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.<br>
     * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     *
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<PotentialHistoryResponseDTO> getPotentialHistory(int count, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<PotentialHistoryResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2024, 1, 25));

            buildRetrofit()
                    .create(PotentialApi.class)
                    .getPotentialHistoryByDate(this.apiKey, count, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 잠재능력 재설정 이용 결과를 조회합니다.<br>
     * - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.<br>
     * - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     *
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public CompletableFuture<PotentialHistoryResponseDTO> getPotentialHistory(int count, @NonNull String cursor) {
        final CompletableFuture<PotentialHistoryResponseDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(PotentialApi.class)
                .getPotentialHistoryByCursor(this.apiKey, count, cursor)
                .enqueue(createCallback(future));

        return future;
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
     *                       에오스<br>
     *                       헬리오스<br>
     *                       버닝<br>
     *                       버닝2<br>
     *                       버닝3<br>
     * @param worldType      월드 타입 (0:일반, 1:에오스,헬리오스) (기본 값은 0이며, worldName 입력 시 미 반영)
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
    public CompletableFuture<OverallRankingResponseDTO> getOverallRanking(String worldName, Integer worldType, String characterClass, String ocid, Integer page) {
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
     *                       에오스<br>
     *                       헬리오스<br>
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
    public CompletableFuture<OverallRankingResponseDTO> getOverallRanking(String worldName, Integer worldType, String characterClass, String ocid, Integer page, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<OverallRankingResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2023, 12, 22));

            buildRetrofit()
                    .create(RankingApi.class)
                    .getOverallRanking(this.apiKey, date, worldName, worldType, characterClass, ocid, page)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
     *                  에오스<br>
     *                  헬리오스<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     * @param ocid      캐릭터 식별자
     * @param page      페이지 번호
     */
    public CompletableFuture<UnionRankingResponseDTO> getUnionRanking(String worldName, String ocid, Integer page) {
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
     *                      에오스<br>
     *                      헬리오스<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<UnionRankingResponseDTO> getUnionRanking(String worldName, String ocid, Integer page, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<UnionRankingResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2023, 12, 22));

            buildRetrofit()
                    .create(RankingApi.class)
                    .getUnionRanking(this.apiKey, date, worldName, ocid, page)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
     *                    에오스<br>
     *                    헬리오스<br>
     *                    버닝<br>
     *                    버닝2<br>
     *                    버닝3<br>
     * @param rankingType 랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     * @param guildName   길드 명
     * @param page        페이지 번호
     */
    public CompletableFuture<GuildRankingResponseDTO> getGuildRanking(String worldName, int rankingType, String guildName, Integer page) {
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
     *                      에오스<br>
     *                      헬리오스<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param rankingType   랭킹 타입 (0:주간 명성치, 1:플래그 레이스, 2:지하 수로)
     * @param guildName     길드 명
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<GuildRankingResponseDTO> getGuildRanking(String worldName, int rankingType, String guildName, Integer page, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<GuildRankingResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2023, 12, 22));

            buildRetrofit()
                    .create(RankingApi.class)
                    .getGuildRanking(this.apiKey, date, worldName, rankingType, guildName, page)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
     *                       에오스<br>
     *                       헬리오스<br>
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
    public CompletableFuture<DojangRankingResponseDTO> getDojangRanking(String worldName, int difficulty, String characterClass, String ocid, Integer page) {
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
     *                       에오스<br>
     *                       헬리오스<br>
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
    public CompletableFuture<DojangRankingResponseDTO> getDojangRanking(String worldName, int difficulty, String characterClass, String ocid, Integer page, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<DojangRankingResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2023, 12, 22));

            buildRetrofit()
                    .create(RankingApi.class)
                    .getDojangRanking(this.apiKey, date, worldName, difficulty, characterClass, ocid, page)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
     *                  에오스<br>
     *                  헬리오스<br>
     *                  버닝<br>
     *                  버닝2<br>
     *                  버닝3<br>
     * @param ocid      캐릭터 식별자
     * @param page      페이지 번호
     */
    public CompletableFuture<TheSeedRankingResponseDTO> getTheSeedRanking(String worldName, String ocid, Integer page) {
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
     *                      에오스<br>
     *                      헬리오스<br>
     *                      버닝<br>
     *                      버닝2<br>
     *                      버닝3<br>
     * @param ocid          캐릭터 식별자
     * @param page          페이지 번호
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<TheSeedRankingResponseDTO> getTheSeedRanking(String worldName, String ocid, Integer page, LocalDateTime localDateTime) {
        final CompletableFuture<TheSeedRankingResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2023, 12, 22));

            buildRetrofit()
                    .create(RankingApi.class)
                    .getTheSeedRanking(this.apiKey, date, worldName, ocid, page)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
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
    public CompletableFuture<AchievementRankingResponseDTO> getAchievementRanking(String ocid, Integer page) {
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
    public CompletableFuture<AchievementRankingResponseDTO> getAchievementRanking(String ocid, Integer page, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<AchievementRankingResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2023, 12, 22));

            buildRetrofit()
                    .create(RankingApi.class)
                    .getAchievementRanking(this.apiKey, date, ocid, page)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    //#endregion

    //#region 공지 정보 조회

    /**
     * 메이플스토리 공지사항에 최근 등록된 게시글 20개를 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public CompletableFuture<NoticeListDTO> getNoticeList() {
        final CompletableFuture<NoticeListDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(NoticeApi.class)
                .getNoticeList(this.apiKey)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 메이플스토리 공지사항 게시글 세부 사항을 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public CompletableFuture<NoticeDetailDTO> getNoticeDetail(int noticeId) {
        final CompletableFuture<NoticeDetailDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(NoticeApi.class)
                .getNoticeDetail(this.apiKey, noticeId)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 메이플스토리 업데이트에 최근 등록된 게시글 20개를 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public CompletableFuture<UpdateNoticeListDTO> getUpdateNoticeList() {
        final CompletableFuture<UpdateNoticeListDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(NoticeApi.class)
                .getUpdateNoticeList(this.apiKey)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 메이플스토리 업데이트 게시글 세부 사항을 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public CompletableFuture<UpdateNoticeDetailDTO> getUpdateNoticeDetail(int noticeId) {
        final CompletableFuture<UpdateNoticeDetailDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(NoticeApi.class)
                .getUpdateNoticeDetail(this.apiKey, noticeId)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 메이플스토리 진행 중 이벤트에 최근 등록된 공지사항 20개를 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public CompletableFuture<EventNoticeListDTO> getEventNoticeList() {
        final CompletableFuture<EventNoticeListDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(NoticeApi.class)
                .getEventNoticeList(this.apiKey)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 메이플스토리 진행 중 이벤트 게시글 세부 사항을 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public CompletableFuture<EventNoticeDetailDTO> getEventNoticeDetail(int noticeId) {
        final CompletableFuture<EventNoticeDetailDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(NoticeApi.class)
                .getEventNoticeDetail(this.apiKey, noticeId)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 메이플스토리 캐시샵 공지에 최근 등록된 공지사항 20개를 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     */
    public CompletableFuture<CashshopNoticeListDTO> getCashshopNoticeList() {
        final CompletableFuture<CashshopNoticeListDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(NoticeApi.class)
                .getCashshopNoticeList(this.apiKey)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 메이플스토리 캐시샵 공지 게시글 세부 사항을 조회합니다.<br>
     * - 공지 정보 API는 데이터 최신화(공지 내용 수정/ 업데이트 고려)를 위해 실시간 조회 또는 최소 일배치 작업을 권장합니다.<br>
     * - 실시간으로 정보를 제공하지 않는 경우, 신규/수정 공지 내용이 반영되지 않을 수 있으니 서비스 이용 유저에게 홈페이지 공지 사항을 확인하라는 가이드를 제공해주세요.<br>
     *
     * @param noticeId 공지 식별자
     */
    public CompletableFuture<CashshopNoticeDetailDTO> getCashshopNoticeDetail(int noticeId) {
        final CompletableFuture<CashshopNoticeDetailDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(NoticeApi.class)
                .getCashshopNoticeDetail(this.apiKey, noticeId)
                .enqueue(createCallback(future));

        return future;
    }

    //#endregion

    /**
     * 서버 점검 정보를 조회합니다.
     */
    public CompletableFuture<InspectionInfoDTO> getInspectionInfo() {
        final String baseUrl = "https://api.maplestory.nexon.com/";
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(this.buildClient())
                .build();

        final String soapEnvelop =
                "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" " +
                        "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                        "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "  <soap:Body>\n" +
                        "    <GetInspectionInfo xmlns=\"https://api.maplestory.nexon.com/soap/\" />\n" +
                        "  </soap:Body>\n" +
                        "</soap:Envelope>";

        final RequestBody body = RequestBody.create(MediaType.parse("text/xml; charset=utf-8"), soapEnvelop);
        final InspectionInfoApi api = retrofit.create(InspectionInfoApi.class);
        final Call<String> call = api.getInspectionInfo(body);

        CompletableFuture<InspectionInfoDTO> future = new CompletableFuture<>();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    future.complete(new InspectionInfoDTO(response.body()));
                } else {
                    future.completeExceptionally(
                            new MapleStoryApiException(MapleStoryApiErrorCode.OPENAPI00003, "Bad Request")
                    );
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
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

    private <DTO> Callback<DTO> createCallback(CompletableFuture<DTO> task) {
        return new Callback<DTO>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<DTO> call, Response<DTO> response) {
                if (response.isSuccessful()) {
                    task.complete(response.body());
                } else {
                    task.completeExceptionally(parseError(response));
                }
            }

            @Override
            public void onFailure(Call<DTO> call, Throwable t) {
                task.completeExceptionally(t);
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
     * @param date    조회 하려는 날짜
     * @param minDate API 호출 가능한 최소 날짜
     * @return
     */
    private static String toDateString(@NonNull LocalDateTime date, @NonNull LocalDateTime minDate) {

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

    /**
     * 날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.
     *
     * @param date 조회 하려는 날짜
     * @return
     */
    private static String toDateString(@NonNull LocalDateTime date) {
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

