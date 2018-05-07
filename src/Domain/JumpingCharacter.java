package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {
     
    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for (int i = 0; i < 3; i++) {
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping"+i+".png")));    
        }
        
    }

    @Override
    public void run() {
        int i=0;
        int y1=370;
        int y2=270;
        int aux=270;
        ArrayList<Image> sprite = super.getSprite();
        
        while (true) {
            try {
                for(int x=370; x>=270; x=x-10){
                    if(x>270){
                        super.setImage(sprite.get(0));
                        Thread.sleep(100);
                        this.setY(x);
                        
                    }else{
                        super.setImage(sprite.get(2));
                        Thread.sleep(100);
                        this.setY(x);
                    }
                }
                for(int y=270; y<=370; y=y+10){
                    if(y<370){
                        super.setImage(sprite.get(1));
                        Thread.sleep(100);
                        this.setY(y);
                        
                    }else{
                        super.setImage(sprite.get(2));
                        Thread.sleep(100);
                        this.setY(y);
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(JumpingCharacter.class.getName()).log(Level.SEVERE, null, ex);
            }
   
        }
    }
}
