package dev.spiralmoon.maplestory.api.template;

import dev.spiralmoon.maplestory.api.dto.character.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CharacterApi {

    @GET("maplestory/v1/id")
    Call<CharacterDTO> getCharacter(@Header("x-nxopen-api-key") String apiKey, @Query("character_name") String characterName);

    @GET("maplestory/v1/character/list")
    Call<CharacterListDTO> getCharacterList(@Header("x-nxopen-api-key") String apiKey);

    @GET("maplestory/v1/character/basic")
    Call<CharacterBasicDTO> getCharacterBasic(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/popularity")
    Call<CharacterPopularityDTO> getCharacterPopularity(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/stat")
    Call<CharacterStatDTO> getCharacterStat(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/hyper-stat")
    Call<CharacterHyperStatDTO> getCharacterHyperStat(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/propensity")
    Call<CharacterPropensityDTO> getCharacterPropensity(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/ability")
    Call<CharacterAbilityDTO> getCharacterAbility(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/item-equipment")
    Call<CharacterItemEquipmentDTO> getCharacterItemEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/cashitem-equipment")
    Call<CharacterCashItemEquipmentDTO> getCharacterCashItemEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/symbol-equipment")
    Call<CharacterSymbolEquipmentDTO> getCharacterSymbolEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/set-effect")
    Call<CharacterSetEffectDTO> getCharacterSetEffect(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/beauty-equipment")
    Call<CharacterBeautyEquipmentDTO> getCharacterBeautyEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/android-equipment")
    Call<CharacterAndroidEquipmentDTO> getCharacterAndroidEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/pet-equipment")
    Call<CharacterPetEquipmentDTO> getCharacterPetEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/skill")
    Call<CharacterSkillDTO> getCharacterSkill(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date, @Query("character_skill_grade") String characterSkillGrade);

    @GET("maplestory/v1/character/link-skill")
    Call<CharacterLinkSkillDTO> getCharacterLinkSkill(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/vmatrix")
    Call<CharacterVMatrixDTO> getCharacterVMatrix(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/hexamatrix")
    Call<CharacterHexaMatrixDTO> getCharacterHexaMatrix(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/hexamatrix-stat")
    Call<CharacterHexaMatrixStatDTO> getCharacterHexaMatrixStat(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestory/v1/character/dojang")
    Call<CharacterDojangDTO> getCharacterDojang(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);
}
