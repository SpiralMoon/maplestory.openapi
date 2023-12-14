package dev.spiralmoon.sample;

import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.MapleStoryApiException;
import dev.spiralmoon.maplestory.api.dto.CubeHistoryDTO;

import java.util.List;

class AsyncApiCallSample {
    public static void main(String[] args) {
        final String apiKey = "{Your API Key}";
        final MapleStoryApi api = new MapleStoryApi(apiKey);

        api.getCubeResultAsync(1000, 2023, 10, 15,
                (response) -> {
                    // run your code

                    final int count = response.getCount();
                    final List<CubeHistoryDTO> cubeHistory = response.getCubeHistory();
                    final String nextCursor = response.getNextCursor();

                    System.out.println("You used " + count + " cubes.");
                }, (throwable) -> {
                    // exception handling

                    if (throwable instanceof MapleStoryApiException) {
                        // handle MapleStoryApiException
                    } else {
                        // handle
                    }

                    throwable.printStackTrace();
                });
    }
}
