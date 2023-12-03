using System.Xml.Linq;

namespace MapleStory.OpenAPI.Dto
{
    /// <summary>
    /// 서버 점검 정보
    /// </summary>
    public class InspectionInfoDTO
    {
        /// <summary>
        /// 서비스 코드
        /// </summary>
        public int ServiceCode;

        /// <summary>
        /// 점검 시작 시각
        /// </summary>
        public DateTimeOffset StartDateTime;

        /// <summary>
        /// 점검 종료 시각
        /// </summary>
        public DateTimeOffset EndDateTime;

        /// <summary>
        /// 점검 안내 제목
        /// </summary>
        public string StrObstacleContents;

        internal InspectionInfoDTO(string xml)
        {
            var document = XDocument.Parse(xml);
            var element = document.Descendants("InspectionInfo");

            this.ServiceCode = int.Parse(element.Descendants("serviceCode").First().Value);
            this.StartDateTime = DateTimeOffset.Parse(element.Descendants("startDateTime").First().Value);
            this.EndDateTime = DateTimeOffset.Parse(element.Descendants("endDateTime").First().Value);
            this.StrObstacleContents = element.Descendants("strObstacleContents").First().Value;
        }
    }
}
