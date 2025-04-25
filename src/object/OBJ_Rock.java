package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

import java.awt.*;

public class OBJ_Rock extends Projectile {

    public OBJ_Rock(GamePanel gp) {
        super(gp);
        name="Rock";
        speed=8;
        maxLife=50;
        life=maxLife;
        attack=10;
        useCost=1;
        alive=false;
        getImage();
        collisionArea.x=0;
        collisionArea.y=10;
        collisionArea.width=gp.tileSize-10;
        collisionArea.height=gp.tileSize/2-10;


    }
    public void getImage(){
        fall=setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        attackDown2=setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        left1=setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        left2=setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        right1=setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);
        right2=setup("/projectile/rock_down_1",gp.tileSize,gp.tileSize);

    }
    public boolean haveResource(Entity user){
        boolean haveResource=false;
        if(user.ammo>=useCost){
            haveResource=true;
        }
        return haveResource;
    }
    public void subtractResource(Entity user){
        user.ammo-=useCost;
    }
    public Color getParticleColor(){
        return new Color(75, 54, 54);
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
