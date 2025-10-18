package dev.spiralmoon.maplestory.api.tms.param;

import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;
import lombok.Data;

/**
 * 角色圖片產生選項
 */
@Data
public class CharacterImageOption implements dev.spiralmoon.maplestory.api.common.param.CharacterImageOption {

    /**
     * 角色動作
     */
    private CharacterImageAction action = CharacterImageAction.Stand1;

    /**
     * 角色表情
     */
    private CharacterImageEmotion emotion = CharacterImageEmotion.Default;

    /**
     * 角色武器動作
     */
    private CharacterImageWeaponMotion wmotion = CharacterImageWeaponMotion.Default;

    /**
     * 角色動作影格
     */
    private int actionFrame = 0;

    /**
     * 角色表情影格
     */
    private int emotionFrame = 0;

    /**
     * 寬度 (對應背景大小，96 (預設) 至 1000)
     */
    private Integer width = 96;

    /**
     * 高度 (對應背景大小，96 (預設) 至 1000)
     */
    private Integer height = 96;

    /**
     * 角色的水平座標 (座標範圍 0 < x < 寬度，0 對應至最左起點)
     */
    private Integer x;

    /**
     * 角色的垂直座標 (座標範圍 0 < y < 高度，0 對應至最上方起點)
     */
    private Integer y;
}
