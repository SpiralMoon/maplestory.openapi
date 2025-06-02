import dev.spiralmoon.maplestory.api.kms.MapleStoryApi;
import dev.spiralmoon.maplestory.api.kms.dto.character.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@DisplayName("캐릭터 정보 조회")
public class CharacterApi {

    private static final String apiKey = System.getProperty("API_KEY"); // Your API Key
    private static final MapleStoryApi api = new MapleStoryApi(apiKey);
    private static final String ocid = "e0a4f439e53c369866b55297d2f5f4eb";

    @Test
    @DisplayName("캐릭터 식별자(ocid) 조회")
    void getCharacter() throws IOException {
        String nickname = "아델";
        CharacterDTO response = api.getCharacter(nickname).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("캐릭터 목록 조회")
    void getCharacterList() throws IOException {
        CharacterListDTO response = api.getCharacterList().join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("기본 정보 조회")
    void getCharacterBasic() throws IOException {
        CharacterBasicDTO response = api.getCharacterBasic(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("외형 이미지 조회")
    void getCharacterImage() throws IOException {
        CharacterImageDTO response = api.getCharacterImage(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("인기도 정보 조회")
    void getCharacterPopularity() throws IOException {
        CharacterPopularityDTO response = api.getCharacterPopularity(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("종합 능력치 정보 조회")
    void getCharacterStat() throws IOException {
        CharacterStatDTO response = api.getCharacterStat(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("하이퍼스탯 정보 조회")
    void getCharacterHyperStat() throws IOException {
        CharacterHyperStatDTO response = api.getCharacterHyperStat(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("성향 정보 조회")
    void getCharacterPropensity() throws IOException {
        CharacterPropensityDTO response = api.getCharacterPropensity(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("어빌리티 정보 조회")
    void getCharacterAbility() throws IOException {
        CharacterAbilityDTO response = api.getCharacterAbility(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("장착 장비 정보 조회 (캐시 장비 제외)")
    void getCharacterItemEquipment() throws IOException {
        CharacterItemEquipmentDTO response = api.getCharacterItemEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("장착 캐시 장비 정보 조회")
    void getCharacterCashItemEquipment() throws IOException {
        CharacterCashItemEquipmentDTO response = api.getCharacterCashItemEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("장착 심볼 정보 조회")
    void getCharacterSymbolEquipment() throws IOException {
        CharacterSymbolEquipmentDTO response = api.getCharacterSymbolEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("적용 세트 효과 정보 조회")
    void getCharacterSetEffect() throws IOException {
        CharacterSetEffectDTO response = api.getCharacterSetEffect(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("장착 헤어, 성형, 피부 정보 조회")
    void getCharacterBeautyEquipment() throws IOException {
        CharacterBeautyEquipmentDTO response = api.getCharacterBeautyEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("장착 안드로이드 정보 조회")
    void getCharacterAndroidEquipment() throws IOException {
        CharacterAndroidEquipmentDTO response = api.getCharacterAndroidEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("장착 펫 정보 조회")
    void getCharacterPetEquipment() throws IOException {
        CharacterPetEquipmentDTO response = api.getCharacterPetEquipment(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("스킬 정보 조회")
    void getCharacterSkill() throws IOException {
        String skillGrade = "0";
        CharacterSkillDTO response = api.getCharacterSkill(ocid, skillGrade).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("장착 링크 스킬 정보 조회")
    void getCharacterLinkSkill() throws IOException {
        CharacterLinkSkillDTO response = api.getCharacterLinkSkill(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("V매트릭스 정보 조회")
    void getCharacterVMatrix() throws IOException {
        CharacterVMatrixDTO response = api.getCharacterVMatrix(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("HEXA 코어 정보 조회")
    void getCharacterHexaMatrix() throws IOException {
        CharacterHexaMatrixDTO response = api.getCharacterHexaMatrix(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("HEXA 매트릭스 설정 HEXA 스탯 정보 조회")
    void getCharacterHexaMatrixStat() throws IOException {
        CharacterHexaMatrixStatDTO response = api.getCharacterHexaMatrixStat(ocid).join();
        System.out.println(response.toString());
    }

    @Test
    @DisplayName("무릉도장 최고 기록 정보 조회")
    void getCharacterDojang() throws IOException {
        CharacterDojangDTO response = api.getCharacterDojang(ocid).join();
        System.out.println(response.toString());
    }
}
