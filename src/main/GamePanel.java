package main;

import entity.Entity;
import entity.Player;
import tile.TileManager;
import tile_interactive.InteractiveTile;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static main.Main.device;

public class GamePanel extends JPanel implements Runnable{
    final int originalTileSize=16; // 16x16 tile
    public final int scale=4;
    public final int tileSize=originalTileSize*scale; // 48*48 tile
    public  int maxScreenCol=16;
    public  int maxScreenRow=12;
    public  int screenWidth= tileSize * maxScreenCol;  // 768 pixels
    public  int screenHeight=tileSize * maxScreenRow;  // 576 pixels
    JFrame window;

    // FULLSCREEN COUNTER
    int fCount=0;
    // MAP
    public final int maxWorldCol=130;
    public final int maxWorldRow=100;
    public final int worldWidth=tileSize*maxWorldCol;
    public final int worldHeight=tileSize*maxWorldRow;
    // FPS
    int FPS=70;

    // SYSTEM
    TileManager tileManager=new TileManager(this);
    public KeyHandler keyH=new KeyHandler(this);
    public Sound birds=new Sound();
    Sound music=new Sound();
    Sound se=new Sound();
    public MouseHandler mouseH=new MouseHandler(this);
    public CollisionChecker cChecker=new CollisionChecker(this,mouseH);
    public AssetSetter aSetter=new AssetSetter(this);
    public UI ui=new UI(this);
    public EventHandler eHandler=new EventHandler(this);
    Thread gameThread;


    // PLAYER & OBJECT
    public Player player =new Player(this,keyH);
    public Entity[] obj=new Entity[20];
    public Entity[] npc = new Entity[10];
    public Entity[] monster=new Entity[35];
    public InteractiveTile[] iTile=new InteractiveTile[250];
    public ArrayList<Entity>projectileList=new ArrayList<>();
    public ArrayList<Entity>particleList=new ArrayList<>();
    ArrayList<Entity>entityList=new ArrayList<>();

    // GAME STATE
    public int gameState;
    public int descriptionCounter;
    public final int playState=1,pauseState=2,dialogueState=3,titleState=0,characterState=4;


    public GamePanel(JFrame window)  {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.addMouseListener(mouseH);
        this.setFocusable(true);
        this.window=window;

    }

    public void setupGame(){
        aSetter.setObject();
        aSetter.setNPC();
        aSetter.setMonster();
        aSetter.setInteractiveTile();

        playMusic(0);
        setBirds(14);
        gameState=titleState;
    }
    public void startGameThread(){
        gameThread=new Thread(this);
        gameThread.start();
    }
    @Override
    public void run(){
        double  drawInterval=1000000000/FPS;
        double delta=0;
        long lastTime=System.nanoTime();
        long currentTime;
        long timer=0;
        int drawCount=0;

        while(gameThread!=null){
            currentTime=System.nanoTime();
            delta+=(currentTime-lastTime)/drawInterval;

            timer+=(currentTime-lastTime);

            lastTime=currentTime;

            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer>=1000000000){
                //System.out.println("FPS: "+drawCount);
                drawCount=0;
                timer=0;
            }

        }


    }
    public void update(){

        if(gameState==playState){
            // PLAYER
            player.update();
            // NPC
            for(int i=0;i<npc.length;i++){
                if(npc[i]!=null){
                    npc[i].update();
                }
            }
            for(int i=0;i<monster.length;i++){
                if(monster[i]!=null){
                    if(monster[i].alive){
                        monster[i].update();
                    }
                    if(!monster[i].alive){
                        monster[i].checkDrop();
                        monster[i]=null;
                    }
                }
            }
            for(int i=0;i<projectileList.size();i++){
                if(projectileList.get(i)!=null){
                    if(projectileList.get(i).alive){
                        projectileList.get(i).update();
                    }
                    if(!projectileList.get(i).alive){
                        projectileList.remove(i);
                    }
                }
            }
            for(int i=0;i<particleList.size();i++){
                if(particleList.get(i)!=null){
                    if(particleList.get(i).alive){
                        particleList.get(i).update();
                    }
                    if(!particleList.get(i).alive){
                        particleList.remove(i);
                    }
                }
            }
            for(int i=0;i<iTile.length;i++){
                if(iTile[i]!=null){
                    iTile[i].update();
                }
            }
            music.play();
            music.loop();
            //playBirds();
        }
        if(gameState==pauseState){
            music.stop();
            birds.stop();
            //nothing
        }

        if(keyH.f11Pressed){
            if(fCount%2==0){
                device.setFullScreenWindow(window);
                screenWidth=window.getWidth();
                screenHeight=window.getHeight();

                player.screenX=screenWidth/2 - tileSize/2;
                player.screenY=screenHeight/2 - tileSize/2;


                // window.setExtendedState(Frame.MAXIMIZED_BOTH);
                window.pack();
                setPreferredSize(new Dimension(screenWidth,screenHeight));
                window.pack();
                keyH.f11Pressed=false;
                fCount++;

            }else{
                device.setFullScreenWindow(null);
                maxScreenCol=16;
                maxScreenRow=12;
                screenWidth= tileSize * maxScreenCol;
                screenHeight=tileSize * maxScreenRow;
                player.screenX=screenWidth/2 - tileSize/2;
                player.screenY=screenHeight/2 - tileSize/2;
                setPreferredSize(new Dimension(screenWidth,screenHeight));
                window.pack();
                keyH.f11Pressed=false;
                fCount++;
            }
        }
    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2=(Graphics2D)g;

        //g2.setColor(Color.white);
        //g2.drawRect(x,y,tileSize,tileSize);

        //g2.setColor(Color.red);
        //g2.drawRoundRect(x,y,tileSize,tileSize,tileSize,tileSize);
        //g2.fillRoundRect(x,y,tileSize,tileSize,tileSize,tileSize);
        //g2.setColor(Color.pink);
        //g2.drawRect(0,11*48,screenWidth,tileSize);
        //g2.fillRect(0,11*48,screenWidth,tileSize);

       // TITLE SCREEN
        if(gameState==titleState){

            ui.draw(g2);
        }
        // OTHERS
        else {
            // TILES

            tileManager.draw(g2);

            for(int i=0;i<iTile.length;i++){
                if(iTile[i]!=null){
                    iTile[i].draw(g2);
                }
            }

            // ADD ENTITIES TO THE LIST
            for(int i=0;i<obj.length;i++){
                if(obj[i]!=null){
                    entityList.add(obj[i]);
                }
            }
            for(int i=0;i<npc.length;i++){
                if(npc[i]!=null){
                    entityList.add(npc[i]);
                }
            }
            for(int i=0;i<monster.length;i++){
                if(monster[i]!=null){
                    entityList.add(monster[i]);
                }
            }
            for(int i=0;i<projectileList.size();i++){
                if(projectileList.get(i)!=null){
                    entityList.add(projectileList.get(i));
                }
            }
            entityList.add(player);
            for(int i=0;i<particleList.size();i++){
                if(particleList.get(i)!=null){
                    entityList.add(particleList.get(i));
                }
            }

            // SORT
            //entityList.sort(new Comparator<Entity>() {
            //    @Override
            //    public int compare(Entity e1, Entity e2) {
            //        int result = Integer.compare(e1.worldY, e2.worldY);
             //       return e1.worldY-e2.worldY;
            //    }
           // });

            // DRAW ENTITIES
            for(int i=0;i<entityList.size();i++){
                entityList.get(i).draw(g2);
            }
            // EMPTY ENTITY LIST
           // for(int i=0;i<entityList.size();i++){
           //    entityList.remove(i);
            //}
            entityList.clear();

            // PLAYER
            //player.draw(g2);

            // UI
            ui.draw(g2);
            // DEBUG
            if(keyH.showDebugText){
                g2.setFont(new Font("Arial",Font.PLAIN,20));
                g2.setColor(Color.white);
                int x=10,y=400,lineHeight=20;
                g2.drawString("WorldX "+player.worldX,x,y); y+=lineHeight;
                g2.drawString("WorldY "+player.worldY,x,y); y+=lineHeight;
                g2.drawString("Col "+(player.worldX+player.collisionArea.x)/tileSize,x,y);
                y+=lineHeight;
                g2.drawString("Row "+(player.worldY+player.collisionArea.y)/tileSize,x,y);
                y+=lineHeight;

            }
        }


        g2.dispose();

    }
    public void playMusic(int i){
        music.setFile(i);
        music.play();
        music.loop();
    }
    public void setBirds(int j){
        birds.setFile(j);
    }
    public void playBirds(){
        birds.play();
        birds.loop();

    }
    public void stopMusic(){
        music.stop();
        birds.stop();
    }
    public void playSoundEffect(int i){
        se.setFile(i);
        se.play();
    }


}

