package tile_interactive;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class InteractiveTile extends Entity {
    public boolean destructible=false;
    public InteractiveTile(GamePanel gp,int col,int row) {
        super(gp);

    }
    public boolean isCorrectItem(Entity entity){
        boolean isCorrectItem=false;
        return isCorrectItem;

    }
    public void playSoundEffect(){

    }
    public InteractiveTile getDestroyedForm(){
        InteractiveTile tile=null;
        return tile;
    }
    public void update(){
        if(invincible){
            invincibleCounter++;
            if(invincibleCounter>30){
                invincible=false;
                invincibleCounter=0;
            }
        }

    }
    public void changeAlpha(Graphics2D g2, float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
    }

}
