package dev.spiralmoon.maplestory.api.kms;

import dev.spiralmoon.maplestory.api.common.MapleStoryApiErrorCode;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.common.param.LatestApiUpdateTimeOption;
import dev.spiralmoon.maplestory.api.kms.dto.InspectionInfoDTO;
import dev.spiralmoon.maplestory.api.kms.dto.character.*;
import dev.spiralmoon.maplestory.api.kms.dto.guild.*;
import dev.spiralmoon.maplestory.api.kms.dto.history.*;
import dev.spiralmoon.maplestory.api.kms.dto.notice.*;
import dev.spiralmoon.maplestory.api.kms.dto.ranking.*;
import dev.spiralmoon.maplestory.api.kms.dto.union.*;
import dev.spiralmoon.maplestory.api.kms.dto.user.*;
import dev.spiralmoon.maplestory.api.kms.template.*;
import dev.spiralmoon.maplestory.api.kms.param.*;
import lombok.*;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * MapleStory OpenAPI client for KMS.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestory">MapleStory API</a>
 */
public class MapleStoryApi extends dev.spiralmoon.maplestory.api.common.MapleStoryApi {

    private static final String BASE_URL = "https://open.api.nexon.com/";

    // in milliseconds
    @Getter
    @Setter
    private long timeout;

    public MapleStoryApi(String apiKey) {
        super(apiKey);

        this.timezone = "Asia/Seoul";
        this.subUrl = "maplestory";
    }

    //#region 계정 정보 조회

    /**
     * 계정의 보유 캐릭터 목록을 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
     */
    public CompletableFuture<CharacterListDTO> getCharacterList() {
        final CompletableFuture<CharacterListDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(UserApi.class)
                .getCharacterList(this.apiKey)
                .enqueue(createCallback(future));

        return future;
    }

    /**
     * 계정의 업적 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
     */
    public CompletableFuture<AchievementDTO> getAchievement() {
        final CompletableFuture<AchievementDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(UserApi.class)
                .getAchievement(this.apiKey)
                .enqueue(createCallback(future));

        return future;
    }

    //#endregion

    //#region 캐릭터 정보 조회

    /**
     * 캐릭터 식별자(ocid)를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * 기본 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
                        final Map<String, String> queryMap = new HashMap<>();
                        queryMap.put("action", imageOption.getAction().getValue());
                        queryMap.put("emotion", imageOption.getEmotion().getValue());
                        queryMap.put("wmotion", imageOption.getWmotion().getValue());
                        queryMap.put("actionFrame", String.valueOf(imageOption.getActionFrame()));
                        queryMap.put("emotionFrame", String.valueOf(imageOption.getEmotionFrame()));

                        CompletableFuture<String> originImageFuture =
                                getCharacterUrlImageToBase64(ocid, path, Collections.emptyMap(), date);

                        CompletableFuture<String> imageFuture =
                                getCharacterUrlImageToBase64(ocid, path, queryMap, date);

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
                                        300,
                                        300,
                                        150,
                                        200
                                )
                        );
                    });
        } catch (Exception e) {
            final CompletableFuture<CharacterImageDTO> failed = new CompletableFuture<>();
            failed.completeExceptionally(e);

            return failed;
        }
    }

    /**
     * 인기도 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2023년 12월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
     *
     * @param ocid                캐릭터 식별자
     * @param characterSkillGrade 조회하고자 하는 전직 차수 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a><br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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

    /**
     * 캐릭터 기타 능력치에 영향을 주는 요소 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2025년 8월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CompletableFuture<CharacterOtherStatDTO> getCharacterOtherStat(@NonNull String ocid) {
        return this.getCharacterOtherStat(ocid, null);
    }

    /**
     * 캐릭터 기타 능력치에 영향을 주는 요소 정보를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2025년 8월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (12월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<CharacterOtherStatDTO> getCharacterOtherStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterOtherStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 8, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterOtherStat(this.apiKey, ocid, date)
                    .enqueue(createCallback(future));

        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 링 익스체인지 스킬 등록 장비를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2025년 8월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (8월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
     *
     * @param ocid 캐릭터 식별자
     */
    public CompletableFuture<CharacterRingExchangeSkillEquipmentDTO> getCharacterRingExchangeSkillEquipment(@NonNull String ocid) {
        return this.getCharacterRingExchangeSkillEquipment(ocid, null);
    }

    /**
     * 링 익스체인지 스킬 등록 장비를 조회합니다.<br>
     * - 메이플스토리 게임 데이터는 평균 15분 후 확인 가능합니다.<br>
     * - 2025년 8월 21일 데이터부터 조회할 수 있습니다.<br>
     * - 과거 데이터는 원하는 일자를 입력해 조회할 수 있으며, 전일 데이터는 다음날 오전 2시부터 확인할 수 있습니다. (8월 22일 데이터 조회 시, 22일 00시부터 23일 00시 사이 데이터가 조회 됩니다.)<br>
     * - 게임 콘텐츠 변경으로 ocid가 변경될 수 있습니다. ocid 기반 서비스 갱신 시 유의해 주시길 바랍니다.<br>
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
     *
     * @param ocid          캐릭터 식별자
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<CharacterRingExchangeSkillEquipmentDTO> getCharacterRingExchangeSkillEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterRingExchangeSkillEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 8, 21))
                    : null;

            buildRetrofit()
                    .create(CharacterApi.class)
                    .getCharacterRingExchangeSkillEquipment(this.apiKey, ocid, date)
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
     *
     * @param guildName 길드 명
     * @param worldName 월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=16">Available values</a>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * - 해당 API는 메이플스토리 한국의 데이터가 제공됩니다.<br>
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
     * @param worldName      월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=18">Available values</a>
     * @param worldType      월드 타입 (0:일반, 1:에오스,헬리오스) (기본 값은 0이며, worldName 입력 시 미 반영)
     * @param characterClass 직업 및 전직 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName      월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
     * @param worldType      월드 타입 (0:일반, 1:에오스,헬리오스) (기본 값은 0이며, worldName 입력 시 미 반영)
     * @param characterClass 직업 및 전직 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName 월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName     월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName   월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName     월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName      월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
     * @param difficulty     구간 (0:일반, 1:통달)
     * @param characterClass 직업 및 전직 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName      월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
     * @param difficulty     구간 (0:일반, 1:통달)
     * @param characterClass 직업 및 전직 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName 월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
     * @param worldName     월드 명 <a href="https://openapi.nexon.com/ko/game/maplestory/?id=14">Available values</a>
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
}

