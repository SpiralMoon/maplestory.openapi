package dev.spiralmoon.maplestory.api;

import lombok.NonNull;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Utils {

    public static ZonedDateTime toZonedDateTime(@NonNull String date) {
        final String[] patterns = {
                "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", // with millis + offset
                "yyyy-MM-dd'T'HH:mm:ss.SSS",    // with millis
                "yyyy-MM-dd'T'HH:mmXXX",        // without millis + offset
                "yyyy-MM-dd"                    // date only
        };

        ZonedDateTime dateTime = null;

        for (String pattern : patterns) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

                if (pattern.equals("yyyy-MM-dd")) {
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    dateTime =  localDate.atStartOfDay(ZoneId.systemDefault());
                } else {
                    OffsetDateTime offsetDateTime = OffsetDateTime.parse(date, formatter);
                    dateTime = offsetDateTime.toZonedDateTime();
                }
            } catch (DateTimeParseException e) {
                // Nothing to do
            }
        }

        return dateTime;
    }

    public static String removeQuery(String url) {
        if (url == null || url.isEmpty()) {
            return url;
        }

        int queryIndex = url.indexOf('?');
        return queryIndex >= 0 ? url.substring(0, queryIndex) : url;
    }
}
