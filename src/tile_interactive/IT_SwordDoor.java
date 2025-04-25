package tile_interactive;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class IT_SwordDoor extends InteractiveTile{

    public IT_SwordDoor(GamePanel gp,int col,int row) {
        super(gp,col,row);

        this.worldX=gp.tileSize*col;
        this.worldY=gp.tileSize*row;

        fall=setup("/tiles_interactive/boss_door",gp.tileSize,gp.tileSize);
        destructible=true;
        life=5;

    }
    public boolean isCorrectItem(Entity entity){
        boolean isCorrectItem=false;
        if(entity.currentWeapon.type== type_rustySword&&gp.player.level>10){
            isCorrectItem=true;
        }
        return isCorrectItem;
    }
    public void playSoundEffect(){
        gp.playSoundEffect(13);

    }
    public InteractiveTile getDestroyedForm(){
        return null;
    }
    public Color getParticleColor(){
        return new Color(72, 56, 56);
    }
    public int getParticleSize(){
        return 6; // 6 pixels
    }
    public int getParticleSpeed(){
        return 2;
    }
    public int getParticleMaxLife(){
        return 20;
    }

}
