package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

import java.awt.*;

public class OBJ_BossProjectile extends Projectile {

    public OBJ_BossProjectile(GamePanel gp) {
        super(gp);
        name="Void Flame";
        speed=15;
        maxLife=40;
        life=maxLife;
        attack=15;
        useCost=1;
        alive=false;
        getImage();
        collisionArea.x=0;
        collisionArea.y=10;
        collisionArea.width=gp.tileSize-10;
        collisionArea.height=gp.tileSize/2-10;


    }
    public void getImage(){
        fall=setup("/projectile/p_boss_projectile",gp.tileSize,gp.tileSize);
        attackDown2=setup("/projectile/p_boss_projectile",gp.tileSize,gp.tileSize);
        left1=setup("/projectile/p_boss_projectile",gp.tileSize,gp.tileSize);
        left2=setup("/projectile/p_boss_projectile",gp.tileSize,gp.tileSize);
        right1=setup("/projectile/p_boss_projectile",gp.tileSize,gp.tileSize);
        right2=setup("/projectile/p_boss_projectile",gp.tileSize,gp.tileSize);

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
        return new Color(72, 50, 87);
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
