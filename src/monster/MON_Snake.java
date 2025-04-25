package monster;

import entity.Entity;
import main.GamePanel;
import object.*;

import java.awt.*;
import java.util.Random;

public class MON_Snake extends Entity {
    public MON_Snake(GamePanel gp) {
        super(gp);
        type=type_monster;
        name="Snake";
        speed=3;
        maxLife=5;
        life=maxLife;
        attack=2;
        defense=1;
        exp=20;

        direction="fall";

        collisionArea.x=10;
        collisionArea.y=0;
        collisionArea.width=64;
        collisionArea.height=64;
        collisionAreaDefaultX=collisionArea.x;
        collisionAreaDefaultY=collisionArea.y;
        getImage();
    }
    public void getImage(){
        // jump = setup("/monster/greenslime_down_2",gp.tileSize,gp.tileSize);
        fall = setup("/monster/m_snake_idle",gp.tileSize,gp.tileSize);
        idle1 = setup("/monster/m_snake_idle",gp.tileSize,gp.tileSize);
        left1 = setup("/monster/m_snake_left1",gp.tileSize,gp.tileSize);
        left2 = setup("/monster/m_snake_left2",gp.tileSize,gp.tileSize);
        right1 = setup("/monster/m_snake_right1",gp.tileSize,gp.tileSize);
        right2 = setup("/monster/m_snake_right2",gp.tileSize,gp.tileSize);

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
            dropItem(new OBJ_Arrow(gp));
        }
        if(i>=50&&i<75){
            dropItem(new OBJ_Heart(gp));
        }
        if(i>=75&&i<100){
            dropItem(new OBJ_Arrow(gp));
        }
    }
    public Color getParticleColor(){
        return new Color(187, 57, 57);
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
