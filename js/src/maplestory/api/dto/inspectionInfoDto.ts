import { InspectionInfoSoapBody } from '@src/maplestory/api/response/inspectionInfoSoapBody';

/**
 * 서버 점검 정보
 */
class InspectionInfoDto {
  /**
   * 서비스 코드
   */
  serviceCode: number;

  /**
   * 점검 시작 시각
   */
  startDateTime: Date;

  /**
   * 점검 종료 시각
   */
  endDateTime: Date;

  /**
   * 점검 안내 제목
   */
  strObstacleContents: string;

  constructor(obj: InspectionInfoSoapBody) {
    const inspectionInfoTag =
      obj['soap:Envelope']['soap:Body'][0]['GetInspectionInfoResponse'][0][
        'GetInspectionInfoResult'
      ][0]['diffgr:diffgram'][0]['NewDataSet'][0]['InspectionInfo'][0];

    this.serviceCode = Number(inspectionInfoTag.serviceCode[0]);
    this.startDateTime = new Date(inspectionInfoTag.startDateTime[0]);
    this.endDateTime = new Date(inspectionInfoTag.endDateTime[0]);
    this.strObstacleContents = inspectionInfoTag.strObstacleContents[0];
  }
}

export { InspectionInfoDto };
