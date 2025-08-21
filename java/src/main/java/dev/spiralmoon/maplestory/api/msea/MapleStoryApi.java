package dev.spiralmoon.maplestory.api.msea;

import dev.spiralmoon.maplestory.api.msea.dto.character.*;
import dev.spiralmoon.maplestory.api.msea.dto.guild.GuildBasicDTO;
import dev.spiralmoon.maplestory.api.msea.dto.guild.GuildDTO;
import dev.spiralmoon.maplestory.api.msea.dto.union.UnionArtifactDTO;
import dev.spiralmoon.maplestory.api.msea.dto.union.UnionDTO;
import dev.spiralmoon.maplestory.api.msea.dto.union.UnionRaiderDTO;
import dev.spiralmoon.maplestory.api.msea.template.*;
import dev.spiralmoon.maplestory.api.msea.param.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * MapleStory OpenAPI client for MSEA.<br>
 * This is an implementation of <a href="https://openapi.nexon.com/game/maplestorysea">MapleStory API</a>
 */
public class MapleStoryApi extends dev.spiralmoon.maplestory.api.common.MapleStoryApi {

    private static final String BASE_URL = "https://open.api.nexon.com/";

    // in milliseconds
    @Getter
    @Setter
    private long timeout;

    public MapleStoryApi(String apiKey) {
        super(apiKey);

        this.timezone = "Asia/Singapore";
        this.subUrl = "maplestorysea";
    }

    //#region Character Information Retrieval

    /**
     * Retrieves the character identifier (ocid).<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param characterName Character name
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
     * Retrieves basic character information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterBasicDTO> getCharacterBasic(@NonNull String ocid) {
        return this.getCharacterBasic(ocid, null);
    }

    /**
     * Retrieves basic character information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterBasicDTO> getCharacterBasic(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterBasicDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves character image information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid) {
        return this.getCharacterImage(ocid, new CharacterImageOption(), null);
    }

    /**
     * Retrieves character image information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid        Character identifier
     * @param imageOption Image options
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid, @NonNull CharacterImageOption imageOption) {
        return this.getCharacterImage(ocid, imageOption, null);
    }

    /**
     * Retrieves character image information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param imageOption   Image options
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterImageDTO> getCharacterImage(@NonNull String ocid, @NonNull CharacterImageOption imageOption, LocalDateTime localDateTime) {
        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves popularity information of a character.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterPopularityDTO> getCharacterPopularity(@NonNull String ocid) {
        return this.getCharacterPopularity(ocid, null);
    }

    /**
     * Retrieves popularity information of a character.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterPopularityDTO> getCharacterPopularity(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPopularityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves comprehensive character stats information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterStatDTO> getCharacterStat(@NonNull String ocid) {
        return this.getCharacterStat(ocid, null);
    }

    /**
     * Retrieves comprehensive character stats information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterStatDTO> getCharacterStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves Hyper Stat information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterHyperStatDTO> getCharacterHyperStat(@NonNull String ocid) {
        return this.getCharacterHyperStat(ocid, null);
    }

    /**
     * Retrieves Hyper Stat information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterHyperStatDTO> getCharacterHyperStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHyperStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves traits information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterPropensityDTO> getCharacterPropensity(@NonNull String ocid) {
        return this.getCharacterPropensity(ocid, null);
    }

    /**
     * Retrieves traits information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterPropensityDTO> getCharacterPropensity(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPropensityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves Ability information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterAbilityDTO> getCharacterAbility(@NonNull String ocid) {
        return getCharacterAbility(ocid, null);
    }

    /**
     * Retrieves Ability information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterAbilityDTO> getCharacterAbility(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterAbilityDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about equipped equipment, excluding cash items.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterItemEquipmentDTO> getCharacterItemEquipment(@NonNull String ocid) {
        return this.getCharacterItemEquipment(ocid, null);
    }

    /**
     * Retrieves information about equipped equipment, excluding cash items.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterItemEquipmentDTO> getCharacterItemEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterItemEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves equipped cash item information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterCashItemEquipmentDTO> getCharacterCashItemEquipment(@NonNull String ocid) {
        return this.getCharacterCashItemEquipment(ocid, null);
    }

    /**
     * Retrieves equipped cash item information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterCashItemEquipmentDTO> getCharacterCashItemEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterCashItemEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about equipped symbols.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterSymbolEquipmentDTO> getCharacterSymbolEquipment(@NonNull String ocid) {
        return this.getCharacterSymbolEquipment(ocid, null);
    }

    /**
     * Retrieves information about equipped symbols.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterSymbolEquipmentDTO> getCharacterSymbolEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSymbolEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about equipped set item effects.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterSetEffectDTO> getCharacterSetEffect(@NonNull String ocid) {
        return this.getCharacterSetEffect(ocid, null);
    }

    /**
     * Retrieves information about equipped set item effects.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterSetEffectDTO> getCharacterSetEffect(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSetEffectDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about equipped hair, face, and skin.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterBeautyEquipmentDTO> getCharacterBeautyEquipment(@NonNull String ocid) {
        return this.getCharacterBeautyEquipment(ocid, null);
    }

    /**
     * Retrieves information about equipped hair, face, and skin.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterBeautyEquipmentDTO> getCharacterBeautyEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterBeautyEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves equipped android information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterAndroidEquipmentDTO> getCharacterAndroidEquipment(@NonNull String ocid) {
        return getCharacterAndroidEquipment(ocid, null);
    }

    /**
     * Retrieves equipped android information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterAndroidEquipmentDTO> getCharacterAndroidEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterAndroidEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about equipped pets, including pet skills and equipment.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterPetEquipmentDTO> getCharacterPetEquipment(@NonNull String ocid) {
        return this.getCharacterPetEquipment(ocid, null);
    }

    /**
     * Retrieves information about equipped pets, including pet skills and equipment.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterPetEquipmentDTO> getCharacterPetEquipment(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterPetEquipmentDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about character skills and Hyper Skills.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid                Character identifier
     * @param characterSkillGrade Job advancement tier to query <a href="https://openapi.nexon.com/game/maplestorysea/?id=45">Available values</a>
     */
    public CompletableFuture<CharacterSkillDTO> getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade) {
        return this.getCharacterSkill(ocid, characterSkillGrade, null);
    }

    /**
     * Retrieves information about character skills and Hyper Skills.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param characterSkillGrade Job advancement tier to query <a href="https://openapi.nexon.com/game/maplestorysea/?id=45">Available values</a>
     * @param localDateTime       Reference date for query (SGT)
     */
    public CompletableFuture<CharacterSkillDTO> getCharacterSkill(@NonNull String ocid, @NonNull String characterSkillGrade, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterSkillDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about equipped Link Skills.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterLinkSkillDTO> getCharacterLinkSkill(@NonNull String ocid) {
        return this.getCharacterLinkSkill(ocid, null);
    }

    /**
     * Retrieves information about equipped Link Skills.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterLinkSkillDTO> getCharacterLinkSkill(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterLinkSkillDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves V Matrix slot and equipped Node information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterVMatrixDTO> getCharacterVMatrix(@NonNull String ocid) {
        return this.getCharacterVMatrix(ocid, null);
    }

    /**
     * Retrieves V Matrix slot and equipped Node information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterVMatrixDTO> getCharacterVMatrix(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterVMatrixDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about HEXA Nodes equipped in the HEXA Matrix.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterHexaMatrixDTO> getCharacterHexaMatrix(@NonNull String ocid) {
        return this.getCharacterHexaMatrix(ocid, null);
    }

    /**
     * Retrieves information about HEXA Nodes equipped in the HEXA Matrix.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterHexaMatrixDTO> getCharacterHexaMatrix(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHexaMatrixDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves information about HEXA stats configured in the HEXA Matrix.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterHexaMatrixStatDTO> getCharacterHexaMatrixStat(@NonNull String ocid) {
        return this.getCharacterHexaMatrixStat(ocid, null);
    }

    /**
     * Retrieves information about HEXA stats configured in the HEXA Matrix.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterHexaMatrixStatDTO> getCharacterHexaMatrixStat(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterHexaMatrixStatDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves the character's highest record information in Mu Lung Garden.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<CharacterDojangDTO> getCharacterDojang(@NonNull String ocid) {
        return this.getCharacterDojang(ocid, null);
    }

    /**
     * Retrieves the character's highest record information in Mu Lung Garden.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<CharacterDojangDTO> getCharacterDojang(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<CharacterDojangDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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

    //#region Union Information Retrieval

    /**
     * Retrieves Union level and Union rank information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<UnionDTO> getUnion(@NonNull String ocid) {
        return this.getUnion(ocid, null);
    }

    /**
     * Retrieves Union level and Union rank information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<UnionDTO> getUnion(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves detailed information about raid member effects and capture effects deployed in the Union.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<UnionRaiderDTO> getUnionRaider(@NonNull String ocid) {
        return this.getUnionRaider(ocid, null);
    }

    /**
     * Retrieves detailed information about raid member effects and capture effects deployed in the Union.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<UnionRaiderDTO> getUnionRaider(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionRaiderDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
     * Retrieves Union Artifact information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid Character identifier
     */
    public CompletableFuture<UnionArtifactDTO> getUnionArtifact(@NonNull String ocid) {
        return this.getUnionArtifact(ocid, null);
    }

    /**
     * Retrieves Union Artifact information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param ocid          Character identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<UnionArtifactDTO> getUnionArtifact(@NonNull String ocid, LocalDateTime localDateTime) {
        final CompletableFuture<UnionArtifactDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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

    //#region Guild Information Retrieval

    /**
     * Retrieves information for the guild identifier (oguild_id).<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param guildName Guild name
     * @param worldName World name <a href="https://openapi.nexon.com/game/maplestorysea/?id=47">Available values</a>
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
     * Retrieves guild basic information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param oGuildId Guild identifier
     */
    public CompletableFuture<GuildBasicDTO> getGuildBasic(@NonNull String oGuildId) {
        return this.getGuildBasic(oGuildId, null);
    }

    /**
     * Retrieves guild basic information.<br>
     * - MapleStory game data can be verified approximately 15 minutes after updates.<br>
     * - Data is available starting from April 20, 2025.<br>
     * - Historical data can be queried by specifying the desired date, and data from the previous day can be accessed starting at 2 AM the next day. (For example, when querying data for December 22, data from 00:00 to 24:00 on December 22 will be retrieved.)<br>
     * - Due to game content changes, the ocid may be updated. Please pay attention to this when updating services based on ocid.<br>
     * - This API provides data for MapleStory SEA.<br>
     * @param oGuildId      Guild identifier
     * @param localDateTime Reference date for query (SGT)
     */
    public CompletableFuture<GuildBasicDTO> getGuildBasic(@NonNull String oGuildId, LocalDateTime localDateTime) {
        final CompletableFuture<GuildBasicDTO> future = new CompletableFuture<>();

        try {
            final String date = localDateTime != null
                    ? toDateString(localDateTime, minDate(2025, 4, 20))
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
