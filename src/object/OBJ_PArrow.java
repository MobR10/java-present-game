package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

import java.awt.*;

public class OBJ_PArrow extends Projectile {

    public OBJ_PArrow(GamePanel gp) {
        super(gp);
        name="Fireball";
        speed=20;
        maxLife=35;
        life=maxLife;
        attack=2;
        useCost=1;
        alive=false;
        getImage();
        collisionArea.x=0;
        collisionArea.y=0;
        collisionArea.width=gp.tileSize-10;
        collisionArea.height=gp.tileSize/2;


    }
    public void getImage(){
        fall=setup("/projectile/arrow1_down",gp.tileSize,gp.tileSize);
        attackDown2=setup("/projectile/arrow2_down",gp.tileSize,gp.tileSize);
        left1=setup("/projectile/arrow1_left",gp.tileSize,gp.tileSize);
        left2=setup("/projectile/arrow2_left",gp.tileSize,gp.tileSize);
        right1=setup("/projectile/arrow1_right",gp.tileSize,gp.tileSize);
        right2=setup("/projectile/arrow2_right",gp.tileSize,gp.tileSize);

    }
    public boolean haveResource(Entity user){
        boolean haveResource=false;
        if(user.ammo >=useCost){
            haveResource=true;
        }
        return haveResource;
    }
    public void subtractResource(Entity user){
        user.ammo -=useCost;
    }
    public Color getParticleColor(){
        return new Color(126, 34, 34);
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
