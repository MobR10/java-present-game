package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {
    Clip clip;
    URL[] soundURL=new URL[30];

    public Sound(){
        soundURL[0]=getClass().getResource("/sound/SurprizaMusic1.wav");
        soundURL[14]=getClass().getResource("/sound/birds (2).wav");
        //soundURL[0]=getClass().getResource("/sound/BlueBoyAdventure.wav");
        soundURL[1]=getClass().getResource("/sound/coin.wav");
        soundURL[2]=getClass().getResource("/sound/powerup.wav");
        soundURL[3]=getClass().getResource("/sound/unlock.wav");
        soundURL[4]=getClass().getResource("/sound/fanfare.wav");
        soundURL[5]=getClass().getResource("/sound/damageSlime.wav");
        soundURL[6]=getClass().getResource("/sound/receivedamage.wav");
        soundURL[7]=getClass().getResource("/sound/asunasword.wav");
        soundURL[8]=getClass().getResource("/sound/levelup.wav");
        soundURL[9]=getClass().getResource("/sound/cursor.wav");
        soundURL[10]=getClass().getResource("/sound/arrowshoot1.wav");
        soundURL[11]=getClass().getResource("/sound/cuttree.wav");
        soundURL[12]=getClass().getResource("/sound/pickupcustom.wav");
        soundURL[13]=getClass().getResource("/sound/cuttree.wav");
    }
    public void setFile(int i){
        try{
            AudioInputStream ais= AudioSystem.getAudioInputStream(soundURL[i]);
            clip=AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e) {}

    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }

}
