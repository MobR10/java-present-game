package entity;

import main.GamePanel;

public class Projectile extends Entity{
    Entity user;
    public Projectile(GamePanel gp) {
        super(gp);

    }

    public void set(int worldX,int worldY,String direction,boolean alive
    ,Entity user){
        this.worldX=worldX+2;
        this.worldY=worldY;
        this.direction=direction;
        this.alive=alive;
        this.user=user;
        this.life=this.maxLife;

    }
    public void update(){
        if(user==gp.player){
            int monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
            bottomCollision=false;
            collisionOn=false;
            gp.cChecker.tileCollision(this);
            gp.cChecker.isBottomCollision(this);
            gp.cChecker.checkEntity(this,gp.iTile);
            if(monsterIndex!=999){
                gp.player.damageMonster(monsterIndex,attack);
                generateParticle(user.projectile,gp.monster[monsterIndex]);
                alive=false;
            }else if(collisionOn){
                alive=false;
            }else if(bottomCollision){
                alive=false;
            }

        }
        if(user!=gp.player){
        boolean contactPlayer=gp.cChecker.checkPlayer(this);
            bottomCollision=false;
            collisionOn=false;
            gp.cChecker.tileCollision(this);
            gp.cChecker.isBottomCollision(this);
            gp.cChecker.checkEntity(this,gp.iTile);
            gp.cChecker.checkObject(this,false);
        if(!gp.player.invincible&&contactPlayer){
            damagePlayer(attack);
            generateParticle(user.projectile,gp.player);
            alive=false;
        }else if(collisionOn){
            alive=false;
        }else if(bottomCollision){
            alive=false;
        }
        }
        switch (direction){
            case "fall": worldY+=speed; break;
            case "left": worldX-=speed; break;
            case "right": worldX+=speed; break;
        }
        life--;
        if(life<=0){
            alive=false;
        }

        spriteCounter++;
        if(spriteCounter>15){
            if(spriteNum==1){
                spriteNum=2;
            }else if(spriteNum==2){
                spriteNum=1;
            }
            spriteCounter=0;
        }
    }

    public boolean haveResource(Entity user){return false;}
    public void subtractResource(Entity user){}

}
