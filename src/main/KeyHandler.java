package main;

import netscape.javascript.JSObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.logging.MemoryHandler;


public class KeyHandler implements KeyListener {
    public boolean showDebugText=false,upPressed,downPressed,leftPressed
            ,rightPressed,spacePressed,f11Pressed,enterPressed,ePressed,cPressed;

    GamePanel gp;
    public KeyHandler(GamePanel gp){
        this.gp=gp;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if(code==KeyEvent.VK_F11){
            f11Pressed=true;
        }
        // TITLE STATE
        if(gp.gameState==gp.titleState){
            titleState(code);
        }
        // PLAY STATE
        else if(gp.gameState==gp.playState){
            playState(code);
            if(code== KeyEvent.VK_T){
                showDebugText=!showDebugText;
            }
            if(code==KeyEvent.VK_R){
                gp.aSetter.setObject();
                gp.aSetter.setNPC();
                gp.aSetter.setMonster();
                gp.aSetter.setInteractiveTile();
                gp.tileManager.loadMap("/map/map.txt");
                System.out.println("RESET MAP");
            }
        }
        // PAUSE STATE
        else if(gp.gameState==gp.pauseState){
            pauseState(code);
        }
        // DIALOGUE STATE
        else if(gp.gameState==gp.dialogueState){
           dialogueState(code);
        }
        // CHARACTER STATE
        else if(gp.gameState==gp.characterState){
            characterState(code);
        }

    }
    public void titleState(int code){
            if(code==KeyEvent.VK_W){
                gp.ui.commandNum--;
                if(gp.ui.commandNum<0){
                    gp.ui.commandNum=2;
                }
            }
            if(code==KeyEvent.VK_S){
                gp.ui.commandNum++;
                if(gp.ui.commandNum>2){
                    gp.ui.commandNum=0;
                }
            }
            if(code==KeyEvent.VK_ENTER){
                if(gp.ui.commandNum==0){
                    gp.gameState=gp.playState;
                }
                if(gp.ui.commandNum==1){

                }
                if(gp.ui.commandNum==2){
                    System.exit(0);
                }
            }
    }
    public void playState(int code){

        if(!cPressed){
            if(code==KeyEvent.VK_SPACE&&!gp.player.jumping){
                gp.player.dy=-11;
                gp.player.jumping=true;
            }
            if(code==KeyEvent.VK_W){
                upPressed=true;
            }
            if(code==KeyEvent.VK_S){
                downPressed=true;
            }
            if(code==KeyEvent.VK_A){
                leftPressed=true;
            }
            if(code==KeyEvent.VK_D){
                rightPressed=true;
            }
            if(code==KeyEvent.VK_C){
                //gp.gameState=gp.characterState;
                cPressed= true;
            }
        }else{
            if(code==KeyEvent.VK_E){
                gp.player.selectItem();
            }
            if(code==KeyEvent.VK_C){
                //gp.gameState=gp.characterState;
                cPressed= false;
            }
            if(code==KeyEvent.VK_W){
                if(gp.ui.slotRow!=0){
                    gp.ui.slotRow--;
                }
                gp.playSoundEffect(9);
            }
            if(code==KeyEvent.VK_S){
                if(gp.ui.slotRow!=3){
                    gp.ui.slotRow++;
                }
                gp.playSoundEffect(9);
            }
            if(code==KeyEvent.VK_A){
                if(gp.ui.slotCol!=0){
                    gp.ui.slotCol--;
                }
                gp.playSoundEffect(9);
            }
            if(code==KeyEvent.VK_D){
                if(gp.ui.slotCol!=4){
                    gp.ui.slotCol++;
                }
                gp.playSoundEffect(9);
            }

        }

        if(code==KeyEvent.VK_ESCAPE){
            gp.gameState=gp.pauseState;
        }
        if(code==KeyEvent.VK_E){
            ePressed=true;
        }

    }
    public void pauseState(int code){
        if(code==KeyEvent.VK_ESCAPE){
            gp.gameState=gp.playState;
        }
    }
    public void dialogueState(int code){
        if(code==KeyEvent.VK_ESCAPE){
            gp.gameState=gp.playState;
        }
    }
    public void characterState(int code){
        if(code==KeyEvent.VK_C){
            gp.gameState=gp.playState;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code=e.getKeyCode();
       // if(code==KeyEvent.VK_E){
       //     ePressed=false;
       // }

        if(code==KeyEvent.VK_W){
            upPressed=false;
        }
        if(code==KeyEvent.VK_S){
            downPressed=false;

        }
        if(code==KeyEvent.VK_A){
            leftPressed=false;

        }
        if(code==KeyEvent.VK_D){
            rightPressed=false;

        }

    }
}
