package dev.spiralmoon.maplestory.api.common.param;

import dev.spiralmoon.maplestory.api.common.enums.CharacterImageAction;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageEmotion;
import dev.spiralmoon.maplestory.api.common.enums.CharacterImageWeaponMotion;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CharacterImageOption {

    /**
     * Character action
     */
    private CharacterImageAction action = CharacterImageAction.Stand1;

    /**
     * Character emotion
     */
    private CharacterImageEmotion emotion = CharacterImageEmotion.Default;

    /**
     * Character weapon motion
     */
    private CharacterImageWeaponMotion wmotion = CharacterImageWeaponMotion.Default;

    /**
     * Character action frame
     */
    private int actionFrame = 0;

    /**
     * Character emotion frame
     */
    private int emotionFrame = 0;

    /**
     * Horizontal length (corresponding to the background size, 96 (default) ~ 1000)
     */
    private Integer width = 96;

    /**
     * Vertical length (corresponding to the background size, 96 (default) ~ 1000)
     */
    private Integer height = 96;

    /**
     * Horizontal coordinate of the character (coordinate range 0 < x < width, 0 is the left starting point)
     */
    private Integer x;

    /**
     * Vertical coordinate of the character (coordinate range 0 < y < height, 0 is the top starting point)
     */
    private Integer y;
}
