﻿using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 세트 효과 정보
    /// </summary>
    public class CharacterSetEffectInfoDTO
    {
        /// <summary>
        /// 세트 효과 명
        /// </summary>
        [JsonProperty("set_name")]
        public string SetName { get; set; }

        /// <summary>
        /// 세트 개수 (럭키 아이템 포함)
        /// </summary>
        [JsonProperty("total_set_count")]
        public long TotalSetCount { get; set; }

        /// <summary>
        /// 적용 중인 세트 효과 정보
        /// </summary>
        [JsonProperty("set_effect_info")]
        public List<CharacterSetEffectInfoDTO> SetEffectInfo { get; set; }

        /// <summary>
        /// 모든 세트 효과 정보
        /// </summary>
        [JsonProperty("set_effect_full_info")]
        public List<CharacterSetEffectFullInfoDTO> SetEffectFullInfo { get; set; }
    }
}