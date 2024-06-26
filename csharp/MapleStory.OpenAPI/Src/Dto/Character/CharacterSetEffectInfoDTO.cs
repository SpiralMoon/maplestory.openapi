﻿using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 적용 중인 세트 효과 정보
    /// </summary>
    public class CharacterSetEffectInfoDTO
    {
        /// <summary>
        /// 세트 효과 레벨 (장비 수)
        /// </summary>
        [JsonProperty("set_count")]
        public int SetCount { get; set; }

        /// <summary>
        /// 세트 효과
        /// </summary>
        [JsonProperty("set_option")]
        public string SetOption { get; set; }
    }
}
