package monster;

import entity.Entity;
import main.GamePanel;
import object.*;

import java.awt.*;
import java.util.Random;

public class MON_Boss extends Entity {
    public MON_Boss(GamePanel gp) {
        super(gp);
        type=type_monster;
        name="Boss";
        speed=1;
        maxLife=3000;
        life=maxLife;
        attack=20;
        defense=10;
        exp=0;
        projectile=new OBJ_BossProjectile(gp);

        direction="fall";

        collisionArea.x=10;
        collisionArea.y=0;
        collisionArea.width=54;
        collisionArea.height=64;
        collisionAreaDefaultX=collisionArea.x;
        collisionAreaDefaultY=collisionArea.y;
        getImage();
    }
    public void getImage(){
        // jump = setup("/monster/greenslime_down_2",gp.tileSize,gp.tileSize);
        fall = setup("/monster/m_boss_idle",gp.tileSize,gp.tileSize);
        idle1 = setup("/monster/m_boss_idle",gp.tileSize,gp.tileSize);
        left1 = setup("/monster/m_boss_left",gp.tileSize,gp.tileSize);
        left2 = setup("/monster/m_boss_left",gp.tileSize,gp.tileSize);
        right1 = setup("/monster/m_boss_right",gp.tileSize,gp.tileSize);
        right2 = setup("/monster/m_boss_right",gp.tileSize,gp.tileSize);

    }
    public void setAction(){
        if(!dying){
            actionLockCounter++;
            if(actionLockCounter==120){
                Random random=new Random();
                int i=random.nextInt(100)+1; // pick up a number from 1 to 100
                if(i<=25){
                    direction="idle";
                }
                if(i>25&&i<=50){
                    direction="right";
                }
                if(i>50){
                    direction="left";
                }
                actionLockCounter=0;
            }
            int i=new Random().nextInt(100)+1;
            if(i>99&&!projectile.alive&&shotAvailableCounter==30){
                projectile.set(worldX,worldY,direction,true,this);
                gp.projectileList.add(projectile);
                shotAvailableCounter=0;
            }
        }

    }
    public void damageReaction(){
        actionLockCounter=0;
        if(gp.player.direction.equals("fall")){
            Random rand=new Random();
            int i=rand.nextInt(100)+1;
            if(i<=50){
                direction="left";
            }
            if(i>50){
                direction="right";
            }
        }else{
            if(gp.player.attackDirection.equals("left")){
                direction="right";
            }
            if(gp.player.attackDirection.equals("right")){
                direction="left";
            }
        }
    }
    public void checkDrop(){
        // CAT A DICE
        int i=new Random().nextInt(100)+1;

        // SET THE MONSTER DROP
        if(i<50){
            //dropItem(new OBJ_Potion_Red(gp));
        }
        if(i>=50&&i<75){
           // dropItem(new OBJ_Heart(gp));
        }
        if(i>=75&&i<100){
            //dropItem(new OBJ_Arrow(gp));
        }
    }
    public Color getParticleColor(){
        return new Color(206, 69, 195);
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
