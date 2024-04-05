using Newtonsoft.Json;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 캐릭터 HEXA 코어 정보
    /// </summary>
    public class CharacterHexaMatrixDTO
    {
        /// <summary>
        /// 조회 기준일 (KST)
        /// </summary>
        [JsonProperty("date")]
        public DateTimeOffset? Date
        {
            get
            {
                return _date?.ToOffset(TimeSpan.FromHours(9));
            }
            set
            {
                _date = value;
            }
        }

        private DateTimeOffset? _date;

        /// <summary>
        /// HEXA 코어 정보
        /// </summary>
        [JsonProperty("character_hexa_core_equipment")]
        public List<CharacterHexaMatrixEquipmentDTO>? CharacterHexaCoreEquipment { get; set; }
    }
}
