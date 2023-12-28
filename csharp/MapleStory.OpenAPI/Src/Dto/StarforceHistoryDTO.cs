﻿using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 스타포스 히스토리
    /// </summary>
    public class StarforceHistoryDTO
    {
        /// <summary>
        /// 스타포스 히스토리 식별자
        /// </summary>
        [JsonProperty("id")]
        public string Id { get; set; }

        /// <summary>
        /// 강화 시도 결과
        /// </summary>
        [JsonProperty("item_upgrade_result")]
        public string ItemUpgradeResult { get; set; }

        /// <summary>
        /// 강화 시도 전 스타포스 수치
        /// </summary>
        [JsonProperty("before_starforce_count")]
        public int BeforeStarforceCount { get; set; }

        /// <summary>
        /// 강화 시도 후 스타포스 수치
        /// </summary>
        [JsonProperty("after_starforce_count")]
        public int AfterStarforceCount { get; set; }

        /// <summary>
        /// 스타 캐치
        /// </summary>
        [JsonProperty("starcatch_result")]
        public string StarCatchResult { get; set; }

        /// <summary>
        /// 슈페리얼 장비
        /// </summary>
        [JsonProperty("superior_item_flag")]
        public string SuperiorItemFlag { get; set; }

        /// <summary>
        /// 파괴 방지
        /// </summary>
        [JsonProperty("destroy_defence")]
        public string DestroyDefence { get; set; }

        /// <summary>
        /// 찬스 타임
        /// </summary>
        [JsonProperty("chance_time")]
        public string ChanceTime { get; set; }

        /// <summary>
        /// 파괴 방지 필드 이벤트
        /// </summary>
        [JsonProperty("event_field_flag")]
        public string EventFieldFlag { get; set; }

        /// <summary>
        /// 사용 주문서 명
        /// </summary>
        [JsonProperty("upgrade_item")]
        public string UpgradeItem { get; set; }

        /// <summary>
        /// 프로텍트 실드
        /// </summary>
        [JsonProperty("protect_shield")]
        public string ProtectShield { get; set; }

        /// <summary>
        /// 보너스 스탯 부여 아이템 여부
        /// </summary>
        [JsonProperty("bonus_stat_upgrade")]
        public string BonusStatUpgrade { get; set; }

        /// <summary>
        /// 캐릭터 명
        /// </summary>
        [JsonProperty("character_name")]
        public string CharacterName { get; set; }

        /// <summary>
        /// 월드 명
        /// </summary>
        [JsonProperty("world_name")]
        public string WorldName { get; set; }

        /// <summary>
        /// 대상 장비 아이템 명
        /// </summary>
        [JsonProperty("target_item")]
        public string TargetItem { get; set; }

        /// <summary>
        /// 강화 일시 (KST)
        /// </summary>
        [JsonProperty("date_create")]
        public DateTimeOffset DateCreate
        {
            get
            {
                return _dateCreate.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _dateCreate = value;
            }
        }

        private DateTimeOffset _dateCreate;

        /// <summary>
        /// 진행 중인 스타포스 강화 이벤트 정보
        /// </summary>
        [JsonProperty("starforce_event_list")]
        public List<StarforceEventDTO> StarforceEventList { get; set; }
    }
}
