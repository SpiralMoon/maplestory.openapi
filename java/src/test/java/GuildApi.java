import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.dto.guild.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("길드 정보 조회")
public class GuildApi {

    private static final String apiKey = System.getProperty("API_KEY"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ogid = "f5992063d46d6f8718e514fca5428960";

    @Test
    @DisplayName("길드 식별자(oguild_id) 정보 조회")
    void getGuild() throws IOException {
        String guildName = "붕붕";
        String worldName = "크로아";
        GuildDTO response = api.getGuild(guildName, worldName).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("기본 정보 조회")
    void getGuildBasic() throws IOException {
        GuildBasicDTO response = api.getGuildBasic(ogid).join();
        System.out.println(response.toString());
    }
}
