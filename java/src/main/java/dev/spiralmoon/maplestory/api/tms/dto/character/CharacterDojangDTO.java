package dev.spiralmoon.maplestory.api.tms.dto.character;

import com.google.gson.annotations.SerializedName;
import dev.spiralmoon.maplestory.api.Utils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.time.ZonedDateTime;

/**
 * 角色在武陵道場的最高紀錄資訊
 */
@AllArgsConstructor
@Data
@ToString
public class CharacterDojangDTO implements dev.spiralmoon.maplestory.api.common.dto.character.CharacterDojangDTO {

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    @SerializedName("date")
    private String date;

    /**
     * 角色職業
     */
    @SerializedName("character_class")
    private String characterClass;

    /**
     * 世界名稱
     */
    @SerializedName("world_name")
    private String worldName;

    /**
     * 武陵道場最高紀錄層數
     */
    @SerializedName("dojang_best_floor")
    private Integer dojangBestFloor;

    /**
     * 達成武陵道場最高紀錄的日期 (TST，每日資料的小時與分鐘顯示為 0)
     */
    @SerializedName("date_dojang_record")
    private String dateDojangRecord;

    /**
     * 通關武陵道場最高樓層所花費的時間 (秒)
     */
    @SerializedName("dojang_best_time")
    private Integer dojangBestTime;

    /**
     * 要搜尋的日期 (TST，每日資料中的小時與分鐘將顯示為 0)
     */
    public ZonedDateTime getDate() {
        return date != null
                ? Utils.toZonedDateTime(this.date)
                : null;
    }

    /**
     * 達成武陵道場最高紀錄的日期 (TST，每日資料的小時與分鐘顯示為 0)
     */
    public ZonedDateTime getDateDojangRecord() {
        return dateDojangRecord != null ? Utils.toZonedDateTime(this.dateDojangRecord) : null;
    }
}
