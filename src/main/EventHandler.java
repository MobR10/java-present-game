package main;

public class EventHandler {
    GamePanel gp;
    EventRect[][] eventRect;

    int previousEventX,previousEventY;
    boolean canTouchEvent=true;

    public EventHandler(GamePanel gp){
        this.gp=gp;
        this.eventRect=new EventRect[gp.maxWorldCol][gp.maxWorldRow];
        int col=0;
        int row=0;
        while(col<gp.maxWorldCol&&row<gp.maxWorldRow){
            eventRect[col][row]=new EventRect();
            eventRect[col][row].x=0;
            eventRect[col][row].y=gp.tileSize/2;
            eventRect[col][row].width=gp.tileSize;
            eventRect[col][row].height=10;
            eventRect[col][row].eventRectDefaultX=eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY=eventRect[col][row].y;
            col++;
            if(col==gp.maxWorldCol){
                col=0;
                row++;
            }
        }

    }
    public void checkEvent(){


        // Check if the player character is more than 1 tile away than the last event
        int xDistance=Math.abs(gp.player.worldX-previousEventX);
        int yDistance=Math.abs(gp.player.worldY-previousEventY);
        int distance=Math.max(xDistance,yDistance);
        if(distance>gp.tileSize){
            canTouchEvent=true;
        }

        // y==31 surface
        if(canTouchEvent){
            if(hit(64,48,"any")){
                System.out.println("bruh");
                if(gp.player.level<8){
                    gp.player.direction="idle";
                    hitMiddle(21,33,gp.dialogueState);
                }
            } else if(hit(64,47,"any")){
                System.out.println("bruh");
                if(gp.player.level<8){
                    gp.player.direction="idle";
                    hitMiddle(22,33,gp.dialogueState);
                }


            }else if(hit(64,46,"any")){
                System.out.println("bruh");
                if(gp.player.level<8){
                    gp.player.direction="idle";
                    hitMiddle(23,33,gp.dialogueState);
                }
            }
            if(hit(23,46,"any")){
                healingPlace(23,46,gp.dialogueState);
            }
        }

        //if(hit(19,31,"any")){
         //       gp.ui.drawPressForAction();
           // healingPlace(gp.dialogueState);
       // }
    }
    public boolean hit(int col,int row,String regDirection){
        boolean hit=false;

        gp.player.collisionArea.x=gp.player.worldX+gp.player.collisionArea.x;
        gp.player.collisionArea.y=gp.player.worldY+gp.player.collisionArea.y;
        eventRect[col][row].x=col*gp.tileSize+eventRect[col][row].x;
        eventRect[col][row].y=row*gp.tileSize+eventRect[col][row].y;

        if(gp.player.collisionArea.intersects(eventRect[col][row]) &&
                !eventRect[col][row].eventDone){
            if(gp.player.direction.contentEquals(regDirection)||
            regDirection.contentEquals("any")){
                hit=true;
                previousEventX=gp.player.worldX;
                previousEventY=gp.player.worldY;
            }
        }
        gp.player.collisionArea.x=gp.player.collisionAreaDefaultX;
        gp.player.collisionArea.y=gp.player.collisionAreaDefaultY;
        eventRect[col][row].x=eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y=eventRect[col][row].eventRectDefaultY;

        return hit;
    }
    public void hitMiddle(int col, int row,int gameState){
        gp.gameState=gameState;
        gp.ui.currentDialogue="Nu recomand sa treci de partea cealalta inca";
        gp.player.worldX=gp.tileSize*63;
        gp.player.worldY=gp.tileSize*48;
        //eventRect[col][row].eventDone=true;
    }
    public void healingPlace(int col, int row,int gameState){
        if(gp.keyH.ePressed){
            gp.gameState=gameState;
            gp.ui.currentDialogue="Primesti heal si sageti aici, ce tare!";
            gp.player.life=gp.player.maxLife;
            gp.player.ammo =gp.player.maxAmmo;
            canTouchEvent=false;
           // gp.aSetter.setMonster();

        }

    }


}
