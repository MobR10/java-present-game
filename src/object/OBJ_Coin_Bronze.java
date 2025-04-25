package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Coin_Bronze extends Entity {
    public OBJ_Coin_Bronze(GamePanel gp) {
        super(gp);

        type=type_pickupOnly;
        name= "Bronze Coin";
        fall=setup("/objects/coin_bronze",gp.tileSize/2,gp.tileSize/2);
        value=1;
    }
    public void use(Entity entity){
        gp.playSoundEffect(12);
        gp.ui.addMessage("Coin +"+value);
        gp.player.coin+=value;
    }
}
