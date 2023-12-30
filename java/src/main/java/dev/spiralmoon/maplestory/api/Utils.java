package dev.spiralmoon.maplestory.api;

import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class Utils {

    public static LocalDateTime toLocalDateTime(@NonNull String date) {

        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mmXXX");

        try {
            return LocalDateTime.parse(date, formatter1);
        }
        catch (Exception e) {
            return LocalDateTime.parse(date, formatter2);
        }
    }
}
