package tile_interactive;

import entity.Entity;
import main.GamePanel;

public class IT_Trunk extends InteractiveTile{

    public IT_Trunk(GamePanel gp,int col,int row) {
        super(gp,col,row);

        this.worldX=gp.tileSize*col;
        this.worldY=gp.tileSize*row;

        fall=setup("/tiles_interactive/treeBody",gp.tileSize,gp.tileSize);
        destructible=false;

        collisionArea.x=0;
        collisionArea.y=0;
        collisionArea.width=0;
        collisionArea.height=0;
        collisionAreaDefaultX=collisionArea.x;
        collisionAreaDefaultY=collisionArea.y;
    }



}