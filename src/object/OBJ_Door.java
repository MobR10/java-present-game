package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Door extends Entity {

    public OBJ_Door(GamePanel gp){
        super(gp);

        name="Door";
        fall=setup("/objects/door",gp.tileSize,gp.tileSize);
        collision=true;
    }
}
