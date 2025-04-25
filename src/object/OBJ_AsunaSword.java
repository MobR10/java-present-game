package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_AsunaSword extends Entity {
    GamePanel gp;
    public OBJ_AsunaSword(GamePanel gp){
        super(gp);
        type= type_asunaSword;
        name="Asuna Sword";
        description="["+name+"]\nSimte-o, te cheama,\neste sabia ta!";
        fall=setup("/objects/asunasword_fall",gp.tileSize,gp.tileSize);
        attackValue=15;

        attackArea.width=60;
        attackArea.height=40;
    }
}
