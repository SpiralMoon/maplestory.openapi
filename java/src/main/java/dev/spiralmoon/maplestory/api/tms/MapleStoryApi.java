package dev.spiralmoon.maplestory.api.tms;

import dev.spiralmoon.maplestory.api.tms.dto.character.*;
import dev.spiralmoon.maplestory.api.tms.dto.guild.GuildBasicDTO;
import dev.spiralmoon.maplestory.api.tms.dto.guild.GuildDTO;
import dev.spiralmoon.maplestory.api.tms.dto.union.UnionArtifactDTO;
import dev.spiralmoon.maplestory.api.tms.dto.union.UnionDTO;
import dev.spiralmoon.maplestory.api.tms.dto.union.UnionRaiderDTO;
import dev.spiralmoon.maplestory.api.tms.param.CharacterImageOption;
import dev.spiralmoon.maplestory.api.tms.template.CharacterApi;
import dev.spiralmoon.maplestory.api.tms.template.GuildApi;
import dev.spiralmoon.maplestory.api.tms.template.UnionApi;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * MapleStory OpenAPI client for TMS.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestorytw">MapleStory API</a>
 */
public class MapleStoryApi extends dev.spiralmoon.maplestory.api.common.MapleStoryApi {

    private static final String BASE_URL = "https://open.api.nexon.com/";

    // in milliseconds
    @Getter
    @Setter
    private long timeout;

    public MapleStoryApi(String apiKey) {
        super(apiKey);

        this.timezone = "Asia/Taipei";
        this.subUrl = "maplestorytw";
    }

    //#region 檢視角色資訊

    /**
     * 檢視角色辨識器 (OCID)。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param characterName 角色名稱
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
     * 檢視基本資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterBasicDTO> getCharacterBasic(@NonNull String ocid) {
        return this.getCharacterBasic(ocid, null);
    }

    /**
     * 檢視基本資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterBasicDTO> getCharacterBasic(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterBasicDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視角色外型圖片資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid) {
        return this.getCharacterImage(ocid, new CharacterImageOption(), null);
    }

    /**
     * 檢視角色外型圖片資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid        角色辨識器
     * @param imageOption 圖像選項
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid, @NonNull CharacterImageOption imageOption) {
        return this.getCharacterImage(ocid, imageOption, null);
    }

    /**
     * 檢視角色外型圖片資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param imageOption   圖像選項
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid, @NonNull CharacterImageOption imageOption, LocalDateTime localDateTime) {
        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
                        queryMap.put("width", String.valueOf(imageOption.getWidth()));
                        queryMap.put("height", String.valueOf(imageOption.getHeight()));
                        queryMap.put("x", String.valueOf(imageOption.getX()));
                        queryMap.put("y", String.valueOf(imageOption.getY()));

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

    /**
     * 檢視名聲資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterPopularityDTO> getCharacterPopularity(@NonNull String ocid) {
        return this.getCharacterPopularity(ocid, null);
    }

    /**
     * 檢視名聲資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterPopularityDTO> getCharacterPopularity(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPopularityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視綜合能力值資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterStatDTO> getCharacterStat(@NonNull String ocid) {
        return this.getCharacterStat(ocid, null);
    }

    /**
     * 檢視綜合能力值資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterStatDTO> getCharacterStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視極限屬性資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterHyperStatDTO> getCharacterHyperStat(@NonNull String ocid) {
        return this.getCharacterHyperStat(ocid, null);
    }

    /**
     * 檢視極限屬性資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterHyperStatDTO> getCharacterHyperStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHyperStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視性向資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterPropensityDTO> getCharacterPropensity(@NonNull String ocid) {
        return this.getCharacterPropensity(ocid, null);
    }

    /**
     * 檢視性向資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterPropensityDTO> getCharacterPropensity(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPropensityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視能力資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterAbilityDTO> getCharacterAbility(@NonNull String ocid) {
        return getCharacterAbility(ocid, null);
    }

    /**
     * 檢視能力資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterAbilityDTO> getCharacterAbility(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterAbilityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視已裝備道具資訊 (不含現金道具)。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterItemEquipmentDTO> getCharacterItemEquipment(@NonNull String ocid) {
        return this.getCharacterItemEquipment(ocid, null);
    }

    /**
     * 檢視已裝備道具資訊 (不含現金道具)。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterItemEquipmentDTO> getCharacterItemEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterItemEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視已裝備現金道具資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterCashItemEquipmentDTO> getCharacterCashItemEquipment(@NonNull String ocid) {
        return this.getCharacterCashItemEquipment(ocid, null);
    }

    /**
     * 檢視已裝備現金道具資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterCashItemEquipmentDTO> getCharacterCashItemEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterCashItemEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視已裝備符文資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterSymbolEquipmentDTO> getCharacterSymbolEquipment(@NonNull String ocid) {
        return this.getCharacterSymbolEquipment(ocid, null);
    }

    /**
     * 檢視已裝備符文資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterSymbolEquipmentDTO> getCharacterSymbolEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSymbolEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視目前套用的套裝效果資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterSetEffectDTO> getCharacterSetEffect(@NonNull String ocid) {
        return this.getCharacterSetEffect(ocid, null);
    }

    /**
     * 檢視目前套用的套裝效果資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterSetEffectDTO> getCharacterSetEffect(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSetEffectDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視目前已裝備的髮型、臉型與膚色資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterBeautyEquipmentDTO> getCharacterBeautyEquipment(@NonNull String ocid) {
        return this.getCharacterBeautyEquipment(ocid, null);
    }

    /**
     * 檢視目前已裝備的髮型、臉型與膚色資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterBeautyEquipmentDTO> getCharacterBeautyEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterBeautyEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視已裝備機器人資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterAndroidEquipmentDTO> getCharacterAndroidEquipment(@NonNull String ocid) {
        return getCharacterAndroidEquipment(ocid, null);
    }

    /**
     * 檢視已裝備機器人資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterAndroidEquipmentDTO> getCharacterAndroidEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterAndroidEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視已裝備寵物、寵物技能與寵物道具資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterPetEquipmentDTO> getCharacterPetEquipment(@NonNull String ocid) {
        return this.getCharacterPetEquipment(ocid, null);
    }

    /**
     * 檢視已裝備寵物、寵物技能與寵物道具資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterPetEquipmentDTO> getCharacterPetEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPetEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視角色技能與超技能資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid                角色辨識器
     * @param characterSkillGrade 您要檢視的轉職階段 <a href="https://openapi.nexon.com/game/maplestorytw/?id=49">Available values</a>
     */
    public CompletableFuture<CharacterSkillDTO> getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade) {
        return this.getCharacterSkill(ocid, characterSkillGrade, null);
    }

    /**
     * 檢視角色技能與超技能資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid                角色辨識器
     * @param characterSkillGrade 您要檢視的轉職階段 <a href="https://openapi.nexon.com/game/maplestorytw/?id=49">Available values</a>
     * @param localDateTime       要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterSkillDTO> getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSkillDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視已裝備連結技能資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterLinkSkillDTO> getCharacterLinkSkill(@NonNull String ocid) {
        return this.getCharacterLinkSkill(ocid, null);
    }

    /**
     * 檢視已裝備連結技能資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterLinkSkillDTO> getCharacterLinkSkill(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterLinkSkillDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視 V 矩陣欄位資訊與已裝備 V 核心資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterVMatrixDTO> getCharacterVMatrix(@NonNull String ocid) {
        return this.getCharacterVMatrix(ocid, null);
    }

    /**
     * 檢視 V 矩陣欄位資訊與已裝備 V 核心資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterVMatrixDTO> getCharacterVMatrix(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterVMatrixDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視已裝備於 HEXA 矩陣的 HEXA 核心資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterHexaMatrixDTO> getCharacterHexaMatrix(@NonNull String ocid) {
        return this.getCharacterHexaMatrix(ocid, null);
    }

    /**
     * 檢視已裝備於 HEXA 矩陣的 HEXA 核心資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterHexaMatrixDTO> getCharacterHexaMatrix(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHexaMatrixDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視設定於 HEXA 矩陣中的 HEXA 屬性資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterHexaMatrixStatDTO> getCharacterHexaMatrixStat(@NonNull String ocid) {
        return this.getCharacterHexaMatrixStat(ocid, null);
    }

    /**
     * 檢視設定於 HEXA 矩陣中的 HEXA 屬性資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterHexaMatrixStatDTO> getCharacterHexaMatrixStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHexaMatrixStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視角色在武陵道場的最高紀錄資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<CharacterDojangDTO> getCharacterDojang(@NonNull String ocid) {
        return this.getCharacterDojang(ocid, null);
    }

    /**
     * 檢視角色在武陵道場的最高紀錄資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<CharacterDojangDTO> getCharacterDojang(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterDojangDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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

    //#region 檢視聯盟資訊

    /**
     * 檢視戰地等級與戰地階級資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<UnionDTO> getUnion(@NonNull String ocid) {
        return this.getUnion(ocid, null);
    }

    /**
     * 檢視戰地等級與戰地階級資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<UnionDTO> getUnion(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視詳細資訊，例如派遣至聯盟的攻擊單位成員效果，以及攻擊單位佔領效果。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<UnionRaiderDTO> getUnionRaider(@NonNull String ocid) {
        return this.getUnionRaider(ocid, null);
    }

    /**
     * 檢視詳細資訊，例如派遣至聯盟的攻擊單位成員效果，以及攻擊單位佔領效果。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<UnionRaiderDTO> getUnionRaider(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionRaiderDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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
     * 檢視戰地神器資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid 角色辨識器
     */
    public CompletableFuture<UnionArtifactDTO> getUnionArtifact(@NonNull String ocid) {
        return this.getUnionArtifact(ocid, null);
    }

    /**
     * 檢視戰地神器資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param ocid          角色辨識器
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<UnionArtifactDTO> getUnionArtifact(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionArtifactDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
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

    //#endregion

    //#region 檢視公會資訊

    /**
     * 檢視公會識別碼 (oguild_id) 資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param guildName 公會名稱
     * @param worldName 世界名稱 <a href="https://openapi.nexon.com/game/maplestorytw/?id=51">Available values</a>
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
     * 檢視公會基本資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param oGuildId 公會識別碼
     */
    public CompletableFuture<GuildBasicDTO> getGuildBasic(@NonNull String oGuildId) {
        return this.getGuildBasic(oGuildId, null);
    }

    /**
     * 檢視公會基本資訊。<br>
     * - 楓之谷遊戲資料平均在 15 分鐘後即可使用。<br>
     * - 您可以從 2025 年 10 月 15 日起搜尋資料。<br>
     * - 您可以輸入所需日期以搜尋過往資料。前一日的資料將於翌日凌晨 2:00 起提供。(當您搜尋 10 月 15 日的資料時，將會擷取從 15 日 00:00 到 16 日 00:00 的資料。)<br>
     * - 由於遊戲內容變動，OCID 可能會有所變更。在更新以 OCID 為基礎的服務時，請務必留意。<br>
     * - 此 API 提供來自楓之谷台灣的資料。<br>
     * @param oGuildId      公會識別碼
     * @param localDateTime 要搜尋的日期 (TST)
     */
    public CompletableFuture<GuildBasicDTO> getGuildBasic(@NonNull String oGuildId, LocalDateTime localDateTime) {
        final CompletableFuture<GuildBasicDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 10, 15))
                    : null;

            buildRetrofit()
                    .create(GuildApi.class)
                    .getGuildBasic(this.apiKey, oGuildId, date)
                    .enqueue(createCallback(future));
        } catch (Exception e) {
            future.completeExceptionally(e);
        }

        return future;
    }

    //#endregion
}
