package object;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class OBJ_Heart extends Entity {
    public OBJ_Heart(GamePanel gp){
        super(gp);
        type=type_pickupOnly;
        name="Heart";
        value=2;
        fall=setup("/objects/heart_full",gp.tileSize/2,gp.tileSize/2);
        image=setup("/objects/heart_full",gp.tileSize/2,gp.tileSize/2);
        image2=setup("/objects/heart_half",gp.tileSize/2,gp.tileSize/2);
        image3=setup("/objects/heart_blank",gp.tileSize/2,gp.tileSize/2);

    }
    public void use(Entity entity){
        gp.playSoundEffect(12);
        gp.ui.addMessage("HP +"+value);
        entity.life+=value;
    }

}
