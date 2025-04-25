package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Entity {

    protected GamePanel gp;
    public BufferedImage idle1,idle2,jump,fall,left1,left2,right1,right2;
    public BufferedImage attackUp1,attackUp2,attackDown1,attackDown2,
    attackLeft1,attackLeft2,attackRight1,attackRight2;
    public BufferedImage image,image2,image3;
    public Rectangle collisionArea;
    public Rectangle attackArea=new Rectangle(0,0,0,0);
    public int collisionAreaDefaultX, collisionAreaDefaultY;
    public boolean collision=false;
    String[] dialogue=new String[20];
    // STATE
    public int worldX,worldY;
    public String direction="fall",attackDirection;
    public int spriteNum=1;
    int dialogueIndex=0;
    public boolean collisionOn=false,topCollision,bottomCollision;
    public boolean invincible=false;
    public boolean attacking=false;
    public boolean alive=true, dying=false;
    public boolean hpBarOn=false;
    ///
    public float dy=0f;
    public boolean falling=true,jumping=true;
    public float gravity=0.5f;

    // COUNTER
    public int spriteCounter=0,attackSpriteCounter=0,idleSpriteCounter=0;
    public int actionLockCounter=0;
    public int invincibleCounter=0;
    int dyingCounter=0;
    int hpBarCounter=0;
    public int shotAvailableCounter;

    // CHARACTER ATTRIBUTES
    public String name;
    public int speed;
    public int maxLife;
    public int maxAmmo;
    public int ammo;
    public int life;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public Entity currentWeapon;
    public Entity currentShield;
    public Projectile projectile;

    // ITEM ATTRIBUTES
    public int value;
    public int attackValue;
    public int defenseValue;
    public String description="";
    public int useCost;

    // TYPE
    public int type; // 0= player, 1=npc, 2=monster
    public final int type_player=0;
    public final int type_npc=1;
    public final int type_monster=2;
    public final int type_rustySword =3;
    public final int type_asunaSword =4;
    public final int type_shield=5;
    public final int type_consumable=6;
    public final int type_pickupOnly=7;

    public Entity(GamePanel gp){
        this.gp=gp;
        this.collisionArea= new Rectangle(5,0,gp.tileSize-8,gp.tileSize);
    }

    public void setAction(){}
    public void damageReaction(){}
    public void speak(){
        if(dialogue[dialogueIndex]==null){
            dialogueIndex=0;
        }

        gp.ui.currentDialogue=dialogue[dialogueIndex];
        dialogueIndex++;

        switch (gp.player.direction){
            case "left":
                direction="right";
                gp.player.direction="idle";
                break;
            case "right":
                direction="left";
                gp.player.direction="idle";
                break;
        }


    }
    public void use (Entity entity){}
    public void checkDrop(){}
    public void dropItem(Entity droppedItem){
        for(int i=0;i<gp.obj.length;i++){
            if(gp.obj[i]==null){
                gp.obj[i]=droppedItem;
                gp.obj[i].worldX=worldX; // the dead monster's worldX
                gp.obj[i].worldY=worldY;
                i=gp.obj.length;
            }
        }
    }
    public Color getParticleColor(){
        return null;//new Color(72, 56, 56);
    }
    public int getParticleSize(){
        return 0; // 6 pixels
    }
    public int getParticleSpeed(){
        return 0;
    }
    public int getParticleMaxLife(){
        return 0;
    }
    public void generateParticle(Entity generator, Entity target){
        Color color=generator.getParticleColor();
        int size= generator.getParticleSize();
        int speed=generator.getParticleSpeed();
        int maxLife=generator.getParticleMaxLife();
        // left up/down
        Particle p1=new Particle(gp,generator,color,size,speed,
                maxLife,-2,-1);
        Particle p2=new Particle(gp,generator,color,size,speed,
                maxLife,-2,1);
        Particle p5=new Particle(gp,generator,color,size,speed,
                maxLife,-2,-2);
        Particle p6=new Particle(gp,generator,color,size,speed,
                maxLife,-2,2);
        // right up/down
        Particle p3=new Particle(gp,generator,color,size,speed,
                maxLife,2,-1);
        Particle p4=new Particle(gp,generator,color,size,speed,
                maxLife,2,1);
        gp.particleList.add(p1);
        gp.particleList.add(p2);
        gp.particleList.add(p3);
        gp.particleList.add(p4);
        gp.particleList.add(p5);
        gp.particleList.add(p6);


    }
    public void update(){
        worldY+=dy;
        if(falling/*||jumping*/){
            //if(dy>0/*&&!direction.equals("idle")*/){
               //direction="fall";

            //}//else if(dy<0){
            // direction="jump";
            // }
            dy+=gravity;
            if(dy>20){
                dy=20;
            }
        }
        bottomCollision=false;
        gp.cChecker.isBottomCollision(this);
        String oldDirection=direction;
        direction="fall";
        boolean contactPlayer=gp.cChecker.checkPlayer(this);
        if(this.type==type_monster&&contactPlayer){
            damagePlayer(attack);
        }
        gp.cChecker.checkObject(this,false);
        gp.cChecker.checkEntity(this,gp.iTile);
        direction=oldDirection;
        if(bottomCollision){
            dy=0;
            //jumping=false;
            falling=false;
        }else{
            falling=true;
        }
        //topCollision=false;
        //gp.cChecker.isTopCollision(this);
        // if(topCollision){
        //    dy=1;
        // }
        setAction();
        collisionOn=false;
        gp.cChecker.tileCollision(this);
        gp.cChecker.checkEntity(this,gp.iTile);
        gp.cChecker.checkObject(this,false);
        gp.cChecker.checkEntity(this,gp.npc);
        //gp.cChecker.checkEntity(this,gp.monster);
        contactPlayer=gp.cChecker.checkPlayer(this);
        if(this.type==2&&contactPlayer){
            damagePlayer(attack);
        }
         if(!collisionOn){
             switch (direction){
                 case "left": worldX-=speed; break;
                 case "right": worldX+=speed; break;
                 case "idle": break;
             }
         }else{
             if(direction.equals("left")){
                 direction="right";
             }else{
                 direction="left";
             }
        }
        spriteCounter++;
        if(spriteCounter>11){
            if(spriteNum==1){
                spriteNum=2;
            }else if(spriteNum==2){
                spriteNum=1;
            }
            spriteCounter=0;
        }
        if(invincible){
            invincibleCounter++;
            if(invincibleCounter>40){
                invincible=false;
                invincibleCounter=0;
            }
        }
        if(shotAvailableCounter<30){
            shotAvailableCounter++;
        }

    }
    public void damagePlayer(int attack){
        if(!gp.player.invincible){
            //we can give damage
            int damage=attack-gp.player.defense;
            if(damage<0){
                damage=0;
            }
            gp.playSoundEffect(6);
            gp.player.life-=damage;
            if(gp.player.life<0){
                gp.player.life=0;
            }
            gp.player.invincible=true;
        }

    }
    public void draw(Graphics2D g2){
        int screenX=worldX-gp.player.worldX+gp.player.screenX;
        int screenY=worldY-gp.player.worldY+gp.player.screenY;

        if(worldX+gp.tileSize>gp.player.worldX-gp.player.screenX&&
                worldX - gp.tileSize<gp.player.worldX+gp.player.screenX&&
                worldY + gp.tileSize>gp.player.worldY-gp.player.screenY&&
                worldY - gp.tileSize<gp.player.worldY+gp.player.screenY){
            BufferedImage image=null;
            switch (direction){
                case "fall":
                    if(this instanceof Projectile){
                        if(spriteNum==1){image=fall;}
                        if(spriteNum==2){image=attackDown2;}
                    }else{
                        image=fall;
                    }
                    break;
                case "idle":
                    if(spriteNum==1){image=idle1;}
                    if(spriteNum==2){image=idle1;}
                    break;
                //case "jump":
                 //   image=jump;
                  //  break;
                case "left":
                    if(spriteNum==1){image=left1;}
                    if(spriteNum==2){image=left2;}
                    break;
                case "right":
                    if(spriteNum==1){image=right1;}
                    if(spriteNum==2){image=right2;}
                    break;
            }
            // Monster HP Bar
            if(type==2&&hpBarOn){
                double oneScale=(double)gp.tileSize/maxLife;
                double hpBarValue=oneScale*life;
                g2.setColor(new Color(35,35,35));
                g2.fillRoundRect(screenX-1,screenY-16,gp.tileSize+2,12,5,5);
                g2.setColor(new Color(255,0,30));
                g2.fillRoundRect(screenX,screenY-15,(int)hpBarValue,10,3,3);
                hpBarCounter++;
                if(hpBarCounter>600){
                    hpBarCounter=0;
                    hpBarOn=false;
                }
            }


            if(invincible){
                hpBarCounter=0;
                hpBarOn=true;
                changeAlpha(g2,0.7f);
            }
            if(dying){
                dyingAnimation(g2);
            }

            g2.drawImage(image,screenX,screenY,null);
            changeAlpha(g2,1f);
        }

    }
    public void dyingAnimation(Graphics2D g2){
        dyingCounter++;
        int i=5;
        if(dyingCounter<=i){changeAlpha(g2,0f);}
        if(dyingCounter>i&&dyingCounter<=i*2) {changeAlpha(g2,1f);}
        if(dyingCounter>i*2&&dyingCounter<=i*3) {changeAlpha(g2,0f);}
        if(dyingCounter>i*3&&dyingCounter<=i*4) {changeAlpha(g2,1f);}
        if(dyingCounter>i*4&&dyingCounter<=i*5) {changeAlpha(g2,0f);}
        if(dyingCounter>i*5&&dyingCounter<=i*6) {changeAlpha(g2,1f);}
        if(dyingCounter>i*6&&dyingCounter<=i*7) {changeAlpha(g2,0f);}
        if(dyingCounter>i*7&&dyingCounter<=i*8) {changeAlpha(g2,1f);}
        if(dyingCounter>i*8){
            alive=false;
        }

    }
    public void changeAlpha(Graphics2D g2,float alphaValue){
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alphaValue));
    }

    public BufferedImage setup(String imagePath, int width,int height){
        UtilityTool uTool=new UtilityTool();
        BufferedImage image=null;
        try{
            image= ImageIO.read(getClass().getResourceAsStream(imagePath+".png"));
            image=uTool.scaleImage(image,width,height);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }


}
