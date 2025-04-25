package main;

import entity.Entity;
import object.OBJ_Heart;
import object.OBJ_Arrow;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font maruMonica_40,maruMonica_80;
    BufferedImage heart_full,heart_half,heart_blank, arrow_full, arrow_blank;
    //BufferedImage keyImage;
    public boolean messageOn=false;
  //  public String message="";
   // int messageCounter=0;
    ArrayList<String>message=new ArrayList<>();
    ArrayList<Integer>messageCounter=new ArrayList<>();
    public boolean gameFinished=false;
    public String currentDialogue="";
    public int commandNum=0;
    public int slotCol=0;
    public int slotRow=0;
    double playTime;
    DecimalFormat dFormat=new DecimalFormat("#0.00");
    Color salmonPink=new Color(250, 160, 171);
    Color titleBackground=new Color(145, 255, 236);

    public UI(GamePanel gp){
        this.gp=gp;

        try{
            InputStream is=getClass().getResourceAsStream("/font/x12y16pxMaruMonica.ttf");
            maruMonica_40=Font.createFont(Font.TRUETYPE_FONT, is);
        }catch (FontFormatException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        // CREATE HUD OBJECT
        Entity heart=new OBJ_Heart(gp);
        heart_full=heart.image;
        heart_half=heart.image2;
        heart_blank=heart.image3;
        Entity arrow=new OBJ_Arrow(gp);
        arrow_full =arrow.image;
        arrow_blank =arrow.image2;

       // arial_80B=new Font("Arial",Font.PLAIN,80);
        //arial_40=new Font("Arial",Font.PLAIN,40);
        //OBJ_Key key=new OBJ_Key(gp);
        //keyImage=key.image;
    }
    public void addMessage(String text){
     //   message=text;
     //   messageOn=true;
        message.add(text);
        messageCounter.add(0);
    }
    public void draw(Graphics2D g2){
     this.g2=g2;

     g2.setFont(maruMonica_40);
     g2.setColor(Color.white);


     // TITLE STATE
        if(gp.gameState==gp.titleState){
            drawTitleScreen();
        }
     // PLAY STATE
     if(gp.gameState==gp.playState){
         // Do playState stuff later
         if(gp.eHandler.hit(23,46,"any")&&gp.eHandler.canTouchEvent){
             drawPressForAction("Apasa E pentru heal");
         }else{
             isDrawingPressForAction=false;
         }
         drawPlayerLife();
         drawMessage();
         if(gp.keyH.cPressed){
             drawCharacterScreen();
             drawInventory();
         }
     }
     // PAUSE STATE
     if(gp.gameState==gp.pauseState){
         drawPlayerLife();
         drawPauseScreen();
     }
     // DIALOGUE STATE
     if(gp.gameState==gp.dialogueState){
         drawPlayerLife();
         drawDialogueScreen();
         gp.descriptionCounter=0;
     }
     // CHARACTER STATE
        if(gp.gameState==gp.characterState){
            drawCharacterScreen();
        }


        /*
        if(gameFinished){
            g2.setFont(arial_40);
            g2.setColor(Color.white);

            String text;
            int textLength;
            int x;
            int y;

            text="You found the treasure!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x=gp.screenWidth/2-textLength/2;
            y=gp.screenHeight/2-(gp.tileSize*3);
            g2.drawString(text,x,y);

            text="Your time is: "+dFormat.format(playTime)+"!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x=gp.screenWidth/2-textLength/2;
            y=gp.screenHeight/2+(gp.tileSize*4);
            g2.drawString(text,x,y);

            g2.setFont(arial_80B);
            g2.setColor(Color.yellow);
            text="Congratulations!";
            textLength=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();

            x=gp.screenWidth/2-textLength/2;
            y=gp.screenHeight/2+(gp.tileSize*2);
            g2.drawString(text,x,y);

            gp.gameThread=null;

        }
        else{
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage,gp.tileSize/2,gp.tileSize/2,gp.tileSize,gp.tileSize,null);
            g2.drawString("x "+gp.player.hasKey,74,65);

            //TIME
            playTime+=(double)1/60;
            g2.drawString("Time:"+dFormat.format(playTime),gp.tileSize*11,65);

            //MESSAGE
            if(messageOn){
                g2.setFont(g2.getFont().deriveFont(30f));
                g2.drawString(message,gp.tileSize/2,gp.tileSize*5);

                messageCounter++;
                if(messageCounter>120){
                    messageCounter=0;
                    messageOn=false;
                }
            }
        }
        */


    }
    public boolean isDrawingPressForAction=false;
    public void drawPressForAction(String messageForAction){
        // WINDOW
        isDrawingPressForAction=true;
        int x=(int) (gp.screenWidth/1.23f)-15;
        int y=(int)(gp.screenHeight/1.09f)-5;
        int width=gp.tileSize*2+20;
        int height=gp.tileSize;
        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,16F));
        x+=15;
        y+=35;

        g2.drawString(messageForAction,x,y);
    }
    public void drawPlayerLife(){

        int x=gp.tileSize/2;
        int y=gp.tileSize/2;
        int i=0;
        // DRAW BLANK HEART
        while(i<gp.player.maxLife/2){
            g2.drawImage(heart_blank,x,y,null);
            i++;
            x+=gp.tileSize/2;
        }
        // RESET
         x=gp.tileSize/2;
         y=gp.tileSize/2;
         i=0;
         // DRAW CURRENT LIFE
        while(i<gp.player.life){
            g2.drawImage(heart_half,x,y,null);
            i++;
            if(i<gp.player.life){
                g2.drawImage(heart_full,x,y,null);
            }
            i++;
            x+=gp.tileSize/2;
        }
        // DRAW MAX ARROWS
        x=gp.tileSize/2;
        y=gp.tileSize;
        i=0;
        while(i<gp.player.maxAmmo){
            g2.drawImage(arrow_blank,x,y,null);
            i++;
            x+=gp.tileSize/2;
        }
        // DRAW ARROWS
        x=gp.tileSize/2;
        y=gp.tileSize;
        i=0;
        while(i<gp.player.ammo){
            g2.drawImage(arrow_full,x,y,null);
            i++;
            x+=gp.tileSize/2;
        }

    }
    public void drawMessage(){
        int messageX=gp.tileSize,messageY=gp.tileSize*4;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 25F));
        for(int i=0;i<message.size();i++){
            if(message.get(i)!=null){
                g2.setColor(Color.white);
                g2.drawString(message.get(i),messageX-gp.tileSize/2,messageY+gp.tileSize*6);

                int counter=messageCounter.get(i)+1; // messageCounter++
                messageCounter.set(i,counter); // set the counter to the array
                messageY+=50;
                if(messageCounter.get(i)>180){
                    message.remove(i);
                    messageCounter.remove(i);

                }
            }
        }
    }
    public void drawTitleScreen(){
        g2.setColor(titleBackground);
        g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
        // TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text="Alexa's FairyTale";
        int x=getXForCenteredText(text);
        int y=gp.tileSize*3;

        // SHADOW
        g2.setColor(new Color(0,0,0,100));
        g2.drawString(text,x+3,y+2);

        // MAIN COLOR
        g2.setColor(salmonPink);
        g2.drawString(text,x,y);

        // ASUNA IMAGE
        x=gp.screenWidth/2-gp.tileSize/2;
        y+=gp.tileSize*2;
        g2.drawImage(gp.player.idle1,x,y,gp.tileSize,gp.tileSize,null);

        // MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
        text="New Game";
        x=getXForCenteredText(text);
        y+=gp.tileSize*2;
        g2.setColor(new Color(0,0,0,100));
        g2.drawString(text,x+3,y+2);
        g2.setColor(salmonPink);
        g2.drawString(text,x,y);
        if(commandNum==0){
            g2.setColor(new Color(0,0,0,100));
            g2.drawString(">",x-gp.tileSize/2+3,y+2);
            g2.setColor(salmonPink);
             g2.drawString(">",x-gp.tileSize/2,y);
        }
        text="Load Game";
        x=getXForCenteredText(text);
        y+=gp.tileSize;
        g2.setColor(new Color(0,0,0,100));
        g2.drawString(text,x+3,y+2);
        g2.setColor(salmonPink);
        g2.drawString(text,x,y);
        if(commandNum==1){
            g2.setColor(new Color(0,0,0,100));
            g2.drawString(">",x-gp.tileSize/2+3,y+2);
            g2.setColor(salmonPink);
            g2.drawString(">",x-gp.tileSize/2,y);
        }
        text="Quit";
        x=getXForCenteredText(text);
        y+=gp.tileSize;
        g2.setColor(new Color(0,0,0,100));
        g2.drawString(text,x+3,y+2);
        g2.setColor(salmonPink);
        g2.drawString(text,x,y);
        if(commandNum==2){
            g2.setColor(new Color(0,0,0,100));
            g2.drawString(">",x-gp.tileSize/2+3,y+2);
            g2.setColor(salmonPink);
            g2.drawString(">",x-gp.tileSize/2,y);
        }
    }
    public void drawDialogueScreen(){
        // WINDOW
        int x=gp.tileSize*2;
        int y=gp.tileSize/2;
        int width=gp.screenWidth-(gp.tileSize*4);
        int height=gp.tileSize*3;
        drawSubWindow(x,y,width,height);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD,30F));
        x+=gp.tileSize/2;
        y+=gp.tileSize/2+3;

        for(String line: currentDialogue.split("\n")){
            g2.drawString(line,x,y);
            y+=40;
        }


    }
    public void drawCharacterScreen(){
        // CREATE A FRAME
        final int frameX=gp.tileSize;
        final int frameY=gp.tileSize;
        final int frameWidth=gp.tileSize*5,frameHeight=gp.tileSize*10;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight);
        //TEXT
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,32F));
        int textX=frameX+20,textY=frameY+gp.tileSize;
        final int lineHeight=35;
        // NAMES
        g2.drawString("Level: ",textX,textY);textY+=lineHeight;
        g2.drawString("HP: ",textX,textY);textY+=lineHeight;
        g2.drawString("Arrows: ",textX,textY);textY+=lineHeight;
        g2.drawString("Attack: ",textX,textY);textY+=lineHeight;
        g2.drawString("Defense: ",textX,textY);textY+=lineHeight;
        g2.drawString("EXP: ",textX,textY);textY+=lineHeight;
        g2.drawString("Next level EXP : ",textX,textY);textY+=lineHeight+35;
        //g2.drawString("Coins: ",textX,textY);textY+=lineHeight+35;
        g2.drawString("Weapon: ",textX,textY);textY+=lineHeight+15;
        //g2.drawString("Shield: ",textX,textY);textY+=lineHeight;

        // VALUES
        int tailX=(frameX+frameWidth)-30;
        // RESET textY
        textY=frameY+gp.tileSize;
        String value;

        value=String.valueOf(gp.player.level);
        textX=getXForAlignedToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.life+"/"+gp.player.maxLife);
        textX=getXForAlignedToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.ammo +"/"+gp.player.maxAmmo);
        textX=getXForAlignedToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.attack);
        textX=getXForAlignedToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.defense);
        textX=getXForAlignedToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.exp);
        textX=getXForAlignedToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

        value=String.valueOf(gp.player.nextLevelExp);
        textX=getXForAlignedToRightText(value,tailX);
        g2.drawString(value,textX,textY);
        textY+=lineHeight;

       // value=String.valueOf(gp.player.coin);
        //textX=getXForAlignedToRightText(value,tailX);
        //g2.drawString(value,textX,textY);
        //textY+=lineHeight;

        g2.drawImage(gp.player.currentWeapon.fall,tailX-gp.tileSize,textY-13,null);
        textY+=gp.tileSize;
        //g2.drawImage(gp.player.currentShield.fall,textX-gp.tileSize,textY-13,null);



    }
    public void drawInventory(){
        // FRAME
        int frameX=gp.screenWidth/2+gp.tileSize,frameY=gp.tileSize,
                frameWidth=gp.tileSize*6,frameHeight=gp.tileSize*5;
        drawSubWindow(frameX,frameY,frameWidth,frameHeight );
        // SLOT
        final int slotXStart=frameX+20;
        final int slotYStart=frameY+20;
        int slotX=slotXStart,slotY=slotYStart;
        int slotSize=gp.tileSize+5;

        // DRAW PLAYER'S ITEMS
        for(int i=0;i<gp.player.inventory.size();i++){
            // EQUIP CURSOR
            if(gp.player.inventory.get(i)==gp.player.currentWeapon||
            gp.player.inventory.get(i)==gp.player.currentShield){
                g2.setColor(salmonPink);
                g2.fillRoundRect(slotX,slotY,gp.tileSize,gp.tileSize,10,10);
            }

            g2.drawImage(gp.player.inventory.get(i).fall,slotX,slotY,null);
            slotX+=slotSize;
            if(i==4||i==9||i==14){
                slotX=slotXStart;
                slotY+=slotSize;
            }
        }
        // CURSOR
        int cursorX=slotXStart+(slotSize*slotCol);
        int cursorY=slotYStart+(slotSize*slotRow);
        int cursorWidth=gp.tileSize;
        int cursorHeight=gp.tileSize;
        // DRAW CURSOR
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX,cursorY,cursorWidth,cursorHeight,10,10);

        // DESCRIPTION FRAME
        int dFrameX=frameX;
        int dFrameY=frameY+frameHeight;
        int dFrameWidth=frameWidth;
        int dFrameHeight=gp.tileSize*3;

        // DRAW DESCRIPTION TEXT
        int textX=dFrameX+20;
        int textY=dFrameY+gp.tileSize;
        g2.setFont(g2.getFont().deriveFont(28F));

        int itemIndex=getItemIndexOnSlot();
        if(itemIndex<gp.player.inventory.size()){
            drawSubWindow(dFrameX,dFrameY,dFrameWidth,dFrameHeight);
            for(String line:gp.player.inventory.get(itemIndex).description.split("\n")){
                g2.drawString(line, textX,textY);
                textY+=32;
            }
        }



    }
    public int getItemIndexOnSlot(){
        return slotCol+(slotRow*5);

    }
    public void drawSubWindow(int x,int y,int width,int height){
        Color c=new Color(0,0,0,150);
        g2.setColor(c);
        g2.fillRoundRect(x,y,width,height,35,35);
        c=new Color(255,255,255);
        g2.setStroke(new BasicStroke(5));
        g2.setColor(c);
        g2.drawRoundRect(x+5,y+5,width-10,height-10,25,25);

    }
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text="PAUSED";
        int x=getXForCenteredText(text);
        int y=gp.screenHeight/2;

        g2.drawString(text,x,y);

    }
   public int getXForCenteredText(String text){
        int length=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
        return gp.screenWidth/2-length/2;
   }
   public int getXForAlignedToRightText(String text,int tailX){
       int length=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
       return tailX-length;
   }

}
