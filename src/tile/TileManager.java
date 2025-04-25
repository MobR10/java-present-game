package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;


    public TileManager(GamePanel gp){
        this.gp=gp;
        tile=new Tile[81];
        mapTileNum=new int[gp.maxWorldCol][gp.maxWorldRow];

        getTileImage();
        loadMap("/map/map.txt");

    }

    public void getTileImage(){
        ////////////////////////
        setup(0,"normal_sky",false);
        setup(1,"normal_sky",false);
        setup(2,"normal_sky",false);
        setup(3,"normal_sky",false);
        setup(4,"normal_sky",false);
        setup(5,"normal_sky",false);
        setup(6,"normal_sky",false);
        setup(7,"normal_sky",false);
        setup(8,"normal_sky",false);
        setup(9,"normal_sky",false);
        ////////////////////////

        setup(10,"normal_sky",true);
        // TODO: SKY ZONE

        {      // NORMAL //
            setup(11,"normal_sky",false);
            setup(12,"normal_sky_withGrass_left",false);
            setup(13,"normal_sky_withGrass_right",false);
            setup(14,"normal_sky_withGrass_both",false);
        }
        {      // SWITCH //
            setup(15,"switch_sky",false);
        }
        {      // BAD //
            setup(16,"bad_sky",false);
            setup(17,"bad_sky_withGrass_left",false);
            setup(18,"bad_sky_withGrass_right",false);
        }
        //  TODO: GRASS ZONE
        {     // NORMAL //
            // 1
            setup(19,"normal_grass1",true);
            setup(20,"normal_grass1_edge_left",true);
            setup(21,"normal_grass1_edge_right",true);
            setup(22,"normal_grass1&sky_edge_left",true);
            setup(23,"normal_grass1&sky_edge_right",true);
            // 2   // BAD GRASS&SKY TOO
            setup(24,"normal_grass2_edge_left",true);
            setup(25,"normal_grass2_edge_right",true);

            setup(26,"bad_grass&sky_edge_left",true);
            setup(27,"bad_grass&sky_edge_right",true);
            // 3
            setup(28,"normal_grass3_edge_left",true);
            setup(29,"normal_grass3_edge_right",true);
            setup(30,"normal_grass3_noBottomEdge_left",true);
            setup(31,"normal_grass3_noBottomEdge_right",true);
        }
        {       // SWITCH NORMAL - BAD //
            setup(32,"switch_grass1",true);

        }
        {       // BAD //
            setup(33,"bad_grass",true);
            setup(34,"bad_grass_edge_left",true);
            setup(35,"bad_grass_edge_right",true);

        }
        {       // SWITCH BAD - CASTLE //
            setup(36,"badSwitch_grass_topLess",true);
            setup(37,"badSwitch_grass_withTop",true);
        }
        // TODO: DIRT ZONE
        {       // NORMAL //
            setup(38,"normal_dirt1",true);
            setup(39,"normal_dirt1_withGrass_left",true);
            setup(40,"normal_dirt1_withGrass_right",true);
            setup(41,"normal_dirt2",true);
            setup(42,"normal_dirt2_withGrass_left",true);
            setup(43,"normal_dirt2_withGrass_right",true);
            setup(44,"normal_dirt2_bottom_edge_left",true);
            setup(45,"normal_dirt2_bottom_edge_right",true);
            setup(46,"normal_dirt3",true);
            setup(47,"normal_dirt3_withGrass_left",true);
            setup(48,"normal_dirt3_withGrass_right",true);
            setup(49,"normal_dirt3_bottom_edge_left",true);
            setup(50,"normal_dirt3_bottom_edge_right",true);

        }
        {       // SWITCH NORMAL - BAD //
            setup(51,"switch_dirt1",true);
            setup(52,"switch_dirt2",true);
            setup(53,"switch_dirt3",true);
        }
        {       // BAD //
            setup(54,"bad_dirt",true);
            setup(55,"bad_dirt_withGrass_left",true);
            setup(56,"bad_dirt_withGrass_right",true);
        }
        {       // SWITCH BAD- CASTLE //
            setup(57,"badSwitch_dirt",true);
        }
        // TODO: CASTLE ZONE
        {
            setup(58,"castle_wall",true);
            setup(59,"castle_wall_shadow",true);
            setup(60,"castle_inside_walkway",true);
            setup(61,"castle_outside_walkway",true);
            setup(62,"castle_lowPillar_left",false);
            setup(63,"castle_lowPillar_right",false);
        }
        // TODO: COBBLESTONE
        {
            setup(64,"cobblestone",true);
            setup(65,"cobblestone_dirt",true);
            setup(66,"background_down",false);
            // bad grass&sky
            setup(67,"bad_sky_withGrassBlue_left",false);
            setup(68,"bad_sky_withGrassBlue_right",false);

            setup(69,"normal_sky_withGrassBlue_left",false);
            setup(70,"normal_sky_withGrassBlue_right",false);

            // BAD DIRT BOTTOM EDGE
            setup(71,"bad_dirt_bottom_edge_left",true);
            setup(72,"bad_dirt_bottom_edge_right",true);

            // CASTLE WALL NO COLLISION
            setup(73,"castle_wall",false);

            setup(74,"bad_dirt_bottom_edge_right",false);

            // BIG TREE
            setup(75,"zanaTree",true);
            setup(76,"leaves",false);

            setup(77,"castle_wall_shadow",false);

            setup(78,"normal_cloud1",false);
            setup(79,"normal_cloud2",false);



        }









    }

    public void setup(int index,String imageName,boolean collision){
        UtilityTool uTool=new UtilityTool();
        try{
            tile[index]=new Tile();
            tile[index].image=ImageIO.read(getClass().getResourceAsStream("./src/res/tiles/tile_"+imageName+".png"));
            tile[index].image=uTool.scaleImage(tile[index].image, gp.tileSize,gp.tileSize);
            tile[index].collision=collision;
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void loadMap(String filePath){
        try{
            InputStream is=getClass().getResourceAsStream(filePath);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row=0;
            while(col < gp.maxWorldCol&& row< gp.maxWorldRow){
                String line=br.readLine();
                while(col<gp.maxWorldCol){
                    String[] numbers =line.split(" ");
                    int num=Integer.parseInt(numbers[col]);
                    mapTileNum[col][row]=num;
                    col++;
                }
                if(col==gp.maxWorldCol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }catch (Exception e){}

    }

    public void draw(Graphics2D g2){
        // g2.drawImage(tile[0].image,0,0,gp.tileSize,gp.tileSize,null);
        //g2.drawImage(tile[1].image,48,0,gp.tileSize,gp.tileSize,null);
        //g2.drawImage(tile[2].image,96,0,gp.tileSize,gp.tileSize,null);
        int worldCol=0;
        int worldRow=0;

        while(worldCol<gp.maxWorldCol&&worldRow < gp.maxWorldRow){

            int tileNum=mapTileNum[worldCol][worldRow];

            int worldX=worldCol*gp.tileSize;
            int worldY=worldRow*gp.tileSize;
            int screenX=worldX-gp.player.worldX+gp.player.screenX;
            int screenY=worldY-gp.player.worldY+gp.player.screenY;

            /*
            // Stop moving the camera at the edge
            if(gp.player.screenX>gp.player.worldX){
                screenX=worldX;
            }
            if(gp.player.screenY>gp.player.worldY){
                screenY=worldY;
            }
            int rightOffset=gp.screenWidth-gp.player.screenX;
            if(rightOffset>gp.worldWidth-gp.player.worldX){
                screenX=gp.screenWidth-(gp.worldWidth-worldX);
            }
            int bottomOffset=gp.screenHeight-gp.player.screenY;
            if(bottomOffset>gp.worldHeight-gp.player.worldY){
                screenY=gp.screenHeight-gp.worldHeight-worldY;
            }
             */

            if(worldX+gp.tileSize>gp.player.worldX-gp.player.screenX&&
                    worldX - gp.tileSize<gp.player.worldX+gp.player.screenX&&
                    worldY + gp.tileSize>gp.player.worldY-gp.player.screenY&&
                    worldY - gp.tileSize<gp.player.worldY+gp.player.screenY){
                g2.drawImage(tile[tileNum].image,screenX,screenY,null);
            }/*else if(gp.player.screenX>gp.player.worldX||
                    gp.player.screenY> gp.player.worldY||
                    rightOffset>gp.worldWidth-gp.player.worldX||
                    bottomOffset>gp.worldHeight-gp.player.worldY){
                g2.drawImage(tile[tileNum].image,screenX,screenY,null);
            }
            */
            worldCol++;
            if(worldCol==gp.maxWorldCol){
                worldCol=0;
                worldRow++;

            }

        }
    }



}
