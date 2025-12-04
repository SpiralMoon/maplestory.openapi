package dev.spiralmoon.maplestory.api.common;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dev.spiralmoon.maplestory.api.common.param.LatestApiUpdateTimeOption;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * MapleStory Friends API client.
 */
public abstract class MapleStoryFriendsApi {

    protected final String accessToken;

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

    public MapleStoryFriendsApi(String accessToken) {
        this.accessToken = accessToken;
        this.timeout = 5000;
    }

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
     */
    protected String toDateString(LocalDateTime date, LocalDateTime minDate) {
        if (date.isBefore(minDate)) {
            throw new IllegalArgumentException(
                    String.format("You can only retrieve data after %s.",
                            minDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
        }

        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    /**
     * 날짜 정보를 API 서버에서 요구하는 포맷으로 변환합니다.
     *
     * @param date 조회 하려는 날짜
     */
    protected String toDateString(LocalDateTime date) {
        return date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
