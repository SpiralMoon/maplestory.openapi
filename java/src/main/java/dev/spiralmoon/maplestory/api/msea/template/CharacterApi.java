package dev.spiralmoon.maplestory.api.msea.template;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CharacterApi {

    @GET("maplestorysea/v1/id")
    Call<ResponseBody> getCharacter(@Header("x-nxopen-api-key") String apiKey, @Query("character_name") String characterName);

    @GET("maplestorysea/v1/character/basic")
    Call<ResponseBody> getCharacterBasic(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/popularity")
    Call<ResponseBody> getCharacterPopularity(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/stat")
    Call<ResponseBody> getCharacterStat(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/hyper-stat")
    Call<ResponseBody> getCharacterHyperStat(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/propensity")
    Call<ResponseBody> getCharacterPropensity(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/ability")
    Call<ResponseBody> getCharacterAbility(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/item-equipment")
    Call<ResponseBody> getCharacterItemEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/cashitem-equipment")
    Call<ResponseBody> getCharacterCashItemEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/symbol-equipment")
    Call<ResponseBody> getCharacterSymbolEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/set-effect")
    Call<ResponseBody> getCharacterSetEffect(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/beauty-equipment")
    Call<ResponseBody> getCharacterBeautyEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/android-equipment")
    Call<ResponseBody> getCharacterAndroidEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/pet-equipment")
    Call<ResponseBody> getCharacterPetEquipment(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/skill")
    Call<ResponseBody> getCharacterSkill(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date, @Query("character_skill_grade") String characterSkillGrade);

    @GET("maplestorysea/v1/character/link-skill")
    Call<ResponseBody> getCharacterLinkSkill(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/vmatrix")
    Call<ResponseBody> getCharacterVMatrix(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/hexamatrix")
    Call<ResponseBody> getCharacterHexaMatrix(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/hexamatrix-stat")
    Call<ResponseBody> getCharacterHexaMatrixStat(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);

    @GET("maplestorysea/v1/character/dojang")
    Call<ResponseBody> getCharacterDojang(@Header("x-nxopen-api-key") String apiKey, @Query("ocid") String ocid, @Query("date") String date);
}
