package main;

import entity.Entity;

public class CollisionChecker {

    GamePanel gp;
    MouseHandler mouseH;
    public CollisionChecker(GamePanel gp,MouseHandler mouseH){
        this.gp=gp;
        this.mouseH=mouseH;
    }
    public void checkTile(Entity entity){

        int entityLeftWorldX=entity.worldX+ entity.collisionArea.x;
        int entityRightWorldX=entity.worldX+entity.collisionArea.x+entity.collisionArea.width;
        int entityTopWorldY=entity.worldY+entity.collisionArea.y;
        int entityBottomWorldY=entity.worldY+entity.collisionArea.y+entity.collisionArea.height;

        int entityLeftCol=entityLeftWorldX/gp.tileSize;
        int entityRightCol=entityRightWorldX/gp.tileSize;
        int entityTopRow=entityTopWorldY/gp.tileSize;
        int entityBottomRow=entityBottomWorldY/gp.tileSize;

        int tileNum1,tileNum2;

        switch(entity.direction){
            case "up":
                entityTopRow=(entityTopWorldY-entity.speed)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }

                break;

            case "down":
                entityBottomRow=(entityBottomWorldY+entity.speed)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
            case "left":
                entityLeftCol=(entityLeftWorldX-entity.speed)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
            case "right":
                entityRightCol=(entityRightWorldX+entity.speed)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;

        }
    }

    public void isBottomCollision(Entity entity){

        int entityLeftWorldX=entity.worldX+entity.collisionArea.x;
        int entityRightWorldX=entity.worldX-1+entity.collisionArea.x+entity.collisionArea.width;
        int entityBottomWorldY=entity.worldY-1+entity.collisionArea.y+entity.collisionArea.height;

        int entityLeftCol=entityLeftWorldX/ gp.tileSize;
        int entityRightCol=entityRightWorldX/gp.tileSize;
        int entityBottomRow;

        int tileNum1,tileNum2;

            if(entity.dy==0){
                entityBottomRow=(int)(entityBottomWorldY+1)/gp.tileSize;
            }else{
                entityBottomRow=(int)(entityBottomWorldY+entity.dy)/gp.tileSize;
            }
            tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
            tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
            if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                entity.bottomCollision=true;
            }
    }

    public void isTopCollision(Entity entity){
        int entityLeftWorldX=entity.worldX+entity.collisionArea.x;
        int entityRightWorldX=entity.worldX+entity.collisionArea.x+entity.collisionArea.width-1;
        int entityTopWorldY=entity.worldY+entity.collisionArea.y;

        int entityLeftCol=entityLeftWorldX/ gp.tileSize;
        int entityRightCol=entityRightWorldX/gp.tileSize;
        int entityTopRow=entityTopWorldY/ gp.tileSize;
        int tileNum1,tileNum2;

        entityTopRow=(int)(entityTopWorldY+entity.dy)/gp.tileSize;
        tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
        tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
        if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
            entity.topCollision=true;
        }
    }

    public void tileCollision(Entity entity){
        int entityLeftWorldX=entity.worldX-18+entity.collisionArea.x;
        int entityRightWorldX=entity.worldX+entity.collisionArea.x+entity.collisionArea.width;
        int entityTopWorldY=entity.worldY+1+entity.collisionArea.y;
        int entityBottomWorldY=entity.worldY-1+entity.collisionArea.y+entity.collisionArea.height;

        int entityLeftCol=entityLeftWorldX/ gp.tileSize;
        int entityRightCol=entityRightWorldX/gp.tileSize;
        int entityTopRow=entityTopWorldY/ gp.tileSize;
        int entityBottomRow=entityBottomWorldY/gp.tileSize;
        int tileNum1,tileNum2;

        switch(entity.direction){
            /*case "jump":
                entityTopRow=(int)(entityTopWorldY-entity.jumpVelocity*entity.delta)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.topCollision=true;
                }
                break;
            case "fall":
                entityBottomRow=(int)(entityBottomWorldY-entity.point0*entity.delta)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.bottomCollision=true;
                }
                break;

             */


            case "left":
                entityLeftCol=(entityLeftWorldX-entity.speed)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
            case "right":
                entityRightCol=((entityRightWorldX+entity.speed)/gp.tileSize);
                tileNum1=gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;


        }
    }
    public int checkObject(Entity entity, boolean player){

        int index=999;

        for(int i=0;i<gp.obj.length;i++){
            if(gp.obj[i]!=null){
                // Get entity's solid area position
                entity.collisionArea.x=entity.worldX+entity.collisionArea.x;
                entity.collisionArea.y=entity.worldY+entity.collisionArea.y;

                // Get the object's solid area position
                gp.obj[i].collisionArea.x=gp.obj[i].worldX+gp.obj[i].collisionArea.x;
                gp.obj[i].collisionArea.y=gp.obj[i].worldY+gp.obj[i].collisionArea.y;

                switch(entity.direction){
                    case "jump": entity.collisionArea.y+=entity.dy; break;
                    case "fall":
                        if(entity.dy==0){
                            entity.collisionArea.y+=1;
                        }else{
                            entity.collisionArea.y+=entity.dy;
                        }
                        break;
                    case "left": entity.collisionArea.x-=entity.speed; break;
                    case "right": entity.collisionArea.x+=entity.speed; break;
                }
                if(entity.collisionArea.intersects(gp.obj[i].collisionArea)) {
                    if (player) {
                        index = i;
                    }
                    if (gp.obj[i].collision) {
                        if(entity.direction.equals("fall")){
                            entity.bottomCollision=true;
                        }else if(entity.direction.equals("jump")){
                            entity.topCollision=true;
                        }else{
                            entity.collisionOn=true;
                        }
                    }
                }

                entity.collisionArea.x=entity.collisionAreaDefaultX;
                entity.collisionArea.y=entity.collisionAreaDefaultY;
                gp.obj[i].collisionArea.x=gp.obj[i].collisionAreaDefaultX;
                gp.obj[i].collisionArea.y=gp.obj[i].collisionAreaDefaultY;
            }
        }
        return index;
    }

    // NPC OR MONSTER COLLISION
    public int checkEntity(Entity entity, Entity[] target){
        int index=999;
        for(int i=0;i<target.length;i++){
            if(target[i]!=null){
                // Get entity's solid area position
                entity.collisionArea.x=entity.worldX+entity.collisionArea.x;
                entity.collisionArea.y=entity.worldY+entity.collisionArea.y;

                // Get the object's solid area position
                target[i].collisionArea.x=target[i].worldX+target[i].collisionArea.x;
                target[i].collisionArea.y=target[i].worldY+target[i].collisionArea.y;

                switch(entity.direction){
                    case "jump": entity.collisionArea.y+=entity.dy; break;

                    case "fall": if(entity.dy==0){
                        entity.collisionArea.y+=1;
                    }else{
                        entity.collisionArea.y+=entity.dy;
                    } break;
                    case "left": entity.collisionArea.x-=entity.speed; break;
                    case "right": entity.collisionArea.x+=entity.speed; break;
                }
                if(entity.collisionArea.intersects(target[i].collisionArea)){
                    if(target[i]!=entity){
                        index=i;
                        if(entity.direction.equals("fall")){
                            entity.bottomCollision=true;
                        }else if(entity.direction.equals("jump")){
                            entity.topCollision=true;
                        }else{
                            entity.collisionOn=true;
                        }
                    }
                }
                entity.collisionArea.x=entity.collisionAreaDefaultX;
                entity.collisionArea.y=entity.collisionAreaDefaultY;
                target[i].collisionArea.x=target[i].collisionAreaDefaultX;
                target[i].collisionArea.y=target[i].collisionAreaDefaultY;
            }
        }
        return index;

    }
    public boolean checkPlayer(Entity entity){
        boolean contactPlayer=false;
        entity.collisionArea.x=entity.worldX+entity.collisionArea.x;
        entity.collisionArea.y=entity.worldY+entity.collisionArea.y;

        // Get the object's solid area position
        gp.player.collisionArea.x=gp.player.worldX+gp.player.collisionArea.x;
        gp.player.collisionArea.y=gp.player.worldY+gp.player.collisionArea.y;

        switch(entity.direction){
            case "jump": entity.collisionArea.y+=entity.dy; break;
            case "fall": entity.collisionArea.y+=entity.dy;
            if(entity.dy==0){
                entity.collisionArea.y+=1;
            }else{
                entity.collisionArea.y+=entity.dy;
            }
                break;
            case "left": entity.collisionArea.x-=entity.speed; break;
            case "right": entity.collisionArea.x+=entity.speed; break;
        }
        if(entity.collisionArea.intersects(gp.player.collisionArea)){
            if(entity.direction.equals("fall")){
                entity.bottomCollision=true;
                contactPlayer=true;
            }else if(entity.direction.equals("jump")){
                entity.topCollision=true;
                contactPlayer=true;
            }else{
                entity.collisionOn=true;
                contactPlayer=true;
            }
        }
        entity.collisionArea.x=entity.collisionAreaDefaultX;
        entity.collisionArea.y=entity.collisionAreaDefaultY;
        gp.player.collisionArea.x=gp.player.collisionAreaDefaultX;
        gp.player.collisionArea.y=gp.player.collisionAreaDefaultY;
        return contactPlayer;
    }

    /*public void checkCollision(Entity entity){
        int entityLeftWorldX=entity.worldX+entity.collisionArea.x;
        int entityRightWorldX=entity.worldX+entity.collisionArea.x+entity.collisionArea.width;
        int entityTopWorldY=entity.worldY+entity.collisionArea.y;
        int entityBottomWorldY=entity.worldY+entity.collisionArea.y+entity.collisionArea.height;

        int entityLeftCol=entityLeftWorldX/ gp.tileSize;
        int entityRightCol=entityRightWorldX/gp.tileSize;
        int entityTopRow=entityTopWorldY/ gp.tileSize;
        int entityBottomRow=entityBottomWorldY/gp.tileSize;
        int tileNum1,tileNum2;

        switch(entity.direction){
            case "jump":
                entityTopRow=(int)(entityTopWorldY+entity.dy)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
            case "fall":
                entityBottomRow=(int)(entityBottomWorldY+entity.dy)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;

            case "left":
                entityLeftCol=(entityLeftWorldX-entity.speed)/gp.tileSize;
                tileNum1=gp.tileManager.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityLeftCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;
            case "right":
                entityRightCol=((entityRightWorldX+entity.speed)/gp.tileSize);
                tileNum1=gp.tileManager.mapTileNum[entityRightCol][entityTopRow];
                tileNum2=gp.tileManager.mapTileNum[entityRightCol][entityBottomRow];
                if(gp.tileManager.tile[tileNum1].collision||gp.tileManager.tile[tileNum2].collision){
                    entity.collisionOn=true;
                }
                break;


        }
    }
     */





}
