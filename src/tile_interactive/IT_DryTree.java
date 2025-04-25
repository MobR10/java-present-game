package tile_interactive;

import entity.Entity;
import main.GamePanel;

import java.awt.*;

public class IT_DryTree extends InteractiveTile{

    public IT_DryTree(GamePanel gp,int col,int row) {
        super(gp,col,row);

        this.worldX=gp.tileSize*col;
        this.worldY=gp.tileSize*row;

        fall=setup("/tiles_interactive/treeRoot",gp.tileSize,gp.tileSize);
        destructible=false;
        life=3;

    }
    public boolean isCorrectItem(Entity entity){
        boolean isCorrectItem=false;
        if(entity.currentWeapon.type== type_asunaSword){
            isCorrectItem=true;
        }
        return isCorrectItem;
    }
    public void playSoundEffect(){
        gp.playSoundEffect(13);

    }
    public InteractiveTile getDestroyedForm(){
        InteractiveTile tile=new IT_Trunk(gp,worldX/ gp.tileSize,worldY/gp.tileSize);
        return tile;
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
