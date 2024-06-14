import dev.spiralmoon.maplestory.api.MapleStoryApi;
import dev.spiralmoon.maplestory.api.dto.union.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("유니온 정보 조회")
public class UnionApi {

    private static final String apiKey = System.getProperty("API_KEY"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("유니온 정보 조회")
    void getUnion() throws IOException {
        UnionDTO response = api.getUnion(ocid);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("유니온 공격대 정보 조회")
    void getUnionRaider() throws IOException {
        UnionRaiderDTO response = api.getUnionRaider(ocid);
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("유니온 아티팩트 정보 조회")
    void getUnionArtifact() throws IOException {
        UnionArtifactDTO response = api.getUnionArtifact(ocid);
        System.out.println(response.toString());
    }
}
