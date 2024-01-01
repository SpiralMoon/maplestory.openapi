package dev.spiralmoon.maplestory.api;

import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utils {

    public static LocalDateTime toLocalDateTime(@NonNull String date) {

        final String[] patterns = {
                "yyyy-MM-dd'T'HH:mm:ss.SSSX",
                "yyyy-MM-dd'T'HH:mmXXX",
                "yyyy-MM-dd"
        };

        LocalDateTime kstDateTime = null;

        for (String pattern : patterns) {
            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

                if (pattern.equals("yyyy-MM-dd")) {
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    kstDateTime = localDate.atStartOfDay().atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime();
                } else {
                    kstDateTime = LocalDateTime.parse(date, formatter).atZone(ZoneId.of("Asia/Seoul")).toLocalDateTime();
                }

                break;
            } catch (DateTimeParseException e) {
                // nothing to do
            }
        }

        return kstDateTime;
    }
}
