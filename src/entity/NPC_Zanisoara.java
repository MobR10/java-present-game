package entity;

import main.GamePanel;

import java.util.Random;

public class NPC_Zanisoara extends Entity{

    public NPC_Zanisoara(GamePanel gp){
        super(gp);
        speed=1;

        getImage();
        direction="right";
        setDialogue();
    }

    public void getImage() {
        jump = setup("/npc/zanisoara",gp.tileSize,gp.tileSize);
        fall = setup("/npc/zanisoara",gp.tileSize,gp.tileSize);
        idle1 = setup("/npc/zanisoara",gp.tileSize,gp.tileSize);
        left1 = setup("/npc/zanisoara",gp.tileSize,gp.tileSize);
        left2 = setup("/npc/zanisoara",gp.tileSize,gp.tileSize);
        right1 = setup("/npc/zanisoara",gp.tileSize,gp.tileSize);
        right2 = setup("/npc/zanisoara",gp.tileSize,gp.tileSize);
    }
    public void setDialogue(){
        dialogue[0]="Hey! Esti luptatoarea legendara!";
        dialogue[1]="Eu sunt personajul alter-ego, " +
                "iti voi comunica voia naratorului.\n";
        dialogue[2]= "Acest joculet este menit de a-l primi cadou de ziua ta, Alexa!";
        dialogue[3]="Ugh... Ce-a fost asta, ce s-a intamplat? Vai, nu am timp\npentru asta! Lordul Vidului ne ameninta casa!";
        dialogue[4]="Trebuie sa ne ajuti, viata intregului Copac\nsi a zanelor este in pericol!";
        dialogue[5]="Iti comunic voia naratorului:\nControale:\nAtac cu sabia (M1), cu arcul(M2). Daca sari si ataci dai\nputin mai mult DMG. Poti testa pe slime-ul din spate!";
        dialogue[6]="Apasa C pentru a deschide inventarul.\nApasa WASD pentru a misca cursorul in inventar.\nApasa E pentru a selecta item-ul! GOOD LUCK!";
        dialogue[7]="Ugh... De ce ma simt asa ciudat...\nUnde am ramas? Ah!";
        dialogue[8]="Repede, trebuie sa te misti!\nNu stim cat timp ne-a mai ramas! *Last Reply*";

    }
   public void setAction(){
/*
        Random random=new Random();

        actionLockCounter++;
        if(actionLockCounter==120){
            int i=random.nextInt(100)+1; // pick up a number from 1 to 100
            if(i<=25){
                direction="left";
            }
            if(i>25&&i<=50){
                direction="right";
            }
            if(i>50){
                direction="idle";
            }
            actionLockCounter=0;
        }

 */

    }
    public void update(){

    }
    public void speak(){
        // Do this character's specific stuff
        if(dialogue[dialogueIndex]==null){
            dialogueIndex=0;
        }
        gp.ui.currentDialogue=dialogue[dialogueIndex];
        dialogueIndex++;
    }

}
