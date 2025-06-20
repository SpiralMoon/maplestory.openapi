package dev.spiralmoon.sample;

import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.common.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.kms.dto.history.CubeHistoryDTO;

import java.time.LocalDateTime;
import java.util.List;

class AsyncApiCallSample {
    public static void main(String[] args) {
        final String apiKey = "{Your API Key}";
        final MapleStoryApi api = new MapleStoryApi(apiKey);

        final LocalDateTime localDateTime = LocalDateTime.of(2023, 10, 15, 0, 0);

        api.getCubeHistory(1000, localDateTime)
                .thenAccept(response -> {
                    // run your code

                    final int count = response.getCount();
                    final List<CubeHistoryDTO> cubeHistory = response.getCubeHistory();
                    final String nextCursor = response.getNextCursor();

                    System.out.println("You used " + count + " cubes.");
                })
                .exceptionally(throwable -> {
                    // exception handling
                    if (throwable.getCause() instanceof MapleStoryApiException) {
                        // handle MapleStoryApiException
                    } else {
                        // handle
                    }

                    throwable.printStackTrace();
                    return null;
                });
    }
}
