package dev.spiralmoon.maplestory.api.common.enums;

public enum CharacterImageAction {
    Stand1("A00"),
    Stand2("A01"),
    Walk1("A02"),
    Walk2("A03"),
    Prone("A04"),
    Fly("A05"),
    Jump("A06"),
    Sit("A07"),
    Ladder("A08"),
    Rope("A09"),
    Heal("A10"),
    Alert("A11"),
    ProneStab("A12"),
    SwingO1("A13"),
    SwingO2("A14"),
    SwingO3("A15"),
    SwingOF("A16"),
    SwingP1("A17"),
    SwingP2("A18"),
    SwingPF("A19"),
    SwingT1("A20"),
    SwingT2("A21"),
    SwingT3("A22"),
    SwingTF("A23"),
    StabO1("A24"),
    StabO2("A25"),
    StabOF("A26"),
    StabT1("A27"),
    StabT2("A28"),
    StabTF("A29"),
    Shoot1("A30"),
    Shoot2("A31"),
    ShootF("A32"),
    Dead("A33"),
    GhostWalk("A34"),
    GhostStand("A35"),
    GhostJump("A36"),
    GhostProneStab("A37"),
    GhostLadder("A38"),
    GhostRope("A39"),
    GhostFly("A40"),
    GhostSit("A41");

    private final String action;

    CharacterImageAction(String action) {
        this.action = action;
    }

    public String getValue() {
        return action;
    }
}
