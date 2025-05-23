package main;

import entity.NPC_Zanisoara;
import monster.MON_Boss;
import monster.MON_GreenSlime;
import monster.MON_Radir;
import monster.MON_Snake;
import object.*;
import tile_interactive.IT_BossDoor;
import tile_interactive.IT_DryTree;
import tile_interactive.IT_SwordDoor;
import tile_interactive.IT_Trunk;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        int i=0;

        gp.obj[i]=new OBJ_AsunaSword(gp);
        gp.obj[i].worldX=112*gp.tileSize;
        gp.obj[i].worldY=91*gp.tileSize;
        i++;

    }

    public void setNPC(){
        gp.npc[0]=new NPC_Zanisoara(gp);
        gp.npc[0].worldX=gp.tileSize*19;
        gp.npc[0].worldY=gp.tileSize*48;

    }

    public void setMonster(){
        int i=0;
        gp.monster[i]=new MON_GreenSlime(gp);
        gp.monster[i].worldX=gp.tileSize*16;
        gp.monster[i].worldY=gp.tileSize*48;
        i++;
        //////
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*15;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*16;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*17;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*18;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*19;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*20;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*21;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*22;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*23;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*24;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*25;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*26;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*27;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*28;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Snake(gp);
        gp.monster[i].worldX=gp.tileSize*29;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;

        ////////
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*108;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*107;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*105;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*104;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*106;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*107;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*100;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*102;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*101;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*105;
        gp.monster[i].worldY=gp.tileSize*91;
        i++;

        // BOSS
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*108;
        gp.monster[i].worldY=gp.tileSize*48;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*107;
        gp.monster[i].worldY=gp.tileSize*48;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*105;
        gp.monster[i].worldY=gp.tileSize*48;
        i++;
        gp.monster[i]=new MON_Radir(gp);
        gp.monster[i].worldX=gp.tileSize*109;
        gp.monster[i].worldY=gp.tileSize*48;
        i++;

        gp.monster[i]=new MON_Boss(gp);
        gp.monster[i].worldX=gp.tileSize*113;
        gp.monster[i].worldY=gp.tileSize*48;
        i++;



    }
    public void setInteractiveTile(){

        int i=0;
        // tree one
        gp.iTile[i]=new IT_DryTree(gp,33,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,33,35);
        i++;
        // tree two
        gp.iTile[i]=new IT_DryTree(gp,30,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,35);
        i++;

        // tree three
        gp.iTile[i]=new IT_DryTree(gp,36,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,36,35);
        i++;

        // tree 4
        gp.iTile[i]=new IT_DryTree(gp,41,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,41,35);
        i++;

        // tree 5
        gp.iTile[i]=new IT_DryTree(gp,39,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,39,35);
        i++;
        // tree 6
        gp.iTile[i]=new IT_DryTree(gp,49,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,49,35);
        i++;
        // tree 7
        gp.iTile[i]=new IT_DryTree(gp,48,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,48,35);
        i++;
        // tree 7
        gp.iTile[i]=new IT_DryTree(gp,32,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,32,35);
        i++;
        // tree 8
        gp.iTile[i]=new IT_DryTree(gp,51,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,51,35);
        i++;
        // tree 9
        gp.iTile[i]=new IT_DryTree(gp,53,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,53,35);
        i++;
        // tree 10
        gp.iTile[i]=new IT_DryTree(gp,56,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,56,35);
        i++;

        // tree 11
        gp.iTile[i]=new IT_DryTree(gp,57,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,57,35);
        i++;

        // tree 12
        gp.iTile[i]=new IT_DryTree(gp,59,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,59,35);
        i++;

        // tree 13
        gp.iTile[i]=new IT_DryTree(gp,62,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,62,35);
        i++;

        // tree 14
        gp.iTile[i]=new IT_DryTree(gp,30,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,30,35);
        i++;

        // tree 15
        gp.iTile[i]=new IT_DryTree(gp,27,49);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,48);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,47);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,46);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,45);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,44);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,43);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,42);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,41);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,40);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,39);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,38);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,37);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,36);
        i++;
        gp.iTile[i]=new IT_Trunk(gp,27,35);
        i++;

        gp.iTile[i]=new IT_BossDoor(gp,95,48);
        i++;
        gp.iTile[i]=new IT_SwordDoor(gp,110,91);
        i++;


    }




}
