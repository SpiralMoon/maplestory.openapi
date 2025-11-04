package dev.spiralmoon.maplestory.api.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.spiralmoon.maplestory.api.common.param.LatestApiUpdateTimeOption;
import dev.spiralmoon.maplestory.api.common.dto.character.*;
import dev.spiralmoon.maplestory.api.common.dto.guild.GuildBasicDTO;
import dev.spiralmoon.maplestory.api.common.dto.guild.GuildDTO;
import dev.spiralmoon.maplestory.api.common.dto.union.UnionArtifactDTO;
import dev.spiralmoon.maplestory.api.common.dto.union.UnionDTO;
import dev.spiralmoon.maplestory.api.common.dto.union.UnionRaiderDTO;
import dev.spiralmoon.maplestory.api.common.template.CharacterApi;
import lombok.*;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * MapleStory OpenAPI client.
 */
public abstract class MapleStoryApi {

    protected final String apiKey;

    private static final String BASE_URL = "https://open.api.nexon.com/";

    // in milliseconds
    @Getter
    @Setter
    private long timeout;

    protected String subUrl;

    protected String timezone;

    private static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public MapleStoryApi(String apiKey) {
        this.apiKey = apiKey;
        this.timeout = 5000;
    }

    //#region Character Information Retrieval

    public abstract <Character extends CharacterDTO> CompletableFuture<Character> getCharacter(@NonNull String characterName);
    public abstract <CharacterBasic extends CharacterBasicDTO> CompletableFuture<CharacterBasic> getCharacterBasic(@NonNull String ocid);
    public abstract <CharacterBasic extends CharacterBasicDTO> CompletableFuture<CharacterBasic> getCharacterBasic(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterImage extends CharacterImageDTO> CompletableFuture<CharacterImage> getCharacterImage(@NonNull String ocid);
    protected CompletableFuture<String> getCharacterUrlImageToBase64(@NonNull String ocid, @NonNull String path, @NonNull Map<String, String> imageOption, String date) {
        final CompletableFuture<String> future = new CompletableFuture<>();

        buildRetrofit()
                .create(CharacterApi.class)
                .getCharacterImage(
                        path,
                        this.apiKey,
                        ocid,
                        date,
                        imageOption
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
    public abstract <CharacterPopularity extends CharacterPopularityDTO> CompletableFuture<CharacterPopularity> getCharacterPopularity(@NonNull String ocid);
    public abstract <CharacterPopularity extends CharacterPopularityDTO> CompletableFuture<CharacterPopularity> getCharacterPopularity(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterStat extends CharacterStatDTO<?>> CompletableFuture<CharacterStat> getCharacterStat(@NonNull String ocid);
    public abstract <CharacterStat extends CharacterStatDTO<?>> CompletableFuture<CharacterStat> getCharacterStat(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterHyperStat extends CharacterHyperStatDTO<?>> CompletableFuture<CharacterHyperStat> getCharacterHyperStat(@NonNull String ocid);
    public abstract <CharacterHyperStat extends CharacterHyperStatDTO<?>> CompletableFuture<CharacterHyperStat> getCharacterHyperStat(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterPropensity extends CharacterPropensityDTO> CompletableFuture<CharacterPropensity> getCharacterPropensity(@NonNull String ocid);
    public abstract <CharacterPropensity extends CharacterPropensityDTO> CompletableFuture<CharacterPropensity> getCharacterPropensity(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterAbility extends CharacterAbilityDTO<?, ?>> CompletableFuture<CharacterAbility> getCharacterAbility(@NonNull String ocid);
    public abstract <CharacterAbility extends CharacterAbilityDTO<?, ?>> CompletableFuture<CharacterAbility> getCharacterAbility(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterItemEquipment extends CharacterItemEquipmentDTO<?, ?, ?, ?>> CompletableFuture<CharacterItemEquipment> getCharacterItemEquipment(@NonNull String ocid);
    public abstract <CharacterItemEquipment extends CharacterItemEquipmentDTO<?, ?, ?, ?>> CompletableFuture<CharacterItemEquipment> getCharacterItemEquipment(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterCashItemEquipment extends CharacterCashItemEquipmentDTO<?>> CompletableFuture<CharacterCashItemEquipment> getCharacterCashItemEquipment(@NonNull String ocid);
    public abstract <CharacterCashItemEquipment extends CharacterCashItemEquipmentDTO<?>> CompletableFuture<CharacterCashItemEquipment> getCharacterCashItemEquipment(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterSymbolEquipment extends CharacterSymbolEquipmentDTO<?>> CompletableFuture<CharacterSymbolEquipment> getCharacterSymbolEquipment(@NonNull String ocid);
    public abstract <CharacterSymbolEquipment extends CharacterSymbolEquipmentDTO<?>> CompletableFuture<CharacterSymbolEquipment> getCharacterSymbolEquipment(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterSetEffect extends CharacterSetEffectDTO<?>> CompletableFuture<CharacterSetEffect> getCharacterSetEffect(@NonNull String ocid);
    public abstract <CharacterSetEffect extends CharacterSetEffectDTO<?>> CompletableFuture<CharacterSetEffect> getCharacterSetEffect(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterBeautyEquipment extends CharacterBeautyEquipmentDTO<?, ?, ?>> CompletableFuture<CharacterBeautyEquipment> getCharacterBeautyEquipment(@NonNull String ocid);
    public abstract <CharacterBeautyEquipment extends CharacterBeautyEquipmentDTO<?, ?, ?>> CompletableFuture<CharacterBeautyEquipment> getCharacterBeautyEquipment(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterAndroidEquipment extends CharacterAndroidEquipmentDTO<?, ?, ?, ?, ?>> CompletableFuture<CharacterAndroidEquipment> getCharacterAndroidEquipment(@NonNull String ocid);
    public abstract <CharacterAndroidEquipment extends CharacterAndroidEquipmentDTO<?, ?, ?, ?, ?>> CompletableFuture<CharacterAndroidEquipment> getCharacterAndroidEquipment(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterPetEquipment extends CharacterPetEquipmentDTO<?, ?>> CompletableFuture<CharacterPetEquipment> getCharacterPetEquipment(@NonNull String ocid);
    public abstract <CharacterPetEquipment extends CharacterPetEquipmentDTO<?, ?>> CompletableFuture<CharacterPetEquipment> getCharacterPetEquipment(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterSkill extends CharacterSkillDTO<?>> CompletableFuture<CharacterSkill> getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade);
    public abstract <CharacterSkill extends CharacterSkillDTO<?>> CompletableFuture<CharacterSkill> getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade, LocalDateTime localDateTime);
    public abstract <CharacterLinkSkill extends CharacterLinkSkillDTO<?>> CompletableFuture<CharacterLinkSkill> getCharacterLinkSkill(@NonNull String ocid);
    public abstract <CharacterLinkSkill extends CharacterLinkSkillDTO<?>> CompletableFuture<CharacterLinkSkill> getCharacterLinkSkill(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterVMatrix extends CharacterVMatrixDTO<?>> CompletableFuture<CharacterVMatrix> getCharacterVMatrix(@NonNull String ocid);
    public abstract <CharacterVMatrix extends CharacterVMatrixDTO<?>> CompletableFuture<CharacterVMatrix> getCharacterVMatrix(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterHexaMatrix extends CharacterHexaMatrixDTO<?>> CompletableFuture<CharacterHexaMatrix> getCharacterHexaMatrix(@NonNull String ocid);
    public abstract <CharacterHexaMatrix extends CharacterHexaMatrixDTO<?>> CompletableFuture<CharacterHexaMatrix> getCharacterHexaMatrix(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterHexaMatrixStat extends CharacterHexaMatrixStatDTO<?>> CompletableFuture<CharacterHexaMatrixStat> getCharacterHexaMatrixStat(@NonNull String ocid);
    public abstract <CharacterHexaMatrixStat extends CharacterHexaMatrixStatDTO<?>> CompletableFuture<CharacterHexaMatrixStat> getCharacterHexaMatrixStat(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <CharacterDojang extends CharacterDojangDTO> CompletableFuture<CharacterDojang> getCharacterDojang(@NonNull String ocid);
    public abstract <CharacterDojang extends CharacterDojangDTO> CompletableFuture<CharacterDojang> getCharacterDojang(@NonNull String ocid, LocalDateTime localDateTime);

    //#endregion

    //#region Union Information Retrieval

    public abstract <Union extends UnionDTO> CompletableFuture<Union> getUnion(@NonNull String ocid);
    public abstract <Union extends UnionDTO> CompletableFuture<Union> getUnion(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <UnionRaider extends UnionRaiderDTO<?, ?, ?>> CompletableFuture<UnionRaider> getUnionRaider(@NonNull String ocid);
    public abstract <UnionRaider extends UnionRaiderDTO<?, ?, ?>> CompletableFuture<UnionRaider> getUnionRaider(@NonNull String ocid, LocalDateTime localDateTime);
    public abstract <UnionArtifact extends UnionArtifactDTO<?, ?>> CompletableFuture<UnionArtifact> getUnionArtifact(@NonNull String ocid);
    public abstract <UnionArtifact extends UnionArtifactDTO<?, ?>> CompletableFuture<UnionArtifact> getUnionArtifact(@NonNull String ocid, LocalDateTime localDateTime);

    //#endregion

    //#region Guild Information Retrieval

    public abstract <Guild extends GuildDTO> CompletableFuture<Guild> getGuild(@NonNull String guildName, @NonNull String worldName);
    public abstract <GuildBasic extends GuildBasicDTO<?>> CompletableFuture<GuildBasic> getGuildBasic(@NonNull String oGuildId);
    public abstract <GuildBasic extends GuildBasicDTO<?>> CompletableFuture<GuildBasic> getGuildBasic(@NonNull String oGuildId, LocalDateTime localDateTime);

    //#endregion

    protected Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .client(this.buildClient())
                .build();
    }

    protected OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .readTimeout(timeout, TimeUnit.MILLISECONDS)
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .build();
    }

    protected <DTO> Callback<ResponseBody> createCallback(CompletableFuture<DTO> task, Class<DTO> dtoClass) {
        return createCallback(task, dtoClass, false);
    }

    protected <DTO> Callback<ResponseBody> createCallback(CompletableFuture<DTO> task, Class<DTO> dtoClass, boolean checkEmpty) {
        return new Callback<ResponseBody>() {
            @SneakyThrows
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    final String rawJson = response.body().string();

                    if (checkEmpty) {
                        final JsonNode jsonNode = objectMapper.readTree(rawJson);

                        if (isEmptyResponse(jsonNode)) {
                            task.complete(null);
                            return;
                        }
                    }

                    final DTO dto = objectMapper.readValue(rawJson, dtoClass);
                    task.complete(dto);
                } else {
                    task.completeExceptionally(parseError(response));
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                task.completeExceptionally(t);
            }
        };
    }

    /**
     * API 응답 데이터가 비어있는지 확인 합니다.<br/>
     * API 요청 시 날짜에 해당하는 데이터가 없을 경우 date 필드만 값이 존재하는 상황을 검증할 때 사용 합니다.<br/>
     * 일반적으로 API 지원 시작일과 캐릭터 생성일 사이의 날짜를 조회할 때 발생 합니다.
     *
     * @param jsonNode JSON 응답을 파싱한 JsonNode
     * @return date 필드를 제외한 모든 필드가 null 또는 빈 배열인 경우 true
     */
    private boolean isEmptyResponse(JsonNode jsonNode) {
        if (!jsonNode.isObject()) {
            return false;
        }

        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();

        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> field = fields.next();

            if ("date".equals(field.getKey())) {
                continue;
            }

            JsonNode value = field.getValue();

            if (value.isNull()) {
                continue;
            }
            if (value.isArray() && value.isEmpty()) {
                continue;
            }

            return false;
        }

        return true; // 모든 필드(date 제외)가 null 또는 빈 배열
    }

    protected static MapleStoryApiException parseError(Response<?> response) throws IOException {
        final String errorJson = response.errorBody().string();
        final MapleStoryApiErrorBody error = objectMapper.readValue(errorJson, MapleStoryApiErrorBody.class);

        return new MapleStoryApiException(error);
    }

    protected static LocalDateTime minDate(int year, int month, int day) {
        return LocalDateTime.of(year, month, day, 0, 0, 0, 0);
    }

    /**
     * API 서버의 데이터 갱신 시간에 따라 데이터를 조회 가능한 최신 날짜를 반환합니다.
     *
     * @param option
     */
    protected LocalDateTime getProperDefaultDateTime(LatestApiUpdateTimeOption option) {

        final int hour = option.getHour();
        final int minute = option.getMinute();
        final Integer dateOffset = option.getDateOffset();

        final LocalDateTime nowInTimezone = LocalDateTime.now(ZoneId.of(this.timezone));
        final LocalDateTime updateDate = LocalDateTime
                .now(ZoneId.of(this.timezone))
                .withHour(hour)
                .withMinute(minute);

        LocalDateTime adjustedDateTime;

        if (nowInTimezone.isAfter(updateDate)) {
            adjustedDateTime = nowInTimezone;
        } else {
            adjustedDateTime = nowInTimezone.minusDays(1);
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
    protected static String toDateString(@NonNull LocalDateTime date, @NonNull LocalDateTime minDate) {

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
    protected static String toDateString(@NonNull LocalDateTime date) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final String yyyyMMdd = date.format(formatter);

        return yyyyMMdd;
    }
}

