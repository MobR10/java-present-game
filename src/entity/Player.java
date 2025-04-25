package entity;

import main.GamePanel;
import main.KeyHandler;
import monster.MON_Boss;
import monster.MON_GreenSlime;
import object.*;
import tile_interactive.IT_BossDoor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends Entity{

    KeyHandler keyH;

    public int screenX;
    public int screenY;
    public ArrayList<Entity> inventory=new ArrayList<>();
    public final int maxInventorySize=20;
   // public int hasKey=0;



    public Player(GamePanel gp,KeyHandler keyH){
        super(gp);

        this.keyH=keyH;

        screenX=gp.screenWidth/2 - gp.tileSize/2;
        screenY=gp.screenHeight/2 - gp.tileSize/2;

        collisionArea =new Rectangle(10,16,gp.tileSize-35,gp.tileSize-20);
        collisionArea.x=20;
        collisionArea.y=20;
        collisionArea.width=gp.tileSize-collisionArea.x-10;
        collisionArea.height=gp.tileSize-collisionArea.y;
        collisionAreaDefaultX = collisionArea.x;
        collisionAreaDefaultY = collisionArea.y;

       // attackArea.width=45;
       // attackArea.height=40;

        setDefaultValues();
        getPlayerImage();
        getPlayerAttackImage();
        setItems();
    }
    public void setDefaultValues(){
        worldX=gp.tileSize*20;
        worldY=gp.tileSize*48;
        speed=5;
        direction="fall";
        // PLAYER STATUS
        level=1;
        maxLife=10;
        life=maxLife;
        maxAmmo =8;
        ammo = maxAmmo;
        strength=1; // the more strength, the more damage given
        dexterity=1; // the more dexterity, the less damage received
        exp=0;
        nextLevelExp=5;
        coin=0;
        currentWeapon=new OBJ_RustySword(gp);
        //currentShield=new OBJ_Shield_Wood(gp);
        projectile=new OBJ_PArrow(gp);
        attack=getAttack(); // the total attack value is decided by strength and weapon
        defense=getDefense(); // the total defense value is decided by dexterity and shield

    }
    public void setItems(){
        inventory.add(currentWeapon);
       // inventory.add(new OBJ_AsunaSword(gp));

    }
    public int getAttack(){
        attackArea=currentWeapon.attackArea;
        if(currentWeapon instanceof OBJ_AsunaSword){
            return strength*currentWeapon.attackValue;
        }else{
            return strength+currentWeapon.attackValue;
        }

    }
    public int getDefense(){
        return dexterity;
    }
    public void getPlayerImage(){

        /*
        idle=setup("player_static");
        up1=setup("boy_up_1");
        up2=setup("boy_up_2");
        down1=setup("boy_down_1");
        down2=setup("boy_down_2");
        left1=setup("boy_left_1");
        left2=setup("boy_left_2");
        right1=setup("boy_right_1");
        right2=setup("boy_right_2");
         */
        idle1=setup("/player/CP_static1",gp.tileSize,gp.tileSize);
        idle2=setup("/player/CP_static2",gp.tileSize,gp.tileSize);
        left1=setup("/player/CP_left1",gp.tileSize,gp.tileSize);
        left2=setup("/player/CP_left2",gp.tileSize,gp.tileSize);
        right1=setup("/player/CP_right1",gp.tileSize,gp.tileSize);
        right2=setup("/player/CP_right2",gp.tileSize,gp.tileSize);
        fall=setup("/player/CP_fall(1)",gp.tileSize,gp.tileSize);
        jump=setup("/player/CP_jump",gp.tileSize,gp.tileSize);


    }
    public void getPlayerAttackImage(){
        if(currentWeapon.type== type_rustySword){
            attackDown1=setup("/player/rustysword_down1",gp.tileSize,gp.tileSize*2);
            attackDown2=setup("/player/rustysword_down2",gp.tileSize,gp.tileSize*2);
            attackLeft1=setup("/player/rustysword_left1",gp.tileSize*2,gp.tileSize);
            attackLeft2=setup("/player/rustysword_left2",gp.tileSize*2,gp.tileSize);
            attackRight1=setup("/player/rustysword_right1",gp.tileSize*2,gp.tileSize);
            attackRight2=setup("/player/rustysword_right2",gp.tileSize*2,gp.tileSize);
        }
        if(currentWeapon.type== type_asunaSword){
            attackDown1=setup("/player/asunasword_down1",gp.tileSize,gp.tileSize*2);
            attackDown2=setup("/player/asunasword_down2",gp.tileSize,gp.tileSize*2);
            attackLeft1=setup("/player/asunasword_left1",gp.tileSize*2,gp.tileSize);
            attackLeft2=setup("/player/asunasword_left2",gp.tileSize*2,gp.tileSize);
            attackRight1=setup("/player/asunasword_right1",gp.tileSize*2,gp.tileSize);
            attackRight2=setup("/player/asunasword_right2",gp.tileSize*2,gp.tileSize);
        }

    }

int monsterIndex;
    public void gravityTest(){

        bottomCollision=false;
        gp.cChecker.isBottomCollision(this);
        //System.out.printf("BOTTOM COLLISION IMEDIAT DUPA VERIFICARE GRAVITY: %b",bottomCollision);
        String oldDirection=direction;
        direction="fall";
        int objIndex= gp.cChecker.checkObject(this,true);
        pickUpObject(objIndex);
        int i=gp.cChecker.checkEntity(this,gp.npc);
        gp.cChecker.checkEntity(this,gp.iTile);
        monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
        contactMonster(monsterIndex);
        interactNPC(i);
        direction=oldDirection;
        if(bottomCollision){
            //System.out.println("IMPACT!!! DY A DEVENIT 0");
            if(dy==20){
                damagePlayer(6+gp.player.defense);
            }
            dy=0;
            jumping=false;
            falling=false;
        }else{
           // System.out.printf("DY IN ELSE FALLING TRUE ESTE : %f",dy);
            jumping=true;
            falling=true;
        }
        topCollision=false;
        gp.cChecker.isTopCollision(this);
        direction="jump";
        objIndex= gp.cChecker.checkObject(this,true);
        pickUpObject(objIndex);
        i=gp.cChecker.checkEntity(this,gp.npc);
        gp.cChecker.checkEntity(this,gp.iTile);
        monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
        contactMonster(monsterIndex);
        interactNPC(i);
        direction=oldDirection;
        if(topCollision){
            dy=0;
        }
    }
    int birdsCounter=1;
    boolean playing=false;
    int canFire;
    public void update(){
        if(worldX>64*gp.tileSize||worldY>gp.tileSize*50){
            gp.birds.stop();
            birdsCounter=2;
            playing=false;
        }else{
            birdsCounter=1;
        }
        if(birdsCounter==1&&!playing){
            gp.birds.play();
            gp.birds.loop();
            playing=true;
        }
        if(life<=0){
            life=maxLife;
            ammo=maxAmmo;
            gp.ui.currentDialogue="Cazi la pamant, dar copacul iti da putere!\nRidica-te si distruge-i de data asta!";
            gp.gameState=gp.dialogueState;
            gp.player.worldX=gp.tileSize*22;
            gp.player.worldY=gp.tileSize*46;
        }
///////////////////////////
        worldY+=dy;
         if(jumping||falling){
             if(!attacking){
                 if(falling&&!direction.equals("idle")){
                     direction="fall";
                 }
                 if(jumping&&dy<0){
                     direction="jump";
                 }
             }
            dy+=gravity;
            if(dy>20){
                dy=20;
            }
        }
         gravityTest();
/////////////////////////
        if(keyH.leftPressed||keyH.rightPressed||keyH.ePressed){

            if(keyH.leftPressed){
                    direction="left";
                collisionOn=false;
                gp.cChecker.tileCollision(this);
                int i=gp.cChecker.checkEntity(this,gp.npc);
                gp.cChecker.checkEntity(this,gp.iTile);
                monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
                interactNPC(i);
                int objIndex= gp.cChecker.checkObject(this,true);
                pickUpObject(objIndex);
                if(!collisionOn&&!keyH.ePressed&&!keyH.cPressed){
                    worldX-=speed;
                }
            }
            if(keyH.rightPressed){
                    direction="right";
                collisionOn=false;
                gp.cChecker.tileCollision(this);
                int i=gp.cChecker.checkEntity(this,gp.npc);
                gp.cChecker.checkEntity(this,gp.iTile);
                monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
                interactNPC(i);
                int objIndex= gp.cChecker.checkObject(this,true);
                pickUpObject(objIndex);
                if(!collisionOn&&!keyH.ePressed&&!keyH.cPressed){
                    worldX+=speed;
                }
            }
            gp.eHandler.checkEvent();
            gp.keyH.ePressed=false;
            spriteCounter++;
            if(spriteCounter>25){
                if(spriteNum==1){
                    spriteNum=2;
                }else if(spriteNum==2){
                    spriteNum=1;
                }
                spriteCounter=0;
            }
        }
        contactMonster(monsterIndex);
        if((!keyH.leftPressed&&!keyH.rightPressed&&!jumping&&!falling&&!attacking)){
            direction="idle";
            idleSpriteCounter++;
            if(idleSpriteCounter>40){
                if(spriteNum==1){
                    spriteNum=2;
                }else if(spriteNum==2){
                    spriteNum=1;
                }
                idleSpriteCounter=0;
            }
        }
        gp.eHandler.checkEvent();
        if(attacking){
            attacking();
            speed=4;
        }else{
            speed=5;
            attackSpriteCounter=0;

        }
        if(gp.mouseH.shotKeyPressed&&!projectile.alive&&canFire>=80&& projectile.haveResource(this)){
            // SET DEFAULT COORDINATES, DIRECTION AND USER;
            projectile.set(worldX,worldY,attackDirection,true,this);

            // SUBTRACT THE COST( MANA, AMMO, ETC)
            projectile.subtractResource(this);

            // ADD IT TO THE LIST
            gp.projectileList.add(projectile);
            gp.playSoundEffect(10);
            canFire=0;
            if(!bottomCollision){

            }

        }else{
            gp.mouseH.shotKeyPressed=false;
        }
        canFire++;


        // This needs to be outside of key if statement!
        if(invincible){
            invincibleCounter++;
            if(invincibleCounter>60){
                invincible=false;
                invincibleCounter=0;
            }
        }
        if(life> maxLife){
            life= maxLife;
        }
        if(ammo > maxAmmo){
            ammo = maxAmmo;
        }


    }
    /*
    public void update(){


        if(!keyH.upPressed&&!keyH.downPressed&&
                !keyH.leftPressed&&!keyH.rightPressed){
            direction="idle";
        }

        if(keyH.upPressed||keyH.downPressed||
                keyH.leftPressed||keyH.rightPressed){
            if(keyH.upPressed){
                direction="up";
                collisionOn=false;
                gp.cChecker.checkTile(this);
                int objIndex= gp.cChecker.checkObject(this,true);
                pickUpObject(objIndex);
                if(!collisionOn){
                    worldY-=speed;
                }
            }
            if(keyH.downPressed){
                direction="down";
                collisionOn=false;
                gp.cChecker.checkTile(this);
                int objIndex= gp.cChecker.checkObject(this,true);
                pickUpObject(objIndex);
                if(!collisionOn){
                    worldY+=speed;
                }
            }
            if(keyH.leftPressed){
                direction="left";
                collisionOn=false;
                gp.cChecker.checkTile(this);
                int objIndex= gp.cChecker.checkObject(this,true);
                pickUpObject(objIndex);
                if(!collisionOn){
                    worldX-=speed;
                }
            }
            if(keyH.rightPressed){
                direction="right";
                collisionOn=false;
                gp.cChecker.checkTile(this);
                int objIndex= gp.cChecker.checkObject(this,true);
                pickUpObject(objIndex);
                if(!collisionOn){
                    worldX+=speed;
                }
            }

            spriteCounter++;
            if(spriteCounter>12){
                if(spriteNum==1){
                    spriteNum=2;
                }else if(spriteNum==2){
                    spriteNum=1;
                }
                spriteCounter=0;
            }
        }


        // CHECK TILE COLLISION
        //collisionOn=false;
        //gp.cChecker.checkTile(this);

        // CHECK OBJECT COLLISION
        //int objIndex= gp.cChecker.checkObject(this,true);
        //pickUpObject(objIndex);

        // IF COLLISION IS FALSE, PLAYER CAN MOVE
       /* if(!collisionOn){
            if(direction.equals("up")) {
                worldY-=speed;
            }
            if(direction.equals("down")){
                    worldY+=speed;
                }
            if(direction.equals("left")){
                    worldX-=speed;
                }
            if(direction.equals("right")){
                    worldX+=speed;
                }
            }

        /*

    }
    */

   public void attacking(){
       /* String testDirection=direction;
           if(gp.mouseH.beforeScreenX){
               testDirection="left";
           }else if(gp.mouseH.afterScreenX){
               testDirection="right";
           }else if(gp.mouseH.downAttack){
               testDirection="fall";
           }*/
       attackSpriteCounter++;
       if(attackSpriteCounter<=5){
           spriteNum=1;
       }
       if(attackSpriteCounter>5&&attackSpriteCounter<=25){
           spriteNum=2;
           // Save the current worldX,worldY, collisionArea
           int currentWorldX=worldX;
           int currentWorldY=worldY;
           int collisionAreaWidth=collisionArea.width;
           int collisionAreaHeight=collisionArea.height;

            //Adjust player's worldX/Y for the attackArea
            switch (attackDirection){
               case "fall": this.worldY+=attackArea.height+24; break;
               case "left": this.worldX-=attackArea.width; break;
               case "right": this.worldX+=attackArea.width-20; break;
          }

           // attackArea becomes collisionArea
           collisionArea.width=attackArea.width;
           collisionArea.height=attackArea.height;
           // Check monster collision with the updated worldX, worldY and collisionArea
           int monsterIndex=gp.cChecker.checkEntity(this,gp.monster);
           damageMonster(monsterIndex,attack);
           int iTileIndex=gp.cChecker.checkEntity(this, gp.iTile);
           damageInteractiveTile(iTileIndex);
           // After checking collision, restore the original data
           worldX=currentWorldX;
           worldY=currentWorldY;
           collisionArea.width=collisionAreaWidth;
           collisionArea.height=collisionAreaHeight;
       }
       if(attackSpriteCounter>25){
           spriteNum=1;
           attackSpriteCounter=0;
           attacking=false;
       }
   }
   public void damageMonster(int i,int attack){
       if(i!=999) {
           if (!gp.monster[i].invincible) {
               int damage=attack-gp.monster[i].defense;
               if(damage<0){
                   damage=0;
               }
               gp.monster[i].damageReaction();
               gp.playSoundEffect(5);
               if(attackDirection.equals("fall")){
                   if(!this.projectile.alive){
                       generateParticle(gp.monster[i],null);
                   }
                   damage+=2;
                   gp.monster[i].life -= damage;
                   gp.ui.addMessage(damage+" Damage!");
               }else{
                   if(!this.projectile.alive){
                       generateParticle(gp.monster[i],null);
                   }

                   gp.monster[i].life -= damage;
                   gp.ui.addMessage(damage+" Damage!");
               }
               gp.monster[i].invincible = true;
               if (gp.monster[i].life <= 0) {
                   gp.monster[i].direction="idle";
                   gp.monster[i].dying=true;
                   gp.ui.addMessage("Killed the "+gp.monster[i].name+"!");
                   gp.ui.addMessage("EXP+ "+gp.monster[i].exp+"!");
                   exp+=gp.monster[i].exp;
                   checkLevelUp();
                   if(gp.monster[i] instanceof MON_Boss){
                       gp.ui.currentDialogue="YEEEEE, AI REUSIIIT!! Ai omorat Lordul Vidului si ai salvat copacul zanelor!\nVoia naratorului spune: La multi anisoori!!";
                       gp.gameState=gp.dialogueState;
                   }
                   if(gp.monster[i] instanceof MON_GreenSlime){
                       gp.ui.currentDialogue="Hehe, ai tinut neaparat sa-l omori pe bietul slime, ei? Congrats!";
                       gp.gameState=gp.dialogueState;
                   }
               }
           }

       }
   }
   public int doorCounter=1;
   public void damageInteractiveTile(int i){
       if(i!=999&&gp.iTile[i].destructible&&gp.iTile[i].isCorrectItem(this)
       &&!gp.iTile[i].invincible){
           if(gp.iTile[i] instanceof IT_BossDoor){
               doorCounter=0;
           }
               gp.iTile[i].playSoundEffect();
               gp.iTile[i].life--;
               gp.iTile[i].invincible=true;
               // Generates particles
               generateParticle(gp.iTile[i],gp.iTile[i]);
               if(gp.iTile[i].life==0){
                   gp.iTile[i]=gp.iTile[i].getDestroyedForm();
               }
       }
   }
   public void checkLevelUp(){
       if(exp>=nextLevelExp){
           level++;
           exp=exp-nextLevelExp;
           if(exp<0){
               exp=0;
           }
           nextLevelExp=nextLevelExp+10;
           maxLife+=2;
           strength++;
           defense++;
           attack=getAttack();
           //defense=getDefense();
           gp.playSoundEffect(8);
           gp.gameState=gp.dialogueState;
           gp.ui.currentDialogue="You have reached level "+level+"!";
       }
   }
   public void selectItem(){
       int itemIndex=gp.ui.getItemIndexOnSlot();
       if(itemIndex<inventory.size()){
           Entity selectedItem=inventory.get(itemIndex);
           if(selectedItem.type== type_rustySword ||selectedItem.type== type_asunaSword){
               currentWeapon=selectedItem;
               attack=getAttack();
               getPlayerAttackImage();
           }
           if(selectedItem.type==type_shield){
               currentShield=selectedItem;
               defense=getDefense();
           }
           if(selectedItem.type==type_consumable){
               selectedItem.use(this);
               inventory.remove(itemIndex);
           }
       }
   }
   public void pickUpObject(int i){
        if(i!=999){

            // PICKUP ONLY ITEMS
            if(gp.obj[i].type==type_pickupOnly){
                gp.obj[i].use(this);
                gp.obj[i]=null;
            }
            // INVENTORY ITEMS
            else{String text;
                if(inventory.size()!=maxInventorySize){
                    inventory.add(gp.obj[i]);
                    gp.playSoundEffect(12);
                    text="Got "+gp.obj[i].name+"!";
                }else{
                    text="You cannot carry any more!";
                }
                gp.ui.addMessage(text);
                gp.obj[i]=null;

            }

            /*
            String objectName=gp.obj[i].name;
            switch (objectName){
                case "Key":
                    gp.playSoundEffect(1);
                    hasKey++;
                    gp.obj[i]=null;
                    gp.ui.showMessage("You got a key!");
                    break;
                case "Door":
                    if(hasKey >0){
                        gp.playSoundEffect(3);
                        gp.obj[i]=null;
                        hasKey--;
                        gp.ui.showMessage("You opened the door!");
                    }

                    break;
                case "Boots":
                    gp.playSoundEffect(2);
                    speed+=2;
                    gp.obj[i]=null;
                    gp.ui.showMessage("Speed up!");
                    break;
                case "Chest":
                    gp.ui.gameFinished=true;
                    gp.stopMusic();
                    gp.playSoundEffect(4);
                    break;
            }
            */
        }

    }
   public void interactNPC(int i){
        if(keyH.ePressed&&!keyH.cPressed) {
            if (i != 999) {
                gp.gameState = gp.dialogueState;
                gp.npc[i].speak();
                //direction="idle";
                //gp.keyH.ePressed=false;
            } //else {
             //   attacking = true;
           // }
        }

   }

   public void contactMonster(int i){
        if(i!=999&&!(gp.monster[i] instanceof MON_GreenSlime)){
            if(!invincible&&!gp.monster[i].dying){
                gp.playSoundEffect(6);
                int damage=gp.monster[i].attack-defense;
                if(damage<0){
                    damage=0;
                }
                life-=damage;
                invincible=true;
            }

        }
   }
    public void draw(Graphics2D g2){
        // g2.setColor(Color.white);
        //g2.fillRect(x,y,gp.tileSize,gp.tileSize);

        BufferedImage image=null;
        int tempScreenX=screenX;
        int tempScreenY=screenY;


        if(!attacking){
            if(keyH.cPressed&&direction.equals("right")||keyH.cPressed&&direction.equals("left")){
                direction="idle";
            }
            switch (direction){
                case "fall":
                        image=fall;
                    break;
                case "idle":
                    if(spriteNum==1){image=idle1;}
                    if(spriteNum==2){image=idle2;}
                    break;
                case "jump":
                    image=jump;
                    break;
                case "left":
                        if(spriteNum==1){image=left1;}
                        if(spriteNum==2){image=left2;}
                    break;
                case "right":
                        if(spriteNum==1){image=right1;}
                        if(spriteNum==2){image=right2;}
                    break;
            }
        }else{
            switch (attackDirection){
                case "fall":
                        if(spriteNum==1){image=attackDown1;}
                        if(spriteNum==2){image=attackDown2;}
                    break;
                case "left":
                        tempScreenX=screenX-gp.tileSize;
                        if(spriteNum==1){image=attackLeft1;}
                        if(spriteNum==2){image=attackLeft2;}
                    break;
                case "right":
                        if(spriteNum==1){image=attackRight1;}
                        if(spriteNum==2){image=attackRight2;}
                    break;
            }
        }

        /*
        int x=screenX;
        int y=screenY;
        if(screenX>worldX){
            x=worldX;
        }
        if(screenY>worldY){
            y=worldY;
        }
        int rightOffset=gp.screenWidth-screenX;
        if(rightOffset>gp.worldWidth-worldX){
            x=gp.screenWidth-(gp.worldWidth-worldX);
        }
        int bottomOffset=gp.screenHeight-screenY;
        if(bottomOffset>gp.worldHeight-worldY){
            y=gp.screenHeight-gp.worldHeight-worldY;
        }

         */

        if(invincible){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.7f));
        }
        g2.drawImage(image,tempScreenX,tempScreenY,null);

        // Reset Alpha
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
        g2.setColor(Color.black);

        //g2.drawRect(tempScreenX,tempScreenY,collisionArea.x+collisionArea.width,collisionArea.y+collisionArea.height);

        // DEBUG
        //g2.setFont(new Font("Arial",Font.PLAIN,20));
        //g2.setColor(Color.white);
        //g2.drawString("Invincible:"+invincibleCounter,10,100);

    }
}
