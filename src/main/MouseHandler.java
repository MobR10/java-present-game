package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    GamePanel gp;
    public boolean shotKeyPressed;
    public MouseHandler(GamePanel gp){
        this.gp=gp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
         int i=e.getX();

        if(i>gp.screenWidth/2){
            System.out.println("i higher");
        }else if(i<gp.screenWidth/2){
            System.out.println("i less");
        }
        if(gp.gameState==gp.playState&&!gp.keyH.cPressed){
            if(!gp.player.bottomCollision&&!gp.ui.isDrawingPressForAction&&!gp.player.attacking&&e.getButton()==MouseEvent.BUTTON1){
                gp.playSoundEffect(7);
                gp.player.attackDirection="fall";
                gp.player.attacking=true;
            }
            if(i>gp.screenWidth/2&&!gp.ui.isDrawingPressForAction&&!gp.player.attacking&&e.getButton()==MouseEvent.BUTTON1){
                gp.playSoundEffect(7);
                gp.player.attackDirection="right";
                gp.player.attacking=true;

            }
            if(i<gp.screenWidth/2&&!gp.ui.isDrawingPressForAction&&!gp.player.attacking&&e.getButton()==MouseEvent.BUTTON1){
                gp.playSoundEffect(7);
                gp.player.attackDirection="left";
                gp.player.attacking=true;
            }
            if(!gp.player.bottomCollision&&!gp.ui.isDrawingPressForAction&&!gp.player.attacking&&!shotKeyPressed&&e.getButton()==MouseEvent.BUTTON3){
                shotKeyPressed=true;
                gp.player.attackDirection="fall";

            }
            if(i>gp.screenWidth/2&&!gp.ui.isDrawingPressForAction&&!shotKeyPressed&&!gp.player.attacking&&e.getButton()==MouseEvent.BUTTON3){
                shotKeyPressed=true;
                gp.player.attackDirection="right";
            }
            if(i<gp.screenWidth/2&&!gp.ui.isDrawingPressForAction&&!shotKeyPressed&&!gp.player.attacking&&e.getButton()==MouseEvent.BUTTON3){
                shotKeyPressed=true;
                gp.player.attackDirection="left";
            }



        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
       /* if(e.getButton()==MouseEvent.BUTTON3){
            shotKeyPressed=false;
            System.out.println(shotKeyPressed);
        }

        */
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
