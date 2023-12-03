package dev.spiralmoon.maplestory.api.dto;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.ToString;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 서버 점검 정보
 */
@Data
@ToString
public class InspectionInfoDTO {


    /**
     * 서비스 코드
     */
    private int serviceCode;

    /**
     * 점검 시작 시각
     */
    private Date startDateTime;

    /**
     * 점검 종료 시각
     */
    private Date endDateTime;

    /**
     * 점검 안내 제목
     */
    private String strObstacleContents;

    @SneakyThrows
    public InspectionInfoDTO(String xml) {
        final Document document = Jsoup.parse(xml);
        final Element element = document.selectFirst("InspectionInfo");

        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

        this.serviceCode = Integer.parseInt(element.selectFirst("serviceCode").text());
        this.startDateTime = format.parse(element.selectFirst("startDateTime").text());
        this.endDateTime = format.parse(element.selectFirst("endDateTime").text());
        this.strObstacleContents = element.selectFirst("strObstacleContents").text();
    }
}
