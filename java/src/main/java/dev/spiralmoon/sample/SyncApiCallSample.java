package dev.spiralmoon.sample;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.dto.history.CubeHistoryDTO;
import dev.spiralmoon.maplestory.api.kms.dto.history.CubeHistoryResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CompletionException;

class SyncApiCallSample {
    public static void main(String[] args) {
        final String apiKey = "{Your API key}";
        final MapleStoryApi api = new MapleStoryApi(apiKey);

        final LocalDateTime localDateTime = LocalDateTime.of(2023, 10, 15, 0, 0);

        // run your code
        try {

            final CubeHistoryResponseDTO response = api.getCubeHistory(1000, localDateTime).join();

            final int count = response.getCount();
            final List<CubeHistoryDTO> cubeHistory = response.getCubeHistory();
            final String nextCursor = response.getNextCursor();

            System.out.println("You used " + count + " cubes.");
        }
        // exception handling
        catch (CompletionException exception) {
            if (exception.getCause() instanceof MapleStoryApiException) {
                // handle MapleStoryApiException
            } else {
                // handle
            }

            exception.printStackTrace();
        }
    }
}
