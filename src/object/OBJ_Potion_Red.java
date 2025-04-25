package object;

import entity.Entity;
import main.GamePanel;

public class OBJ_Potion_Red extends Entity {

    public OBJ_Potion_Red(GamePanel gp) {
        super(gp);

        type=type_consumable;
        name="Potiunea de Heal";
        value=5;
        fall=setup("/objects/potion_red",gp.tileSize,gp.tileSize);
        description="["+name+"]\nPrimesti "+value+" HP.";

    }
    public void use(Entity entity){
        gp.gameState=gp.dialogueState;
        gp.ui.currentDialogue="Ai baut "+name+"!\n"+
                "Ti-ai refacut "+value+" HP!";
        entity.life+=value;
        gp.playSoundEffect(2);

    }
}
