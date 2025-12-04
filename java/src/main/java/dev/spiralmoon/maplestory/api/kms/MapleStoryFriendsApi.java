package dev.spiralmoon.maplestory.api.kms;

import dev.spiralmoon.maplestory.api.common.param.LatestApiUpdateTimeOption;
import dev.spiralmoon.maplestory.api.kms.dto.history.CubeHistoryResponseDTO;
import dev.spiralmoon.maplestory.api.kms.dto.history.PotentialHistoryResponseDTO;
import dev.spiralmoon.maplestory.api.kms.dto.history.StarforceHistoryResponseDTO;
import dev.spiralmoon.maplestory.api.kms.dto.user.AchievementDTO;
import dev.spiralmoon.maplestory.api.kms.dto.user.CharacterListDTO;
import dev.spiralmoon.maplestory.api.kms.template.FriendsCubeApi;
import dev.spiralmoon.maplestory.api.kms.template.FriendsPotentialApi;
import dev.spiralmoon.maplestory.api.kms.template.FriendsStarforceApi;
import dev.spiralmoon.maplestory.api.kms.template.FriendsUserApi;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.concurrent.CompletableFuture;

/**
 * MapleStory Friends API client for KMS<br>
 * This is an implementation of <a href="https://openapi.nexon.com/ko/friends/maplestory/?id=36">MapleStory Friends API</a>
 */
public class MapleStoryFriendsApi extends dev.spiralmoon.maplestory.api.common.MapleStoryFriendsApi {

    // in milliseconds
    @Getter
    @Setter
    private long timeout;

    public MapleStoryFriendsApi(String accessToken) {
        super(accessToken);

        this.timezone = "Asia/Seoul";
        this.subUrl = "maplestory";
    }

    //#region 계정 정보 조회

    /**
     * 계정의 보유 캐릭터 목록을 조회합니다.<br>
     * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '캐릭터 목록'을 활용 데이터 항목으로 선택해주세요.<br>
     * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     */
    public CompletableFuture<CharacterListDTO> getCharacterList() {
        final CompletableFuture<CharacterListDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(FriendsUserApi.class)
                .getCharacterList("Bearer " + this.accessToken)
                .enqueue(createCallback(future, CharacterListDTO.class));

        return future;
    }

    /**
     * 계정의 업적 정보를 조회합니다.<br>
     * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '업적 정보'를 활용 데이터 항목으로 선택해주세요.<br>
     * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     */
    public CompletableFuture<AchievementDTO> getAchievement() {
        final CompletableFuture<AchievementDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(FriendsUserApi.class)
                .getAchievement("Bearer " + this.accessToken)
                .enqueue(createCallback(future, AchievementDTO.class));

        return future;
    }

    //#endregion

    //#region 확률 정보 조회

    /**
     * 스타포스 강화 결과를 조회합니다.<br>
     * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     */
    public CompletableFuture<StarforceHistoryResponseDTO> getStarforceHistory(int count) {
        return this.getStarforceHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(0, 0, 0)));
    }

    /**
     * 지목한 날짜의 스타포스 강화 결과를 조회합니다.<br>
     * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<StarforceHistoryResponseDTO> getStarforceHistory(int count, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<StarforceHistoryResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2023, 12, 27));

            buildRetrofit()
                    .create(FriendsStarforceApi.class)
                    .getStarforceHistoryByDate("Bearer " + this.accessToken, count, date)
                    .enqueue(createCallback(future, StarforceHistoryResponseDTO.class));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 지목한 날짜의 스타포스 강화 결과를 조회합니다.<br>
     * - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '스타포스 강화 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     * - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     * - 스타포스 확률 정보는 최대 5분 후 확인 가능합니다.<br>
     * - 스타포스 강화 결과는 2023년 12월 27일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000)
     * @param cursor 페이징 처리를 위한 cursor
     */
    public CompletableFuture<StarforceHistoryResponseDTO> getStarforceHistory(int count, @NonNull String cursor) {
        final CompletableFuture<StarforceHistoryResponseDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(FriendsStarforceApi.class)
                .getStarforceHistoryByCursor("Bearer " + this.accessToken, count, cursor)
                .enqueue(createCallback(future, StarforceHistoryResponseDTO.class));

        return future;
    }

    /**
     * 큐브 사용 결과를 조회합니다.<br>
     - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.<br>
     - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.<br>
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
     */
    public CompletableFuture<CubeHistoryResponseDTO> getCubeHistory(int count) {
        return this.getCubeHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(0, 0, 0)));
    }

    /**
     * 지목한 날짜의 큐브 사용 결과를 조회합니다.<br>
     - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.<br>
     - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.<br>
     * @param count         한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<CubeHistoryResponseDTO> getCubeHistory(int count, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<CubeHistoryResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime);

            buildRetrofit()
                    .create(FriendsCubeApi.class)
                    .getCubeHistoryByDate("Bearer " + this.accessToken, count, date)
                    .enqueue(createCallback(future, CubeHistoryResponseDTO.class));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 큐브 사용 결과를 조회합니다.<br>
     - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '큐브 사용 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     - 큐브 확률 정보는 최대 30분 후 확인 가능합니다.<br>
     - 큐브 사용 결과는 최근 2년 데이터만 조회 가능합니다.<br>
     * @param count  한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
     * @param cursor 페이징 처리를 위한 cursor
     */
    public CompletableFuture<CubeHistoryResponseDTO> getCubeHistory(int count, @NonNull String cursor) {
        final CompletableFuture<CubeHistoryResponseDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(FriendsCubeApi.class)
                .getCubeHistoryByCursor("Bearer " + this.accessToken, count, cursor)
                .enqueue(createCallback(future, CubeHistoryResponseDTO.class));

        return future;
    }

    /**
     * 잠재능력 재설정 이용 결과를 조회합니다.<br>
     - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.<br>
     - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
     */
    public CompletableFuture<PotentialHistoryResponseDTO> getPotentialHistory(int count) {
        return this.getPotentialHistory(count, getProperDefaultDateTime(new LatestApiUpdateTimeOption(0, 0, 0)));
    }

    /**
     * 지목한 날짜의 잠재능력 재설정 이용 결과를 조회합니다.<br>
     - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.<br>
     - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
     * @param localDateTime 조회 기준일 (KST)
     */
    public CompletableFuture<PotentialHistoryResponseDTO> getPotentialHistory(int count, @NonNull LocalDateTime localDateTime) {
        final CompletableFuture<PotentialHistoryResponseDTO> future = new CompletableFuture<>();

        try {
            final String date = toDateString(localDateTime, minDate(2024, 1, 25));

            buildRetrofit()
                    .create(FriendsPotentialApi.class)
                    .getPotentialHistoryByDate("Bearer " + this.accessToken, count, date)
                    .enqueue(createCallback(future, PotentialHistoryResponseDTO.class));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    /**
     * 잠재능력 재설정 이용 결과를 조회합니다.<br>
     - 이 항목을 조회하시려면 NEXON Open ID 클라이언트 설정에서 '잠재능력 재설정 이용 결과'를 활용 데이터 항목으로 선택해주세요.<br>
     - 이후 자세한 데이터 호출 및 활용 방법은 <a href="https://openapi.nexon.com/ko/open-id/development-guide/">NEXON Open ID 개발 가이드 문서</a>를 참조해주세요.<br>
     - 잠재능력 재설정 정보는 최대 30분 후 확인 가능합니다.<br>
     - 잠재능력 재설정 이용 결과는 2024년 01월 25일 데이터부터 조회 가능하며, 최대 2년동안의 데이터만 제공됩니다.<br>
     * @param count 한번에 가져오려는 결과의 개수(최소 10, 최대 1000). 옵션 재설정을 3회 진행한 결과가 포함될 경우 입력한 count보다 적은 수로 조회될 수 있습니다.
     * @param cursor 페이징 처리를 위한 cursor
     */
    public CompletableFuture<PotentialHistoryResponseDTO> getPotentialHistory(int count, @NonNull String cursor) {
        final CompletableFuture<PotentialHistoryResponseDTO> future = new CompletableFuture<>();

        buildRetrofit()
                .create(FriendsPotentialApi.class)
                .getPotentialHistoryByCursor("Bearer " + this.accessToken, count, cursor)
                .enqueue(createCallback(future, PotentialHistoryResponseDTO.class));

        return future;
    }

    //#endregion
}
