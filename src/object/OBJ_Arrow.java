package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Arrow extends Entity {
    public OBJ_Arrow(GamePanel gp) {
        super(gp);
        type=type_pickupOnly;
        name="Arrow";
        value=1;
        fall=setup("/objects/arrow_ammo",gp.tileSize,gp.tileSize);
        image=setup("/objects/arrow_ammo",gp.tileSize,gp.tileSize);
        image2=setup("/objects/arrow_no_ammo",gp.tileSize,gp.tileSize);
    }
    public void use(Entity entity){
        gp.playSoundEffect(12);
        gp.ui.addMessage("Arrow +"+value);
        entity.ammo +=value;
    }
}
