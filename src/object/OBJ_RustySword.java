package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_RustySword extends Entity {
    public OBJ_RustySword(GamePanel gp) {
        super(gp);
        type= type_rustySword;
        name="Rusty Sword";
        fall=setup("/objects/rustysword_fall",gp.tileSize,gp.tileSize);
        attackValue=1;
        description="["+name+"]\nIigh, sabie de noobi";
        attackArea.x=0;
        attackArea.width=60;
        attackArea.height=40;
    }
}
