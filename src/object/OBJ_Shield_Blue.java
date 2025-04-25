package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Shield_Blue extends Entity {

    public OBJ_Shield_Blue(GamePanel gp) {
        super(gp);
        type=type_shield;
        name="Blue Shield";
        description="["+name+"]\nIt's a blue shield, who would\n have thought?";
        fall=setup("/objects/shield_blue",gp.tileSize,gp.tileSize);
        defenseValue=2;
    }
}
